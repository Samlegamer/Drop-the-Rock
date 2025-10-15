package fr.samlegamer.droptherock.data;

import com.alcatrazescapee.notreepunching.NoTreePunching;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RockBlocksTagsProvider extends BlockTagsProvider {

    public RockBlocksTagsProvider(DataGenerator dataGenerator, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator.getPackOutput(), lookupProvider, DropTheRock.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.@NotNull Provider p_256380_) {

        List<Rock> cobble = new ArrayList<>();
        cobble.addAll(DTRRocks.quark());
        cobble.addAll(DTRRocks.byg());
        cobble.addAll(DTRRocks.bop());

        cobble.removeIf(filter -> !filter.cobblestone().contains("droptherock:"));

        Block[] cobblestones = new Block[cobble.size()];
        Block[] cobblestones_slab = new Block[cobble.size()];
        Block[] cobblestones_stairs = new Block[cobble.size()];
        Block[] cobblestones_wall = new Block[cobble.size()];
        Block[] loose_rocks = new Block[cobble.size()];

        int i = 0;
        for(Rock rock : cobble)
        {
            Block cobblestone = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()));
            Block cobblestone_slab = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_slab"));
            Block cobblestone_stairs = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_stairs"));
            Block cobblestone_wall = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.cobblestone()+"_wall"));
            Block loose_rock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(rock.loose_rock()));
            cobblestones[i] = cobblestone;
            cobblestones_slab[i] = cobblestone_slab;
            cobblestones_stairs[i] = cobblestone_stairs;
            cobblestones_wall[i] = cobblestone_wall;
            loose_rocks[i] = loose_rock;
            i++;
        }
        this.tag(BlockTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunching.MOD_ID, "cobblestone"))).add(cobblestones);

        this.tag(BlockTags.SLABS).add(cobblestones_slab);
        this.tag(BlockTags.STAIRS).add(cobblestones_stairs);
        this.tag(BlockTags.WALLS).add(cobblestones_wall);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(loose_rocks).add(cobblestones).add(cobblestones_slab).add(cobblestones_stairs).add(cobblestones_wall);
    }
}