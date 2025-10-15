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
        quark.add(new Rock("quark:jasper", "droptherock:quark_jasper_loose_rock", "droptherock:quark_jasper_cobblestone"));
        quark.add(new Rock("quark:limestone", "droptherock:quark_limestone_loose_rock", "droptherock:quark_limestone_cobblestone"));
        quark.add(new Rock("quark:shale", "droptherock:quark_shale_loose_rock", "droptherock:quark_shale_cobblestone"));
        return quark;
    }

    public static List<Rock> biomeswevegone()
    {
        List<Rock> biomeswevegone = new ArrayList<>();
        biomeswevegone.add(new Rock("biomeswevegone:black_sandstone", "droptherock:biomeswevegone_black_sandstone_loose_rock", "biomeswevegone:black_sandstone"));
        biomeswevegone.add(new Rock("biomeswevegone:blue_sandstone", "droptherock:biomeswevegone_blue_sandstone_loose_rock", "biomeswevegone:blue_sandstone"));
        biomeswevegone.add(new Rock("biomeswevegone:dacite", "droptherock:biomeswevegone_dacite_loose_rock", "biomeswevegone:dacite_cobblestone"));
        biomeswevegone.add(new Rock("biomeswevegone:pink_sandstone", "droptherock:biomeswevegone_pink_sandstone_loose_rock", "biomeswevegone:pink_sandstone"));
        biomeswevegone.add(new Rock("biomeswevegone:purple_sandstone", "droptherock:biomeswevegone_purple_sandstone_loose_rock", "biomeswevegone:purple_sandstone"));
        biomeswevegone.add(new Rock("biomeswevegone:red_rock", "droptherock:biomeswevegone_red_rock_loose_rock", "droptherock:biomeswevegone_red_rock_cobblestone"));
        biomeswevegone.add(new Rock("biomeswevegone:rocky_stone", "droptherock:biomeswevegone_rocky_stone_loose_rock", "droptherock:biomeswevegone_rocky_stone_cobblestone"));
        biomeswevegone.add(new Rock("biomeswevegone:white_sandstone", "droptherock:biomeswevegone_white_sandstone_loose_rock", "biomeswevegone:white_sandstone"));
        biomeswevegone.add(new Rock("biomeswevegone:windswept_sandstone", "droptherock:biomeswevegone_windswept_sandstone_loose_rock", "biomeswevegone:windswept_sandstone"));
        return biomeswevegone;
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
