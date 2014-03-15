package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

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
	
	public static Item RawPenguinMeat;
	
	public static Item CookedPenguin;
	
	
	
    public static ToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static ArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
	
	public static void Init(){

        Main.config.addCustomCategoryComment("Items", "Disabling items will require a world which has not used the mod before(a new one or a world you have not used the mod in yet)");


        GuideBook = new ModItemGuideBook().setUnlocalizedName("item.guidebook").setCreativeTab(Main.MiscTab).setTextureName(Refrence.Mod_Id + ":" + "book");
        Register(GuideBook, "GuideBook");
		
		XpExtractor = new ModItemXpExtractor().setCreativeTab(Main.MiscTab);
		Register(XpExtractor, StatCollector.translateToLocal("xpextractor"));
		
		SilverIngot = new ModItemSilverIngot().setUnlocalizedName("SilverIngot").setCreativeTab(Main.MiscTab);
		Register(SilverIngot, StatCollector.translateToLocal("silveringot"));
		
		SilverNugget = new ModItemSilverNugget().setUnlocalizedName("SilverNugget").setCreativeTab(Main.MiscTab);
		Register(SilverNugget, StatCollector.translateToLocal("silvernugget"));
		
		SilverSword = new ModItemSilverSword(SilverMaterial).setUnlocalizedName("SilverSword").setCreativeTab(Main.MiscTab);
		Register(SilverSword, StatCollector.translateToLocal("silversword"));
		
		SilverBow = new ModItemSilverBow().setUnlocalizedName("SilverBow").setCreativeTab(Main.MiscTab);
		Register(SilverBow, StatCollector.translateToLocal("silverbow"));
		
		SilverArrow = new ModItemSilverArrow().setUnlocalizedName("SilverArrow").setCreativeTab(Main.MiscTab);
		Register(SilverArrow, StatCollector.translateToLocal("silverarrow"));
		
        DivingHelmet = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 0, 1, "PowerarmorHelmet")).setUnlocalizedName("Powerarmor Helmet").setCreativeTab(Main.MiscTab);
        Register(DivingHelmet, StatCollector.translateToLocal("powerarmor.helmet"));
		
        FlightChestPlate = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 1, 2, "PowerarmorChestplate")).setUnlocalizedName("Powerarmor Chestplate").setCreativeTab(Main.MiscTab);
        Register(FlightChestPlate, StatCollector.translateToLocal("powerarmor.chestplate"));
        
        RunningLeggings = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 2, 3, "PowerarmorLeggings")).setUnlocalizedName("Powerarmor Leggings").setCreativeTab(Main.MiscTab);
        Register(RunningLeggings, StatCollector.translateToLocal("powerarmor.leggings"));
        
        JumpingBoots = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 3, 4, "PowerarmorBoots")).setUnlocalizedName("Powerarmor Boots").setCreativeTab(Main.MiscTab);
        Register(JumpingBoots, StatCollector.translateToLocal("powerarmor.boots"));
        
        Cardboard = new ModItemCardboard().setUnlocalizedName("Cardboard").setCreativeTab(Main.MiscTab);
        Register(Cardboard, StatCollector.translateToLocal("cardboard"));
        
        Tomato = new ModItemTomato(3, 1F, false).setUnlocalizedName("Tomato").setCreativeTab(Main.MiscTab);
        Register(Tomato, StatCollector.translateToLocal("tomato"));
        
        Flour = new ModItemFlour().setUnlocalizedName("Flour").setCreativeTab(Main.MiscTab);
        Register(Flour, StatCollector.translateToLocal("flour"));
        
        TomatoSeeds = new ModItemTomatoSeeds(ModBlocks.TomatoPlant, Blocks.farmland);
        Register(TomatoSeeds, StatCollector.translateToLocal("tomatoseeds"));
        
        PizzaBottom = new ModItemPizzaBottom().setUnlocalizedName("PizzaBottom").setCreativeTab(Main.MiscTab);
        Register(PizzaBottom, StatCollector.translateToLocal("pizzabase"));
        
        Liquid = new ModItemLiquid().setUnlocalizedName("Liquid").setCreativeTab(Main.MiscTab);
        RegisterOutName(Liquid, "Liquid");
        
        Cheese = new ModItemCheese().setUnlocalizedName("Cheese").setCreativeTab(Main.MiscTab);
        Register(Cheese, StatCollector.translateToLocal("cheese"));
        
        PizzaRaw = new ModItemPizzaRaw().setUnlocalizedName("PizzaRaw").setCreativeTab(Main.MiscTab);
        RegisterOutName(PizzaRaw, "Pizza Raw");
        
        Pizza = new ModItemPizza().setUnlocalizedName("Pizza");
        RegisterOutName(Pizza, "Pizza");
        
        Orange = new ModItemOrange().setUnlocalizedName("Orange").setCreativeTab(Main.MiscTab);
        Register(Orange, StatCollector.translateToLocal("orange"));
        
        DisarmStick = new ModItemDisarmStick().setUnlocalizedName("DisarmStick").setCreativeTab(Main.MiscTab);
        Register(DisarmStick, StatCollector.translateToLocal("disarmstick"));
        
        Drill = new ModItemDrill(ToolMaterial.EMERALD).setUnlocalizedName("Drill").setCreativeTab(Main.ElectricTab);
        Register(Drill, StatCollector.translateToLocal("drill"));
        
        Circuit = new ModItemCircuit().setUnlocalizedName("Circuit").setCreativeTab(Main.ElectricTab);
        RegisterOutName(Circuit, "Circuit Board");
        
        ModuleConnecter = new ModItemModuleConnecter().setUnlocalizedName("ModuleConnecter").setCreativeTab(Main.ElectricTab);
        Register(ModuleConnecter, StatCollector.translateToLocal("moduleconnecter"));
        
        SolarCells = new ModItemSolarCells().setUnlocalizedName("SolarCells").setCreativeTab(Main.ElectricTab);
        Register(SolarCells, StatCollector.translateToLocal("solarcells"));
        
        Turbine = new ModItemTurbine().setUnlocalizedName("Turbine").setCreativeTab(Main.ElectricTab);
        Register(Turbine, StatCollector.translateToLocal("turbine"));
        
        Battery = new ModItemBattery().setUnlocalizedName("Battery").setCreativeTab(Main.ElectricTab);
        Register(Battery, StatCollector.translateToLocal("battery"));
        
        BigBattery = new ModItemBigBattery().setUnlocalizedName("BigBattery").setCreativeTab(Main.ElectricTab);
        Register(BigBattery, StatCollector.translateToLocal("bigbattery"));
        
        AdvancedBattery = new ModItemAdvancedBattery().setUnlocalizedName("AdvancedBattery").setCreativeTab(Main.ElectricTab);
        Register(AdvancedBattery, StatCollector.translateToLocal("advancedbattery"));
        
		CreativeBattery = new ModItemCreativeBattery().setUnlocalizedName("CreativeBattery").setCreativeTab(Main.ElectricTab);
		Register(CreativeBattery, "Creative Battery");
        
        ElectricShears = new ModItemElectricShear().setUnlocalizedName("ELShears").setCreativeTab(Main.ElectricTab);
        Register(ElectricShears, StatCollector.translateToLocal("electricshears"));
        
        ElectricBow = new ModItemElectricBow().setUnlocalizedName("ElBow").setCreativeTab(Main.ElectricTab);
        Register(ElectricBow, StatCollector.translateToLocal("electricbow"));
        
        Upgrades = new ModItemUpgrades().setUnlocalizedName("Upgrades").setCreativeTab(Main.ElectricTab);
        RegisterOutName(Upgrades, "Upgrades");
        
        Wrench = new ModItemWrench().setUnlocalizedName("Wrench").setCreativeTab(Main.ElectricTab);
        Register(Wrench, StatCollector.translateToLocal("wrench"));
        
        IronPlate = new ModItemIronPlate().setUnlocalizedName("IronPlate").setCreativeTab(Main.ElectricTab);
        Register(IronPlate, "Iron Plate");
        
        HeatDrill = new ModItemHeatDrill().setUnlocalizedName("HeatDrill").setCreativeTab(Main.ElectricTab);
        Register(HeatDrill, StatCollector.translateToLocal("heatdrill"));
        
        PaintBrush = new ModItemPaintBrush().setUnlocalizedName("PaintBrush").setCreativeTab(Main.MiscTab);
        RegisterOutName(PaintBrush, "Paint Brush");
        
        FloatBlockPlacer = new ModItemFloatBlockPlacer().setUnlocalizedName("FloatPlacer").setTextureName(Refrence.Mod_Id + ":FloatBlockPlacer").setCreativeTab(Main.ElectricTab);
        Register(FloatBlockPlacer, StatCollector.translateToLocal("floatblockplacer"));
        
        Main.proxy.addArmor("AntiFall");
        
        AntiFallChestPlate = (new ModItemAntiFallChest(1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Refrence.Mod_Id + ":AntiFallChest").setCreativeTab(Main.ElectricTab);
        Register(AntiFallChestPlate, StatCollector.translateToLocal("antifallchestplate"));
        
        InfoScreenHelmet = new ModItemInfoScreenHelmet(1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Refrence.Mod_Id + ":InfoScreenHelmet").setCreativeTab(Main.ElectricTab);
        Register(InfoScreenHelmet, StatCollector.translateToLocal("infoscreen"));
        
        DataChip = new ModItemDataChip().setUnlocalizedName("DataChip").setCreativeTab(Main.ElectricTab);
        Register(DataChip, "Data Chip");
		
		Lens = new ModItemLens().setUnlocalizedName("Lens").setCreativeTab(Main.ElectricTab);
		Register(Lens, "Lens");
		
		CookedPenguin = new CookedPenguinMeat(6002, 4, true).setUnlocalizedName("CookedPenguin").setCreativeTab(CreativeTabs.tabFood);
		Register(CookedPenguin, "CookedPenguin");
		
		RawPenguinMeat = new RawPenguinMeat(6001, 1, true).setUnlocalizedName("RawPenguinMeat").setCreativeTab(CreativeTabs.tabFood);
		Register(RawPenguinMeat, "RawPenguinMeat");
		
		
		
	RegisterOreDictionary(new ItemStack(SilverIngot), "ingotSilver");
	RegisterOreDictionary(new ItemStack(SilverNugget), "nuggetSilver");
		
	
	
    Main.config.save();
		
		
		
		
	}
	
	
	public static void RegisterOreDictionary(ItemStack Item, String dictonaryName){
		
		OreDictionary.registerOre(dictonaryName, Item);
		
	}
	
	public static void Register(Item Item, String Name){
		
		
		if(Main.config.get("Items", "Enable " + Name + "?", true).getBoolean(true)){
			
        Item.setUnlocalizedName((Name.toLowerCase().replace(" ", "_")));
        GameRegistry.registerItem(Item, (Name.toLowerCase().replace(" ", "_")));
	}
	}
	
	public static void RegisterOutName(Item Item, String Name){
		
		
        GameRegistry.registerItem(Item, Name.toLowerCase().replace(" ", ""));

	}
}
