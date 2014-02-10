package com.miscitems.MiscItemsAndBlocks.VersionChecker;

import java.util.EnumSet;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.client.FMLClientHandler;

public class VersionCheckTicker implements ITickHandler {

private boolean init = true;

@Override
public void tickStart(EnumSet<tickType> type, Object... tickData) {

}

@Override
public void tickEnd(EnumSet<tickType> type, Object... tickData) {
if(init){
for(tickType tickType: type){
if(tickType == tickType.CLIENT){
if(FMLClientHandler.instance().getClient().currentScreen == null){
init = false;
if(!Main.UP_TO_DATE){
	Main.UpdateMessage = StatCollector.translateToLocal("string.versioncheck.newversion").replace("%EnumRed", EnumChatFormatting.RED + "").replace("%EnumYellow", EnumChatFormatting.YELLOW + "").replace("%EnumBlue", EnumChatFormatting.BLUE + "").replace("%EnumGold", EnumChatFormatting.GOLD + "").replace("%ModName", Refrence.Mod_Name).replace("%NewVersion", Main.LATEST_VERSION).replace("%DowLink", Main.UPDATE_URL).replace("%Changes", Main.LATEST_CHANGES);
FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(Main.UpdateMessage);

}

}
}
}
}
}

@Override
public EnumSet<tickType> ticks() {
return EnumSet.of(tickType.CLIENT);
}

@Override
public String getLabel() {
return Refrence.Mod_Id + ": " +this.getClass().getSimpleName();
}

}