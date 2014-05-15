package me.sturk.RealCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Cable extends Block {

    private static int Side;

    public Cable(Material material) {
        super(material);
        setCreativeTab(Main.realTab);
        setBlockBounds(0.4F, 0.4F, 0.4F, 0.6F, 0.6F, 0.6F);

        if(Side==0) {

        }
    }

    public static void CableInfo(int side, int x, int y, int z, Block block) {
        Side = side;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }
}
