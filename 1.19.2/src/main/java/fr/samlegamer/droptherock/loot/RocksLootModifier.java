package fr.samlegamer.droptherock.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.samlegamer.droptherock.config.DTRConfig;
import fr.samlegamer.droptherock.enchant.DTREnchantmentRegistry;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Supplier;

public class RocksLootModifier extends LootModifier
{
    public static final Supplier<Codec<RocksLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, RocksLootModifier::new)));


    protected RocksLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    public LootItemCondition[] conditions() {
        return this.conditions;
    }

    @Nonnull
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);
        boolean hasSilkTouch = tool != null && EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;
        boolean hasLithofusion = tool != null && EnchantmentHelper.getTagEnchantmentLevel(DTREnchantmentRegistry.LITHOFUSION.get(), tool) > 0;

        List<Rock> rocks = new ArrayList<>();

        if(DTRConfig.enableVanillaRocks.get()) {
            rocks.addAll(DTRRocks.vanilla());
        }

        if(ModList.get().isLoaded("quark") && DTRConfig.enableQuarkRocks.get())
        {
            rocks.addAll(DTRRocks.quark());
        }

        if(ModList.get().isLoaded("byg") && DTRConfig.enableBYGRocks.get())
        {
            rocks.addAll(DTRRocks.byg());
        }

        if(ModList.get().isLoaded("biomesoplenty") && DTRConfig.enableBOPRocks.get())
        {
            rocks.addAll(DTRRocks.bop());
        }
        rocks.addAll(DTRRocks.customRocks());

        for(Rock vanillaRockable : rocks) {
            Block rock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(vanillaRockable.rock()));
            Item loose_rock = ForgeRegistries.ITEMS.getValue(new ResourceLocation(vanillaRockable.getLooseRock()));
            Block cobblestone = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(vanillaRockable.cobblestone()));
            String modid = vanillaRockable.rock().split(":")[0];

            if(cobblestone != null && rock != null && loose_rock != null && ModList.get().isLoaded(modid)) {
                if (state != null && state.is(rock)) {
                    generatedLoot.clear();
                    if (hasSilkTouch) {
                        generatedLoot.add(new ItemStack(rock, 1));
                    } else if (hasLithofusion) {
                        generatedLoot.add(new ItemStack(cobblestone, 1));
                    } else {
                        int fortuneLevel = tool != null ? EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BLOCK_FORTUNE, tool) : 0;
                        Random rand = new Random();
                        int amount = rand.nextInt(4) + 1 + rand.nextInt(fortuneLevel + 1);
                        generatedLoot.add(new ItemStack(loose_rock, amount));
                    }
                }
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
