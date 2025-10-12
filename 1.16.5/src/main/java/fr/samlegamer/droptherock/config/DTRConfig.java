package fr.samlegamer.droptherock.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class DTRConfig
{
    public static ForgeConfigSpec.BooleanValue enableVanillaRocks;
    public static ForgeConfigSpec.BooleanValue enableQuarkRocks;
    public static ForgeConfigSpec.BooleanValue enableBYGRocks;
    public static ForgeConfigSpec.BooleanValue enableBOPRocks;

    public static final DTRConfig INSTANCE;
    public static final ForgeConfigSpec CONFIG_SPEC;

    static {
        final Pair<DTRConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(DTRConfig::new);
        INSTANCE = specPair.getLeft();
        CONFIG_SPEC = specPair.getRight();
    }

    public DTRConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("DropTheRock Config Settings").push("General Settings");

        enableVanillaRocks = builder
                .comment("Enable loose rocks from vanilla stone variants")
                .define("enableVanillaRocks", true);

        enableQuarkRocks = builder
                .comment("Enable loose rocks from Quark stone variants")
                .define("enableQuarkRocks", true);

        enableBYGRocks = builder
                .comment("Enable loose rocks from Oh The Biomes You'll Go stone variants")
                .define("enableBYGRocks", true);

        enableBOPRocks = builder
                .comment("Enable loose rocks from Biomes O' Plenty stone variants")
                .define("enableBYGRocks", true);

        builder.pop();
    }
}
