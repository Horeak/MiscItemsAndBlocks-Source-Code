package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockDice extends ModBlock {

	IIcon Dice1;
	IIcon Dice2;
	IIcon Dice3;
	IIcon Dice4;
	IIcon Dice5;
	IIcon Dice6;
	
	IIcon[] icons;
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return false;
    }
	public ModBlockDice() {
		super(Material.wood);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	
    	this.Dice1 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice1");
    	this.Dice2 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice2");
    	this.Dice3 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice3");
    	this.Dice4 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice4");
    	this.Dice5 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice5");
    	this.Dice6 = par1IconRegister.registerIcon(Reference.Mod_Id + ":Dice6");
    	
    	
    	this.blockIcon = Dice1;
    	
    	icons = new IIcon[]{Dice1, Dice2, Dice3, Dice4, Dice5, Dice6};
    	
    }

    
    
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {

        return icons[par2];
        
        
    }
    

}
