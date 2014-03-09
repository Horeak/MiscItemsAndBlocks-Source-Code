package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiOverlayInfoScreen;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class GuiListener {
	
	private GuiOverlayInfoScreen overlay;
	
	public GuiListener()
	{
		this.overlay = new GuiOverlayInfoScreen();
	}
	

	@SubscribeEvent 
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		if (event.type == ElementType.TEXT) {
			if (!Minecraft.getMinecraft().playerController.isInCreativeMode()) {
				overlay.renderOverlay();
			}
		} 
		}
	}

