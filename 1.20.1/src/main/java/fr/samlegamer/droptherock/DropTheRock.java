package fr.samlegamer.droptherock;

import com.alcatrazescapee.notreepunching.common.items.ModItemGroups;
import fr.samlegamer.droptherock.block.DTRBlockRegistry;
import fr.samlegamer.droptherock.client.RockBlockstatesProvider;
import fr.samlegamer.droptherock.client.RockItemsModelsProvider;
import fr.samlegamer.droptherock.config.DTRConfig;
import fr.samlegamer.droptherock.config.DTRRockableAdd;
import fr.samlegamer.droptherock.data.RockBlocksTagsProvider;
import fr.samlegamer.droptherock.data.RockItemsTagsProvider;
import fr.samlegamer.droptherock.data.RockRecipesProvider;
import fr.samlegamer.droptherock.enchant.DTREnchantmentRegistry;
import fr.samlegamer.droptherock.item.DTRItemRegistry;
import fr.samlegamer.droptherock.loot.LootModRegistry;
import fr.samlegamer.droptherock.mapping.MissingnoFix;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Mod(value = DropTheRock.MODID)
public class DropTheRock
{
	public static final String MODID = "droptherock";
	public static final Logger LOGGER = LogManager.getLogger(DropTheRock.MODID);

	public DropTheRock(FMLJavaModLoadingContext javaModLoadingContext)
	{
		LOGGER.info("Loading DropTheRock");
        javaModLoadingContext.getModEventBus().addListener(this::setup);
        javaModLoadingContext.getModEventBus().addListener(this::onGatherData);
        javaModLoadingContext.getModEventBus().addListener(this::addOnTab);
        javaModLoadingContext.registerConfig(ModConfig.Type.COMMON, DTRConfig.CONFIG_SPEC);
		DTRRockableAdd.initOrCreateCfg();
		IEventBus bus = javaModLoadingContext.getModEventBus();
		DTRItemRegistry.ITEM.register(bus);
		DTRBlockRegistry.BLOCK.register(bus);
        DTREnchantmentRegistry.ENCHANTMENT.register(bus);
		LootModRegistry.SERIALIZERS.register(bus);

		DTRBlockRegistry.createLooseRock();
		DTRBlockRegistry.createModdedCobblestone();
        DTRItemRegistry.registerCustom();

        MinecraftForge.EVENT_BUS.register(MissingnoFix.class);
        LOGGER.info("Finished Loading DropTheRock");
	}

	private void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> completableFuture = event.getLookupProvider();

		if (event.includeClient()) {
			generator.addProvider(true, new RockBlockstatesProvider(generator, existingFileHelper));
			generator.addProvider(true, new RockItemsModelsProvider(generator, existingFileHelper));
		}

		if(event.includeServer())
		{
			generator.addProvider(true, new RockRecipesProvider(generator));
            generator.addProvider(true, new RockBlocksTagsProvider(generator, completableFuture, existingFileHelper));
            generator.addProvider(true, new RockItemsTagsProvider(generator, completableFuture, existingFileHelper));
        }
	}

	private void setup(FMLCommonSetupEvent event)
	{
        MinecraftForge.EVENT_BUS.register(DTREvents.class);
    }

    private void addOnTab(BuildCreativeModeTabContentsEvent event)
    {
        ModList modList = ModList.get();

        if(event.getTab() == ModItemGroups.TAB.get())
        {
            event.accept(DTRBlockRegistry.vanilla_deepslate_loose_rock.get());

            if(modList.isLoaded("iceandfire"))
            {
//                event.accept(DTRItemRegistry.IAF_COPPER_KNIFE);
//                event.accept(DTRItemRegistry.IAF_COPPER_SAW);
//                event.accept(DTRItemRegistry.IAF_COPPER_MATTOCK);
//
//                event.accept(DTRItemRegistry.IAF_SILVER_KNIFE);
//                event.accept(DTRItemRegistry.IAF_SILVER_SAW);
//                event.accept(DTRItemRegistry.IAF_SILVER_MATTOCK);
//
//                event.accept(DTRItemRegistry.IAF_DRAGONBONE_KNIFE);
//                event.accept(DTRItemRegistry.IAF_DRAGONBONE_SAW);
//                event.accept(DTRItemRegistry.IAF_DRAGONBONE_MATTOCK);
                event.acceptAll(searcher("iaf"));
            }

            if(modList.isLoaded("quark"))
            {
                event.acceptAll(searcher("quark"));
            }

            if(modList.isLoaded("biomeswevegone"))
            {
                event.acceptAll(searcher("biomeswevegone"));
            }

            if(modList.isLoaded("biomesoplenty"))
            {
                event.acceptAll(searcher("biomesoplenty"));
            }

            event.accept(DTRBlockRegistry.example_stone.get());
            event.acceptAll(searcher(DropTheRock.MODID+"_example_"));
        }
    }

    private Collection<ItemStack> searcher(String contains)
    {
        Collection<RegistryObject<Item>> items_iaf = DTRItemRegistry.ITEM.getEntries();
        Collection<ItemStack> item_accepted = new HashSet<>();

        for(RegistryObject<Item> item : items_iaf)
        {
            if(item.getId() != null)
            {
                if(item.getId().getPath().contains(contains))
                {
                    item_accepted.add(item.get().getDefaultInstance());
                }
            }
        }

        return item_accepted;
    }
}