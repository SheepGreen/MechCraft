package me.sturk.RealCraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(Main.openCraftPack.isPressed()) {
			System.out.println("Key Pressed!");
		}
	}
}
