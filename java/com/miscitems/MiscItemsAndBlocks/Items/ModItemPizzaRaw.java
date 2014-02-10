package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemPizzaRaw extends ItemFood{
	
	IIcon PizzaRaw;



	public ModItemPizzaRaw() {
		super(1, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
		this.setPotionEffect(Potion.hunger.id, 20, 2, 0.6F);

	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	
        this.PizzaRaw = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PizzaRaw");



    }
    
    public IIcon getIconFromDamage(int meta)
    {
    		return PizzaRaw;
    	
    }
    
    public String getItemDisplayName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return StatCollector.translateToLocal("items.name.pizza.raw.1");
    	if(meta == 1)return StatCollector.translateToLocal("items.name.pizza.raw.2");
    	if(meta == 2)return StatCollector.translateToLocal("items.name.pizza.raw.3");
    	if(meta == 3)return StatCollector.translateToLocal("items.name.pizza.raw.4");
    	
    	
    	
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
