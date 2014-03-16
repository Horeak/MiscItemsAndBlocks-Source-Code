package com.miscitems.MiscItemsAndBlocks.Economy.Lib;


import com.miscitems.MiscItemsAndBlocks.Economy.Main.Economy;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.ClientPackets.MoneyChangePacket;
import net.minecraft.entity.player.EntityPlayer;

public class MoneyUtils {

    public static String MoneyMark = "$";

    public static int Multiplier = 0;


    public static void SetMoneyForPlayer(EntityPlayer Player, int Amount){

        if(Economy.proxy.MoneyStorage.containsKey(Player)){
            Economy.proxy.MoneyStorage.remove(Player);
        }

       Economy.proxy.MoneyStorage.put(Player, Amount);

        Economy.NETWORK_MANAGER.sendPacketToPlayer(new MoneyChangePacket(Amount), Player);

        System.out.println(Player + " :1");

    }

}
