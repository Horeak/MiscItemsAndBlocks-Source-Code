package com.miscitems.MiscItemsAndBlocks.Gui.Overlayes;

import MiscItemsApi.Electric.IPowerItem;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
			if(((ModItemElArmor)player.inventory.armorInventory[3].getItem()).CurrentPower(player.inventory.armorInventory[3]) > 0){
		this.drawTexturedModalRect(0, 3 - 7, 0, 0, 159, 80);
		
		
		
		ItemStack armorScreen = player.inventory.armorInventory[3];
        ModItemElArmor item = (ModItemElArmor)armorScreen.getItem();
		int PercentScreen = (int)(item.CurrentPower(armorScreen) / item.MaxPower(armorScreen) * 100);
		String TextScreen = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.screenpower") + ": " + GetColor(PercentScreen) + PercentScreen + "%";
		RenderText(TextScreen);
		
		
		if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemElArmor){
            ItemStack armor = player.inventory.armorInventory[2];
            ModItemElArmor item1 = (ModItemElArmor)armor.getItem();
            int Percent = (int)(item1.CurrentPower(armor) / item1.MaxPower(armor) * 100);
		String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.chestplatepower") + ": " + GetColor(Percent) + Percent + "%";
		RenderText(Text);
	}


                if(Loader.isModLoaded("IC2")) {
                    if (player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof IPowerItem &&  !(player.inventory.armorInventory[2].getItem() instanceof IPowerItem)) {
                        ItemStack stack = player.inventory.armorInventory[2];
                        IPowerItem item1 = (IPowerItem) stack.getItem();
                        int Percent = (int) (item1.CurrentPower(stack) / item1.MaxPower(stack) * 100);
                        String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.chestplatepower") + ": " + GetColor(Percent) + Percent + "%";
                        RenderText(Text);
                    }


                    if (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem() instanceof IPowerItem &&  !(player.inventory.armorInventory[1].getItem() instanceof IPowerItem)) {
                        ItemStack stack = player.inventory.armorInventory[1];
                        IPowerItem item1 = (IPowerItem) stack.getItem();
                        int Percent = (int) (item1.CurrentPower(stack) / item1.MaxPower(stack) * 100);
                        String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.leggingspower") + ": " + GetColor(Percent) + Percent + "%";
                        RenderText(Text);
                    }


                    if (player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem() instanceof IPowerItem &&  !(player.inventory.armorInventory[0].getItem() instanceof IPowerItem)) {
                        ItemStack stack = player.inventory.armorInventory[0];
                        IPowerItem item1 = (IPowerItem) stack.getItem();
                        int Percent = (int) (item1.CurrentPower(stack) / item1.MaxPower(stack) * 100);
                        String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.bootspower") + ": " + GetColor(Percent) + Percent + "%";
                        RenderText(Text);
                    }



                    if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof IPowerItem &&  !(player.inventory.getCurrentItem().getItem() instanceof IPowerItem)) {
                        ItemStack Item = player.inventory.getCurrentItem();
                        IPowerItem item_e = (IPowerItem) Item.getItem();
                        int Percent = (int) (item_e.CurrentPower(Item) / item_e.MaxPower(Item) * 100);
                        String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.currentitempower") + ": " + GetColor(Percent) + Percent + "%";
                        RenderText(Text);
                    }

                }
		
		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemPowerTool){
		ItemStack Item = player.inventory.getCurrentItem();
        ModItemPowerTool itm = (ModItemPowerTool)Item.getItem();
		int Percent = (int)(itm.CurrentPower(Item) / itm.MaxPower(Item) * 100);
		String Text = EnumChatFormatting.GOLD + StatCollector.translateToLocal("gui.string.currentitempower") + ": " + GetColor(Percent) + Percent + "%";
		RenderText(Text);
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
	
	public void RenderText(String text){

        int x = 15;
        int yStart = 8;


			this.drawString(this.mc.fontRenderer, text, x, yStart + yPlus, 0xffffff);


        yPlus += 12;
	}
}
