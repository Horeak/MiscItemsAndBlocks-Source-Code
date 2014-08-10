package com.miscitems.MiscItemsAndBlocks.Utils;

import MiscItemsApi.Recipes.RecipeHandler;
import MiscUtils.Utils.CraftingUtils;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;

public class Crafting {

	public static void RegisterRecipes(){
        CraftingUtils Utils = new CraftingUtils(Main.config);

        //Squeezer Recipes
        RecipeHandler.RegisterSqueezerRecipe(new ItemStack(ModItems.Liquid, 1, 0), new Object[]{Items.glass_bottle, Items.apple});
        RecipeHandler.RegisterSqueezerRecipe(new ItemStack(ModItems.Liquid, 1, 1), new Object[]{Items.bucket, ModItems.Tomato});
        RecipeHandler.RegisterSqueezerRecipe(new ItemStack(ModItems.Liquid, 1, 2), new Object[]{Items.glass_bottle, ModItems.Orange});
        RecipeHandler.RegisterSqueezerRecipe(new ItemStack(ModItems.Liquid, 1, 3), new Object[]{Items.glass_bottle, Items.carrot});

        //Mill Recipes
        RecipeHandler.RegisterMillRecipe(Items.wheat, ModItems.Flour);
        RecipeHandler.RegisterMillRecipe(Items.rotten_flesh, Items.leather);

        //Metal Press Recipes
        RecipeHandler.RegisterMetalPressRecipe(new ItemStack(ModItems.IronPlate, 1, 0), new Object[]{Items.iron_ingot}, 1);
        RecipeHandler.RegisterMetalPressRecipe(new ItemStack(ModItems.IronPlate, 1, 2), new Object[]{Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot}, 2);


        //NBT ItemStacks
        ItemStack FullBat = new ItemStack(ModItems.Battery); ((ModItemPowerTool)FullBat.getItem()).AddPower(FullBat, ((ModItemPowerTool) FullBat.getItem()).MaxPower(FullBat));
        ItemStack FullBigBat = new ItemStack(ModItems.BigBattery); ((ModItemPowerTool)FullBigBat.getItem()).AddPower(FullBigBat, ((ModItemPowerTool) FullBigBat.getItem()).MaxPower(FullBigBat));
        ItemStack FullAdvancedBat = new ItemStack(ModItems.AdvancedBattery); ((ModItemPowerTool)FullAdvancedBat.getItem()).AddPower(FullAdvancedBat, ((ModItemPowerTool) FullAdvancedBat.getItem()).MaxPower(FullAdvancedBat));




	    Utils.AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 1), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 1)});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 2), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 2)});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 3), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 4)});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.Cheese), Items.milk_bucket);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
        Utils.AddShapelessRecipe(new ItemStack(ModBlocks.DiceHolder, 1, 0), new Object[]{ModBlocks.ItemPedestal, ModBlocks.Dice});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
        Utils.AddShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Items.paper, Items.paper, Items.paper});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.SilverIngot, 9), new Object[]{ModBlocks.SilverBlock});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_fished);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_porkchop);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_beef);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_chicken);
        Utils.AddShapelessRecipe(new ItemStack(ModBlocks.LensBench), ModItems.Lens, ModBlocks.Worktable);
        Utils.AddShapelessRecipe(new ItemStack(ModItems.BigBattery), new Object[]{new ItemStack(ModItems.Battery), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.Battery),});
        Utils.AddShapelessRecipe(FullBigBat, new Object[]{FullBat, new ItemStack(ModItems.Circuit, 1, 1), FullBat});
        Utils.AddShapelessRecipe(new ItemStack(ModItems.AdvancedBattery), new Object[]{new ItemStack(ModItems.BigBattery), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.BigBattery)});
        Utils.AddShapelessRecipe(FullAdvancedBat, new Object[]{FullBigBat, new ItemStack(ModItems.Circuit, 1, 1), FullBigBat});

        Utils.AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Worktable, new Object[]{"WWW", "PIP", "PCP", 'W', Blocks.wool, Character.valueOf('P'), "plankWood", 'C', Blocks.chest, 'I', Blocks.crafting_table}));
        Utils.AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Items.dye}));
        Utils.AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));
        Utils.AddShapedOreRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Items.stick, Character.valueOf('P'), "plankWood"}));

        Utils.AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlock, 32), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, Character.valueOf('S'), "ingotSilver"}));
        Utils.AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlock, 4), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, Character.valueOf('S'), "nuggetSilver"}));
        Utils.AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Lens), new Object[]{"ISI", "SGS", "ISI", 'I', Items.iron_ingot, Character.valueOf('S'), "nuggetSilver", 'G', Blocks.glass_pane}));

        Utils.AddRecipe(new ItemStack(ModBlocks.Worktable), new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, 'P', Blocks.planks, 'C', Blocks.chest, 'I', Blocks.crafting_table});
        Utils.AddRecipe(new ItemStack(ModBlocks.Dice), new Object[]{"PPP", "PDP", "PPP", 'P', Blocks.planks, 'D', Items.dye});
        Utils.AddRecipe(new ItemStack(ModBlocks.Table), new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), 'P', Blocks.planks, 'H', Blocks.wooden_slab});
        Utils.AddRecipe(new ItemStack(ModItems.Turbine), new Object[]{"S S", " P ", "S S", 'S', Items.stick, 'P', Blocks.planks});


        Utils.AddRecipe(new ItemStack(ModItems.GuideBook), new Object[]{"BP", "SP", 'B', Items.book, 'P', Items.paper, 'S', Items.string});
        Utils.AddRecipe(new ItemStack(ModItems.DataChip, 2),new Object[]{"CCC", "CGC", "III", 'C', ModItems.Cardboard, 'G', new ItemStack(ModItems.Circuit, 1, 0), 'I', Items.iron_ingot});
        Utils.AddRecipe(new ItemStack(ModBlocks.Teleporter), new Object[]{"HCH", "BEB", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullAdvancedBat, 'E', Items.ender_pearl});
        Utils.AddRecipe(new ItemStack(ModBlocks.WireLessRedstone, 2), new Object[]{"IEI", "ERE", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'E', Items.ender_pearl, 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
        Utils.AddRecipe(new ItemStack(ModBlocks.WirelessItemTrans, 2),new Object[]{"POP", "CEC", "POP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'O', Blocks.obsidian, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'E', Items.ender_pearl});
        Utils.AddRecipe(new ItemStack(ModBlocks.MetalPress), new Object[]{"IPI", "CBC", "IAI", 'I', new ItemStack(ModItems.IronPlate, 1,0), 'P', Blocks.piston, 'C', new ItemStack(ModItems.Circuit), 'B', Blocks.iron_block, 'A', Blocks.anvil});
        Utils.AddRecipe(new ItemStack(ModBlocks.SilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', ModItems.SilverIngot});
        Utils.AddRecipe(new ItemStack(ModBlocks.Computer),new Object[]{"IBI", "PCB", "IBT", 'I', Items.iron_ingot, 'B', Blocks.iron_block, 'P', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'R', Items.redstone, 'T', Blocks.redstone_block});
        Utils.AddRecipe(new ItemStack(ModBlocks.StorageBlock), new Object[]{"ICI", "CBC", "ICI", 'I', Blocks.iron_block, 'C', Blocks.chest, 'B', ModBlocks.Box});
        Utils.AddRecipe(new ItemStack(ModBlocks.OneWayGlass, 8), new Object[]{"SSS", "GES", "SSS", 'S', Blocks.stone, 'G', Blocks.glass, 'E', Items.ender_pearl});
        Utils.AddRecipe(new ItemStack(ModItems.XpExtractor), new Object[] {" D ", "IGI", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', Items.diamond});
        Utils.AddRecipe(new ItemStack(ModBlocks.XpStorage), new Object[] {"BIB", "IEI", "BIB", 'I', Blocks.obsidian, 'B', Blocks.iron_block, 'E', ModItems.XpExtractor});
        Utils.AddRecipe(new ItemStack(ModItems.SilverIngot), new Object[] {"NNN", "NNN", "NNN", 'N', ModItems.SilverNugget});
        Utils.AddRecipe(new ItemStack(ModItems.SilverSword), new Object[] {" I ", " I ", " S ", 'I', ModItems.SilverIngot, 'S', Items.stick});
        Utils.AddRecipe(new ItemStack(ModItems.SilverBow), new Object[] {" IS", "I S", " IS", 'I', ModItems.SilverIngot, 'S', Items.string});
        Utils.AddRecipe(new ItemStack(ModItems.SilverBow), new Object[] {"SI ", "S I", "SI ", 'I', ModItems.SilverIngot, 'S', Items.string});
        Utils.AddRecipe(new ItemStack(ModItems.SilverArrow, 8), new Object[] {" N ", " S ", " F ", 'N', ModItems.SilverNugget, 'S', Items.stick, 'F', Items.feather});
        Utils.AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"S  ", "SS ", "SSS", 'S', Blocks.stone});
        Utils.AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"  S", " SS", "SSS", 'S', Blocks.stone});
        Utils.AddRecipe(new ItemStack(ModBlocks.DisarmTrap),new Object[] {"IHI", "HPH", "IDI", 'I', Items.iron_ingot, 'H', Blocks.hopper, 'P', Blocks.heavy_weighted_pressure_plate, 'D', Blocks.dispenser});
        Utils.AddRecipe(new ItemStack(ModBlocks.Bin), new Object[] {"I I", "IBI", " I ", 'I', Items.iron_ingot, 'B', Items.bucket});
        Utils.AddRecipe(new ItemStack(ModBlocks.Box), new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
        Utils.AddRecipe(new ItemStack(ModItems.DivingHelmet), new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Items.nether_star, 'G', Blocks.glass});
        Utils.AddRecipe(new ItemStack(ModItems.RunningLeggings), new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Items.nether_star});
	    Utils.AddRecipe(new ItemStack(ModItems.JumpingBoots), new Object[] {"   ", "S S", "D D", 'D', Items.diamond, 'S', ModItems.SilverIngot});
		Utils.AddRecipe(new ItemStack(ModBlocks.PaintBlock, 8),new Object[]{"CCC", "CSC", "CCC", 'C', Blocks.wool, 'S', Items.stick});
		Utils.AddRecipe(new ItemStack(ModBlocks.SpeedBlock, 32), new Object[]{"III", "BDB", "BBB", 'I', Blocks.ice, 'B', Blocks.iron_block, 'D', Items.diamond});
		Utils.AddRecipe(new ItemStack(ModBlocks.Mill),new Object[]{"CSC", "SPS", "CCC", 'C', Blocks.cobblestone, 'S', Blocks.stone, 'P', Blocks.piston});			Utils.AddRecipe(new ItemStack(ModItems.PizzaBottom), new Object[]{"FFF", 'F', ModItems.Flour});
		Utils.AddRecipe(new ItemStack(ModBlocks.Squezer), new Object[]{"CIC", "IPI", "CCC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot, 'P', Blocks.piston});
		Utils.AddRecipe(new ItemStack(ModBlocks.Oven), new Object[] {"SSS", "SFS", "SSS", 'S', Blocks.stone, 'F', Blocks.furnace});
		Utils.AddRecipe(new ItemStack(ModItems.PaintBrush), new Object[]{"  C", " S ", "S  ", 'C', Blocks.wool, 'S', Items.stick});
		Utils.AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 4), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 5), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 4)});
		Utils.AddRecipe(new ItemStack(ModBlocks.MachinePart), new Object[]{"PPP", "P P", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModItems.IronPlate, 2, 0), new Object[]{"II ", "II ", 'I', Items.iron_ingot});
		Utils.AddRecipe(new ItemStack(ModItems.IronPlate, 1, 2), new Object[]{"II ", "II ", 'I', new ItemStack(ModItems.IronPlate, 1, 1)});
		Utils.AddRecipe(new ItemStack(ModItems.Wrench), new Object[]{"P P", " P ", " P ", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModItems.Upgrades, 3, 0), new Object[]{"PPP", "BBB", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'B', FullBat});
        Utils.AddRecipe(new ItemStack(ModBlocks.ItemPedestal, 2), new Object[]{"I I", " S ", "SSS", 'I', Items.iron_ingot, 'S', Blocks.stone});
		Utils.AddRecipe(new ItemStack(ModBlocks.MiningChamber), new Object[]{"ICI", "IMI", " P ", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'P', Items.diamond_pickaxe, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
		Utils.AddRecipe(new ItemStack(ModItems.Drill), new Object[]{"DD ", "DSI", " IP", 'D', Items.diamond, 'P', FullBat, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', new ItemStack(ModItems.Circuit, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModItems.HeatDrill), new Object[]{"CFP", "FDF", "PFK", 'C', new ItemStack(ModItems.Circuit, 1, 1), 'F', Items.fire_charge, 'D', ModItems.Drill, 'K', Blocks.furnace, 'P', new ItemStack(ModItems.IronPlate, 1, 2)});
		Utils.AddRecipe(new ItemStack(ModItems.Battery), new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
        Utils.AddRecipe(new ItemStack(ModItems.ElectricShears), new Object[]{"ISI", "IBI", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.shears, 'B', FullBat, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModItems.ElectricBow), new Object[]{" IS", "ICB", " IS", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.string, 'C', new ItemStack(ModItems.Circuit), 'B', FullBat});
		Utils.AddRecipe(new ItemStack(ModItems.Circuit, 1, 1), new Object[]{"IGI", "RCR", "IGI", 'I', new ItemStack(Items.dye, 1, 4), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Items.redstone, 'G', Items.glowstone_dust});
		Utils.AddRecipe(new ItemStack(ModItems.Circuit, 1, 0), new Object[]{"WIW", "IRI", "WIW", 'W', ModItems.Cardboard, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
		Utils.AddRecipe(new ItemStack(ModItems.CableItem, 16), new Object[]{"CSC", "PRP", "CSC", 'C', new ItemStack(Blocks.carpet), 'S', new ItemStack(Items.string), 'P', new ItemStack(ModItems.IronPlate, 1, 0), 'R', new ItemStack(Items.redstone)});
		Utils.AddRecipe(new ItemStack(ModItems.SolarCells), new Object[]{"IGI", "GCG", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'G', Blocks.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
		Utils.AddRecipe(new ItemStack(ModBlocks.Charger), new Object[]{"ICI", "RMR", "IRI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'R', new ItemStack(ModItems.Battery), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
		Utils.AddRecipe(new ItemStack(ModBlocks.SolarPanel), new Object[]{"IGI", "GMG", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
		Utils.AddRecipe(new ItemStack(ModBlocks.WindMill), new Object[]{"III", "SMS", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
		Utils.AddRecipe(new ItemStack(ModBlocks.Generator), new Object[]{"III", "FMF", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace});
		Utils.AddRecipe(new ItemStack(ModBlocks.PowerCable, 32), new Object[]{"CCC", "IRI", "CCC", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'C', new ItemStack(ModItems.CableItem), 'R', new ItemStack(Blocks.redstone_block)});
		Utils.AddRecipe(new ItemStack(ModItems.FloatBlockPlacer), new Object[]{"GDP", "DRC", "PCB", 'G', Blocks.glass, 'D', Items.diamond, 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullAdvancedBat});
		Utils.AddRecipe(new ItemStack(ModItems.AntiFallChestPlate), new Object[]{"PUP", "FCF", "PBP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'U', new ItemStack(ModItems.Upgrades, 1, 0), 'F', ModItems.FloatBlockPlacer, 'C', Items.iron_chestplate, 'B', FullAdvancedBat});
		Utils.AddRecipe(new ItemStack(ModItems.InfoScreenHelmet), new Object[]{"IIP", "GCB", "IIP", 'I', new ItemStack(ModItems.IronPlate, 1 ,0), 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'G', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullBat});
		Utils.AddRecipe(new ItemStack(Items.saddle), new Object[]{"LLL", "LSL", " I ", 'L', Items.leather, 'S', Items.string, 'I', Items.iron_ingot});
	    Utils.AddRecipe(new ItemStack(ModBlocks.ElectricFurnace), new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
        Utils.AddRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Items.nether_star, 'F', Items.feather});
        Utils.AddRecipe(new ItemStack(ModBlocks.Laser), new Object[]{"HCH", "BML", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', ModBlocks.PowerCable, 'B', FullBat, 'M', ModBlocks.MachinePart, 'L', ModItems.Lens});
        Utils.AddRecipe(new ItemStack(ModBlocks.LaserReciver), new Object[]{"HBH", "CLC", "HRH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'B', FullBat, 'C', ModBlocks.PowerCable, 'L', ModItems.Lens, 'R', Blocks.redstone_block});

        Utils.RegisterSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 2.0F);
        Utils.RegisterSmelting(ModBlocks.OrangeLog, new ItemStack(Items.coal, 1, 1), 1.2F);
        Utils.RegisterSmelting(ModItems.Flour, new ItemStack(Items.bread), 1F);

        Utils.RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 0), new ItemStack(ModItems.Pizza, 1, 0), 20F);
        Utils.RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 1), new ItemStack(ModItems.Pizza, 1, 1), 20F);
        Utils.RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 2), new ItemStack(ModItems.Pizza, 1, 2), 20F);
        Utils.RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 3), new ItemStack(ModItems.Pizza, 1, 3), 20F);

        Utils.RegisterSmelting(new ItemStack(ModItems.IronPlate, 1, 0), new ItemStack(ModItems.IronPlate, 1, 1), 20F);




        for(int i = 0; i < 16; i++)
            Utils.AddRecipe(new ItemStack(ModBlocks.GamePart, 8, i), new Object[]{ "BBB", " B ", "BBB", 'B', new ItemStack(Blocks.stained_hardened_clay, 1, i)});

        for(int i = 0; i < 16; i++)
            Utils.AddRecipe(new ItemStack(ModBlocks.ColoredBrick, 8, i), new Object[]{"ISI", "SDS", "ISI", 'I', Items.iron_ingot, 'S', Blocks.stonebrick, 'D', new ItemStack(Items.dye, 1, 15 - i)});

        for(int i = 0; i < 16; i++)
            Utils.AddRecipe(new ItemStack(ModBlocks.ColoredBrickGlowstone, 8, i), new Object[]{"BBB", "BGB", "BBB", 'B', new ItemStack(ModBlocks.ColoredBrick, 1, i), 'G', Blocks.glowstone});


        for(int i = 0; i < 16; i ++)
        PillarUtils.BlU.add(new ItemStack(Blocks.stained_hardened_clay, 1, i));


        for(int i = 0; i < 16; i++){

            ItemStack stack = new ItemStack(ModBlocks.Pillar);
            stack.setItemDamage(i);

            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger("Bl", PillarUtils.BlU.size()-1);

            ArrayList List = new ArrayList();
            List.add(new ItemStack(ModBlocks.GamePart, 1, i));

            ShapelessRecipes res = new ShapelessRecipes(stack, List);

            Utils.AddRecipe(res);

        }

        for(int i = 0; i < PillarUtils.BlU.size(); i++){
            if(Main.config.AllowCustomPillars) {
                Block bl = Block.getBlockFromItem(PillarUtils.BlU.get(i).getItem());
                ItemStack stack = null;


                if (Item.getItemFromBlock(bl) != null && Item.getItemFromBlock(bl) instanceof ItemBlock && Item.getItemFromBlock(bl).getHasSubtypes()) {
                    stack = new ItemStack(ModBlocks.Pillar, 16, PillarUtils.BlU.get(i).getItemDamage());
                } else {
                    stack = new ItemStack(ModBlocks.Pillar, 16, 0);
                }

                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setInteger("Bl", i);

                if(bl instanceof BlockAir || bl == null || bl == Blocks.air) {
                    continue;
                }

                ItemStack stk = new ItemStack(bl, 1, stack.getItemDamage());

                ShapedRecipes recipe = new ShapedRecipes(3, 3, new ItemStack[]{stk, stk, stk, null, stk, null, stk, stk, stk}, stack);

                Utils. AddRecipe(recipe);
            }
        }


    }


    
}
