package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ChatMessageHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class ClientGamePacketInviteRecived  extends AbstractPacket {

	String Player;
	
	public ClientGamePacketInviteRecived(){}
	public ClientGamePacketInviteRecived(String Pl){
		Player = Pl;
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {
		Player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {
		ByteBufUtils.writeUTF8String(buf,Player);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {

        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            Main.proxy.tickHandlerClient.tradeReq = Player;
             FMLClientHandler.instance().getClient().theWorld.playSoundEffect((float) FMLClientHandler.instance().getClient().thePlayer.posX, (float) FMLClientHandler.instance().getClient().thePlayer.posY, (float) FMLClientHandler.instance().getClient().thePlayer.posZ, "random.successful_hit", 1.0F, 1.0F);
            ChatMessageHandler.sendChatToPlayer(FMLClientHandler.instance().getClient().thePlayer, EnumChatFormatting.GOLD + "You have recived a game invite to play tic tac toe!");

        }

	}

}
