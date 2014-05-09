package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDisarmTrap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockDisarmTrap extends BlockContainer{

	private Block BlockBelow;
	
	protected ModBlockDisarmTrap() {
		super(Material.iron);
		setHardness(8);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.1F, 1F);
	}


	
	 
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {

    	if(player.isSneaking()){

    	}else{
    		
        player.inventory.dropAllItems();	
    	    	
    	}
            return true;
        }
    
    
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		
		return world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}
    
 
    
    
    
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}

	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
}
    
    
    
    public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon(Refrence.Mod_Id + ":DisarmTrap");
}
    
    
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {

		int Meta = world.getBlockMetadata(x, y, z);
		
		if(Meta == 0){
		
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			
           world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.5F);
			
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			
			if(!player.capabilities.isCreativeMode){
			player.inventory.dropAllItems();
			entity.attackEntityFrom(new DamageSource("step.disarm"), 2);
			}
		}else{
			if(entity instanceof EntityItem){
				
		}else{
			entity.attackEntityFrom(new DamageSource("step.disarm"), 2);
			
			
		}
		}
		
		}
		
		
	}
	
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float par6) {
    	
    	onEntityWalking(world, x, y, z, entity);
			
    	
    }
    
    

	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityDisarmTrap();
	}
	
    public void onNeighborBlockChange(World world, int x, int y, int z, int BlockId)
    {
    	
    	if(world.doesBlockHaveSolidTopSurface(world, x, y - 1, z) == false){
    		
    		Random rand = new Random();
    		
    		world.setBlock(x, y, z, Blocks.air);
    		world.spawnEntityInWorld(new EntityItem(world, x + rand.nextInt(3), y + rand.nextInt(3), z + rand.nextInt(3), new ItemStack(ModBlocks.DisarmTrap)));
    	}
    	


    }
    
    
    

    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote)
        {
        	onEntityWalking(world, x, y, z, entity);
            
        }
    }
    
    
    
    
		
    }




