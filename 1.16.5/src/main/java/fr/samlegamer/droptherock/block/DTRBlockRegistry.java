package fr.samlegamer.droptherock.block;

import com.alcatrazescapee.notreepunching.common.blocks.LooseRockBlock;
import com.google.common.base.Supplier;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.item.DTRItemRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class DTRBlockRegistry
{
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DropTheRock.MODID);

    public static final RegistryObject<Block> example_stone = register("example_stone", () -> new Block(Block.Properties.copy(Blocks.STONE)), DropTheRock.MODID);

    public static void createLooseRock()
	{
		List<Rock> rocks = new ArrayList<>();
		rocks.addAll(DTRRocks.quark());
		rocks.addAll(DTRRocks.byg());
        rocks.addAll(DTRRocks.bop());
        rocks.addAll(DTRRocks.customRocks());

		for(Rock vanilla : rocks)
		{
			final String modid = vanilla.getRock().split(":")[0];
			final String name = vanilla.getLooseRock().split(":")[1];
            
			final RegistryObject<Block> loose_rock = register(name, LooseRockBlock::new, modid);
		}
	}

	public static void createModdedCobblestone()
	{
		List<Rock> rocks = new ArrayList<>();
		rocks.addAll(DTRRocks.quark());
		rocks.addAll(DTRRocks.byg());
        rocks.addAll(DTRRocks.bop());
        rocks.addAll(DTRRocks.customRocks());

        rocks.removeIf(filter -> !filter.getCobblestone().contains("droptherock:"));

		for(Rock mod : rocks)
		{
            final String modid = mod.getRock().split(":")[0];
            final String name = mod.getCobblestone().split(":")[1];

			final RegistryObject<Block> cobblestone = register(name, () -> new Block(Block.Properties.copy(Blocks.COBBLESTONE)), modid);
            final RegistryObject<Block> cobblestone_slab = register(name+"_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.COBBLESTONE_SLAB)), modid);
            final RegistryObject<Block> cobblestone_stairs = register(name+"_stairs", () -> new StairsBlock(() -> cobblestone.get().defaultBlockState(), Block.Properties.copy(Blocks.COBBLESTONE_STAIRS)), modid);
            final RegistryObject<Block> cobblestone_wall = register(name+"_wall", () -> new WallBlock(Block.Properties.copy(Blocks.COBBLESTONE_WALL)), modid);
        }
	}
	
	public static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier, String modLoaded)
    {
        RegistryObject<Block> block = BLOCK.register(name, supplier);
        Item.Properties properties = DTRItemRegistry.getPropertiesIsModLoaded(modLoaded);
        DTRItemRegistry.ITEM.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}