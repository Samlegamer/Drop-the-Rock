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

	/*
	 * BYG - 100%
	 */
	public static final RegistryObject<Block> black_sandstone_loose_rock = createBlock("black_sandstone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> blue_sandstone_loose_rock = createBlock("blue_sandstone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> ether_stone_loose_rock = createBlock("ether_stone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> pink_sandstone_loose_rock = createBlock("pink_sandstone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> purple_sandstone_loose_rock = createBlock("purple_sandstone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> scoria_stone_loose_rock = createBlock("scoria_stone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> soapstone_loose_rock = createBlock("soapstone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> travertine_loose_rock = createBlock("travertine_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> purple_stone_loose_rock = createBlock("purple_stone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> red_rock_loose_rock = createBlock("red_rock_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> rocky_stone_loose_rock = createBlock("rocky_stone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> cryptic_stone_loose_rock = createBlock("cryptic_stone_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> dacite_loose_rock = createBlock("dacite_loose_rock", LooseRockBlock::new);
	public static final RegistryObject<Block> white_sandstone_loose_rock = createBlock("white_sandstone_loose_rock", LooseRockBlock::new);
	
	/*
	 * Biome O' Plenty - 0%
	 */
	
	/*
	 * Quark - 0%
	 */
	
	/*
	 * Project Vibrant Journey - 0%
	 */
	
	
	public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCK.register(name, supplier);
        ItemsMod.ITEM.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
        return block;
    }
}