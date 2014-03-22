package MiscItemsApi.Electric;

import net.minecraft.item.ItemStack;

public interface IPowerItem {
	
	
	/**
	 * Set the max power of a item
	 * 
	 * @param stack
	 * @return Max itemstack power
	 */
 
	int MaxPower(ItemStack stack);
	
	/**
	 * Set the amount of power recharged at a time
	 * 
	 * @param stack
	 * @return
	 */
	int ChargeAmount(ItemStack stack);
	
	/**
	 * 
	 * Allow Power items to recharg from a electric backpack
	 * 
	 * @param stack
	 * @return
	 */
	boolean CanBackpackRecharge(ItemStack stack);
	
	
	

}
