package fr.samlegamer.droptherock.config;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.samlegamer.droptherock.DropTheRock;
import fr.samlegamer.droptherock.rock.Rock;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DTRRockableAdd
{
    public static void initOrCreateCfg()
    {
        if(!FMLPaths.CONFIGDIR.get().resolve("droptherockadd.json").toFile().exists())
        {
            try(JsonWriter writer = new JsonWriter(new FileWriter(FMLPaths.CONFIGDIR.get().resolve("droptherockadd.json").toFile())))
            {
                writer.setIndent("  ");
                writer.beginArray();
                writer.beginObject();
                writer.name("base_block").value("droptherock:example_stone");
                writer.name("loose_rock_block").value("droptherock:droptherock_example_stone_loose_rock");
                writer.name("cobblestone_block").value("droptherock:droptherock_example_cobblestone");
                writer.endObject();
                writer.endArray();
            }
            catch (Exception e)
            {
                DropTheRock.LOGGER.info("Could not create default config file droptherockadd.json");
            }
        }

        if(!FMLPaths.CONFIGDIR.get().resolve("dropthemat"+ File.separator).toFile().exists())
        {
            FMLPaths.CONFIGDIR.get().resolve("dropthemat"+ File.separator).toFile().mkdir();
        }
    }

    public static List<Rock> getRockLooseAndCobble()
    {
        List<Rock> list = new ArrayList<>();

        if(FMLPaths.CONFIGDIR.get().resolve("droptherockadd.json").toFile().exists())
        {
            try(JsonReader reader = new JsonReader(new FileReader(FMLPaths.CONFIGDIR.get().resolve("droptherockadd.json").toFile())))
            {
                for(reader.beginArray(); reader.hasNext();)
                {
                    reader.beginObject();
                    String base = "";
                    String loose = "";
                    String cobble = "";

                    while (reader.hasNext())
                    {
                        String name = reader.nextName();
                        switch (name)
                        {
                            case "base_block":
                                base = reader.nextString();
                                break;
                            case "loose_rock_block":
                                loose = reader.nextString();
                                break;
                            case "cobblestone_block":
                                cobble = reader.nextString();
                                break;
                            default:
                                reader.skipValue();
                        }
                    }
                    reader.endObject();

                    if(!base.isEmpty() && !loose.isEmpty() && !cobble.isEmpty())
                    {
                        Rock rock = new Rock(base, loose, cobble);
                        if(!list.contains(rock))
                        {
                            list.add(rock);
                        }
                    }
                    else
                    {
                        DropTheRock.LOGGER.info("Error with custom rock: {} -> {} -> {}", base, loose, cobble);
                    }
                }
                reader.endArray();
            }
            catch (Exception e)
            {
                DropTheRock.LOGGER.info("Could not read default config file droptherockadd.json");
            }
        }

        return list;
    }
}
