package fr.samlegamer.droptherock.data;

import com.alcatrazescapee.notreepunching.NoTreePunching;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RockBlocksTagsProvider extends BlockTagsProvider {
    public RockBlocksTagsProvider(DataGenerator p_i48256_1_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i48256_1_, DropTheRock.MODID, existingFileHelper);
    }

    protected void addTags() {

        List<Rock> cobble = new ArrayList<>();
        cobble.addAll(DTRRocks.quark());
        cobble.addAll(DTRRocks.byg());

        cobble.removeIf(filter -> !filter.getCobblestone().contains("droptherock:"));

        Block[] cobblestones = new Block[cobble.size()];
        Block[] cobblestones_slab = new Block[cobble.size()];
        Block[] cobblestones_stairs = new Block[cobble.size()];
        Block[] cobblestones_wall = new Block[cobble.size()];

        int i = 0;
        for(Rock rock : cobble)
        {
            Block cobblestone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(rock.getCobblestone()));
            Block cobblestone_slab = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(rock.getCobblestone()+"_slab"));
            Block cobblestone_stairs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(rock.getCobblestone()+"_stairs"));
            Block cobblestone_wall = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(rock.getCobblestone()+"_wall"));
            cobblestones[i] = cobblestone;
            cobblestones_slab[i] = cobblestone_slab;
            cobblestones_stairs[i] = cobblestone_stairs;
            cobblestones_wall[i] = cobblestone_wall;
            i++;
        }
        this.tag(BlockTags.bind((new ResourceLocation(NoTreePunching.MOD_ID, "cobblestone")).toString())).add(cobblestones);

        this.tag(BlockTags.SLABS).add(cobblestones_slab);
        this.tag(BlockTags.STAIRS).add(cobblestones_stairs);
        this.tag(BlockTags.WALLS).add(cobblestones_wall);
    }
}