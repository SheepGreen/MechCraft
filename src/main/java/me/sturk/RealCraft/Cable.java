package me.sturk.RealCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Cable extends Block {
    public Cable(Material material) {
        super(material);
        setCreativeTab(Main.realTab);
        setBlockBounds(0.4F, 0.4F, 0.4F, 0.6F, 0.6F, 0.6F);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }
}
