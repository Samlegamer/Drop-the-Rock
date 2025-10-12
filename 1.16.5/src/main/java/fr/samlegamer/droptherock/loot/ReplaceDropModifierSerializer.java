package fr.samlegamer.droptherock.loot;

import com.google.gson.JsonObject;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

public class ReplaceDropModifierSerializer extends GlobalLootModifierSerializer<RocksLootModifier> {
    @Override
    public RocksLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
        return new RocksLootModifier(ailootcondition);
    }

    @Override
    public JsonObject write(RocksLootModifier instance) {
        return makeConditions(instance.conditions());
    }
}
