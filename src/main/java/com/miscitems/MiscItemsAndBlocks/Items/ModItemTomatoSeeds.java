package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;

public class ModItemTomatoSeeds extends ItemSeeds implements IPlantable{

	public ModItemTomatoSeeds(Block par2, Block par3) {
		super(par2, par3);
        this.setCreativeTab(Main.MiscTab);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":TomatoSeeds");
		   
	   }


}
