package me.sturk.RealCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Cable extends Block {
    public Cable(Material material) {
        super(material);
        setCreativeTab(Main.realTab);
        setBlockBounds(4, 4, 4, 6, 6, 6);
    }
}
