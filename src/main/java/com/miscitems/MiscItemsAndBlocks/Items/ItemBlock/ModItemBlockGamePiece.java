package com.miscitems.MiscItemsAndBlocks.Items.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

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

    public String getItemStackDisplayName(ItemStack stack)
    {
        return StatCollector.translateToLocal("item.fireworksCharge." + ItemDye.field_150923_a[15 - stack.getItemDamage()]) + " " + StatCollector.translateToLocal(stack.getItem().getUnlocalizedName() + ".name");
    }


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":BlankPillar");

    }


}
