package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.ChatProgram;

public class ProgramList {

    public static void RegisterPrograms(){


        ComputerUtils.AddProgram(new ChatProgram());

    }
}
