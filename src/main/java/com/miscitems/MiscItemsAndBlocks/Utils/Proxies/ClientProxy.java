package com.miscitems.MiscItemsAndBlocks.Utils.Proxies;


import MiscUtils.TileEntity.ModTileEntity;
import com.miscitems.MiscItemsAndBlocks.Entity.EntityPowerArrow;
import com.miscitems.MiscItemsAndBlocks.Entity.EntitySilverArrow;
import com.miscitems.MiscItemsAndBlocks.Event.GuiListener;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaserReciver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityTrashBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.Entity.PowerArrowRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.Entity.SilverArrowRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.ComputerItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.DiceHolderItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.DisarmTrapItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.GamePartItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.ItemPedestalItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.ItemRenderMetalPress;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.LaserReciverItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.MetalBrickItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.MiningChamberItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.PaintBlockItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.PillarItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.PowerCableItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.TableItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.TeleporterItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender.TrashBinItemRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityBinRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityComputerRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityDiceHolderRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityGamePartRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityItemPedestalRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityLaserReciverRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityLaserRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityMetalPressRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityMiningChamberRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityPillarRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityPowerCableRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityTableRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer.TileEntityTeleporterRender;
import com.miscitems.MiscItemsAndBlocks.Utils.Tickhandler.TickHandlerClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
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


    @Override
    public EntityPlayer getPlayer() {

        return FMLClientHandler.instance().getClientPlayerEntity();
    }

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
        
        if(!Main.config.DisableCustomItemModels){
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


        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.ColoredBrick).getItem(), new MetalBrickItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.ColoredBrickGlowstone).getItem(), new MetalBrickItemRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(ModBlocks.PaintBlock).getItem(), new PaintBlockItemRender());


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

                ((TileEntityItemPedestal) tileEntity).setInventorySlotContents(0, itemStack);
            }
            
            if (tileEntity instanceof TileEntityMiningStation) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);

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
