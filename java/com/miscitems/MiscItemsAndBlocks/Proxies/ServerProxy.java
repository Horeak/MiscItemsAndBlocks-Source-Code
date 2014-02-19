package com.miscitems.MiscItemsAndBlocks.Proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerBin;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerBox;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerCharger;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerComputer;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerCraftingInv;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerGenerator;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerLaser;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMill;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerPizzaOven;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerSquezer;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerTeleporter;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerXpStorage;
import com.miscitems.MiscItemsAndBlocks.Tick.ServerTickHandler;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCharger;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCraftingInv;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityOvenCore;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.IGuiHandler;

public class ServerProxy implements IGuiHandler{

	
    public static TickHandlerClient tickHandlerClient;
    public static ServerTickHandler tickHandlerServer;
	
    public void registerRenderThings(){
        
    }
    
    
    public int addArmor(String armor){
        return 0;
    }
    
	public void registerServerTickHandler()
	 {
		
        tickHandlerServer = new ServerTickHandler();
        MinecraftForge.EVENT_BUS.register(tickHandlerServer);
	 }

	
	public void RegisterListeners(){
		
		
	}

	public void registerClientTickHandler() {

		
		
		
	}
	
	public String getMinecraftVersion() {
return Loader.instance().getMinecraftModContainer().getVersion();
}



public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

}

public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

}

public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, Item itemID, int metaData, int stackSize, int color) {

}




@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z) {

    TileEntity tile_entity = world.getTileEntity(x, y, z);
   
    
    if (ID < 0)
        return null;
    
    if(tile_entity instanceof TileEntityComputer){
    	return new ContainerComputer((TileEntityComputer)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityWirelessItemTrans){
    	return new ContainerWirelessItemTransfer(player.inventory, (TileEntityWirelessItemTrans)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityLaser){
    	return new ContainerLaser(player.inventory, (TileEntityLaser)tile_entity);
    }
    
    
    if(tile_entity instanceof TileEntityLensBench){
    	return new ContainerLensBench(player.inventory, (TileEntityLensBench)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityMetalPress){
    	return new ContainerMetalPress(player.inventory, (TileEntityMetalPress)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityTeleporter){
    	return new ContainerTeleporter(player.inventory, (TileEntityTeleporter)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityWirelessRedstone){
    	return new ContainerWirelessRedstone(player.inventory, (TileEntityWirelessRedstone)tile_entity);
    }
    
    if(tile_entity instanceof TileEntityStorageBlock){
    	return new ContainerStorageBlock(player.inventory, (TileEntityStorageBlock)tile_entity);
    }
    
    
    if(tile_entity instanceof TileEntityOvenCore){
    	
    	return new ContainerPizzaOven(player.inventory, (TileEntityOvenCore) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityElectricFurnace){
    	
    	return new ContainerElectricFurnace(player.inventory, (TileEntityElectricFurnace) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityMiningChamber){
    	
    	return new ContainerMiningChamber(player.inventory, (TileEntityMiningChamber) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityCharger){
    	
    	return new ContainerCharger(player.inventory, (TileEntityCharger) tile_entity);
    }

    
    if(tile_entity instanceof TileEntityXpStorage){

        return new ContainerXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

    }
    
    if(tile_entity instanceof TileEntityBin){

        return new ContainerBin(player.inventory, (TileEntityBin) tile_entity);

    }

    
    if(tile_entity instanceof TileEntityBox){
    	
    	return new ContainerBox(player.inventory, (TileEntityBox) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityCraftingInv){
    	
    	return new ContainerCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityMill){
    	
    	return new ContainerMill(player.inventory, (TileEntityMill) tile_entity);
    }
    
    if(tile_entity instanceof TileEntitySquezer){
    	
    	return new ContainerSquezer(player.inventory, (TileEntitySquezer) tile_entity);
    }
    
    if(tile_entity instanceof TileEntitySolarPanel){
    	
    	return new ContainerSolarPanel(player.inventory, (TileEntitySolarPanel) tile_entity);
    }
    
    if(tile_entity instanceof TileEntityGenerator){
    	
    	return new ContainerGenerator(player.inventory, (TileEntityGenerator) tile_entity);
    }

	return null;
}


@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z) {
	return null;
}
}
