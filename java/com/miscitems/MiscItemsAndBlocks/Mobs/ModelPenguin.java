package com.miscitems.MiscItemsAndBlocks.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPenguin extends ModelBase
{
	//limbs
    ModelRenderer body;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;
    ModelRenderer tummy;
    ModelRenderer head;
    ModelRenderer righteye;
    ModelRenderer lefteye;
    ModelRenderer nose;
    ModelRenderer leftarm;
    ModelRenderer rightarm;
    
  public ModelPenguin()
  {
	  textureWidth = 64;
	    textureHeight = 32;
	    
	      body = new ModelRenderer(this, 13, 12);
	      body.addBox(-3.5F, -4.5F, -2F, 7, 10, 4);
	      body.setRotationPoint(0F, 17.5F, 0F);
	      body.setTextureSize(64, 32);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      rightleg = new ModelRenderer(this, 15, 27);
	      rightleg.addBox(-1F, 0F, -3F, 2, 1, 4);
	      rightleg.setRotationPoint(-2F, 23F, -1F);
	      rightleg.setTextureSize(64, 32);
	      rightleg.mirror = true;
	      setRotation(rightleg, 0F, 0F, 0F);
	      leftleg = new ModelRenderer(this, 15, 27);
	      leftleg.addBox(-1F, 0F, -3F, 2, 1, 4);
	      leftleg.setRotationPoint(2F, 23F, -1F);
	      leftleg.setTextureSize(64, 32);
	      leftleg.mirror = true;
	      setRotation(leftleg, 0F, 0F, 0F);
	      tail = new ModelRenderer(this, 49, 7);
	      tail.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
	      tail.setRotationPoint(0F, 22F, 1F);
	      tail.setTextureSize(64, 32);
	      tail.mirror = true;
	      setRotation(tail, 0.9773844F, 0F, 0F);
	      tummy = new ModelRenderer(this, 7, 0);
	      tummy.addBox(-2.5F, -3.5F, -0.5F, 5, 8, 1);
	      tummy.setRotationPoint(0F, 17.5F, -2F);
	      tummy.setTextureSize(64, 32);
	      tummy.mirror = true;
	      setRotation(tummy, 0F, 0F, 0F);
	      head = new ModelRenderer(this, 39, 1);
	      head.addBox(-3F, -6F, -3F, 6, 6, 6);
	      head.setRotationPoint(0F, 13F, 0F);
	      head.setTextureSize(64, 32);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      righteye = new ModelRenderer(this, 22, 2);
	      righteye.addBox(-0.5F, -0.5F, -1F, 1, 1, 1);
	      righteye.setRotationPoint(-1.5F, 9F, -2.3F);
	      righteye.setTextureSize(64, 32);
	      righteye.mirror = true;
	      setRotation(righteye, 0F, 0F, 0F);
	      lefteye = new ModelRenderer(this, 31, 2);
	      lefteye.addBox(-0.5F, -0.5F, -1F, 1, 1, 1);
	      lefteye.setRotationPoint(1.5F, 9F, -2.3F);
	      lefteye.setTextureSize(64, 32);
	      lefteye.mirror = true;
	      setRotation(lefteye, 0F, 0F, 0F);
	      nose = new ModelRenderer(this, 27, 5);
	      nose.addBox(-0.5F, 0F, -1F, 1, 2, 1);
	      nose.setRotationPoint(0F, 10F, -1.5F);
	      nose.setTextureSize(64, 32);
	      nose.mirror = true;
	      setRotation(nose, -0.7807508F, 0F, 0F);
	      leftarm = new ModelRenderer(this, 5, 15);
	      leftarm.addBox(-0.5F, 0F, -1F, 1, 5, 2);
	      leftarm.setRotationPoint(3.7F, 14F, 0F);
	      leftarm.setTextureSize(64, 32);
	      leftarm.mirror = true;
	      setRotation(leftarm, 0F, 0F, -0.2230717F);
	      rightarm = new ModelRenderer(this, 37, 16);
	      rightarm.addBox(-0.5F, 0F, -1F, 1, 5, 2);
	      rightarm.setRotationPoint(-3.7F, 14F, 0F);
	      rightarm.setTextureSize(64, 32);
	      rightarm.mirror = true;
	      setRotation(rightarm, 0F, 0F, 0.2230705F);
	  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    tail.render(f5);
    tummy.render(f5);
    head.render(f5);
    righteye.render(f5);
    lefteye.render(f5);
    nose.render(f5);
    leftarm.render(f5);
    rightarm.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
   // this.lefteye.rotateAngleX = this.head.rotateAngleX;
   // this.lefteye.rotateAngleY = this.head.rotateAngleY;
   // this.righteye.rotateAngleX = this.head.rotateAngleX;
   // this.righteye.rotateAngleY = this.head.rotateAngleY;
      this.nose.rotateAngleX = this.head.rotateAngleX;
      this.nose.rotateAngleY = this.head.rotateAngleY;
   // this.body.rotateAngleX = ((float)Math.PI / 2F);
      this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.rightarm.rotateAngleZ = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.leftarm.rotateAngleZ = - MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.tail.rotateAngleZ = - MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}