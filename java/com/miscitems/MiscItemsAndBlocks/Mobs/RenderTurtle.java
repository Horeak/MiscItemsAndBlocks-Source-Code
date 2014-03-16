package com.miscitems.MiscItemsAndBlocks.Mobs;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTurtle extends RenderLiving {

private static final ResourceLocation textureLocation = new ResourceLocation(Refrence.Mod_Id + ":" + "textures/mobs/Turtle.png");

public RenderTurtle(ModelBase model, float shadowSize) {
super(model, shadowSize);
}

@Override
protected ResourceLocation getEntityTexture(Entity par1Entity)
{
return textureLocation;
}
}