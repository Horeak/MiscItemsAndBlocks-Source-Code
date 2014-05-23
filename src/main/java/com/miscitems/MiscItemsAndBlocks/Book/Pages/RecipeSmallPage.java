package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeSmallPage extends Page{

   ItemStack RecipeItem;
   List RecipeItems;

    int GridX = 60;
    int GridY = 65;

    int posX, posY;

    public RecipeSmallPage(ItemStack Output){
        RecipeItem = Output;

        RecipeItems = BookUtils.InfoPageShapelessRecipes.get(RecipeItem.getItem().getUnlocalizedName(RecipeItem).replace(".name", "")).recipeItems;
    }


    @Override
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY) {
            render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);

            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
            Page.drawTexturedModalRect(posX + GridX, posY + GridY, 3, 0, 81, 34);

        this.posX = posX;
        this.posY = posY;


        GL11.glDisable(GL11.GL_LIGHTING);

            for(int i = 0; i < 4; i++){
                    if(RecipeItems.size() > i)
                    RenderItem(ItemRender, render, (ItemStack)RecipeItems.get(i), posX + GridX + (i == 1 || i == 3 ? 18 : 0), posY + GridY + (i > 1 ? 18 : 0));
            }

        if(OverSlot(posX + GridX, posY + GridY, MouseX, MouseY) && ((ItemStack)RecipeItems.get(0)) != null) {
            drawTooltip(render, GetToolTip(((ItemStack) RecipeItems.get(0))), MouseX, MouseY);
        }


        if(RecipeItems.size() > 1)
        if(OverSlot(posX + GridX + 18, posY + GridY, MouseX, MouseY) && ((ItemStack)RecipeItems.get(1)) != null)
            drawTooltip(render, GetToolTip(((ItemStack) RecipeItems.get(1))), MouseX, MouseY);


        if(RecipeItems.size() > 2)
        if(OverSlot(posX + GridX, posY + GridY + 18, MouseX, MouseY) && ((ItemStack)RecipeItems.get(2)) != null)
            drawTooltip(render, GetToolTip(((ItemStack) RecipeItems.get(2))), MouseX, MouseY);


        if(RecipeItems.size() > 3)
        if(OverSlot(posX + GridX + 18, posY + GridY + 18, MouseX, MouseY) && ((ItemStack)RecipeItems.get(3)) != null)
            drawTooltip(render, GetToolTip(((ItemStack) RecipeItems.get(3))), MouseX, MouseY);


        if(OverSlot(posX + GridX + 63, posY + GridY + 9, MouseX, MouseY) && RecipeItem != null)
            drawTooltip(render, Arrays.asList(new String[]{RecipeItem.getDisplayName()}), MouseX, MouseY);


         RenderItem(ItemRender, render, RecipeItem, posX + GridX + 63, posY + GridY + 9);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_LIGHTING);

   }


    public void OnClick(InfoPage page, int ClickedX, int ClickedY){



        if(OverSlot(posX + GridX, posY + GridY, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(0)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(0))) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(((ItemStack)RecipeItems.get(0)), page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(1)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(1))) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(((ItemStack)RecipeItems.get(1)), page.LastTab));
        }

        if(OverSlot(posX + GridX, posY + GridY + 18, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(2)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(2))) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(((ItemStack)RecipeItems.get(2)), page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY + 18, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(3)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(3))) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(((ItemStack)RecipeItems.get(3)), page.LastTab));
        }


        if(OverSlot(posX + GridX, posY + GridY, ClickedX, ClickedY) && RecipeItem != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItem) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItem, page.LastTab));
        }

    }
}

