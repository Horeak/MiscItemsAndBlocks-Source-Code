package com.miscitems.MiscItemsAndBlocks.Network.Client;


import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientGhostBlockPacket extends AbstractPacket {
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
    public void fromBytes(ByteBuf buf, Side side) {
        x = buf.readInt();
        y =  buf.readInt();
        z =  buf.readInt();

        ID =  buf.readInt();
        Meta = buf.readInt();

        Player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(ID);
        buf.writeInt(Meta);

        ByteBufUtils.writeUTF8String(buf, Player);
    }

    @Override
    public void onMessage(Side side, EntityPlayer player) {
        World world = Minecraft.getMinecraft().thePlayer.worldObj;

        if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){

            TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);
            tile.Id = ID;
            tile.Meta = Meta;
            tile.Placer = Player;


        }

    }
}
