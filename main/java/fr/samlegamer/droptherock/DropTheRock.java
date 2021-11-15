package fr.samlegamer.droptherock;

import fr.samlegamer.droptherock.item.ItemsMod;
import fr.samlegamer.droptherock.item.RocksModRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = DropTheRock.MODID)
@Mod.EventBusSubscriber(modid = DropTheRock.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DropTheRock
{
	public static final String MODID = "droptherock";
	
	public DropTheRock()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientSetup);
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemsMod.ITEM.register(bus);
		RocksModRegistry.BLOCK.register(bus);
	}
	
	private void setup(FMLCommonSetupEvent event)
	{
		
	}
	
	private void ClientSetup(FMLClientSetupEvent event)
	{
		
	}
}