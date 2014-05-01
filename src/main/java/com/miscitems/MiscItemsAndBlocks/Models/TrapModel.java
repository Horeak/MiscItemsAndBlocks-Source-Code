package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TrapModel extends ModelBase
{
    ModelRenderer MainPart;
    ModelRenderer Pad;
  
  public TrapModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    MainPart = new ModelRenderer(this, 0, 0);
    MainPart.addBox(0F, 0F, 0F, 12, 1, 12);
    MainPart.setRotationPoint(-6F, 23F, -6F);
    MainPart.setTextureSize(64, 32);
    MainPart.mirror = true;
    setRotation(MainPart, 0F, 0F, 0F);
    Pad = new ModelRenderer(this, 0, 0);
    Pad.addBox(0F, 0F, 0F, 12, 1, 12);
    Pad.setRotationPoint(-6F, 22F, -6F);
    Pad.setTextureSize(64, 32);
    Pad.mirror = true;
    setRotation(Pad, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean IsEntityOnTop)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    MainPart.render(f5);
    if(IsEntityOnTop)
    Pad.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
