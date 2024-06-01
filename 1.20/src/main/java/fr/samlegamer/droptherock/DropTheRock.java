package fr.samlegamer.droptherock;

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
	
	public DropTheRock()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		RocksModRegistry.ITEM.register(bus);	
		RocksModRegistry.BLOCK.register(bus);
		
		if(ModList.get().isLoaded("byg"))
		{
			RocksModRegistry.InitBYG();
		}
		
		if(ModList.get().isLoaded("quark"))
		{
			RocksModRegistry.InitQuark();
		}
		
		if(ModList.get().isLoaded("biomesoplenty"))
		{
			RocksModRegistry.InitBOP();
		}
	}
}