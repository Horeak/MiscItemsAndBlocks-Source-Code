package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

import java.util.*;

public class ModItemUpgrades extends ModItemUpgradeItem{

	IIcon[] icons = new IIcon[10];
	
	public ModItemUpgrades() {
		super();
		this.maxStackSize = 16;

	}


	public IIcon getIconFromDamage(int meta)
	{
			return icons[meta];

	}


    public String getUnlocalizedName(ItemStack stack)
    {

        int meta = stack.getItemDamage();


        if(meta == 0)return "powerupgrade";



        return null;
    }

	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
	{
	    super.getSubItems(par1, par2CreativeTabs, list);
	    
	    
	}


}
