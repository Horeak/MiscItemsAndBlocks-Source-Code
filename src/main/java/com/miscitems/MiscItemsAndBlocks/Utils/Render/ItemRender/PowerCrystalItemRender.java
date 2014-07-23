package com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityPowerCrystal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class PowerCrystalItemRender implements IItemRenderer
{

    private final IModelCustom model;

    public PowerCrystalItemRender() {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("miscitems", "Models/BigCrystal.obj"));
    }

    private TileEntityPowerCrystal tile = new TileEntityPowerCrystal();



    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case ENTITY:
                return true;
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glTranslated(0.3, 0.2, 0.3);
        GL11.glScalef(0.8F, 0.8F, 0.8F);
        GL11.glEnable(GL11.GL_BLEND);


        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("miscitems", "textures/models/BigCrystalAlphaTexture.png"));

        GL11.glPushMatrix();
        GL11.glColor4f(0, 0, 0, 1F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        model.renderAll();


        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}
