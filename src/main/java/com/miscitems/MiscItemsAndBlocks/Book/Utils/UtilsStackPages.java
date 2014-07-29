package com.miscitems.MiscItemsAndBlocks.Book.Utils;

import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import net.minecraft.item.ItemStack;

public class UtilsStackPages {

   public ItemStack item;
   public Page[] pages;

    public UtilsStackPages(ItemStack stack, Page[] pages){
        this.item = stack;
        this.pages = pages;

    }
}
