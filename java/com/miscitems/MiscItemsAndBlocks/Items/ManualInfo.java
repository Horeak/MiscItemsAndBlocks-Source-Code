package com.miscitems.MiscItemsAndBlocks.Items;

import mantle.books.BookData;
import mantle.books.BookDataStore;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.w3c.dom.Document;

import com.miscitems.MiscItemsAndBlocks.Proxies.ClientProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ManualInfo
{

    BookData Guide = new BookData();

    public ManualInfo()
    {
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        Guide = initManual(Guide, "miscitems.guide", "\u00a7o" + "MiscItemsAndBlocsk Guide", side == Side.CLIENT ? ClientProxy.Guide : null, "miscitems:book");

    }

    public BookData initManual (BookData data, String unlocName, String toolTip, Document xmlDoc, String itemImage)
    {
        //proxy.readManuals();
        data.unlocalizedName = unlocName;
        data.toolTip = unlocName;
        data.modID = "TConstruct";
        data.itemImage = new ResourceLocation(data.modID, itemImage);
        data.doc = xmlDoc;
        BookDataStore.addBook(data);
        return data;
    }

}