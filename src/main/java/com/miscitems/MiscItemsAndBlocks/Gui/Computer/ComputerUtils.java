package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import java.util.ArrayList;
import java.util.HashMap;

public class ComputerUtils {

    public static HashMap<ComputerProgram, Boolean> ProgramEnabled = new HashMap<ComputerProgram, Boolean>();
    public static HashMap<String, ComputerProgram> ProgramIds = new HashMap<String, ComputerProgram>();
    public static ArrayList<ComputerProgram> Programs = new ArrayList<ComputerProgram>();


    public static void AddProgram(ComputerProgram Program){
        if(Program.IsEnabled()) {
            ProgramIds.put(Program.GetId(), Program);
            ProgramEnabled.put(Program, Program.IsEnabled());
            Programs.add(Program);
        }

    }

}
