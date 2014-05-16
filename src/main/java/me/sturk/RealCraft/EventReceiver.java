package me.sturk.RealCraft;

import cpw.mods.fml.common.eventhandler.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class EventReceiver {
    @ForgeSubscribe(priority = EventPriority.NORMAL)
    public void eventHandler(RenderGameOverlayEvent event) {

    }
}
