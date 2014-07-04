package com.miscitems.MiscItemsAndBlocks.Main;


import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockCardboardBox;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockColoredMetalBrick;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockComputer;
import com.miscitems.MiscItemsAndBlocks.Block.Magic.ModBlockCrystalOre;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDice;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDiceHolder;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockEmptyBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockGamePart;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockGenerator;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockGhostBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockItemPedestal;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLaser;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLaserReciver;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockLensBench;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMachinePart;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMetalPress;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockMill;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockMiningStation;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockOneWayGlass;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeLeaf;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeLog;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangePlanks;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeSapling;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockOven;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockPaintBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockPillar;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockSilverOre;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockSolarPanel;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockSpeedBlock;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockSquezer;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockStair;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockTable;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockTeleporter;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockTimedBlock;
import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockTomatoPlant;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockTrashBin;
import com.miscitems.MiscItemsAndBlocks.Block.Electric.ModBlockWindMill;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWirelessItemTransfer;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockWorktable;
import com.miscitems.MiscItemsAndBlocks.Block.BlockContainers.ModBlockXpStorage;
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
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCardboardBox;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDisarmTrap;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityEnergyStorageCube;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGamePart;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityItemPedestal;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaserReciver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityOven;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPaintBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySquezer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTimedBlock;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTrashBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWindMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessItemTrans;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWirelessRedstone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityWorktable;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
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
    public static Block ColoredBrickGlowstone;
	
	public static ModBlockStair StoneStair;
	public static IPlantable OrangeSapling;

    public static Block BlueCrystalOre, GreenCrystalOre, RedCrystalOre;
	
	
	public static void Init(){


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
        
        GamePart = new ModBlockGamePart().setCreativeTab(Main.DecorativeTab);
        Register(GamePart, ModItemBlockGamePiece.class, "Game Piece", TileEntityGamePart.class);

        
        Pillar = new ModBlockPillar().setCreativeTab(Main.DecorativeTab);
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
        
        ItemPedestal = new ModBlockItemPedestal().setCreativeTab(Main.DecorativeTab);
        Register(ItemPedestal, ModItemBlockItemPedestal.class, "Item Pedestal", TileEntityItemPedestal.class);
        
        Table = new ModBlockTable().setCreativeTab(Main.DecorativeTab);
        Register(Table, ModItemBlockTable.class ,"Table", TileEntityTable.class);
        
        PaintBlock = new ModBlockPaintBlock().setCreativeTab(Main.DecorativeTab);
        Register(PaintBlock, ModItemBlockPaintBlock.class, "Paint Block", TileEntityPaintBlock.class);
        
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

        ColoredBrick = new ModBlockColoredMetalBrick().setBlockTextureName(Reference.Mod_Id + ":MetalBrick").setCreativeTab(Main.DecorativeTab);
        Register(ColoredBrick, ModItemBlockColoredMetalBrick.class, "ColoredBrick");

        ColoredBrickGlowstone = new ModBlockColoredMetalBrick().setBlockTextureName(Reference.Mod_Id + ":MetalBrickGlowstone").setCreativeTab(Main.DecorativeTab).setLightLevel(1.0F);
        Register(ColoredBrickGlowstone, ModItemBlockColoredMetalBrick.class, "ColoredBrickGlowstone");






        OreDictionary.registerOre("oreSilver", new ItemStack(SilverOre));
        OreDictionary.registerOre("logWood", new ItemStack(OrangeLog));
        OreDictionary.registerOre("plankWood", new ItemStack(OrangePlanks));



		
	}
	



	
	
	    
		public static void Register(Block block, String Name){
            ConfigUtils.BlockConfigNames.put(block, Name);

			if(ConfigUtils.IsBlockEnabled(block)){

	            block.setBlockName(Name.toLowerCase().replace(" ", "_"));
		        GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));
			}
		}


    public static void Register(Block block, String Name, Class<? extends TileEntity> tileClass){
        ConfigUtils.BlockConfigNames.put(block, Name);

        if(ConfigUtils.IsBlockEnabled(block)){

            block.setBlockName(Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerBlock(block, Name.toLowerCase().replace(" ", "_"));

            GameRegistry.registerTileEntity(tileClass, "[MiscItems]" + Name);



        }
    }



     public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name) {
         ConfigUtils.BlockConfigNames.put(Block, Name);

        if (ConfigUtils.IsBlockEnabled(Block)) {

        Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
        GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));
    }
}



    public static void Register(Block Block, Class<? extends ItemBlock> itemclass, String Name, Class<? extends TileEntity> tileClass){
        ConfigUtils.BlockConfigNames.put(Block, Name);

        if(ConfigUtils.IsBlockEnabled(Block)){
            Block.setBlockName(Name.toLowerCase().replace(" ", "_"));
            GameRegistry.registerBlock(Block, itemclass, Name.toLowerCase().replace(" ", "_"));

            GameRegistry.registerTileEntity(tileClass, "[MiscItems]" + Name);



        }
    }


}

