package com.miscitems.MiscItemsAndBlocks.Economy.Network.ClientPackets;

import com.miscitems.MiscItemsAndBlocks.Economy.Main.Economy;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.IPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MoneyChangePacket extends IPacket{

    int Amount;

    public MoneyChangePacket(){}
    public MoneyChangePacket(int Amount){
        this.Amount = Amount;

    }

    @Override
    public void read(DataInputStream data) throws IOException {

        Amount = data.readInt();
    }

    @Override
    public void write(DataOutputStream data) throws IOException {

        data.writeInt(Amount);
    }

    @Override
    public void execute(EntityPlayer player) {

            Economy.proxy.tickHandlerClient.Money = Amount;

        System.out.println(player + " :2");


    }
}
