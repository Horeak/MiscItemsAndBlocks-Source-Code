package com.miscitems.MiscItemsAndBlocks.Main;


import MiscUtils.Block.ModBlockStair;
import MiscUtils.MiscUtilsMain;
import MiscUtils.Register.BlockRegister;
import MiscUtils.Register.OreDictionaryRegister;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockCardboardBox;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockMill;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockOven;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockSquezer;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockTrashBin;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWorktable;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockXpStorage;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockColoredMetalBrick;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockGamePart;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockItemPedestal;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockPaintBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockPillar;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockTable;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockCreativeEnergySource;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockGenerator;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLaser;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLaserReciver;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLensBench;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMachinePart;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMetalPress;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMiningStation;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockTeleporter;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockWindMill;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockComputer;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDice;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDiceHolder;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockGhostBlock;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockOneWayGlass;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockSilverOre;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockSpeedBlock;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockTimedBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeLeaf;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeLog;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangePlanks;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeSapling;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockTomatoPlant;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockBox;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockColoredMetalBrick;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockComputer;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockDice;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockDiceHolder;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockGamePiece;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockItemPedestal;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockLaserReciver;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockMetalPress;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockPaintBlock;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockPillar;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockTable;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockTeleporter;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemBlockTrashBin;
import com.miscitems.MiscItemsAndBlocks.Item.ItemBlock.ModItemXpStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPaintBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityCreativeEnergySource;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaserReciver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityWindMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityCardboardBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityOven;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityTrashBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWorktable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityXpStorage;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTimedBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IPlantable;

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

    public static Block CreativeEnergySource;


    public static Block ColoredBrick;
    public static Block ColoredBrickGlowstone;
	
	public static ModBlockStair StoneStair;
	public static IPlantable OrangeSapling;

	


	public static void Init(){

        BlockRegister Utils = new BlockRegister(Main.config, Reference.Mod_Id);



		XpStorage = new ModBlockXpStorage().setCreativeTab(Main.MiscTab);
        Utils.Register(XpStorage, ModItemXpStorageBlock.class, "Xp Storage Block", TileEntityXpStorage.class);
		
		Bin = new ModBlockTrashBin().setCreativeTab(Main.MiscTab);
        Utils.Register(Bin, ModItemBlockTrashBin.class, "Trash Bin", TileEntityTrashBin.class);
		
		DisarmTrap = new ModBlockDisarmTrap().setCreativeTab(Main.MiscTab);
        Utils.Register(DisarmTrap, ModItemBlockDisarmTrap.class, "Disarm Trap", TileEntityDisarmTrap.class);
		
		SilverOre = new ModBlockSilverOre().setCreativeTab(Main.MiscTab);
        Utils.Register(SilverOre, "Silver Ore");

        StoneStair = new ModBlockStair(Blocks.stone, 0);
        Utils.Register(StoneStair, "Stone Stair");
        
        Box = new ModBlockCardboardBox().setCreativeTab(Main.MiscTab);
        Utils.Register(Box, ModItemBlockBox.class, "Cardboard Box", TileEntityCardboardBox.class);
        
        Worktable = new ModBlockWorktable().setCreativeTab(Main.MiscTab);
        Utils.Register(Worktable, "Worktable", TileEntityWorktable.class);
        
        Dice = new ModBlockDice().setCreativeTab(Main.MiscTab);
        Utils.Register(Dice, ModItemBlockDice.class, "Dice");
        
        SpeedBlock = new ModBlockSpeedBlock().setCreativeTab(Main.MiscTab);
        Utils.Register(SpeedBlock, "Speed Block");
        
        GamePart = new ModBlockGamePart().setCreativeTab(Main.DecorativeTab);
        Utils.Register(GamePart, ModItemBlockGamePiece.class, "Game Piece", TileEntityGamePart.class);

        
        Pillar = new ModBlockPillar();
        Utils.Register(Pillar, ModItemBlockPillar.class, "Pillar", TileEntityPillar.class);
        
        TomatoPlant = new ModBlockTomatoPlant();
        Utils.Register(TomatoPlant, "Tomato Plant");

        Mill = new ModBlockMill().setCreativeTab(Main.MiscTab);
        Utils.Register(Mill, "Mill", TileEntityMill.class);

        Squezer = new ModBlockSquezer().setCreativeTab(Main.MiscTab);
        Utils.Register(Squezer, "Squeezer", TileEntitySquezer.class);
        
        OrangeLeaf = new ModBlockOrangeLeaf().setCreativeTab(Main.MiscTab);
        Utils.Register(OrangeLeaf, "Orange Tree Leaves");
        
        OrangeSapling = new ModBlockOrangeSapling();
        Utils.Register((Block) OrangeSapling, "Orange Tree Sapling");
        

        Oven = new ModBlockOven().setCreativeTab(Main.MiscTab);
        Utils.Register(Oven, "Oven", TileEntityOven.class);
        
        OrangeLog = new ModBlockOrangeLog().setCreativeTab(Main.MiscTab);
        Utils.Register(OrangeLog, "Orange Tree Wood");
        
        OrangePlanks = new ModBlockOrangePlanks().setCreativeTab(Main.MiscTab);
        Utils.Register(OrangePlanks, "Orange Tree Planks");
        
        MachinePart = new ModBlockMachinePart().setCreativeTab(Main.ElectricTab).setHardness(1F);
        Utils.Register(MachinePart, "Machine Part");


        CreativeEnergySource = new ModBlockCreativeEnergySource().setCreativeTab(Main.ElectricTab).setBlockTextureName(Reference.Mod_Id + ":CreativeEnergySource");
        Utils.Register(CreativeEnergySource, "Creative Energy Source", TileEntityCreativeEnergySource.class);

        Charger = new ModBlockEnergyStorageCube().setCreativeTab(Main.ElectricTab);
        Utils.Register(Charger, "Charger", TileEntityEnergyStorageCube.class);
        
        SolarPanel = new ModBlockSolarPanel().setCreativeTab(Main.ElectricTab);
        Utils.Register(SolarPanel, "Solar PanelBlock", TileEntitySolarPanel.class);
        
        WindMill = new ModBlockWindMill().setCreativeTab(Main.ElectricTab);
        Utils.Register(WindMill, "Wind Mill", TileEntityWindMill.class);
        
        Generator = new ModBlockGenerator().setCreativeTab(Main.ElectricTab);
        Utils.Register(Generator, "Coal Generator", TileEntityGenerator.class);

        ElectricFurnace = new ModBlockElectricFurnace().setCreativeTab(Main.ElectricTab);
        Utils.Register(ElectricFurnace, "Electric Furnace", TileEntityElectricFurnace.class);
        
        PowerCable = new ModBlockPowerCable().setCreativeTab(Main.ElectricTab);
        Utils.Register(PowerCable, ModItemBlockPowerCable.class, "Power Cable", TileEntityPowerCable.class);
        
        MetalPress = new ModBlockMetalPress().setCreativeTab(Main.ElectricTab);
        Utils.Register(MetalPress, ModItemBlockMetalPress.class, "Metal Press", TileEntityMetalPress.class);

            LensBench = new ModBlockLensBench().setCreativeTab(Main.ElectricTab);
            Utils.Register(LensBench, "Lens Bench", TileEntityLensBench.class);

            Laser = new ModBlockLaser().setCreativeTab(Main.ElectricTab);
            Utils.Register(Laser, "Laser", TileEntityLaser.class);

            LaserReciver = new ModBlockLaserReciver().setBlockTextureName(Reference.Mod_Id + ":LaserReciver").setCreativeTab(Main.ElectricTab);
            Utils.Register(LaserReciver, ModItemBlockLaserReciver.class, "Laser Reciver", TileEntityLaserReciver.class);


        MiningChamber = new ModBlockMiningStation().setCreativeTab(Main.ElectricTab);
        Utils.Register(MiningChamber, ModItemBlockMiningChamber.class, "Mining Station", TileEntityMiningStation.class);
        
        Teleporter = new ModBlockTeleporter().setCreativeTab(Main.ElectricTab);
        Utils.Register(Teleporter, ModItemBlockTeleporter.class, "Teleporter", TileEntityTeleporter.class);
        
        ItemPedestal = new ModBlockItemPedestal().setCreativeTab(Main.DecorativeTab);
        Utils.Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal", TileEntityItemPedestal.class);
        
        Table = new ModBlockTable().setCreativeTab(Main.DecorativeTab);
        Utils.Register(Table, ModItemBlockTable.class, "Table", TileEntityTable.class);
        
        PaintBlock = new ModBlockPaintBlock().setCreativeTab(Main.DecorativeTab);
        Utils.Register(PaintBlock, ModItemBlockPaintBlock.class, "Paint Block", TileEntityPaintBlock.class);
        
        TimedBlock = new ModBlockTimedBlock();
        Utils.Register(TimedBlock, "Float Block", TileEntityTimedBlock.class);
        
        OneWayGlass = new ModBlockOneWayGlass().setCreativeTab(Main.MiscTab);
        Utils.Register(OneWayGlass, "One Way Glass");

        //TODO FINSIH!
        if(MiscUtilsMain.IsLoadedInDev) {
            Computer = new ModBlockComputer().setCreativeTab(Main.MiscTab);
            Utils.Register(Computer, ModItemBlockComputer.class, "Computer", TileEntityComputer.class);
        }
        
        StorageBlock = new ModBlockStorageBlock().setCreativeTab(Main.MiscTab);
        Utils.Register(StorageBlock, ModItemBlockStorageBlock.class, "Storage Block", TileEntityStorageBlock.class);
        
        DiceHolder = new ModBlockDiceHolder().setCreativeTab(Main.MiscTab);
        Utils.Register(DiceHolder, ModItemBlockDiceHolder.class, "Dice Stand", TileEntityDiceHolder.class);
        
        WireLessRedstone = new ModBlockWirelessRedstone().setCreativeTab(Main.MiscTab);
        Utils.Register(WireLessRedstone, "Wireless Redstone", TileEntityWirelessRedstone.class);
        
        SilverBlock = new BlockCompressed(MapColor.ironColor).setBlockTextureName(Reference.Mod_Id + ":" + "SilverBlock").setHardness(2.7F).setCreativeTab(Main.MiscTab);
        Utils.Register(SilverBlock, "Silver Block");
        
        WirelessItemTrans = new ModBlockWirelessItemTransfer().setCreativeTab(Main.MiscTab);
        Utils.Register(WirelessItemTrans, "Wireless Item Transfer", TileEntityWirelessItemTrans.class);

        GhostBlock = new ModBlockGhostBlock().setCreativeTab(Main.MiscTab);
        Utils.Register(GhostBlock, "Ghost Block", TileEntityGhostBlock.class);

        ColoredBrick = new ModBlockColoredMetalBrick().setBlockTextureName(Reference.Mod_Id + ":MetalBrick").setCreativeTab(Main.DecorativeTab);
        Utils.Register(ColoredBrick, ModItemBlockColoredMetalBrick.class, "Colored Brick");

        ColoredBrickGlowstone = new ModBlockColoredMetalBrick().setBlockTextureName(Reference.Mod_Id + ":MetalBrickGlowstone").setCreativeTab(Main.DecorativeTab).setLightLevel(1.0F);
        Utils.Register(ColoredBrickGlowstone, ModItemBlockColoredMetalBrick.class, "Colored Brick Glowstone");






        OreDictionaryRegister OreUtils = new OreDictionaryRegister(Main.config);

        OreUtils.RegisterOreDictionary("oreSilver", new ItemStack(SilverOre));
        OreUtils.RegisterOreDictionary("logWood", new ItemStack(OrangeLog));
        OreUtils.RegisterOreDictionary("plankWood", new ItemStack(OrangePlanks));



		
	}
	



	
	

}

