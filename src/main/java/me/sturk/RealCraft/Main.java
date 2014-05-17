package me.sturk.RealCraft;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@Mod(modid = Main.Modid, name = Main.Name, version = Main.Version)
public class Main {
	@SidedProxy(clientSide = "me.sturk.RealCraft.CommonProxy", serverSide = "me.sturk.RealCraft.CommonProxy")
	public static CommonProxy proxy;
	@Mod.Instance(Main.Modid)
	public static Main instance;
	public static final String Modid = "realcraft";
	public static final String Name = "RealCraft";
	public static final String Version = "1.0";
	public static CreativeTabs realTab = new RealTab("RealCraft");
	public static KeyBinding openCraftPack;
	public static Item screwDriver;
	public static Item craftPack;
	public static Block cable;
	public static Block machineGenerator;
	public static Block machineFurnace;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		screwDriver = new ScrewDriver().setUnlocalizedName("ScrewDriver");
		craftPack = new CraftPack().setUnlocalizedName("CraftPack");
		GameRegistry.registerItem(screwDriver, "ScrewDriver");

		machineGenerator = new MachineGenerator(Material.iron).setBlockName("Generator");
		machineFurnace = new MachineFurnace(Material.iron).setBlockName("Furnace");
		cable = new Cable(Material.iron).setBlockName("Cable");
		GameRegistry.registerBlock(machineGenerator, "MachineGenerator");
		GameRegistry.registerBlock(machineFurnace, "MachineFurnace");
		GameRegistry.registerBlock(cable, "Cable");

		GameRegistry.addRecipe(new ItemStack(machineGenerator, 1), new Object[]{
				"iii", "ifi", "iii", 'i', Items.iron_ingot, 'f', Blocks.furnace
		});
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		openCraftPack = new KeyBinding("key.openCraftPack", Keyboard.KEY_F, "key.categories.misc");
		ClientRegistry.registerKeyBinding(openCraftPack);
		GameRegistry.registerTileEntity(TileEntityCable.class, "Cable");
		GameRegistry.registerTileEntity(TileEntityMachineFurnace.class, "MachineFurnace");
		new RealGuiHandler();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RealGuiHandler());
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GuiMachineGenerator(Minecraft.getMinecraft()));
		instance = this;
	}
}
