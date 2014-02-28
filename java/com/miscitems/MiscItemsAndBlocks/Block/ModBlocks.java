package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.miscitems.MiscItemsAndBlocks.GamePart.ModBlockGamePart;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockBox;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockComputer;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockDice;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockDiceHolder;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockGamePiece;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockItemPedestal;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockLaserReciver;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockMetalPress;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockMiningChamber;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockPillar;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockStorageBlock;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockTable;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockTeleporter;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemBlockTrashBin;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.ModItemXpStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCharger;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCraftingInv;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaserReciver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityOvenCore;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPaintBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTimedBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWindMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block DisarmTrap;
	public static Block SilverOre;
	public static Block Box;
	public static Block CraftingInv;
	public static Block Dice;
	public static Block SpeedBlock;
	public static Block Pillar;
	public static Block TomatoPlant;
	public static Block Mill;
	public static Block Squezer;
	public static Block OrangeSapling;
	public static Block OrangeLeaf;
	public static Block PizzaOven;
	public static Block OrangeLog;
	public static Block OrangePlanks;
	public static Block Table;
	public static Block TimedBlock;
	public static Block StorageBlock;
	
	public static Block Computer;
	
	public static Block Teleporter;
	public static Block WireLessRedstone;
	public static Block WirelessItemTrans;
	
	public static Block MetalPress;
	
	public static Block PaintBlock;
	public static Block SilverBlock;
	
	public static Block ElectricFurnace;
	
	public static Block ItemPedestal;
	public static Block MiningChamber;
	
	public static Block PowerCable;
	public static Block Charger;
	public static Block SolarPanel;
	public static Block WindMill;
	public static Block Generator;
	
	public static Block OneWayGlass;
	
	public static Block MachinePart;

	
	public static Block GamePart;
	
	public static Block DiceHolder;
	
	public static Block LensBench;
	public static Block Laser;
	
	
	public static ModBlockStair StoneStair;
	
	public static Block LaserReciver;
	
	
	
	public static void Init(){
		
		XpStorage = new ModBlockXpStorage();
		Register(XpStorage, ModItemXpStorageBlock.class, "Xp Storage Block", true);
		
		Bin = new ModBlockBin();
		Register(Bin, ModItemBlockTrashBin.class,"Trash Bin", true);
		
		DisarmTrap = new ModBlockDisarmTrap();
		Register(DisarmTrap, ModItemBlockDisarmTrap.class,"Disarm Trap", true);
		
		SilverOre = new ModBlockSilverOre();
		Register(SilverOre, "Silver Ore", true);

        StoneStair = new ModBlockStair(Blocks.stone, 0);
        Register(StoneStair, "Stone Stair", true);
        
        Box = new ModBlockBox();
        Register(Box, ModItemBlockBox.class, "Cardboard Box", true);
        
        CraftingInv = new ModBlockCraftingInv();
        Register(CraftingInv, "Worktable", true);
        
        Dice = new ModBlockDice();
        Register(Dice, ModItemBlockDice.class, "Dice", true);
        
        SpeedBlock = new ModBlockSpeedBlock();
        Register(SpeedBlock, "Speed Block", true);
        
        GamePart = new ModBlockGamePart();
        Register(GamePart, ModItemBlockGamePiece.class, "Game Piece", true);

        
        Pillar = new ModBlockPillar();
        Register(Pillar, ModItemBlockPillar.class,"Pillar", true);
        
        TomatoPlant = new ModBlockTomatoPlant();
        Register(TomatoPlant, "Tomato Plant", false);

        Mill = new ModBlockMill();
        Register(Mill, "Mill", true);

        Squezer = new ModBlockSquezer();
        Register(Squezer, "Squeezer", true);
        
        OrangeLeaf = new ModBlockOrangeLeaf();
        Register(OrangeLeaf, "Orange Tree Leaves", true);
        
        OrangeSapling = new ModBlockOrangeSapling();
        Register(OrangeSapling, "Orange Tree Sapling", true);
        
        
        //Renamed to Oven
        PizzaOven = new ModBlockOvenCore();
        Register(PizzaOven, "Oven", true);
        
        OrangeLog = new ModBlockOrangeLog();
        Register(OrangeLog, "Orange Tree Wood", true);
        
        OrangePlanks = new ModBlockOrangePlanks();
        Register(OrangePlanks, "Orange Tree Planks", true);
        
        Charger = new ModBlockCharger();
        Register(Charger, "Charger", true);
        
        SolarPanel = new ModBlockSolarPanel();
        Register(SolarPanel, "Solar Panel", true);
        
        WindMill = new ModBlockWindMill();
        Register(WindMill, "Wind Mill", true);
        
        Generator = new ModBlockGenerator();
        Register(Generator, "Coal Generator", true);
        
        PowerCable = new ModBlockPowerCable();
        Register(PowerCable, ModItemBlockPowerCable.class, "Power Cable", true);
        
        
        ItemPedestal = new ModBlockItemPedestal();
        Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal", true);
        
        MiningChamber = new ModBlockMiningChamber();
        Register(MiningChamber, ModItemBlockMiningChamber.class, "Mining Station", true);
        
        Table = new ModBlockTable();
        Register(Table, ModItemBlockTable.class ,"Table", true);
        
        MachinePart = new ModBlockMachinePart();
        Register(MachinePart, "Machine Part", true);
        
        PaintBlock = new ModBlockPaintBlock();
        Register(PaintBlock, "Paint Block", true);
        
        ElectricFurnace = new ModBlockElectricFurnace();
        Register(ElectricFurnace, "Electric Furnace", true);
        
        TimedBlock = new ModBlockTimedBlock();
        Register(TimedBlock, "Float Block", false);
        
        OneWayGlass = new ModBlockOneWayGlass();
        Register(OneWayGlass, "One Way Glass", true);
        
        Computer = new ModBlockComputer();
        Register(Computer, ModItemBlockComputer.class, "Computer", true);
        
        StorageBlock = new ModBlockStorageBlock();
        Register(StorageBlock, ModItemBlockStorageBlock.class, "Storage Block", true);
        
        
        DiceHolder = new ModBlockDiceHolder();
        Register(DiceHolder, ModItemBlockDiceHolder.class, "Dice Stand", true);

        
        Teleporter = new ModBlockTeleporter();
        Register(Teleporter, ModItemBlockTeleporter.class, "Teleporter", true);
        
        WireLessRedstone = new ModBlockWirelessRedstone();
        Register(WireLessRedstone, "Wireless Redstone", true);
        
        SilverBlock = new ModBlockEmptyBlock().setBlockTextureName(Refrence.Mod_Id + ":" + "SilverBlock").setHardness(1.7F);
        Register(SilverBlock, "Silver Block", true);
        
        WirelessItemTrans = new ModBlockWirelessItemTransfer();
        Register(WirelessItemTrans, "Wireless Item Transfer", true);
        
        
        MetalPress = new ModBlockMetalPress();
        Register(MetalPress, ModItemBlockMetalPress.class, "Metal Press", true);
        
        LensBench = new ModBlockLensBench();
        Register(LensBench, "Lens Bench", true);
        
        Laser = new ModBlockLaser();
        Register(Laser, "Laser", true);
        
        LaserReciver = new ModBlockLaserReciver().setBlockTextureName("furnace_top");
        Register(LaserReciver, ModItemBlockLaserReciver.class, "Laser Reciver", true);
        
        
        
		RegisterOreDictionary(new ItemStack(SilverOre), "oreSilver");
		RegisterOreDictionary(new ItemStack(OrangeLog), "logWood");
		RegisterOreDictionary(new ItemStack(OrangePlanks), "plankWood");

		
        GameRegistry.registerTileEntity(TileEntityXpStorage.class, "TileEntityXpStorage");
        GameRegistry.registerTileEntity(TileEntityBin.class, "TileEntityBin");
        GameRegistry.registerTileEntity(TileEntityDisarmTrap.class, "TileEntityTrap");
        GameRegistry.registerTileEntity(TileEntityBox.class, "TileEntityBox");
        GameRegistry.registerTileEntity(TileEntityCraftingInv.class, "TileEntityCraftingInv");
        GameRegistry.registerTileEntity(TileEntityMill.class, "TileEntityMill");
        GameRegistry.registerTileEntity(TileEntitySquezer.class, "TileEntitySquezer");
        GameRegistry.registerTileEntity(TileEntityOvenCore.class, "TileEntityOvenCore");
        
        GameRegistry.registerTileEntity(TileEntityItemPedestal.class, "TileEntityItemPedestal");
        GameRegistry.registerTileEntity(TileEntityMiningChamber.class, "TileEntityMiningChamber");
        
        GameRegistry.registerTileEntity(TileEntityCharger.class, "TileEntityCharger");
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "TileEntitySolarPanel");
        GameRegistry.registerTileEntity(TileEntityWindMill.class, "TileEntityWindMill");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
        GameRegistry.registerTileEntity(TileEntityPowerCable.class, "TileEntityPowerCable");
        
        GameRegistry.registerTileEntity(TileEntityGamePart.class, "TileEntityGamePart");
        GameRegistry.registerTileEntity(TileEntityPillar.class, "TileEntityPillar");
        GameRegistry.registerTileEntity(TileEntityTimedBlock.class, "TileEntityTimedBLock");
        GameRegistry.registerTileEntity(TileEntityElectricFurnace.class, "TileEntityElectricFurnace");
        GameRegistry.registerTileEntity(TileEntityTable.class, "TileEntityTable");
        GameRegistry.registerTileEntity(TileEntityPaintBlock.class, "TileEntityPaintBlock");
        GameRegistry.registerTileEntity(TileEntityComputer.class, "TileEntityComputer");
        GameRegistry.registerTileEntity(TileEntityStorageBlock.class, "TileEntityStorageBlock");
        
        GameRegistry.registerTileEntity(TileEntityDiceHolder.class, "TileEntityDiceHolder");
        GameRegistry.registerTileEntity(TileEntityTeleporter.class, "TileEntityTeleporter");
        GameRegistry.registerTileEntity(TileEntityWirelessRedstone.class, "TileEntityWirelessRedstone");
        GameRegistry.registerTileEntity(TileEntityWirelessItemTrans.class, "TileEntityWirelessItemTransfer");
        
        GameRegistry.registerTileEntity(TileEntityMetalPress.class, "TileEntityMetalPress");
        GameRegistry.registerTileEntity(TileEntityLensBench.class, "TileEntityensBench");
        GameRegistry.registerTileEntity(TileEntityLaser.class, "TileEntityensLaser");
        GameRegistry.registerTileEntity(TileEntityLaserReciver.class, "TileEntityensLaserReciver");
        
        
        Main.config.save();
		
	}
	
	
	
	
	    
		public static void Register(Block block, String Name, boolean AddTab){
			
			
			if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
				
	        block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));

	        
	        if(AddTab)
	        block.setCreativeTab(Main.CreativeTab);

			}
		}
		
public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name, boolean AddTab){
			
		
	
	if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
	
	              Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));

	        if(AddTab)
	        Block.setCreativeTab(Main.CreativeTab);
	}

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

