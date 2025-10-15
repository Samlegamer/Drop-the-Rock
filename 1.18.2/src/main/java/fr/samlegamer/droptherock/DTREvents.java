package fr.samlegamer.droptherock;

import fr.samlegamer.droptherock.commands.GetTierParam;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DTREvents {

    @SubscribeEvent
    public static void commandsRegister(RegisterCommandsEvent e)
    {
        GetTierParam.register(e.getDispatcher());
    }

}
