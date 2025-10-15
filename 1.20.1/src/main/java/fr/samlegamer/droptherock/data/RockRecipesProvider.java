package fr.samlegamer.droptherock.data;

//import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RockRecipesProvider extends RecipeProvider
{
    public RockRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn.getPackOutput());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Rock> rocks = new ArrayList<>();
        //rocks.addAll(DTRRocks.quark());
        rocks.addAll(DTRRocks.byg());
        rocks.addAll(DTRRocks.bop());

        for (Rock rock : rocks) {
            String[] partsLoose = rock.getLooseRock().split(":");
            String modidLoose = partsLoose[0];
            String nameLoose  = partsLoose[1];
            String[] partsCobble = rock.cobblestone().split(":");
            String modidCobble = partsCobble[0];
            String nameCobble  = partsCobble[1];
            String[] partsRock = rock.rock().split(":");
            String modidRock = partsRock[0];
            String nameRock  = partsRock[1];

            //DropTheRock.LOGGER.info("rocks {} {} {}", nameLoose, modidCobble, nameCobble);

            Block blockRock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(modidRock, nameRock));
            Block blockLoose = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameLoose));
            Block blockCobble = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()));
            Block blockCobbleSlab = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_slab"));
            Block blockCobbleStairs = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_stairs"));
            Block blockCobbleWall = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_wall"));

            try {
                if(blockLoose != null && blockCobble != null && !blockCobble.toString().contains(DropTheRock.MODID))
                {
                    ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modidRock))
                            .addRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockCobble).group("rock")
                                    .unlockedBy("has_loose_rock", has(blockLoose))
                                    .define('#', blockLoose).pattern("##").pattern("##")::save).generateAdvancement()
                            .build(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, modidRock+"_"+nameCobble));
                }
                else if(blockRock != null && blockLoose != null && blockCobble != null && blockCobbleSlab != null &&
                blockCobbleStairs != null && blockCobbleWall != null && blockCobble.toString().contains(DropTheRock.MODID))
                {
                    //DropTheRock.LOGGER.info("In try if : " + blockLoose.getRegistryName().toString() + " " + blockCobble.getRegistryName().toString());
                    ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modidRock))
                            .addRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockCobble).group("rock")
                                    .unlockedBy("has_loose_rock", has(blockLoose))
                                    .define('#', blockLoose).pattern("##").pattern("##")::save).generateAdvancement()
                            .build(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble));

//                    ConditionalRecipe.builder()
//                            .addCondition(new ModLoadedCondition(modidRock))
//                            .addRecipe(c -> CookingRecipeBuilder.smelting(Ingredient.of(blockCobble), blockRock.asItem(), 0.1F, 200)
//                                    .unlockedBy("has_cobblestone", has(blockCobble))
//                                    .save(c))
//                            .generateAdvancement()
//                            .build(consumer, new ResourceLocation(DropTheRock.MODID, modidRock+"_"+nameRock + "_furnace"));

                    //Slab Recipe
                    ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modidRock))
                            .addRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockCobbleSlab, 6).group("slab")
                                    .unlockedBy("has_cobblestone", has(blockCobble))
                                    .define('#', blockCobble).pattern("###")::save).generateAdvancement()
                            .build(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_slab"));

                    //Stairs Recipe
                    ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modidRock))
                            .addRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockCobbleStairs, 4).group("stair")
                                    .unlockedBy("has_cobblestone", has(blockCobble))
                                    .define('#', blockCobble)
                                    .pattern("#  ").pattern("## ").pattern("###")
                                    ::save).generateAdvancement()
                            .build(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_stairs"));

                    //Wall Recipe
                    ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modidRock))
                            .addRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockCobbleWall, 6).group("wall")
                                    .unlockedBy("has_cobblestone", has(blockCobble))
                                    .define('#', blockCobble)
                                    .pattern("###").pattern("###")::save).generateAdvancement()
                            .build(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_wall"));

                    //Stone cutter recipes
                    SingleItemRecipeBuilder.stonecutting(Ingredient.of(blockCobble), RecipeCategory.BUILDING_BLOCKS, blockCobbleSlab, 2)
                            .unlockedBy("has_stone", has(blockCobble))
                            .save(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_slab_stonecutting"));


                    SingleItemRecipeBuilder.stonecutting(Ingredient.of(blockCobble), RecipeCategory.BUILDING_BLOCKS, blockCobbleStairs)
                            .unlockedBy("has_stone", has(blockCobble))
                            .save(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_stairs_stonecutting"));

                    SingleItemRecipeBuilder.stonecutting(Ingredient.of(blockCobble), RecipeCategory.BUILDING_BLOCKS, blockCobbleWall).unlockedBy("has_stone", has(blockCobble))
                            .save(consumer, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, nameCobble + "_wall_stonecutting"));
                }
            } catch (Exception e) {
                DropTheRock.LOGGER.error(e);
            }

            // Modded Knife, Saw and Mattock
//            knife(consumer, "iceandfire", DTRItemRegistry.IAF_COPPER_KNIFE.get(), IafItemRegistry.COPPER_INGOT);
//            knife(consumer, "iceandfire", DTRItemRegistry.IAF_SILVER_KNIFE.get(), IafItemRegistry.SILVER_INGOT);
//            knife(consumer, "iceandfire", DTRItemRegistry.IAF_DRAGONBONE_KNIFE.get(), IafItemRegistry.DRAGON_BONE);
//
//            saw(consumer, "iceandfire", DTRItemRegistry.IAF_COPPER_SAW.get(), IafItemRegistry.COPPER_INGOT);
//            saw(consumer, "iceandfire", DTRItemRegistry.IAF_SILVER_SAW.get(), IafItemRegistry.SILVER_INGOT);
//            saw(consumer, "iceandfire", DTRItemRegistry.IAF_DRAGONBONE_SAW.get(), IafItemRegistry.DRAGON_BONE);
//
//            mattock(consumer, "iceandfire", DTRItemRegistry.IAF_COPPER_MATTOCK.get(), IafItemRegistry.COPPER_INGOT);
//            mattock(consumer, "iceandfire", DTRItemRegistry.IAF_SILVER_MATTOCK.get(), IafItemRegistry.SILVER_INGOT);
//            mattock(consumer, "iceandfire", DTRItemRegistry.IAF_DRAGONBONE_MATTOCK.get(), IafItemRegistry.DRAGON_BONE);
        }
    }
}
