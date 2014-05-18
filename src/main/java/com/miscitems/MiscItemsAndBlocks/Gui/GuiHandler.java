package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.*;
import com.miscitems.MiscItemsAndBlocks.TileEntity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

    TileEntityXpStorage tile = null;
    
    public static final int ComputerID = 3;
    public static final int ChatID = 2;
    public static final int PlayerFindID = 4;
    public static final int TicTacToeID = 5;
    public static final int MasterMindID = 6;
    public static int manualGuiID = -1;
	
    @Override

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

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

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

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