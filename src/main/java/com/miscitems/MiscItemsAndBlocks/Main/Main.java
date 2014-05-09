package com.miscitems.MiscItemsAndBlocks.Main;

import com.google.common.collect.Sets;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Book.BookRegestration;
import com.miscitems.MiscItemsAndBlocks.Book.SmallFontRenderer;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.*;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Laser.DefaultLaser;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Utils.Crafting;
import com.miscitems.MiscItemsAndBlocks.Utils.Messages;
import com.miscitems.MiscItemsAndBlocks.Utils.ModConfig;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import com.miscitems.MiscItemsAndBlocks.Utils.BoneMealEvent;
import com.miscitems.MiscItemsAndBlocks.Network.NetworkManager;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.WorldGen.ModWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
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
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.Set;


	@Mod(modid = Refrence.Mod_Id, name = Refrence.Mod_Name, version = Refrence.Version)
	public class Main 
	{

	
		@Instance(Refrence.Mod_Id)
		public static Main instance = new Main();
    
		@SidedProxy(clientSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ClientProxy", serverSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy")
		public static ServerProxy proxy;


        public static Set EmptyToolSet = Sets.newHashSet();


    
        public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("MiscItems");
    
        public static NetworkManager NETWORK_MANAGER;

        public static boolean HDTextures = false;


        public static Configuration config;

        public static net.minecraft.creativetab.CreativeTabs MiscTab = new net.minecraft.creativetab.CreativeTabs("tabMiscMisc")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                if(Main.config.get("Items", "Enable " + "Guide Book" + "?", true).getBoolean(true))
                {
                    Main.config.save();
                    return ModItems.GuideBook;
                }else

                {
                    Main.config.save();
                    return ItemBlock.getItemFromBlock(Blocks.bedrock);
                }
            }

        };


        public static net.minecraft.creativetab.CreativeTabs ElectricTab = new net.minecraft.creativetab.CreativeTabs("tabMiscElectric")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                if(Main.config.get("Blocks", "Enable " + "Charger" + "?", true).getBoolean(true)){
                    Main.config.save();
                    return ItemBlock.getItemFromBlock(ModBlocks.Charger);
                }else
                {
                    Main.config.save();
                    return ItemBlock.getItemFromBlock(Blocks.bedrock);
                }
            }

        };

	
        @EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {
	
        	//TODO Add some type of ore doubling
            //TODO Redo guide book
	
    	
        	config = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg")); 



        	try
        	{
        
        		ModConfig.Init(config);

                HDTextures = !config.get("Client Settings", "Should HD textures be used for some blocks?", true).getBoolean(true);
    	
        	} 
        	
        	catch(Exception ex)
        	{
        		logger.log(Level.ERROR, ex.getMessage(), Refrence.Mod_Id + ": Error encountered while loading config file.");
        	} 
        	finally
        	{
        		config.save();
        	}





        	ModBlocks.Init();
        	ModItems.Init();
    	
        	Messages.Init();

        	Crafting.RegisterRecipes();


        	proxy.RegisterListeners();
    	
        	proxy.registerRenderThings();
        
        	proxy.RegisterClientTickhandler();
        	proxy.RegisterServerTickhandler();
        
        	//Register Events
        	if(event.getSide() == Side.SERVER)
        		RegisterServerEvents();
        
        	if(event.getSide() == Side.CLIENT)
        		RegisterClientEvents();


           registerRenderer();


            BookRegestration.Register();
        }

        public void RegisterClientEvents()
        {
	
	
        	MinecraftForge.EVENT_BUS.register(new GuiListener());	
        	MinecraftForge.EVENT_BUS.register(new CapeRenderEvent());


            FMLCommonHandler.instance().bus().register(Main.proxy.tickHandlerClient);
        }


        public void RegisterServerEvents()
        {
	


	
        	MinecraftForge.EVENT_BUS.register(new BoneMealEvent());
        	MinecraftForge.EVENT_BUS.register(new PlayerFirstJoinEvent());
        	MinecraftForge.EVENT_BUS.register(new DisarmStickEvent());
        	MinecraftForge.EVENT_BUS.register(new GhostBlockBreakEvent());

            FMLCommonHandler.instance().bus().register(Main.proxy.tickHandlerServer);

        }
            
        @EventHandler
        public void Init(FMLInitializationEvent event){

        	proxy.registerRenderers();
    	

        
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
        public void PostInit(FMLPostInitializationEvent event)
        {
        	
        	LaserRegistry.registerLaser("default", new DefaultLaser());
	
        }


        public static SmallFontRenderer font;

        public void registerRenderer ()
        {
            Minecraft mc = Minecraft.getMinecraft();
            font = new SmallFontRenderer(mc.gameSettings, new ResourceLocation("minecraft:textures/font/ascii.png"), mc.renderEngine, false);
        }
	
	}
