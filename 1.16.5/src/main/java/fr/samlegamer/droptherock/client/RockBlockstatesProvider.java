package fr.samlegamer.droptherock.client;

import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.block.DTRBlockRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RockBlockstatesProvider extends BlockStateProvider
{
    public RockBlockstatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DropTheRock.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        String exCobble = "droptherock_example_cobblestone";
        simpleBlock(DTRBlockRegistry.example_stone.get(), models().cubeAll("example_stone", new ResourceLocation(DropTheRock.MODID, "block/" + "example_stone")));
        simpleBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, exCobble)), models().cubeAll(exCobble, new ResourceLocation(DropTheRock.MODID, "block/" + exCobble)));
        slabBlock((SlabBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, exCobble + "_slab")), new ResourceLocation(DropTheRock.MODID, "block/" + exCobble), new ResourceLocation(DropTheRock.MODID, "block/" + exCobble));
        stairsBlock((StairsBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, exCobble + "_stairs")), new ResourceLocation(DropTheRock.MODID, "block/" + exCobble));
        wallBlock((WallBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, exCobble + "_wall")), new ResourceLocation(DropTheRock.MODID, "block/" + exCobble));
        models().withExistingParent(exCobble + "_wall_inventory", mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(DropTheRock.MODID, "block/" + exCobble));

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
        cobblestones.addAll(DTRRocks.byg());
        cobblestones.addAll(DTRRocks.bop());
        //cobblestones.addAll(DTRRocks.customRocks());

        cobblestones.removeIf(filter -> !filter.getCobblestone().contains("droptherock:"));

        for(Rock rock : cobblestones)
        {
            String modid = rock.getCobblestone().split(":")[0];
            String name = rock.getCobblestone().split(":")[1];

            //DropTheRock.LOGGER.info("Generating blockstate for {}:{}", modid, name);
            Block cobblestone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, name));
            SlabBlock cobblestone_slab = (SlabBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, name + "_slab"));
            StairsBlock cobblestone_stairs = (StairsBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, name + "_stairs"));
            WallBlock cobblestone_wall = (WallBlock) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, name + "_wall"));
            if (cobblestone != null && cobblestone_slab != null && cobblestone_stairs != null && cobblestone_wall != null && done.add(cobblestone)) {
                simpleBlock(cobblestone, models().cubeAll(name, new ResourceLocation(modid, "block/" + name)));
                slabBlock(cobblestone_slab, new ResourceLocation(modid, "block/" + name), new ResourceLocation(modid, "block/" + name));
                stairsBlock(cobblestone_stairs, new ResourceLocation(modid, "block/" + name));
                wallBlock(cobblestone_wall, new ResourceLocation(modid, "block/" + name));
                models().withExistingParent(name + "_wall_inventory", mcLoc("block/wall_inventory"))
                        .texture("wall", new ResourceLocation(modid, "block/" + name));

            }
        }

    }
}
