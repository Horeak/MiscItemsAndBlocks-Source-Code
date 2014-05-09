package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockXpStorage extends BlockContainer{

	public ModBlockXpStorage() {
		super(Material.iron);

		this.setHardness(7);
		this.setResistance(100000000);

	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "XpStorage" + (Main.HDTextures ? "_16" : ""));
		   
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
    
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityXpStorage();
	}
	
	   @Override
	    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
	    {

	    	TileEntity tile_e = World.getTileEntity(x, y, z);
	    	
	    	if(tile_e != null && tile_e instanceof TileEntityXpStorage){
	    		TileEntityXpStorage tile = (TileEntityXpStorage)tile_e;
	    	
	    		ItemStack stack = new ItemStack(ModBlocks.XpStorage);
	    		
	    		if(tile.XpAmount > 0){
	    		stack.setTagCompound(new NBTTagCompound());
	    		
	    		stack.stackTagCompound.setInteger("Levels", tile.XpAmount);
	    		}
   		
	    		
	    	
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
   				super.breakBlock(World, x, y, z, id, meta);
   			}
   				
   				
	    }

}
	   
	   
	    public int quantityDropped(Random p_149745_1_)
	    {
	        return 0;
	    }
}
