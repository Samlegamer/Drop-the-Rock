package fr.samlegamer.droptherock.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import javax.annotation.ParametersAreNonnullByDefault;

public class Lithofusion extends Enchantment {
    public Lithofusion(EquipmentSlot... slots) {
        super(Rarity.VERY_RARE, EnchantmentCategory.DIGGER, slots);
    }

    public int getMinCost(int p_77321_1_) {
        return 15;
    }

    public int getMaxCost(int p_223551_1_) {
        return super.getMinCost(p_223551_1_) + 50;
    }

    @ParametersAreNonnullByDefault
    public boolean checkCompatibility(Enchantment p_77326_1_) {
        return super.checkCompatibility(p_77326_1_) && p_77326_1_ != Enchantments.SILK_TOUCH;
    }
}

