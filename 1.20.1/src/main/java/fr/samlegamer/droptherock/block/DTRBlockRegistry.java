package fr.samlegamer.droptherock.block;

import com.alcatrazescapee.notreepunching.common.blocks.LooseRockBlock;
import com.google.common.base.Supplier;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.item.DTRItemRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class DTRBlockRegistry
{
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DropTheRock.MODID);

    public static final RegistryObject<Block> example_stone = register("example_stone", () -> new Block(Block.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> vanilla_deepslate_loose_rock = register("vanilla_deepslate_loose_rock", LooseRockBlock::new);

	public static void createModdedCobblestone()
	{
        List<Rock> rocks = new ArrayList<>();
		rocks.addAll(DTRRocks.quark());
		rocks.addAll(DTRRocks.biomeswevegone());
        rocks.addAll(DTRRocks.bop());
        rocks.addAll(DTRRocks.customRocks());

        //rocks.removeIf(filter -> !filter.cobblestone().contains("droptherock:"));

		for(Rock mod : rocks)
		{
            final String nameLoose = mod.loose_rock().split(":")[1];
            final String name = mod.cobblestone().split(":")[1];

            final RegistryObject<Block> loose_rock = register(nameLoose, LooseRockBlock::new);

            if(mod.cobblestone().contains("droptherock:"))
            {
                final RegistryObject<Block> cobblestone = register(name, () -> new Block(Block.Properties.copy(Blocks.COBBLESTONE)));
                final RegistryObject<Block> cobblestone_slab = register(name+"_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.COBBLESTONE_SLAB)));
                final RegistryObject<Block> cobblestone_stairs = register(name+"_stairs", () -> new StairBlock(() -> cobblestone.get().defaultBlockState(), Block.Properties.copy(Blocks.COBBLESTONE_STAIRS)));
                final RegistryObject<Block> cobblestone_wall = register(name+"_wall", () -> new WallBlock(Block.Properties.copy(Blocks.COBBLESTONE_WALL)));
            }
        }
	}
	
	public static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCK.register(name, supplier);
        Item.Properties properties = DTRItemRegistry.getPropertiesIsModLoaded();
        DTRItemRegistry.ITEM.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}