package com.miscitems.MiscItemsAndBlocks.Proxies;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.GamePart.GamePartItemRender;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiListener;
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
import com.miscitems.MiscItemsAndBlocks.Misc.ItemHelper;
import com.miscitems.MiscItemsAndBlocks.Network.PacketRequestEvent;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTypeHandler;
import com.miscitems.MiscItemsAndBlocks.Render.PowerArrowRender;
import com.miscitems.MiscItemsAndBlocks.Render.SilverArrowRender;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;
import com.miscitems.MiscItemsAndBlocks.TileEntity.ModTileEntity;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityBinRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityComputerRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityDiceHolderRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityGamePartRender;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.TileEntityItemPedestalRender;
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


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerCable.class, new TileEntityPowerCableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPedestal.class, new TileEntityItemPedestalRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningChamber.class, new TileEntityMiningChamberRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePart.class, new TileEntityGamePartRender());

        
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

       // PacketDispatcher.sendPacketToServer(PacketTypeHandler.populatePacket(new PacketRequestEvent(eventType, originX, originY, originZ, sideHit, rangeX, rangeY, rangeZ, data)));
    }


    @Override
    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, Item itemID, int metaData, int stackSize, int color) {

     World world = FMLClientHandler.instance().getClient().theWorld;
//        TileEntity tileEntity = world.getTileEntity(x, y, z);
//
//        this.handleTileEntityPacket(x, y, z, orientation, state, customName);
//
//        if (tileEntity != null) {
//            if (tileEntity instanceof TileEntityItemPedestal) {
//
//                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
//                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
//                    ItemHelper.setColor(itemStack, color);
//                }
//
//                ((TileEntityItemPedestal) tileEntity).setInventorySlotContents(0, itemStack);
//                world.updateAllLightTypes(x, y, z);
//            }
//            
//            if (tileEntity instanceof TileEntityMiningChamber) {
//
//                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
//                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
//                    ItemHelper.setColor(itemStack, color);
//                }
//
//                ((TileEntityMiningChamber) tileEntity).setInventorySlotContents(0, itemStack);
//                world.updateAllLightTypes(x, y, z);
//            }
//            
//          
//        }
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




}
