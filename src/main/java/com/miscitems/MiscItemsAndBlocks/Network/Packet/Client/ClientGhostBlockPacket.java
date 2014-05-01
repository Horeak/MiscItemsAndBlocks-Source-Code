package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;


import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientGhostBlockPacket extends IPacket {
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
    public void read(DataInputStream data) throws IOException {
        x = data.readInt();
        y =  data.readInt();
        z =  data.readInt();

        ID =  data.readInt();
        Meta = data.readInt();

        Player = data.readUTF();
    }

    @Override
    public void write(DataOutputStream data) throws IOException {

        data.writeInt(x);
        data.writeInt(y);
        data.writeInt(z);

        data.writeInt(ID);
        data.writeInt(Meta);

        data.writeUTF(Player);
    }

    @Override
    public void execute(EntityPlayer player) {


        World world = player.getEntityWorld();

        if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){

            TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);
            tile.Id = ID;
            tile.Meta = Meta;
            tile.Placer = Player;


        }


    }
}
