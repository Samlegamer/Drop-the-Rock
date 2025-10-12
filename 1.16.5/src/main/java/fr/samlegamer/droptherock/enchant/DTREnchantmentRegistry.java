package fr.samlegamer.droptherock.enchant;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DTREnchantmentRegistry
{
    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DropTheRock.MODID);

    public static final RegistryObject<Enchantment> LITHOFUSION = ENCHANTMENT.register("lithofusion", Lithofusion::new);
}