package com.miscitems.MiscItemsAndBlocks.Main;

import MiscUtils.Register.ItemRegister;
import MiscUtils.Register.OreDictionaryRegister;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemAdvancedBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemAntiFallChest;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemBigBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemCircuit;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDrill;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElectricBow;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElectricShear;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemFloatBlockPlacer;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemHeatDrill;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemInfoScreenHelmet;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemIronPlate;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemLens;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemUpgrades;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemWrench;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemCheese;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemLiquid;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemOrange;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemPizza;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemPizzaRaw;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemTomato;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemTomatoSeeds;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemDisarmStick;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemPaintBrush;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemPowerArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemSilverBow;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemSilverSword;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemXpExtractor;
import com.miscitems.MiscItemsAndBlocks.Utils.IconRegisteringItemClass;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

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
	public static Item CableItem;
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


    private static Item IconItem;




    public static ToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static ArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);


    public static void Init(){

        ItemRegister Utils = new ItemRegister(Main.config, Reference.Mod_Id);


		XpExtractor = new ModItemXpExtractor().setCreativeTab(Main.MiscTab);
        Utils.Register(XpExtractor, ("xp extractor"));

		SilverIngot = new Item().setUnlocalizedName("SilverIngot").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverIngot");
        Utils.Register(SilverIngot, ("silver ingot"));

		SilverNugget = new Item().setUnlocalizedName("SilverNugget").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverNugget");
        Utils.Register(SilverNugget, ("silver nugget"));

		SilverSword = new ModItemSilverSword(SilverMaterial).setUnlocalizedName("SilverSword").setCreativeTab(Main.MiscTab);
        Utils.Register(SilverSword, ("silver sword"));

		SilverBow = new ModItemSilverBow().setUnlocalizedName("SilverBow").setCreativeTab(Main.MiscTab);
        Utils.Register(SilverBow, ("silver bow"));

		SilverArrow = new Item().setUnlocalizedName("SilverArrow").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverArrow");
        Utils.Register(SilverArrow, ("silver arrow"));

        DivingHelmet = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 0, 1, "PowerarmorHelmet")).setUnlocalizedName("Powerarmor Helmet").setCreativeTab(Main.MiscTab);
        Utils.Register(DivingHelmet, ("power armor.helmet"));

        FlightChestPlate = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 1, 2, "PowerarmorChestplate")).setUnlocalizedName("Powerarmor Chestplate").setCreativeTab(Main.MiscTab);
        Utils.Register(FlightChestPlate, ("power armor.chestplate"));

        RunningLeggings = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 2, 3, "PowerarmorLeggings")).setUnlocalizedName("Powerarmor Leggings").setCreativeTab(Main.MiscTab);
        Utils.Register(RunningLeggings, ("power armor.leggings"));

        JumpingBoots = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 3, 4, "PowerarmorBoots")).setUnlocalizedName("Powerarmor Boots").setCreativeTab(Main.MiscTab);
        Utils.Register(JumpingBoots, ("power armor.boots"));


        Cardboard = new Item().setUnlocalizedName("Cardboard").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":Cardboard");
        Utils.Register(Cardboard, ("cardboard"));

        Tomato = new ModItemTomato(3, 1F, false).setUnlocalizedName("Tomato").setCreativeTab(Main.MiscTab);
        Utils.Register(Tomato, ("tomato"));

        Flour = new Item().setUnlocalizedName("Flour").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":Flour");
        Utils.Register(Flour, ("flour"));

        TomatoSeeds = new ModItemTomatoSeeds(ModBlocks.TomatoPlant, Blocks.farmland);
        Utils.Register(TomatoSeeds, ("tomato seeds"));

        PizzaBottom = new Item().setUnlocalizedName("PizzaBottom").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":PizzaBottom");
        Utils.Register(PizzaBottom, ("pizza base"));

        Liquid = new ModItemLiquid().setUnlocalizedName("Liquid").setCreativeTab(Main.MiscTab);
        Utils.RegisterOutName(Liquid, "Liquid");

        Cheese = new ModItemCheese().setUnlocalizedName("Cheese").setCreativeTab(Main.MiscTab);
        Utils.Register(Cheese, ("cheese"));

        PizzaRaw = new ModItemPizzaRaw().setUnlocalizedName("PizzaRaw").setCreativeTab(Main.MiscTab);
        Utils.RegisterOutName(PizzaRaw, "Pizza Raw");

        Pizza = new ModItemPizza().setUnlocalizedName("Pizza").setCreativeTab(Main.MiscTab);
        Utils.RegisterOutName(Pizza, "Pizza");

        Orange = new ModItemOrange().setUnlocalizedName("Orange").setCreativeTab(Main.MiscTab);
        Utils.Register(Orange, ("orange"));

        DisarmStick = new ModItemDisarmStick().setUnlocalizedName("DisarmStick");
        Utils.Register(DisarmStick, ("disarm stick"));

        Drill = new ModItemDrill(ToolMaterial.EMERALD).setUnlocalizedName("Drill").setCreativeTab(Main.ElectricTab);
        Utils.Register(Drill, ("drill"));

        Circuit = new ModItemCircuit().setUnlocalizedName("Circuit").setCreativeTab(Main.ElectricTab);
        Utils.RegisterOutName(Circuit, "Circuit Board");

        CableItem = new Item().setUnlocalizedName("CableItem").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":CableItem");
        Utils.Register(CableItem, ("cable"));

        SolarCells = new Item().setUnlocalizedName("SolarCells").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":SolarCells");
        Utils.Register(SolarCells, ("solar cells"));

        Turbine = new Item().setUnlocalizedName("Turbine").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":Turbine");
        Utils.Register(Turbine, ("turbine"));

        Battery = new ModItemBattery().setUnlocalizedName("Battery").setCreativeTab(Main.ElectricTab);
        Utils.Register(Battery, ("battery"));

        BigBattery = new ModItemBigBattery().setUnlocalizedName("BigBattery").setCreativeTab(Main.ElectricTab);
        Utils.Register(BigBattery, ("big battery"));

        AdvancedBattery = new ModItemAdvancedBattery().setUnlocalizedName("AdvancedBattery").setCreativeTab(Main.ElectricTab);
        Utils.Register(AdvancedBattery, ("advanced battery"));

        ElectricShears = new ModItemElectricShear().setUnlocalizedName("ELShears").setCreativeTab(Main.ElectricTab);
        Utils.Register(ElectricShears, ("electric shears"));

        ElectricBow = new ModItemElectricBow().setUnlocalizedName("ElBow").setCreativeTab(Main.ElectricTab);
        Utils.Register(ElectricBow, ("electric bow"));

        Upgrades = new ModItemUpgrades().setUnlocalizedName("Upgrades").setCreativeTab(Main.ElectricTab);
        Utils.RegisterOutName(Upgrades, "Upgrades");

        Wrench = new ModItemWrench().setUnlocalizedName("Wrench").setCreativeTab(Main.ElectricTab);
        Utils.Register(Wrench, ("wrench"));

        IronPlate = new ModItemIronPlate().setUnlocalizedName("IronPlate").setCreativeTab(Main.ElectricTab);
        Utils.Register(IronPlate, "Iron Plate");

        HeatDrill = new ModItemHeatDrill().setUnlocalizedName("HeatDrill").setCreativeTab(Main.ElectricTab);
        Utils.Register(HeatDrill, ("heat drill"));

        PaintBrush = new ModItemPaintBrush().setUnlocalizedName("PaintBrush").setCreativeTab(Main.MiscTab);
        Utils.RegisterOutName(PaintBrush, "Paint Brush");

        FloatBlockPlacer = new ModItemFloatBlockPlacer().setUnlocalizedName("FloatPlacer").setTextureName(Reference.Mod_Id + ":FloatBlockPlacer").setCreativeTab(Main.ElectricTab);
        Utils.Register(FloatBlockPlacer, ("float block placer"));

        Main.proxy.addArmor("AntiFall");

        AntiFallChestPlate = (new ModItemAntiFallChest(1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Reference.Mod_Id + ":AntiFallChest").setCreativeTab(Main.ElectricTab);
        Utils.Register(AntiFallChestPlate, ("anti fall chestplate"));

        InfoScreenHelmet = new ModItemInfoScreenHelmet(1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Reference.Mod_Id + ":InfoScreenHelmet").setCreativeTab(Main.ElectricTab);
        Utils.Register(InfoScreenHelmet, ("info screen"));

        DataChip = new ModItemDataChip().setUnlocalizedName("DataChip").setCreativeTab(Main.ElectricTab);
        Utils.Register(DataChip, "Data Chip");

		Lens = new ModItemLens().setUnlocalizedName("Lens").setCreativeTab(Main.ElectricTab);
        Utils.Register(Lens, "Lens");


        IconItem = new IconRegisteringItemClass();
        Utils.SilentRegister(IconItem);






        OreDictionaryRegister OreUtils = new OreDictionaryRegister(Main.config);

        OreUtils.RegisterOreDictionary("ingotSilver", new ItemStack(SilverIngot));
        OreUtils.RegisterOreDictionary("nuggetSilver", new ItemStack(SilverNugget));
		
		
	}


}
