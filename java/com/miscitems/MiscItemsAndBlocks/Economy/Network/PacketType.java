package com.miscitems.MiscItemsAndBlocks.Economy.Network;

import com.miscitems.MiscItemsAndBlocks.Economy.Network.ClientPackets.*;
//import com.miscitems.MiscItemsAndBlocks.Economy.Network.ServerPackets.*;

public enum PacketType {
	
	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */



    MoneyChangePacket(MoneyChangePacket.class);

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