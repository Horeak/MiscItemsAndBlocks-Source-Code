package com.miscitems.MiscItemsAndBlocks.Utils.Proxies;

import com.miscitems.MiscItemsAndBlocks.Network.Client.SyncPlayerPropsPacket;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Magic.MagicInfoStorage;
import com.miscitems.MiscItemsAndBlocks.Utils.Tickhandler.ServerTickHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Tickhandler.TickHandlerClient;
import cpw.mods.fml.common.Loader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerProxy{

	public static ArrayList<EntityPlayer> JoinedPlayers = new ArrayList<EntityPlayer>();

    private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

public static ServerTickHandler tickHandlerServer;
    public static TickHandlerClient tickHandlerClient;


    public void registerRenderThings(){
        
    }

    public EntityPlayer getPlayer(){return null;}
    
    
    public int addArmor(String armor){
        return 0;
    }


    public void RegisterServerTickhandler(){
        tickHandlerServer = new ServerTickHandler();

    }

    public void RegisterClientTickhandler(){
    }
	
	public void RegisterListeners(){
		
		
	}

    	
	
	public String getMinecraftVersion() {
return Loader.instance().getMinecraftModContainer().getVersion();
}



public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

}

public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

}

public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, Item itemID, int metaData, int stackSize, int color) {

}



    public void registerRenderers() {
	// Nothing here as the server doesn't render graphics or entities!
	}


	public void registerSoundHandler() {
		
	}


    public static void storeEntityData(String name, NBTTagCompound compound)
    {
        extendedEntityData.put(name, compound);
    }

    public static NBTTagCompound getEntityData(String name)
    {
        return extendedEntityData.remove(name);
    }



    private static final String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + MagicInfoStorage.EXT_PROP_NAME;
    }

    public static void saveProxyData(EntityPlayer player) {
        MagicInfoStorage playerData = MagicInfoStorage.get(player);
        NBTTagCompound savedData = new NBTTagCompound();

        playerData.saveNBTData(savedData);
        ServerProxy.storeEntityData(getSaveKey(player), savedData);
    }


    public static final void loadProxyData(EntityPlayer player) {
        MagicInfoStorage playerData = MagicInfoStorage.get(player);
        NBTTagCompound savedData = ServerProxy.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }

        PacketHandler.sendToPlayer(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
    }


}
