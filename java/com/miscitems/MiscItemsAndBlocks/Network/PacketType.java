package com.miscitems.MiscItemsAndBlocks.Network;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.*;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.*;

public enum PacketType {
	
	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */

	ClientPacketGameChange(ClientGamePacketChange.class),
	ClientPacketGameInviteRecived(ClientGamePacketInviteRecived.class),
	ClientPacketGameRestart(ClientGamePacketRestart.class),
	ClientGamePacketBegin(ClientGamePacketBegin.class),
	ClientMetalPressPacketUpdate(ClientMetalPressPacketUpdate.class),
	ClinetChatMessageRecivedPacket(ClientChatMessageRecivedPacket.class),
	
	ServerChatMessagePacket(ServerChatMessagePacket.class),
	ServerPaintBrushChangePacket(ServerPaintBrushChangePacket.class),
	ServerButtonPacket(ServerButtonPacket.class),
	ServerGamePacketAccept(ServerGamePacketAccept.class),
	ServerGamePacketChange(ServerGamePacketChange.class),
	ServerGamePacketClosed(ServerGamePacketClosed.class),
	ServerGamePacketInvite(ServerGamePacketInvite.class),
	ServerLensBenchPacketDone(ServerLensBenchPacketDone.class),
	ServerSetBlockPacket(ServerSetBlockPacket.class),
	
	PacketRequestEvent(PacketRequestEvent.class),
	PacketTileUpdate(PacketTileUpdate.class),
	PacketTileWithItemUpdate(PacketTileWithItemUpdate.class);

public Class<? extends IPacket> packetClass;

PacketType(Class<? extends IPacket> packetClass) {
this.packetClass = packetClass;
}

public static byte getIdFromClass(Class<? extends IPacket> packetClass) {
for(PacketType type : values())
if(type.packetClass == packetClass)
return (byte)type.ordinal();
return -1;
}
}