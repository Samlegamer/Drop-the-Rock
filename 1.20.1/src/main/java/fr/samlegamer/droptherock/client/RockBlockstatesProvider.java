package fr.samlegamer.droptherock.client;

import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.block.DTRBlockRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RockBlockstatesProvider extends BlockStateProvider
{
    public RockBlockstatesProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, DropTheRock.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        String exCobble = "droptherock_example_cobblestone";
        simpleBlock(DTRBlockRegistry.example_stone.get(), models().cubeAll("example_stone", ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + "example_stone")));
        simpleBlock(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, exCobble)), models().cubeAll(exCobble, ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble)));
        slabBlock((SlabBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, exCobble + "_slab")), ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble), ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble));
        stairsBlock((StairBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, exCobble + "_stairs")), ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble));
        wallBlock((WallBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, exCobble + "_wall")), ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble));
        models().withExistingParent(exCobble + "_wall_inventory", mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "block/" + exCobble));

//        List<Rock> rocks = new ArrayList<>();
//        rocks.addAll(DTRRocks.quark());
//        rocks.addAll(DTRRocks.byg());

        Set<Block> done = new HashSet<>();

//        for(Rock rock : rocks)
//        {
//            String modid = rock.getRock().split(":")[0];
//            String baseName = rock.getRock().split(":")[1];
//            String name = rock.getLooseRock().split(":")[1];
//
//            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, name));
//            if(block != null && done.add(block))
//            {
//                simpleBlock(block,
//                        models().withExistingParent(name, new ResourceLocation("notreepunching", "block/loose_rock"))
//                                .texture("all", new ResourceLocation(modid, "block/" + baseName)));
//            }
//        }

        List<Rock> cobblestones = new ArrayList<>();
        cobblestones.addAll(DTRRocks.quark());
        cobblestones.addAll(DTRRocks.biomeswevegone());
        cobblestones.addAll(DTRRocks.bop());
        //cobblestones.addAll(DTRRocks.customRocks());

        cobblestones.removeIf(filter -> !filter.cobblestone().contains("droptherock:"));

        for(Rock rock : cobblestones)
        {
            String modid = rock.cobblestone().split(":")[0];
            String name = rock.cobblestone().split(":")[1];

            //DropTheRock.LOGGER.info("Generating blockstate for {}:{}", modid, name);
            Block cobblestone = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, name));
            SlabBlock cobblestone_slab = (SlabBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, name + "_slab"));
            StairBlock cobblestone_stairs = (StairBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, name + "_stairs"));
            WallBlock cobblestone_wall = (WallBlock) ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, name + "_wall"));
            if (cobblestone != null && cobblestone_slab != null && cobblestone_stairs != null && cobblestone_wall != null && done.add(cobblestone)) {
                simpleBlock(cobblestone, models().cubeAll(name, ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)));
                slabBlock(cobblestone_slab, ResourceLocation.fromNamespaceAndPath(modid, "block/" + name), ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
                stairsBlock(cobblestone_stairs, ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
                wallBlock(cobblestone_wall, ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
                models().withExistingParent(name + "_wall_inventory", mcLoc("block/wall_inventory"))
                        .texture("wall", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));

            }
        }

    }
}
