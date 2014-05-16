package me.sturk.RealCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Cable extends BlockContainer {

    private float pixel = 1F/16F;

    public Cable(Material material) {
        super(material);
        setCreativeTab(Main.realTab);
        setBlockBounds(10*pixel/2,10*pixel/2,10*pixel/2, 1-10*pixel/2, 1-10*pixel/2, 1-10*pixel/2);
        this.useNeighborBrightness=true;
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return true;
    }

    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityCable();
    }
}
