package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;


import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientGhostBlockPacket implements IMessage, IMessageHandler<ClientGhostBlockPacket, IMessage> {
    int x, y, z, ID, Meta;
    String Player;

    public ClientGhostBlockPacket(){}
    public ClientGhostBlockPacket(int x, int y, int z, int ID, int Meta, String Player){
        this.x = x;
        this.y = y;
        this.z = z;

        this.ID = ID;
        this.Meta = Meta;
        this.Player = Player;

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y =  buf.readInt();
        z =  buf.readInt();

        ID =  buf.readInt();
        Meta = buf.readInt();

        Player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(ID);
        buf.writeInt(Meta);

        ByteBufUtils.writeUTF8String(buf, Player);
    }

    @Override
      public IMessage onMessage(ClientGhostBlockPacket message, MessageContext ctx) {
        World world = Minecraft.getMinecraft().thePlayer.worldObj;

        if(world.getTileEntity(message.x, message.y, message.z) instanceof TileEntityGhostBlock){

            TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(message.x, message.y, message.z);
            tile.Id = message.ID;
            tile.Meta = message.Meta;
            tile.Placer = message.Player;


        }


        return null;
    }
}
