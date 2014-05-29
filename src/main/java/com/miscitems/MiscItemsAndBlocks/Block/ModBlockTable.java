package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockTable extends BlockContainer{

	protected ModBlockTable() {
		super(Material.wood);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityTable();
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
        this.blockIcon = icon.registerIcon(Refrence.Mod_Id + ":Table");
}
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	
    	if(player.inventory.getCurrentItem() != null){
    	if(player.inventory.getCurrentItem().getItem() == new ItemStack(Blocks.carpet).getItem()){


            ((TileEntityTable)world.getTileEntity(x,y,z)).Color = 15 - player.inventory.getCurrentItem().getItemDamage();

    		if(world.getBlockMetadata(x, y, z) > 0){
    			return true;
    		}
    		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.5F);
    	}else{
    		if(world.getBlockMetadata(x, y, z) >= 1){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.7F);
    		}
    	}
    	}else{
    		if(world.getBlockMetadata(x, y, z) >= 1){
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "step.cloth", 0.8F, 0.7F);
    		}
    	}
    	
    	return true;
    }
}
