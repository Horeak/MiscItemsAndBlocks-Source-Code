package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ModItemIronPlate extends Item{

	IIcon[] Textures = new IIcon[5];
	
	public ModItemIronPlate() {
		super();
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	
        this.Textures[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "IronPlate");
        this.Textures[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "RawIronPlate");
        this.Textures[2] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "HardIronPlate");

    }
    
    public IIcon getIconFromDamage(int meta)
    {

    	return Textures[meta];

    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return "item.ironplate.1";
    	if(meta == 1)return "item.ironplate.2";
    	if(meta == 2)return "item.ironplate.3";
    	
    	
    	
    	return null;
    }
    
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        list.add(new ItemStack(par1, 1, 1));
        list.add(new ItemStack(par1, 1, 2));
        
    }
	   

}
