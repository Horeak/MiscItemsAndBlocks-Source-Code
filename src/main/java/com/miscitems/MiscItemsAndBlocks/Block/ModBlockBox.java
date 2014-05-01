package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBox;
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
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockBox extends BlockContainer{

	public IIcon TopIcon;
	public IIcon SideIcon;
	
	public ModBlockBox() {
		super(Material.wood);
		this.setStepSound(soundTypeWood);
		this.setHardness(0.5F);
	}
	
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Box");
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxTop");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxSide");
		   
	   }
	   
	    public IIcon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.blockIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }


		@Override
		public TileEntity createNewTileEntity(World world, int i) {
			return new TileEntityBox();
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
	    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
	    {

	    	TileEntity tile_e = World.getTileEntity(x, y, z);
	    	
	    	if(tile_e != null && tile_e instanceof TileEntityBox){
	    		TileEntityBox tile = (TileEntityBox)tile_e;
	    	
	    		ItemStack stack = new ItemStack(ModBlocks.Box);
	    		
	    		stack.setTagCompound(new NBTTagCompound());

	
	    			NBTTagList Items = new NBTTagList();
    		

	        		for (int i = 0; i < tile.getSizeInventory(); i++){
	        			
	        			ItemStack stack1 = tile.getStackInSlot(i);
	        			if(stack1 != null){
	        				
	        				NBTTagCompound item = new NBTTagCompound();
	        				item.setByte("Slot", (byte)i);
	        				stack1.writeToNBT(item);
	        				Items.appendTag(item);
	        			}
	        		}

    		
    				stack.stackTagCompound.setTag("Items", Items);
    		
	    	
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
}
