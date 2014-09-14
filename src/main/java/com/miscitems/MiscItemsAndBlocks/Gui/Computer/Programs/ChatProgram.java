package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs;

import com.miscitems.MiscItemsAndBlocks.Gui.Computer.ComputerProgram;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.GuiComputerScreen;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.ProgramIconInfo;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatRanks;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.PlayerButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatProgram extends ComputerProgram {


    private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ChatGui.png");
    private final ResourceLocation Options = new ResourceLocation("miscitems" , "textures/gui/GuiBlankOutInv.png");


    boolean ConnectWindow = false, PlayerHandleWindow = false;
    ChatChannel CurrentChannel = null;
    EntityPlayer CurrentHandel = null;

    GuiTextField ConnectText;
    GuiTextField ChatText;

    float zLevel = 0;
    public float chatScroll, playerListScroll;
    public boolean chatScrolling, playerScrolling;


    int posX = 0, posY = 0;

    public ChatProgram() {
        super("Chat_ID", "Chat", true, new ProgramIconInfo(new ResourceLocation("miscitems", "textures/gui/ComputerIcons/ComputerIcons.png"), 0, 0, 16, 16));
    }


    public void ConnectToChannel(String Name){
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if(!CurrentChannel.ChannelName.equals(Name)) {
            ChannelUtils.DisconnectFromChannel(CurrentChannel.ChannelId, player);
            ChatChannel channel = ChannelUtils.CreateChannel(Name, player);

            if (ChannelUtils.ConnectToChannel(channel.ChannelId, player))
                CurrentChannel = channel;

        }

    }

    public void MouseClicked(int x, int y, int par3){
            if(ConnectText != null && ConnectWindow && !PlayerHandleWindow)
            ConnectText.mouseClicked(x,y,par3);

            if(ChatText != null && !ConnectWindow && !PlayerHandleWindow)
                ChatText.mouseClicked(x,y,par3);

        boolean isOnChatScroll = x >= posX + 207 && x < posX + 207 + 4 && y >= posY + 34 && y < posY + 109;
        boolean isOnPlayerScroll = x >= posX + 299 && x < posX + 299 + 4 && y >= posY + 34 && y < posY + 109;
        if(isOnChatScroll)
        {
            chatScrolling = true;

        }else if(isOnPlayerScroll)
        {
            playerScrolling = true;
        }


    }

    public boolean KeyTyped(char key, int keycode){

        if(ConnectWindow){
            if(ConnectText != null)
            if(ConnectText.isFocused()){
                ConnectText.textboxKeyTyped(key, keycode);
                return false;
            }

        }



        if(ChatText != null)
            if(ChatText.isFocused()){

                if(keycode == Keyboard.KEY_RETURN){
                    if(CurrentChannel != null){

                        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

                        CurrentChannel.AddMessageFromPlayer(player, ChatText.getText());

                        ChatText.setText("");
                    }
                }else {
                    ChatText.textboxKeyTyped(key, keycode);
                }


                return false;
            }



        return true;

    }


    public void OpenProgram(){

        ChatChannel channel = ChannelUtils.GetChannel("Default");

        if(channel.CanConnectPlayer(Minecraft.getMinecraft().thePlayer)){
            ChannelUtils.ConnectToChannel(channel.ChannelId, Minecraft.getMinecraft().thePlayer);
            CurrentChannel = ChannelUtils.GetChannel("Default");
        }

    }

    public void CloseProgram(){

        if(CurrentChannel != null)
        if(CurrentChannel.IsPlayerConnected(Minecraft.getMinecraft().thePlayer)) {

            ChannelUtils.DisconnectFromChannel(CurrentChannel.ChannelId, Minecraft.getMinecraft().thePlayer);
            CurrentChannel = null;
        }

    }




    public void AddButton(List buttonList, int x, int y){


        GuiButton buttonConnect = new GuiButton(0, x + 33, y + 5, 82, 20, "Connect");
        buttonList.add(buttonConnect);

        buttonConnect.enabled = !ConnectWindow && !PlayerHandleWindow;

        if(ConnectWindow){
         buttonList.add(new GuiButton(1, x + 125, y + 90, 50, 20, "Done"));
         buttonList.add(new GuiButton(2, x + 75, y + 90, 50, 20, "Default"));
        }


        if(PlayerHandleWindow && CurrentHandel != null){


            ChatRanks RankUse = CurrentChannel.GetPlayerRank(Minecraft.getMinecraft().thePlayer);
            ChatRanks RankCheck = CurrentChannel.GetPlayerRank(CurrentHandel);

            int i = 0;

            if(RankUse.Value - 2 >= RankCheck.Value)
                i = 3;

            else if(RankUse.Value - 1 >= RankCheck.Value)
                i = 2;

            else
            i = 1;


            if(i <= 1){

                buttonList.add(new GuiButton(1, x + 96, y + 90, 60, 20, "Done"));

            }else if (i == 2){

                int XBase = 102;

                buttonList.add(new GuiButton(1, x + XBase + 40, y + 90, 40, 20, "Done"));
                buttonList.add(new GuiButton(3, x + XBase, y + 90, 40, 20, "Kick"));
                buttonList.add(new GuiButton(5, x + XBase - 40, y + 90, 40, 20, "Demote"));

            }else if (i == 3){

                int XBase = 105;

                buttonList.add(new GuiButton(1, x + XBase + 40, y + 90, 40, 20, "Done"));
                buttonList.add(new GuiButton(2, x + XBase, y + 90, 40, 20, "Ban"));
                buttonList.add(new GuiButton(3, x + XBase - 40, y + 90, 40, 20, "Kick"));
                buttonList.add(new GuiButton(5, x + XBase + 20, y + 70, 40, 20, "Demote"));
                buttonList.add(new GuiButton(4, x + XBase - 20, y + 70, 40, 20, "Promote"));

            }

        }


        if(!ConnectWindow && !PlayerHandleWindow) {
            List list = addPlayerList(x, y);

            if (list != null && list.size() > 0)
                for (Object r : list) {
                    if (r instanceof GuiButton) {
                        buttonList.add(r);

                    }
                }


        }
    }

    public void ButtonClicked(GuiButton button){

        if(PlayerHandleWindow && CurrentHandel != null){
            int id = button.id;



            //1 = done
            //2 = ban
            //3 = kick
            //4 = promote
            //5 = demote

            if(id == 1){

                PlayerHandleWindow = false;
                CurrentHandel = null;

            }else if (id == 2){
                CurrentChannel.BanPlayer(CurrentHandel);
            }else if (id == 3){
                CurrentChannel.KickPlayer(CurrentHandel);
            }else if(id == 4){


                ChatRanks rank = CurrentChannel.GetPlayerRank(CurrentHandel);

                if(rank.Value == 0)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.Moderator);

                else if(rank.Value == 1)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.Admin);

                else if(rank.Value == 2)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.Owner);


            }else if(id == 5){


                ChatRanks rank = CurrentChannel.GetPlayerRank(CurrentHandel);

                if(rank.Value == 1)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.User);

                else if(rank.Value == 2)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.Moderator);

                else if(rank.Value == 3)
                    CurrentChannel.SetPlayerRank(CurrentHandel, ChatRanks.Admin);


            }
        }

        if(button instanceof PlayerButton && !PlayerHandleWindow){
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            EntityPlayer pl = CurrentChannel.ConnectedPlayers.get(button.id - 3);

          //  if(pl != null && !player.getCommandSenderName().equalsIgnoreCase(pl.getCommandSenderName())){


                CurrentHandel = pl;
                PlayerHandleWindow = true;

            //}

        }

        if(button.enabled) {

            if (button.id == 0) {
                ConnectWindow = true;
            }

            if(button.id == 1) {
                if (ConnectWindow) {
                    if(ConnectText != null && !ConnectText.getText().isEmpty()){
                        ConnectToChannel(ConnectText.getText().replace(" ", "_"));
                        ConnectWindow = false;

                    }
                }
            }

            if(button.id == 2) {
                if (ConnectWindow) {

                        ConnectToChannel("Default");
                        ConnectText.setText("Default");
                        ConnectWindow = false;

                    }

            }

        }
    }


    public void DrawScreen(int xCord, int yCord, int x, int y, float par3){

        if(!ConnectWindow && !PlayerHandleWindow) {
            boolean flag = Mouse.isButtonDown(0);
            if (!flag) {
                chatScrolling = false;
            } else if (chatScrolling) {
                chatScroll = MathHelper.clamp_float((float) ((yCord + 96) - y) / 82F, 0.0F, 0.77F);

            }


            if (!flag) {
                playerScrolling = false;
            } else if (playerScrolling) {

                playerListScroll = MathHelper.clamp_float((float) ((yCord + 96) - y) / 82F, 0.0F, 0.77F);

            }
        }


    }

    @Override
    public void RenderWindow(GuiComputerScreen guiInstance, FontRenderer font, int xCord, int yCord) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        zLevel = guiInstance._zLevel;

        posX = xCord;
        posY = yCord;


        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

        guiInstance.drawTexturedModalRect(xCord + 25,yCord, 0,0, 198, 152 );
        guiInstance.drawTexturedModalRect(xCord + 152 + 72, yCord + 27, 16,164, 86, 90 );

        if(CurrentChannel != null){
            guiInstance.drawCenteredString(font, CurrentChannel.ChannelName, xCord + 71 + 95, yCord + 11, new Color(77, 77, 77).getRGB());
        }


        if(ChatText == null){
            ChatText = new GuiTextField(font, xCord + 25 + 10, yCord + 128, 185, 19);
            ChatText.setMaxStringLength(80);
        }else{
            ChatText.xPosition = xCord + 25 + 7;
            ChatText.yPosition = yCord + 125;
        }

        ChatText.drawTextBox();
            drawChat(guiInstance, xCord, yCord);





        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
        GL11.glTranslatef(0.0F, -82F * playerListScroll, 0.0F);
        guiInstance.drawTexturedModalRect(xCord + 299, yCord + 96, 3, 154, 4, 15);
        GL11.glPopMatrix();

        if(ConnectWindow){
            guiInstance.drawDefaultBackground();


            GL11.glEnable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            Minecraft.getMinecraft().renderEngine.bindTexture(Options);

            guiInstance.drawTexturedModalRect(xCord + 36, yCord + 30, 0,0, 176, 88);

            font.drawString("Connect to channel", xCord + 40, yCord + 33, new Color(61, 61, 61).getRGB());

            font.drawString("Enter channel name", xCord + 50, yCord + 50, new Color(107, 107, 107).getRGB());




            if(ConnectText == null) {
                ConnectText = new GuiTextField(font, xCord + 50, yCord + 60, 145, 20);

                ConnectText.setText(CurrentChannel.ChannelName);
            }else{
                ConnectText.xPosition = xCord + 50;
                ConnectText.yPosition = yCord + 60;
            }


            ConnectText.setMaxStringLength(16);

            ConnectText.drawTextBox();


            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);

        }else if(PlayerHandleWindow){


            guiInstance.drawDefaultBackground();


            GL11.glEnable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            Minecraft.getMinecraft().renderEngine.bindTexture(Options);

            guiInstance.drawTexturedModalRect(xCord + 36, yCord + 30, 0,0, 176, 88);



            if(CurrentHandel != null){

                ChatRanks rank = CurrentChannel.GetPlayerRank(CurrentHandel);

                Color rankColor = rank.color;

                if(rankColor == null)
                    rankColor = new Color(107, 107, 107);

                font.drawString(EnumChatFormatting.DARK_GRAY + "Player: " + EnumChatFormatting.RESET + CurrentHandel.getDisplayName(), xCord + 45, yCord + 41, rankColor.getRGB());
                font.drawString(EnumChatFormatting.DARK_GRAY + "Rank: " + EnumChatFormatting.RESET + rank.Name, xCord + 45, yCord + 50, rankColor.getRGB());

            }


            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);

        }








    }

    @Override
    public ComputerProgram GetInstance() {
        return new ChatProgram();
    }


    /**
     *
     *
     *
     *  The code for drawing chat and player list begins here!
     *
     *
     *
     */



    public void drawSolidRect(int par0, int par1, int par2, int par3, int par4, float alpha)
    {
        float f1 = (float)(par4 >> 16 & 255) / 255.0F;
        float f2 = (float)(par4 >> 8 & 255) / 255.0F;
        float f3 = (float)(par4 & 255) / 255.0F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(f1, f2, f3, alpha);
        tessellator.startDrawingQuads();
        tessellator.addVertex((double)(par0 + 0), (double)(par1 + par3), (double)this.zLevel);
        tessellator.addVertex((double)(par0 + par2), (double)(par1 + par3), (double)this.zLevel);
        tessellator.addVertex((double)(par0 + par2), (double)(par1 + 0), (double)this.zLevel);
        tessellator.addVertex((double)(par0 + 0), (double)(par1 + 0), (double)this.zLevel);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }



    public void drawChat(GuiScreen gui, int x, int y)
    {


        if(CurrentChannel != null) {
            GL11.glEnable(GL11.GL_STENCIL_TEST);
            GL11.glColorMask(false, false, false, false);

            GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 0xFF);
            GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
            GL11.glStencilMask(0xFF);
            GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);

            drawSolidRect(x + 13, y + 34, 200, 78, 0xffffff, 1.0F);

            GL11.glStencilMask(0x00);
            GL11.glStencilFunc(GL11.GL_EQUAL, 1, 0xFF);

            GL11.glColorMask(true, true, true, true);

            GL11.glPushMatrix();
            float scale = 0.5F;

            GL11.glScalef(scale, scale, scale);
            int lines = 0;

            int Split = 322;


            //Getting the amount of lines
            for (int i = 0; i < CurrentChannel.Messages.size(); i++) {
                List<?> list = Minecraft.getMinecraft().fontRenderer.listFormattedStringToWidth(CurrentChannel.Messages.get(i), Split);

                lines += list.size();
            }


            //Translating the Gl11 area with the scroll bar value
            if (lines > 15) {
                GL11.glTranslatef(0.0F, -(lines - 15) * 13.0F * (0.77F - chatScroll), 0.0F);
            }


            lines = 0;


            //Drawing the lines
            for (int i = 0; i < CurrentChannel.Messages.size(); i++) {
                String msg = CurrentChannel.Messages.get(i);

                List<?> list = Minecraft.getMinecraft().fontRenderer.listFormattedStringToWidth(msg, Split);

                for (int kk = 0; kk < list.size(); kk++) {


                    if (kk == 0) {
                        Minecraft.getMinecraft().fontRenderer.drawString(list.get(kk).toString(), (int) ((x + 38) / scale), (int) ((y + 34 + (lines * 5)) / scale), 24737632, false);

                    } else {
                        Minecraft.getMinecraft().fontRenderer.drawString(" " + list.get(kk).toString(), (int) ((x + 38) / scale), (int) ((y + 39 + (lines * 5)) / scale), 24737632, false);
                    }

                }
                if (list.size() > 1)
                    lines++;

                lines++;
            }


            GL11.glDisable(GL11.GL_STENCIL_TEST);

            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if (lines > 15) {

                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
                GL11.glTranslatef(0.0F, -82F * chatScroll, 0.0F);
                gui.drawTexturedModalRect(x + 207, y + 96, 3, 154, 4, 15);
                GL11.glPopMatrix();


            }
        }
    }


    public List addPlayerList(int x, int y)
    {

        if(CurrentChannel != null) {
            GL11.glPushMatrix();

            GL11.glEnable(GL11.GL_STENCIL_TEST);
            GL11.glColorMask(false, false, false, false);

            GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 0xFF);
            GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
            GL11.glStencilMask(0xFF);
            GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);

            drawSolidRect(x + 152 + 80, y + 33, 67, 81, 0xffffff, 1.0F);

            GL11.glStencilMask(0x00);
            GL11.glStencilFunc(GL11.GL_EQUAL, 1, 0xFF);

            GL11.glColorMask(true, true, true, true);

            GL11.glPushMatrix();
            float scale = 0.5F;

            GL11.glScalef(scale, scale, scale);


            int Size = 0;

            if (CurrentChannel != null && CurrentChannel.ConnectedPlayers != null && CurrentChannel.ConnectedPlayers.size() > 0)
                Size = CurrentChannel.ConnectedPlayers.size();


            int lines = Size;

            int xBase = x + 152 + 80;
            int yBase = y + 34;

            List list = new ArrayList();


            //Translating the Gl11 area with the scroll bar value
            if (lines > 15) {
                GL11.glTranslatef(0.0F, -(lines - 15) * 13.0F * (0.77F - playerListScroll), 0.0F);
            }


            lines = 0;


            //Adding player list buttons
            for (int i = 0; i < Size; i++) {

                EntityPlayer player = CurrentChannel.ConnectedPlayers.get(i);
                if (player != null) {


                    PlayerButton button = new PlayerButton(3 + i, ((xBase)), ((yBase + (lines * 5))), player, CurrentChannel);


                    list.add(button);

                }

                lines++;
            }


            GL11.glDisable(GL11.GL_STENCIL_TEST);

            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            GL11.glPopMatrix();


            return list;
        }

        return null;

    }

}

