package com.miscitems.MiscItemsAndBlocks.Items;

import MiscItemsApi.Electric.IPowerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ModItemElArmor extends ItemArmor implements IPowerItem{

	public ModItemElArmor(int RenderIndex, int ArmorType) {
		super(ArmorMaterial.IRON, RenderIndex, ArmorType);
		this.canRepair = false;

	}

    private int CurrentPower = MaxPower(new ItemStack(this));

    public boolean IsCreative;

    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){

    }

    public int CurrentPower(ItemStack stack){return CurrentPower;}

}
