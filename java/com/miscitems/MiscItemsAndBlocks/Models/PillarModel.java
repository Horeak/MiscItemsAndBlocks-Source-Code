package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PillarModel extends ModelBase
{
  //fields
    ModelRenderer Bottom1;
    ModelRenderer Bottom2;
    ModelRenderer Bottom6;
    ModelRenderer Bottom7;
    ModelRenderer Bottom8;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top5;
    ModelRenderer Top7;
    ModelRenderer Top8;
    ModelRenderer SideDown3;
    ModelRenderer SideDown4;
    ModelRenderer MiddleDown;
    ModelRenderer MiddleFrontBack;
    ModelRenderer Front1;
    ModelRenderer Front2;
    ModelRenderer Front4;
    ModelRenderer Front7;
    ModelRenderer Front8;
    ModelRenderer FrontBackSide1;
    ModelRenderer FrontBackSide4;
    ModelRenderer Back1;
    ModelRenderer Back2;
    ModelRenderer Back3;
    ModelRenderer Back4;
    ModelRenderer Back5;
    ModelRenderer MiddleLeftRight;
    ModelRenderer Right1;
    ModelRenderer Right2;
    ModelRenderer Right3;
    ModelRenderer Right4;
    ModelRenderer Right5;
    ModelRenderer RightLeftSide1;
    ModelRenderer RightLeftSide2;
    ModelRenderer Left1;
    ModelRenderer Left2;
    ModelRenderer Left3;
    ModelRenderer Left4;
    ModelRenderer Left5;
  
  public PillarModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Bottom1 = new ModelRenderer(this, 0, 0);
      Bottom1.addBox(0F, 0F, 0F, 6, 1, 12);
      Bottom1.setRotationPoint(-3F, 23F, -6F);
      Bottom1.setTextureSize(64, 32);
      Bottom1.mirror = true;
      setRotation(Bottom1, 0F, 0F, 0F);
      Bottom2 = new ModelRenderer(this, 0, 0);
      Bottom2.addBox(0F, 0F, 0F, 12, 1, 6);
      Bottom2.setRotationPoint(-6F, 23F, -3F);
      Bottom2.setTextureSize(64, 32);
      Bottom2.mirror = true;
      setRotation(Bottom2, 0F, 0F, 0F);
      Bottom6 = new ModelRenderer(this, 0, 0);
      Bottom6.addBox(0F, 0F, 0F, 10, 1, 10);
      Bottom6.setRotationPoint(-5F, 23F, -5F);
      Bottom6.setTextureSize(64, 32);
      Bottom6.mirror = true;
      setRotation(Bottom6, 0F, 0F, 0F);
      Bottom7 = new ModelRenderer(this, 0, 0);
      Bottom7.addBox(0F, 0F, 0F, 8, 1, 10);
      Bottom7.setRotationPoint(-4F, 22F, -5F);
      Bottom7.setTextureSize(64, 32);
      Bottom7.mirror = true;
      setRotation(Bottom7, 0F, 0F, 0F);
      Bottom8 = new ModelRenderer(this, 0, 0);
      Bottom8.addBox(0F, 0F, 0F, 10, 1, 8);
      Bottom8.setRotationPoint(-5F, 22F, -4F);
      Bottom8.setTextureSize(64, 32);
      Bottom8.mirror = true;
      setRotation(Bottom8, 0F, 0F, 0F);
      Top1 = new ModelRenderer(this, 0, 0);
      Top1.addBox(0F, 0F, 0F, 12, 1, 6);
      Top1.setRotationPoint(-6F, 8F, -3F);
      Top1.setTextureSize(64, 32);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 0, 0);
      Top2.addBox(0F, 0F, 0F, 6, 1, 12);
      Top2.setRotationPoint(-3F, 8F, -6F);
      Top2.setTextureSize(64, 32);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Top5 = new ModelRenderer(this, 0, 0);
      Top5.addBox(0F, 0F, 0F, 10, 1, 10);
      Top5.setRotationPoint(-5F, 8F, -5F);
      Top5.setTextureSize(64, 32);
      Top5.mirror = true;
      setRotation(Top5, 0F, 0F, 0F);
      Top7 = new ModelRenderer(this, 0, 0);
      Top7.addBox(0F, 0F, 0F, 8, 1, 10);
      Top7.setRotationPoint(-4F, 9F, -5F);
      Top7.setTextureSize(64, 32);
      Top7.mirror = true;
      setRotation(Top7, 0F, 0F, 0F);
      Top8 = new ModelRenderer(this, 0, 0);
      Top8.addBox(0F, 0F, 0F, 10, 1, 8);
      Top8.setRotationPoint(-5F, 9F, -4F);
      Top8.setTextureSize(64, 32);
      Top8.mirror = true;
      setRotation(Top8, 0F, 0F, 0F);
      SideDown3 = new ModelRenderer(this, 0, 0);
      SideDown3.addBox(0F, 0F, 0F, 4, 16, 8);
      SideDown3.setRotationPoint(-2F, 8F, -4F);
      SideDown3.setTextureSize(64, 32);
      SideDown3.mirror = true;
      setRotation(SideDown3, 0F, 0F, 0F);
      SideDown4 = new ModelRenderer(this, 0, 0);
      SideDown4.addBox(0F, 0F, 0F, 8, 16, 4);
      SideDown4.setRotationPoint(-4F, 8F, -2F);
      SideDown4.setTextureSize(64, 32);
      SideDown4.mirror = true;
      setRotation(SideDown4, 0F, 0F, 0F);
      MiddleDown = new ModelRenderer(this, 0, 0);
      MiddleDown.addBox(0F, 0F, 0F, 6, 16, 6);
      MiddleDown.setRotationPoint(-3F, 8F, -3F);
      MiddleDown.setTextureSize(64, 32);
      MiddleDown.mirror = true;
      setRotation(MiddleDown, 0F, 0F, 0F);
      MiddleFrontBack = new ModelRenderer(this, 0, 0);
      MiddleFrontBack.addBox(0F, 0F, 0F, 6, 6, 16);
      MiddleFrontBack.setRotationPoint(-3F, 13F, -8F);
      MiddleFrontBack.setTextureSize(64, 32);
      MiddleFrontBack.mirror = true;
      setRotation(MiddleFrontBack, 0F, 0F, 0F);
      Front1 = new ModelRenderer(this, 0, 0);
      Front1.addBox(0F, 0F, 0F, 6, 12, 1);
      Front1.setRotationPoint(-3F, 10F, -8F);
      Front1.setTextureSize(64, 32);
      Front1.mirror = true;
      setRotation(Front1, 0F, 0F, 0F);
      Front2 = new ModelRenderer(this, 0, 0);
      Front2.addBox(0F, 0F, 0F, 12, 6, 1);
      Front2.setRotationPoint(-6F, 13F, -8F);
      Front2.setTextureSize(64, 32);
      Front2.mirror = true;
      setRotation(Front2, 0F, 0F, 0F);
      Front4 = new ModelRenderer(this, 0, 0);
      Front4.addBox(0F, 0F, 0F, 10, 10, 1);
      Front4.setRotationPoint(-5F, 11F, -8F);
      Front4.setTextureSize(64, 32);
      Front4.mirror = true;
      setRotation(Front4, 0F, 0F, 0F);
      Front7 = new ModelRenderer(this, 0, 0);
      Front7.addBox(0F, 0F, 0F, 8, 10, 1);
      Front7.setRotationPoint(-4F, 11F, -7F);
      Front7.setTextureSize(64, 32);
      Front7.mirror = true;
      setRotation(Front7, 0F, 0F, 0F);
      Front8 = new ModelRenderer(this, 0, 0);
      Front8.addBox(0F, 0F, 0F, 10, 8, 1);
      Front8.setRotationPoint(-5F, 12F, -7F);
      Front8.setTextureSize(64, 32);
      Front8.mirror = true;
      setRotation(Front8, 0F, 0F, 0F);
      FrontBackSide1 = new ModelRenderer(this, 0, 0);
      FrontBackSide1.addBox(0F, 0F, 0F, 4, 8, 16);
      FrontBackSide1.setRotationPoint(-2F, 12F, -8F);
      FrontBackSide1.setTextureSize(64, 32);
      FrontBackSide1.mirror = true;
      setRotation(FrontBackSide1, 0F, 0F, 0F);
      FrontBackSide4 = new ModelRenderer(this, 0, 0);
      FrontBackSide4.addBox(0F, 0F, 0F, 8, 4, 16);
      FrontBackSide4.setRotationPoint(-4F, 14F, -8F);
      FrontBackSide4.setTextureSize(64, 32);
      FrontBackSide4.mirror = true;
      setRotation(FrontBackSide4, 0F, 0F, 0F);
      Back1 = new ModelRenderer(this, 0, 0);
      Back1.addBox(0F, 0F, 0F, 6, 12, 1);
      Back1.setRotationPoint(-3F, 10F, 7F);
      Back1.setTextureSize(64, 32);
      Back1.mirror = true;
      setRotation(Back1, 0F, 0F, 0F);
      Back2 = new ModelRenderer(this, 0, 0);
      Back2.addBox(0F, 0F, 0F, 12, 6, 1);
      Back2.setRotationPoint(-6F, 13F, 7F);
      Back2.setTextureSize(64, 32);
      Back2.mirror = true;
      setRotation(Back2, 0F, 0F, 0F);
      Back3 = new ModelRenderer(this, 0, 0);
      Back3.addBox(0F, 0F, 0F, 10, 10, 1);
      Back3.setRotationPoint(-5F, 11F, 7F);
      Back3.setTextureSize(64, 32);
      Back3.mirror = true;
      setRotation(Back3, 0F, 0F, 0F);
      Back4 = new ModelRenderer(this, 0, 0);
      Back4.addBox(0F, 0F, 0F, 8, 10, 1);
      Back4.setRotationPoint(-4F, 11F, 6F);
      Back4.setTextureSize(64, 32);
      Back4.mirror = true;
      setRotation(Back4, 0F, 0F, 0F);
      Back5 = new ModelRenderer(this, 0, 0);
      Back5.addBox(0F, 0F, 0F, 10, 8, 1);
      Back5.setRotationPoint(-5F, 12F, 6F);
      Back5.setTextureSize(64, 32);
      Back5.mirror = true;
      setRotation(Back5, 0F, 0F, 0F);
      MiddleLeftRight = new ModelRenderer(this, 0, 0);
      MiddleLeftRight.addBox(0F, 0F, 0F, 16, 6, 6);
      MiddleLeftRight.setRotationPoint(-8F, 13F, -3F);
      MiddleLeftRight.setTextureSize(64, 32);
      MiddleLeftRight.mirror = true;
      setRotation(MiddleLeftRight, 0F, 0F, 0F);
      Right1 = new ModelRenderer(this, 0, 0);
      Right1.addBox(0F, 0F, 0F, 1, 12, 6);
      Right1.setRotationPoint(-8F, 10F, -3F);
      Right1.setTextureSize(64, 32);
      Right1.mirror = true;
      setRotation(Right1, 0F, 0F, 0F);
      Right2 = new ModelRenderer(this, 0, 0);
      Right2.addBox(0F, 0F, 0F, 1, 6, 12);
      Right2.setRotationPoint(-8F, 13F, -6F);
      Right2.setTextureSize(64, 32);
      Right2.mirror = true;
      setRotation(Right2, 0F, 0F, 0F);
      Right3 = new ModelRenderer(this, 0, 0);
      Right3.addBox(0F, 0F, 0F, 1, 10, 10);
      Right3.setRotationPoint(-8F, 11F, -5F);
      Right3.setTextureSize(64, 32);
      Right3.mirror = true;
      setRotation(Right3, 0F, 0F, 0F);
      Right4 = new ModelRenderer(this, 0, 0);
      Right4.addBox(0F, 0F, 0F, 1, 10, 8);
      Right4.setRotationPoint(-7F, 11F, -4F);
      Right4.setTextureSize(64, 32);
      Right4.mirror = true;
      setRotation(Right4, 0F, 0F, 0F);
      Right5 = new ModelRenderer(this, 0, 0);
      Right5.addBox(0F, 0F, 0F, 1, 8, 10);
      Right5.setRotationPoint(-7F, 12F, -5F);
      Right5.setTextureSize(64, 32);
      Right5.mirror = true;
      setRotation(Right5, 0F, 0F, 0F);
      RightLeftSide1 = new ModelRenderer(this, 0, 0);
      RightLeftSide1.addBox(0F, 0F, 0F, 16, 8, 4);
      RightLeftSide1.setRotationPoint(-8F, 12F, -2F);
      RightLeftSide1.setTextureSize(64, 32);
      RightLeftSide1.mirror = true;
      setRotation(RightLeftSide1, 0F, 0F, 0F);
      RightLeftSide2 = new ModelRenderer(this, 0, 0);
      RightLeftSide2.addBox(0F, 0F, 0F, 16, 4, 8);
      RightLeftSide2.setRotationPoint(-8F, 14F, -4F);
      RightLeftSide2.setTextureSize(64, 32);
      RightLeftSide2.mirror = true;
      setRotation(RightLeftSide2, 0F, 0F, 0F);
      Left1 = new ModelRenderer(this, 0, 0);
      Left1.addBox(0F, 0F, 0F, 1, 12, 6);
      Left1.setRotationPoint(7F, 10F, -3F);
      Left1.setTextureSize(64, 32);
      Left1.mirror = true;
      setRotation(Left1, 0F, 0F, 0F);
      Left2 = new ModelRenderer(this, 0, 0);
      Left2.addBox(0F, 0F, 0F, 1, 6, 12);
      Left2.setRotationPoint(7F, 13F, -6F);
      Left2.setTextureSize(64, 32);
      Left2.mirror = true;
      setRotation(Left2, 0F, 0F, 0F);
      Left3 = new ModelRenderer(this, 0, 0);
      Left3.addBox(0F, 0F, 0F, 1, 10, 10);
      Left3.setRotationPoint(7F, 11F, -5F);
      Left3.setTextureSize(64, 32);
      Left3.mirror = true;
      setRotation(Left3, 0F, 0F, 0F);
      Left4 = new ModelRenderer(this, 0, 0);
      Left4.addBox(0F, 0F, 0F, 1, 10, 8);
      Left4.setRotationPoint(6F, 11F, -4F);
      Left4.setTextureSize(64, 32);
      Left4.mirror = true;
      setRotation(Left4, 0F, 0F, 0F);
      Left5 = new ModelRenderer(this, 0, 0);
      Left5.addBox(0F, 0F, 0F, 1, 8, 10);
      Left5.setRotationPoint(6F, 12F, -5F);
      Left5.setTextureSize(64, 32);
      Left5.mirror = true;
      setRotation(Left5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean Top, boolean Bottom, boolean Front, boolean Back, boolean Left, boolean Right, boolean Item)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if(!Item){
    if(!Bottom && !Top && !Front && !Back && !Right && !Left){
        MiddleDown.render(f5);
        SideDown3.render(f5);
        SideDown4.render(f5);
    	
        Bottom1.render(f5);
        Bottom2.render(f5);
        Bottom6.render(f5);
        Bottom7.render(f5);
        Bottom8.render(f5);
        
        Top1.render(f5);
        Top2.render(f5);
        Top5.render(f5);
        Top7.render(f5);
        Top8.render(f5);
    }
    
    
    if(Top && !Bottom){
        Bottom1.render(f5);
        Bottom2.render(f5);
        Bottom6.render(f5);
        Bottom7.render(f5);
        Bottom8.render(f5);
    }
    
    if(Bottom && !Top){
        Top1.render(f5);
        Top2.render(f5);
        Top5.render(f5);
        Top7.render(f5);
        Top8.render(f5);
    }
    
    

    if(Front && !Back){
    Front1.render(f5);
    Front2.render(f5);
    Front4.render(f5);
    Front7.render(f5);
    Front8.render(f5);
    }
    
    if(Back && !Front){
    Back1.render(f5);
    Back2.render(f5);
    Back3.render(f5);
    Back4.render(f5);
    Back5.render(f5);
    }
    
    
    if(Right && !Left){
    Right1.render(f5);
    Right2.render(f5);
    Right3.render(f5);
    Right4.render(f5);
    Right5.render(f5);
    }
    
    
    if(Left && !Right){
    Left1.render(f5);
    Left2.render(f5);
    Left3.render(f5);
    Left4.render(f5);
    Left5.render(f5);
    }
    
    if(Top || Bottom){
    MiddleDown.render(f5);
    SideDown3.render(f5);
    SideDown4.render(f5);
    }
    
    if(Front || Back){
    MiddleFrontBack.render(f5);
    FrontBackSide1.render(f5);
    FrontBackSide4.render(f5);
    }
    
    if(Right || Left){
    MiddleLeftRight.render(f5);
    RightLeftSide1.render(f5);
    RightLeftSide2.render(f5);
    }
    }else{
    	
    	
        MiddleDown.render(f5);
        SideDown3.render(f5);
        SideDown4.render(f5);
    	
        Bottom1.render(f5);
        Bottom2.render(f5);
        Bottom6.render(f5);
        Bottom7.render(f5);
        Bottom8.render(f5);
        
        Top1.render(f5);
        Top2.render(f5);
        Top5.render(f5);
        Top7.render(f5);
        Top8.render(f5);
    }
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