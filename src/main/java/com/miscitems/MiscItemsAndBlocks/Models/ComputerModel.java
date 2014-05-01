package com.miscitems.MiscItemsAndBlocks.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ComputerModel extends ModelBase {
	// fields
	ModelRenderer Foot1;
	ModelRenderer Foot2;
	ModelRenderer Foot3;
	ModelRenderer Screen;
	ModelRenderer Border1;
	ModelRenderer Border2;
	ModelRenderer Border3;
	ModelRenderer Border4;
	ModelRenderer Keyboard;
	ModelRenderer Mouse;
	ModelRenderer Computer;

	public ComputerModel() {
		textureWidth = 64;
		textureHeight = 32;

		Foot1 = new ModelRenderer(this, 0, 0);
		Foot1.addBox(0F, 0F, 0F, 8, 1, 3);
		Foot1.setRotationPoint(-6F, 23F, -1F);
		Foot1.setTextureSize(64, 32);
		Foot1.mirror = true;
		setRotation(Foot1, 0F, 0F, 0F);
		Foot2 = new ModelRenderer(this, 25, 15);
		Foot2.addBox(0F, 0F, 0F, 2, 8, 1);
		Foot2.setRotationPoint(-3F, 15F, 0F);
		Foot2.setTextureSize(64, 32);
		Foot2.mirror = true;
		setRotation(Foot2, 0F, 0F, 0F);
		Foot3 = new ModelRenderer(this, 0, 5);
		Foot3.addBox(0F, 0F, 0F, 2, 2, 1);
		Foot3.setRotationPoint(-3F, 16F, -1F);
		Foot3.setTextureSize(64, 32);
		Foot3.mirror = true;
		setRotation(Foot3, 0F, 0F, 0F);
		Screen = new ModelRenderer(this, 0, 22);
		Screen.addBox(0F, 0F, 0F, 10, 9, 1);
		Screen.setRotationPoint(-7F, 12F, -2F);
		Screen.setTextureSize(64, 32);
		Screen.mirror = true;
		setRotation(Screen, 0F, 0F, 0F);
		Border1 = new ModelRenderer(this, 0, 11);
		Border1.addBox(0F, 0F, 0F, 10, 1, 2);
		Border1.setRotationPoint(-7F, 11F, -3F);
		Border1.setTextureSize(64, 32);
		Border1.mirror = true;
		setRotation(Border1, 0F, 0F, 0F);
		Border2 = new ModelRenderer(this, 0, 14);
		Border2.addBox(0F, 0F, 0F, 10, 1, 2);
		Border2.setRotationPoint(-7F, 21F, -3F);
		Border2.setTextureSize(64, 32);
		Border2.mirror = true;
		setRotation(Border2, 0F, 0F, 0F);
		Border3 = new ModelRenderer(this, 49, 19);
		Border3.addBox(0F, 0F, 0F, 1, 11, 2);
		Border3.setRotationPoint(-8F, 11F, -3F);
		Border3.setTextureSize(64, 32);
		Border3.mirror = true;
		setRotation(Border3, 0F, 0F, 0F);
		Border4 = new ModelRenderer(this, 56, 19);
		Border4.addBox(0F, 0F, 0F, 1, 11, 2);
		Border4.setRotationPoint(3F, 11F, -3F);
		Border4.setTextureSize(64, 32);
		Border4.mirror = true;
		setRotation(Border4, 0F, 0F, 0F);
		Keyboard = new ModelRenderer(this, 23, 27);
		Keyboard.addBox(0F, 0F, 0F, 9, 1, 4);
		Keyboard.setRotationPoint(-7F, 23F, -7F);
		Keyboard.setTextureSize(64, 32);
		Keyboard.mirror = true;
		setRotation(Keyboard, 0F, 0F, 0F);
		Mouse = new ModelRenderer(this, 33, 18);
		Mouse.addBox(0F, 0F, 0F, 2, 1, 3);
		Mouse.setRotationPoint(4F, 23F, -6F);
		Mouse.setTextureSize(64, 32);
		Mouse.mirror = true;
		setRotation(Mouse, 0F, 0F, 0F);
		Computer = new ModelRenderer(this, 34, 0);
		Computer.addBox(0F, 0F, 0F, 10, 9, 4);
		Computer.setRotationPoint(-7F, 15F, 3F);
		Computer.setTextureSize(64, 32);
		Computer.mirror = true;
		setRotation(Computer, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		Foot1.render(f5);
		Foot2.render(f5);
		Foot3.render(f5);
		Screen.render(f5);
		Border1.render(f5);
		Border2.render(f5);
		Border3.render(f5);
		Border4.render(f5);
		Keyboard.render(f5);
		Mouse.render(f5);
		Computer.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

	}

}
