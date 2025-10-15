package fr.samlegamer.droptherock.client;

import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.rock.DTRRocks;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RockItemsModelsProvider extends ItemModelProvider
{
    public RockItemsModelsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), DropTheRock.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        String exCobble = "droptherock_example_cobblestone";
        String ex = "example_stone";
        withExistingParent(ex, ResourceLocation.fromNamespaceAndPath(modid, "block/" + ex));
        withExistingParent(exCobble, ResourceLocation.fromNamespaceAndPath(modid, "block/" + exCobble));
        withExistingParent(exCobble+"_slab", ResourceLocation.fromNamespaceAndPath(modid, "block/" + exCobble+"_slab"));
        withExistingParent(exCobble+"_stairs", ResourceLocation.fromNamespaceAndPath(modid, "block/" + exCobble+"_stairs"));
        withExistingParent(exCobble+"_wall", ResourceLocation.fromNamespaceAndPath(modid, "block/" + exCobble+"_wall_inventory"));

        List<Rock> rocks = new ArrayList<>();
        rocks.addAll(DTRRocks.quark());
        rocks.addAll(DTRRocks.byg());
        rocks.addAll(DTRRocks.bop());
        rocks.addAll(DTRRocks.customRocks());
        rocks.add(new Rock("minecraft:deepslate", "droptherock:vanilla_deepslate_loose_rock", "minecraft:cobbled_deepslate"));

        for (Rock rock : rocks) {
            String[] parts = rock.getLooseRock().split(":");
            String modid = parts[0];
            String name  = parts[1];

            withExistingParent(name, mcLoc("item/generated"))
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(modid, "item/" + name));
        }
        List<Rock> cobble = new ArrayList<>();
        cobble.addAll(DTRRocks.quark());
        cobble.addAll(DTRRocks.byg());
        cobble.addAll(DTRRocks.bop());
        //cobble.addAll(DTRRocks.customRocks());

        cobble.removeIf(filter -> !filter.cobblestone().contains("droptherock:"));

        for(Rock rock : cobble)
        {
            String[] parts = rock.cobblestone().split(":");
            String modid = parts[0];
            String name  = parts[1];

            withExistingParent(name, ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
            withExistingParent(name + "_stairs", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_stairs"));
            withExistingParent(name + "_slab", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_slab"));
            withExistingParent(name + "_wall", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_wall_inventory"));
        }

        List<String> listToolsMat = Arrays.asList("iaf_copper_", "iaf_silver_", "iaf_dragonbone_");

        for(String mat : listToolsMat)
        {
            withExistingParent(mat+"knife", mcLoc("item/handheld"))
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "item/" + mat+"knife"));

            withExistingParent(mat+"saw", mcLoc("item/handheld"))
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "item/" + mat+"saw"));

            withExistingParent(mat+"mattock", mcLoc("item/handheld"))
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(DropTheRock.MODID, "item/" + mat+"mattock"));
        }


    }
}
