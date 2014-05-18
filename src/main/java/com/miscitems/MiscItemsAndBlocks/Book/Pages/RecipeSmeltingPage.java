package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import MiscItemsApi.Utils.DoubleStackUtil;
import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class RecipeSmeltingPage extends Page  {


    ItemStack Input;
    DoubleStackUtil FurnaceItems;

    public RecipeSmeltingPage(ItemStack Input){
        this.Input = Input;

        FurnaceItems = BookUtils.InfoPageFurnaceRecipes.get(Input.getUnlocalizedName().replace(".name", "").replace("item.", "").replace("tile.", ""));
    }



    @Override
    public void Render(InfoPage Page, FontRenderer render, int posX, int posY, int Side) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.smelting"), posX + 70, posY + 25, 0x949294, false);



        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + 63, posY + 65, 118, 2, 71, 56);

        GL11.glDisable(GL11.GL_LIGHTING);

        RenderItem(new ItemStack(Items.coal), posX + 64, posY + 104);



        if(FurnaceItems != null)
        if(FurnaceItems.GetStack_1() != null && FurnaceItems.GetStack_1().getItem() != null && FurnaceItems.GetStack_2() != null && FurnaceItems.GetStack_2().getItem() != null){
            RenderItem(FurnaceItems.GetStack_1(), posX + 64, posY + 66);
            RenderItem(FurnaceItems.GetStack_2(), posX + 63 + 54, posY + 84);


        }



        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_LIGHTING);

    }
}
