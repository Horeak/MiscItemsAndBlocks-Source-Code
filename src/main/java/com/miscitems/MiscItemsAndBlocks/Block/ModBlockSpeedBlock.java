package com.miscitems.MiscItemsAndBlocks.Block;

import MiscUtils.Block.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ModBlockSpeedBlock extends ModBlock {

	public ModBlockSpeedBlock() {
		super(Material.rock);
		this.slipperiness = 1.2F;
		this.setHardness(0.7F);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon Top;
    
    @SideOnly(Side.CLIENT)
    private IIcon TextureSide;
    

    
    @SideOnly(Side.CLIENT)

    public IIcon getIcon(int par1, int par2)
    {
    	
        return par1 == 1 ? Top : TextureSide;
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.Top = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "SpeedTop");
        this.TextureSide = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "SpeedSide");
    }
    
 
    
    
    
    


}
