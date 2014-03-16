package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.GamePart.ModBlockGamePart;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.*;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.oredict.OreDictionary;

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
	public static Block LaserReciver;
	public static Block GhostBlock;
	public static Block Tv;
	public static Block TurtleShell;
	
	public static ModBlockStair StoneStair;
	public static IPlantable OrangeSapling;
	
	
	public static void Init(){

        Main.config.addCustomCategoryComment("Blocks", "Disabling blocks will require a world which has not used the mod before(a new one or a world you have not used the mod in yet)");

		XpStorage = new ModBlockXpStorage().setCreativeTab(Main.MiscTab);
		Register(XpStorage, ModItemXpStorageBlock.class, "Xp Storage Block");
		
		Bin = new ModBlockBin().setCreativeTab(Main.MiscTab);
		Register(Bin, ModItemBlockTrashBin.class,"Trash Bin");
		
		DisarmTrap = new ModBlockDisarmTrap().setCreativeTab(Main.MiscTab);
		Register(DisarmTrap, ModItemBlockDisarmTrap.class,"Disarm Trap");
		
		SilverOre = new ModBlockSilverOre().setCreativeTab(Main.MiscTab);
		Register(SilverOre, "Silver Ore");

        StoneStair = new ModBlockStair(Blocks.stone, 0);
        Register(StoneStair, "Stone Stair");
        
        Box = new ModBlockBox().setCreativeTab(Main.MiscTab);
        Register(Box, ModItemBlockBox.class, "Cardboard Box");
        
        CraftingInv = new ModBlockCraftingInv().setCreativeTab(Main.MiscTab);
        Register(CraftingInv, "Worktable");
        
        Dice = new ModBlockDice().setCreativeTab(Main.MiscTab);
        Register(Dice, ModItemBlockDice.class, "Dice");
        
        SpeedBlock = new ModBlockSpeedBlock().setCreativeTab(Main.MiscTab);
        Register(SpeedBlock, "Speed Block");
        
        GamePart = new ModBlockGamePart().setCreativeTab(Main.MiscTab);
        Register(GamePart, ModItemBlockGamePiece.class, "Game Piece");

        
        Pillar = new ModBlockPillar().setCreativeTab(Main.MiscTab);
        Register(Pillar, ModItemBlockPillar.class,"Pillar");
        
        TomatoPlant = new ModBlockTomatoPlant();
        Register(TomatoPlant, "Tomato Plant");

        Mill = new ModBlockMill().setCreativeTab(Main.MiscTab);
        Register(Mill, "Mill");

        Squezer = new ModBlockSquezer().setCreativeTab(Main.MiscTab);
        Register(Squezer, "Squeezer");
        
        OrangeLeaf = new ModBlockOrangeLeaf().setCreativeTab(Main.MiscTab);
        Register(OrangeLeaf, "Orange Tree Leaves");
        
        OrangeSapling = new ModBlockOrangeSapling();
        Register((Block) OrangeSapling, "Orange Tree Sapling");
        
        
        //Renamed to Oven
        PizzaOven = new ModBlockOvenCore().setCreativeTab(Main.MiscTab);
        Register(PizzaOven, "Oven");
        
        OrangeLog = new ModBlockOrangeLog().setCreativeTab(Main.MiscTab);
        Register(OrangeLog, "Orange Tree Wood");
        
        OrangePlanks = new ModBlockOrangePlanks().setCreativeTab(Main.MiscTab);
        Register(OrangePlanks, "Orange Tree Planks");
        
        MachinePart = new ModBlockMachinePart().setCreativeTab(Main.ElectricTab);
        Register(MachinePart, "Machine Part");
        
        Charger = new ModBlockCharger().setCreativeTab(Main.ElectricTab);
        Register(Charger, "Charger");
        
        SolarPanel = new ModBlockSolarPanel().setCreativeTab(Main.ElectricTab);
        Register(SolarPanel, "Solar Panel");
        
        WindMill = new ModBlockWindMill().setCreativeTab(Main.ElectricTab);
        Register(WindMill, "Wind Mill");
        
        Generator = new ModBlockGenerator().setCreativeTab(Main.ElectricTab);
        Register(Generator, "Coal Generator");

        ElectricFurnace = new ModBlockElectricFurnace().setCreativeTab(Main.ElectricTab);
        Register(ElectricFurnace, "Electric Furnace");
        
        PowerCable = new ModBlockPowerCable().setCreativeTab(Main.ElectricTab);
        Register(PowerCable, ModItemBlockPowerCable.class, "Power Cable");
        
        MetalPress = new ModBlockMetalPress().setCreativeTab(Main.ElectricTab);
        Register(MetalPress, ModItemBlockMetalPress.class, "Metal Press");
        
        LensBench = new ModBlockLensBench().setCreativeTab(Main.ElectricTab);
        Register(LensBench, "Lens Bench");
        
        Laser = new ModBlockLaser().setCreativeTab(Main.ElectricTab);
        Register(Laser, "Laser");
        
        LaserReciver = new ModBlockLaserReciver().setBlockTextureName(Refrence.Mod_Id + ":LaserReciver").setCreativeTab(Main.ElectricTab);
        Register(LaserReciver, ModItemBlockLaserReciver.class, "Laser Reciver");
        
        MiningChamber = new ModBlockMiningChamber().setCreativeTab(Main.ElectricTab);
        Register(MiningChamber, ModItemBlockMiningChamber.class, "Mining Station");
        
        Teleporter = new ModBlockTeleporter().setCreativeTab(Main.ElectricTab);
        Register(Teleporter, ModItemBlockTeleporter.class, "Teleporter");
        
        ItemPedestal = new ModBlockItemPedestal().setCreativeTab(Main.MiscTab);
        Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal");
        
        Table = new ModBlockTable().setCreativeTab(Main.MiscTab);
        Register(Table, ModItemBlockTable.class ,"Table");
        
        PaintBlock = new ModBlockPaintBlock().setCreativeTab(Main.MiscTab);
        Register(PaintBlock, "Paint Block");
        
        TimedBlock = new ModBlockTimedBlock();
        Register(TimedBlock, "Float Block");
        
        OneWayGlass = new ModBlockOneWayGlass().setCreativeTab(Main.MiscTab);
        Register(OneWayGlass, "One Way Glass");
        
        Computer = new ModBlockComputer().setCreativeTab(Main.MiscTab);
        Register(Computer, ModItemBlockComputer.class, "Computer");
        
        StorageBlock = new ModBlockStorageBlock().setCreativeTab(Main.MiscTab);
        Register(StorageBlock, ModItemBlockStorageBlock.class, "Storage Block");
        
        DiceHolder = new ModBlockDiceHolder().setCreativeTab(Main.MiscTab);
        Register(DiceHolder, ModItemBlockDiceHolder.class, "Dice Stand");
        
        WireLessRedstone = new ModBlockWirelessRedstone().setCreativeTab(Main.MiscTab);
        Register(WireLessRedstone, "Wireless Redstone");
        
        SilverBlock = new ModBlockEmptyBlock().setBlockTextureName(Refrence.Mod_Id + ":" + "SilverBlock").setHardness(2.7F).setCreativeTab(Main.MiscTab);
        Register(SilverBlock, "Silver Block");
        
        WirelessItemTrans = new ModBlockWirelessItemTransfer().setCreativeTab(Main.MiscTab);
        Register(WirelessItemTrans, "Wireless Item Transfer");

        GhostBlock = new ModBlockGhostBlock().setCreativeTab(Main.MiscTab);
        Register(GhostBlock, "Ghost Block");
        
        Tv = new ModBlockTv().setCreativeTab(Main.MiscTab);
        Register(Tv, "Tv");
        
        TurtleShell = new ModBlockTurtleShell().setCreativeTab(Main.MiscTab);
        Register(TurtleShell, "Turtle Shell");



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
        GameRegistry.registerTileEntity(TileEntityGhostBlock.class, "TileEntityGhostBlock");
        GameRegistry.registerTileEntity(TileEntityTv.class, "Tv");
        GameRegistry.registerTileEntity(TileEntityTurtleShell.class, "TurtleShell");
        
        
        Main.config.save();
		
	}
	
	
	
	
	    
		public static void Register(Block block, String Name){
			
			
			if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
				
	        block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));



			}
		}
		
public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name){
			
		
	
	if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
	
	              Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));

	}

		}
		
		public static void RegisterOreDictionary(ItemStack Block, String dictonaryName){
			
			OreDictionary.registerOre(dictonaryName, Block);
			
		}
}

