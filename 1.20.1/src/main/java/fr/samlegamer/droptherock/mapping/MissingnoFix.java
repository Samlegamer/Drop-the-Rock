package fr.samlegamer.droptherock.mapping;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.core.registries.Registries;
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
        convertDataBlockAndItem(event, "black_sandstone_loose_rock", "biomeswevegone_black_sandstone_loose_rock");
        convertDataBlockAndItem(event, "blue_sandstone_loose_rock", "biomeswevegone_blue_sandstone_loose_rock");
        convertDataBlockAndItem(event, "dacite_loose_rock", "biomeswevegone_dacite_loose_rock");
        convertDataBlockAndItem(event, "pink_sandstone_loose_rock", "biomeswevegone_pink_sandstone_loose_rock");
        convertDataBlockAndItem(event, "purple_sandstone_loose_rock", "biomeswevegone_purple_sandstone_loose_rock");
        convertDataBlockAndItem(event, "red_rock_loose_rock", "biomeswevegone_red_rock_loose_rock");
        convertDataBlockAndItem(event, "rocky_stone_loose_rock", "biomeswevegone_rocky_stone_loose_rock");
        convertDataBlockAndItem(event, "white_sandstone_loose_rock", "biomeswevegone_white_sandstone_loose_rock");
        convertDataBlockAndItem(event, "orange_sandstone_loose_rock", "biomesoplenty_orange_sandstone_loose_rock");
        convertDataBlockAndItem(event, "windswept_sandstone_loose_rock", "biomeswevegone_windswept_sandstone_loose_rock");
    }

    public static void convertDataBlockAndItem(MissingMappingsEvent event, String oldId, String newId)
    {
        Block remappedBlock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, newId));
        Item remappedItem = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, newId));

        if (remappedBlock != null)
        {
            for(MissingMappingsEvent.Mapping<Block> entry : event.getAllMappings(Registries.BLOCK))
            {
                if(entry.getKey().toString().equals(DropTheRock.MODID + ":" + oldId))
                {
                    entry.remap(remappedBlock);
                }
            }
        }

        if (remappedItem != null)
        {
            for(MissingMappingsEvent.Mapping<Item> entry : event.getAllMappings(Registries.ITEM))
            {
                if(entry.getKey().toString().equals(DropTheRock.MODID + ":" + oldId))
                {
                    entry.remap(remappedItem);
                }
            }
        }
    }
}
