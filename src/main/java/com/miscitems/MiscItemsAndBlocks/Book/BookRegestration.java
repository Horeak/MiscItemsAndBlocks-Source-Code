package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import com.miscitems.MiscItemsAndBlocks.Book.Pages.RecipeSmallPage;
import com.miscitems.MiscItemsAndBlocks.Book.Pages.TextPage;
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
        BookUtils.RegisterItemsForTab(3, new ItemStack[]{new ItemStack(ModBlocks.MachinePart), new ItemStack(ModBlocks.Charger), new ItemStack(ModBlocks.SolarPanel), new ItemStack(ModBlocks.WindMill), new ItemStack(ModBlocks.Generator), new ItemStack(ModBlocks.ElectricFurnace), new ItemStack(ModBlocks.PowerCable), new ItemStack(ModBlocks.MetalPress), new ItemStack(ModBlocks.LensBench), new ItemStack(ModBlocks.Laser), new ItemStack(ModBlocks.LaserReciver), new ItemStack(ModBlocks.MiningChamber), new ItemStack(ModBlocks.Teleporter)});
        BookUtils.RegisterItemsForTab(4, new ItemStack[]{new ItemStack(ModItems.Drill), new ItemStack(ModItems.Circuit, 1, 0), new ItemStack(ModItems.CableItem), new ItemStack(ModItems.SolarCells), new ItemStack(ModItems.Turbine), new ItemStack(ModItems.Battery), new ItemStack(ModItems.BigBattery), new ItemStack(ModItems.AdvancedBattery), new ItemStack(ModItems.ElectricShears), new ItemStack(ModItems.ElectricBow), new ItemStack(ModItems.Upgrades, 1, 0), new ItemStack(ModItems.Wrench), new ItemStack(ModItems.IronPlate), new ItemStack(ModItems.HeatDrill), new ItemStack(ModItems.FloatBlockPlacer), new ItemStack(ModItems.AntiFallChestPlate), new ItemStack(ModItems.InfoScreenHelmet), new ItemStack(ModItems.DataChip), new ItemStack(ModItems.Lens)});
        BookUtils.RegisterItemsForTab(5, new ItemStack[]{new ItemStack(ModItems.XpExtractor), new ItemStack(ModItems.SilverIngot), new ItemStack(ModItems.SilverSword), new ItemStack(ModItems.SilverBow), new ItemStack(ModItems.DivingHelmet), new ItemStack(ModItems.FlightChestPlate), new ItemStack(ModItems.RunningLeggings), new ItemStack(ModItems.JumpingBoots), new ItemStack(ModItems.Cardboard), new ItemStack(ModItems.Tomato), new ItemStack(ModItems.Flour), new ItemStack(ModItems.PizzaBottom), new ItemStack(ModItems.Liquid), new ItemStack(ModItems.Cheese), new ItemStack(ModItems.Orange), new ItemStack(ModItems.DisarmStick), new ItemStack(ModItems.PaintBrush)});


//        BookUtils.RegisterInfoPage("test_page_1", 1);
//        BookUtils.RegisterInfoPage("test_page_2", 2);
//        BookUtils.RegisterInfoPage("test_page_3", 3);
//        BookUtils.RegisterInfoPage("test_page_4", 4);
//
//        BookUtils.RegisterRecipeForInfoPage("test_page_2", new ItemStack(ModItems.Cheese));
//
//        BookUtils.RegisterTextForInfoPage("test_page_1", "This is a test page ");

        BookUtils.RegisterPagesForItem(new ItemStack(ModBlocks.XpStorage), new Page[]{new TextPage("Test_Page_1"), new RecipeSmallPage(new ItemStack(ModItems.Cheese))});
    }
}
