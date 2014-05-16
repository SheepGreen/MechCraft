package me.sturk.RealCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCable extends Item {

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2) {
		if (!world.isRemote) {
			if (side == 0) {
				world.setBlock(x, y - 1, z, Main.cable);
			} else if (side == 1) {
				world.setBlock(x, y + 1, z, Main.cable);
			} else if (side == 2) {
				world.setBlock(x, y, z - 1, Main.cable);
			} else if (side == 3) {
				world.setBlock(x, y, z + 1, Main.cable);
			} else if (side == 4) {
				world.setBlock(x - 1, y, z, Main.cable);
			} else if (side == 5) {
				world.setBlock(x + 1, y, z, Main.cable);
			}
			System.out.println(side);
			return true;
		}
		return false;
	}
}
