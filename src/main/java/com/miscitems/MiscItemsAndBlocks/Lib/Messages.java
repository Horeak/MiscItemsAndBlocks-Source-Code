package com.miscitems.MiscItemsAndBlocks.Lib;

public class Messages {

	
	public static String[] XpStorageTips = new String[10];
	public static String[] TrashBinTips = new String[10];
	public static String[] WorktableTips = new String[10];
	public static String[] CardboardBoxTipes = new String[10];
	public static String[] ShelfTipes = new String[10];
	public static String[] MillTips = new String[10];
	public static String[] SquezerTips = new String[10];
	public static String[] PizzaOvenTips = new String[10];
	public static String[] ChargerTips = new String[10];
	
	public static void Init(){
		
		XpStorageTips[0] = "This is a Xp Storage block you can store and take xp levels from it at any time";
		XpStorageTips[1] = "You can save levels then earn more quicker";
		XpStorageTips[2] = "Use the XpStored button to check the amount stored in the xp storage block on Multiplayer";
		
		TrashBinTips[0] = "When putting items into the trash bin they get deleted";
		
		WorktableTips[0] = "The worktable will save the crafting grid";
		WorktableTips[1] = "The worktable can use resources from the internal chest";
		
		CardboardBoxTipes[0] = "The cardboard box is a cheaper type of item storage";
		
		ShelfTipes[0] = "The shelf is a block where you can store items for display";
		ShelfTipes[1] = "The shelf is still in a early Work In Progress state";
		
		MillTips[0] = "The mill is used to make flour out of wheat";
		MillTips[1] = "The mill only work if the output slot has less then 16 items";
		MillTips[2] = "The mills max item slot size is 16";
		
		SquezerTips[0] = "The squezer takes a liquid container and a item";
		SquezerTips[1] = "Put a liquid container in the left slot then the item in the right";
		
		PizzaOvenTips[0] = "The oven is used to cook food";
		PizzaOvenTips[1] = "The higher the heat is the faster it will cook the item";
		
		ChargerTips[0] = "The charger block will not generate power itself it require another block to do it";
		ChargerTips[1] = "If the charger has power it can recharge any electric tool from this mod";
		
	}
}
