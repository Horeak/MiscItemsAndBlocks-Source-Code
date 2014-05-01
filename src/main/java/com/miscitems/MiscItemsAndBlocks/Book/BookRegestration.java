package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import net.minecraft.item.ItemStack;

public class BookRegestration {

    public static void Register(){



        BookUtils.RegisterTab(1, "Main Page", new ItemStack(ModItems.GuideBook), 1);
        BookUtils.RegisterTab(2, "Misc Blocks Page", new ItemStack(ModBlocks.XpStorage), 2);
        BookUtils.RegisterTab(3, "Electrical Blocks Page", new ItemStack(ModBlocks.Charger), 2);
        BookUtils.RegisterTab(4, "Electrical Items Page", new ItemStack(ModItems.Battery), 2);
        BookUtils.RegisterTab(5, "Items Page", new ItemStack(ModItems.XpExtractor), 2);
        BookUtils.RegisterTab(6, "Other Changes Page", new ItemStack(ModItems.Wrench), 2);

        BookUtils.RegisterTextForTab(1, "This a guide book for MiscItemsAndBlocks which explains all blocks and items in the mod and will also show any recipes added by the mod.");

        BookUtils.RegisterItemsForTab(2, new ItemStack[]{new ItemStack(ModBlocks.XpStorage), new ItemStack(ModBlocks.Bin), new ItemStack(ModBlocks.DisarmTrap), new ItemStack(ModBlocks.SilverOre), new ItemStack(ModBlocks.StoneStair), new ItemStack(ModBlocks.Box), new ItemStack(ModBlocks.CraftingInv), new ItemStack(ModBlocks.Dice), new ItemStack(ModBlocks.SpeedBlock), new ItemStack(ModBlocks.GamePart), new ItemStack(ModBlocks.Pillar), new ItemStack(ModBlocks.Mill), new ItemStack(ModBlocks.Squezer), new ItemStack(ModBlocks.PizzaOven), new ItemStack(ModBlocks.OrangeLog), new ItemStack(ModBlocks.ItemPedestal), new ItemStack(ModBlocks.Table), new ItemStack(ModBlocks.PaintBlock), new ItemStack(ModBlocks.OneWayGlass), new ItemStack(ModBlocks.Computer), new ItemStack(ModBlocks.StorageBlock), new ItemStack(ModBlocks.DiceHolder), new ItemStack(ModBlocks.WireLessRedstone), new ItemStack(ModBlocks.WirelessItemTrans), new ItemStack(ModBlocks.GhostBlock)});
        BookUtils.RegisterItemsForTab(3, new ItemStack[]{new ItemStack(ModBlocks.MachinePart), new ItemStack(ModBlocks.Charger)});
        BookUtils.RegisterItemsForTab(4, new ItemStack[]{new ItemStack(ModItems.Battery), new ItemStack(ModItems.BigBattery)});
        BookUtils.RegisterItemsForTab(5, new ItemStack[]{new ItemStack(ModItems.XpExtractor), new ItemStack((ModItems.Orange))});
    }
}
