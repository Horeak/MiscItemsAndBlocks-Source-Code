package BookCode_mantle;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * Mantle
 *
 * Central mod object for Mantle
 *
 * @author Sunstrike <sun@sunstrike.io>
 */

@Mod(modid = CoreRepo.modId, name = CoreRepo.modName, version = CoreRepo.modVersion, dependencies = "required-after:Forge")

public class Mantle
{
    /**
     *
     * Temporary use of Mantle for adding the guide book until i have time to make my own.
     * - tm1990
     *
     */


    /* Instance of this mod, used for grabbing prototype fields */
    @Instance("MiscItemsMantle")
    public static Mantle instance;
    /* Proxies for sides, used for graphics processing */
    @SidedProxy(clientSide = "BookCode_mantle.client.MProxyClient", serverSide = "BookCode_mantle.MProxyCommon")
    public static MProxyCommon proxy;


    

    /**
     * FML preinitialisation handler
     *
     * This is where we load our configs and related data, preparing for main load.
     *
     * @param evt The FMLPreInitializationEvent from FML
     */
    @EventHandler
    public void preInit (FMLPreInitializationEvent evt)
    {


        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);

    }

    /**
     * FML preinitialisation handler
     *
     * This is where we handle basic loading and populating any missing data in the Repo
     *
     * @param evt The FMLInitializationEvent from FML
     */
    @EventHandler
    public void Init (FMLInitializationEvent evt)
    {
    	CoreRepo.logger.info("Entering initialization phase.");
        proxy.registerRenderer();

    }

    /**
     * FML preinitialisation handler
     *
     * Final chance for cleanup before main game launch
     *
     * @param evt The FMLPostInitializationEvent from FML
     */
    @EventHandler
    public void postInit (FMLPostInitializationEvent evt)
    {
    	CoreRepo.logger.info("Entering postinitialization phase.");
        proxy.readManuals();
    }

}
