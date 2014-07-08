package MiscItemsApi.Electric;

import net.minecraft.item.ItemStack;

public interface IPowerItem {


    /**
     * Adds power to the item
     *
     * @param stack
     * @param Amount
     */
    void AddPower(ItemStack stack, double Amount);


    /**
     * Removes power from the item
     *
     * @param stack
     * @param Amount
     */
    void RemovePower(ItemStack stack, double Amount);

	/**
	 * Set the max power of a item
	 * 
	 * @param stack the stack
	 * @return Max itemstack power
	 */
 
	double MaxPower(ItemStack stack);


    /**
     * Get the current amount of power
     *
     * @param stack the stack
     * @return the amount of power the item currently has
     */

    double CurrentPower(ItemStack stack);
	
	/**
	 * Set the amount of power recharged at a time
	 * 
	 * @param stack the stack
	 * @return the amount of power added when charging
	 */
    double ChargeAmount(ItemStack stack);
	
	/**
	 * 
	 * Allow Power items to recharge from a electric backpack
	 * 
	 * @param stack the stack
	 * @return can be charged from a backpack
	 */
	boolean CanBackpackRecharge(ItemStack stack);
	
	
	

}
