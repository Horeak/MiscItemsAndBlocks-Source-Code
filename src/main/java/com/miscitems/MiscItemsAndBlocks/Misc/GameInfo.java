package com.miscitems.MiscItemsAndBlocks.Misc;

import com.miscitems.MiscItemsAndBlocks.Lib.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketBegin;
import net.minecraft.entity.player.EntityPlayer;

public class GameInfo
{

        public final EntityPlayer Player_1;
        public final EntityPlayer Player_2;

        
        public boolean terminate;
        
        public GameInfo(EntityPlayer t1, EntityPlayer t2)
        {
        	Player_1 = t1;
        	Player_2 = t2;
        }
        
        public GameInfo initialize()
        {


        	Main.NETWORK_MANAGER.sendPacketToPlayer(new ClientGamePacketBegin(Player_1.getCommandSenderName(), Player_2.getCommandSenderName()), Player_1);
        	Main.NETWORK_MANAGER.sendPacketToPlayer(new ClientGamePacketBegin(Player_1.getCommandSenderName(), Player_2.getCommandSenderName()), Player_2);
        
        return this;
        }
        
        public void terminate(EntityPlayer terminator)
        {
        	terminate = true;
        	ChatMessageHandler.sendChatToPlayer(Player_1, "Game was closed.");
        	ChatMessageHandler.sendChatToPlayer(Player_2, "Game was closed.");
        	
        }
    
     
        public EntityPlayer getOtherPlayer(EntityPlayer player)
        {
                return player == Player_1 ? Player_2 : Player_1;
        }
        
        public boolean isPlayerInGame(EntityPlayer player)
        {
                return Player_1 == player || Player_2 == player;
        }

   
}