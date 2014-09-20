package com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories;


import MiscUtils.TileEntity.TileEntityInvBase;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.Config;

public class TileEntityStorageBlock extends TileEntityInvBase {

	int Lines;
	
	public TileEntityStorageBlock() {
		super(Main.config.GetConfigFile().getInt("Storage Block Inventory slots", Config.CATEGORY_SERVER_SETTINGS, 200, 1, 5000, "The amount of inventory slots the storage block has"), "Storage Block", 128);
	}
	
   	

}
