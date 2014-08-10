package com.miscitems.MiscItemsAndBlocks.Main;

import MiscUtils.Network.ChannelHandler;
import com.google.common.collect.Sets;
import com.miscitems.MiscItemsAndBlocks.Book.BookRegestration;
import com.miscitems.MiscItemsAndBlocks.Book.SmallFontRenderer;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.BoneMealEvent;
import com.miscitems.MiscItemsAndBlocks.Event.DisarmStickEvent;
import com.miscitems.MiscItemsAndBlocks.Event.GhostBlockBreakEvent;
import com.miscitems.MiscItemsAndBlocks.Event.GuiListener;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientChatMessageRecivedPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketBegin;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketInviteRecived;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketRestart;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGhostBlockPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientLaserUpdatePacket;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientMetalPressPacketUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerButtonPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerChatMessagePacket;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketAccept;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketClosed;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketInvite;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerLensBenchPacketDone;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerPaintBrushChangePacket;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerSetBlockPacket;
import com.miscitems.MiscItemsAndBlocks.Utils.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.Crafting;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.DefaultLaser;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.Proxies.ServerProxy;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;


	@Mod(modid = Reference.Mod_Id, name = Reference.Mod_Name, version = Reference.Version, guiFactory = "MiscUtils.Utils.Config.GuiConfigFactory", dependencies = "after:NEI;required-after:MiscUtils")
	public class Main 
	{

	
		@Instance(Reference.Mod_Id)
		public static Main instance = new Main();
    
		@SidedProxy(clientSide = "com.miscitems.MiscItemsAndBlocks.Utils.Proxies.ClientProxy", serverSide = "com.miscitems.MiscItemsAndBlocks.Utils.Proxies.ServerProxy")
		public static ServerProxy proxy;


        public static Set EmptyToolSet = Sets.newHashSet();

        public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("MiscItems");

        public static CreativeTabs MiscTab = new CreativeTabs("tabMiscMisc")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ConfigUtils.GetCheckedItem(ModItems.GuideBook);
            }

        };

        public static CreativeTabs DecorativeTab = (new CreativeTabs("tabMiscDeco")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {

                return ItemBlock.getItemFromBlock(ConfigUtils.GetCheckedBlock(ModBlocks.GamePart));

            }


        });


        public static CreativeTabs ElectricTab = new CreativeTabs("tabMiscElectric")
        {


            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem()
            {
                return ItemBlock.getItemFromBlock(ConfigUtils.GetCheckedBlock(ModBlocks.Charger));
            }

        };




        public static EnumMap<Side, FMLEmbeddedChannel> channels;

        public static ChannelHandler handler = new ChannelHandler(Reference.Channel);

	
        @EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {

             ConfigUtils.InitConfig(event.getModConfigurationDirectory() + "");


            RegisterPackets();
            channels = getNewChannelHandler(handler.channel);

            if(ConfigUtils.AllowCustomPillars) {
                PillarUtils.RegisterBlackList();
                PillarUtils.RegisterBlocks(event.getSide());
            }

        	ModBlocks.Init();
        	ModItems.Init();

        	Messages.Init();

        	Crafting.RegisterRecipes();



        	proxy.RegisterListeners();

        	proxy.registerRenderThings();

        	proxy.RegisterClientTickhandler();
        	proxy.RegisterServerTickhandler();


            EntityRegistry.registerGlobalEntityID(EntitySilverArrow.class, "SilverArrow", EntityRegistry.findGlobalUniqueEntityId());
            EntityRegistry.registerModEntity(EntitySilverArrow.class, "SilverArrow", 0, this, 128, 1, true);

            EntityRegistry.registerGlobalEntityID(EntityPowerArrow.class, "PowerArrow", EntityRegistry.findGlobalUniqueEntityId());
            EntityRegistry.registerModEntity(EntityPowerArrow.class, "PowerArrow", 1, this, 128, 1, true);






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



        
        	GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 3);
        
        	MinecraftForge.addGrassSeed(new ItemStack(ModItems.TomatoSeeds), 10);
        
        

        	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        

        }


        public static void RegisterPackets(){


            Main.handler.RegisterPacket(ClientChatMessageRecivedPacket.class);
            Main.handler.RegisterPacket(ClientGamePacketBegin.class);
            Main.handler.RegisterPacket(ClientGamePacketChange.class);
            Main.handler.RegisterPacket(ClientGamePacketInviteRecived.class);
            Main.handler.RegisterPacket(ClientGamePacketRestart.class);
            Main.handler.RegisterPacket(ClientGhostBlockPacket.class);
            Main.handler.RegisterPacket(ClientLaserUpdatePacket.class);
            Main.handler.RegisterPacket(ClientMetalPressPacketUpdate.class);

            Main.handler.RegisterPacket(ServerButtonPacket.class);
            Main.handler.RegisterPacket(ServerChatMessagePacket.class);
            Main.handler.RegisterPacket(ServerGamePacketAccept.class);
            Main.handler.RegisterPacket(ServerGamePacketChange.class);
            Main.handler.RegisterPacket(ServerGamePacketClosed.class);
            Main.handler.RegisterPacket(ServerGamePacketInvite.class);
            Main.handler.RegisterPacket(ServerLensBenchPacketDone.class);
            Main.handler.RegisterPacket(ServerPaintBrushChangePacket.class);
            Main.handler.RegisterPacket(ServerSetBlockPacket.class);

            Main.handler.RegisterPacket(PacketTileUpdate.class);
            Main.handler.RegisterPacket(PacketTileWithItemUpdate.class);


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
