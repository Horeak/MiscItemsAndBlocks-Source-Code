package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.Lib.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemWrench extends Item{

	public ModItemWrench() {
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Wrench");
		   
	   }
	   
	   
	    public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	    {
	        return true;
	    }
	    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	
	    	Block block = world.getBlock(x, y, z);
	    	
	    	if(block instanceof ModBlockPowerCable){
	    	if(!world.isRemote){
	    		
	    		
		    	int Meta = world.getBlockMetadata(x, y, z);


		    	
		    		if(player.isSneaking()){
		    			if(Meta > 0){
		    	    		world.setBlockMetadataWithNotify(x, y, z, Meta - 1, 2);
		    		    	Meta = world.getBlockMetadata(x, y, z);
		    	    	}
		    	    	
		    			ChatMessageHandler.sendChatToPlayer(player, ModBlockPowerCable.messages[Meta]);

		    			
		    		}
		    	}
	    	}

	    	
	    	return true;
	    }
}
