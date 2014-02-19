package com.miscitems.MiscItemsAndBlocks.Proxies;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.GamePart.GamePartItemRender;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiBox;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiCharger;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiChat;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiComputerScreen;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiCraftingInv;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame1Select;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_2;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiGenerator;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiLaser;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiLensBench;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiListener;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiMetalPress;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiMill;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiPaintBrush;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiPizzaOven;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiPlayerFinder;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiSquezer;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiTeleporter;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiTrashBin;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiXpStorage;
import com.miscitems.MiscItemsAndBlocks.ItemRender.ComputerItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.DiceHolderItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.DisarmTrapItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.ItemPedestalItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.ItemRenderMetalPress;
import com.miscitems.MiscItemsAndBlocks.ItemRender.MiningChamberItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.PillarItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.PowerCableItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.TableItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.TeleporterItemRender;
import com.miscitems.MiscItemsAndBlocks.ItemRender.TrashBinItemRender;
import com.miscitems.MiscItemsAndBlocks.Lib.Colours;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.ItemHelper;
import com.miscitems.MiscItemsAndBlocks.Network.PacketRequestEvent;
import com.miscitems.MiscItemsAndBlocks.Render.PowerArrowRender;
import com.miscitems.MiscItemsAndBlocks.Render.SilverArrowRender;
import com.miscitems.MiscItemsAndBlocks.Render.SmallFontRenderer;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;
import com.miscitems.MiscItemsAndBlocks.TileEntity.ModTileEntity;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCharger;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCraftingInv;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityOvenCore;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityBinRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityComputerRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityDiceHolderRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityGamePartRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityItemPedestalRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityLaserRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityMetalPressRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityMiningChamberRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityPillarRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityPowerCableRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityTableRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityTeleporterRender;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends ServerProxy {


    public static final int ComputerID = 3;
    public static final int ChatID = 2;
    public static final int PlayerFindID = 4;
    public static final int TicTacToeID = 5;
    public static final int MasterMindID = 6;
    public static int manualGuiID = -1;
	
    public static SmallFontRenderer smallFontRenderer;
    public void registerRenderThings() {
	
	
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.getTextureManager() == null)
        	Main.logger.error("vanilla texture man is null");
        if (mc.renderEngine == null)
            Main.logger.error("vanilla render engine is null");
        smallFontRenderer = new SmallFontRenderer(mc.gameSettings, new ResourceLocation("minecraft:textures/font/ascii.png"), mc.renderEngine, false);
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerCable.class, new TileEntityPowerCableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPedestal.class, new TileEntityItemPedestalRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningChamber.class, new TileEntityMiningChamberRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePart.class, new TileEntityGamePartRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaser.class, new TileEntityLaserRender());

        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPillar.class, new TileEntityPillarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new TileEntityTableRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputer.class, new TileEntityComputerRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiceHolder.class, new TileEntityDiceHolderRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, new TileEntityTeleporterRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetalPress.class, new TileEntityMetalPressRender());
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
        RenderingRegistry.registerEntityRenderingHandler(EntityPowerArrow.class, new PowerArrowRender());
        
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.Bin).getItem(), new TrashBinItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.ItemPedestal).getItem(), new ItemPedestalItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.MiningChamber).getItem(), new MiningChamberItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.Pillar).getItem(), new PillarItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.PowerCable).getItem(), new PowerCableItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.DisarmTrap).getItem(), new DisarmTrapItemRender());
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.Computer).getItem(), new ComputerItemRender());
        
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.GamePart).getItem(), new GamePartItemRender());
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.Table).getItem(), new TableItemRender());
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.DiceHolder).getItem(), new DiceHolderItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.Teleporter).getItem(), new TeleporterItemRender());
        
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.MetalPress).getItem(), new ItemRenderMetalPress());

}
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    @Override
    public void registerClientTickHandler()
    {
    	
        tickHandlerClient = new TickHandlerClient();
        MinecraftForge.EVENT_BUS.register(tickHandlerClient);

    }
    
    
	public void RegisterListeners(){
		
		MinecraftForge.EVENT_BUS.register(new GuiListener());
	}
    
    @Override
    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

  
    Main.NETWORK_MANAGER.sendPacketToServer(new PacketRequestEvent(eventType, originX, originY, originZ, sideHit, rangeX, rangeY, rangeZ, data));
    }


    @Override
    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, Item itemID, int metaData, int stackSize, int color) {

     World world = FMLClientHandler.instance().getClient().theWorld;
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        this.handleTileEntityPacket(x, y, z, orientation, state, customName);

        if (tileEntity != null) {
            if (tileEntity instanceof TileEntityItemPedestal) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
                    ItemHelper.setColor(itemStack, color);
                }

                ((TileEntityItemPedestal) tileEntity).setInventorySlotContents(0, itemStack);
            }
            
            if (tileEntity instanceof TileEntityMiningChamber) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
                    ItemHelper.setColor(itemStack, color);
                }

                ((TileEntityMiningChamber) tileEntity).setInventorySlotContents(0, itemStack);
            }
            
          
        }
    }
    
    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof ModTileEntity) {
                ((ModTileEntity) tileEntity).setOrientation(orientation);
                ((ModTileEntity) tileEntity).setState(state);
                ((ModTileEntity) tileEntity).setCustomName(customName);
            }
        }
    }



    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
    		int x, int y, int z) {
    	
    	
    	
    	
//        if (ID == manualGuiID)
//        {
//            ItemStack stack = player.getCurrentEquippedItem();
//            if (stack == null)
//                Main.logger.error("stack null in book");
//            if (stack != null && stack.getItem() == null)
//            	 Main.logger.error("item null in book");
//            if (stack != null && stack.getItem() != null && stack.getItem().getUnlocalizedName() == null)
//            	 Main.logger.error("unlocalized name null in book");
//            else
//            {
//
//                return new GuiManual(stack, ClientProxy.getBookDataFromStack(stack));
//            }
//            
//        }
    	
 TileEntity tile_entity = world.getTileEntity(x, y, z);

        
        
        switch(ID){
        
        case ChatID:
        	return new GuiChat(player.inventory, null);
        	
        case PlayerFindID:
        	return new GuiPlayerFinder();

        case TicTacToeID:
        	
            	return new GuiGame1Select();
            	
        case MasterMindID:
        	
        	return new GuiGame_2();
            	
        }
        

        
        if(tile_entity instanceof TileEntityLensBench){
        	return new GuiLensBench(player.inventory, (TileEntityLensBench)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityWirelessRedstone){
        	return new GuiWirelessRedstone(player.inventory, (TileEntityWirelessRedstone)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityLaser){
        	return new GuiLaser(player.inventory, (TileEntityLaser)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityWirelessItemTrans){
        	return new GuiWirelessItemTransfer(player.inventory, (TileEntityWirelessItemTrans)tile_entity);
        }

        if(tile_entity instanceof TileEntityMetalPress){
        	return new GuiMetalPress(player.inventory, (TileEntityMetalPress)tile_entity);
        }

        if(tile_entity instanceof TileEntityTeleporter){
        	return new GuiTeleporter(player.inventory, (TileEntityTeleporter)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityStorageBlock){
        	return new GuiStorageBlock(player.inventory, (TileEntityStorageBlock)tile_entity);
        }

        
        if(tile_entity instanceof TileEntityComputer){
        	return new GuiComputerScreen((TileEntityComputer)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityXpStorage){
            return new GuiXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityElectricFurnace){
            return new GuiElectricFurnace(player.inventory, (TileEntityElectricFurnace) tile_entity);

        }
        
        if(ID == 1){
        	return new GuiPaintBrush(player.inventory.getCurrentItem());
        }
        

        
        if(tile_entity instanceof TileEntityBin){

            return new GuiTrashBin(player.inventory, (TileEntityBin) tile_entity);

        }

        
        if(tile_entity instanceof TileEntityBox){
        	
        	return new GuiBox(player.inventory, (TileEntityBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCraftingInv){
        	
        	return new GuiCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMill){
        	
        	return new GuiMill(player.inventory, (TileEntityMill) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySquezer){
        	
        	return new GuiSquezer(player.inventory, (TileEntitySquezer) tile_entity);
        }
        
        
        
        if(tile_entity instanceof TileEntityOvenCore){
        	
        	return new GuiPizzaOven(player.inventory, (TileEntityOvenCore) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCharger){
        	
        	return new GuiCharger(player.inventory, (TileEntityCharger) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySolarPanel){
        	
        	return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityGenerator){
        	
        	return new GuiGenerator(player.inventory, (TileEntityGenerator) tile_entity);
        }
        

        
        if(tile_entity instanceof TileEntityMiningChamber){
        	
        	return new GuiMiningChamber(player.inventory, (TileEntityMiningChamber) tile_entity);
        }


        
    	return null;
    }

}
