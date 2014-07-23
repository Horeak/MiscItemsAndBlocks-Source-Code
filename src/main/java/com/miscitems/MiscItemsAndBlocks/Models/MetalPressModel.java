package com.miscitems.MiscItemsAndBlocks.Models;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMetalPress;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MetalPressModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer HolderLeft;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer HolderRight;
    ModelRenderer BasePlate;
    ModelRenderer TopPlate;
    ModelRenderer PlateHolder1;
    ModelRenderer PlateHolder2;
    ModelRenderer PlateHolder3;
    ModelRenderer PlateHolder4;
    ModelRenderer PlateHolder5;
    ModelRenderer PlateHolder6;
    ModelRenderer PlateTop;
    ModelRenderer BackPlate;
  
  public MetalPressModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 72, 0);
      Shape1.addBox(0F, 0F, 0F, 14, 1, 14);
      Shape1.setRotationPoint(-7F, 23F, -7F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 57);
      Shape2.addBox(0F, 0F, 0F, 2, 5, 2);
      Shape2.setRotationPoint(-6F, 18F, -6F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 57);
      Shape3.addBox(0F, 0F, 0F, 2, 5, 2);
      Shape3.setRotationPoint(4F, 18F, -6F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 57);
      Shape4.addBox(0F, 0F, 0F, 2, 5, 2);
      Shape4.setRotationPoint(-6F, 18F, 4F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 57);
      Shape5.addBox(0F, 0F, 0F, 2, 5, 2);
      Shape5.setRotationPoint(4F, 18F, 4F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 48);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 5);
      Shape6.setRotationPoint(-6F, 16F, -6F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 48);
      Shape7.addBox(0F, 0F, 0F, 2, 2, 5);
      Shape7.setRotationPoint(-6F, 16F, 1F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      HolderLeft = new ModelRenderer(this, 57, 0);
      HolderLeft.addBox(0F, 0F, 0F, 2, 10, 2);
      HolderLeft.setRotationPoint(-6F, 8F, -1F);
      HolderLeft.setTextureSize(128, 64);
      HolderLeft.mirror = true;
      setRotation(HolderLeft, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 48);
      Shape8.addBox(0F, 0F, 0F, 2, 2, 5);
      Shape8.setRotationPoint(4F, 16F, -6F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 48);
      Shape9.addBox(0F, 0F, 0F, 2, 2, 5);
      Shape9.setRotationPoint(4F, 16F, 1F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      HolderRight = new ModelRenderer(this, 57, 0);
      HolderRight.addBox(0F, 0F, 0F, 2, 10, 2);
      HolderRight.setRotationPoint(4F, 8F, -1F);
      HolderRight.setTextureSize(128, 64);
      HolderRight.mirror = true;
      setRotation(HolderRight, 0F, 0F, 0F);
      BasePlate = new ModelRenderer(this, 91, 18);
      BasePlate.addBox(0F, 0F, 0F, 8, 2, 10);
      BasePlate.setRotationPoint(-4F, 15F, -5F);
      BasePlate.setTextureSize(128, 64);
      BasePlate.mirror = true;
      setRotation(BasePlate, 0F, 0F, 0F);
      TopPlate = new ModelRenderer(this, 91, 31);
      TopPlate.addBox(0F, 0F, 0F, 8, 2, 8);
      TopPlate.setRotationPoint(-4F, 11F, -4F);
      TopPlate.setTextureSize(128, 64);
      TopPlate.mirror = true;
      setRotation(TopPlate, 0F, 0F, 0F);
      PlateHolder1 = new ModelRenderer(this, 0, 22);
      PlateHolder1.addBox(0F, 0F, 0F, 8, 3, 1);
      PlateHolder1.setRotationPoint(-4F, 9F, -5F);
      PlateHolder1.setTextureSize(128, 64);
      PlateHolder1.mirror = true;
      setRotation(PlateHolder1, 0F, 0F, 0F);
      PlateHolder2 = new ModelRenderer(this, 0, 15);
      PlateHolder2.addBox(0F, 0F, 0F, 2, 2, 3);
      PlateHolder2.setRotationPoint(4F, 10F, -4F);
      PlateHolder2.setTextureSize(128, 64);
      PlateHolder2.mirror = true;
      setRotation(PlateHolder2, 0F, 0F, 0F);
      PlateHolder3 = new ModelRenderer(this, 0, 15);
      PlateHolder3.addBox(0F, 0F, 0F, 2, 2, 3);
      PlateHolder3.setRotationPoint(4F, 10F, 1F);
      PlateHolder3.setTextureSize(128, 64);
      PlateHolder3.mirror = true;
      setRotation(PlateHolder3, 0F, 0F, 0F);
      PlateHolder4 = new ModelRenderer(this, 0, 22);
      PlateHolder4.addBox(0F, 0F, 0F, 8, 3, 1);
      PlateHolder4.setRotationPoint(-4F, 9F, 4F);
      PlateHolder4.setTextureSize(128, 64);
      PlateHolder4.mirror = true;
      setRotation(PlateHolder4, 0F, 0F, 0F);
      PlateHolder5 = new ModelRenderer(this, 0, 15);
      PlateHolder5.addBox(0F, 0F, 0F, 2, 2, 3);
      PlateHolder5.setRotationPoint(-6F, 10F, 1F);
      PlateHolder5.setTextureSize(128, 64);
      PlateHolder5.mirror = true;
      setRotation(PlateHolder5, 0F, 0F, 0F);
      PlateHolder6 = new ModelRenderer(this, 0, 15);
      PlateHolder6.addBox(0F, 0F, 0F, 2, 2, 3);
      PlateHolder6.setRotationPoint(-6F, 10F, -4F);
      PlateHolder6.setTextureSize(128, 64);
      PlateHolder6.mirror = true;
      setRotation(PlateHolder6, 0F, 0F, 0F);
      PlateTop = new ModelRenderer(this, 0, 0);
      PlateTop.addBox(0F, 0F, 0F, 8, 2, 8);
      PlateTop.setRotationPoint(-4F, 9F, -4F);
      PlateTop.setTextureSize(128, 64);
      PlateTop.mirror = true;
      setRotation(PlateTop, 0F, 0F, 0F);
      BackPlate = new ModelRenderer(this, 104, 49);
      BackPlate.addBox(0F, 0F, 0F, 8, 13, 2);
      BackPlate.setRotationPoint(-4F, 10F, 5F);
      BackPlate.setTextureSize(128, 64);
      BackPlate.mirror = true;
      setRotation(BackPlate, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, TileEntityMetalPress tile)
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
    Shape9.render(f5);
    HolderLeft.render(f5);
    HolderRight.render(f5);
    
    BasePlate.render(f5);
    
   
    BackPlate.render(f5);
    
    if(tile != null){

    	
    	float Down = (float)tile.GetWorkTime() / 410;

    	TopPlate.offsetY = Down;
    	
    	PlateHolder1.offsetY = Down;
    	PlateHolder2.offsetY = Down;
    	PlateHolder3.offsetY = Down;
    	PlateHolder4.offsetY = Down;
    	PlateHolder5.offsetY = Down;
    	PlateHolder6.offsetY = Down;
    	
    	PlateTop.offsetY = Down;
    	
    	
    }
    
    
    TopPlate.render(f5);
    PlateHolder1.render(f5);
    PlateHolder2.render(f5);
    PlateHolder3.render(f5);
    PlateHolder4.render(f5);
    PlateHolder5.render(f5);
    PlateHolder6.render(f5);
    PlateTop.render(f5);
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
