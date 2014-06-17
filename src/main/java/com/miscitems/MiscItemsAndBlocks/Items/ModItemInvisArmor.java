package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ModItemInvisArmor extends ItemArmor {

    private String iconName;
    private int ArmorTypeNumber;


    public ModItemInvisArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, int par5) {
        super(par2EnumArmorMaterial, par3, par4);

    }




    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        if (stack.getItem() == ModItems.InvisChestPlate || stack.getItem() == ModItems.InvisHelmet || stack.getItem() == ModItems.InvisBoots) {
            return Reference.Mod_Id + ":" + "textures/models/armor/InvisArmor_layer_1.png";

        }
        if (stack.getItem() == ModItems.InvisLeggings) {

            return Reference.Mod_Id + ":" + "textures/models/armor/InvisArmor_layer_2.png";

        } else {


            return null;
        }
    }
}