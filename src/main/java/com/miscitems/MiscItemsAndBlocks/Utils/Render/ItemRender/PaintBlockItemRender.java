package com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender;

import com.miscitems.MiscItemsAndBlocks.Utils.Render.Utils.RenderHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class PaintBlockItemRender implements IItemRenderer
{


    public PaintBlockItemRender() {}

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
        Color color = new Color(255,255,255);

        if(item.stackTagCompound != null){

            color = new Color(item.getTagCompound().getInteger("Red"), item.getTagCompound().getInteger("Green"), item.getTagCompound().getInteger("Blue"));
        }

        RenderHelper.RenderInventoryBlockWithColor(type, item, color);
    }
}