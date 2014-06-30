package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import java.util.HashMap;

public class ComputerUtils {

    private static HashMap<ComputerProgram, Boolean> ProgramEnabled = new HashMap<ComputerProgram, Boolean>();
    private static HashMap<String, ComputerProgram> Programs = new HashMap<String, ComputerProgram>();

    private static final int MAX_WINDOW_SIZE_X = 250;
    private static final int MAX_WINDOW_SIZE_Y = 157;

    public static int GetMaxWindowSizeX(){return MAX_WINDOW_SIZE_X;}
    public static int GetMaxWindowSizeY(){return MAX_WINDOW_SIZE_Y;}

    public static void AddProgram(ComputerProgram Program){
        Programs.put(Program.GetId(), Program);
        ProgramEnabled.put(Program, Program.IsEnabled());

    }
}
