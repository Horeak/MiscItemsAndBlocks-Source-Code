package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ModItemUpgrades extends ModItemUpgradeItem{

	IIcon[] icons = new IIcon[10];
	
	public ModItemUpgrades() {
		super();
		this.maxStackSize = 16;

	}


	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{


	    this.icons[0] = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "PowerUpgrade");



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
