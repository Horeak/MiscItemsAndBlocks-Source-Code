package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;

import java.util.List;

public class ModItemPizza extends ItemFood{
	
	
	IIcon Pizza;

	public ModItemPizza() {
		super(6, false);
		this.maxStackSize = 1;
		
		this.setPotionEffect(Potion.field_76443_y.id, 10, 2, 1F);

	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	
        
        this.Pizza = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Pizza");


    }
    
    public IIcon getIconFromDamage(int meta)
    {
    		return Pizza;

    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();
    	
    	
    	if(meta == 0)return "item.pizza.1";
    	if(meta == 1)return "item.pizza.2";
    	if(meta == 2)return "item.pizza.3";
    	if(meta == 3)return "item.pizza.4";
    	
    	
    	
    	return null;
    }
    
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        list.add(new ItemStack(par1, 1, 1));
        list.add(new ItemStack(par1, 1, 2));
        list.add(new ItemStack(par1, 1, 3));
        
    }

}
