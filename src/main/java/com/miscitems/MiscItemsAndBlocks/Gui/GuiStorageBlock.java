package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Container.Utils.ModGuiContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityStorageBlock;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Iterator;
import java.util.List;

public class GuiStorageBlock extends ModGuiContainer {


	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/StorageBlockGui.png");
	
	    String username;
	    boolean isScrolling = false;
	    boolean wasClicking;
	    float currentScroll = 0.0F;
	    int slotPos = 0;
	    int prevSlotPos = 0;
	    
	    
	    TileEntityStorageBlock tile;
	    
		public GuiStorageBlock(InventoryPlayer InvPlayer, TileEntityStorageBlock tile) {
			super(new ContainerStorageBlock(InvPlayer, tile));
			this.xSize = 176;
			this.ySize = 235;
			
			this.tile = tile;
	        username = InvPlayer.player.getCommandSenderName();
			
	     
		}


	    @Override
	    public void drawScreen (int mouseX, int mouseY, float par3)
	    {
	        super.drawScreen(mouseX, mouseY, par3);
	        updateScrollbar(mouseX, mouseY, par3);
	    }

	    protected void updateScrollbar (int mouseX, int mouseY, float par3)
	    {
	        if (tile.getSizeInventory() > 64)
	        {
	            boolean mouseDown = Mouse.isButtonDown(0);
	            int lefto = this.guiLeft;
	            int topo = this.guiTop;
	            int xScroll = lefto + 157;
	            int yScroll = topo + 6;
	            int scrollWidth = xScroll + 14;
	            int scrollHeight = yScroll + 144;

	            if (!this.wasClicking && mouseDown && mouseX >= xScroll && mouseY >= yScroll && mouseX < scrollWidth && mouseY < scrollHeight)
	            {
	                this.isScrolling = true;
	            }

	            if (!mouseDown)
	            {
	                this.isScrolling = false;
	            }

	            if (wasClicking && !isScrolling && slotPos != prevSlotPos)
	            {
	                prevSlotPos = slotPos;
	            }

	            this.wasClicking = mouseDown;

	            if (this.isScrolling)
	            {
	                this.currentScroll = (mouseY - yScroll - 7.5F) / (scrollHeight - yScroll - 15.0F);

	                if (this.currentScroll < 0.0F)
	                {
	                    this.currentScroll = 0.0F;
	                }

	                if (this.currentScroll > 1.0F)
	                {
	                    this.currentScroll = 1.0F;
	                }

	                int s = ((ContainerStorageBlock) this.container).scrollTo(this.currentScroll);
	                if (s != -1)
	                    slotPos = s;
	            }
	        }
	    }
	    

	    @Override
	    protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY)
	    {

	        int base = 0;
	        int cornerX = (width - xSize) / 2;
	        int cornerY = (height - ySize) / 2;


	    }


	    @Override
	    protected void drawGuiContainerBackgroundLayer (float f, int mouseX, int mouseY)
	    {
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(Texture);
	        int cornerX = (width - xSize) / 2;
	        int cornerY = (height - ySize) / 2;
	        drawTexturedModalRect(cornerX, cornerY, 0, 0, 176, ySize);

	            
	            drawTexturedModalRect(cornerX + 157, (int) (cornerY + 6 + 127 * currentScroll), 176, 0, 12, 15);
	        

	
	    }

	  
	    protected void drawToolTip (List par1List, int par2, int par3)
	    {
	        if (!par1List.isEmpty())
	        {
	            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	            RenderHelper.disableStandardItemLighting();
	            GL11.glDisable(GL11.GL_LIGHTING);
	            GL11.glDisable(GL11.GL_DEPTH_TEST);
	            int k = 0;
	            Iterator iterator = par1List.iterator();

	            while (iterator.hasNext())
	            {
	                String s = (String) iterator.next();
	                int l = this.fontRendererObj.getStringWidth(s);

	                if (l > k)
	                {
	                    k = l;
	                }
	            }

	            int i1 = par2 + 12;
	            int j1 = par3 - 12;
	            int k1 = 8;

	            if (par1List.size() > 1)
	            {
	                k1 += 2 + (par1List.size() - 1) * 10;
	            }

	            if (i1 + k > this.width)
	            {
	                i1 -= 28 + k;
	            }

	            if (j1 + k1 + 6 > this.height)
	            {
	                j1 = this.height - k1 - 6;
	            }

	            this.zLevel = 300.0F;
	            itemRenderer.zLevel = 300.0F;
	            int l1 = -267386864;
	            this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
	            this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
	            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
	            this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
	            this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
	            int i2 = 1347420415;
	            int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
	            this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
	            this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
	            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
	            this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

	            for (int k2 = 0; k2 < par1List.size(); ++k2)
	            {
	                String s1 = (String) par1List.get(k2);
	                this.fontRendererObj.drawStringWithShadow(s1, i1, j1, -1);

	                if (k2 == 0)
	                {
	                    j1 += 2;
	                }

	                j1 += 10;
	            }

	            this.zLevel = 0.0F;
	            itemRenderer.zLevel = 0.0F;
	        }
	    }





	}
