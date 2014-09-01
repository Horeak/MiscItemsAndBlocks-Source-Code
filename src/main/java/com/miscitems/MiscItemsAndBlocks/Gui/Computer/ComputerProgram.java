package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;

import java.util.List;

public abstract class ComputerProgram {

    //Receiving the info for the program from the the parent
    public ComputerProgram(String Id, String Name, boolean Enabled, ProgramIconInfo Icon){

        this.ProgramId = Id;
        this.ProgramName = Name;
        this.Enabled = Enabled;
        this.ProgramIcon = Icon;
    }

    //Is the program enabled server side
    protected boolean Enabled = true;

    //The name of the program
    protected String ProgramName;

    //The id for the program. Used for saving the program to the server
    protected String ProgramId;

    //The icon used for the program
    protected ProgramIconInfo ProgramIcon;



    //Returns true if the program is enabled on the server
    public boolean IsEnabled(){return Enabled;}

    //Allows programs to add buttons to the gui while the program is open
    public void AddButton(List buttonList, int x, int y){}

    //Called when a button in the program is clicked
    public void ButtonClicked(GuiButton button){}

    //Called when the mouse is clicked when the program is open
    public void MouseClicked(int x, int y, int par3){}

    //Called when a key is typed when the program is open
    //Returns a boolean if it should call keyTyped in the computer gui instance
    public boolean KeyTyped(char key, int keycode){return true;}

    //Returns the name of the program
    public String GetName(){return ProgramName;}

    //Returns the id of the program. Used for identifying the program and saving syncing it with the server
    public String GetId(){return ProgramId;}


    //Returns the ProgramIconInfo to be used for the program icon
    public ProgramIconInfo GetIcon(){return ProgramIcon;}

    //Called when the program is closed
    public void CloseProgram(){}

    //Called when the program is opened
    public void OpenProgram(){}

    //Renders the program
    public abstract void RenderWindow(GuiComputerScreen guiInstance, FontRenderer font, int xCord, int yCord);

    public void DrawScreen(int Xcord, int yCord, int x, int y, float par3){}

    //Gets a new instance of the program
    public abstract ComputerProgram GetInstance();

}
