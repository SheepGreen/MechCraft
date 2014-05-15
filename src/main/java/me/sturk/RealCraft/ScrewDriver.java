package me.sturk.RealCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ScrewDriver extends Item {
    public ScrewDriver() {
        setCreativeTab(Main.realTab);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2) {
        if(!world.isRemote) {
        }
        return false;
    }
}
