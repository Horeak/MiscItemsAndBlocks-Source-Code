package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;




public class TvModel extends ModelBase
{
	//fields
    ModelRenderer Screen;
    ModelRenderer ShellBottom;
    ModelRenderer ShellTop;
    ModelRenderer ShellRight;
    ModelRenderer SellLeft;
    ModelRenderer ShellBack;
    ModelRenderer AntennaBox;
    ModelRenderer AntennaRight;
    ModelRenderer AntennaLeft;
  
  public TvModel()
  {
	  textureWidth = 64;
	    textureHeight = 32;
	    
	    Screen = new ModelRenderer(this, 28, 0);
	      Screen.addBox(-3.5F, -3.5F, -3.5F, 9, 9, 9);
	      Screen.setRotationPoint(-1F, 17.5F, -1F);
	      Screen.setTextureSize(64, 32);
	      Screen.mirror = true;
	      setRotation(Screen, 0F, 0F, 0F);
	      ShellBottom = new ModelRenderer(this, 0, 21);
	      ShellBottom.addBox(-5.5F, -0.5F, 0F, 11, 1, 10);
	      ShellBottom.setRotationPoint(0F, 23.5F, -5F);
	      ShellBottom.setTextureSize(64, 32);
	      ShellBottom.mirror = true;
	      setRotation(ShellBottom, 0F, 0F, 0F);
	      ShellTop = new ModelRenderer(this, 0, 21);
	      ShellTop.addBox(-5.5F, -1F, 0F, 11, 1, 10);
	      ShellTop.setRotationPoint(0F, 14F, -5F);
	      ShellTop.setTextureSize(64, 32);
	      ShellTop.mirror = true;
	      setRotation(ShellTop, 0F, 0F, 0F);
	      ShellRight = new ModelRenderer(this, 0, 13);
	      ShellRight.addBox(0F, 0F, 0F, 1, 9, 10);
	      ShellRight.setRotationPoint(-5.5F, 14F, -5F);
	      ShellRight.setTextureSize(64, 32);
	      ShellRight.mirror = true;
	      setRotation(ShellRight, 0F, 0F, 0F);
	      SellLeft = new ModelRenderer(this, 0, 13);
	      SellLeft.addBox(0F, 0F, 0F, 1, 9, 10);
	      SellLeft.setRotationPoint(4.5F, 14F, -5F);
	      SellLeft.setTextureSize(64, 32);
	      SellLeft.mirror = true;
	      setRotation(SellLeft, 0F, 0F, 0F);
	      ShellBack = new ModelRenderer(this, 0, 22);
	      ShellBack.addBox(-3.5F, -3.5F, 0F, 9, 9, 1);
	      ShellBack.setRotationPoint(-1F, 17.5F, 4F);
	      ShellBack.setTextureSize(64, 32);
	      ShellBack.mirror = true;
	      setRotation(ShellBack, 0F, 0F, 0F);
	      AntennaBox = new ModelRenderer(this, 0, 0);
	      AntennaBox.addBox(-2F, 0F, -1.5F, 4, 1, 3);
	      AntennaBox.setRotationPoint(0F, 12F, -1F);
	      AntennaBox.setTextureSize(64, 32);
	      AntennaBox.mirror = true;
	      setRotation(AntennaBox, 0F, 0F, 0F);
	      AntennaRight = new ModelRenderer(this, 0, 5);
	      AntennaRight.addBox(-0.5F, -5F, -0.5F, 1, 6, 1);
	      AntennaRight.setRotationPoint(-1F, 12F, -1F);
	      AntennaRight.setTextureSize(64, 32);
	      AntennaRight.mirror = true;
	      setRotation(AntennaRight, 0F, 0F, -0.6108652F);
	      AntennaLeft = new ModelRenderer(this, 0, 5);
	      AntennaLeft.addBox(-0.5F, -6F, -0.5F, 1, 6, 1);
	      AntennaLeft.setRotationPoint(1F, 13F, -1F);
	      AntennaLeft.setTextureSize(64, 32);
	      AntennaLeft.mirror = true;
	      setRotation(AntennaLeft, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Screen.render(f5);
    ShellBottom.render(f5);
    ShellTop.render(f5);
    ShellRight.render(f5);
    SellLeft.render(f5);
    ShellBack.render(f5);
    AntennaBox.render(f5);
    AntennaRight.render(f5);
    AntennaLeft.render(f5);
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
