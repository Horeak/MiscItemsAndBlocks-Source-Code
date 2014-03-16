package com.miscitems.MiscItemsAndBlocks.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTurtle extends ModelBase
{
	//limbs
    ModelRenderer FrontRightLeg;
    ModelRenderer Tummy;
    ModelRenderer BackRightLeg;
    ModelRenderer BackLeftLet;
    ModelRenderer FrontLeftLeg;
    ModelRenderer MiddleShell;
    ModelRenderer MidTopShell;
    ModelRenderer TopShell;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Tail;
    
  public ModelTurtle()
  {
	  textureWidth = 32;
	    textureHeight = 32;
	    
	    FrontRightLeg = new ModelRenderer(this, 0, 30);
	      FrontRightLeg.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
	      FrontRightLeg.setRotationPoint(-2F, 23F, -2F);
	      FrontRightLeg.setTextureSize(64, 32);
	      FrontRightLeg.mirror = true;
	      setRotation(FrontRightLeg, 0F, 0F, 0F);
	      Tummy = new ModelRenderer(this, 0, 23);
	      Tummy.addBox(-2.5F, 0F, -2F, 4, 1, 5);
	      Tummy.setRotationPoint(0F, 22F, 0F);
	      Tummy.setTextureSize(64, 32);
	      Tummy.mirror = true;
	      setRotation(Tummy, 0F, 0F, 0F);
	      BackRightLeg = new ModelRenderer(this, 0, 30);
	      BackRightLeg.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
	      BackRightLeg.setRotationPoint(-2F, 23F, 3F);
	      BackRightLeg.setTextureSize(64, 32);
	      BackRightLeg.mirror = true;
	      setRotation(BackRightLeg, 0F, 0F, 0F);
	      BackLeftLet = new ModelRenderer(this, 0, 30);
	      BackLeftLet.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
	      BackLeftLet.setRotationPoint(1F, 23F, 3F);
	      BackLeftLet.setTextureSize(64, 32);
	      BackLeftLet.mirror = true;
	      setRotation(BackLeftLet, 0F, 0F, 0F);
	      FrontLeftLeg = new ModelRenderer(this, 0, 30);
	      FrontLeftLeg.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
	      FrontLeftLeg.setRotationPoint(1F, 23F, -2F);
	      FrontLeftLeg.setTextureSize(64, 32);
	      FrontLeftLeg.mirror = true;
	      setRotation(FrontLeftLeg, 0F, 0F, 0F);
	      MiddleShell = new ModelRenderer(this, 0, 15);
	      MiddleShell.addBox(-2.5F, 0F, -3F, 5, 1, 6);
	      MiddleShell.setRotationPoint(-0.5F, 21.5F, 0.5F);
	      MiddleShell.setTextureSize(64, 32);
	      MiddleShell.mirror = true;
	      setRotation(MiddleShell, 0F, 0F, 0F);
	      MidTopShell = new ModelRenderer(this, 0, 8);
	      MidTopShell.addBox(-2F, 0F, -2.5F, 4, 1, 5);
	      MidTopShell.setRotationPoint(-0.5F, 21F, 0.5F);
	      MidTopShell.setTextureSize(64, 32);
	      MidTopShell.mirror = true;
	      setRotation(MidTopShell, 0F, 0F, 0F);
	      TopShell = new ModelRenderer(this, 0, 2);
	      TopShell.addBox(-1.5F, 0F, -2F, 3, 1, 4);
	      TopShell.setRotationPoint(-0.5F, 20.5F, 0.5F);
	      TopShell.setTextureSize(64, 32);
	      TopShell.mirror = true;
	      setRotation(TopShell, 0F, 0F, 0F);
	      Neck = new ModelRenderer(this, 15, 2);
	      Neck.addBox(-0.5F, -0.5F, -3F, 1, 1, 3);
	      Neck.setRotationPoint(-0.5F, 22.5F, -1F);
	      Neck.setTextureSize(64, 32);
	      Neck.mirror = true;
	      setRotation(Neck, 0F, 0F, 0F);
	      Head = new ModelRenderer(this, 19, 9);
	      Head.addBox(-1F, -1F, -2F, 2, 2, 2);
	      Head.setRotationPoint(-0.5F, 22.5F, -3.5F);
	      Head.setTextureSize(64, 32);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      Tail = new ModelRenderer(this, 17, 3);
	      Tail.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
	      Tail.setRotationPoint(-0.5F, 22F, 3F);
	      Tail.setTextureSize(32, 32);
	      Tail.mirror = true;
	      setRotation(Tail, 0.7853982F, 0F, 0F);
	  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    FrontRightLeg.render(f5);
    Tummy.render(f5);
    BackRightLeg.render(f5);
    BackLeftLet.render(f5);
    FrontLeftLeg.render(f5);
    MiddleShell.render(f5);
    MidTopShell.render(f5);
    TopShell.render(f5);
    Neck.render(f5);
    Head.render(f5);
    Tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.FrontRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.FrontLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.BackLeftLet.rotateAngleZ = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.BackRightLeg.rotateAngleZ = - MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.Tail.rotateAngleZ = - MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}