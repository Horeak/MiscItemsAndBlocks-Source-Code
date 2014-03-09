package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockGhostBlock extends BlockContainer{

	protected ModBlockGhostBlock() {
		super(Material.glass);
		this.setStepSound(soundTypeCloth);
	
	}
	

	
	IIcon defaultTexture;
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityGhostBlock();
	}

	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	
    	if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){
    		TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);

    		if(player.getHeldItem() != null){
    			if(player.getHeldItem().getItem() instanceof ItemBlock){
    				Block block = Block.getBlockById(Item.getIdFromItem(player.getHeldItem().getItem()));
    				if(block.hasTileEntity(player.getHeldItem().getItemDamage()))
                        return true;


    				if(block != null && block != Blocks.air){
    					tile.Camo = block;
    					tile.Meta = player.getHeldItem().getItemDamage();
    					

    	    			world.markBlockForUpdate(x, y, z);
    	    			
    					return true;
    				}
    				
    			}
    		}else{
    			tile.Camo = null;
    			

    			world.markBlockForUpdate(x, y, z);
				return true;
    		}
    		
    	}
    	
    	
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
    	
    	if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){
    		TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);
    		
    		if(tile.Camo != null){
    			
    			return tile.Camo.getIcon(side, tile.Meta);
    		}
    		
    	}
    	
    	return defaultTexture;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	
    	return defaultTexture;
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	defaultTexture = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "GhostBlock");
    	
    }
    
    public int getRenderBlockPass()
    {
        return 1;
    }
    

   public boolean renderAsNormalBlock()
   {
       return false;
   }
   
	
   public boolean isOpaqueCube()
   {
       return false;
   }
   
   
    
}
