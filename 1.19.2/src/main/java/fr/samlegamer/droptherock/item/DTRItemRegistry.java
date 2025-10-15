package fr.samlegamer.droptherock.item;

import com.alcatrazescapee.notreepunching.common.items.KnifeItem;
import com.alcatrazescapee.notreepunching.common.items.MattockItem;
import com.alcatrazescapee.notreepunching.common.items.ModItems;
import com.google.gson.stream.JsonReader;
import fr.samlegamer.droptherock.DropTheRock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public class DTRItemRegistry {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, DropTheRock.MODID);

    // Ice and Fire Mats
    public static final MaterialTiers SILVER_TOOL_MATERIAL = new MaterialTiers(2, 460, 11.0F, 1.0F, 18, new LazyLoadedValue<>(() ->
    {return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "silver_ingot")));}));

    public static final MaterialTiers COPPER_TOOL_MATERIAL = new MaterialTiers(2, 300, 0.7F, 0.0F, 10, new LazyLoadedValue<>(() ->
    {return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "copper_ingot")));}));

    public static final MaterialTiers DRAGONBONE_TOOL_MATERIAL = new MaterialTiers(4, 1660, 10.0F, 4.0F, 22, new LazyLoadedValue<>(() ->
    {return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "dragonbone")));}));

    public static final RegistryObject<Item> IAF_COPPER_KNIFE = ITEM.register("iaf_copper_knife", () -> new KnifeItem(COPPER_TOOL_MATERIAL, 1, -2.2F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_SILVER_KNIFE = ITEM.register("iaf_silver_knife", () -> new KnifeItem(SILVER_TOOL_MATERIAL, 1, -2.2F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_DRAGONBONE_KNIFE = ITEM.register("iaf_dragonbone_knife", () -> new KnifeItem(DRAGONBONE_TOOL_MATERIAL, 1, -2.2F, getPropertiesIsModLoaded("iceandfire")));

    public static final RegistryObject<Item> IAF_COPPER_SAW = ITEM.register("iaf_copper_saw", () -> new AxeItem(COPPER_TOOL_MATERIAL, 2.0F, -3.2F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_SILVER_SAW = ITEM.register("iaf_silver_saw", () -> new AxeItem(SILVER_TOOL_MATERIAL, 2.0F, -3.2F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_DRAGONBONE_SAW = ITEM.register("iaf_dragonbone_saw", () -> new AxeItem(DRAGONBONE_TOOL_MATERIAL, 2.0F, -3.2F, getPropertiesIsModLoaded("iceandfire")));

    public static final RegistryObject<Item> IAF_COPPER_MATTOCK = ITEM.register("iaf_copper_mattock", () -> new MattockItem(COPPER_TOOL_MATERIAL, 0.5F, -3.0F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_SILVER_MATTOCK = ITEM.register("iaf_silver_mattock", () -> new MattockItem(SILVER_TOOL_MATERIAL, 0.5F, -3.0F, getPropertiesIsModLoaded("iceandfire")));
    public static final RegistryObject<Item> IAF_DRAGONBONE_MATTOCK = ITEM.register("iaf_dragonbone_mattock", () -> new MattockItem(DRAGONBONE_TOOL_MATERIAL, 0.5F, -3.0F, getPropertiesIsModLoaded("iceandfire")));

    public static void registerCustom()
    {
        for(File file : Objects.requireNonNull(FMLPaths.CONFIGDIR.get().resolve("dropthemat"+File.separator).toFile().listFiles()))
        {
            MaterialTiers mat;
            try(JsonReader reader = new JsonReader(new FileReader(file)))
            {
                reader.beginObject();
                String repair = "";
                int level = 0;
                int durability = 0;
                float efficiency = 0;
                float attack = 0;
                int enchant = 0;

                while (reader.hasNext())
                {
                    String name = reader.nextName();
                    switch (name)
                    {
                        case "RepairIngredient":
                            repair = reader.nextString();
                            break;
                        case "Level":
                            level = reader.nextInt();
                            break;
                        case "Durability":
                            durability = reader.nextInt();
                            break;
                        case "Efficiency":
                            efficiency = (float)reader.nextDouble();
                            break;
                        case "AttackDamage":
                            attack = (float)reader.nextDouble();
                            break;
                        case "EnchantmentValue":
                            enchant = reader.nextInt();
                            break;
                        default:
                            reader.skipValue();
                    }
                }
                reader.endObject();

                String finalRepair = repair;
                mat = new MaterialTiers(level, durability, efficiency, attack, enchant, new LazyLoadedValue<>(() ->
                {return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(finalRepair)));}));

                String name = file.getName().replace(".json", "");

                ITEM.register(name+"_knife", () -> new KnifeItem(mat, 1, -2.2F, new Item.Properties().tab(ModItems.Tab.ITEMS)));
                ITEM.register(name+"_saw", () -> new AxeItem(mat, 2.0F, -3.2F, new Item.Properties().tab(ModItems.Tab.ITEMS)));
                ITEM.register(name+"_mattock", () -> new MattockItem(mat, 0.5F, -3.0F, new Item.Properties().tab(ModItems.Tab.ITEMS)));
            }
            catch (Exception e)
            {
                DropTheRock.LOGGER.error("Error while loading custom item from {}", file.getName(), e);
            }
        }
    }

    public static Item.Properties getPropertiesIsModLoaded(String modid) {
        Item.Properties properties = new Item.Properties();
        if (ModList.get().isLoaded(modid)) {
            properties.tab(ModItems.Tab.ITEMS);
        }
        return properties;
    }
}