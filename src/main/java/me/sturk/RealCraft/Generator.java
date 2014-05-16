package me.sturk.RealCraft;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Generator extends BlockContainer {

    public Generator(Material material) {
        super(material);
        setHardness(3F);
        setResistance(5F);
    }



    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }
}
