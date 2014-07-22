package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemWrench;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModBlockEnergyStorageCube extends ModBlockContainer {

	public IIcon InIcon;
	public IIcon OutIcon;
	
	
	public ModBlockEnergyStorageCube() {
		super(Material.iron);
		this.setHardness(3);
	}
	
	
    public int getRenderType()
    {
        return 31;
    }

    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
    int rotation = BlockPistonBase.determineOrientation(par1World, x, y, z, par5EntityLiving);
    par1World.setBlockMetadataWithNotify(x, y, z, rotation, 2);
    }

	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.InIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "ChargerSideIn" + (ConfigUtils.HDTextures ? "_16" : ""));
		   this.OutIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "ChargerSideOut" + (ConfigUtils.HDTextures ? "_16" : ""));
		   
	   }
	   
	   
	   
	   @Override
	   public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
	   int meta = LaserUtil.getOrientation(world.getBlockMetadata(x, y, z));

	   if (meta > 5)
	   return getSideIcon(0);
	   if (side == meta)
	   return getTopIcon(0);
	   else
	   	return getSideIcon(0);
	   	
	       }

	   @Override
	   @SideOnly(Side.CLIENT)
	   public IIcon getIcon(int side, int meta) {
	   int rotation = 3;

	   if (rotation > 5)
	   return getTopIcon(0);
	   if (side == rotation)
	   return getTopIcon(0);
	   else
	   return getSideIcon(0);
	   }

		@Override
		public TileEntity createNewTileEntity(World world, int i) {
			return new TileEntityEnergyStorageCube();
		}
		
	    @SideOnly(Side.CLIENT)
	    protected  IIcon getSideIcon(int var1)
	    {
	    	return InIcon;
	    }

	    @SideOnly(Side.CLIENT)
	    protected IIcon getTopIcon(int p_150161_1_)
	    {
	        return OutIcon;
	    }
		
	    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int side, float par7, float par8, float par9)
	    {
	    	if(par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().getItem() instanceof ModItemWrench){
	    		if(par5EntityPlayer.isSneaking()){
	    			par1World.setBlockMetadataWithNotify(par2, par3, par4, ForgeDirection.getOrientation(side).getOpposite().ordinal(), 2);
	    		}else{
	    		par1World.setBlockMetadataWithNotify(par2, par3, par4, side, 2);
	    		}
	    		return true;
	    	}
	    	
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
	    public void breakBlock(World World, int x, int y, int z, Block block, int meta)
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
	    	}
			super.breakBlock(World, x, y, z, block, meta);
	    }

}
