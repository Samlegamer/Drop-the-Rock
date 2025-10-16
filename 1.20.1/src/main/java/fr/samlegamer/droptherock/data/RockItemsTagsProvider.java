package fr.samlegamer.droptherock.data;

import com.alcatrazescapee.notreepunching.NoTreePunching;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.item.DTRItemRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RockItemsTagsProvider extends ItemTagsProvider {
    public RockItemsTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, blockTags, DropTheRock.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.@NotNull Provider p_256380_) {

        DropTheRock.LOGGER.info("Adding tags for RockItemsTagsProvider");
        List<Rock> cobble = new ArrayList<>();
        cobble.addAll(DTRRocks.quark());
        cobble.addAll(DTRRocks.biomeswevegone());

        cobble.removeIf(filter -> !filter.cobblestone().contains("droptherock:"));

        Item[] cobblestones = new Item[cobble.size()];
        int i = 0;
        for(Rock rock : cobble)
        {
            Item block = ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(rock.cobblestone()));
            cobblestones[i] = block;
            i++;
        }

        DropTheRock.LOGGER.info("Vers les cobble");

        this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunching.MOD_ID, "cobblestone"))).add(cobblestones);

        this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunching.MOD_ID, "knives"))).add(DTRItemRegistry.IAF_COPPER_KNIFE.get(), DTRItemRegistry.IAF_SILVER_KNIFE.get(),
                DTRItemRegistry.IAF_DRAGONBONE_KNIFE.get());
        this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunching.MOD_ID, "mattocks")))
                .add(DTRItemRegistry.IAF_COPPER_MATTOCK.get(), DTRItemRegistry.IAF_SILVER_MATTOCK.get(),
                        DTRItemRegistry.IAF_DRAGONBONE_MATTOCK.get());
        this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath(NoTreePunching.MOD_ID, "saws")))
                .add(DTRItemRegistry.IAF_COPPER_SAW.get(), DTRItemRegistry.IAF_SILVER_SAW.get(),
                        DTRItemRegistry.IAF_DRAGONBONE_SAW.get());

        DropTheRock.LOGGER.info("finish");

    }
}