package fr.samlegamer.droptherock.mapping;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

@Mod.EventBusSubscriber(modid = DropTheRock.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingnoFix
{
    @SubscribeEvent
    public static void missingnoBlock(MissingMappingsEvent event)
    {
        convertDataBlockAndItem(event, "deepslate_loose_rock", "vanilla_deepslate_loose_rock");
        convertDataBlockAndItem(event, "jasper_loose_rock", "quark_jasper_loose_rock");
        convertDataBlockAndItem(event, "limestone_loose_rock", "quark_limestone_loose_rock");
        convertDataBlockAndItem(event, "slate_loose_rock", "quark_shale_loose_rock");
        convertDataBlockAndItem(event, "black_sandstone_loose_rock", "byg_black_sandstone_loose_rock");
        convertDataBlockAndItem(event, "blue_sandstone_loose_rock", "byg_blue_sandstone_loose_rock");
        convertDataBlockAndItem(event, "cryptic_stone_loose_rock", "byg_cryptic_stone_loose_rock");
        convertDataBlockAndItem(event, "dacite_loose_rock", "byg_dacite_loose_rock");
        convertDataBlockAndItem(event, "ether_stone_loose_rock", "byg_ether_stone_loose_rock");
        convertDataBlockAndItem(event, "pink_sandstone_loose_rock", "byg_pink_sandstone_loose_rock");
        convertDataBlockAndItem(event, "purple_sandstone_loose_rock", "byg_purple_sandstone_loose_rock");
        convertDataBlockAndItem(event, "purple_stone_loose_rock", "byg_purpur_stone_loose_rock");
        convertDataBlockAndItem(event, "red_rock_loose_rock", "byg_red_rock_loose_rock");
        convertDataBlockAndItem(event, "rocky_stone_loose_rock", "byg_rocky_stone_loose_rock");
        convertDataBlockAndItem(event, "scoria_stone_loose_rock", "byg_scoria_stone_loose_rock");
        convertDataBlockAndItem(event, "soapstone_loose_rock", "byg_soapstone_loose_rock");
        convertDataBlockAndItem(event, "travertine_loose_rock", "byg_travertine_loose_rock");
        convertDataBlockAndItem(event, "white_sandstone_loose_rock", "byg_white_sandstone_loose_rock");
        convertDataBlockAndItem(event, "orange_sandstone_loose_rock", "biomesoplenty_orange_sandstone_loose_rock");
        convertDataBlockAndItem(event, "windswept_sandstone_loose_rock", "byg_windswept_sandstone_loose_rock");
    }

    public static void convertDataBlockAndItem(MissingMappingsEvent event, String oldId, String newId)
    {
        Block remappedBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, newId));
        Item remappedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DropTheRock.MODID, newId));

        if (remappedBlock != null)
        {
            for(MissingMappingsEvent.Mapping<Block> entry : event.getAllMappings(Registry.BLOCK.key()))
            {
                if(entry.getKey().toString().equals(DropTheRock.MODID + ":" + oldId))
                {
                    entry.remap(remappedBlock);
                }
            }
        }

        if (remappedItem != null)
        {
            for(MissingMappingsEvent.Mapping<Item> entry : event.getAllMappings(Registry.ITEM.key()))
            {
                if(entry.getKey().toString().equals(DropTheRock.MODID + ":" + oldId))
                {
                    entry.remap(remappedItem);
                }
            }
        }
    }
}
