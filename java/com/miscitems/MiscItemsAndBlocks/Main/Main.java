package com.miscitems.MiscItemsAndBlocks.Main;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.CapeRenderEvent;
import com.miscitems.MiscItemsAndBlocks.Event.DisarmStickEvent;
import com.miscitems.MiscItemsAndBlocks.Event.GuiListener;
import com.miscitems.MiscItemsAndBlocks.Event.PlayerFirstJoinEvent;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Laser.DefaultLaser;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Lib.Crafting;
import com.miscitems.MiscItemsAndBlocks.Lib.Messages;
import com.miscitems.MiscItemsAndBlocks.Lib.ModConfig;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Misc.BoneMealEvent;
import com.miscitems.MiscItemsAndBlocks.Network.NetworkManager;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.VersionChecker.VersionChecker;
import com.miscitems.MiscItemsAndBlocks.WorldGen.ModWorldGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version)
public class Main {
	

	public static final Logger Log = Logger.getLogger("MiscItems");
	
    @Instance(Refrence.Mod_Id)
    public static Main instance = new Main();
    
    @SidedProxy(clientSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ClientProxy", serverSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy")
    public static ServerProxy proxy;
    
    
    public static boolean Dev = true;
    
	public static boolean VERSION_CHECK = true;
	
    public static final String RELEASE_VERSION = Refrence.Version;
    public static String LATEST_CHANGES = "[Error]";
    public static String LATEST_VERSION = "[Error]";
    public static String UPDATE_URL = "http://adf.ly/U25ua";
    public static boolean UP_TO_DATE = false;
    
    public static String UpdateMessage = StatCollector.translateToLocal("string.versioncheck.newversion").replace("%EnumRed", EnumChatFormatting.RED + "").replace("%EnumYellow", EnumChatFormatting.YELLOW + "").replace("%EnumBlue", EnumChatFormatting.BLUE + "").replace("%EnumGold", EnumChatFormatting.GOLD + "").replace("%ModName", Refrence.Mod_Name).replace("%NewVersion", Main.LATEST_VERSION).replace("%DowLink", Main.UPDATE_URL).replace("%Changes", Main.LATEST_CHANGES);
    
    
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("MiscItems");
    
	public static NetworkManager NETWORK_MANAGER;
    
	public static CreativeTabs CreativeTab = new CreativeTabs("tabMisc") {


		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ModItems.GuideBook;
		}
		
	    
	};
	
       public static Configuration config;
	
@EventHandler
public void preInit(FMLPreInitializationEvent event) {
    	
	

	//TODO Add unbreakable sword
	//TODO Add sometype of ore doubling
	
    	
         config = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg")); 
        
    	try
    	{
        
    	ModConfig.Init(config);
    	
    	} catch(Exception ex)
    	{
    		logger.log(Level.ERROR, ex.getMessage(), Refrence.Mod_Id + ": Error encountered while loading config file.");
    	} finally
    	{
    		config.save();
    	}
    	
    	if(VERSION_CHECK)
    		VersionChecker.go();


    	ModBlocks.Init();
    	ModItems.Init();
    	
    	Messages.Init();
    	
        Crafting.RegisterRecipes();
        proxy.RegisterListeners();
    	
        proxy.registerRenderThings();
        proxy.readManuals();
        
        
        
        //Register Events
        RegisterServerEvents();
        
    	if(event.getSide() == Side.CLIENT){
    		RegisterClientEvents();
    	}
        
    }

public void RegisterClientEvents(){
	
	
    MinecraftForge.EVENT_BUS.register(new GuiListener());	
    MinecraftForge.EVENT_BUS.register(new CapeRenderEvent());
}


public void RegisterServerEvents(){
	
	
	
    MinecraftForge.EVENT_BUS.register(new BoneMealEvent());
    MinecraftForge.EVENT_BUS.register(new PlayerFirstJoinEvent());
    MinecraftForge.EVENT_BUS.register(new DisarmStickEvent());
}
    
    
@EventHandler
    public void Init(FMLInitializationEvent event){
    	

        
		NETWORK_MANAGER = new NetworkManager();
    	
        proxy.registerClientTickHandler();
        proxy.registerServerTickHandler();
    
        EntityRegistry.registerGlobalEntityID(EntitySilverArrow.class, "SilverArrow", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntitySilverArrow.class, "SilverArrow", 0, this, 128, 1, true);
        
        EntityRegistry.registerGlobalEntityID(EntityPowerArrow.class, "PowerArrow", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityPowerArrow.class, "PowerArrow", 1, this, 128, 1, true);


        
        
        GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 3);
        
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.TomatoSeeds), 10);
        
        

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        

    }
    
@EventHandler
    public void PostInit(FMLPostInitializationEvent event){
	LaserRegistry.registerLaser("default", new DefaultLaser());
	
	}

	
}
