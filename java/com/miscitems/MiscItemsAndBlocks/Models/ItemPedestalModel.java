package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ItemPedestalModel extends ModelBase
{
	//fields
	    ModelRenderer Bottom;
	    ModelRenderer Middle;
	    ModelRenderer MiddleTop;
	    ModelRenderer Top1;
	    ModelRenderer Top2;
	    ModelRenderer Top3;
	    ModelRenderer Top4;
	    ModelRenderer MiddleTopCon;
	    ModelRenderer Corner1;
	    ModelRenderer Corner2;
	    ModelRenderer Corner3;
	    ModelRenderer Corner4;
	    ModelRenderer Under1;
	    ModelRenderer Under2;
	    ModelRenderer Under3;
	    ModelRenderer Under4;
	    ModelRenderer TopMiddle1;
	    ModelRenderer TopMiddle2;
	    ModelRenderer TopMiddle3;
	    ModelRenderer TopMiddle4;
  
  public ItemPedestalModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
    Bottom = new ModelRenderer(this, 0, 0);
    Bottom.addBox(0F, 0F, 0F, 12, 3, 12);
    Bottom.setRotationPoint(-6F, 21F, -6F);
    Bottom.setTextureSize(64, 64);
    Bottom.mirror = true;
    setRotation(Bottom, 0F, 0F, 0F);
    Middle = new ModelRenderer(this, 0, 15);
    Middle.addBox(0F, 0F, 0F, 8, 9, 8);
    Middle.setRotationPoint(-4F, 12F, -4F);
    Middle.setTextureSize(64, 64);
    Middle.mirror = true;
    setRotation(Middle, 0F, 0F, 0F);
    MiddleTop = new ModelRenderer(this, 0, 0);
    MiddleTop.addBox(0F, 0F, 0F, 6, 5, 6);
    MiddleTop.setRotationPoint(-3F, 7F, -3F);
    MiddleTop.setTextureSize(64, 64);
    MiddleTop.mirror = true;
    setRotation(MiddleTop, 0F, 0F, 0F);
    Top1 = new ModelRenderer(this, 0, 0);
    Top1.addBox(0F, 0F, 0F, 4, 2, 2);
    Top1.setRotationPoint(-2F, 2F, -4F);
    Top1.setTextureSize(64, 64);
    Top1.mirror = true;
    setRotation(Top1, 0F, 0F, 0F);
    Top2 = new ModelRenderer(this, 0, 0);
    Top2.addBox(0F, 0F, 0F, 2, 2, 4);
    Top2.setRotationPoint(-4F, 2F, -2F);
    Top2.setTextureSize(64, 64);
    Top2.mirror = true;
    setRotation(Top2, 0F, 0F, 0F);
    Top3 = new ModelRenderer(this, 0, 0);
    Top3.addBox(0F, 0F, 0F, 4, 2, 2);
    Top3.setRotationPoint(-2F, 2F, 2F);
    Top3.setTextureSize(64, 64);
    Top3.mirror = true;
    setRotation(Top3, 0F, 0F, 0F);
    Top4 = new ModelRenderer(this, 0, 0);
    Top4.addBox(0F, 0F, 0F, 2, 2, 4);
    Top4.setRotationPoint(2F, 2F, -2F);
    Top4.setTextureSize(64, 64);
    Top4.mirror = true;
    setRotation(Top4, 0F, 0F, 0F);
    MiddleTopCon = new ModelRenderer(this, 0, 0);
    MiddleTopCon.addBox(0F, 0F, 0F, 4, 3, 4);
    MiddleTopCon.setRotationPoint(-2F, 4F, -2F);
    MiddleTopCon.setTextureSize(64, 64);
    MiddleTopCon.mirror = true;
    setRotation(MiddleTopCon, 0F, 0F, 0F);
    Corner1 = new ModelRenderer(this, 0, 0);
    Corner1.addBox(0F, 0F, 0F, 1, 5, 1);
    Corner1.setRotationPoint(2F, -1F, 2F);
    Corner1.setTextureSize(64, 64);
    Corner1.mirror = true;
    setRotation(Corner1, 0F, 0F, 0F);
    Corner2 = new ModelRenderer(this, 0, 0);
    Corner2.addBox(0F, 0F, 0F, 1, 5, 1);
    Corner2.setRotationPoint(-3F, -1F, 2F);
    Corner2.setTextureSize(64, 64);
    Corner2.mirror = true;
    setRotation(Corner2, 0F, 0F, 0F);
    Corner3 = new ModelRenderer(this, 0, 0);
    Corner3.addBox(0F, 0F, 0F, 1, 5, 1);
    Corner3.setRotationPoint(-3F, -1F, -3F);
    Corner3.setTextureSize(64, 64);
    Corner3.mirror = true;
    setRotation(Corner3, 0F, 0F, 0F);
    Corner4 = new ModelRenderer(this, 0, 0);
    Corner4.addBox(0F, 0F, 0F, 1, 5, 1);
    Corner4.setRotationPoint(2F, -1F, -3F);
    Corner4.setTextureSize(64, 64);
    Corner4.mirror = true;
    setRotation(Corner4, 0F, 0F, 0F);
    Under1 = new ModelRenderer(this, 0, 0);
    Under1.addBox(0F, 0F, 0F, 4, 1, 1);
    Under1.setRotationPoint(-2F, 4F, -3F);
    Under1.setTextureSize(64, 64);
    Under1.mirror = true;
    setRotation(Under1, 0F, 0F, 0F);
    Under2 = new ModelRenderer(this, 0, 0);
    Under2.addBox(0F, 0F, 0F, 1, 1, 4);
    Under2.setRotationPoint(2F, 4F, -2F);
    Under2.setTextureSize(64, 64);
    Under2.mirror = true;
    setRotation(Under2, 0F, 0F, 0F);
    Under3 = new ModelRenderer(this, 0, 0);
    Under3.addBox(0F, 0F, 0F, 4, 1, 1);
    Under3.setRotationPoint(-2F, 4F, 2F);
    Under3.setTextureSize(64, 64);
    Under3.mirror = true;
    setRotation(Under3, 0F, 0F, 0F);
    Under4 = new ModelRenderer(this, 0, 0);
    Under4.addBox(0F, 0F, 0F, 1, 1, 4);
    Under4.setRotationPoint(-3F, 4F, -2F);
    Under4.setTextureSize(64, 64);
    Under4.mirror = true;
    setRotation(Under4, 0F, 0F, 0F);
    TopMiddle1 = new ModelRenderer(this, 0, 0);
    TopMiddle1.addBox(0F, 0F, 0F, 4, 1, 1);
    TopMiddle1.setRotationPoint(-2F, 3F, -2F);
    TopMiddle1.setTextureSize(64, 64);
    TopMiddle1.mirror = true;
    setRotation(TopMiddle1, 0F, 0F, 0F);
    TopMiddle2 = new ModelRenderer(this, 0, 0);
    TopMiddle2.addBox(0F, 0F, 0F, 1, 1, 4);
    TopMiddle2.setRotationPoint(1F, 3F, -2F);
    TopMiddle2.setTextureSize(64, 64);
    TopMiddle2.mirror = true;
    setRotation(TopMiddle2, 0F, 0F, 0F);
    TopMiddle3 = new ModelRenderer(this, 0, 0);
    TopMiddle3.addBox(0F, 0F, 0F, 4, 1, 1);
    TopMiddle3.setRotationPoint(-2F, 3F, 1F);
    TopMiddle3.setTextureSize(64, 64);
    TopMiddle3.mirror = true;
    setRotation(TopMiddle3, 0F, 0F, 0F);
    TopMiddle4 = new ModelRenderer(this, 0, 0);
    TopMiddle4.addBox(0F, 0F, 0F, 1, 1, 4);
    TopMiddle4.setRotationPoint(-2F, 3F, -2F);
    TopMiddle4.setTextureSize(64, 64);
    TopMiddle4.mirror = true;
    setRotation(TopMiddle4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bottom.render(f5);
    Middle.render(f5);
    MiddleTop.render(f5);
    Top1.render(f5);
    Top2.render(f5);
    Top3.render(f5);
    Top4.render(f5);
    MiddleTopCon.render(f5);
    Corner1.render(f5);
    Corner2.render(f5);
    Corner3.render(f5);
    Corner4.render(f5);
    Under1.render(f5);
    Under2.render(f5);
    Under3.render(f5);
    Under4.render(f5);
    TopMiddle1.render(f5);
    TopMiddle2.render(f5);
    TopMiddle3.render(f5);
    TopMiddle4.render(f5);
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

