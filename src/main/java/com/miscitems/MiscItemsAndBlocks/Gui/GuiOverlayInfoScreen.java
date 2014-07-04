package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemAntiFallChest;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiOverlayInfoScreen extends GuiIngame{

	public GuiOverlayInfoScreen() {
		super(Minecraft.getMinecraft());
	}

	
	private ResourceLocation texture = new ResourceLocation("miscitems", "textures/gui/GuiOverlayGoggles.png");
	
	
	int yPlus;
	
	@SuppressWarnings("unused")
	@SideOnly(Side.CLIENT)
	public void renderOverlay()
	{
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();
		
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        
        yPlus = 0;
		
		EntityClientPlayerMP player = this.mc.thePlayer;
		
		
		this.mc.renderEngine.bindTexture(this.texture);
		
		if(player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem() ==  ModItems.InfoScreenHelmet){
			if(player.inventory.armorInventory[3].getMaxDamage() - player.inventory.armorInventory[3].getItemDamage() > 0){
		this.drawTexturedModalRect(0, 3 - 7, 0, 0, 159, 80);
		
		
		
		ItemStack armorScreen = player.inventory.armorInventory[3];
		float PowerLeftScreen = armorScreen.getMaxDamage() - armorScreen.getItemDamage();
		int PercentScreen = (int)(PowerLeftScreen / armorScreen.getMaxDamage() * 100);
		String TextScreen = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.screenpower") + ": " + GetColor(PercentScreen) + PercentScreen + "%";
		RenderText(TextScreen, 60, PercentScreen);
		yPlus += 10;
		
		
		if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemAntiFallChest){
		ItemStack armor = player.inventory.armorInventory[2];
		float PowerLeft = armor.getMaxDamage() - armor.getItemDamage();
		int Percent = (int)(PowerLeft / armor.getMaxDamage() * 100);
		String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.antifallpower") + ": " + GetColor(Percent) + Percent + "%";
		RenderText(Text, 62, Percent);
		yPlus += 10;
		
	}
		
		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemPowerTool){
		ItemStack Item = player.inventory.getCurrentItem();
		float PowerLeft = Item.getMaxDamage() - Item.getItemDamage();
		int Percent = (int)(PowerLeft / Item.getMaxDamage() * 100);
		String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.currentitempower") + ": " + GetColor(Percent) + Percent + "%";
		RenderText(Text, 74, Percent);
		yPlus += 10;

		
		}
		
		if(Loader.isModLoaded("IC2"))
		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof IElectricItem){
		ItemStack Item = player.inventory.getCurrentItem();
            IElectricItem item_e = (IElectricItem)Item.getItem();
		int MaxPower = item_e.getMaxCharge(Item);
		float PowerLeft = MaxPower -  ElectricItem.manager.getCharge(Item);
		int Percent = (int)(PowerLeft / MaxPower * 100);
		String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.currentitempower") + ": " + GetColor(Percent) + Percent + "%";
		RenderText(Text, 74, Percent);
		yPlus += 10;


		}
		
		
		}else{
			this.drawTexturedModalRect(0, 3 - 7, 0, 80, 159, 80);
		}
			
		}
		
		
	    GL11.glDisable(GL11.GL_BLEND);
	}
	
	public EnumChatFormatting GetColor(int Percent){
		
		if(Percent > 80){
			return EnumChatFormatting.GREEN;
		}else if (Percent < 81 && Percent > 50){
			return EnumChatFormatting.YELLOW;
		}else if (Percent < 51 && Percent > 25){
			return EnumChatFormatting.GOLD;
		}else if (Percent < 26){
			return EnumChatFormatting.RED;
		}else{
			return EnumChatFormatting.DARK_RED;
		}
	}
	
	public void RenderText(String text, int X, int Percent){
		if(Percent > 9 && Percent < 100){
			this.drawCenteredString(this.mc.fontRenderer, text, X, 10 + yPlus, 0xffffff);
			
		}else if (Percent > 99){
			this.drawCenteredString(this.mc.fontRenderer, text, X + 3, 10 +yPlus , 0xffffff);
		}else{
			this.drawCenteredString(this.mc.fontRenderer, text, X - 3, 10 + yPlus, 0xffffff);
		}
	}
}
