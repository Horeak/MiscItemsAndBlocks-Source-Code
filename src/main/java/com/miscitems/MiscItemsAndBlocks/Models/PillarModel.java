package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PillarModel extends ModelBase
{
  //fields
  ModelRenderer Bottom1;
    ModelRenderer Bottom2;
    ModelRenderer Bottom3;
    ModelRenderer Bottom4;
    ModelRenderer Bottom5;
    ModelRenderer Bottom6;
    ModelRenderer Bottom7;
    ModelRenderer Bottom8;
    ModelRenderer Bottom9;
    ModelRenderer Bottom10;
    ModelRenderer Middle;
    ModelRenderer Middle1;
    ModelRenderer Middle2;
    ModelRenderer Middle3;
    ModelRenderer Middle4;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top3;
    ModelRenderer Top4;
    ModelRenderer Top5;
    ModelRenderer Top6;
    ModelRenderer Top8;
    ModelRenderer Top9;
    ModelRenderer Top10;
    ModelRenderer Top11;
  
  public PillarModel()
  {
    textureWidth = 64;
    textureHeight = 32;
      textureWidth = 64;
      textureHeight = 32;

      Bottom1 = new ModelRenderer(this, 0, 0);
      Bottom1.addBox(0F, 0F, 0F, 6, 1, 1);
      Bottom1.setRotationPoint(-3F, 23F, -6F);
      Bottom1.setTextureSize(64, 32);
      Bottom1.mirror = true;
      setRotation(Bottom1, 0F, 0F, 0F);
      Bottom2 = new ModelRenderer(this, 0, 0);
      Bottom2.addBox(0F, 0F, 0F, 6, 1, 1);
      Bottom2.setRotationPoint(-3F, 23F, 5F);
      Bottom2.setTextureSize(64, 32);
      Bottom2.mirror = true;
      setRotation(Bottom2, 0F, 0F, 0F);
      Bottom3 = new ModelRenderer(this, 0, 0);
      Bottom3.addBox(0F, 0F, 0F, 1, 1, 6);
      Bottom3.setRotationPoint(5F, 23F, -3F);
      Bottom3.setTextureSize(64, 32);
      Bottom3.mirror = true;
      setRotation(Bottom3, 0F, 0F, 0F);
      Bottom4 = new ModelRenderer(this, 0, 0);
      Bottom4.addBox(0F, 0F, 0F, 1, 1, 6);
      Bottom4.setRotationPoint(-6F, 23F, -3F);
      Bottom4.setTextureSize(64, 32);
      Bottom4.mirror = true;
      setRotation(Bottom4, 0F, 0F, 0F);
      Bottom5 = new ModelRenderer(this, 0, 0);
      Bottom5.addBox(0F, 0F, 0F, 10, 1, 10);
      Bottom5.setRotationPoint(-5F, 23F, -5F);
      Bottom5.setTextureSize(64, 32);
      Bottom5.mirror = true;
      setRotation(Bottom5, 0F, 0F, 0F);
      Bottom6 = new ModelRenderer(this, 0, 0);
      Bottom6.addBox(0F, 0F, 0F, 8, 1, 8);
      Bottom6.setRotationPoint(-4F, 22F, -4F);
      Bottom6.setTextureSize(64, 32);
      Bottom6.mirror = true;
      setRotation(Bottom6, 0F, 0F, 0F);
      Bottom7 = new ModelRenderer(this, 0, 0);
      Bottom7.addBox(0F, 0F, 0F, 1, 1, 8);
      Bottom7.setRotationPoint(4F, 22F, -4F);
      Bottom7.setTextureSize(64, 32);
      Bottom7.mirror = true;
      setRotation(Bottom7, 0F, 0F, 0F);
      Bottom8 = new ModelRenderer(this, 0, 0);
      Bottom8.addBox(0F, 0F, 0F, 1, 1, 8);
      Bottom8.setRotationPoint(-5F, 22F, -4F);
      Bottom8.setTextureSize(64, 32);
      Bottom8.mirror = true;
      setRotation(Bottom8, 0F, 0F, 0F);
      Bottom9 = new ModelRenderer(this, 0, 0);
      Bottom9.addBox(0F, 0F, 0F, 8, 1, 1);
      Bottom9.setRotationPoint(-4F, 22F, -5F);
      Bottom9.setTextureSize(64, 32);
      Bottom9.mirror = true;
      setRotation(Bottom9, 0F, 0F, 0F);
      Bottom10 = new ModelRenderer(this, 0, 0);
      Bottom10.addBox(0F, 0F, 0F, 8, 1, 1);
      Bottom10.setRotationPoint(-4F, 22F, 4F);
      Bottom10.setTextureSize(64, 32);
      Bottom10.mirror = true;
      setRotation(Bottom10, 0F, 0F, 0F);
      Middle = new ModelRenderer(this, 0, 0);
      Middle.addBox(0F, 0F, 0F, 6, 12, 6);
      Middle.setRotationPoint(-3F, 10F, -3F);
      Middle.setTextureSize(64, 32);
      Middle.mirror = true;
      setRotation(Middle, 0F, 0F, 0F);
      Middle1 = new ModelRenderer(this, 0, 0);
      Middle1.addBox(0F, 0F, 0F, 1, 12, 4);
      Middle1.setRotationPoint(-4F, 10F, -2F);
      Middle1.setTextureSize(64, 32);
      Middle1.mirror = true;
      setRotation(Middle1, 0F, 0F, 0F);
      Middle2 = new ModelRenderer(this, 0, 0);
      Middle2.addBox(0F, 0F, 0F, 4, 12, 1);
      Middle2.setRotationPoint(-2F, 10F, -4F);
      Middle2.setTextureSize(64, 32);
      Middle2.mirror = true;
      setRotation(Middle2, 0F, 0F, 0F);
      Middle3 = new ModelRenderer(this, 0, 0);
      Middle3.addBox(0F, 0F, 0F, 1, 12, 4);
      Middle3.setRotationPoint(3F, 10F, -2F);
      Middle3.setTextureSize(64, 32);
      Middle3.mirror = true;
      setRotation(Middle3, 0F, 0F, 0F);
      Middle4 = new ModelRenderer(this, 0, 0);
      Middle4.addBox(0F, 0F, 0F, 4, 12, 1);
      Middle4.setRotationPoint(-2F, 10F, 3F);
      Middle4.setTextureSize(64, 32);
      Middle4.mirror = true;
      setRotation(Middle4, 0F, 0F, 0F);
      Top1 = new ModelRenderer(this, 0, 0);
      Top1.addBox(0F, 0F, 0F, 10, 1, 10);
      Top1.setRotationPoint(-5F, 8F, -5F);
      Top1.setTextureSize(64, 32);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 0, 0);
      Top2.addBox(0F, 0F, 0F, 8, 1, 8);
      Top2.setRotationPoint(-4F, 9F, -4F);
      Top2.setTextureSize(64, 32);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Top3 = new ModelRenderer(this, 0, 0);
      Top3.addBox(0F, 0F, 0F, 8, 1, 1);
      Top3.setRotationPoint(-4F, 9F, -5F);
      Top3.setTextureSize(64, 32);
      Top3.mirror = true;
      setRotation(Top3, 0F, 0F, 0F);
      Top4 = new ModelRenderer(this, 0, 0);
      Top4.addBox(0F, 0F, 0F, 1, 1, 8);
      Top4.setRotationPoint(-5F, 9F, -4F);
      Top4.setTextureSize(64, 32);
      Top4.mirror = true;
      setRotation(Top4, 0F, 0F, 0F);
      Top5 = new ModelRenderer(this, 0, 0);
      Top5.addBox(0F, 0F, 0F, 8, 1, 1);
      Top5.setRotationPoint(-4F, 9F, 4F);
      Top5.setTextureSize(64, 32);
      Top5.mirror = true;
      setRotation(Top5, 0F, 0F, 0F);
      Top6 = new ModelRenderer(this, 0, 0);
      Top6.addBox(0F, 0F, 0F, 1, 1, 8);
      Top6.setRotationPoint(4F, 9F, -4F);
      Top6.setTextureSize(64, 32);
      Top6.mirror = true;
      setRotation(Top6, 0F, 0F, 0F);
      Top8 = new ModelRenderer(this, 0, 0);
      Top8.addBox(0F, 0F, 0F, 1, 1, 6);
      Top8.setRotationPoint(5F, 8F, -3F);
      Top8.setTextureSize(64, 32);
      Top8.mirror = true;
      setRotation(Top8, 0F, 0F, 0F);
      Top9 = new ModelRenderer(this, 0, 0);
      Top9.addBox(0F, 0F, 0F, 6, 1, 1);
      Top9.setRotationPoint(-3F, 8F, 5F);
      Top9.setTextureSize(64, 32);
      Top9.mirror = true;
      setRotation(Top9, 0F, 0F, 0F);
      Top10 = new ModelRenderer(this, 0, 0);
      Top10.addBox(0F, 0F, 0F, 1, 1, 6);
      Top10.setRotationPoint(-6F, 8F, -3F);
      Top10.setTextureSize(64, 32);
      Top10.mirror = true;
      setRotation(Top10, 0F, 0F, 0F);
      Top11 = new ModelRenderer(this, 0, 0);
      Top11.addBox(0F, 0F, 0F, 6, 1, 1);
      Top11.setRotationPoint(-3F, 8F, -6F);
      Top11.setTextureSize(64, 32);
      Top11.mirror = true;
      setRotation(Top11, 0F, 0F, 0F);
  }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean Top, Boolean Bottom)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if(!Bottom) {
            Bottom1.render(f5);
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

            int Size = 16;
            int MinHig = 4;



            Middle = new ModelRenderer(this, 0, 0);
            Middle.addBox(0F, 0F, 0F, 6, Size, 6);
            Middle.setRotationPoint(-3F, 10F - MinHig, -3F);

            Middle1 = new ModelRenderer(this, 0, 0);
            Middle1.addBox(0F, 0F, 0F, 1, Size, 4);
            Middle1.setRotationPoint(-4F, 10F - MinHig, -2F);

            Middle2 = new ModelRenderer(this, 0, 0);
            Middle2.addBox(0F, 0F, 0F, 4, Size, 1);
            Middle2.setRotationPoint(-2F, 10F - MinHig, -4F);


            Middle3 = new ModelRenderer(this, 0, 0);
            Middle3.addBox(0F, 0F, 0F, 1, Size, 4);
            Middle3.setRotationPoint(3F, 10F - MinHig, -2F);

            Middle4 = new ModelRenderer(this, 0, 0);
            Middle4.addBox(0F, 0F, 0F, 4, Size, 1);
            Middle4.setRotationPoint(-2F, 10F - MinHig, 3F);




        }else{



            Middle = new ModelRenderer(this, 0, 0);
            Middle.addBox(0F, 0F, 0F, 6, 12, 6);
            Middle.setRotationPoint(-3F, 10F, -3F);
            Middle.setTextureSize(64, 32);
            Middle.mirror = true;
            setRotation(Middle, 0F, 0F, 0F);
            Middle1 = new ModelRenderer(this, 0, 0);
            Middle1.addBox(0F, 0F, 0F, 1, 12, 4);
            Middle1.setRotationPoint(-4F, 10F, -2F);
            Middle1.setTextureSize(64, 32);
            Middle1.mirror = true;
            setRotation(Middle1, 0F, 0F, 0F);
            Middle2 = new ModelRenderer(this, 0, 0);
            Middle2.addBox(0F, 0F, 0F, 4, 12, 1);
            Middle2.setRotationPoint(-2F, 10F, -4F);
            Middle2.setTextureSize(64, 32);
            Middle2.mirror = true;
            setRotation(Middle2, 0F, 0F, 0F);
            Middle3 = new ModelRenderer(this, 0, 0);
            Middle3.addBox(0F, 0F, 0F, 1, 12, 4);
            Middle3.setRotationPoint(3F, 10F, -2F);
            Middle3.setTextureSize(64, 32);
            Middle3.mirror = true;
            setRotation(Middle3, 0F, 0F, 0F);
            Middle4 = new ModelRenderer(this, 0, 0);
            Middle4.addBox(0F, 0F, 0F, 4, 12, 1);
            Middle4.setRotationPoint(-2F, 10F, 3F);
            Middle4.setTextureSize(64, 32);
            Middle4.mirror = true;
            setRotation(Middle4, 0F, 0F, 0F);
        }

        Middle.render(f5);
        Middle1.render(f5);
        Middle2.render(f5);
        Middle3.render(f5);
        Middle4.render(f5);

        if(!Top) {
            Top1.render(f5);
            Top2.render(f5);
            Top3.render(f5);
            Top4.render(f5);
            Top5.render(f5);
            Top6.render(f5);
            Top8.render(f5);
            Top9.render(f5);
            Top10.render(f5);
            Top11.render(f5);
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