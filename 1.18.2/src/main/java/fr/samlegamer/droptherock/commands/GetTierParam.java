package fr.samlegamer.droptherock.commands;

import com.google.gson.stream.JsonWriter;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

public class GetTierParam {

    public static void register(CommandDispatcher<CommandSourceStack> p_202649_0_) {
        p_202649_0_.register(Commands.literal("dropthemat").requires((p_203630_0_) -> {
            return p_203630_0_.hasPermission(2);
        }).then(Commands.argument("targets", EntityArgument.entities()).executes((p_198672_0_) -> {
                    getTierToJson(p_198672_0_.getSource(), p_198672_0_.getSource().getEntity());
               return 0; })));
    }


    private static void getTierToJson(CommandSourceStack commandSource, Entity entity) throws CommandSyntaxException {
        if (entity instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entity;
            ItemStack itemstack = livingentity.getMainHandItem();
            if (itemstack.getItem() instanceof TieredItem) {
                TieredItem tieredItem = (TieredItem) itemstack.getItem();
                Tier tier = tieredItem.getTier();

                try (JsonWriter writer = new JsonWriter(new FileWriter(FMLPaths.CONFIGDIR.get().resolve("dropthemat" + File.separator + Objects.requireNonNull(tier.getRepairIngredient().getItems()[0].getItem().getRegistryName()).toString().split(":")[1] + ".json").toFile()))) {
                    writer.setIndent("  ");
                    writer.beginObject();
                    writer.name("Level").value(tier.getLevel());
                    writer.name("Durability").value(tier.getUses());
                    writer.name("Efficiency").value(tier.getSpeed());
                    writer.name("AttackDamage").value(tier.getAttackDamageBonus());
                    writer.name("EnchantmentValue").value(tier.getEnchantmentValue());
                    writer.name("RepairIngredient").value(tier.getRepairIngredient().getItems()[0].getItem().getRegistryName().toString());
                    writer.endObject();
                    writer.close();
                    DropTheRock.LOGGER.info("Wrote material file in dropthemat/{}.json", tier.getRepairIngredient().getItems()[0].getItem().getRegistryName().toString().split(":")[1]);
                } catch (Exception e) {
                    DropTheRock.LOGGER.info(e.getMessage());
                }
            }
        }
    }
}