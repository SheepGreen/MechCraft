package me.sturk.RealCraft;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderCable extends TileEntitySpecialRenderer {

    ResourceLocation texture = new ResourceLocation(Main.Modid, "textures/model/cable.png");
    float pixel = 1F/16F;
    float texturePixel = 1F/32;
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double translationX, double translationY, double translationZ, float f) {
        GL11.glTranslated(translationX, translationY, translationZ);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.bindTexture(texture);
        GL11.glEnable(GL11.GL_LIGHTING);
        drawCore(tileentity);
        GL11.glTranslated(-translationX, -translationY, -translationZ);
    }

    public void drawCore(TileEntity tileentity) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads(); {
            tessellator.addVertexWithUV(1-10*pixel/2, 10*pixel/2, 1-10*pixel/2, 6*texturePixel, 6*texturePixel);
            tessellator.addVertexWithUV(1-10*pixel/2, 1-10*pixel/2, 1-10*pixel/2, 6*texturePixel, 0*texturePixel);
            tessellator.addVertexWithUV(10*pixel/2, 1-10*pixel/2, 1-10*pixel/2, 0*texturePixel, 0*texturePixel);
            tessellator.addVertexWithUV(10*pixel/2, 10*pixel/2, 1-10*pixel/2, 0*texturePixel, 6*texturePixel);
        }
        tessellator.draw();
    }
}
