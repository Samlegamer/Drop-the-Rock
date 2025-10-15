package fr.samlegamer.droptherock.mapping;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = DropTheRock.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MissingnoFix
{
    @SubscribeEvent
    public static void missingnoBlock(RegistryEvent.MissingMappings<Block> event)
    {
        convertDataBlock(event, "basalt_loose_rock", "quark_basalt_loose_rock");
        convertDataBlock(event, "deepslate_loose_rock", "vanilla_deepslate_loose_rock");
        convertDataBlock(event, "jasper_loose_rock", "quark_jasper_loose_rock");
        convertDataBlock(event, "limestone_loose_rock", "quark_limestone_loose_rock");
        convertDataBlock(event, "marble_loose_rock", "quark_marble_loose_rock");
        convertDataBlock(event, "slate_loose_rock", "quark_slate_loose_rock");
        convertDataBlock(event, "black_sandstone_loose_rock", "byg_black_sandstone_loose_rock");
        convertDataBlock(event, "blue_sandstone_loose_rock", "byg_blue_sandstone_loose_rock");
        convertDataBlock(event, "cryptic_stone_loose_rock", "byg_cryptic_stone_loose_rock");
        convertDataBlock(event, "dacite_loose_rock", "byg_dacite_loose_rock");
        convertDataBlock(event, "ether_stone_loose_rock", "byg_ether_stone_loose_rock");
        convertDataBlock(event, "pink_sandstone_loose_rock", "byg_pink_sandstone_loose_rock");
        convertDataBlock(event, "purple_sandstone_loose_rock", "byg_purple_sandstone_loose_rock");
        convertDataBlock(event, "purple_stone_loose_rock", "byg_purpur_stone_loose_rock");
        convertDataBlock(event, "red_rock_loose_rock", "byg_red_rock_loose_rock");
        convertDataBlock(event, "rocky_stone_loose_rock", "byg_rocky_stone_loose_rock");
        convertDataBlock(event, "scoria_stone_loose_rock", "byg_scoria_stone_loose_rock");
        convertDataBlock(event, "soapstone_loose_rock", "byg_soapstone_loose_rock");
        convertDataBlock(event, "travertine_loose_rock", "byg_travertine_loose_rock");
        convertDataBlock(event, "white_sandstone_loose_rock", "byg_white_sandstone_loose_rock");

        convertDataBlock(event, "orange_sandstone_loose_rock", "biomesoplenty_orange_sandstone_loose_rock");
    }

    @SubscribeEvent
    public static void missingnoItem(RegistryEvent.MissingMappings<Item> event)
    {
        convertDataItem(event, "basalt_loose_rock", "quark_basalt_loose_rock");
        convertDataItem(event, "deepslate_loose_rock", "vanilla_deepslate_loose_rock");
        convertDataItem(event, "jasper_loose_rock", "quark_jasper_loose_rock");
        convertDataItem(event, "limestone_loose_rock", "quark_limestone_loose_rock");
        convertDataItem(event, "marble_loose_rock", "quark_marble_loose_rock");
        convertDataItem(event, "slate_loose_rock", "quark_slate_loose_rock");
        convertDataItem(event, "black_sandstone_loose_rock", "byg_black_sandstone_loose_rock");
        convertDataItem(event, "blue_sandstone_loose_rock", "byg_blue_sandstone_loose_rock");
        convertDataItem(event, "cryptic_stone_loose_rock", "byg_cryptic_stone_loose_rock");
        convertDataItem(event, "dacite_loose_rock", "byg_dacite_loose_rock");
        convertDataItem(event, "ether_stone_loose_rock", "byg_ether_stone_loose_rock");
        convertDataItem(event, "pink_sandstone_loose_rock", "byg_pink_sandstone_loose_rock");
        convertDataItem(event, "purple_sandstone_loose_rock", "byg_purple_sandstone_loose_rock");
        convertDataItem(event, "purple_stone_loose_rock", "byg_purpur_stone_loose_rock");
        convertDataItem(event, "red_rock_loose_rock", "byg_red_rock_loose_rock");
        convertDataItem(event, "rocky_stone_loose_rock", "byg_rocky_stone_loose_rock");
        convertDataItem(event, "scoria_stone_loose_rock", "byg_scoria_stone_loose_rock");
        convertDataItem(event, "soapstone_loose_rock", "byg_soapstone_loose_rock");
        convertDataItem(event, "travertine_loose_rock", "byg_travertine_loose_rock");
        convertDataItem(event, "white_sandstone_loose_rock", "byg_white_sandstone_loose_rock");

        convertDataItem(event, "orange_sandstone_loose_rock", "biomesoplenty_orange_sandstone_loose_rock");
    }

    public static void convertDataBlock(RegistryEvent.MissingMappings<Block> event, String oldId, String newId)
    {
        for(RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings(DropTheRock.MODID))
        {
            if(mapping.key.toString().equals(DropTheRock.MODID + ":" + oldId))
            {
                mapping.remap(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DropTheRock.MODID, newId)));
            }
        }
    }

    public static void convertDataItem(RegistryEvent.MissingMappings<Item> event, String oldId, String newId)
    {
        for(RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings(DropTheRock.MODID))
        {
            if(mapping.key.toString().equals(DropTheRock.MODID + ":" + oldId))
            {
                mapping.remap(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DropTheRock.MODID, newId)));
            }
        }
    }

}
