package com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI.CustomRecipes.InfusionRecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI.CustomRecipes.MillRecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI.CustomRecipes.SqueezerRecipeHandler;

public class NEIConfig implements IConfigureNEI{
    @Override
    public void loadConfig() {


        //TODO Finish rest of nei registration (Metal Press)

        API.registerRecipeHandler(new InfusionRecipeHandler());
        API.registerRecipeHandler(new MillRecipeHandler());
        API.registerRecipeHandler(new SqueezerRecipeHandler());

        API.registerUsageHandler(new InfusionRecipeHandler());
        API.registerUsageHandler(new MillRecipeHandler());
        API.registerUsageHandler(new SqueezerRecipeHandler());
    }

    @Override
    public String getName() {
        return "MiscItemsAndBlocks NEI";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }
}
