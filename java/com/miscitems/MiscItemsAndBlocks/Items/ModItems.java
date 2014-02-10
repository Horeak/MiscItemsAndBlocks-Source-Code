package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Lib.ModConfig;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	
	public static Item XpExtractor;
	public static Item SilverIngot;
	public static Item SilverNugget;
	public static Item SilverSword;
	public static Item SilverBow;
	public static Item SilverArrow;
	public static Item Cardboard;
	public static Item Tomato;
	public static Item Flour;
	public static ItemSeeds TomatoSeeds;
	public static Item Liquid;
	public static Item Cheese;
	public static Item Orange;
	public static Item DisarmStick;
	
	public static Item Drill;
	public static Item ElectricShears;
	public static Item ElectricBow;
	
	public static Item Battery;
	public static Item BigBattery;
	public static Item AdvancedBattery;
	
	public static Item Circuit;
	public static Item ModuleConnecter;
	public static Item SolarCells;
	public static Item Turbine;
	
	
	public static Item PizzaBottom;
	public static Item PizzaRaw;
	public static Item Pizza;
	
	public static Item Upgrades;
	public static Item Wrench;
	public static Item IronPlate;
	public static Item HeatDrill;
	
	public static Item PaintBrush;
	public static Item DataChip;
	
	public static Item DivingHelmet;
	public static Item FlightChestPlate;
	public static Item RunningLeggings;
	public static Item JumpingBoots;
	
	public static Item FloatBlockPlacer;
	public static Item AntiFallChestPlate;
	public static Item InfoScreenHelmet;
	
	
	
	
	
    public static ToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static ArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
	
	public static void Init(){
		
		XpExtractor = new ModItemXpExtractor();
		Register(XpExtractor, StatCollector.translateToLocal("items.name.xpextractor"));
		
		SilverIngot = new ModItemSilverIngot().setUnlocalizedName("SilverIngot");
		Register(SilverIngot, StatCollector.translateToLocal("items.name.silveringot"));
		
		SilverNugget = new ModItemSilverNugget().setUnlocalizedName("SilverNugget");
		Register(SilverNugget, StatCollector.translateToLocal("items.name.silvernugget"));
		
		SilverSword = new ModItemSilverSword(SilverMaterial).setUnlocalizedName("SilverSword");
		Register(SilverSword, StatCollector.translateToLocal("items.name.silversword"));
		
		SilverBow = new ModItemSilverBow().setUnlocalizedName("SilverBow");
		Register(SilverBow, StatCollector.translateToLocal("items.name.silverbow"));
		
		SilverArrow = new ModItemSilverArrow().setUnlocalizedName("SilverArrow");
		Register(SilverArrow, StatCollector.translateToLocal("items.name.silverarrow"));
		
        DivingHelmet = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 0, 1)).setUnlocalizedName("DivingHelmet");
        Register(DivingHelmet, StatCollector.translateToLocal("items.name.powerarmor.helmet"));
		
        FlightChestPlate = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 1, 2)).setUnlocalizedName("FlightChestplate");
        Register(FlightChestPlate, StatCollector.translateToLocal("items.name.powerarmor.chestplate"));
        
        RunningLeggings = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 2, 3)).setUnlocalizedName("RunningLeggings");
        Register(RunningLeggings, StatCollector.translateToLocal("items.name.powerarmor.leggings"));
        
        JumpingBoots = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 3, 4)).setUnlocalizedName("JumpingBoots");
        Register(JumpingBoots, StatCollector.translateToLocal("items.name.powerarmor.boots"));
        
        Cardboard = new ModItemCardboard().setUnlocalizedName("Cardboard");
        Register(Cardboard, StatCollector.translateToLocal("items.name.cardboard"));
        
        Tomato = new ModItemTomato(3, 1F, false).setUnlocalizedName("Tomato");
        Register(Tomato, StatCollector.translateToLocal("items.name.tomato"));
        
        Flour = new ModItemFlour().setUnlocalizedName("Flour");
        Register(Flour, StatCollector.translateToLocal("items.name.flour"));
        
        TomatoSeeds = new ModItemTomatoSeeds(ModBlocks.TomatoPlant, Blocks.farmland);
        Register(TomatoSeeds, StatCollector.translateToLocal("items.name.tomatoseeds"));
        
        PizzaBottom = new ModItemPizzaBottom().setUnlocalizedName("PizzaBottom");
        Register(PizzaBottom, StatCollector.translateToLocal("items.name.pizzabase"));
        
        Liquid = new ModItemLiquid().setUnlocalizedName("Liquid");
        RegisterOutName(Liquid, "Liquid");
        
        Cheese = new ModItemCheese().setUnlocalizedName("Cheese");
        Register(Cheese, StatCollector.translateToLocal("items.name.cheese"));
        
        PizzaRaw = new ModItemPizzaRaw().setUnlocalizedName("PizzaRaw");
        RegisterOutName(PizzaRaw, "Pizza Raw");
        
        Pizza = new ModItemPizza().setUnlocalizedName("Pizza");
        RegisterOutName(Pizza, "Pizza");
        
        Orange = new ModItemOrange().setUnlocalizedName("Orange");
        Register(Orange, StatCollector.translateToLocal("items.name.orange"));
        
        DisarmStick = new ModItemDisarmStick().setUnlocalizedName("DisarmStick");
        Register(DisarmStick, StatCollector.translateToLocal("items.name.disarmstick"));
        
        Drill = new ModItemDrill(ToolMaterial.EMERALD).setUnlocalizedName("Drill");
        Register(Drill, StatCollector.translateToLocal("items.name.drill"));
        
        Circuit = new ModItemCircuit().setUnlocalizedName("Circuit");
        RegisterOutName(Circuit, "Circuit Board");
        
        ModuleConnecter = new ModItemModuleConnecter().setUnlocalizedName("ModuleConnecter");
        Register(ModuleConnecter, StatCollector.translateToLocal("items.name.moduleconnecter"));
        
        SolarCells = new ModItemSolarCells().setUnlocalizedName("SolarCells");
        Register(SolarCells, StatCollector.translateToLocal("items.name.solarcells"));
        
        Turbine = new ModItemTurbine().setUnlocalizedName("Turbine");
        Register(Turbine, StatCollector.translateToLocal("items.name.turbine"));
        
        Battery = new ModItemBattery().setUnlocalizedName("Battery");
        Register(Battery, StatCollector.translateToLocal("items.name.battery"));
        
        BigBattery = new ModItemBigBattery().setUnlocalizedName("BigBattery");
        Register(BigBattery, StatCollector.translateToLocal("items.name.bigbattery"));
        
        AdvancedBattery = new ModItemAdvancedBattery().setUnlocalizedName("AdvancedBattery");
        Register(AdvancedBattery, StatCollector.translateToLocal("items.name.advancedbattery"));
        
        ElectricShears = new ModItemElectricShear().setUnlocalizedName("ELShears");
        Register(ElectricShears, StatCollector.translateToLocal("items.name.electricshears"));
        
        ElectricBow = new ModItemElectricBow().setUnlocalizedName("ElBow");
        Register(ElectricBow, StatCollector.translateToLocal("items.name.electricbow"));
        
       Upgrades = new ModItemUpgrades().setUnlocalizedName("Upgrades");
        RegisterOutName(Upgrades, "Upgrades");
        
        Wrench = new ModItemWrench().setUnlocalizedName("Wrench");
        Register(Wrench, StatCollector.translateToLocal("items.name.wrench"));
        
        IronPlate = new ModItemIronPlate().setUnlocalizedName("IronPlate");
        Register(IronPlate, "Iron Plate");
        
        HeatDrill = new ModItemHeatDrill().setUnlocalizedName("HeatDrill");
        Register(HeatDrill, StatCollector.translateToLocal("items.name.heatdrill"));
        
        PaintBrush = new ModItemPaintBrush().setUnlocalizedName("PaintBrush");
        RegisterOutName(PaintBrush, "Paint Brush");
        
        FloatBlockPlacer = new ModItemFloatBlockPlacer().setUnlocalizedName("FloatPlacer").setTextureName(Refrence.Mod_Id + ":FloatBlockPlacer");
        Register(FloatBlockPlacer, StatCollector.translateToLocal("items.name.floatblockplacer"));
        
        Main.proxy.addArmor("AntiFall");
        
        AntiFallChestPlate = (new ModItemAntiFallChest(1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Refrence.Mod_Id + ":AntiFallChest");
        Register(AntiFallChestPlate, StatCollector.translateToLocal("items.name.antifallchestplate"));
        
        InfoScreenHelmet = new ModItemInfoScreenHelmet(1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Refrence.Mod_Id + ":InfoScreenHelmet");
        Register(InfoScreenHelmet, StatCollector.translateToLocal("items.name.infoscreen"));
        
        DataChip = new ModItemDataChip().setUnlocalizedName("DataChip");
        Register(DataChip, "Data Chip");
		
		
	RegisterOreDictionary(new ItemStack(SilverIngot), "ingotSilver");
	RegisterOreDictionary(new ItemStack(SilverNugget), "nuggetSilver");
		
		
		
		
		
	}
	
	
	public static void RegisterOreDictionary(ItemStack Item, String dictonaryName){
		
		OreDictionary.registerOre(dictonaryName, Item);
		
	}
	
	public static void Register(Item Item, String Name){
		
		
        Item.setUnlocalizedName((Name.toLowerCase().replace(" ", "_")));
        GameRegistry.registerItem(Item, (Name.toLowerCase().replace(" ", "_")));
        Item.setCreativeTab(Main.CreativeTab);
	}
	
	public static void RegisterOutName(Item Item, String Name){
		
		
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));
        Item.setCreativeTab(Main.CreativeTab);
	}
}
