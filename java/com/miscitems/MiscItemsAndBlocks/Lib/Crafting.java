package com.miscitems.MiscItemsAndBlocks.Lib;

import java.util.ArrayList;
import java.util.HashMap;

import mantle.client.MantleClientRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes.MillRecipes;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes.SqueezerRecipes;

import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	
	
	public static void RegisterRecipes(){
		
		
		
		SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.apple), new ItemStack(ModItems.Liquid, 1, 0));
		SqueezerRecipes.instance().AddRecipe(new ItemStack(ModItems.Orange), new ItemStack(ModItems.Liquid, 1, 2));
		SqueezerRecipes.instance().AddRecipe(new ItemStack(Items.carrot), new ItemStack(ModItems.Liquid, 1, 3));
		
		MillRecipes.instance().AddRecipe(new ItemStack(Items.wheat), new ItemStack(ModItems.Flour));
		MillRecipes.instance().AddRecipe(new ItemStack(Items.rotten_flesh), new ItemStack(Items.leather));
		
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 1), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 1)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 2), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 2)});
		    AddShapelessRecipe(new ItemStack(ModItems.PaintBrush, 1, 3), new Object[]{new ItemStack(ModItems.PaintBrush, 1, 0), new ItemStack(Items.dye, 1, 4)});
		    AddShapelessRecipe(new ItemStack(ModItems.Cheese), Items.milk_bucket);
		    AddShapelessRecipe(new ItemStack(ModItems.Liquid, 1, 1), new Object[]{Items.bucket, ModItems.Tomato});
		    AddShapelessRecipe(new ItemStack(ModItems.TomatoSeeds, 4), ModItems.Tomato);
		    AddShapelessRecipe(new ItemStack(ModBlocks.DiceHolder), new Object[]{ModBlocks.ItemPedestal, ModBlocks.Dice});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverNugget, 9), ModItems.SilverIngot);
            AddShapelessRecipe(new ItemStack(ModBlocks.OrangePlanks, 4), ModBlocks.OrangeLog);
            AddShapelessRecipe(new ItemStack(ModItems.Cardboard, 2), new Object[]{Items.paper, Items.paper, Items.paper});
		    AddShapelessRecipe(new ItemStack(ModItems.SilverIngot, 9), new Object[]{ModBlocks.SilverBlock});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 1), new Object[]{new ItemStack(Items.dye, 1, 1), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 4), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 2), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModBlocks.GamePart, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 11), ModBlocks.GamePart});
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_fished);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 1), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_porkchop);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 2), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_beef);
            AddShapelessRecipe(new ItemStack(ModItems.PizzaRaw, 1, 3), ModItems.Cheese, ModItems.PizzaBottom, new ItemStack(ModItems.Liquid, 1, 1), Items.cooked_chicken);
		
            GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.CraftingInv, new Object[] {"WWW", "PIP", "PCP", 'W', Blocks.wool, Character.valueOf('P'), "plankWood", 'C', Blocks.chest, 'I', Blocks.crafting_table}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Dice, new Object[]{"PPP", "PDP", "PPP", Character.valueOf('P'), "plankWood", 'D', Items.dye}));
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.Table, new Object[]{"CCC", "HHH", "P P", 'C', new ItemStack(Blocks.carpet, 1, 14), Character.valueOf('P'), "plankWood", Character.valueOf('H'), "slabWood"}));	
		    GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.Turbine, new Object[]{"S S", " P ", "S S", 'S', Items.stick, Character.valueOf('P'), "plankWood"}));
		
		    MantleClientRegistry.registerManualLargeRecipe("worktable_res", new ItemStack(ModBlocks.CraftingInv), new ItemStack[]{new ItemStack(Blocks.wool),new ItemStack(Blocks.wool), new ItemStack(Blocks.wool), new ItemStack(Blocks.planks), new ItemStack(Blocks.chest), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.crafting_table), new ItemStack(Blocks.planks)});
		    MantleClientRegistry.registerManualLargeRecipe("dice_res", new ItemStack(ModBlocks.Dice), new ItemStack[]{new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Items.dye), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks), new ItemStack(Blocks.planks)});
		    MantleClientRegistry.registerManualLargeRecipe("table_res", new ItemStack(ModBlocks.Table), new ItemStack(Blocks.carpet, 1, 14), new ItemStack(Blocks.carpet, 1, 14), new ItemStack(Blocks.carpet, 1, 14), new ItemStack(Blocks.wooden_slab), new ItemStack(Blocks.wooden_slab), new ItemStack(Blocks.wooden_slab), new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks));
		    MantleClientRegistry.registerManualLargeRecipe("turbine_res", new ItemStack(ModItems.Turbine), new ItemStack[]{new ItemStack(Items.stick), null, new ItemStack(Items.stick), null, new ItemStack(Blocks.planks), null, new ItemStack(Items.stick), null, new ItemStack(Items.stick)});
		    
		    AddRecipe(new ItemStack(ModItems.DataChip, 2), new Object[]{"CCC", "CGC", "III", 'C', ModItems.Cardboard, 'G', new ItemStack(ModItems.Circuit, 1, 0), 'I', Items.iron_ingot});
	     	AddRecipe(new ItemStack(ModBlocks.Teleporter), new Object[]{"HCH", "BEB", "HCH", 'H', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0), 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.WireLessRedstone, 2), new Object[]{"IEI", "ERE", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'E', Items.ender_pearl, 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
		    AddRecipe(new ItemStack(ModBlocks.WirelessItemTrans, 2), new Object[]{"POP", "CEC", "POP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'O', Blocks.obsidian, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'E', Items.ender_pearl});
		    AddRecipe(new ItemStack(ModBlocks.MetalPress), new Object[]{"IPI", "CBC", "IAI", 'I', new ItemStack(ModItems.IronPlate, 1,0), 'P', Blocks.piston, 'C', new ItemStack(ModItems.Circuit), 'B', Blocks.iron_block, 'A', Blocks.anvil});
		    AddRecipe(new ItemStack(ModBlocks.SilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', ModItems.SilverIngot});
		    AddRecipe(new ItemStack(ModBlocks.Computer), new Object[]{"IBI", "PCB", "IBT", 'I', Items.iron_ingot, 'B', Blocks.iron_block, 'P', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'R', Items.redstone, 'T', Blocks.redstone_block});
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
	        AddRecipe(new ItemStack(ModBlocks.DisarmTrap), new Object[] {"IHI", "HPH", "IDI", 'I', Items.iron_ingot, 'H', Blocks.hopper, 'P', Blocks.heavy_weighted_pressure_plate, 'D', Blocks.dispenser});
	        AddRecipe(new ItemStack(ModBlocks.Bin), new Object[] {"I I", "IBI", " I ", 'I', Items.iron_ingot, 'B', Items.bucket});
			AddRecipe(new ItemStack(ModBlocks.Box), new Object[]{"CCC", "C C", "CCC", 'C', ModItems.Cardboard});
			AddRecipe(new ItemStack(ModItems.DivingHelmet), new Object[] {"SNS", "SGS", "   ", 'S', ModItems.SilverIngot, 'N', Items.nether_star, 'G', Blocks.glass});
			AddRecipe(new ItemStack(ModItems.RunningLeggings), new Object[]{"SNS", "S S", "S S", 'S', ModItems.SilverIngot, 'N', Items.nether_star});
			AddRecipe(new ItemStack(ModItems.JumpingBoots), new Object[] {"   ", "S S", "D D", 'D', Items.diamond, 'S', ModItems.SilverIngot});
			AddRecipe(new ItemStack(ModBlocks.PaintBlock, 8), new Object[]{"CCC", "CSC", "CCC", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModBlocks.SpeedBlock, 8), new Object[]{"III", "BDB", "BBB", 'I', Blocks.ice, 'B', Blocks.iron_block, 'D', Items.diamond});
			AddRecipe(new ItemStack(ModBlocks.Mill), new Object[]{"CSC", "SPS", "CCC", 'C', Blocks.cobblestone, 'S', Blocks.stone, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModItems.PizzaBottom), new Object[]{"FFF", 'F', ModItems.Flour});
			AddRecipe(new ItemStack(ModBlocks.Squezer), new Object[]{"CIC", "IPI", "CCC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot, 'P', Blocks.piston});
			AddRecipe(new ItemStack(ModBlocks.PizzaOven), new Object[] {"SSS", "SFS", "SSS", 'S', Blocks.stone, 'F', Blocks.furnace});		
			AddRecipe(new ItemStack(ModItems.PaintBrush), new Object[]{"  C", " S ", "S  ", 'C', Blocks.wool, 'S', Items.stick});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 4), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 0)});
			AddRecipe(new ItemStack(ModItems.PaintBrush, 1, 5), new Object[]{" R ", "GPB", " F ", 'R', new ItemStack(ModItems.PaintBrush, 1, 1 ), 'G', new ItemStack(ModItems.PaintBrush, 1, 2 ), 'B', new ItemStack(ModItems.PaintBrush, 1, 3 ), 'P', Items.paper, 'F', new ItemStack(ModItems.PaintBrush, 1, 4)});
			AddRecipe(new ItemStack(ModBlocks.MachinePart), new Object[]{"PPP", "P P", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.IronPlate, 2, 0), new Object[]{"II", "II", 'I', Items.iron_ingot});
			AddRecipe(new ItemStack(ModItems.IronPlate, 1, 2), new Object[]{"II", "II", 'I', new ItemStack(ModItems.IronPlate, 1, 1)});
			AddRecipe(new ItemStack(ModItems.Wrench), new Object[]{"P P", " P ", " P ", 'P', new ItemStack(ModItems.IronPlate, 1, 0)});
			AddRecipe(new ItemStack(ModItems.Upgrades, 1, 0), new Object[]{"PPP", "BBB", "PPP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'B', ModItems.BigBattery});
            AddRecipe(new ItemStack(ModBlocks.ItemPedestal, 2), new Object[]{"I I", " S ", "SSS", 'I', Items.iron_ingot, 'S', Blocks.stone});
			AddRecipe(new ItemStack(ModBlocks.MiningChamber), new Object[]{"ICI", "IMI", " P ", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'P', Items.diamond_pickaxe, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModItems.Drill), new Object[]{"DD ", "DSI", " IP", 'D', Items.diamond, 'P', ModItems.Battery, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.HeatDrill), new Object[]{"CFP", "FDF", "PFK", 'C', new ItemStack(ModItems.Circuit, 1, 1), 'F', Items.fire_charge, 'D', ModItems.Drill, 'K', Blocks.furnace, 'P', new ItemStack(ModItems.IronPlate, 1, 2)});		
			AddRecipe(new ItemStack(ModItems.Battery, 1, 16), new Object[]{" C ", "IRI", "IRI", 'C', new ItemStack(ModItems.Circuit, 1, 0), 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});		
			AddRecipe(new ItemStack(ModItems.BigBattery, 1, 32), new Object[]{"BCB", 'B', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			AddRecipe(new ItemStack(ModItems.BigBattery, 1, 0), new Object[]{"BCB", 'B', new ItemStack(ModItems.Battery, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 1)});	
			AddRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 64), new Object[]{"BCB", 'B', new ItemStack(ModItems.BigBattery, 1, 32), 'C', new ItemStack(ModItems.Circuit, 1, 1)});
			AddRecipe(new ItemStack(ModItems.AdvancedBattery, 1, 0), new Object[]{"BCB", 'B', new ItemStack(ModItems.BigBattery, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 1)});	
			AddRecipe(new ItemStack(ModItems.ElectricShears), new Object[]{"ISI", "IBI", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.shears, 'B', ModItems.Battery, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.ElectricBow), new Object[]{" IS", "ICB", " IS", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'S', Items.string, 'C', new ItemStack(ModItems.Circuit), 'B', ModItems.Battery});			
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 1), new Object[]{"IGI", "RCR", "IGI", 'I', new ItemStack(Items.dye, 1, 4), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'R', Items.redstone, 'G', Items.glowstone_dust});
			AddRecipe(new ItemStack(ModItems.Circuit, 1, 0), new Object[]{"WIW", "IRI", "WIW", 'W', ModItems.Cardboard, 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'R', Items.redstone});
			AddRecipe(new ItemStack(ModItems.ModuleConnecter), new Object[]{"III", "ICI", "III", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModItems.SolarCells), new Object[]{"IGI", "GCG", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 0), 'G', Blocks.glass, 'C', new ItemStack(ModItems.Circuit, 1, 0)});
			AddRecipe(new ItemStack(ModBlocks.Charger), new Object[]{"ICI", "RMR", "IRI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'R', new ItemStack(ModItems.Battery, 1, 16), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.SolarPanel), new Object[]{"IGI", "GMG", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', ModItems.SolarCells, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.WindMill), new Object[]{"III", "SMS", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'S', ModItems.Turbine, 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart});
			AddRecipe(new ItemStack(ModBlocks.Generator), new Object[]{"III", "FMF", "ICI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'C', new ItemStack(ModItems.Circuit, 1, 0), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace});
			AddRecipe(new ItemStack(ModBlocks.PowerCable, 32), new Object[]{"IGI", "RDR", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', new ItemStack(ModItems.Circuit, 1, 1), 'R', ModItems.ModuleConnecter, 'D', new ItemStack(ModItems.BigBattery, 1, 32)});
			AddRecipe(new ItemStack(ModBlocks.PowerCable, 48), new Object[]{"IGI", "RDR", "IGI", 'I', new ItemStack(ModItems.IronPlate, 1, 2), 'G', new ItemStack(ModItems.Circuit, 1, 1), 'R', ModItems.ModuleConnecter, 'D', new ItemStack(ModItems.BigBattery, 1, 0)});
			AddRecipe(new ItemStack(ModItems.FloatBlockPlacer), new Object[]{"GDP", "DRC", "PCB", 'G', Blocks.glass, 'D', Items.diamond, 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'R', Blocks.redstone_block, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			AddRecipe(new ItemStack(ModItems.AntiFallChestPlate), new Object[]{"PUP", "FCF", "PBP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'U', new ItemStack(ModItems.Upgrades, 1, 0), 'F', ModItems.FloatBlockPlacer, 'C', Items.iron_chestplate, 'B', new ItemStack(ModItems.AdvancedBattery, 1, 0)});
			AddRecipe(new ItemStack(ModItems.InfoScreenHelmet), new Object[]{"IIP", "GCB", "IIP", 'I', new ItemStack(ModItems.IronPlate, 1 ,0), 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'G', Blocks.glass_pane, 'C', new ItemStack(ModItems.Circuit, 1, 1), 'B', new ItemStack(ModItems.Battery, 1, 0)});
			AddRecipe(new ItemStack(Items.saddle), new Object[]{"LLL", "LSL", " I ", 'L', Items.leather, 'S', Items.string, 'I', Items.iron_ingot});
	        AddRecipe(new ItemStack(ModBlocks.Pillar, 4), new Object[]{"QQQ", " Q ", "QQQ", 'Q', Blocks.quartz_block});
	        AddRecipe(new ItemStack(ModBlocks.ElectricFurnace), new Object[]{"PMP", "PFP", "PCP", 'P', new ItemStack(ModItems.IronPlate, 1, 2), 'M', ModBlocks.MachinePart, 'F', Blocks.furnace, 'C', new ItemStack(ModItems.Circuit, 1, 1)});
	        AddRecipe(new ItemStack(ModBlocks.GamePart, 4), new Object[]{"III", " I ", "III", 'I', Items.iron_ingot});
	        

	        
			if(ModConfig.AllowFlightChest)
			GameRegistry.addRecipe(new ItemStack(ModItems.FlightChestPlate), new Object[] {"IFI", "ISI", "III", 'I', ModItems.SilverIngot, 'S', Items.nether_star, 'F', Items.feather});

			GameRegistry.addSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 2.0F);
			GameRegistry.addSmelting(ModBlocks.OrangeLog, new ItemStack(Items.coal, 1, 1), 1.2F);
			GameRegistry.addSmelting(ModItems.Flour, new ItemStack(Items.bread), 1F);
			
			MantleClientRegistry.registerManualFurnaceRecipe("silver_ore_use", new ItemStack(ModItems.SilverIngot), new ItemStack(ModBlocks.SilverOre));
			MantleClientRegistry.registerManualFurnaceRecipe("flour_use", new ItemStack(Items.bread), new ItemStack(ModItems.Flour));
	}
	
	
    public ItemStack Stack(Item item){
    	return new ItemStack(item, 1 ,0);
    }
    
    public ItemStack Stack(Block block){
    	return new ItemStack(block, 1 ,0);
    }
    
    public static void AddRecipe(ItemStack output, Object... Array){
    	GameRegistry.addShapedRecipe(output, Array);
    	RegisterGuideRes(output, Array);
    }
    
    public static void AddShapelessRecipe(ItemStack output, Object... Array){
    	GameRegistry.addShapelessRecipe(output, Array);
    	RegisterShaplessGuideRes(output, Array);
    }
    
    public static void RegisterGuideRes(ItemStack stack, Object ... par2ArrayOfObj)
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
        
        String name = stack.getDisplayName().toLowerCase().replace(" ", "_") + "_res";

        if(aitemstack.length > 4){
        MantleClientRegistry.registerManualLargeRecipe(name, stack, new ItemStack[]{aitemstack[0], aitemstack[1], aitemstack[2], aitemstack[3], aitemstack[4], aitemstack[5], aitemstack[6], aitemstack[7], aitemstack[8]});
        }else{
        	if(aitemstack.length == 1){
        		MantleClientRegistry.registerManualSmallRecipe(name, stack, new ItemStack[]{aitemstack[0], null, null, null});
        		
        	}else if (aitemstack.length == 2){
        		MantleClientRegistry.registerManualSmallRecipe(name, stack, new ItemStack[]{aitemstack[0], aitemstack[1], null, null});
        		
        	}else if (aitemstack.length == 3){
        		MantleClientRegistry.registerManualSmallRecipe(name, stack, new ItemStack[]{aitemstack[0], aitemstack[1], aitemstack[2], null});
        		
        	}else if (aitemstack.length == 4){
        		MantleClientRegistry.registerManualSmallRecipe(name, stack, new ItemStack[]{aitemstack[0], aitemstack[1], aitemstack[2], aitemstack[3]});
        		
        	}else
        		System.err.println("ERROR INVALID RECIPE");
        	
        }
        
        
        }
    
    public static void RegisterShaplessGuideRes(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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
            
            
            String name = par1ItemStack.getDisplayName().toLowerCase().replace(" ", "_") + "_res";

            
            
            	if(arraylist.size() == 1){
            		MantleClientRegistry.registerManualSmallRecipe(name, par1ItemStack, new ItemStack[]{(ItemStack) arraylist.get(0), null, null, null});
            		
            	}else if (arraylist.size()  == 2){
            		MantleClientRegistry.registerManualSmallRecipe(name, par1ItemStack, new ItemStack[]{(ItemStack)arraylist.get(0), (ItemStack)arraylist.get(1), null, null});
            		
            	}else if (arraylist.size()  == 3){
            		MantleClientRegistry.registerManualSmallRecipe(name, par1ItemStack, new ItemStack[]{(ItemStack)arraylist.get(0), (ItemStack)arraylist.get(1), (ItemStack)arraylist.get(2), null});
            		
            	}else if (arraylist.size()  == 4){
            		MantleClientRegistry.registerManualSmallRecipe(name, par1ItemStack, new ItemStack[]{(ItemStack)arraylist.get(0), (ItemStack)arraylist.get(1), (ItemStack)arraylist.get(2),(ItemStack)arraylist.get(3)});
            		
            	}else
            		System.err.println("ERROR INVALID RECIPE");
            	
            }
            
        }

    
}
