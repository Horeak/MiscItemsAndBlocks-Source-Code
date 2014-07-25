package com.miscitems.MiscItemsAndBlocks.Utils;

import MiscItemsApi.Recipes.RecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils.CrystalToolUpgradeRecipe;
import com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils.ItemRechargeRecipe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class Crafting {

    public static ArrayList<String> Recipes = new ArrayList<String>();

	public static void RegisterRecipes(){


        //Infusion Recipes
        //MagicUtils.RegisterInfusionRecipe(new ItemStack(), new ItemStack(), new Object[]{}, 0);
        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalInfusedMetal, new ItemStack(Items.iron_ingot), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 10);
        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalInfusedGem, new ItemStack(Items.diamond), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 30);
        RecipeHandler.RegisterInfusionRecipe(new ItemStack(ModItems.CrystalSilk, 3), new ItemStack(Items.string), new Object[]{Items.leather, Items.leather, ModItems.BlueCrystal}, 5);
        RecipeHandler.RegisterInfusionRecipe(ModBlocks.InfusedMetalBlock, new ItemStack(Blocks.iron_block), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 90);
        RecipeHandler.RegisterInfusionRecipe(ModBlocks.InfusedGemBlock, new ItemStack(Blocks.diamond_block), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 90);

        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalPickaxe, new ItemStack(Items.diamond_pickaxe), new Object[]{ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedGem, ModItems.GreenCrystal, ModItems.GreenCrystal, ModItems.RedCrystal, ModItems.RedCrystal, ModItems.ChargedCrystal}, 1000);
        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalBlade, new ItemStack(Items.diamond_sword), new Object[]{ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedGem, ModItems.GreenCrystal, ModItems.GreenCrystal, ModItems.RedCrystal, ModItems.RedCrystal, ModItems.ChargedCrystal}, 1000);


        RecipeHandler.RegisterInfusionRecipe(ModItems.InvisHelmet, new ItemStack(Items.leather_helmet), new Object[]{ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk}, 80);
        RecipeHandler.RegisterInfusionRecipe(ModItems.InvisChestPlate, new ItemStack(Items.leather_chestplate), new Object[]{ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk}, 80);
        RecipeHandler.RegisterInfusionRecipe(ModItems.InvisLeggings, new ItemStack(Items.leather_leggings), new Object[]{ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk}, 80);
        RecipeHandler.RegisterInfusionRecipe(ModItems.InvisBoots, new ItemStack(Items.leather_boots), new Object[]{ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk}, 80);
        RecipeHandler.RegisterInfusionRecipe(ModItems.InvisibilityCore, new ItemStack(ModItems.CrystalInfusedGem), new Object[]{ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.CrystalSilk, ModItems.RedCrystal, ModItems.RedCrystal, ModItems.ChargedCrystal, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal}, 500);

        RecipeHandler.RegisterInfusionRecipe(ModBlocks.MagicalRecharger, new ItemStack(ModBlocks.EnergyBattery), new Object[]{ModItems.CrystalInfusedGem, ModItems.CrystalInfusedGem, ModItems.CrystalInfusedGem, ModItems.CrystalInfusedGem, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal, ModItems.CrystalInfusedMetal}, 300);


        //Magic Recipes
        AddRecipe(new ItemStack(ModBlocks.EnergyBattery), new Object[]{"GMG", "MCM", "GMG", 'G', Items.gold_ingot, 'M', ModItems.CrystalInfusedMetal, 'C', ModItems.CrystalInfusedGem});
        AddRecipe(new ItemStack(ModBlocks.InfusedGemBlock), new Object[]{"XXX", "XXX", "XXX", 'X', ModItems.CrystalInfusedGem });
        AddRecipe(new ItemStack(ModBlocks.InfusedMetalBlock), new Object[]{"XXX", "XXX", "XXX", 'X', ModItems.CrystalInfusedMetal });

        AddShapelessRecipe(new ItemStack(ModItems.CrystalInfusedGem, 9), new Object[]{ModBlocks.InfusedGemBlock});
        AddShapelessRecipe(new ItemStack(ModItems.CrystalInfusedMetal, 9), new Object[]{ModBlocks.InfusedMetalBlock});

        AddRecipe(new ItemStack(ModItems.ChargedCrystal, 1, 50), new Object[]{"RBG", "BCB", "GBR", 'R', Items.redstone, 'G', Items.glowstone_dust, 'B', ModItems.BlueCrystal, 'C', ModItems.GreenCrystal});
        AddRecipe(new ItemStack(ModItems.ChargedCrystal, 1, 50), new Object[]{"GBR", "BCB", "RBG", 'R', Items.redstone, 'G', Items.glowstone_dust, 'B', ModItems.BlueCrystal, 'C', ModItems.GreenCrystal});

        GameRegistry.addRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.diamond), "ExtraDamage"));
        GameRegistry.addRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.blaze_rod), "FireDamage"));
        GameRegistry.addRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.ender_pearl), "Looting"));

        GameRegistry.addRecipe(new ItemRechargeRecipe(50, 0, new ItemStack(ModItems.InvisibilityCore), new ItemStack(ModItems.ChargedCrystal, 1, 0)));
        GameRegistry.addRecipe(new ItemRechargeRecipe(2, 0, new ItemStack(ModItems.ChargedCrystal), new ItemStack(Items.redstone, 1)));
        GameRegistry.addRecipe(new ItemRechargeRecipe(5, 0, new ItemStack(ModItems.ChargedCrystal), new ItemStack(Items.glowstone_dust, 1)));



        //NBT ItemStacks
        ItemStack FullBat = new ItemStack(ModItems.Battery); ((ModItemPowerTool)FullBat.getItem()).AddPower(FullBat, ((ModItemPowerTool)FullBat.getItem()).MaxPower(FullBat));
        ItemStack FullBigBat = new ItemStack(ModItems.BigBattery); ((ModItemPowerTool)FullBigBat.getItem()).AddPower(FullBigBat, ((ModItemPowerTool)FullBigBat.getItem()).MaxPower(FullBigBat));
        ItemStack FullAdvancedBat = new ItemStack(ModItems.AdvancedBattery); ((ModItemPowerTool)FullAdvancedBat.getItem()).AddPower(FullAdvancedBat, ((ModItemPowerTool)FullAdvancedBat.getItem()).MaxPower(FullAdvancedBat));

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


		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 1), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 1)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 2), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 2)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 3), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 4)});
		    AddShapelessRecipe(new ItemStack(ModItems.Cheese), Items.milk_bucket);
		    AddShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
		    AddShapelessRecipe(new ItemStack(ModBlocks.DiceHolder, 1, 0), new Object[]{ModBlocks.ItemPedestal, ModBlocks.Dice});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
            AddShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);
            AddShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Items.paper, Items.paper, Items.paper});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverIngot, 9), new Object[]{ModBlocks.SilverBlock});
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_fished);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_porkchop);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_beef);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_chicken);
            AddShapelessRecipe(new ItemStack(ModBlocks.LensBench), ModItems.Lens, ModBlocks.Worktable);
            AddShapelessRecipe(new ItemStack(ModItems.BigBattery), new Object[]{new ItemStack(ModItems.Battery), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.Battery),});
            AddShapelessRecipe(FullBigBat, new Object[]{FullBat, new ItemStack(ModItems.Circuit, 1, 1), FullBat});
            AddShapelessRecipe(new ItemStack(ModItems.AdvancedBattery), new Object[]{new ItemStack(ModItems.BigBattery), new ItemStack(ModItems.Circuit, 1, 1), new ItemStack(ModItems.BigBattery)});
            AddShapelessRecipe(FullAdvancedBat, new Object[]{FullBigBat, new ItemStack(ModItems.Circuit, 1, 1), FullBigBat});

            GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Worktable, new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, Character.valueOf('P'), "plankWood", 'C', Blocks.chest, 'I', Blocks.crafting_table}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Items.dye}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Items.stick, Character.valueOf('P'), "plankWood"}));

            AddRecipe(new ItemStack(ModBlocks.Worktable), new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, 'P', Blocks.planks, 'C', Blocks.chest, 'I', Blocks.crafting_table});
            AddRecipe(new ItemStack(ModBlocks.Dice), new Object[]{"PPP", "PDP", "PPP", 'P', Blocks.planks, 'D', Items.dye});
            AddRecipe(new ItemStack(ModBlocks.Table), new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), 'P', Blocks.planks, 'H', Blocks.wooden_slab});
            AddRecipe(new ItemStack(ModItems.Turbine), new Object[]{"S S", " P ", "S S", 'S', Items.stick, 'P', Blocks.planks});


        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.GamePart, 8, i), new Object[]{ "BBB", " B ", "BBB", 'B', new ItemStack(Blocks.stained_hardened_clay, 1, i)});

        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.ColoredBrick, 8, i), new Object[]{"ISI", "SDS", "ISI", 'I', Items.iron_ingot, 'S', Blocks.stonebrick, 'D', new ItemStack(Items.dye, 1, 15 - i)});

        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.ColoredBrickGlowstone, 8, i), new Object[]{"BBB", "BGB", "BBB", 'B', new ItemStack(ModBlocks.ColoredBrick, 1, i), 'G', Blocks.glowstone});


            AddRecipe(new ItemStack(ModItems.GuideBook), new Object[]{"BP", "SP", 'B', Items.book, 'P', Items.paper, 'S', Items.string});
		    AddRecipe(new ItemStack(ModItems.DataChip, 2),new Object[]{"CCC", "CGC", "III", 'C', ModItems.Cardboard, 'G', new ItemStack(ModItems.Circuit, 1, 0), 'I', Items.iron_ingot});
	     	AddRecipe(new ItemStack(ModBlocks.Teleporter), new Object[]{"HCH", "BEB", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullAdvancedBat, 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.WireLessRedstone, 2), new Object[]{"IEI", "ERE", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'E', Items.ender_pearl, 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
		    AddRecipe(new ItemStack(ModBlocks.WirelessItemTrans, 2),new Object[]{"POP", "CEC", "POP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'O', Blocks.obsidian, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.MetalPress), new Object[]{"IPI", "CBC", "IAI", 'I', new ItemStack(ModItems.IronPlate, 1,0), 'P', Blocks.piston, 'C', new ItemStack(ModItems.Circuit), 'B', Blocks.iron_block, 'A', Blocks.anvil});
		    AddRecipe(new ItemStack(ModBlocks.SilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', ModItems.SilverIngot});
		    AddRecipe(new ItemStack(ModBlocks.Computer),new Object[]{"IBI", "PCB", "IBT", 'I', Items.iron_ingot, 'B', Blocks.iron_block, 'P', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'R', Items.redstone, 'T', Blocks.redstone_block});
		    AddRecipe(new ItemStack(ModBlocks.StorageBlock), new Object[]{"ICI", "CBC", "ICI", 'I', Blocks.iron_block, 'C', Blocks.chest, 'B', ModBlocks.Box});
		    AddRecipe(new ItemStack(ModBlocks.OneWayGlass, 8), new Object[]{"SSS", "GES", "SSS", 'S', Blocks.stone, 'G', Blocks.glass, 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModItems.XpExtractor), new Object[] {" D ", "IGI", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass, 'D', Items.diamond});
			AddRecipe(new ItemStack(ModBlocks.XpStorage), new Object[] {"BIB", "IEI", "BIB", 'I', Blocks.obsidian, 'B', Blocks.iron_block, 'E', ModItems.XpExtractor});
	        AddRecipe(new ItemStack(ModItems.SilverIngot), new Object[] {"NNN", "NNN", "NNN", 'N', ModItems.SilverNugget});
			AddRecipe(new ItemStack(ModItems.SilverSword), new Object[] {" I ", " I ", " S ", 'I', ModItems.SilverIngot, 'S', Items.stick});
			AddRecipe(new ItemStack(ModItems.SilverBow), new Object[] {" IS", "I S", " IS", 'I', ModItems.SilverIngot, 'S', Items.string});
	        AddRecipe(new ItemStack(ModItems.SilverBow), new Object[] {"SI ", "S I", "SI ", 'I', ModItems.SilverIngot, 'S', Items.string});
	        AddRecipe(new ItemStack(ModItems.SilverArrow, 8), new Object[] {" N ", " S ", " F ", 'N', ModItems.SilverNugget, 'S', Items.stick, 'F', Items.feather});
			AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"S  ", "SS ", "SSS", 'S', Blocks.stone});
			AddRecipe(new ItemStack(ModBlocks.StoneStair, 4), new Object[]{"  S", " SS", "SSS", 'S', Blocks.stone});
	        AddRecipe(new ItemStack(ModBlocks.DisarmTrap),new Object[] {"IHI", "HPH", "IDI", 'I', Items.iron_ingot, 'H', Blocks.hopper, 'P', Blocks.heavy_weighted_pressure_plate, 'D', Blocks.dispenser});
	        AddRecipe(new ItemStack(ModBlocks.Bin), new Object[] {"I I", "IBI", " I ", 'I', Items.iron_ingot, 'B', Items.bucket});
			AddRecipe(new ItemStack(ModBlocks.Box), new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
			AddRecipe(new ItemStack(ModItems.DivingHelmet), new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Items.nether_star, 'G', Blocks.glass});
			AddRecipe(new ItemStack(ModItems.RunningLeggings), new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Items.nether_star});
			AddRecipe(new ItemStack(ModItems.JumpingBoots), new Object[] {"   ", "S S", "D D", 'D', Items.diamond, 'S', ModItems.SilverIngot});
			AddRecipe(new ItemStack(ModBlocks.PaintBlock, 8),new Object[]{"CCC", "CSC", "CCC", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModBlocks.SpeedBlock, 32), new Object[]{"III", "BDB", "BBB", 'I', Blocks.ice, 'B', Blocks.iron_block, 'D', Items.diamond});
			AddRecipe(new ItemStack(ModBlocks.Mill),new Object[]{"CSC", "SPS", "CCC", 'C', Blocks.cobblestone, 'S', Blocks.stone, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModItems.PizzaBottom), new Object[]{"FFF", 'F', ModItems.Flour});
			AddRecipe(new ItemStack(ModBlocks.Squezer), new Object[]{"CIC", "IPI", "CCC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModBlocks.Oven), new Object[] {"SSS", "SFS", "SSS", 'S', Blocks.stone, 'F', Blocks.furnace});
			AddRecipe(new ItemStack(ModItems.PaintBrush), new Object[]{"  C", " S ", "S  ", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 4), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 0)});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 5), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 4)});
			AddRecipe(new ItemStack(ModBlocks.MachinePart), new Object[]{"PPP", "P P", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.IronPlate, 2, 0), new Object[]{"II ", "II ", 'I', Items.iron_ingot});
			AddRecipe(new ItemStack(ModItems.IronPlate, 1, 2), new Object[]{"II ", "II ", 'I', new ItemStack(ModItems.IronPlate, 1, 1)});
			AddRecipe(new ItemStack(ModItems.Wrench), new Object[]{"P P", " P ", " P ", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.Upgrades, 3, 0), new Object[]{"PPP", "BBB", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'B', FullBat});
            AddRecipe(new ItemStack(ModBlocks.ItemPedestal, 2), new Object[]{"I I", " S ", "SSS", 'I', Items.iron_ingot, 'S', Blocks.stone});
			AddRecipe(new ItemStack(ModBlocks.MiningChamber), new Object[]{"ICI", "IMI", " P ", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'P', Items.diamond_pickaxe, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModItems.Drill), new Object[]{"DD ", "DSI", " IP", 'D', Items.diamond, 'P', FullBat, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.HeatDrill), new Object[]{"CFP", "FDF", "PFK", 'C', new ItemStack(ModItems.Circuit, 1, 1), 'F', Items.fire_charge, 'D', ModItems.Drill, 'K', Blocks.furnace, 'P', new ItemStack(ModItems.IronPlate, 1, 2)});
			AddRecipe(new ItemStack(ModItems.Battery), new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
            AddRecipe(new ItemStack(ModItems.ElectricShears), new Object[]{"ISI", "IBI", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.shears, 'B', FullBat, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.ElectricBow), new Object[]{" IS", "ICB", " IS", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.string, 'C', new ItemStack(ModItems.Circuit), 'B', FullBat});
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 1), new Object[]{"IGI", "RCR", "IGI", 'I', new ItemStack(Items.dye, 1, 4), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Items.redstone, 'G', Items.glowstone_dust});
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 0), new Object[]{"WIW", "IRI", "WIW", 'W', ModItems.Cardboard, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
			AddRecipe(new ItemStack(ModItems.CableItem, 16), new Object[]{"CSC", "PRP", "CSC", 'C', new ItemStack(Blocks.carpet), 'S', new ItemStack(Items.string), 'P', new ItemStack(ModItems.IronPlate, 1, 0), 'R', new ItemStack(Items.redstone)});
			AddRecipe(new ItemStack(ModItems.SolarCells), new Object[]{"IGI", "GCG", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'G', Blocks.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModBlocks.Charger), new Object[]{"ICI", "RMR", "IRI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'R', new ItemStack(ModItems.Battery), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.SolarPanel), new Object[]{"IGI", "GMG", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.WindMill), new Object[]{"III", "SMS", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.Generator), new Object[]{"III", "FMF", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace});
			AddRecipe(new ItemStack(ModBlocks.PowerCable, 32), new Object[]{"CCC", "IRI", "CCC", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'C', new ItemStack(ModItems.CableItem), 'R', new ItemStack(Blocks.redstone_block)});
			AddRecipe(new ItemStack(ModItems.FloatBlockPlacer), new Object[]{"GDP", "DRC", "PCB", 'G', Blocks.glass, 'D', Items.diamond, 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullAdvancedBat});
			AddRecipe(new ItemStack(ModItems.AntiFallChestPlate), new Object[]{"PUP", "FCF", "PBP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'U', new ItemStack(ModItems.Upgrades, 1, 0), 'F', ModItems.FloatBlockPlacer, 'C', Items.iron_chestplate, 'B', FullAdvancedBat});
			AddRecipe(new ItemStack(ModItems.InfoScreenHelmet), new Object[]{"IIP", "GCB", "IIP", 'I', new ItemStack(ModItems.IronPlate, 1 ,0), 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'G', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', FullBat});
			AddRecipe(new ItemStack(Items.saddle), new Object[]{"LLL", "LSL", " I ", 'L', Items.leather, 'S', Items.string, 'I', Items.iron_ingot});
	        AddRecipe(new ItemStack(ModBlocks.Pillar, 4), new Object[]{"QQQ", " Q ", "QQQ", 'Q', Blocks.quartz_block});
	        AddRecipe(new ItemStack(ModBlocks.ElectricFurnace), new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
            AddRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Items.nether_star, 'F', Items.feather});
            AddRecipe(new ItemStack(ModItems.Lens), new Object[]{"ISI", "SGS", "ISI", 'I', Items.iron_ingot, 'S', ModItems.SilverNugget, 'G', Blocks.glass_pane});
            AddRecipe(new ItemStack(ModBlocks.Laser), new Object[]{"HCH", "BML", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', ModBlocks.PowerCable, 'B', FullBat, 'M', ModBlocks.MachinePart, 'L', ModItems.Lens});
            AddRecipe(new ItemStack(ModBlocks.LaserReciver), new Object[]{"HBH", "CLC", "HRH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'B', FullBat, 'C', ModBlocks.PowerCable, 'L', ModItems.Lens, 'R', Blocks.redstone_block});
            AddRecipe(new ItemStack(ModBlocks.GhostBlock, 32), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, 'S', ModItems.SilverIngot});
            AddRecipe(new ItemStack(ModBlocks.GhostBlock, 4), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, 'S', ModItems.SilverNugget});

            AddRecipe(new ItemStack(ModBlocks.PowerCrystal), new Object[]{"BPB", "GRG", "BPB", 'B', ModItems.BlueCrystal, 'P', ModItems.ChargedCrystal, 'G', ModItems.GreenCrystal, 'R', ModItems.RedCrystal});

            RegisterSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 2.0F);
            RegisterSmelting(ModBlocks.OrangeLog, new ItemStack(Items.coal, 1, 1), 1.2F);
            RegisterSmelting(ModItems.Flour, new ItemStack(Items.bread), 1F);

            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 0), new ItemStack(ModItems.Pizza, 1, 0), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 1), new ItemStack(ModItems.Pizza, 1, 1), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 2), new ItemStack(ModItems.Pizza, 1, 2), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 3), new ItemStack(ModItems.Pizza, 1, 3), 20F);

            RegisterSmelting(new ItemStack(ModItems.IronPlate, 1, 0), new ItemStack(ModItems.IronPlate, 1, 1), 20F);




    }

    public static boolean RegisterRes(String name){


        if(!Recipes.contains(name)){
            Recipes.add(name);
            return true;
        }

        return false;
    }


    public static void RegisterSmelting(ItemStack Input, ItemStack Output, float Xp){
        if(!Item.itemRegistry.containsId(Item.getIdFromItem(Input.getItem())) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;
        FurnaceRecipes.smelting().func_151394_a(Input, Output, Xp);

        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            BookUtils.AddSmeltingRecipe(Input, new DoubleStackUtil(Input, Output));
    }

    public static void RegisterSmelting(Item Input, ItemStack Output, float Xp){
        if(!Item.itemRegistry.containsId(Item.getIdFromItem(Input)) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;
        GameRegistry.addSmelting(Input, Output, Xp);

        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        BookUtils.AddSmeltingRecipe(new ItemStack(Input), new DoubleStackUtil(new ItemStack(Input), Output));
    }

    public static void RegisterSmelting(Block Input, ItemStack Output, float Xp){
        if(!Block.blockRegistry.containsId(Block.getIdFromBlock(Input)) || !Item.itemRegistry.containsId(Item.getIdFromItem(Output.getItem())))
            return;


        GameRegistry.addSmelting(Input, Output, Xp);

        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            BookUtils.AddSmeltingRecipe(new ItemStack(Input), new DoubleStackUtil(new ItemStack(Input), Output));
    }

    
    public static void AddRecipe(ItemStack output, Object... Array){

        if(CheckBigRecipe(output, Array)) {
            String name = output.getItem().getUnlocalizedName(output).replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "");


            if (RegisterRes(name)) {
                GameRegistry.addShapedRecipe(output, Array);


            } else {
                if (!RegisterRes(name)) {
                    for (int i = 0; i < 20; i++) {

                        if (RegisterRes(name + "_" + i)) {

                            name = output.getItem().getUnlocalizedName(output).replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "") + "_" + i;


                            if (CheckBigRecipe(output, Array)) {
                                GameRegistry.addShapedRecipe(output, Array);
                                break;
                            }
                        }

                    }
                }


            }


        }
    }
    
    public static void AddShapelessRecipe(ItemStack output, Object... Array) {

        if (CheckSmallRecipe(output, Array)) {
            String name = output.getItem().getUnlocalizedName(output).replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "");


            if (RegisterRes(name)) {
                GameRegistry.addShapelessRecipe(output, Array);



        } else {
            if (!RegisterRes(name)) {
                for (int i = 0; i < 20; i++) {

                    if (RegisterRes(name + "_" + i)) {

                        name = output.getItem().getUnlocalizedName(output).replace("tile.", "").replace(".name", "").replace(" ", "_").replace("item.", "") + "_" + i;


                        if (CheckSmallRecipe(output, Array)) {
                            GameRegistry.addShapelessRecipe(output, Array);
                            break;
                        }
                    }

                }
            }


        }
    }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean CheckBigRecipe(ItemStack stack, Object ... par2ArrayOfObj)
    {



        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }



        if(Item.itemRegistry.containsId(Item.getIdFromItem(stack.getItem()))){
        for(int z = 0; z  < aitemstack.length; z++){
            if(aitemstack[z] != null){
                if(Item.itemRegistry.containsId(Item.getIdFromItem(aitemstack[z].getItem())) == false){
                    return false;
                }

            }
        }

    }else{
            return false;
        }


        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        BookUtils.AddShapedRecipe(stack, aitemstack);

        return true;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean CheckSmallRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }

        }

        if(Item.itemRegistry.containsId(Item.getIdFromItem(par1ItemStack.getItem()))){
            for(int z = 0; z  < arraylist.size(); z++){
                if((ItemStack)arraylist.get(z) != null){
                if(Item.itemRegistry.containsId(Item.getIdFromItem(((ItemStack)arraylist.get(z)).getItem())) == false){
                    return false;
                }

            }
            }

        }else
            return false;


        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
       BookUtils.AddShapelessRecipe(par1ItemStack, arraylist);

      return true;
    }




    
}
