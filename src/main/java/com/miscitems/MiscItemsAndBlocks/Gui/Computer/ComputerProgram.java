package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

public abstract class ComputerProgram {

    //Receiving the info for the program from the the parent
    public ComputerProgram(String Id, String Name, boolean Enabled, int XSize, int YSize, int XCord, int YCord, ProgramIconInfo Icon){

        this.ProgramId = Id;
        this.ProgramName = Name;
        this.Enabled = Enabled;
        this.WindowSizeX = XSize;
        this.WindowSizeY = YSize;
        this.WindowXCord = XCord;
        this.WindowYCord = YCord;
        this.ProgramIcon = Icon;
    }

    //Is the program enabled server side
    protected boolean Enabled = true;

    //The name of the program
    protected String ProgramName;

    //The id for the program. Used for saving the program to the server
    protected String ProgramId;

    //The size of the program window
    protected int WindowSizeX;
    protected int WindowSizeY;

    //The coordinates of the program on the screen
    protected int WindowXCord;
    protected int WindowYCord;

    //The icon used for the program
    protected ProgramIconInfo ProgramIcon;



    //Returns true if the program is enabled on the server
    public boolean IsEnabled(){return Enabled;}

    //Returns true if the program runs with fullscreen
    public boolean IsFullScreen(){return WindowSizeX >= ComputerUtils.GetMaxWindowSizeX() && WindowSizeY >= ComputerUtils.GetMaxWindowSizeY();}

    //Returns true if the window can be moved around on the screen
    public boolean CanBeMoved(){return !IsFullScreen();}

    //Returns the name of the program
    public String GetName(){return ProgramName;}

    //Returns the id of the program. Used for identifying the program and saving syncing it with the server
    public String GetId(){return ProgramId;}

    //Returns the size of the window
    public int GetSizeX(){return WindowSizeX;}
    public int GetSizeY(){return WindowSizeY;}

    //Returns the coordinates for the position of the program on the screen
    public int GetX(){return WindowXCord;}
    public int GetY(){return WindowYCord;}

    //Returns the ProgramIconInfo to be used for the program icon
    public ProgramIconInfo GetIcon(){return ProgramIcon;}

    //TODO Implement properly
    public abstract void RenderWindow(int xCord, int yCord);

}
