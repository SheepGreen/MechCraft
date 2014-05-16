package me.sturk.RealCraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=Main.Modid, name=Main.Name, version=Main.Version)
public class Main {
    @SidedProxy(clientSide="me.sturk.RealCraft.CommonProxy", serverSide="me.sturk.RealCraft.CommonProxy")
    public static CommonProxy proxy;
    public static final String Modid = "realcraft";
    public static final String Name = "RealCraft";
    public static final String Version = "1.0";
    public static CreativeTabs realTab = new RealTab("RealCraft");
    public static Item screwDriver;
    public static Block cable;
    public static Block generator;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        screwDriver = new ScrewDriver().setUnlocalizedName("ScrewDriver");
        GameRegistry.registerItem(screwDriver, "ScrewDriver");

        generator = new Generator(Material.iron).setBlockName("Generator");
        cable = new Cable(Material.iron).setBlockName("Cable");
        GameRegistry.registerBlock(cable, "Cable");

        GameRegistry.addRecipe(new ItemStack(generator, 1), new Object[]{
                "iii", "ifi", "iii", 'i', Items.iron_ingot, 'f', Blocks.furnace
        });
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerTileEntity(TileEntityCable.class, "cable");
        proxy.registerRenderers();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiGenerator(Minecraft.getMinecraft()));
    }
}
