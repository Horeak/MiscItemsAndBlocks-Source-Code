package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DiceHolderModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;

    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    
    ModelRenderer Dice1;
    ModelRenderer Dice2;
    ModelRenderer Dice3;
    ModelRenderer Dice4;
    ModelRenderer Dice5;
    ModelRenderer Dice6;
  
  public DiceHolderModel()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 10, 2, 10);
      Shape1.setRotationPoint(-5F, 22F, -5F);
      Shape1.setTextureSize(64, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 12);
      Shape2.addBox(0F, 0F, 0F, 3, 6, 3);
      Shape2.setRotationPoint(1F, 16F, -4F);
      Shape2.setTextureSize(64, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 12);
      Shape3.addBox(0F, 0F, 0F, 3, 6, 3);
      Shape3.setRotationPoint(1F, 16F, 1F);
      Shape3.setTextureSize(64, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 12);
      Shape4.addBox(0F, 0F, 0F, 3, 6, 3);
      Shape4.setRotationPoint(-4F, 16F, -4F);
      Shape4.setTextureSize(64, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 12);
      Shape5.addBox(0F, 0F, 0F, 3, 6, 3);
      Shape5.setRotationPoint(-4F, 16F, 1F);
      Shape5.setTextureSize(64, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 14, 18);
      Shape6.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape6.setRotationPoint(-3F, 15F, -3F);
      Shape6.setTextureSize(64, 128);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 14, 18);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape7.setRotationPoint(1F, 15F, 1F);
      Shape7.setTextureSize(64, 128);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 14, 18);
      Shape8.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape8.setRotationPoint(1F, 15F, -3F);
      Shape8.setTextureSize(64, 128);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 14, 18);
      Shape9.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape9.setRotationPoint(-3F, 15F, 1F);
      Shape9.setTextureSize(64, 128);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      
      
      Dice1 = new ModelRenderer(this, 0, 22);
      Dice1.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice1.setRotationPoint(0F, 13F, 0F);
      Dice1.setTextureSize(64, 128);
      Dice1.mirror = true;
      setRotation(Dice1, 0.7807508F, 0.1115358F, -0.5576792F);
      
      Dice2 = new ModelRenderer(this, 32, 22);
      Dice2.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice2.setRotationPoint(0F, 13F, 0F);
      Dice2.setTextureSize(64, 128);
      Dice2.mirror = true;
      setRotation(Dice2, 0.7807508F, 0.1115358F, -0.5576792F);
      
      Dice3 = new ModelRenderer(this, 0, 38);
      Dice3.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice3.setRotationPoint(0F, 13F, 0F);
      Dice3.setTextureSize(64, 128);
      Dice3.mirror = true;
      setRotation(Dice3, 0.7807508F, 0.1115358F, -0.5576792F);
      
      Dice4 = new ModelRenderer(this, 32, 38);
      Dice4.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice4.setRotationPoint(0F, 13F, 0F);
      Dice4.setTextureSize(64, 128);
      Dice4.mirror = true;
      setRotation(Dice4, 0.7807508F, 0.1115358F, -0.5576792F);
      
      Dice5 = new ModelRenderer(this, 0, 54);
      Dice5.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice5.setRotationPoint(0F, 13F, 0F);
      Dice5.setTextureSize(64, 128);
      Dice5.mirror = true;
      setRotation(Dice5, 0.7807508F, 0.1115358F, -0.5576792F);
      
      Dice6 = new ModelRenderer(this, 32, 54);
      Dice6.addBox(0F, -8F, 0F, 8, 8, 8);
      Dice6.setRotationPoint(0F, 13F, 0F);
      Dice6.setTextureSize(64, 128);
      Dice6.mirror = true;
      setRotation(Dice6, 0.7807508F, 0.1115358F, -0.5576792F);
      
      
      Shape11 = new ModelRenderer(this, 14, 18);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(-2F, 14F, -2F);
      Shape11.setTextureSize(64, 128);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 14, 18);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape12.setRotationPoint(1F, 14F, -2F);
      Shape12.setTextureSize(64, 128);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 14, 18);
      Shape13.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape13.setRotationPoint(-2F, 14F, 1F);
      Shape13.setTextureSize(64, 128);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 14, 18);
      Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape14.setRotationPoint(1F, 14F, 1F);
      Shape14.setTextureSize(64, 128);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
  }
  
  float CurrentHight = 0F;
  
  boolean Down = false;
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int Number, boolean Item)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    
    
    


    
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);


    if(CurrentHight >= -0.20F && !Down){
    	CurrentHight = CurrentHight - 0.0005F;
    }else{
    	Down = true;
    	CurrentHight = CurrentHight + 0.0005F;
    }
    
    if(CurrentHight >= 0)
    	Down = false;
    
    
    Dice1.offsetY = CurrentHight;
    Dice2.offsetY = CurrentHight;
    Dice3.offsetY = CurrentHight;
    Dice4.offsetY = CurrentHight;
    Dice5.offsetY = CurrentHight;
    Dice6.offsetY = CurrentHight;
    
    
    
    
    if(Number == 0 || Number == 1){
    Dice1.render(f5);
    
    }else if (Number == 2){
    	Dice2.render(f5);
    }else if (Number == 3){
    	Dice3.render(f5);
    }else if (Number == 4){
    	Dice4.render(f5);
    }else if (Number== 5){
    	Dice5.render(f5);
    }else if (Number == 6){
    	Dice6.render(f5);
    }else{
    	Dice1.render(f5);
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
