package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.*;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerCharger;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerGenerator;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerLaser;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerTeleporter;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerCraftingInv;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerMill;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerPizzaOven;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerSquezer;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerXpStorage;
import com.miscitems.MiscItemsAndBlocks.Container.Magic.ContainerMagicalCharger;
import com.miscitems.MiscItemsAndBlocks.Container.Magic.ContainerMagicalDeconstructor;
import com.miscitems.MiscItemsAndBlocks.Container.Magic.ContainerMagicalInfuser;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiChat;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiComputerScreen;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiGame1Select;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiPlayerFinder;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiCharger;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiGenerator;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiLensBench;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiMetalPress;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiMill;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiSquezer;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiTeleporter;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Gui.Machines.GuiPizzaOven;
import com.miscitems.MiscItemsAndBlocks.Gui.Machines.GuiTrashBin;
import com.miscitems.MiscItemsAndBlocks.Gui.Machines.GuiXpStorage;
import com.miscitems.MiscItemsAndBlocks.Gui.Magic.GuiMagicalCharger;
import com.miscitems.MiscItemsAndBlocks.Gui.Magic.GuiMagicalDeconstructor;
import com.miscitems.MiscItemsAndBlocks.Gui.Magic.GuiMagicalInfuser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.*;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityCardboardBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityOven;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityTrashBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWorktable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityXpStorage;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityMagicalDecontructor;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityMagicalEnergyRecharger;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityMagicalInfuser;
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
        
        
        if(tile_entity instanceof TileEntityOven){
        	
        	return new ContainerPizzaOven(player.inventory, (TileEntityOven) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityElectricFurnace){
        	
        	return new ContainerElectricFurnace(player.inventory, (TileEntityElectricFurnace) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMiningStation){
        	
        	return new ContainerMiningChamber(player.inventory, (TileEntityMiningStation) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityEnergyStorageCube){
        	
        	return new ContainerCharger(player.inventory, (TileEntityEnergyStorageCube) tile_entity);
        }

        
        if(tile_entity instanceof TileEntityXpStorage){

            return new ContainerXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityTrashBin){

            return new ContainerBin(player.inventory, (TileEntityTrashBin) tile_entity);

        }

        
        if(tile_entity instanceof TileEntityCardboardBox){
        	
        	return new ContainerBox(player.inventory, (TileEntityCardboardBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityWorktable){
        	
        	return new ContainerCraftingInv(player.inventory, (TileEntityWorktable) tile_entity);
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


        if(tile_entity instanceof TileEntityMagicalInfuser){

            return new ContainerMagicalInfuser(player.inventory, (TileEntityMagicalInfuser) tile_entity);
        }

        if(tile_entity instanceof TileEntityMagicalEnergyRecharger){

            return new ContainerMagicalCharger(player.inventory, (TileEntityMagicalEnergyRecharger) tile_entity);
        }

        if(tile_entity instanceof TileEntityMagicalDecontructor){

            return new ContainerMagicalDeconstructor(player.inventory, (TileEntityMagicalDecontructor) tile_entity);
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
        

        
        if(tile_entity instanceof TileEntityTrashBin){

            return new GuiTrashBin(player.inventory, (TileEntityTrashBin) tile_entity);

        }

        
        if(tile_entity instanceof TileEntityCardboardBox){
        	
        	return new GuiBox(player.inventory, (TileEntityCardboardBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityWorktable){
        	
        	return new GuiCraftingInv(player.inventory, (TileEntityWorktable) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMill){
        	
        	return new GuiMill(player.inventory, (TileEntityMill) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySquezer){
        	
        	return new GuiSquezer(player.inventory, (TileEntitySquezer) tile_entity);
        }
        
        
        
        if(tile_entity instanceof TileEntityOven){
        	
        	return new GuiPizzaOven(player.inventory, (TileEntityOven) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityEnergyStorageCube){
        	
        	return new GuiCharger(player.inventory, (TileEntityEnergyStorageCube) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySolarPanel){
        	
        	return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityGenerator){
        	
        	return new GuiGenerator(player.inventory, (TileEntityGenerator) tile_entity);
        }
        

        
        if(tile_entity instanceof TileEntityMiningStation){
        	
        	return new GuiMiningChamber(player.inventory, (TileEntityMiningStation) tile_entity);
        }

        if(tile_entity instanceof TileEntityMagicalInfuser){

            return new GuiMagicalInfuser(player.inventory, (TileEntityMagicalInfuser) tile_entity);
        }

        if(tile_entity instanceof TileEntityMagicalEnergyRecharger){

            return new GuiMagicalCharger(player.inventory, (TileEntityMagicalEnergyRecharger) tile_entity);
        }

        if(tile_entity instanceof TileEntityMagicalDecontructor){

            return new GuiMagicalDeconstructor(player.inventory, (TileEntityMagicalDecontructor) tile_entity);
        }



        return null;

    }
    

}
