package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;




public class TurtleShellModel extends ModelBase
{
	  //fields
    ModelRenderer Tummy;
    ModelRenderer MiddleShell;
    ModelRenderer MidTopShell;
    ModelRenderer TopShell;
  
  public TurtleShellModel()
  {
	  textureWidth = 32;
	    textureHeight = 32;
	    
	    Tummy = new ModelRenderer(this, 0, 23);
	      Tummy.addBox(-2.5F, 0F, -2F, 4, 1, 5);
	      Tummy.setRotationPoint(0F, 23F, 0F);
	      Tummy.setTextureSize(32, 32);
	      Tummy.mirror = true;
	      setRotation(Tummy, 0F, 0F, 0F);
	      MiddleShell = new ModelRenderer(this, 0, 15);
	      MiddleShell.addBox(-2.5F, 0F, -3F, 5, 1, 6);
	      MiddleShell.setRotationPoint(-0.5F, 22.5F, 0.5F);
	      MiddleShell.setTextureSize(32, 32);
	      MiddleShell.mirror = true;
	      setRotation(MiddleShell, 0F, 0F, 0F);
	      MidTopShell = new ModelRenderer(this, 0, 8);
	      MidTopShell.addBox(-2F, 0F, -2.5F, 4, 1, 5);
	      MidTopShell.setRotationPoint(-0.5F, 22F, 0.5F);
	      MidTopShell.setTextureSize(32, 32);
	      MidTopShell.mirror = true;
	      setRotation(MidTopShell, 0F, 0F, 0F);
	      TopShell = new ModelRenderer(this, 0, 2);
	      TopShell.addBox(-1.5F, 0F, -2F, 3, 1, 4);
	      TopShell.setRotationPoint(-0.5F, 21.5F, 0.5F);
	      TopShell.setTextureSize(32, 32);
	      TopShell.mirror = true;
	      setRotation(TopShell, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Tummy.render(f5);
    MiddleShell.render(f5);
    MidTopShell.render(f5);
    TopShell.render(f5);
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
