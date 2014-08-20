package com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender;

import MiscUtils.Render.RenderHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class MetalBrickItemRender implements IItemRenderer
{


    public MetalBrickItemRender() {}

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case ENTITY:
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }


    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        switch (type) {
            case ENTITY: {
                return (helper == ItemRendererHelper.ENTITY_BOBBING ||
                        helper == ItemRendererHelper.ENTITY_ROTATION ||
                        helper == ItemRendererHelper.BLOCK_3D);
            }
            case EQUIPPED: {
                return (helper == ItemRendererHelper.BLOCK_3D ||
                        helper == ItemRendererHelper.EQUIPPED_BLOCK);
            }
            case EQUIPPED_FIRST_PERSON: {
                return (helper == ItemRendererHelper.EQUIPPED_BLOCK);
            }
            case INVENTORY: {
                return (helper == ItemRendererHelper.INVENTORY_BLOCK);
            }
            default: {
                return false;
            }
        }
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        int Meta = item.getItemDamage();

        RenderHelper.RenderInventoryBlockWithColor(type, item, new Color(ItemDye.field_150922_c[15 - Meta]));

    }
}