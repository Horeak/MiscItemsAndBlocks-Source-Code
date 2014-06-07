package com.miscitems.MiscItemsAndBlocks.Proxies;


import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.GuiListener;
import com.miscitems.MiscItemsAndBlocks.GamePart.GamePartItemRender;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.ItemRender.*;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Render.PowerArrowRender;
import com.miscitems.MiscItemsAndBlocks.Render.SilverArrowRender;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;
import com.miscitems.MiscItemsAndBlocks.TileEntity.*;
import com.miscitems.MiscItemsAndBlocks.TileEntityRenderer.*;
import com.miscitems.MiscItemsAndBlocks.Utils.Colours;
import com.miscitems.MiscItemsAndBlocks.Utils.ItemHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;


public class ClientProxy extends ServerProxy {



    public void RegisterClientTickhandler(){
        tickHandlerClient = new TickHandlerClient();
    }

    public static boolean HasValidInvisibilityArmor = false;

    public void registerRenderThings() {
	

    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrashBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerCable.class, new TileEntityPowerCableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPedestal.class, new TileEntityItemPedestalRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningStation.class, new TileEntityMiningChamberRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePart.class, new TileEntityGamePartRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaser.class, new TileEntityLaserRender());

        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPillar.class, new TileEntityPillarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new TileEntityTableRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputer.class, new TileEntityComputerRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiceHolder.class, new TileEntityDiceHolderRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, new TileEntityTeleporterRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetalPress.class, new TileEntityMetalPressRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaserReciver.class, new TileEntityLaserReciverRender());
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
        RenderingRegistry.registerEntityRenderingHandler(EntityPowerArrow.class, new PowerArrowRender());
        
        //Register Custom Item Models
        
        if(!Main.config.get("Client Settings", "Disable custom item models. (If you are getting a OutOfMemoryException crash or lagging when looking a items with custom model)", false).getBoolean(false)){
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
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.LaserReciver).getItem(), new LaserReciverItemRender());
        }
        Main.config.save();
}
    
        
    
    @SideOnly(Side.CLIENT)
    @Override
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

    
	public void RegisterListeners(){
		
		MinecraftForge.EVENT_BUS.register(new GuiListener());
	}
    
    @Override
    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {


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
            
            if (tileEntity instanceof TileEntityMiningStation) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
                    ItemHelper.setColor(itemStack, color);
                }

                ((TileEntityMiningStation) tileEntity).setInventorySlotContents(0, itemStack);
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






    
    
    public ItemStack Stack(Item item){
    	return new ItemStack(item, 1 ,0);
    }
    
    public ItemStack Stack(Block block){
    	return new ItemStack(block, 1 ,0);
    }



}
