package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ModItemElArmor extends ItemArmor implements IPowerItem{

	public ModItemElArmor(int RenderIndex, int ArmorType) {
		super(ArmorMaterial.IRON, RenderIndex, ArmorType);
		this.canRepair = false;

	}
	
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
    	
    	
    }

}
