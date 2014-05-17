package me.sturk.RealCraft;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		ClientRegistry.registerTileEntity(TileEntityCable.class, Main.Modid, new TileEntityRenderCable());
	}
}
