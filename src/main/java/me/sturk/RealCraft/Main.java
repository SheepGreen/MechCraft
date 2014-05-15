package me.sturk.RealCraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid=Main.Modid, name=Main.Name, version=Main.Version)
public class Main {
    public static final String Modid = "realcraft";
    public static final String Name = "RealCraft";
    public static final String Version = "RealCraft";
    public static CreativeTabs realTab = new RealTab("RealCraft");
    public static Item screwDriver;
    public static Item itemCable;
    public static Block cable;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        screwDriver = new ScrewDriver().setUnlocalizedName("ScrewDriver");
        itemCable = new ItemCable().setUnlocalizedName("ItemCable");
        GameRegistry.registerItem(screwDriver, "ScrewDriver");
        GameRegistry.registerItem(itemCable, "ItemCable");

        cable = new Cable(Material.coral).setBlockName("Cable");
        GameRegistry.registerBlock(cable, "Cable");
    }
}
