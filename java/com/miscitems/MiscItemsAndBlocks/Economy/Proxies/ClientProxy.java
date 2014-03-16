package com.miscitems.MiscItemsAndBlocks.Economy.Proxies;


import com.miscitems.MiscItemsAndBlocks.Economy.Tick.ClientTickHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends ServerProxy{


    public void RegisterClientTick(){
        tickHandlerClient = new ClientTickHandler();


    }

}
