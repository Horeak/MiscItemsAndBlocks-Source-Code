package MiscItemsApi.Electric;

import net.minecraft.item.ItemStack;

public interface IPowerItem {
	
	
	/**
	 * Set the max power of a item
	 * 
	 * @param stack the stack
	 * @return Max itemstack power
	 */
 
	int MaxPower(ItemStack stack);


    /**
     * Get the current amount of power
     *
     * @param stack the stack
     * @return the amount of power the item currently has
     */

    int CurrentPower(ItemStack stack);
	
	/**
	 * Set the amount of power recharged at a time
	 * 
	 * @param stack the stack
	 * @return the amount of power added when charging
	 */
	int ChargeAmount(ItemStack stack);
	
	/**
	 * 
	 * Allow Power items to recharge from a electric backpack
	 * 
	 * @param stack the stack
	 * @return can be charged from a backpack
	 */
	boolean CanBackpackRecharge(ItemStack stack);
	
	
	

}
