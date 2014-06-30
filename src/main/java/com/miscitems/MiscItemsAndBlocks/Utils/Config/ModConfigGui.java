package com.miscitems.MiscItemsAndBlocks.Utils.Config;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
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
                Reference.Mod_Id, false, false, GuiConfig.getAbridgedConfigPath(Main.config.toString()));
    }

    //TODO Try to make it change models/blocks and other things (if possible) without restarting the game

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyCategoryElement("client settings", "config.el.Client", ClientSettingsConfigEntry.class));
        list.add(new DummyCategoryElement("server settings", "config.el.Server", ServerSettingsConfigEntry.class));
        list.add(new DummyCategoryElement("blocks", "config.el.Blocks", BlocksSettingsConfigEntry.class));
        list.add(new DummyCategoryElement("items", "config.el.Items", ItemsSettingsConfigEntry.class));
        return list;
    }

    }

