package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemDye;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GamePartModel extends ModelBase
{
	  //fields
	    ModelRenderer Bottom_1;
	    ModelRenderer Bottom2;
	    ModelRenderer Bottom3;
	    ModelRenderer Bottom4;
	    ModelRenderer Bottom5;
	    ModelRenderer Bottom6;
	    ModelRenderer Shape7;
	    ModelRenderer Bottom7;
	    ModelRenderer Bottom8;
	    ModelRenderer Bottom9;
	    ModelRenderer Bottom10;
	    ModelRenderer Top1;
	    ModelRenderer Top2;
	    ModelRenderer Top3;
	    ModelRenderer Top4;
	    ModelRenderer Top5;
	    ModelRenderer Top6;
	    ModelRenderer Top7;
	    ModelRenderer Top8;
	    ModelRenderer Top9;
	    ModelRenderer Top10;
	    ModelRenderer Shape20;
	    ModelRenderer Shape21;
	    ModelRenderer Shape22;
	    ModelRenderer Shape23;
	  
	  public GamePartModel()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Bottom_1 = new ModelRenderer(this, 0, 0);
	      Bottom_1.addBox(0F, 0F, 0F, 6, 1, 12);
	      Bottom_1.setRotationPoint(-3F, 23F, -6F);
	      Bottom_1.setTextureSize(64, 32);
	      Bottom_1.mirror = true;
	      setRotation(Bottom_1, 0F, 0F, 0F);
	      Bottom2 = new ModelRenderer(this, 0, 0);
	      Bottom2.addBox(0F, 0F, 0F, 12, 1, 6);
	      Bottom2.setRotationPoint(-6F, 23F, -3F);
	      Bottom2.setTextureSize(64, 32);
	      Bottom2.mirror = true;
	      setRotation(Bottom2, 0F, 0F, 0F);
	      Bottom3 = new ModelRenderer(this, 0, 0);
	      Bottom3.addBox(0F, 0F, 0F, 2, 1, 2);
	      Bottom3.setRotationPoint(3F, 23F, 3F);
	      Bottom3.setTextureSize(64, 32);
	      Bottom3.mirror = true;
	      setRotation(Bottom3, 0F, 0F, 0F);
	      Bottom4 = new ModelRenderer(this, 0, 0);
	      Bottom4.addBox(0F, 0F, 0F, 2, 1, 2);
	      Bottom4.setRotationPoint(-5F, 23F, 3F);
	      Bottom4.setTextureSize(64, 32);
	      Bottom4.mirror = true;
	      setRotation(Bottom4, 0F, 0F, 0F);
	      Bottom5 = new ModelRenderer(this, 0, 0);
	      Bottom5.addBox(0F, 0F, 0F, 2, 1, 2);
	      Bottom5.setRotationPoint(3F, 23F, -5F);
	      Bottom5.setTextureSize(64, 32);
	      Bottom5.mirror = true;
	      setRotation(Bottom5, 0F, 0F, 0F);
	      Bottom6 = new ModelRenderer(this, 0, 0);
	      Bottom6.addBox(0F, 0F, 0F, 2, 1, 2);
	      Bottom6.setRotationPoint(-5F, 23F, -5F);
	      Bottom6.setTextureSize(64, 32);
	      Bottom6.mirror = true;
	      setRotation(Bottom6, 0F, 0F, 0F);
	      Shape7 = new ModelRenderer(this, 0, 0);
	      Shape7.addBox(0F, 0F, 0F, 6, 16, 6);
	      Shape7.setRotationPoint(-3F, 8F, -3F);
	      Shape7.setTextureSize(64, 32);
	      Shape7.mirror = true;
	      setRotation(Shape7, 0F, 0F, 0F);
	      Bottom7 = new ModelRenderer(this, 0, 0);
	      Bottom7.addBox(0F, 0F, 0F, 8, 1, 2);
	      Bottom7.setRotationPoint(-4F, 22F, 3F);
	      Bottom7.setTextureSize(64, 32);
	      Bottom7.mirror = true;
	      setRotation(Bottom7, 0F, 0F, 0F);
	      Bottom8 = new ModelRenderer(this, 0, 0);
	      Bottom8.addBox(0F, 0F, 0F, 2, 1, 8);
	      Bottom8.setRotationPoint(-5F, 22F, -4F);
	      Bottom8.setTextureSize(64, 32);
	      Bottom8.mirror = true;
	      setRotation(Bottom8, 0F, 0F, 0F);
	      Bottom9 = new ModelRenderer(this, 0, 0);
	      Bottom9.addBox(0F, 0F, 0F, 8, 1, 2);
	      Bottom9.setRotationPoint(-4F, 22F, -5F);
	      Bottom9.setTextureSize(64, 32);
	      Bottom9.mirror = true;
	      setRotation(Bottom9, 0F, 0F, 0F);
	      Bottom10 = new ModelRenderer(this, 0, 0);
	      Bottom10.addBox(0F, 0F, 0F, 2, 1, 8);
	      Bottom10.setRotationPoint(3F, 22F, -4F);
	      Bottom10.setTextureSize(64, 32);
	      Bottom10.mirror = true;
	      setRotation(Bottom10, 0F, 0F, 0F);
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
	      Top3 = new ModelRenderer(this, 0, 0);
	      Top3.addBox(0F, 0F, 0F, 2, 1, 2);
	      Top3.setRotationPoint(3F, 8F, 3F);
	      Top3.setTextureSize(64, 32);
	      Top3.mirror = true;
	      setRotation(Top3, 0F, 0F, 0F);
	      Top4 = new ModelRenderer(this, 0, 0);
	      Top4.addBox(0F, 0F, 0F, 2, 1, 2);
	      Top4.setRotationPoint(3F, 8F, -5F);
	      Top4.setTextureSize(64, 32);
	      Top4.mirror = true;
	      setRotation(Top4, 0F, 0F, 0F);
	      Top5 = new ModelRenderer(this, 0, 0);
	      Top5.addBox(0F, 0F, 0F, 2, 1, 2);
	      Top5.setRotationPoint(-5F, 8F, -5F);
	      Top5.setTextureSize(64, 32);
	      Top5.mirror = true;
	      setRotation(Top5, 0F, 0F, 0F);
	      Top6 = new ModelRenderer(this, 0, 0);
	      Top6.addBox(0F, 0F, 0F, 2, 1, 2);
	      Top6.setRotationPoint(-5F, 8F, 3F);
	      Top6.setTextureSize(64, 32);
	      Top6.mirror = true;
	      setRotation(Top6, 0F, 0F, 0F);
	      Top7 = new ModelRenderer(this, 0, 0);
	      Top7.addBox(0F, 0F, 0F, 8, 1, 2);
	      Top7.setRotationPoint(-4F, 9F, -5F);
	      Top7.setTextureSize(64, 32);
	      Top7.mirror = true;
	      setRotation(Top7, 0F, 0F, 0F);
	      Top8 = new ModelRenderer(this, 0, 0);
	      Top8.addBox(0F, 0F, 0F, 2, 1, 8);
	      Top8.setRotationPoint(-5F, 9F, -4F);
	      Top8.setTextureSize(64, 32);
	      Top8.mirror = true;
	      setRotation(Top8, 0F, 0F, 0F);
	      Top9 = new ModelRenderer(this, 0, 0);
	      Top9.addBox(0F, 0F, 0F, 8, 1, 2);
	      Top9.setRotationPoint(-4F, 9F, 3F);
	      Top9.setTextureSize(64, 32);
	      Top9.mirror = true;
	      setRotation(Top9, 0F, 0F, 0F);
	      Top10 = new ModelRenderer(this, 0, 0);
	      Top10.addBox(0F, 0F, 0F, 2, 1, 8);
	      Top10.setRotationPoint(3F, 9F, -4F);
	      Top10.setTextureSize(64, 32);
	      Top10.mirror = true;
	      setRotation(Top10, 0F, 0F, 0F);
	      Shape20 = new ModelRenderer(this, 0, 0);
	      Shape20.addBox(0F, 0F, 0F, 4, 16, 1);
	      Shape20.setRotationPoint(-2F, 8F, 3F);
	      Shape20.setTextureSize(64, 32);
	      Shape20.mirror = true;
	      setRotation(Shape20, 0F, 0F, 0F);
	      Shape21 = new ModelRenderer(this, 0, 0);
	      Shape21.addBox(0F, 0F, 0F, 1, 16, 4);
	      Shape21.setRotationPoint(3F, 8F, -2F);
	      Shape21.setTextureSize(64, 32);
	      Shape21.mirror = true;
	      setRotation(Shape21, 0F, 0F, 0F);
	      Shape22 = new ModelRenderer(this, 0, 0);
	      Shape22.addBox(0F, 0F, 0F, 4, 16, 1);
	      Shape22.setRotationPoint(-2F, 8F, -4F);
	      Shape22.setTextureSize(64, 32);
	      Shape22.mirror = true;
	      setRotation(Shape22, 0F, 0F, 0F);
	      Shape23 = new ModelRenderer(this, 0, 0);
	      Shape23.addBox(0F, 0F, 0F, 1, 16, 4);
	      Shape23.setRotationPoint(-4F, 8F, -2F);
	      Shape23.setTextureSize(64, 32);
	      Shape23.mirror = true;
	      setRotation(Shape23, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean Top, boolean Bottom, int Meta)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);

          Color c = new Color(ItemDye.field_150922_c[15 - Meta]);
          float Red = (float)c.getRed() / (float)255, Green = (float)c.getGreen() / (float)255, Blue = (float)c.getBlue() / (float)255;
          GL11.glColor4f(Red, Green, Blue, 1F);
	    
	    
	    if(Bottom){
	    Bottom_1.render(f5);
	    Bottom2.render(f5);
	    Bottom3.render(f5);
	    Bottom4.render(f5);
	    Bottom5.render(f5);
	    Bottom6.render(f5);
	    Bottom7.render(f5);
	    Bottom8.render(f5);
	    Bottom9.render(f5);
	    Bottom10.render(f5);
	    }
	    if(Top){
	    Top1.render(f5);
	    Top2.render(f5);
	    Top3.render(f5);
	    Top4.render(f5);
	    Top5.render(f5);
	    Top6.render(f5);
	    Top7.render(f5);
	    Top8.render(f5);
	    Top9.render(f5);
	    Top10.render(f5);
	    }
	    Shape7.render(f5);
	    Shape20.render(f5);
	    Shape21.render(f5);
	    Shape22.render(f5);
	    Shape23.render(f5);

          GL11.glColor4f(1F, 1F, 1F, 1F);
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

