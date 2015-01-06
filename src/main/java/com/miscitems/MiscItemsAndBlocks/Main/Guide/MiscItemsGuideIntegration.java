package com.miscitems.MiscItemsAndBlocks.Main.Guide;

import MiscUtils.GuideBase.Utils.GuideInstance;
import MiscUtils.GuideBase.Utils.GuideTab;
import MiscUtils.GuideBase.Utils.ModGuideText;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
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
        return new ItemStack(Main.config.GetCheckedBlock(ModBlocks.ItemPedestal));
    }

    @Override
    public String ModDescription() {
        return "MiscItemsAndBlocks is a mod which just adds alot of random items and blocks to game with some being useful while others can be usless and pointless. The mod has features related to electrical systems, decorations, magic and a few more minor things. In the end the mod is just a collection of a buch of random blocks and items that might not fit very well together but they are there in case anyone might find them useful. ";
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
                if (id != null && id.modId != null && id.modId.equalsIgnoreCase(Reference.Mod_Id)) {
                    if (bl.getCreativeTabToDisplayOn() != null) {
                        BlocksTab.Register(bl);
                    }
                }
            }
        }

        BlocksTab.Register(ModBlocks.Pillar);


        for(Object r : Item.itemRegistry) {
            Item itm = (Item) r;
            if (itm != null && !(itm instanceof ItemBlock)) {
                GameRegistry.UniqueIdentifier id = GameRegistry.findUniqueIdentifierFor(itm);
                if (id != null && id.modId != null && id.modId.equalsIgnoreCase(Reference.Mod_Id)) {
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
