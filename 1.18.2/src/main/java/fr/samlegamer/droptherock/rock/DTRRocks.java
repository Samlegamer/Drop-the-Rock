package fr.samlegamer.droptherock.rock;

import fr.samlegamer.droptherock.config.DTRRockableAdd;

import java.util.ArrayList;
import java.util.List;

public class DTRRocks
{
    public static List<Rock> vanilla()
    {
        List<Rock> vanilla = new ArrayList<>();
        vanilla.add(new Rock("minecraft:stone", "notreepunching:stone_loose_rock", "minecraft:cobblestone"));
        vanilla.add(new Rock("minecraft:granite", "notreepunching:granite_loose_rock", "notreepunching:granite_cobblestone"));
        vanilla.add(new Rock("minecraft:diorite", "notreepunching:diorite_loose_rock", "notreepunching:diorite_cobblestone"));
        vanilla.add(new Rock("minecraft:andesite", "notreepunching:andesite_loose_rock", "notreepunching:andesite_cobblestone"));
        vanilla.add(new Rock("minecraft:sandstone", "notreepunching:sandstone_loose_rock", "minecraft:sandstone"));
        vanilla.add(new Rock("minecraft:red_sandstone", "notreepunching:red_sandstone_loose_rock", "minecraft:red_sandstone"));
        vanilla.add(new Rock("minecraft:deepslate", "droptherock:vanilla_deepslate_loose_rock", "minecraft:cobbled_deepslate"));
        return vanilla;
    }

    public static List<Rock> quark()
    {
        List<Rock> quark = new ArrayList<>();
        quark.add(new Rock("quark:basalt", "droptherock:quark_basalt_loose_rock", "droptherock:quark_basalt_cobblestone"));
        quark.add(new Rock("quark:jasper", "droptherock:quark_jasper_loose_rock", "droptherock:quark_jasper_cobblestone"));
        quark.add(new Rock("quark:limestone", "droptherock:quark_limestone_loose_rock", "droptherock:quark_limestone_cobblestone"));
        quark.add(new Rock("quark:marble", "droptherock:quark_marble_loose_rock", "droptherock:quark_marble_cobblestone"));
        quark.add(new Rock("quark:slate", "droptherock:quark_slate_loose_rock", "droptherock:quark_slate_cobblestone"));
        return quark;
    }

    public static List<Rock> byg()
    {
        List<Rock> byg = new ArrayList<>();
        byg.add(new Rock("byg:black_sandstone", "droptherock:byg_black_sandstone_loose_rock", "byg:black_sandstone"));
        byg.add(new Rock("byg:blue_sandstone", "droptherock:byg_blue_sandstone_loose_rock", "byg:blue_sandstone"));
        byg.add(new Rock("byg:cryptic_stone", "droptherock:byg_cryptic_stone_loose_rock", "droptherock:byg_cryptic_stone_cobblestone"));
        byg.add(new Rock("byg:dacite", "droptherock:byg_dacite_loose_rock", "byg:dacite_cobblestone"));
        byg.add(new Rock("byg:ether_stone", "droptherock:byg_ether_stone_loose_rock", "byg:cobbled_ether_stone"));
        byg.add(new Rock("byg:pink_sandstone", "droptherock:byg_pink_sandstone_loose_rock", "byg:pink_sandstone"));
        byg.add(new Rock("byg:purple_sandstone", "droptherock:byg_purple_sandstone_loose_rock", "byg:purple_sandstone"));
        byg.add(new Rock("byg:purpur_stone", "droptherock:byg_purpur_stone_loose_rock", "droptherock:byg_purpur_stone_cobblestone"));
        byg.add(new Rock("byg:red_rock", "droptherock:byg_red_rock_loose_rock", "droptherock:byg_red_rock_cobblestone"));
        byg.add(new Rock("byg:rocky_stone", "droptherock:byg_rocky_stone_loose_rock", "droptherock:byg_rocky_stone_cobblestone"));
        byg.add(new Rock("byg:scoria_stone", "droptherock:byg_scoria_stone_loose_rock", "byg:scoria_cobblestone"));
        byg.add(new Rock("byg:soapstone", "droptherock:byg_soapstone_loose_rock", "droptherock:byg_soapstone_cobblestone"));
        byg.add(new Rock("byg:travertine", "droptherock:byg_travertine_loose_rock", "droptherock:byg_travertine_cobblestone"));
        byg.add(new Rock("byg:white_sandstone", "droptherock:byg_white_sandstone_loose_rock", "byg:white_sandstone"));
        return byg;
    }

    public static List<Rock> bop()
    {
        List<Rock> bop = new ArrayList<>();
        bop.add(new Rock("biomesoplenty:black_sandstone", "droptherock:biomesoplenty_black_sandstone_loose_rock", "biomesoplenty:black_sandstone"));
        bop.add(new Rock("biomesoplenty:white_sandstone", "droptherock:biomesoplenty_white_sandstone_loose_rock", "biomesoplenty:white_sandstone"));
        bop.add(new Rock("biomesoplenty:orange_sandstone", "droptherock:biomesoplenty_orange_sandstone_loose_rock", "biomesoplenty:orange_sandstone"));
        return bop;
    }

    public static List<Rock> customRocks()
    {
        return DTRRockableAdd.getRockLooseAndCobble();
    }

}
