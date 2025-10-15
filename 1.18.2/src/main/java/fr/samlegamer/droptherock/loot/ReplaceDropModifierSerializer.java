package fr.samlegamer.droptherock.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

public class ReplaceDropModifierSerializer extends GlobalLootModifierSerializer<RocksLootModifier> {
    @Override
    public RocksLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
        return new RocksLootModifier(ailootcondition);
    }

    @Override
    public JsonObject write(RocksLootModifier instance) {
        return makeConditions(instance.conditions());
    }
}
