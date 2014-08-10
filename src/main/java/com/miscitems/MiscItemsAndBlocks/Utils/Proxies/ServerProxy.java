package com.miscitems.MiscItemsAndBlocks.Utils.Proxies;

import com.miscitems.MiscItemsAndBlocks.Utils.Tickhandler.ServerTickHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Tickhandler.TickHandlerClient;
import cpw.mods.fml.common.Loader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;

public class ServerProxy{


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





}
