package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemWrench;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPowerCable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockPowerCable extends BlockContainer{

	protected ModBlockPowerCable() {
		super(Material.iron);
		this.setHardness(2);
		 this.setBlockBounds(0.23F, 0.23F, 0.23F, 0.75F, 0.75F, 0.75F);
	}
	
	public static String[] messages = new String[]{"[PowerCable]The cable will now connect to everything.",
			                         "[PowerCable]The cable will not connect to machines.",
			                         "[PowerCable]The cable will not connect to other cables.",
			                         "[PowerCable]The cable will not connect to chargers.",
			                         "[PowerCable]The cable is now in private mode.",
			                         "[PowerCable]The cable is now in private-public mode."
			};
	
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

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPowerCable();
	}

    	
	
	  @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PowerCable");
		   
	   }
	  
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
	    

	if(!world.isRemote){
	    		
	    		
		    	int Meta = world.getBlockMetadata(x, y, z);
		    	if(player.inventory.getCurrentItem() != null){
		    	
		    	if(player.inventory.getCurrentItem().getItem() instanceof ModItemWrench){

		    	
		    	if(Meta < 5){
		    		world.setBlockMetadataWithNotify(x, y, z, Meta + 1, 2);
			    	Meta = world.getBlockMetadata(x, y, z);
		    	}else{
		    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			    	Meta = world.getBlockMetadata(x, y, z);
		    	}
		    	
		    		player.addChatMessage(IChatComponent.Serializer.func_150699_a(ModBlockPowerCable.messages[Meta]));

		    	
		    	}
		    	}
		    	}
		    	
	    	
	    	
	    	return player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemWrench;
	    }
    }
    	


