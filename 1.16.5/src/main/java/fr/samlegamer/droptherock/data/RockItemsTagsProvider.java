package fr.samlegamer.droptherock.data;

import com.alcatrazescapee.notreepunching.NoTreePunching;
import com.alcatrazescapee.notreepunching.common.ModTags;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.item.DTRItemRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RockItemsTagsProvider extends ItemTagsProvider {
    public RockItemsTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, new RockBlocksTagsProvider(dataGenerator, existingFileHelper), DropTheRock.MODID, existingFileHelper);
    }

    protected void addTags() {

        List<Rock> cobble = new ArrayList<>();
        cobble.addAll(DTRRocks.quark());
        cobble.addAll(DTRRocks.byg());

        cobble.removeIf(filter -> !filter.getCobblestone().contains("droptherock:"));

        Item[] cobblestones = new Item[cobble.size()];
        int i = 0;
        for(Rock rock : cobble)
        {
            Item block = ForgeRegistries.ITEMS.getValue(new ResourceLocation(rock.getCobblestone()));
            cobblestones[i] = block;
            i++;
        }
        this.tag(ItemTags.bind((new ResourceLocation(NoTreePunching.MOD_ID, "cobblestone")).toString())).add(cobblestones);

        this.tag(ModTags.Items.KNIVES).add(DTRItemRegistry.IAF_COPPER_KNIFE.get(), DTRItemRegistry.IAF_SILVER_KNIFE.get(),
                DTRItemRegistry.IAF_DRAGONBONE_KNIFE.get());
        this.tag(ItemTags.bind((new ResourceLocation(NoTreePunching.MOD_ID, "mattocks")).toString()))
                .add(DTRItemRegistry.IAF_COPPER_MATTOCK.get(), DTRItemRegistry.IAF_SILVER_MATTOCK.get(),
                        DTRItemRegistry.IAF_DRAGONBONE_MATTOCK.get());
        this.tag(ItemTags.bind((new ResourceLocation(NoTreePunching.MOD_ID, "saws")).toString()))
                .add(DTRItemRegistry.IAF_COPPER_SAW.get(), DTRItemRegistry.IAF_SILVER_SAW.get(),
                        DTRItemRegistry.IAF_DRAGONBONE_SAW.get());
    }
}