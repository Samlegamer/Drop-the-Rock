package fr.samlegamer.droptherock.loot;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModRegistry {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, DropTheRock.MODID);

    public static final RegistryObject<GlobalLootModifierSerializer<?>> REPLACE_DROP =
            SERIALIZERS.register("replace_drop", ReplaceDropModifierSerializer::new);

}
