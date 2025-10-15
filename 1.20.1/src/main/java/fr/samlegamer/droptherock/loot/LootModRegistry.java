package fr.samlegamer.droptherock.loot;

import com.mojang.serialization.Codec;
import fr.samlegamer.droptherock.DropTheRock;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModRegistry {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DropTheRock.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REPLACE_DROP =
            SERIALIZERS.register("replace_drop", RocksLootModifier.CODEC);

}
