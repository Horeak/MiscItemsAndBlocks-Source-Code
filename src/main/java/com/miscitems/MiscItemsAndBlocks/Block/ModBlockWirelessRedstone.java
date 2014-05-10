package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockWirelessRedstone extends BlockContainer{

	IIcon IconSide;
	IIcon IconOn;
	IIcon IconOff;
	
	protected ModBlockWirelessRedstone() {
		super(Material.iron);
		this.setHardness(1.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityWirelessRedstone();
	}

	
    public void registerBlockIcons(IIconRegister register)
    {
    	IconSide = register.registerIcon(Refrence.Mod_Id + ":" + "WireLessRedstoneSide");
    	IconOn = register.registerIcon(Refrence.Mod_Id + ":" + "WireLessRedstoneOn");
    	IconOff = register.registerIcon(Refrence.Mod_Id + ":" + "WireLessRedstoneOff");
    	
    	
    }
    
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 || par1 == 0 ? IconSide : par2 == 0 ? IconOff : IconOn;
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
        	
            return true;
        }
        else
        {
        	
        	
        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
            return true;
        }
    }
    
    public int isProvidingWeakPower(IBlockAccess access, int x, int y, int z, int side)
    {
    	if(access.getBlockMetadata(x, y, z) == 1){
    		return 16;
    	}
    	
        return 0;
    }
    
    public boolean canProvidePower()
    {
        return true;
    }
    
    
    public int isProvidingStrongPower(IBlockAccess access, int x, int y, int z, int side)
    {
    	if(access.getBlockMetadata(x, y, z) == 1){
    		return 16;
    	}
    	
        return 0;
    }
    
    
    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
    {
		TileEntity tile = World.getTileEntity(x, y, z);
		
		if(tile != null && tile instanceof IInventory){
			IInventory inv = (IInventory)tile;
			
			for(int i = 0; i < inv.getSizeInventory(); i++){
				ItemStack stack = inv.getStackInSlotOnClosing(i);
				
				if(stack != null){
					float spawnX = x + World.rand.nextFloat();
					float spawnY = y + World.rand.nextFloat();
					float spawnZ = z + World.rand.nextFloat();
					
					
					EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
					
					float mult = 0.05F;
					
					droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
					droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
					
					
					World.spawnEntityInWorld(droppedItem);
					

					
				}
				
			}
			super.breakBlock(World, x, y, z, id, meta);
			
		}

}
}
