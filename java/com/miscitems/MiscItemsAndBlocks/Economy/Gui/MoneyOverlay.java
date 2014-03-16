package com.miscitems.MiscItemsAndBlocks.Economy.Gui;

import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyUtils;
import com.miscitems.MiscItemsAndBlocks.Economy.Main.Economy;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiOverlayInfoScreen;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemAntiFallChest;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class MoneyOverlay extends GuiIngame {

    MoneyOverlay Instance = this;

    public MoneyOverlay() {
        super(Minecraft.getMinecraft());
    }




    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            if (!Minecraft.getMinecraft().playerController.isInCreativeMode()) {
                Instance.renderOverlay();
            }
        }
    }



    @SideOnly(Side.CLIENT)
    public void renderOverlay()
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);

        EntityClientPlayerMP player = this.mc.thePlayer;

        int Money = Economy.proxy.tickHandlerClient.Money;


        String Pre = MoneyUtils.MoneyMark;

        if(Money < 10000){
            if(Money < 1000){
                if(Money < 100){
                    if(Money < 10){
                        this.drawCenteredString(this.mc.fontRenderer, Pre +"0000" + Money, width - 30, 15, 0xffffff);

                    }else{
                        this.drawCenteredString(this.mc.fontRenderer, Pre +"000" + Money, width - 30, 15, 0xffffff);
                    }

                }else{
                    this.drawCenteredString(this.mc.fontRenderer, Pre + "00" + Money, width - 30, 15, 0xffffff);
                }
            }else{
                this.drawCenteredString(this.mc.fontRenderer, Pre + "0" + Money, width - 30, 15, 0xffffff);
            }

        }else{
            this.drawCenteredString(this.mc.fontRenderer, Pre + Money, width - 30, 15, 0xffffff);
        }





        GL11.glDisable(GL11.GL_BLEND);
    }
}

