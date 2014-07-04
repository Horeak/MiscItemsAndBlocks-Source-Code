package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGamePart;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;

public class ModBlockGamePart extends BlockContainer{


	
	public ModBlockGamePart(){
		super(Material.rock);
		this.setHardness(1F);
	}

    public String getUnlocalizedName()
    {
        return "tile.gamepart";
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
				
		return new TileEntityGamePart();
		}
	
    public int damageDropped(int par1)
    {
        return par1;
    }
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}


    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x,y-1,z) == null || world.getBlock(x,y-1,z) == Blocks.air){
            world.setBlock(x,y-1,z,world.getBlock(x,y,z), world.getBlockMetadata(x,y,z), 2);
            world.setBlock(x,y,z,Blocks.air);
        }

    }
	
    @Override
    public int getRenderType() {
            return -1;
    }
	@Override
    public boolean renderAsNormalBlock() {
        return false;
}


	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

    	blockIcon = par1IconRegister.registerIcon("stone");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        int Meta;
    	Block Id = world.getBlock(x, y, z);
        
    	if(player.inventory.getCurrentItem() == null){
    	
    	int DirectionMath = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
    	
    	String Direction = DirectionMath == 0 ? "south" : DirectionMath == 1 ? "west" : DirectionMath == 2 ? "north" : "east";
    	
		  
		  Meta = world.getBlockMetadata(x, y, z);
      
    	if(Direction == "south"){
    		
  		  if(world.getBlockMetadata(x, y, z + 1) == Meta && Id == ModBlocks.GamePart && world.getBlock(x, y + 1, z + 1) == Blocks.air){
			  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x, y + 1, z + 1, ModBlocks.GamePart, Meta, 2);
    		  
		  }else{
    	  
    	  if(world.getBlock(x, y, z + 1) == Blocks.grass || world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.air ){
    		  

    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x, y, z + 1, ModBlocks.GamePart, Meta, 2);
    	  }
    		  
    	  
    	  }
    	}
    	  
    	  
    	  

    	if(Direction == "west"){
    		
  		  if(world.getBlockMetadata(x - 1, y, z) == Meta && Id == ModBlocks.GamePart && world.getBlock(x - 1, y + 1, z) == Blocks.air){
			  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x - 1, y + 1, z, ModBlocks.GamePart, Meta, 2);
    		  
		  }else{
    	  
    	  if(world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x - 1, y,z) == Blocks.air){

    		  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x - 1, y, z, ModBlocks.GamePart, Meta , 2);

    	  }
    		  
    	  
    	  }
    	}
    	  
      if(Direction == "north"){
    	  
		  
		  if(world.getBlockMetadata(x, y, z - 1) == Meta && Id == ModBlocks.GamePart && world.getBlock(x, y + 1, z - 1) == Blocks.air){
			  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x, y + 1, z - 1, ModBlocks.GamePart, Meta , 2);
    		  
		  }else{
			  
    	  if(world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.air){

    		  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x, y, z - 1, ModBlocks.GamePart, Meta , 2);
    		  
    		  
    		  
    	  }
    		  
    	  }
      }
    	  
      if(Direction == "east"){
    	  
		  
		  if(world.getBlockMetadata(x + 1, y, z) == Meta && Id == ModBlocks.GamePart && world.getBlock(x + 1, y + 1, z) == Blocks.air){
			  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x + 1, y + 1, z, ModBlocks.GamePart, Meta , 2);
    		  
		  }else{
    	  
    	  if(world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x + 1, y,z) == Blocks.air){
    		  
    		  world.setBlock(x, y, z, Blocks.air);
    		  world.setBlock(x + 1, y, z, ModBlocks.GamePart, Meta , 2);

    		  }
    		  
    	  }
      }
    	  
    	  
    	
    	}else{
    		return false;
    	}
    	
        return true;
    }
    
    public void onBlockAdded(World world, int x, int y, int z) {
    	
		 blockFall(world, x, y, z);

    	
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int nId) {

		 blockFall(world, x, y, z);
    	
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
    	
		 int Meta = block.getBlockMetadata(x, y, z);
    	Block Id = block.getBlock(x, y, z);
    	
    	
		 if(block.getBlockMetadata(x, y + 1, z) == Meta && block.getBlockMetadata(x, y - 1, z) == Meta && Id == ModBlocks.GamePart){
				this.setBlockBounds(0.2F, 0, 0.2F, 0.8F, 1, 0.8F);
		 }else{
				this.setBlockBounds(0.1F, 0, 0.1F, 0.9F, 1, 0.9F);
		 }
    	
    }
    
    public void blockFall(World world, int x, int y, int z){

    	
    	if(world.getBlock(x, y - 1, z) == Blocks.air || world.getBlock(x, y - 1, z) == Blocks.water){
    		
    		Block Block = world.getBlock(x, y, z);
    		int Meta = world.getBlockMetadata(x, y, z);
    		
    		world.setBlock(x, y, z, Blocks.air);
    		world.setBlock(x, y - 1, z, Block, Meta, 2);
    		
    	}

    	
    }
    
    
    public void getSubBlocks(Item id, CreativeTabs tabs, List list)
    {

        for(int i = 0; i < 16; i++){
            list.add(new ItemStack(id, 1, i));
        }
        
    }


    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
    {
        int Meta = block.getBlockMetadata(x,y,z);

        return new Color(ItemDye.field_150922_c[15 - Meta]).getRGB();

    }

}



    