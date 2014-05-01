package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ModItemXpExtractor extends Item{

	@SuppressWarnings("unused")
	private static EntityPlayer player;
	
	private IIcon _icon1;
private IIcon _icon2;
private IIcon _icon3;
	
	public ModItemXpExtractor() {
		super();

        this.maxStackSize = 1;
        this.setUnlocalizedName("XpExtractor");
       
	}
	
	
    public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer player)
    {

    	
    	if(player.experienceLevel > 0 ){
    	
    		if(player.inventory.hasItem(Items.glass_bottle) || player.capabilities.isCreativeMode){
    			
    			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
    			
    	
    	}
    	
    	}
    	
        return stack;
    }
    

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	
    	_icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "XpExtractor" + ".1");
    	_icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "XpExtractor" + ".2");
    	_icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "XpExtractor" + ".3");
    	
    	itemIcon = _icon1;
    }
    
	@Override
public EnumAction getItemUseAction(ItemStack stack)
{
return EnumAction.bow;
}
	
	@Override
public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
{

		if(player.experienceLevel > 0 && player.inventory.hasItem(Items.glass_bottle) || player.capabilities.isCreativeMode)

		{

			player.addExperienceLevel(-1);

			player.inventory.consumeInventoryItem(Items.glass_bottle);

			if(!player.inventory.addItemStackToInventory(new ItemStack(Items.experience_bottle)))

			{

				player.dropItem(Items.experience_bottle, 1);

			}

		}
return stack;
}
	
	@Override

	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)

	{

		if(usingItem != null && usingItem.getItem() == this)

		{

			if(useRemaining > 24)  return _icon1;

			if(useRemaining > 12) return _icon2;

			return _icon3;

		}

		return _icon1;

	}
	
	@Override
public int getMaxItemUseDuration(ItemStack stack)
{
return 32;
}
	
    @SuppressWarnings("unchecked")
	@Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean par4)
    {
            list.add(StatCollector.translateToLocal("items.desc.xpextractor.1") + ": ");
            list.add("1." +  StatCollector.translateToLocal("items.desc.xpextractor.2"));
            list.add("2." + StatCollector.translateToLocal("items.desc.xpextractor.3"));
    }
    
    
    

}
