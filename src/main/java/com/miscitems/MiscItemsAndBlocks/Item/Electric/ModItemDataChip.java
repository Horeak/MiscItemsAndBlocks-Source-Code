package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ModItemDataChip extends Item{

	IIcon[] icons = new IIcon[2];
	
	public ModItemDataChip() {
		super();
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.icons[0] = par1IconRegister.registerIcon(Reference.Mod_Id + ":DataChipEmpty");
		   this.icons[1] = par1IconRegister.registerIcon(Reference.Mod_Id + ":DataChipFull");
		   
	   }
	   
	    public IIcon getIconFromDamage(int meta)
	    {
	    	
	    	return icons[meta];
	    	
	    }
	    
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	if(itemstack.stackTagCompound == null){
	    		list.add("No Data Stored.");
	    		
	    	}else{
	    		
	    		list.add(itemstack.stackTagCompound.getString("DataType") + " Data Stored on Chip.");

	    	}
	    	
	    	
	    	
	    }
	    
	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	    {

	    	if(!world.isRemote){
	    	if(player.isSneaking() && item.getItemDamage() == 1){
	    		item.setTagCompound(null);
	    		item.setItemDamage(0);
	    		ChatMessageHandler.sendChatToPlayer(player, "Removed Data from Chip");
	    		
	    	}
	    	}
	    	
	    	return item;
	    }
}
