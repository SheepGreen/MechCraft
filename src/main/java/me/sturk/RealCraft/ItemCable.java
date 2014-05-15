package me.sturk.RealCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCable extends Item {
    public ItemCable() {
        super();
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2) {
        if(!world.isRemote) {
            System.out.println(side);
        }
        return true;
    }
}
