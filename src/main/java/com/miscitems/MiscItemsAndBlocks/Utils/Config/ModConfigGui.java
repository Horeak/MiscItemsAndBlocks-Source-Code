package com.miscitems.MiscItemsAndBlocks.Utils.Config;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class ModConfigGui extends GuiConfig {
    public ModConfigGui(GuiScreen parent) {
        super(parent,
                getConfigElements(),
                Reference.Mod_Id, false, false, GuiConfig.getAbridgedConfigPath(ConfigUtils.GetConfigFile().toString()));
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyCategoryElement(ConfigUtils.CATEGORY_CLIENT_SETTINGS.toLowerCase(), "config.el.Client", ClientSettingsConfigEntry.class));
        list.add(new DummyCategoryElement(ConfigUtils.CATEGORY_SERVER_SETTINGS.toLowerCase(), "config.el.Server", ServerSettingsConfigEntry.class));
        list.add(new DummyCategoryElement(ConfigUtils.CATEGORY_BLOCKS.toLowerCase(), "config.el.Blocks", BlocksSettingsConfigEntry.class));
        list.add(new DummyCategoryElement(ConfigUtils.CATEGORY_ITEMS.toLowerCase(), "config.el.Items", ItemsSettingsConfigEntry.class));
        return list;
    }

    }

