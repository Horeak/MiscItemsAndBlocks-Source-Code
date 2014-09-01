package com.miscitems.MiscItemsAndBlocks.Models;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMiningStation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class MiningChamberModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer DrillBlade1;
    ModelRenderer DrillBlade2;
    ModelRenderer DrillBlade3;
    ModelRenderer DrillShaft;
    ModelRenderer DrillBlade4;
    ModelRenderer Shape5;
    ModelRenderer Screen1;
    ModelRenderer Screen2;
    ModelRenderer Screen3;
    ModelRenderer Screen4;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
  
  public MiningChamberModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    

      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 13, 2);
      Shape1.setRotationPoint(-6F, 11F, -6F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 13, 2);
      Shape2.setRotationPoint(4F, 11F, 4F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 2, 13, 2);
      Shape3.setRotationPoint(4F, 11F, -6F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 2, 13, 2);
      Shape4.setRotationPoint(-6F, 11F, 4F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      
      DrillBlade1 = new ModelRenderer(this, 56, 0);
      DrillBlade1.addBox(-1F, 0F, -1F, 2, 1, 2);
      DrillBlade1.setRotationPoint(0F, 23F, 0F);
      DrillBlade1.setTextureSize(64, 32);
      DrillBlade1.mirror = true;
      setRotation(DrillBlade1, 0F, 0.2268928F, 0F);
      
      DrillBlade2 = new ModelRenderer(this, 48, 3);
      DrillBlade2.addBox(-2F, 0F, -2F, 4, 1, 4);
      DrillBlade2.setRotationPoint(0F, 22F, 0F);
      DrillBlade2.setTextureSize(64, 32);
      DrillBlade2.mirror = true;
      setRotation(DrillBlade2, 0F, -0.296706F, 0F);
      
      DrillBlade3 = new ModelRenderer(this, 40, 8);
      DrillBlade3.addBox(-3F, 0F, -3F, 6, 1, 6);
      DrillBlade3.setRotationPoint(0F, 21F, 0F);
      DrillBlade3.setTextureSize(64, 32);
      DrillBlade3.mirror = true;
      setRotation(DrillBlade3, 0F, 0.3141593F, 0F);

      DrillBlade4 = new ModelRenderer(this, 32, 15);
      DrillBlade4.addBox(-4F, 0F, -4F, 8, 1, 8);
      DrillBlade4.setRotationPoint(0F, 20F, 0F);
      DrillBlade4.setTextureSize(64, 32);
      DrillBlade4.mirror = true;
      setRotation(DrillBlade4, 0F, -0.3665191F, 0F);
      
      DrillShaft = new ModelRenderer(this, 56, 24);
      DrillShaft.addBox(0F, 0F, 0F, 2, 6, 2);
      DrillShaft.setRotationPoint(-1F, 14F, -1F);
      DrillShaft.setTextureSize(64, 32);
      DrillShaft.mirror = true;
      setRotation(DrillShaft, 0F, 0F, 0F);
      
      Shape5 = new ModelRenderer(this, 0, 15);
      Shape5.addBox(-4F, 0F, -4F, 8, 4, 8);
      Shape5.setRotationPoint(0F, 11F, 0F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Screen1 = new ModelRenderer(this, 16, 6);
      Screen1.addBox(0F, 0F, 0F, 6, 2, 1);
      Screen1.setRotationPoint(-3F, 12F, -5F);
      Screen1.setTextureSize(64, 32);
      Screen1.mirror = true;
      setRotation(Screen1, 0F, 0F, 0F);
      Screen2 = new ModelRenderer(this, 16, 0);
      Screen2.addBox(0F, 0F, 0F, 1, 2, 6);
      Screen2.setRotationPoint(4F, 12F, -3F);
      Screen2.setTextureSize(64, 32);
      Screen2.mirror = true;
      setRotation(Screen2, 0F, 0F, 0F);
      Screen3 = new ModelRenderer(this, 16, 0);
      Screen3.addBox(0F, 0F, 0F, 1, 2, 6);
      Screen3.setRotationPoint(-5F, 12F, -3F);
      Screen3.setTextureSize(64, 32);
      Screen3.mirror = true;
      setRotation(Screen3, 0F, 0F, 0F);
      Screen4 = new ModelRenderer(this, 16, 6);
      Screen4.addBox(0F, 0F, 0F, 6, 2, 1);
      Screen4.setRotationPoint(-3F, 12F, 4F);
      Screen4.setTextureSize(64, 32);
      Screen4.mirror = true;
      setRotation(Screen4, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape6.setRotationPoint(-4F, 11F, -5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape7.setRotationPoint(3F, 11F, -5F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape8.setRotationPoint(-5F, 11F, 3F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape9.setRotationPoint(-5F, 11F, -4F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape10.setRotationPoint(-4F, 11F, 4F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape11.setRotationPoint(3F, 11F, 4F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape12.setRotationPoint(4F, 11F, -4F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 0);
      Shape13.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape13.setRotationPoint(4F, 11F, 3F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 27);
      Shape14.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape14.setRotationPoint(-2F, 10F, -2F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 0, 30);
      Shape15.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape15.setRotationPoint(-1F, 10F, -2F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 0, 28);
      Shape16.addBox(0F, 0F, 0F, 1, 1, 3);
      Shape16.setRotationPoint(1F, 10F, -1F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 0, 30);
      Shape17.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape17.setRotationPoint(-1F, 10F, 1F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 0, 30);
      Shape18.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape18.setRotationPoint(-1F, 10F, 2F);
      Shape18.setTextureSize(64, 32);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 0, 29);
      Shape19.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape19.setRotationPoint(2F, 10F, -1F);
      Shape19.setTextureSize(64, 32);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 0, 30);
      Shape20.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape20.setRotationPoint(-1F, 10F, -3F);
      Shape20.setTextureSize(64, 32);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 0, 29);
      Shape21.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape21.setRotationPoint(-3F, 10F, -1F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
  }
  
  
	float CurrentRotation = 0;
	
	
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, TileEntity tile, int Mode)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    TileEntityMiningStation tile_ent;
    
    if(tile != null)
    tile_ent = (TileEntityMiningStation)tile;
    
    boolean Item = tile == null;
    
    
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
    
    
    if(!Item){
    if(Mode == 1){
    	GL11.glColor4f(0F, 1F, 0F, 1F);
    	
    }else if(Mode == 2){
    	
    	GL11.glColor4f(1F, 1F, 0F, 1F);
    	
    }else if (Mode == 3){
    	
    	GL11.glColor4f(0F, 0F, 1F, 1F);
    	
    }else{
    	GL11.glColor4f(1F, 0F, 0F, 1F);
    }
    }else{
    	GL11.glColor4f(1F, 0F, 0F, 1F);
    }
    
    Screen1.render(f5);
    Screen2.render(f5);
    Screen3.render(f5);
    Screen4.render(f5);
    
    
	GL11.glColor4f(1F, 1F, 1F, 1F);
	
	
	
	

	
	
	if(!Item) {
        if (Mode == 1) {

            float g = new Long(System.currentTimeMillis()).shortValue() / 60;
            float t = 0.08F;

            setRotation(DrillBlade1, 0F, t * g, 0F);
            setRotation(DrillBlade2, 0F, -t * g, 0F);
            setRotation(DrillBlade3, 0F, t * g, 0F);
            setRotation(DrillBlade4, 0F, -t * g, 0F);

        } else {
            setRotation(DrillBlade1, 0F, 0.2268928F, 0F);
            setRotation(DrillBlade2, 0F, -0.296706F, 0F);
            setRotation(DrillBlade3, 0F, 0.3141593F, 0F);
            setRotation(DrillBlade4, 0F, -0.3665191F, 0F);
        }
    }
    DrillBlade1.render(f5);
    DrillBlade2.render(f5);
    DrillBlade3.render(f5);
    DrillShaft.render(f5);
    DrillBlade4.render(f5);
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


