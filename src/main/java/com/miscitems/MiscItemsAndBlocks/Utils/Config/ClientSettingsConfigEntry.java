package com.miscitems.MiscItemsAndBlocks.Utils.Config;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

public class ClientSettingsConfigEntry extends CategoryEntry
{
    public ClientSettingsConfigEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
    {
        super(owningScreen, owningEntryList, prop);
    }

    @Override
    protected GuiScreen buildChildScreen()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        list.addAll((new ConfigElement(Main.config.getCategory("client settings"))).getChildElements());

        return new GuiConfig(this.owningScreen, list, this.owningScreen.modID, "client settings",
                this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                GuiConfig.getAbridgedConfigPath(Main.config.toString()),
                I18n.format("config.el.Client"));
    }
}