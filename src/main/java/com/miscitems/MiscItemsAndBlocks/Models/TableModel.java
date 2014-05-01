package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TableModel extends ModelBase
{
	 //fields
    ModelRenderer BackLeft1;
    ModelRenderer BackRight1;
    ModelRenderer TableTop;
    ModelRenderer FrontRight2;
    ModelRenderer FrontLeft1;
    ModelRenderer Wool1;
    ModelRenderer Wool2;
    ModelRenderer Wool3;
    ModelRenderer Wool4;
    ModelRenderer Wool5;
    ModelRenderer Wool6;
    ModelRenderer Wool7;
    ModelRenderer Wool8;
    ModelRenderer Wool9;
    ModelRenderer FrontRight3;
    ModelRenderer FrontLeft3;
    ModelRenderer FrontRight1;
	ModelRenderer FrontRight4;
    ModelRenderer FrontLeft2;
    ModelRenderer FrontLeft5;
    ModelRenderer BackLeft3;
    ModelRenderer FrontLeft4;
    ModelRenderer BackLeft4;
    ModelRenderer BackLeft5;
    ModelRenderer BackRight3;
    ModelRenderer BackLeft2;
    ModelRenderer BackRight2;
    ModelRenderer BackRight5;
    ModelRenderer BackRight4;
    ModelRenderer FrontLeftCorner1;
    ModelRenderer FrontLeftCorner2;
    ModelRenderer FrontLeftCorner3;
    ModelRenderer BackLeftCorner1;
    ModelRenderer BackLeftCorner2;
    ModelRenderer BackLeftCorner3;
    ModelRenderer FrontRightCorner1;
    ModelRenderer FrontRightCorner2;
    ModelRenderer FrontRightCorner3;
    ModelRenderer BackRightCorner1;
    ModelRenderer BackRightCorner2;
    ModelRenderer BackRightCorner3;
    ModelRenderer FrontRight5;
  
  public TableModel()
  {
	    textureWidth = 64;
	    textureHeight = 31;
    
      BackLeft1 = new ModelRenderer(this, 0, 0);
      BackLeft1.addBox(0F, 0F, 0F, 2, 11, 2);
      BackLeft1.setRotationPoint(6F, 13F, 6F);
      BackLeft1.setTextureSize(64, 64);
      BackLeft1.mirror = true;
      setRotation(BackLeft1, 0F, 0F, 0F);
      BackRight1 = new ModelRenderer(this, 0, 0);
      BackRight1.addBox(0F, 0F, 0F, 2, 11, 2);
      BackRight1.setRotationPoint(-8F, 13F, 6F);
      BackRight1.setTextureSize(64, 64);
      BackRight1.mirror = true;
      setRotation(BackRight1, 0F, 0F, 0F);
      TableTop = new ModelRenderer(this, 0, 0);
      TableTop.addBox(0F, 0F, 0F, 16, 4, 16);
      TableTop.setRotationPoint(-8F, 9F, -8F);
      TableTop.setTextureSize(64, 31);
      TableTop.mirror = true;
      setRotation(TableTop, 0F, 0F, 0F);
      FrontRight2 = new ModelRenderer(this, 0, 0);
      FrontRight2.addBox(0F, 0F, 0F, 2, 11, 2);
      FrontRight2.setRotationPoint(-8F, 13F, -8F);
      FrontRight2.setTextureSize(64, 64);
      FrontRight2.mirror = true;
      setRotation(FrontRight2, 0F, 0F, 0F);
      FrontLeft1 = new ModelRenderer(this, 0, 0);
      FrontLeft1.addBox(0F, 0F, 0F, 2, 11, 2);
      FrontLeft1.setRotationPoint(6F, 13F, -8F);
      FrontLeft1.setTextureSize(64, 64);
      FrontLeft1.mirror = true;
      setRotation(FrontLeft1, 0F, 0F, 0F);
      Wool1 = new ModelRenderer(this, 0, 20);
      Wool1.addBox(0F, 0F, 0F, 10, 1, 10);
      Wool1.setRotationPoint(-5F, 8F, -5F);
      Wool1.setTextureSize(64, 31);
      Wool1.mirror = true;
      setRotation(Wool1, 0F, 0F, 0F);
      Wool2 = new ModelRenderer(this, 0, 20);
      Wool2.addBox(0F, 0F, 0F, 8, 1, 2);
      Wool2.setRotationPoint(-4F, 8F, -7F);
      Wool2.setTextureSize(64, 31);
      Wool2.mirror = true;
      setRotation(Wool2, 0F, 0F, 0F);
      Wool3 = new ModelRenderer(this, 0, 20);
      Wool3.addBox(0F, 0F, 0F, 4, 1, 1);
      Wool3.setRotationPoint(-2F, 8F, -8F);
      Wool3.setTextureSize(64, 31);
      Wool3.mirror = true;
      setRotation(Wool3, 0F, 0F, 0F);
      Wool4 = new ModelRenderer(this, 0, 20);
      Wool4.addBox(0F, 0F, 0F, 2, 1, 8);
      Wool4.setRotationPoint(-7F, 8F, -4F);
      Wool4.setTextureSize(64, 31);
      Wool4.mirror = true;
      setRotation(Wool4, 0F, 0F, 0F);
      Wool5 = new ModelRenderer(this, 0, 20);
      Wool5.addBox(0F, 0F, 0F, 1, 1, 4);
      Wool5.setRotationPoint(-8F, 8F, -2F);
      Wool5.setTextureSize(64, 31);
      Wool5.mirror = true;
      setRotation(Wool5, 0F, 0F, 0F);
      Wool6 = new ModelRenderer(this, 0, 20);
      Wool6.addBox(0F, 0F, 0F, 2, 1, 8);
      Wool6.setRotationPoint(5F, 8F, -4F);
      Wool6.setTextureSize(64, 31);
      Wool6.mirror = true;
      setRotation(Wool6, 0F, 0F, 0F);
      Wool7 = new ModelRenderer(this, 0, 20);
      Wool7.addBox(0F, 0F, 0F, 1, 1, 4);
      Wool7.setRotationPoint(7F, 8F, -2F);
      Wool7.setTextureSize(64, 31);
      Wool7.mirror = true;
      setRotation(Wool7, 0F, 0F, 0F);
      Wool8 = new ModelRenderer(this, 0, 20);
      Wool8.addBox(0F, 0F, 0F, 8, 1, 2);
      Wool8.setRotationPoint(-4F, 8F, 5F);
      Wool8.setTextureSize(64, 31);
      Wool8.mirror = true;
      setRotation(Wool8, 0F, 0F, 0F);
      Wool9 = new ModelRenderer(this, 0, 20);
      Wool9.addBox(0F, 0F, 0F, 4, 1, 1);
      Wool9.setRotationPoint(-2F, 8F, 7F);
      Wool9.setTextureSize(64, 31);
      Wool9.mirror = true;
      setRotation(Wool9, 0F, 0F, 0F);
      FrontRight3 = new ModelRenderer(this, 0, 0);
      FrontRight3.addBox(0F, 0F, 0F, 4, 2, 2);
      FrontRight3.setRotationPoint(-6F, 13F, -8F);
      FrontRight3.setTextureSize(64, 64);
      FrontRight3.mirror = true;
      setRotation(FrontRight3, 0F, 0F, 0F);
      FrontLeft3 = new ModelRenderer(this, 0, 0);
      FrontLeft3.addBox(0F, 0F, 0F, 4, 2, 2);
      FrontLeft3.setRotationPoint(2F, 13F, -8F);
      FrontLeft3.setTextureSize(64, 64);
      FrontLeft3.mirror = true;
      setRotation(FrontLeft3, 0F, 0F, 0F);
      FrontRight1 = new ModelRenderer(this, 0, 0);
      FrontRight1.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontRight1.setRotationPoint(-6F, 15F, -8F);
      FrontRight1.setTextureSize(64, 64);
      FrontRight1.mirror = true;
      setRotation(FrontRight1, 0F, 0F, 0F);
      FrontLeft2 = new ModelRenderer(this, 0, 0);
      FrontLeft2.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontLeft2.setRotationPoint(4F, 15F, -8F);
      FrontLeft2.setTextureSize(64, 64);
      FrontLeft2.mirror = true;
      setRotation(FrontLeft2, 0F, 0F, 0F);
      FrontLeft5 = new ModelRenderer(this, 0, 0);
      FrontLeft5.addBox(0F, 0F, 0F, 2, 2, 4);
      FrontLeft5.setRotationPoint(6F, 13F, -6F);
      FrontLeft5.setTextureSize(64, 64);
      FrontLeft5.mirror = true;
      setRotation(FrontLeft3, 0F, 0F, 0F);
      BackLeft3 = new ModelRenderer(this, 0, 0);
      BackLeft3.addBox(0F, 0F, 0F, 2, 2, 4);
      BackLeft3.setRotationPoint(6F, 13F, 2F);
      BackLeft3.setTextureSize(64, 64);
      BackLeft3.mirror = true;
      setRotation(BackLeft3, 0F, 0F, 0F);
      FrontLeft4 = new ModelRenderer(this, 0, 0);
      FrontLeft4.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontLeft4.setRotationPoint(6F, 15F, -6F);
      FrontLeft4.setTextureSize(64, 64);
      FrontLeft4.mirror = true;
      setRotation(FrontLeft4, 0F, 0F, 0F);
      BackLeft4 = new ModelRenderer(this, 0, 0);
      BackLeft4.addBox(0F, 0F, 0F, 2, 2, 2);
      BackLeft4.setRotationPoint(6F, 15F, 4F);
      BackLeft4.setTextureSize(64, 64);
      BackLeft4.mirror = true;
      setRotation(BackLeft4, 0F, 0F, 0F);
      BackLeft5 = new ModelRenderer(this, 0, 0);
      BackLeft5.addBox(0F, 0F, 0F, 4, 2, 2);
      BackLeft5.setRotationPoint(2F, 13F, 6F);
      BackLeft5.setTextureSize(64, 64);
      BackLeft5.mirror = true;
      setRotation(BackLeft3, 0F, 0F, 0F);
      BackRight3 = new ModelRenderer(this, 0, 0);
      BackRight3.addBox(0F, 0F, 0F, 4, 2, 2);
      BackRight3.setRotationPoint(-6F, 13F, 6F);
      BackRight3.setTextureSize(64, 64);
      BackRight3.mirror = true;
      setRotation(BackRight3, 0F, 0F, 0F);
      BackLeft2 = new ModelRenderer(this, 0, 0);
      BackLeft2.addBox(0F, 0F, 0F, 2, 2, 2);
      BackLeft2.setRotationPoint(4F, 15F, 6F);
      BackLeft2.setTextureSize(64, 64);
      BackLeft2.mirror = true;
      setRotation(BackLeft2, 0F, 0F, 0F);
      BackRight2 = new ModelRenderer(this, 0, 0);
      BackRight2.addBox(0F, 0F, 0F, 2, 2, 2);
      BackRight2.setRotationPoint(-6F, 15F, 6F);
      BackRight2.setTextureSize(64, 64);
      BackRight2.mirror = true;
      setRotation(BackRight2, 0F, 0F, 0F);
      BackRight5 = new ModelRenderer(this, 0, 0);
      BackRight5.addBox(0F, 0F, 0F, 2, 2, 4);
      BackRight5.setRotationPoint(-8F, 13F, 2F);
      BackRight5.setTextureSize(64, 64);
      BackRight5.mirror = true;
      setRotation(BackRight5, 0F, 0F, 0F);
      BackRight4 = new ModelRenderer(this, 0, 0);
      BackRight4.addBox(0F, 0F, 0F, 2, 2, 2);
      BackRight4.setRotationPoint(-8F, 15F, 4F);
      BackRight4.setTextureSize(64, 64);
      BackRight4.mirror = true;
      setRotation(BackRight4, 0F, 0F, 0F);
      FrontRight4 = new ModelRenderer(this, 0, 0);
      FrontRight4.addBox(0F, 0F, 0F, 2, 2, 2);
      FrontRight4.setRotationPoint(-8F, 15F, -6F);
      FrontRight4.setTextureSize(64, 64);
      FrontRight4.mirror = true;
      setRotation(FrontRight4, 0F, 0F, 0F);
      FrontLeftCorner1 = new ModelRenderer(this, 0, 20);
      FrontLeftCorner1.addBox(0F, 0F, 0F, 4, 1, 4);
      FrontLeftCorner1.setRotationPoint(-8F, 8F, -8F);
      FrontLeftCorner1.setTextureSize(64, 31);
      FrontLeftCorner1.mirror = true;
      setRotation(FrontLeftCorner1, 0F, 0F, 0F);
      FrontLeftCorner2 = new ModelRenderer(this, 0, 20);
      FrontLeftCorner2.addBox(0F, 0F, 0F, 2, 1, 1);
      FrontLeftCorner2.setRotationPoint(-4F, 8F, -8F);
      FrontLeftCorner2.setTextureSize(64, 31);
      FrontLeftCorner2.mirror = true;
      setRotation(FrontLeftCorner2, 0F, 0F, 0F);
      FrontLeftCorner3 = new ModelRenderer(this, 0, 20);
      FrontLeftCorner3.addBox(0F, 0F, 0F, 1, 1, 2);
      FrontLeftCorner3.setRotationPoint(-8F, 8F, -4F);
      FrontLeftCorner3.setTextureSize(64, 31);
      FrontLeftCorner3.mirror = true;
      setRotation(FrontLeftCorner3, 0F, 0F, 0F);
      BackLeftCorner1 = new ModelRenderer(this, 0, 20);
      BackLeftCorner1.addBox(0F, 0F, 0F, 4, 1, 4);
      BackLeftCorner1.setRotationPoint(-8F, 8F, 4F);
      BackLeftCorner1.setTextureSize(64, 31);
      BackLeftCorner1.mirror = true;
      setRotation(BackLeftCorner1, 0F, 0F, 0F);
      BackLeftCorner2 = new ModelRenderer(this, 0, 20);
      BackLeftCorner2.addBox(0F, 0F, 0F, 1, 1, 2);
      BackLeftCorner2.setRotationPoint(-8F, 8F, 2F);
      BackLeftCorner2.setTextureSize(64, 31);
      BackLeftCorner2.mirror = true;
      setRotation(BackLeftCorner2, 0F, 0F, 0F);
      BackLeftCorner3 = new ModelRenderer(this, 0, 20);
      BackLeftCorner3.addBox(0F, 0F, 0F, 2, 1, 1);
      BackLeftCorner3.setRotationPoint(-4F, 8F, 7F);
      BackLeftCorner3.setTextureSize(64, 31);
      BackLeftCorner3.mirror = true;
      setRotation(BackLeftCorner3, 0F, 0F, 0F);
      FrontRightCorner1 = new ModelRenderer(this, 0, 20);
      FrontRightCorner1.addBox(0F, 0F, 0F, 4, 1, 4);
      FrontRightCorner1.setRotationPoint(4F, 8F, -8F);
      FrontRightCorner1.setTextureSize(64, 31);
      FrontRightCorner1.mirror = true;
      setRotation(FrontRightCorner1, 0F, 0F, 0F);
      FrontRightCorner2 = new ModelRenderer(this, 0, 20);
      FrontRightCorner2.addBox(0F, 0F, 0F, 2, 1, 1);
      FrontRightCorner2.setRotationPoint(2F, 8F, -8F);
      FrontRightCorner2.setTextureSize(64, 31);
      FrontRightCorner2.mirror = true;
      setRotation(FrontRightCorner2, 0F, 0F, 0F);
      FrontRightCorner3 = new ModelRenderer(this, 0, 20);
      FrontRightCorner3.addBox(0F, 0F, 0F, 1, 1, 2);
      FrontRightCorner3.setRotationPoint(7F, 8F, -4F);
      FrontRightCorner3.setTextureSize(64, 31);
      FrontRightCorner3.mirror = true;
      setRotation(FrontRightCorner3, 0F, 0F, 0F);
      BackRightCorner1 = new ModelRenderer(this, 0, 20);
      BackRightCorner1.addBox(0F, 0F, 0F, 4, 1, 4);
      BackRightCorner1.setRotationPoint(4F, 8F, 4F);
      BackRightCorner1.setTextureSize(64, 31);
      BackRightCorner1.mirror = true;
      setRotation(BackRightCorner1, 0F, 0F, 0F);
      BackRightCorner2 = new ModelRenderer(this, 0, 20);
      BackRightCorner2.addBox(0F, 0F, 0F, 2, 1, 1);
      BackRightCorner2.setRotationPoint(2F, 8F, 7F);
      BackRightCorner2.setTextureSize(64, 31);
      BackRightCorner2.mirror = true;
      setRotation(BackRightCorner2, 0F, 0F, 0F);
      BackRightCorner3 = new ModelRenderer(this, 0, 20);
      BackRightCorner3.addBox(0F, 0F, 0F, 1, 1, 2);
      BackRightCorner3.setRotationPoint(7F, 8F, 2F);
      BackRightCorner3.setTextureSize(64, 31);
      BackRightCorner3.mirror = true;
      setRotation(BackRightCorner3, 0F, 0F, 0F);
      FrontRight5 = new ModelRenderer(this, 0, 0);
      FrontRight5.addBox(0F, 0F, 0F, 2, 2, 4);
      FrontRight5.setRotationPoint(-8F, 13F, -6F);
      FrontRight5.setTextureSize(64, 64);
      FrontRight5.mirror = true;
      setRotation(FrontRight5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean Wool, boolean Right, boolean Left, boolean Front, boolean Back, boolean TableFront, boolean TableBack, boolean TableRight, boolean TableLeft)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    
    
    if(!TableFront && !TableRight){
    BackLeft1.render(f5);
    BackLeft2.render(f5);
    BackLeft3.render(f5);
    BackLeft4.render(f5);
    BackLeft5.render(f5);
    
    }
    
    if(!TableFront && !TableLeft){
        BackRight1.render(f5);
        BackRight2.render(f5);
        BackRight3.render(f5);
        BackRight4.render(f5);
        BackRight5.render(f5);
    }
    
    if(!TableBack && !TableLeft){
        FrontRight1.render(f5);
        FrontRight2.render(f5);
        FrontRight3.render(f5);
        FrontRight4.render(f5);
        FrontRight5.render(f5);
        
    	
    }
    
    if(!TableBack && !TableRight){
        FrontLeft1.render(f5);
        FrontLeft2.render(f5);
        FrontLeft3.render(f5);
        FrontLeft4.render(f5);
        FrontLeft5.render(f5);
    }
    
    

    
    
    
    
    
    
    
    TableTop.render(f5);
    
    if(Wool){
    Wool1.render(f5);
    Wool2.render(f5);
    Wool3.render(f5);
    Wool4.render(f5);
    Wool5.render(f5);
    Wool6.render(f5);
    Wool7.render(f5);
    Wool8.render(f5);
    Wool9.render(f5);
    }
    
    
    

    
    
    
    
    if(Wool){
    	
    	
   if(Left){
    FrontLeftCorner1.render(f5);
    FrontLeftCorner2.render(f5);
    FrontLeftCorner3.render(f5);
    
    BackLeftCorner1.render(f5);
    BackLeftCorner2.render(f5);
    BackLeftCorner3.render(f5);
    }
   
   if(Right){
   BackRightCorner1.render(f5);
   BackRightCorner2.render(f5);
   BackRightCorner3.render(f5);
   
   FrontRightCorner1.render(f5);
   FrontRightCorner2.render(f5);
   FrontRightCorner3.render(f5);
   }
    
    if(Front){
    BackLeftCorner1.render(f5);
    BackLeftCorner2.render(f5);
    BackLeftCorner3.render(f5);
    
    BackRightCorner1.render(f5);
    BackRightCorner2.render(f5);
    BackRightCorner3.render(f5);
    }
    
    if(Back){
    FrontRightCorner1.render(f5);
    FrontRightCorner2.render(f5);
    FrontRightCorner3.render(f5);
    
    FrontLeftCorner1.render(f5);
    FrontLeftCorner2.render(f5);
    FrontLeftCorner3.render(f5);
    }
    
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
