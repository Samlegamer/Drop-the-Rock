package fr.samlegamer.droptherock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.samlegamer.droptherock.item.RocksModRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = DropTheRock.MODID)
@Mod.EventBusSubscriber(modid = DropTheRock.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DropTheRock
{
	public static final String MODID = "droptherock";
	private static final Logger LOGGER = LogManager.getLogger();
	public DropTheRock()
	{
		LOGGER.info("Drop the Rock - Loading...");
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		RocksModRegistry.ITEM.register(bus);	
		RocksModRegistry.BLOCK.register(bus);
		
		if(ModList.get().isLoaded("byg"))
		{
			LOGGER.info("Drop the Rock - BYG Compat Actived !");
			RocksModRegistry.InitBYG();
		}
		
		if(ModList.get().isLoaded("quark"))
		{
			LOGGER.info("Drop the Rock - Quark Compat Actived !");
			RocksModRegistry.InitQuark();
		}
		
		if(ModList.get().isLoaded("biomesoplenty"))
		{
			LOGGER.info("Drop the Rock - BOP Compat Actived !");
			RocksModRegistry.InitBOP();
		}
		LOGGER.info("Drop the Rock - Finish !");
	}
}