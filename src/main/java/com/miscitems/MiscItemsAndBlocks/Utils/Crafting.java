package com.miscitems.MiscItemsAndBlocks.Utils;

import MiscItemsApi.Recipes.RecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils.CrystalToolUpgradeRecipe;
import com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils.ItemRechargeRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

public class Crafting {

	public static void RegisterRecipes(){

        //Infusion Recipes
        //MagicUtils.RegisterInfusionRecipe(new ItemStack(), new ItemStack(), new Object[]{}, 0);
        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalInfusedMetal, new ItemStack(Items.iron_ingot), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 10);
        RecipeHandler.RegisterInfusionRecipe(ModItems.CrystalInfusedGem, new ItemStack(Items.diamond), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 30);
        RecipeHandler.RegisterInfusionRecipe(new ItemStack(ModItems.CrystalSilk, 3), new ItemStack(Items.string), new Object[]{Items.leather, Items.leather, ModItems.BlueCrystal}, 5);
        RecipeHandler.RegisterInfusionRecipe(ModBlocks.InfusedMetalBlock, new ItemStack(Blocks.iron_block), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 90);
        RecipeHandler.RegisterInfusionRecipe(ModBlocks.InfusedGemBlock, new ItemStack(Blocks.diamond_block), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 90);
        RecipeHandler.RegisterInfusionRecipe(new ItemStack(ModItems.ChargedCrystal, 1, ModItems.ChargedCrystal.getMaxDamage()), new ItemStack(ModItems.RedCrystal), new Object[]{ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal, ModItems.BlueCrystal}, 150);

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
        AddRecipe(new ItemStack(ModBlocks.MagicalInfuser), new Object[]{"OCO", "GRG", "OBO", 'O', Blocks.obsidian, 'C', ModItems.ChargedCrystal, 'G', ModItems.GreenCrystal, 'B', ModItems.BlueCrystal, 'R', ModItems.RedCrystal});
        AddRecipe(new ItemStack(ModBlocks.InfusedGemBlock), new Object[]{"XXX", "XXX", "XXX", 'X', ModItems.CrystalInfusedGem });
        AddRecipe(new ItemStack(ModBlocks.InfusedMetalBlock), new Object[]{"XXX", "XXX", "XXX", 'X', ModItems.CrystalInfusedMetal });

        AddShapelessRecipe(new ItemStack(ModItems.CrystalInfusedGem, 9), new Object[]{ModBlocks.InfusedGemBlock});
        AddShapelessRecipe(new ItemStack(ModItems.CrystalInfusedMetal, 9), new Object[]{ModBlocks.InfusedMetalBlock});

        AddRecipe(new ItemStack(ModItems.ChargedCrystal, 1, 50), new Object[]{"RBG", "BCB", "GBR", 'R', Items.redstone, 'G', Items.glowstone_dust, 'B', ModItems.BlueCrystal, 'C', ModItems.GreenCrystal});
        AddRecipe(new ItemStack(ModItems.ChargedCrystal, 1, 50), new Object[]{"GBR", "BCB", "RBG", 'R', Items.redstone, 'G', Items.glowstone_dust, 'B', ModItems.BlueCrystal, 'C', ModItems.GreenCrystal});

        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.diamond), Enchantment.sharpness, 3));
        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.blaze_rod), Enchantment.fireAspect, 1));
        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalBlade), new ItemStack(Items.ender_pearl), Enchantment.looting, 2));

        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalPickaxe), new ItemStack(Items.diamond), Enchantment.efficiency, 3));
        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalPickaxe), new ItemStack(Items.blaze_rod), Enchantment.silkTouch, 1));
        AddRecipe(new CrystalToolUpgradeRecipe(new ItemStack(ModItems.CrystalPickaxe), new ItemStack(Items.ender_pearl), Enchantment.fortune, 2));

        AddRecipe(new ItemRechargeRecipe(50, 0, new ItemStack(ModItems.InvisibilityCore), new ItemStack(ModItems.ChargedCrystal, 1, 0)));
        AddRecipe(new ItemRechargeRecipe(2, 0, new ItemStack(ModItems.ChargedCrystal), new ItemStack(Items.redstone, 1)));
        AddRecipe(new ItemRechargeRecipe(5, 0, new ItemStack(ModItems.ChargedCrystal), new ItemStack(Items.glowstone_dust, 1)));



        //NBT ItemStacks
        ItemStack FullBat = new ItemStack(ModItems.Battery); ((ModItemPowerTool)FullBat.getItem()).AddPower(FullBat, ((ModItemPowerTool) FullBat.getItem()).MaxPower(FullBat));
        ItemStack FullBigBat = new ItemStack(ModItems.BigBattery); ((ModItemPowerTool)FullBigBat.getItem()).AddPower(FullBigBat, ((ModItemPowerTool) FullBigBat.getItem()).MaxPower(FullBigBat));
        ItemStack FullAdvancedBat = new ItemStack(ModItems.AdvancedBattery); ((ModItemPowerTool)FullAdvancedBat.getItem()).AddPower(FullAdvancedBat, ((ModItemPowerTool) FullAdvancedBat.getItem()).MaxPower(FullAdvancedBat));

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

            AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Worktable, new Object[]{"WWW", "PIP", "PCP", 'W', Blocks.wool, Character.valueOf('P'), "plankWood", 'C', Blocks.chest, 'I', Blocks.crafting_table}));
            AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Items.dye}));
            AddShapedOreRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));
            AddShapedOreRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Items.stick, Character.valueOf('P'), "plankWood"}));

            AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlock, 32), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, Character.valueOf('S'), "ingotSilver"}));
            AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlock, 4), new Object[]{"GPG", "GSG", "GDG", 'G', Blocks.glass, 'P', Items.paper, 'D', Items.diamond, Character.valueOf('S'), "nuggetSilver"}));
            AddShapedOreRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Lens), new Object[]{"ISI", "SGS", "ISI", 'I', Items.iron_ingot, Character.valueOf('S'), "nuggetSilver", 'G', Blocks.glass_pane}));

            AddRecipe(new ItemStack(ModBlocks.Worktable), new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, 'P', Blocks.planks, 'C', Blocks.chest, 'I', Blocks.crafting_table});
            AddRecipe(new ItemStack(ModBlocks.Dice), new Object[]{"PPP", "PDP", "PPP", 'P', Blocks.planks, 'D', Items.dye});
            AddRecipe(new ItemStack(ModBlocks.Table), new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), 'P', Blocks.planks, 'H', Blocks.wooden_slab});
            AddRecipe(new ItemStack(ModItems.Turbine), new Object[]{"S S", " P ", "S S", 'S', Items.stick, 'P', Blocks.planks});


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
	        AddRecipe(new ItemStack(ModBlocks.ElectricFurnace), new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
            AddRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Items.nether_star, 'F', Items.feather});
            AddRecipe(new ItemStack(ModBlocks.Laser), new Object[]{"HCH", "BML", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', ModBlocks.PowerCable, 'B', FullBat, 'M', ModBlocks.MachinePart, 'L', ModItems.Lens});
            AddRecipe(new ItemStack(ModBlocks.LaserReciver), new Object[]{"HBH", "CLC", "HRH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'B', FullBat, 'C', ModBlocks.PowerCable, 'L', ModItems.Lens, 'R', Blocks.redstone_block});


            AddRecipe(new ItemStack(ModBlocks.PowerCrystal), new Object[]{"BPB", "GRG", "BPB", 'B', ModItems.BlueCrystal, 'P', ModItems.ChargedCrystal, 'G', ModItems.GreenCrystal, 'R', ModItems.RedCrystal});

            RegisterSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 2.0F);
            RegisterSmelting(ModBlocks.OrangeLog, new ItemStack(Items.coal, 1, 1), 1.2F);
            RegisterSmelting(ModItems.Flour, new ItemStack(Items.bread), 1F);

            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 0), new ItemStack(ModItems.Pizza, 1, 0), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 1), new ItemStack(ModItems.Pizza, 1, 1), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 2), new ItemStack(ModItems.Pizza, 1, 2), 20F);
            RegisterSmelting(new ItemStack(ModItems.PizzaRaw, 1, 3), new ItemStack(ModItems.Pizza, 1, 3), 20F);

            RegisterSmelting(new ItemStack(ModItems.IronPlate, 1, 0), new ItemStack(ModItems.IronPlate, 1, 1), 20F);




        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.GamePart, 8, i), new Object[]{ "BBB", " B ", "BBB", 'B', new ItemStack(Blocks.stained_hardened_clay, 1, i)});

        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.ColoredBrick, 8, i), new Object[]{"ISI", "SDS", "ISI", 'I', Items.iron_ingot, 'S', Blocks.stonebrick, 'D', new ItemStack(Items.dye, 1, 15 - i)});

        for(int i = 0; i < 16; i++)
            AddRecipe(new ItemStack(ModBlocks.ColoredBrickGlowstone, 8, i), new Object[]{"BBB", "BGB", "BBB", 'B', new ItemStack(ModBlocks.ColoredBrick, 1, i), 'G', Blocks.glowstone});


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

            AddRecipe(res);

        }

        for(int i = 0; i < PillarUtils.BlU.size(); i++){
            if(ConfigUtils.AllowCustomPillars) {
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

                AddRecipe(recipe);
            }
        }


    }


    public static void RegisterSmelting(ItemStack Input, ItemStack Output, float Xp){
        if(StackEnabled(Output))
        FurnaceRecipes.smelting().func_151394_a(Input, Output, Xp);

    }

    public static void RegisterSmelting(Item Input, ItemStack Output, float Xp){
        if(StackEnabled(Output))
        GameRegistry.addSmelting(Input, Output, Xp);

    }

    public static void RegisterSmelting(Block Input, ItemStack Output, float Xp){
        if(StackEnabled(Output))
        GameRegistry.addSmelting(Input, Output, Xp);

    }

    
    public static void AddRecipe(ItemStack output, Object... Array){
        if (StackEnabled(output))
            GameRegistry.addShapedRecipe(output, Array);
    }

    public static void AddShapelessRecipe(ItemStack output, Object... Array) {
        if (StackEnabled(output))
                GameRegistry.addShapelessRecipe(output, Array);
    }


    public static void AddRecipe(IRecipe res){
        if (StackEnabled(res.getRecipeOutput()))
            GameRegistry.addRecipe(res);
    }





    public static void AddShapedOreRecipe(ShapedOreRecipe res){
        if(StackEnabled(res.getRecipeOutput()))
            GameRegistry.addRecipe(res);
    }

    public static void AddShapelessOreRecipe(ShapelessOreRecipe res){
        if(StackEnabled(res.getRecipeOutput()))
            GameRegistry.addRecipe(res);
    }

    public static boolean StackEnabled(ItemStack stack){

        boolean Register = false;

        if(stack != null){
            if(stack.getItem() instanceof ItemBlock){
                Block bl = Block.getBlockFromItem(stack.getItem());

                Register = ConfigUtils.IsBlockEnabled(bl);

            }else if(stack.getItem() instanceof Item && !(stack.getItem() instanceof ItemBlock)){
                Item itm = stack.getItem();

                Register = ConfigUtils.IsItemEnabled(itm);
            }
        }
        return Register;
    }
    
}
