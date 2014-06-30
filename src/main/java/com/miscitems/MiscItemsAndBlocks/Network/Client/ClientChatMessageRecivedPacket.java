package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiChat;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ClientChatMessageRecivedPacket  extends AbstractPacket {

	
	String Line;
	
	public ClientChatMessageRecivedPacket(){}
	
	
	public ClientChatMessageRecivedPacket(String Line){
		
		this.Line = Line;
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {
		
		Line = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

        ByteBufUtils.writeUTF8String(buf,Line);
		
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {

		String fullLine1 = Line;

        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            if (FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat) {
                GuiChat gui = (GuiChat) FMLClientHandler.instance().getClient().currentScreen;
                gui.ReciveChatMessage(fullLine1);
            }
        }

	}


}
