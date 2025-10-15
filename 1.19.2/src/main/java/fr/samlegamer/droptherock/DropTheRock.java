package fr.samlegamer.droptherock;

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
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = DropTheRock.MODID)
public class DropTheRock
{
	public static final String MODID = "droptherock";
	public static final Logger LOGGER = LogManager.getLogger(DropTheRock.MODID);

	public DropTheRock()
	{
		LOGGER.info("Loading DropTheRock");
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onGatherData);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DTRConfig.CONFIG_SPEC);
		DTRRockableAdd.initOrCreateCfg();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
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

		if (event.includeClient()) {
			generator.addProvider(true, new RockBlockstatesProvider(generator, existingFileHelper));
			generator.addProvider(true, new RockItemsModelsProvider(generator, existingFileHelper));
		}

		if(event.includeServer())
		{
			generator.addProvider(true, new RockRecipesProvider(generator));
            generator.addProvider(true, new RockBlocksTagsProvider(generator, existingFileHelper));
            generator.addProvider(true, new RockItemsTagsProvider(generator, existingFileHelper));
        }
	}

	private void setup(FMLCommonSetupEvent event)
	{
        MinecraftForge.EVENT_BUS.register(DTREvents.class);
    }
}