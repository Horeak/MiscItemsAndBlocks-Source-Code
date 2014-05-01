package com.miscitems.MiscItemsAndBlocks.ItemRender;

import com.miscitems.MiscItemsAndBlocks.Models.PillarModel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;



@SideOnly(Side.CLIENT)
public class PillarItemRender implements IItemRenderer
{

    private TileEntityPillar tile = new TileEntityPillar();



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

		PillarModel model = new PillarModel();
	    
	    GL11.glPushMatrix();
        if(type == ItemRenderType.EQUIPPED_FIRST_PERSON){
            GL11.glTranslatef((float) 0.5F, (float) 1.9F, (float) 0.5F);
        }else{
            GL11.glTranslatef((float) 0.5F, (float) 1.4F, (float) 0.5F);
        }
        
        
       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/blocks/quartz_block_top.png"));
        
        
       GL11.glPushMatrix();
       GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
       
      model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, true, true, false, false, false, false, true);
       
       GL11.glPopMatrix();
       GL11.glPopMatrix();
        
	}
}
