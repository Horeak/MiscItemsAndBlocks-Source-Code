package com.miscitems.MiscItemsAndBlocks.Items;

import BookCode_mantle.books.BookData;
import BookCode_mantle.client.gui.GuiManual;
import BookCode_mantle.items.abstracts.CraftingItem;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Proxies.ClientProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ModItemGuideBook extends CraftingItem{

	public ModItemGuideBook() {
		super(new String[]{"Guide"}, new String[]{"book"}, "", "miscitems", Main.MiscTab);
		this.setUnlocalizedName("guidebook");
		this.setMaxStackSize(1);
	}

    private BookData getData (ItemStack stack)
    {
    	return ClientProxy.manualData.Guide;
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
        player.openGui(Main.instance, BookCode_mantle.client.MProxyClient.manualGuiID, world, 0, 0, 0);
        FMLClientHandler.instance().displayGuiScreen(player, new GuiManual(stack, getData(stack)));
        return stack;
    }
	
}
