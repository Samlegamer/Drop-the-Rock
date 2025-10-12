package fr.samlegamer.droptherock.enchant;

import net.minecraft.enchantment.*;
import net.minecraft.inventory.EquipmentSlotType;

import javax.annotation.ParametersAreNonnullByDefault;

public class Lithofusion extends Enchantment {
    public Lithofusion(EquipmentSlotType... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentType.DIGGER, slots);
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

