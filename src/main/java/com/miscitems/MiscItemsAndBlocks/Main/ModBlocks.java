package com.miscitems.MiscItemsAndBlocks.Main;

import com.miscitems.MiscItemsAndBlocks.Block.*;
import com.miscitems.MiscItemsAndBlocks.GamePart.ModBlockGamePart;
import com.miscitems.MiscItemsAndBlocks.GamePart.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.ItemBlock.*;
import com.miscitems.MiscItemsAndBlocks.TileEntity.*;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {

	
	
	public static Block XpStorage;
	public static Block Bin;
	public static Block DisarmTrap;
	public static Block SilverOre;
	public static Block Box;
	public static Block Worktable;
	public static Block Dice;
	public static Block SpeedBlock;
	public static Block Pillar;
	public static Block TomatoPlant;
	public static Block Mill;
	public static Block Squezer;
	public static Block OrangeLeaf;
	public static Block Oven;
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

    public static Block ColoredBrick;
    //TODO
    public static Block TestBlock;
	
	public static ModBlockStair StoneStair;
	public static IPlantable OrangeSapling;

    public static Block BlueCrystalOre, GreenCrystalOre, RedCrystalOre;
	
	
	public static void Init(){

        Main.config.addCustomCategoryComment("Blocks", "Disabling blocks will require a world which has not used the mod before(a new one or a world you have not used the mod in yet)");

		XpStorage = new ModBlockXpStorage().setCreativeTab(Main.MiscTab);
		Register(XpStorage, ModItemXpStorageBlock.class, "Xp Storage Block", TileEntityXpStorage.class);
		
		Bin = new ModBlockTrashBin().setCreativeTab(Main.MiscTab);
		Register(Bin, ModItemBlockTrashBin.class,"Trash Bin", TileEntityTrashBin.class);
		
		DisarmTrap = new ModBlockDisarmTrap().setCreativeTab(Main.MiscTab);
		Register(DisarmTrap, ModItemBlockDisarmTrap.class,"Disarm Trap", TileEntityDisarmTrap.class);
		
		SilverOre = new ModBlockSilverOre().setCreativeTab(Main.MiscTab);
		Register(SilverOre, "Silver Ore");

        StoneStair = new ModBlockStair(Blocks.stone, 0);
        Register(StoneStair, "Stone Stair");
        
        Box = new ModBlockCardboardBox().setCreativeTab(Main.MiscTab);
        Register(Box, ModItemBlockBox.class, "Cardboard Box", TileEntityCardboardBox.class);
        
        Worktable = new ModBlockWorktable().setCreativeTab(Main.MiscTab);
        Register(Worktable, "Worktable", TileEntityWorktable.class);
        
        Dice = new ModBlockDice().setCreativeTab(Main.MiscTab);
        Register(Dice, ModItemBlockDice.class, "Dice");
        
        SpeedBlock = new ModBlockSpeedBlock().setCreativeTab(Main.MiscTab);
        Register(SpeedBlock, "Speed Block");
        
        GamePart = new ModBlockGamePart().setCreativeTab(Main.MiscTab);
        Register(GamePart, ModItemBlockGamePiece.class, "Game Piece", TileEntityGamePart.class);

        
        Pillar = new ModBlockPillar().setCreativeTab(Main.MiscTab);
        Register(Pillar, ModItemBlockPillar.class,"Pillar", TileEntityPillar.class);
        
        TomatoPlant = new ModBlockTomatoPlant();
        Register(TomatoPlant, "Tomato Plant");

        Mill = new ModBlockMill().setCreativeTab(Main.MiscTab);
        Register(Mill, "Mill", TileEntityMill.class);

        Squezer = new ModBlockSquezer().setCreativeTab(Main.MiscTab);
        Register(Squezer, "Squeezer", TileEntitySquezer.class);
        
        OrangeLeaf = new ModBlockOrangeLeaf().setCreativeTab(Main.MiscTab);
        Register(OrangeLeaf, "Orange Tree Leaves");
        
        OrangeSapling = new ModBlockOrangeSapling();
        Register((Block) OrangeSapling, "Orange Tree Sapling");
        

        Oven = new ModBlockOven().setCreativeTab(Main.MiscTab);
        Register(Oven, "Oven", TileEntityOven.class);
        
        OrangeLog = new ModBlockOrangeLog().setCreativeTab(Main.MiscTab);
        Register(OrangeLog, "Orange Tree Wood");
        
        OrangePlanks = new ModBlockOrangePlanks().setCreativeTab(Main.MiscTab);
        Register(OrangePlanks, "Orange Tree Planks");
        
        MachinePart = new ModBlockMachinePart().setCreativeTab(Main.ElectricTab).setHardness(1F);
        Register(MachinePart, "Machine Part");
        
        Charger = new ModBlockEnergyStorageCube().setCreativeTab(Main.ElectricTab);
        Register(Charger, "Charger", TileEntityEnergyStorageCube.class);
        
        SolarPanel = new ModBlockSolarPanel().setCreativeTab(Main.ElectricTab);
        Register(SolarPanel, "Solar PanelBlock", TileEntitySolarPanel.class);
        
        WindMill = new ModBlockWindMill().setCreativeTab(Main.ElectricTab);
        Register(WindMill, "Wind Mill", TileEntityWindMill.class);
        
        Generator = new ModBlockGenerator().setCreativeTab(Main.ElectricTab);
        Register(Generator, "Coal Generator", TileEntityGenerator.class);

        ElectricFurnace = new ModBlockElectricFurnace().setCreativeTab(Main.ElectricTab);
        Register(ElectricFurnace, "Electric Furnace", TileEntityElectricFurnace.class);
        
        PowerCable = new ModBlockPowerCable().setCreativeTab(Main.ElectricTab);
        Register(PowerCable, ModItemBlockPowerCable.class, "Power Cable", TileEntityPowerCable.class);
        
        MetalPress = new ModBlockMetalPress().setCreativeTab(Main.ElectricTab);
        Register(MetalPress, ModItemBlockMetalPress.class, "Metal Press", TileEntityMetalPress.class);
        
        LensBench = new ModBlockLensBench().setCreativeTab(Main.ElectricTab);
        Register(LensBench, "Lens Bench", TileEntityLensBench.class);
        
        Laser = new ModBlockLaser().setCreativeTab(Main.ElectricTab);
        Register(Laser, "Laser", TileEntityLaser.class);
        
        LaserReciver = new ModBlockLaserReciver().setBlockTextureName(Reference.Mod_Id + ":LaserReciver").setCreativeTab(Main.ElectricTab);
        Register(LaserReciver, ModItemBlockLaserReciver.class, "Laser Reciver", TileEntityLaserReciver.class);
        
        MiningChamber = new ModBlockMiningStation().setCreativeTab(Main.ElectricTab);
        Register(MiningChamber, ModItemBlockMiningChamber.class, "Mining Station", TileEntityMiningStation.class);
        
        Teleporter = new ModBlockTeleporter().setCreativeTab(Main.ElectricTab);
        Register(Teleporter, ModItemBlockTeleporter.class, "Teleporter", TileEntityTeleporter.class);
        
        ItemPedestal = new ModBlockItemPedestal().setCreativeTab(Main.MiscTab);
        Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal", TileEntityItemPedestal.class);
        
        Table = new ModBlockTable().setCreativeTab(Main.MiscTab);
        Register(Table, ModItemBlockTable.class ,"Table", TileEntityTable.class);
        
        PaintBlock = new ModBlockPaintBlock().setCreativeTab(Main.MiscTab);
        Register(PaintBlock, "Paint Block", TileEntityPaintBlock.class);
        
        TimedBlock = new ModBlockTimedBlock();
        Register(TimedBlock, "Float Block", TileEntityTimedBlock.class);
        
        OneWayGlass = new ModBlockOneWayGlass().setCreativeTab(Main.MiscTab);
        Register(OneWayGlass, "One Way Glass");
        
        Computer = new ModBlockComputer().setCreativeTab(Main.MiscTab);
        Register(Computer, ModItemBlockComputer.class, "Computer", TileEntityComputer.class);
        
        StorageBlock = new ModBlockStorageBlock().setCreativeTab(Main.MiscTab);
        Register(StorageBlock, ModItemBlockStorageBlock.class, "Storage Block", TileEntityStorageBlock.class);
        
        DiceHolder = new ModBlockDiceHolder().setCreativeTab(Main.MiscTab);
        Register(DiceHolder, ModItemBlockDiceHolder.class, "Dice Stand", TileEntityDiceHolder.class);
        
        WireLessRedstone = new ModBlockWirelessRedstone().setCreativeTab(Main.MiscTab);
        Register(WireLessRedstone, "Wireless Redstone", TileEntityWirelessRedstone.class);
        
        SilverBlock = new ModBlockEmptyBlock().setBlockTextureName(Reference.Mod_Id + ":" + "SilverBlock").setHardness(2.7F).setCreativeTab(Main.MiscTab);
        Register(SilverBlock, "Silver Block");
        
        WirelessItemTrans = new ModBlockWirelessItemTransfer().setCreativeTab(Main.MiscTab);
        Register(WirelessItemTrans, "Wireless Item Transfer", TileEntityWirelessItemTrans.class);

        GhostBlock = new ModBlockGhostBlock().setCreativeTab(Main.MiscTab);
        Register(GhostBlock, "Ghost Block", TileEntityGhostBlock.class);

        BlueCrystalOre = new ModBlockCrystalOre(ModItems.BlueCrystal).setCreativeTab(Main.MagicTab).setBlockTextureName(Reference.Mod_Id + ":BlueCrystalOre");
        Register(BlueCrystalOre, "BlueCrystalOre");

        GreenCrystalOre = new ModBlockCrystalOre(ModItems.GreenCrystal).setCreativeTab(Main.MagicTab).setBlockTextureName(Reference.Mod_Id + ":GreenCrystalOre");
        Register(GreenCrystalOre, "GreenCrystalOre");

        RedCrystalOre = new ModBlockCrystalOre(ModItems.RedCrystal).setCreativeTab(Main.MagicTab).setBlockTextureName(Reference.Mod_Id + ":RedCrystalOre");
        Register(RedCrystalOre, "RedCrystalOre");

        ColoredBrick = new ModBlockColoredMetalBrick().setBlockTextureName(Reference.Mod_Id + ":BlueBrick").setCreativeTab(Main.MiscTab);
        Register(ColoredBrick, ModItemBlockColoredMetalBrick.class, "ColoredBrick");

        TestBlock = new ModBlockEmptyBlock().setBlockTextureName(Reference.Mod_Id + ":RandomBlock").setCreativeTab(Main.MiscTab);
        Register(TestBlock, "TestBlock");





        OreDictionary.registerOre("oreSilver", new ItemStack(SilverOre));
        OreDictionary.registerOre("logWood", new ItemStack(OrangeLog));
        OreDictionary.registerOre("plankWood", new ItemStack(OrangePlanks));


        
        Main.config.save();
		
	}
	



	
	
	    
		public static void Register(Block block, String Name){
			if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
	        block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));
			}
		}


    public static void Register(Block block, String Name, Class<? extends TileEntity> tileClass){
        if(Main.config.get("Blocks", "Enable " + Name + "?", true).getBoolean(true)){
            block.setBlockName(Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerTileEntity(tileClass, "[MiscItems]" + Name);
        }
    }


public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name){
	if(Main.config.get("Blocks", "Enable " + Name.replace("tile.", "") + "?", true).getBoolean(true)){
	              Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));
	}	}



    public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name, Class<? extends TileEntity> tileClass){
        if(Main.config.get("Blocks", "Enable " + Name.replace("tile.", "") + "?", true).getBoolean(true)){
            Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerTileEntity(tileClass, "[MiscItems]" + Name);
        }	}


}

