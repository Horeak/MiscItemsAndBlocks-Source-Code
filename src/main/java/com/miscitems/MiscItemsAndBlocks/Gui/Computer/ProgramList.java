package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.GuiChatProgram;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;

public class ProgramList {

    public static void RegisterPrograms(){


        ComputerUtils.AddProgram(new GuiChatProgram());

        ChannelUtils.AddChannel("Default", "Default", false);
    }
}
