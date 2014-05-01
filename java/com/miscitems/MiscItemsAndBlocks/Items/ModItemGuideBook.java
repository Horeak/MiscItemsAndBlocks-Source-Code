package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Book.MainPage;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ModItemGuideBook extends Item {

	public ModItemGuideBook() {

		this.setUnlocalizedName("guidebook");
		this.setMaxStackSize(1);
	}

    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	
    	list.add("\u00a7o" + "MiscItemsAndBlocks Guide");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        player.openGui(Main.instance, GuiHandler.manualGuiID, world, 0, 0, 0);
        FMLClientHandler.instance().displayGuiScreen(player, new MainPage());
        return stack;
    }
	
}
