package com.miscitems.MiscItemsAndBlocks.Network.Client;


import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiGame_1;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ClientGamePacketBegin extends AbstractPacket {

	
	public String Player1;
    public String Player2;
	
	public ClientGamePacketBegin(){}
	public ClientGamePacketBegin(String pl1, String pl2){
		Player1 = pl1;
		Player2 = pl2;
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {
		Player1 = ByteBufUtils.readUTF8String(buf);
		Player2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {
		ByteBufUtils.writeUTF8String(buf,Player1);
        ByteBufUtils.writeUTF8String(buf,Player2);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
        if (side == Side.CLIENT) {
            if(FMLClientHandler.instance().getClient().currentScreen != null)
            FMLClientHandler.instance().getClient().displayGuiScreen(new GuiGame_1(Player1, Player2));
            Main.proxy.tickHandlerClient.tradeReq = null;
        }


	}


}
