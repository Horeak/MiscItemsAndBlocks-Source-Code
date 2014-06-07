package com.miscitems.MiscItemsAndBlocks.Items;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.List;
import java.util.Set;

public class ModItemWithDamage extends ItemTool{


    int MaxDamage;

    protected ModItemWithDamage(int ItemMaxDamage) {
        super(0, ToolMaterial.WOOD, Sets.newHashSet());
        this.setMaxDamage(ItemMaxDamage);

        MaxDamage = ItemMaxDamage;
    }

    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_){

        return false;
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        return 0;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {

        return 0.01F;
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    { }


    public float getDamageVsEntity()
    {
        return 0;
    }

}
