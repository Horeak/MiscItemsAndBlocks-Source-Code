package com.miscitems.MiscItemsAndBlocks.Main;

import com.google.common.collect.Sets;
import com.miscitems.MiscItemsAndBlocks.Book.BookRegestration;
import com.miscitems.MiscItemsAndBlocks.Book.SmallFontRenderer;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.*;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Laser.DefaultLaser;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Network.ChannelHandler;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigChanged;
import com.miscitems.MiscItemsAndBlocks.Utils.Crafting;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Messages;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import com.miscitems.MiscItemsAndBlocks.WorldGen.ModWorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
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
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;


	@Mod(modid = Reference.Mod_Id, name = Reference.Mod_Name, version = Reference.Version, guiFactory = "com.miscitems.MiscItemsAndBlocks.Utils.Config.GuiConfigFactory")
	public class Main 
	{

	
		@Instance(Reference.Mod_Id)
		public static Main instance = new Main();
    
		@SidedProxy(clientSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ClientProxy", serverSide = "com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy")
		public static ServerProxy proxy;


        public static Set EmptyToolSet = Sets.newHashSet();



        public static boolean SpawnParticles;
        public static boolean AllowPowerArmorEffects;
    
        public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("MiscItems");


        public static boolean HDTextures = false;


        public static Configuration config;

        public static CreativeTabs MiscTab = new CreativeTabs("tabMiscMisc")
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


        public static CreativeTabs ElectricTab = new CreativeTabs("tabMiscElectric")
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


        public static CreativeTabs MagicTab = new CreativeTabs("tabMiscMagic")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                if(Main.config.get("Items", "Enable " + ModItems.InvisibilityCore.getUnlocalizedName() + "?", true).getBoolean(true)){
                    Main.config.save();
                    return ModItems.InvisibilityCore;
                }else
                {
                    Main.config.save();
                    return ItemBlock.getItemFromBlock(Blocks.bedrock);
                }
            }

        };


        public static EnumMap<Side, FMLEmbeddedChannel> channels;

        public static ChannelHandler handler = new ChannelHandler(Reference.Channel);

	
        @EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {
	
    	
        	config = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg"));





        	try
        	{

                config.load();

                HDTextures = !config.get("Client Settings", "Should HD textures be used for some blocks?", true).getBoolean(true);

                SpawnParticles = config.get("Client Settings", "Spawn particles?", true).getBoolean(true);
                AllowPowerArmorEffects = config.get("Server Settings", "Enable Powerarmor effects?", true).getBoolean(true);
    	
        	} 
        	
        	catch(Exception ex)
        	{
        		logger.log(Level.ERROR, ex.getMessage(), Reference.Mod_Id + ": Error encountered while loading config file.");
        	} 
        	finally
        	{
        		config.save();
        	}


            Main.config.addCustomCategoryComment("Client Settings", "Client side only settings. Settings that does not affect gameplay");
            Main.config.addCustomCategoryComment("Server Settings", "Server side settings which can affect gameplay");

            PacketHandler.RegisterPackets();
            channels = getNewChannelHandler(handler.channel);

        	ModBlocks.Init();
        	ModItems.Init();
    	
        	Messages.Init();

        	Crafting.RegisterRecipes();


        	proxy.RegisterListeners();
    	
        	proxy.registerRenderThings();
        
        	proxy.RegisterClientTickhandler();
        	proxy.RegisterServerTickhandler();

            MinecraftForge.EVENT_BUS.register(new InvisibilityEvents());
            FMLCommonHandler.instance().bus().register(new InvisibilityEvents());
            FMLCommonHandler.instance().bus().register(new ConfigChanged());
        
        	//Register Events
        	if(event.getSide() == Side.SERVER)
        		RegisterServerEvents();
        
        	if(event.getSide() == Side.CLIENT)
        		RegisterClientEvents();

            if(event.getSide() == Side.CLIENT) {
                registerRenderer();
                BookRegestration.Register();
            }
        }

        public void RegisterClientEvents()
        {
	
	
        	MinecraftForge.EVENT_BUS.register(new GuiListener());	
        	MinecraftForge.EVENT_BUS.register(new CapeRenderEvent());


            FMLCommonHandler.instance().bus().register(ServerProxy.tickHandlerClient);
        }


        public void RegisterServerEvents()
        {
	


	
        	MinecraftForge.EVENT_BUS.register(new BoneMealEvent());
        	MinecraftForge.EVENT_BUS.register(new DisarmStickEvent());
        	MinecraftForge.EVENT_BUS.register(new GhostBlockBreakEvent());

            FMLCommonHandler.instance().bus().register(ServerProxy.tickHandlerServer);

        }
            
        @EventHandler
        public void Init(FMLInitializationEvent event){

        	proxy.registerRenderers();
    	



    
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


        @SideOnly(Side.CLIENT)
        public static SmallFontRenderer font;

        @SideOnly(Side.CLIENT)
        public void registerRenderer ()
        {
            Minecraft mc = Minecraft.getMinecraft();
            font = new SmallFontRenderer(mc.gameSettings, new ResourceLocation("minecraft:textures/font/ascii.png"), mc.renderEngine, false);
        }

        public static EnumMap<Side, FMLEmbeddedChannel> getNewChannelHandler(String modId)
        {

            EnumMap<Side, FMLEmbeddedChannel> handlers = NetworkRegistry.INSTANCE.newChannel(modId, handler);

            ChannelHandler.PacketExecuter executer = new ChannelHandler.PacketExecuter();

            for(Map.Entry<Side, FMLEmbeddedChannel> e : handlers.entrySet())
            {
                FMLEmbeddedChannel channel = e.getValue();
                String codec = channel.findChannelHandlerNameForType(ChannelHandler.class);
                channel.pipeline().addAfter(codec, "PacketExecuter", executer);
            }

            return handlers;
        }

	}
