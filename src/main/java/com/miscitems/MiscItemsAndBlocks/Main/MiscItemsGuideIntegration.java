package com.miscitems.MiscItemsAndBlocks.Main;

import MiscUtils.GuideBase.Utils.GuideInstance;
import MiscUtils.GuideBase.Utils.GuideTab;
import MiscUtils.GuideBase.Utils.ModGuideText;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MiscItemsGuideIntegration extends GuideInstance {

    @Override
    public ResourceLocation BlockDescriptions() {
        return new ResourceLocation(Reference.Mod_Id.toLowerCase(), "guide/blockinfo.txt");
    }

    @Override
    public ResourceLocation ItemDescriptions() {
        return new ResourceLocation(Reference.Mod_Id.toLowerCase(), "guide/iteminfo.txt");
    }

    @Override
    public String ModPageName() {
        return "guide.miscitems.name";
    }

    @Override
    public ItemStack ModPageDisplay() {
        return new ItemStack(Main.config.GetCheckedItem(ModItems.GuideBook));
    }

    @Override
    public String ModDescription() {
        return "MiscItemsAndBlocks is a mod which just adds alot of random items and blocks to game with some being useful while others can be usless and pointless. ";
    }

    ModGuideText MainTab;
    GuideTab BlocksTab;
    GuideTab ItemsTab;

    @Override
    public void RegisterInfo() {
        MainTab = new ModGuideText(this, Items.paper, "guide.miscitems.tab.main");
        BlocksTab = new GuideTab(this, ModBlocks.Box, "guide.miscitems.tab.blocks");
        ItemsTab = new GuideTab(this, ModItems.SilverIngot, "guide.miscitems.tab.items");

        for(Object r : Block.blockRegistry) {
            Block bl = (Block) r;
            if (bl != null) {
                GameRegistry.UniqueIdentifier id = GameRegistry.findUniqueIdentifierFor(bl);
                if (id != null & id.modId.equalsIgnoreCase(Reference.Mod_Id)) {
                    if (bl.getCreativeTabToDisplayOn() != null) {
                        BlocksTab.Register(bl);
                    }
                }
            }
        }


        for(Object r : Item.itemRegistry) {
            Item itm = (Item) r;
            if (itm != null && !(itm instanceof ItemBlock)) {
                GameRegistry.UniqueIdentifier id = GameRegistry.findUniqueIdentifierFor(itm);
                if (id != null & id.modId.equalsIgnoreCase(Reference.Mod_Id)) {
                    if (itm.getCreativeTab() != null) {
                        ItemsTab.Register(itm);
                    }
               }
            }
        }



        RegisterTab(MainTab);
        RegisterTab(BlocksTab);
        RegisterTab(ItemsTab);
    }
}
