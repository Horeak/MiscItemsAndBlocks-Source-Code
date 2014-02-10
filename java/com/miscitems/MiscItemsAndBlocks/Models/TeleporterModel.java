package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class TeleporterModel extends ModelBase
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
    ModelRenderer PlateUnder;
    ModelRenderer MainPlate;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Light;
  
  public TeleporterModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape1.setRotationPoint(4F, 23F, -6F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape2.setRotationPoint(-6F, 23F, -6F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape3.setRotationPoint(-6F, 23F, 4F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape4.setRotationPoint(4F, 23F, 4F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape5.setRotationPoint(3F, 21F, 3F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape6.setRotationPoint(-5F, 21F, -5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape7.setRotationPoint(3F, 21F, -5F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape8.setRotationPoint(-5F, 21F, 3F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      PlateUnder = new ModelRenderer(this, 0, 4);
      PlateUnder.addBox(0F, 0F, 0F, 8, 1, 8);
      PlateUnder.setRotationPoint(-4F, 20F, -4F);
      PlateUnder.setTextureSize(64, 32);
      PlateUnder.mirror = true;
      setRotation(PlateUnder, 0F, 0F, 0F);
      MainPlate = new ModelRenderer(this, 0, 20);
      MainPlate.addBox(0F, 0F, 0F, 10, 2, 10);
      MainPlate.setRotationPoint(-5F, 18F, -5F);
      MainPlate.setTextureSize(64, 32);
      MainPlate.mirror = true;
      setRotation(MainPlate, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 42, 19);
      Shape11.addBox(0F, 0F, 0F, 10, 3, 1);
      Shape11.setRotationPoint(-5F, 17F, -6F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 42, 19);
      Shape12.addBox(0F, 0F, 0F, 1, 3, 10);
      Shape12.setRotationPoint(-6F, 17F, -5F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 42, 19);
      Shape13.addBox(0F, 0F, 0F, 1, 3, 10);
      Shape13.setRotationPoint(5F, 17F, -5F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 42, 19);
      Shape14.addBox(0F, 0F, 0F, 10, 3, 1);
      Shape14.setRotationPoint(-5F, 17F, 5F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 19, 0);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape9.setRotationPoint(1F, 17F, 4F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, -0.2974289F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 29, 0);
      Shape10.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape10.setRotationPoint(1F, 14.2F, 5F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, -0.3346083F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 29, 0);
      Shape15.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape15.setRotationPoint(4F, 14.2F, 5F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, -0.3346083F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 19, 0);
      Shape16.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape16.setRotationPoint(1F, 13.3F, 5.3F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, -0.3346075F, 0F, 0F);
      Light = new ModelRenderer(this, 35, 0);
      Light.addBox(0F, 0F, 0F, 2, 3, 1);
      Light.setRotationPoint(2F, 14.2F, 5F);
      Light.setTextureSize(64, 32);
      Light.mirror = true;
      setRotation(Light, -0.3346145F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int Mode)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    PlateUnder.render(f5);
    MainPlate.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    
    if(Mode == 1){
    	
    	GL11.glColor4f(0.0F, 1.0F, 0.0F, 1.0F);
    	
    }else if (Mode == 2){
    	
    	GL11.glColor4f(0.0F, 0.0F, 1.0F, 1.0F);
    	
    }else{
    	
    	GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
    	
    }
    
    Light.render(f5);
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
