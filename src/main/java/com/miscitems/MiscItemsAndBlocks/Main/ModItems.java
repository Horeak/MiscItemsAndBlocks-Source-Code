package com.miscitems.MiscItemsAndBlocks.Main;

import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemAdvancedBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemAntiFallChest;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemBigBattery;
import com.miscitems.MiscItemsAndBlocks.Item.Magic.ModItemChargedCrystal;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemCheese;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemCircuit;
import com.miscitems.MiscItemsAndBlocks.Item.Magic.ModItemCrystalBlade;
import com.miscitems.MiscItemsAndBlocks.Item.Magic.ModItemCrystalPickaxe;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemDisarmStick;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDrill;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElectricBow;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElectricShear;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemFloatBlockPlacer;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemGuideBook;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemHeatDrill;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemInfoScreenHelmet;
import com.miscitems.MiscItemsAndBlocks.Item.Magic.ModItemInvisArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Magic.ModItemInvisibilityCore;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemIronPlate;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemLens;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemLiquid;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemOrange;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemPaintBrush;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemPizza;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemPizzaRaw;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemPowerArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemSilverBow;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemSilverSword;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemTomato;
import com.miscitems.MiscItemsAndBlocks.Item.ModItemTomatoSeeds;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemUpgrades;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemWrench;
import com.miscitems.MiscItemsAndBlocks.Item.Tools.ModItemXpExtractor;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.IconRegisteringItemClass;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
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
	
	public static Item GuideBook;

    public static Item InvisHelmet, InvisChestPlate, InvisLeggings, InvisBoots;
    public static Item BlueCrystal, GreenCrystal, RedCrystal, ChargedCrystal, InvisibilityCore;
    public static Item CrystalSilk, CrystalBlade, CrystalPickaxe, CrystalInfusedMetal, CrystalInfusedGem;

    private static Item IconItem;




    public static ToolMaterial SilverMaterial = EnumHelper.addToolMaterial("Silver", 5, 257, 13.0F, 0.0F, 45);
    public static ArmorMaterial PowerArmor = EnumHelper.addArmorMaterial("PowerArmor", 37, new int[] {2, 4, 3, 2} , 30);
    public static ArmorMaterial InvisArmor = EnumHelper.addArmorMaterial("InvisArmor", 1, new int[]{0, 0, 0, 0}, 0);

	public static void Init(){



        GuideBook = new ModItemGuideBook().setUnlocalizedName("item.guidebook").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":" + "book");
        Register(GuideBook, "GuideBook");

		XpExtractor = new ModItemXpExtractor().setCreativeTab(Main.MiscTab);
		Register(XpExtractor, ("xpextractor"));

		SilverIngot = new Item().setUnlocalizedName("SilverIngot").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverIngot");
		Register(SilverIngot, ("silveringot"));

		SilverNugget = new Item().setUnlocalizedName("SilverNugget").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverNugget");
		Register(SilverNugget, ("silvernugget"));

		SilverSword = new ModItemSilverSword(SilverMaterial).setUnlocalizedName("SilverSword").setCreativeTab(Main.MiscTab);
		Register(SilverSword, ("silversword"));

		SilverBow = new ModItemSilverBow().setUnlocalizedName("SilverBow").setCreativeTab(Main.MiscTab);
		Register(SilverBow, ("silverbow"));

		SilverArrow = new Item().setUnlocalizedName("SilverArrow").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":SilverArrow");
		Register(SilverArrow, ("silverarrow"));

        DivingHelmet = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 0, 1, "PowerarmorHelmet")).setUnlocalizedName("Powerarmor Helmet").setCreativeTab(Main.MiscTab);
        Register(DivingHelmet, ("powerarmor.helmet"));

        FlightChestPlate = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 1, 2, "PowerarmorChestplate")).setUnlocalizedName("Powerarmor Chestplate").setCreativeTab(Main.MiscTab);
        Register(FlightChestPlate, ("powerarmor.chestplate"));

        RunningLeggings = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 2, 3, "PowerarmorLeggings")).setUnlocalizedName("Powerarmor Leggings").setCreativeTab(Main.MiscTab);
        Register(RunningLeggings, ("powerarmor.leggings"));

        JumpingBoots = (new ModItemPowerArmor(PowerArmor, Main.proxy.addArmor("Power"), 3, 4, "PowerarmorBoots")).setUnlocalizedName("Powerarmor Boots").setCreativeTab(Main.MiscTab);
        Register(JumpingBoots, ("powerarmor.boots"));

        InvisHelmet =  (new ModItemInvisArmor(InvisArmor, Main.proxy.addArmor("Invis"), 0, 1)).setUnlocalizedName("InvisHelmet").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:InvisHelmet");
        Register(InvisHelmet, "InvisHelmet");

        InvisChestPlate =  (new ModItemInvisArmor(InvisArmor, Main.proxy.addArmor("Invis"), 1, 2)).setUnlocalizedName("InvisChestPlate").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:InvisChestPlate");
        Register(InvisChestPlate, "InvisChestPlate");

        InvisLeggings =  (new ModItemInvisArmor(InvisArmor, Main.proxy.addArmor("Invis"), 2, 3)).setUnlocalizedName("InvisLeggings").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:InvisLeggings");
        Register(InvisLeggings, "InvisLeggings");

        InvisBoots =  (new ModItemInvisArmor(InvisArmor, Main.proxy.addArmor("Invis"), 3, 4)).setUnlocalizedName("InvisBoots").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:InvisBoots");
        Register(InvisBoots, "InvisBoots");

        Cardboard = new Item().setUnlocalizedName("Cardboard").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":Cardboard");
        Register(Cardboard, ("cardboard"));

        Tomato = new ModItemTomato(3, 1F, false).setUnlocalizedName("Tomato").setCreativeTab(Main.MiscTab);
        Register(Tomato, ("tomato"));

        Flour = new Item().setUnlocalizedName("Flour").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":Flour");
        Register(Flour, ("flour"));

        TomatoSeeds = new ModItemTomatoSeeds(ModBlocks.TomatoPlant, Blocks.farmland);
        Register(TomatoSeeds, ("tomatoseeds"));

        PizzaBottom = new Item().setUnlocalizedName("PizzaBottom").setCreativeTab(Main.MiscTab).setTextureName(Reference.Mod_Id + ":PizzaBottom");
        Register(PizzaBottom, ("pizzabase"));

        Liquid = new ModItemLiquid().setUnlocalizedName("Liquid").setCreativeTab(Main.MiscTab);
        RegisterOutName(Liquid, "Liquid");

        Cheese = new ModItemCheese().setUnlocalizedName("Cheese").setCreativeTab(Main.MiscTab);
        Register(Cheese, ("cheese"));

        PizzaRaw = new ModItemPizzaRaw().setUnlocalizedName("PizzaRaw").setCreativeTab(Main.MiscTab);
        RegisterOutName(PizzaRaw, "Pizza Raw");

        Pizza = new ModItemPizza().setUnlocalizedName("Pizza").setCreativeTab(Main.MiscTab);
        RegisterOutName(Pizza, "Pizza");

        Orange = new ModItemOrange().setUnlocalizedName("Orange").setCreativeTab(Main.MiscTab);
        Register(Orange, ("orange"));

        DisarmStick = new ModItemDisarmStick().setUnlocalizedName("DisarmStick").setCreativeTab(Main.MiscTab);
        Register(DisarmStick, ("disarmstick"));

        Drill = new ModItemDrill(ToolMaterial.EMERALD).setUnlocalizedName("Drill").setCreativeTab(Main.ElectricTab);
        Register(Drill, ("drill"));

        Circuit = new ModItemCircuit().setUnlocalizedName("Circuit").setCreativeTab(Main.ElectricTab);
        RegisterOutName(Circuit, "Circuit Board");

        CableItem = new Item().setUnlocalizedName("CableItem").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":CableItem");
        Register(CableItem, ("cable"));

        SolarCells = new Item().setUnlocalizedName("SolarCells").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":SolarCells");
        Register(SolarCells, ("solarcells"));

        Turbine = new Item().setUnlocalizedName("Turbine").setCreativeTab(Main.ElectricTab).setTextureName(Reference.Mod_Id + ":Turbine");
        Register(Turbine, ("turbine"));

        Battery = new ModItemBattery().setUnlocalizedName("Battery").setCreativeTab(Main.ElectricTab);
        Register(Battery, ("battery"));

        BigBattery = new ModItemBigBattery().setUnlocalizedName("BigBattery").setCreativeTab(Main.ElectricTab);
        Register(BigBattery, ("bigbattery"));

        AdvancedBattery = new ModItemAdvancedBattery().setUnlocalizedName("AdvancedBattery").setCreativeTab(Main.ElectricTab);
        Register(AdvancedBattery, ("advancedbattery"));

        ElectricShears = new ModItemElectricShear().setUnlocalizedName("ELShears").setCreativeTab(Main.ElectricTab);
        Register(ElectricShears, ("electricshears"));

        ElectricBow = new ModItemElectricBow().setUnlocalizedName("ElBow").setCreativeTab(Main.ElectricTab);
        Register(ElectricBow, ("electricbow"));

        Upgrades = new ModItemUpgrades().setUnlocalizedName("Upgrades").setCreativeTab(Main.ElectricTab);
        RegisterOutName(Upgrades, "Upgrades");

        Wrench = new ModItemWrench().setUnlocalizedName("Wrench").setCreativeTab(Main.ElectricTab);
        Register(Wrench, ("wrench"));

        IronPlate = new ModItemIronPlate().setUnlocalizedName("IronPlate").setCreativeTab(Main.ElectricTab);
        Register(IronPlate, "Iron Plate");

        HeatDrill = new ModItemHeatDrill().setUnlocalizedName("HeatDrill").setCreativeTab(Main.ElectricTab);
        Register(HeatDrill, ("heatdrill"));

        PaintBrush = new ModItemPaintBrush().setUnlocalizedName("PaintBrush").setCreativeTab(Main.MiscTab);
        RegisterOutName(PaintBrush, "Paint Brush");

        FloatBlockPlacer = new ModItemFloatBlockPlacer().setUnlocalizedName("FloatPlacer").setTextureName(Reference.Mod_Id + ":FloatBlockPlacer").setCreativeTab(Main.ElectricTab);
        Register(FloatBlockPlacer, ("floatblockplacer"));

        Main.proxy.addArmor("AntiFall");

        AntiFallChestPlate = (new ModItemAntiFallChest(1, 1)).setUnlocalizedName("AntiFallChestPlate").setTextureName(Reference.Mod_Id + ":AntiFallChest").setCreativeTab(Main.ElectricTab);
        Register(AntiFallChestPlate, ("antifallchestplate"));

        InfoScreenHelmet = new ModItemInfoScreenHelmet(1, 0).setUnlocalizedName("InfoScreenHelmet").setTextureName(Reference.Mod_Id + ":InfoScreenHelmet").setCreativeTab(Main.ElectricTab);
        Register(InfoScreenHelmet, ("infoscreen"));

        DataChip = new ModItemDataChip().setUnlocalizedName("DataChip").setCreativeTab(Main.ElectricTab);
        Register(DataChip, "Data Chip");

		Lens = new ModItemLens().setUnlocalizedName("Lens").setCreativeTab(Main.ElectricTab);
		Register(Lens, "Lens");

        BlueCrystal = new Item().setUnlocalizedName("BlueCrystal").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:BlueCrystal");
        Register(BlueCrystal, "BlueCrystal");

        GreenCrystal = new Item().setUnlocalizedName("GreenCrystal").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:GreenCrystal");
        Register(GreenCrystal, "GreenCrystal");

        RedCrystal = new Item().setUnlocalizedName("RedCrystal").setCreativeTab(Main.MagicTab).setTextureName("MiscItems:RedCrystal");
        Register(RedCrystal, "RedCrystal");

        ChargedCrystal = new ModItemChargedCrystal().setUnlocalizedName("ChargedCrystal").setCreativeTab(Main.MagicTab);
        Register(ChargedCrystal, "ChargedCrystal");

        InvisibilityCore = new ModItemInvisibilityCore().setUnlocalizedName("InvisibilityCore").setCreativeTab(Main.MagicTab);
        Register(InvisibilityCore, "InvisibilityCore");

        CrystalSilk = new Item().setCreativeTab(Main.MagicTab).setUnlocalizedName("CrystalSilk").setTextureName("MiscItems:CrystalSilk");
        Register(CrystalSilk, "CrystalSilk");

        CrystalBlade = new ModItemCrystalBlade().setCreativeTab(Main.MagicTab).setUnlocalizedName("CrystalBlade").setTextureName("MiscItems:CrystalBlade");
        Register(CrystalBlade, "CrystalBlade");

        CrystalPickaxe = new ModItemCrystalPickaxe().setTextureName(Reference.Mod_Id + ":CrystalPickaxe").setCreativeTab(Main.MagicTab);
        Register(CrystalPickaxe, "CrystalPickaxe");

        CrystalInfusedMetal = new Item().setCreativeTab(Main.MagicTab).setTextureName(Reference.Mod_Id + ":CrystalInfusedMetal");
        Register(CrystalInfusedMetal, "CrystalInfusedMetal");

        CrystalInfusedGem = new Item().setCreativeTab(Main.MagicTab).setTextureName(Reference.Mod_Id + ":CrystalInfusedGem");
        Register(CrystalInfusedGem, "CrystalInfusedGem");


        IconItem = new IconRegisteringItemClass();
        SilentRegister(IconItem);



        OreDictionary.registerOre("ingotSilver", new ItemStack(SilverIngot));
        OreDictionary.registerOre("nuggetSilver", new ItemStack(SilverNugget));
		
	

		
		
		
		
	}

    public static int i = 0;

    public static void SilentRegister(Item Item){
        Item.setUnlocalizedName("SilentItem_" + i++);
        GameRegistry.registerItem(Item, "SilentItem_" + i);
    }


	
	public static void Register(Item Item, String Name){
        ConfigUtils.ItemConfigNames.put(Item,Name);

		if(ConfigUtils.IsItemEnabled(Item)){
        Item.setUnlocalizedName((Name.toLowerCase().replace(" ", "_")));
        GameRegistry.registerItem(Item, (Name.toLowerCase().replace(" ", "_")));

	}
	}


	
	public static void RegisterOutName(Item Item, String Name){
        ConfigUtils.ItemConfigNames.put(Item,Name);

        if(ConfigUtils.IsItemEnabled(Item)){
            Item.setUnlocalizedName(Name);
            GameRegistry.registerItem(Item, (Name.toLowerCase().replace(" ", "_")));

        }
	}
}
