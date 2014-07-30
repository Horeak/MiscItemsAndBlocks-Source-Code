package com.miscitems.MiscItemsAndBlocks.Utils.Render.ItemRender;

import com.miscitems.MiscItemsAndBlocks.Models.PillarModel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
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
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glTranslatef((float) 0.5F, (float) 1.9F, (float) 0.5F);
        } else {
            GL11.glTranslatef((float) 0.5F, (float) 1.4F, (float) 0.5F);
        }

        if (PillarUtils.BlU.size() > 0) {
            if (item.getTagCompound() != null) {
                if (item.getTagCompound().getInteger("Bl") > PillarUtils.BlU.size())
                    item.getTagCompound().setInteger("Bl", 0);

                Block block = Block.getBlockFromItem(PillarUtils.BlU.get(item.getTagCompound().getInteger("Bl")).getItem());


                if(block instanceof BlockAir || block == null || block == Blocks.air) {
                    GL11.glPopMatrix();
                    return;
                }


                if (block != null){

                    ResourceLocation res = new ResourceLocation(GameRegistry.findUniqueIdentifierFor(block).modId.toLowerCase(), "textures/blocks/" + (block.getIcon(0, item.getItemDamage()).getIconName()).replace(GameRegistry.findUniqueIdentifierFor(block).modId + ":", "") + ".png");


                if (res != null) {

                    Minecraft.getMinecraft().getTextureManager().bindTexture(res);
                }
            }

        }
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

        model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, false, false);

        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
	}
}
