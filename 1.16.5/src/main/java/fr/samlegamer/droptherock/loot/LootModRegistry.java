package fr.samlegamer.droptherock.loot;

import fr.samlegamer.droptherock.DropTheRock;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LootModRegistry {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, DropTheRock.MODID);

    public static final RegistryObject<GlobalLootModifierSerializer<?>> REPLACE_DROP =
            SERIALIZERS.register("replace_drop", ReplaceDropModifierSerializer::new);

}
