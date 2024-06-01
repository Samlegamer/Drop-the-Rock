package fr.samlegamer.droptherock.item;

import com.alcatrazescapee.notreepunching.common.blocks.LooseRockBlock;
import com.google.common.base.Supplier;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RocksModRegistry
{
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DropTheRock.MODID);

	public static RegistryObject<Block> black_sandstone_loose_rock;
	public static RegistryObject<Block> blue_sandstone_loose_rock;
	public static RegistryObject<Block> ether_stone_loose_rock;
	public static RegistryObject<Block> pink_sandstone_loose_rock;
	public static RegistryObject<Block> purple_sandstone_loose_rock;
	public static RegistryObject<Block> scoria_stone_loose_rock;
	public static RegistryObject<Block> soapstone_loose_rock;
	public static RegistryObject<Block> travertine_loose_rock;
	public static RegistryObject<Block> purple_stone_loose_rock;
	public static RegistryObject<Block> red_rock_loose_rock;
	public static RegistryObject<Block> rocky_stone_loose_rock;
	public static RegistryObject<Block> cryptic_stone_loose_rock;
	public static RegistryObject<Block> dacite_loose_rock;
	public static RegistryObject<Block> white_sandstone_loose_rock;
	
	public static RegistryObject<Block> basalt_loose_rock;
	public static RegistryObject<Block> deepslate_loose_rock;
	public static RegistryObject<Block> jasper_loose_rock;
	public static RegistryObject<Block> limestone_loose_rock;
	public static RegistryObject<Block> marble_loose_rock;
	public static RegistryObject<Block> myalite_loose_rock;
	public static RegistryObject<Block> slate_loose_rock;
	
	public static RegistryObject<Block> orange_sandstone_loose_rock;
	
	public static void InitBYG()
	{
		black_sandstone_loose_rock = register("black_sandstone_loose_rock", LooseRockBlock::new);
		blue_sandstone_loose_rock = register("blue_sandstone_loose_rock", LooseRockBlock::new);
		ether_stone_loose_rock = register("ether_stone_loose_rock", LooseRockBlock::new);
		pink_sandstone_loose_rock = register("pink_sandstone_loose_rock", LooseRockBlock::new);
		purple_sandstone_loose_rock = register("purple_sandstone_loose_rock", LooseRockBlock::new);
		scoria_stone_loose_rock = register("scoria_stone_loose_rock", LooseRockBlock::new);
		soapstone_loose_rock = register("soapstone_loose_rock", LooseRockBlock::new);
		travertine_loose_rock = register("travertine_loose_rock", LooseRockBlock::new);
		purple_stone_loose_rock = register("purple_stone_loose_rock", LooseRockBlock::new);
		red_rock_loose_rock = register("red_rock_loose_rock", LooseRockBlock::new);
		rocky_stone_loose_rock = register("rocky_stone_loose_rock", LooseRockBlock::new);
		cryptic_stone_loose_rock = register("cryptic_stone_loose_rock", LooseRockBlock::new);
		dacite_loose_rock = register("dacite_loose_rock", LooseRockBlock::new);
		white_sandstone_loose_rock = register("white_sandstone_loose_rock", LooseRockBlock::new);
	}
	
	public static void InitQuark()
	{
		basalt_loose_rock = register("basalt_loose_rock", LooseRockBlock::new);
		deepslate_loose_rock = register("deepslate_loose_rock", LooseRockBlock::new);
		jasper_loose_rock = register("jasper_loose_rock", LooseRockBlock::new);
		limestone_loose_rock = register("limestone_loose_rock", LooseRockBlock::new);
		marble_loose_rock = register("marble_loose_rock", LooseRockBlock::new);
		myalite_loose_rock = register("myalite_loose_rock", LooseRockBlock::new);
		slate_loose_rock = register("slate_loose_rock", LooseRockBlock::new);
	}
	
	public static void InitBOP()
	{
		orange_sandstone_loose_rock = register("orange_sandstone_loose_rock", LooseRockBlock::new);
	}
	
	public static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCK.register(name, supplier);
        ItemsMod.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
        return block;
    }
	
	/*
	 * Project Vibrant Journey - 0%
	 */
}