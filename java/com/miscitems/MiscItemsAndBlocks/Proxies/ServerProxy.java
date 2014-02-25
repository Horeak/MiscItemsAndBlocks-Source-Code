package com.miscitems.MiscItemsAndBlocks.Proxies;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Tick.ServerTickHandler;
import com.miscitems.MiscItemsAndBlocks.Tick.TickHandlerClient;

import cpw.mods.fml.common.Loader;

public class ServerProxy{

	
    public static TickHandlerClient tickHandlerClient;
    public static ServerTickHandler tickHandlerServer;
	
    public void registerRenderThings(){
        
    }
    
    
    public int addArmor(String armor){
        return 0;
    }
    
	public void registerServerTickHandler()
	 {
		
        tickHandlerServer = new ServerTickHandler();
        MinecraftForge.EVENT_BUS.register(tickHandlerServer);
	 }

	
	public void RegisterListeners(){
		
		
	}

	public void registerClientTickHandler() {

		
		
		
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





}
