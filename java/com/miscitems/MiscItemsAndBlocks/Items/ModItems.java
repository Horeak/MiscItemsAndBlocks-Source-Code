package com.miscitems.MiscItemsAndBlocks.Items;

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
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Item CreativeBattery;
	
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
	
	public static Item Lens;
	
	public static Item GuideBook;
	
	
	
	
	
    public static ToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static ArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
	
	public static void Init(){
		
        GuideBook = new ModItemGuideBook().setUnlocalizedName("item.guidebook").setCreativeTab(Main.CreativeTab).setTextureName(Refrence.Mod_Id + ":" + "book");
        Register(GuideBook, "GuideBook");
		
		XpExtractor = new ModItemXpExtractor();
		Register(XpExtractor, StatCollector.translateToLocal("xpextractor"));
		
		SilverIngot = new ModItemSilverIngot().setUnlocalizedName("SilverIngot");
		Register(SilverIngot, StatCollector.translateToLocal("silveringot"));
		
		SilverNugget = new ModItemSilverNugget().setUnlocalizedName("SilverNugget");
		Register(SilverNugget, StatCollector.translateToLocal("silvernugget"));
		
		SilverSword = new ModItemSilverSword(SilverMaterial).setUnlocalizedName("SilverSword");
		Register(SilverSword, StatCollector.translateToLocal("silversword"));
		
		SilverBow = new ModItemSilverBow().setUnlocalizedName("SilverBow");
		Register(SilverBow, StatCollector.translateToLocal("silverbow"));
		
		SilverArrow = new ModItemSilverArrow().setUnlocalizedName("SilverArrow");
		Register(SilverArrow, StatCollector.translateToLocal("silverarrow"));
		
        DivingHelmet = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 0, 1, "DivingHelmet")).setUnlocalizedName("DivingHelmet");
        Register(DivingHelmet, StatCollector.translateToLocal("powerarmor.helmet"));
		
        FlightChestPlate = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 1, 2, "FlightChestplate")).setUnlocalizedName("FlightChestplate");
        Register(FlightChestPlate, StatCollector.translateToLocal("powerarmor.chestplate"));
        
        RunningLeggings = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 2, 3, "RunningLeggings")).setUnlocalizedName("RunningLeggings");
        Register(RunningLeggings, StatCollector.translateToLocal("powerarmor.leggings"));
        
        JumpingBoots = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 3, 4, "JumpingBoots")).setUnlocalizedName("JumpingBoots");
        Register(JumpingBoots, StatCollector.translateToLocal("powerarmor.boots"));
        
        Cardboard = new ModItemCardboard().setUnlocalizedName("Cardboard");
        Register(Cardboard, StatCollector.translateToLocal("cardboard"));
        
        Tomato = new ModItemTomato(3, 1F, false).setUnlocalizedName("Tomato");
        Register(Tomato, StatCollector.translateToLocal("tomato"));
        
        Flour = new ModItemFlour().setUnlocalizedName("Flour");
        Register(Flour, StatCollector.translateToLocal("flour"));
        
        TomatoSeeds = new ModItemTomatoSeeds(ModBlocks.TomatoPlant, Blocks.farmland);
        Register(TomatoSeeds, StatCollector.translateToLocal("tomatoseeds"));
        
        PizzaBottom = new ModItemPizzaBottom().setUnlocalizedName("PizzaBottom");
        Register(PizzaBottom, StatCollector.translateToLocal("pizzabase"));
        
        Liquid = new ModItemLiquid().setUnlocalizedName("Liquid");
        RegisterOutName(Liquid, "Liquid");
        
        Cheese = new ModItemCheese().setUnlocalizedName("Cheese");
        Register(Cheese, StatCollector.translateToLocal("cheese"));
        
        PizzaRaw = new ModItemPizzaRaw().setUnlocalizedName("PizzaRaw");
        RegisterOutName(PizzaRaw, "Pizza Raw");
        
        Pizza = new ModItemPizza().setUnlocalizedName("Pizza");
        RegisterOutName(Pizza, "Pizza");
        
        Orange = new ModItemOrange().setUnlocalizedName("Orange");
        Register(Orange, StatCollector.translateToLocal("orange"));
        
        DisarmStick = new ModItemDisarmStick().setUnlocalizedName("DisarmStick");
        Register(DisarmStick, StatCollector.translateToLocal("disarmstick"));
        
        Drill = new ModItemDrill(ToolMaterial.EMERALD).setUnlocalizedName("Drill");
        Register(Drill, StatCollector.translateToLocal("drill"));
        
        Circuit = new ModItemCircuit().setUnlocalizedName("Circuit");
        RegisterOutName(Circuit, "Circuit Board");
        
        ModuleConnecter = new ModItemModuleConnecter().setUnlocalizedName("ModuleConnecter");
        Register(ModuleConnecter, StatCollector.translateToLocal("moduleconnecter"));
        
        SolarCells = new ModItemSolarCells().setUnlocalizedName("SolarCells");
        Register(SolarCells, StatCollector.translateToLocal("solarcells"));
        
        Turbine = new ModItemTurbine().setUnlocalizedName("Turbine");
        Register(Turbine, StatCollector.translateToLocal("turbine"));
        
        Battery = new ModItemBattery().setUnlocalizedName("Battery");
        Register(Battery, StatCollector.translateToLocal("battery"));
        
        BigBattery = new ModItemBigBattery().setUnlocalizedName("BigBattery");
        Register(BigBattery, StatCollector.translateToLocal("bigbattery"));
        
        AdvancedBattery = new ModItemAdvancedBattery().setUnlocalizedName("AdvancedBattery");
        Register(AdvancedBattery, StatCollector.translateToLocal("advancedbattery"));
        
        ElectricShears = new ModItemElectricShear().setUnlocalizedName("ELShears");
        Register(ElectricShears, StatCollector.translateToLocal("electricshears"));
        
        ElectricBow = new ModItemElectricBow().setUnlocalizedName("ElBow");
        Register(ElectricBow, StatCollector.translateToLocal("electricbow"));
        
       Upgrades = new ModItemUpgrades().setUnlocalizedName("Upgrades");
        RegisterOutName(Upgrades, "Upgrades");
        
        Wrench = new ModItemWrench().setUnlocalizedName("Wrench");
        Register(Wrench, StatCollector.translateToLocal("wrench"));
        
        IronPlate = new ModItemIronPlate().setUnlocalizedName("IronPlate");
        Register(IronPlate, "Iron Plate");
        
        HeatDrill = new ModItemHeatDrill().setUnlocalizedName("HeatDrill");
        Register(HeatDrill, StatCollector.translateToLocal("heatdrill"));
        
        PaintBrush = new ModItemPaintBrush().setUnlocalizedName("PaintBrush");
        RegisterOutName(PaintBrush, "Paint Brush");
        
        FloatBlockPlacer = new ModItemFloatBlockPlacer().setUnlocalizedName("FloatPlacer").setTextureName(Refrence.Mod_Id + ":FloatBlockPlacer");
        Register(FloatBlockPlacer, StatCollector.translateToLocal("floatblockplacer"));
        
        Main.proxy.addArmor("AntiFall");
        
        AntiFallChestPlate = (new ModItemAntiFallChest(1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Refrence.Mod_Id + ":AntiFallChest");
        Register(AntiFallChestPlate, StatCollector.translateToLocal("antifallchestplate"));
        
        InfoScreenHelmet = new ModItemInfoScreenHelmet(1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Refrence.Mod_Id + ":InfoScreenHelmet");
        Register(InfoScreenHelmet, StatCollector.translateToLocal("infoscreen"));
        
        DataChip = new ModItemDataChip().setUnlocalizedName("DataChip");
        Register(DataChip, "Data Chip");
        
        Lens = new ModItemLens().setUnlocalizedName("Lens");
        Register(Lens, "Lens");
        
		CreativeBattery = new ModItemCreativeBattery().setUnlocalizedName("CreativeBattery");
		Register(CreativeBattery, "Creative Battery");
		
		
		
		
		
	RegisterOreDictionary(new ItemStack(SilverIngot), "ingotSilver");
	RegisterOreDictionary(new ItemStack(SilverNugget), "nuggetSilver");
		
	
	
    Main.config.save();
		
		
		
		
	}
	
	
	public static void RegisterOreDictionary(ItemStack Item, String dictonaryName){
		
		OreDictionary.registerOre(dictonaryName, Item);
		
	}
	
	public static void Register(Item Item, String Name){
		
		
		if(Main.config.get("Enable/Disable Items", "Enable " + Name + "?", true).getBoolean(true)){
			
        Item.setUnlocalizedName((Name.toLowerCase().replace(" ", "_")));
        GameRegistry.registerItem(Item, (Name.toLowerCase().replace(" ", "_")));
        Item.setCreativeTab(Main.CreativeTab);
	}
	}
	
	public static void RegisterOutName(Item Item, String Name){
		
		
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));
        Item.setCreativeTab(Main.CreativeTab);
	}
}
