package com.miscitems.MiscItemsAndBlocks.Item.Magic;

import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ModItemCrystalPickaxe extends ItemPickaxe {


    public ModItemCrystalPickaxe() {
        super(ModItems.CrystalMaterial);
        this.setMaxDamage(-1);
    }


    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        return true;
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {

        return true;
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    public boolean hasEffect(ItemStack stack)
    {
        return stack.getTagCompound() != null;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {

        if(itemstack.getTagCompound() != null) {

            if (itemstack.getTagCompound().getBoolean("Eff"))
                list.add("Upgraded: Efficiency");

            if (itemstack.getTagCompound().getBoolean("SilkTouch"))
                list.add("Upgraded: Silk touch");

            if (itemstack.getTagCompound().getBoolean("Fortune"))
                list.add("Upgraded: Fortune");



        }
    }


}
