package com.miscitems.MiscItemsAndBlocks.Network;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientChatMessageRecivedPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketBegin;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketInviteRecived;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketRestart;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientMetalPressPacketUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerButtonPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerChatMessagePacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerGamePacketAccept;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerGamePacketClosed;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerGamePacketInvite;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerPaintBrushChangePacket;

public enum PacketType {

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