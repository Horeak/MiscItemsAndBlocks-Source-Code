package com.miscitems.MiscItemsAndBlocks.Items;

import com.google.common.collect.Sets;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;

public class ModItemChargedCrystal extends ModItemWithDamage {


    protected ModItemChargedCrystal() {
        super(50);
    }

    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {

        this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":ChargedCrystal");
    }

    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {

        double DamageLeft = itemstack.getMaxDamage() - itemstack.getItemDamage();
        double Prosentage = (DamageLeft/ 50) * 100;

        if(DamageLeft == 1)
            Prosentage = 0;

        list.add(StatCollector.translateToLocal("items.desc.invisCharged")+ " " + (int)Prosentage + "%");
    }


}
