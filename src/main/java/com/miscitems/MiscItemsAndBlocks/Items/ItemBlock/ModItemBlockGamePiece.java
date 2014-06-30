package com.miscitems.MiscItemsAndBlocks.Items.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModItemBlockGamePiece extends ItemBlock{

	public ModItemBlockGamePiece(Block par1) {
		super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}



    public int getMetadata(int par1)
    {
        return par1;
    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();
    	

    	
    	return "item.GamePart.Number." + meta;
    }
    
    
	IIcon Blank, Red, Blue, Green, Yellow;
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
    
    	
    	if(meta == 0)
    		return Blank;
    	
    	if(meta == 1)
    		return Red;
    	
    	if(meta == 2)
    		return Blue;
    	
    	if(meta == 3)
    		return Green;
    	
    	if(meta == 4)
    		return Yellow;
    	
    	
        return  Red;
    }
	
    public void registerIcons(IIconRegister par1IconRegister)
    {

    	Blank = par1IconRegister.registerIcon(Reference.Mod_Id + ":BlankPillar");
    	Red = par1IconRegister.registerIcon(Reference.Mod_Id + ":RedPillar");
    	Blue = par1IconRegister.registerIcon(Reference.Mod_Id + ":BluePillar");
    	Green = par1IconRegister.registerIcon(Reference.Mod_Id + ":GreenPillar");
    	Yellow = par1IconRegister.registerIcon(Reference.Mod_Id + ":YellowPillar");
    }
}
