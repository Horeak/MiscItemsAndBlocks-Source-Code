package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Utils.DoubleStackUtil;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;

public class RecipeSmeltingPage extends Page  {


    ItemStack Input;

    int CurrentRes = 0;

    int Switch = 0;

    DoubleStackUtil FurnaceItems;

    List<HashMap<ItemStack, ItemStack>> Recipes;


    int GridX = 63;
    int GridY = 65;

    int posX, posY;

    public RecipeSmeltingPage(ItemStack Input){
        this.Input = Input;

        Recipes = BookUtils.GetSmeltingRecipeItems(Input);

        if(Recipes != null && Recipes.size() > 0)
        FurnaceItems = new DoubleStackUtil(Input, Recipes.get(0).get(Input));
    }



    @Override
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.smelting"), posX + 70, posY + 25, 0x949294, false);


        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + GridX, posY + GridY, 118, 2, 71, 56);

        GL11.glDisable(GL11.GL_LIGHTING);

        RenderItem(ItemRender, render, new ItemStack(Items.coal), posX + GridX + 1, posY + GridY + 39);


        this.posX = posX;
        this.posY = posY;


        if (Recipes.size() > 0) {
            if (Recipes.size() > 1) {
                if (Switch >= BookUtils.RecipeChangeTime) {
                    Switch = 0;

                    if (CurrentRes < Recipes.size())
                        CurrentRes += 1;

                    else
                        CurrentRes = 0;

                } else {
                    Switch += 1;
                }

                FurnaceItems = new DoubleStackUtil(Input, Recipes.get(CurrentRes).get(Input));

            }


            if (FurnaceItems != null)
                if (FurnaceItems.GetStack_1() != null && FurnaceItems.GetStack_1().getItem() != null && FurnaceItems.GetStack_2() != null && FurnaceItems.GetStack_2().getItem() != null) {
                    RenderItem(ItemRender, render, FurnaceItems.GetStack_1(), posX + GridX + 1, posY + GridY + 1);
                    RenderItem(ItemRender, render, FurnaceItems.GetStack_2(), posX + GridX + 54, posY + GridY + 19);

                    if (OverSlot(posX + GridX + 1, posY + GridY + 1, MouseX, MouseY) && FurnaceItems.GetStack_1() != null)
                        Page.drawTooltip(GetToolTip(FurnaceItems.GetStack_1()), MouseX, MouseY);

                    if (OverSlot(posX + GridX + 54, posY + GridY + 19, MouseX, MouseY) && FurnaceItems.GetStack_2() != null)
                        Page.drawTooltip((GetToolTipWithoutLink(FurnaceItems.GetStack_2())), MouseX, MouseY);
                }


            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(GL11.GL_LIGHTING);

        }
    }

    public void OnClick(InfoPage page, int ClickedX, int ClickedY){


        if(OverSlot(posX + GridX + 1, posY + GridY + 1, ClickedX, ClickedY) && FurnaceItems.GetStack_1() != null){
            if(BookUtils.GetInfoPagesForItem(FurnaceItems.GetStack_1()) != null)
            FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(FurnaceItems.GetStack_1(), page.LastTab));
        }

        if(OverSlot(posX + GridX + 54, posY + GridY + 19, ClickedX, ClickedY) && FurnaceItems.GetStack_2() != null){
            if(BookUtils.GetInfoPagesForItem(FurnaceItems.GetStack_2()) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(FurnaceItems.GetStack_2(), page.LastTab));
        }
    }
}
