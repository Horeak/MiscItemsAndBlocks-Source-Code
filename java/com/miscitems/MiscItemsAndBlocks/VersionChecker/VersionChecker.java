package com.miscitems.MiscItemsAndBlocks.VersionChecker;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.MinecraftForge;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class VersionChecker implements Runnable{

private static VersionChecker instance = new VersionChecker();

private static final String remoteFileLocation = "https://dl.dropboxusercontent.com/s/vctok5s6njcyekp/version.xml";
private static final String remoteChangesLocation = "https://dl.dropboxusercontent.com/s/8m52pfa8ea293vq/changes.xml";
public static Properties remoteVersionProperties = new Properties();
public static Properties remoteChangesProperties = new Properties();

public static final byte NOT_DONE = 0;
public static final byte UP_TO_DATE = 1;
public static final byte OUT_OF_DATE = 2;
public static final byte FAILED = 3;

private static byte result = NOT_DONE;
public static String remoteVersion = null;
public static String remoteUpdateLocation = null;

public static void checkVersion(){
InputStream remoteVersionStream = null;
result = NOT_DONE;

try{
URL remoteVersionURL = new URL(remoteFileLocation);
remoteVersionStream = remoteVersionURL.openStream();
remoteVersionProperties.loadFromXML(remoteVersionStream);
String versionFromRemote = remoteVersionProperties.getProperty(Loader.instance().getMCVersionString());

if(versionFromRemote != null)
remoteVersion =versionFromRemote;
if(remoteVersion != null){
Main.LATEST_VERSION = remoteVersion;

if(remoteVersion.equalsIgnoreCase(Main.RELEASE_VERSION))
result = UP_TO_DATE;
else
result = OUT_OF_DATE;

}
else{
result = FAILED;
}

}catch (Exception e){
e.printStackTrace();
}
finally{
if(result == NOT_DONE)
result = FAILED;
try{
if(remoteVersionStream != null)
remoteVersionStream.close();
}catch(Exception ex){}
}

}

public static void checkLatestChanges(){
InputStream remoteChangesStream = null;

try{
URL remoteChangesURL = new URL(remoteChangesLocation);
remoteChangesStream = remoteChangesURL.openStream();
remoteChangesProperties.loadFromXML(remoteChangesStream);
String changesFromRemote = remoteChangesProperties.getProperty(Main.LATEST_VERSION);
if(changesFromRemote != null){
System.out.println(Refrence.Mod_Id + " Latest Changes: " +changesFromRemote);
Main.LATEST_CHANGES = changesFromRemote;
}
}catch(Exception ex){
ex.printStackTrace();
}finally{
try{
if(remoteChangesStream != null)
remoteChangesStream.close();
}catch(Exception ex){}
}

}

@Override
public void run() {
int tries = 0;
System.out.println(Refrence.Mod_Id + ": Starting version check.");

try{
while(tries < 5 && (result != OUT_OF_DATE && result != UP_TO_DATE)){
	System.out.println(tries > 0  ? Refrence.Mod_Id + ":  version check try : " + tries : "");
checkVersion();
tries++;
if(result == OUT_OF_DATE){
Main.UP_TO_DATE = false;
checkLatestChanges();
    FMLCommonHandler.instance().bus().register(VersionCheckTicker.class);
}
if(result == UP_TO_DATE)
System.out.println(Refrence.Mod_Id + ":  is up to date.");
}
}catch(Exception ex){
ex.printStackTrace();
System.out.println(Refrence.Mod_Id + ": Error while checking version. Check your internet connection and try again.");
}
}

public static void go(){
new Thread(instance).start();
}

}