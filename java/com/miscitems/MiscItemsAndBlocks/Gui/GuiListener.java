package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;

public class GuiListener {
	
	private GuiOverlayInfoScreen overlay;
	
	public GuiListener()
	{
		this.overlay = new GuiOverlayInfoScreen();
	}
	

@EventHandler
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		if (event.type == ElementType.TEXT) {
			if (!event.isCancelable() && !Minecraft.getMinecraft().playerController.isInCreativeMode()) {
				overlay.renderOverlay();
			}
		} 
		}
	}

