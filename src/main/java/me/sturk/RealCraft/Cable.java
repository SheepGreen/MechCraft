package me.sturk.RealCraft;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Cable extends BlockContainer {
	//when you extend classes, you must override it otherwise nothing will work as it should
	private float pixel = 1F / 16F;

	public Cable(Material material) {
		super(material);
		setCreativeTab(Main.realTab);
		this.setBlockTextureName("realcraft:cable");
		setBlockBounds(10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2);
		this.useNeighborBrightness = true;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override//work on TileEntityCable class for your cables
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityCable();
	}


}
