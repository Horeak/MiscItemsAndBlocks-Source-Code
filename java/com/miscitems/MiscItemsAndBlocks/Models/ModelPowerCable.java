package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPowerCable extends ModelBase
{

    ModelRenderer BottomPiece;
    ModelRenderer MiddlePiece;
    ModelRenderer TopPiece;
    ModelRenderer LeftPiece;
    ModelRenderer RightPiece;
    ModelRenderer BackPiece;
    ModelRenderer FrontPiece;
  
  public ModelPowerCable()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      BottomPiece = new ModelRenderer(this, 0, 0);
      BottomPiece.addBox(0F, 0F, 0F, 4, 6, 4);
      BottomPiece.setRotationPoint(-2F, 18F, -2F);
      BottomPiece.setTextureSize(64, 32);
      BottomPiece.mirror = true;
      setRotation(BottomPiece, 0F, 0F, 0F);
      MiddlePiece = new ModelRenderer(this, 0, 11);
      MiddlePiece.addBox(0F, 0F, 0F, 4, 4, 4);
      MiddlePiece.setRotationPoint(-2F, 14F, -2F);
      MiddlePiece.setTextureSize(64, 32);
      MiddlePiece.mirror = true;
      setRotation(MiddlePiece, 0F, 0F, 0F);
      TopPiece = new ModelRenderer(this, 0, 0);
      TopPiece.addBox(0F, 0F, 0F, 4, 6, 4);
      TopPiece.setRotationPoint(-2F, 8F, -2F);
      TopPiece.setTextureSize(64, 32);
      TopPiece.mirror = true;
      setRotation(TopPiece, 0F, 0F, 0F);
      LeftPiece = new ModelRenderer(this, 17, 0);
      LeftPiece.addBox(0F, 0F, 0F, 6, 4, 4);
      LeftPiece.setRotationPoint(-8F, 14F, -2F);
      LeftPiece.setTextureSize(64, 32);
      LeftPiece.mirror = true;
      setRotation(LeftPiece, 0F, 0F, 0F);
      RightPiece = new ModelRenderer(this, 17, 0);
      RightPiece.addBox(0F, 0F, 0F, 6, 4, 4);
      RightPiece.setRotationPoint(2F, 14F, -2F);
      RightPiece.setTextureSize(64, 32);
      RightPiece.mirror = true;
      setRotation(RightPiece, 0F, 0F, 0F);
      BackPiece = new ModelRenderer(this, 38, 0);
      BackPiece.addBox(0F, 0F, 0F, 4, 4, 6);
      BackPiece.setRotationPoint(-2F, 14F, -8F);
      BackPiece.setTextureSize(64, 32);
      BackPiece.mirror = true;
      setRotation(BackPiece, 0F, 0F, 0F);
      FrontPiece = new ModelRenderer(this, 38, 0);
      FrontPiece.addBox(0F, 0F, 0F, 4, 4, 6);
      FrontPiece.setRotationPoint(-2F, 14F, 2F);
      FrontPiece.setTextureSize(64, 32);
      FrontPiece.mirror = true;
      setRotation(FrontPiece, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean Bottom, boolean Top, boolean Left, boolean Right, boolean Front, boolean Back)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    MiddlePiece.render(f5);
    if(Bottom)
    BottomPiece.render(f5);
    
    if(Top)
    TopPiece.render(f5);
    
    if(Left)
    LeftPiece.render(f5);
    
    if(Right)
    RightPiece.render(f5);
    
    if(Back)
    BackPiece.render(f5);
    
    if(Front)
    FrontPiece.render(f5);
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
