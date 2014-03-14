package com.miscitems.MiscItemsAndBlocks.Main;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.*;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Laser.DefaultLaser;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Lib.Crafting;
import com.miscitems.MiscItemsAndBlocks.Lib.Messages;
import com.miscitems.MiscItemsAndBlocks.Lib.ModConfig;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Misc.BoneMealEvent;
import com.miscitems.MiscItemsAndBlocks.Mobs.EntityPenguin;
import com.miscitems.MiscItemsAndBlocks.Network.NetworkManager;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Tick.ServerTickHandler;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;
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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.Random;
import java.util.logging.Logger;


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

    
	public static CreativeTabs MiscTab = new CreativeTabs("tabMiscMisc") {


		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
            if(Main.config.get("Items", "Enable " + "Guide Book" + "?", true).getBoolean(true)){
                Main.config.save();
			return ModItems.GuideBook;
            }else{
                Main.config.save();
                return ItemBlock.getItemFromBlock(Blocks.bedrock);
            }
        }
		
	    
	};


    public static CreativeTabs ElectricTab = new CreativeTabs("tabMiscElectric") {


        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            if(Main.config.get("Blocks", "Enable " + "Charger" + "?", true).getBoolean(true)){
                Main.config.save();
            return ItemBlock.getItemFromBlock(ModBlocks.Charger);
            }else{
                Main.config.save();
                return ItemBlock.getItemFromBlock(Blocks.bedrock);
            }
        }


    };

       public static Configuration config;
      
       private Object entityRenderMap;
	
@EventHandler
public void preInit(FMLPreInitializationEvent event) {
    	
	

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
        

    proxy.RegisterClientTickhandler();
    proxy.RegisterServerTickhandler();
        
        //Register Events
        RegisterServerEvents();
        
    	if(event.getSide() == Side.CLIENT){
    		RegisterClientEvents();
    	//############Mob code Section################//
    		proxy.registerRenderers();
    		registerEntity(EntityPenguin.class, "Penguin", 0x070A0A, 0xFFF8F7, 64);
    	}
    	 	
        
    }

public void RegisterClientEvents(){
	
	
    MinecraftForge.EVENT_BUS.register(new GuiListener());	
    MinecraftForge.EVENT_BUS.register(new CapeRenderEvent());

    MinecraftForge.EVENT_BUS.register(Main.proxy.tickHandlerServer);
}


public void RegisterServerEvents(){
	
	
	
    MinecraftForge.EVENT_BUS.register(new BoneMealEvent());
    MinecraftForge.EVENT_BUS.register(new PlayerFirstJoinEvent());
    MinecraftForge.EVENT_BUS.register(new DisarmStickEvent());
    MinecraftForge.EVENT_BUS.register(new GhostBlockBreakEvent());

    MinecraftForge.EVENT_BUS.register(Main.proxy.tickHandlerClient);
}
    
    
@EventHandler
    public void Init(FMLInitializationEvent event){
    	

        
		NETWORK_MANAGER = new NetworkManager();

    
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


       public static void registerEntity(Class Entity, String name, int PrimColor, int SecColor, int Tracking)
       {
       int entityID = EntityRegistry.findGlobalUniqueEntityId();
       long seed = name.hashCode();
       Random rand = new Random(seed);

       EntityRegistry.registerGlobalEntityID(Entity, name, entityID);
       EntityRegistry.registerModEntity(Entity, name, entityID, instance, Tracking, 1, true);
       EntityList.entityEggs.put(entityID, new EntityList.EntityEggInfo(entityID, PrimColor, SecColor));
       }
	
}
