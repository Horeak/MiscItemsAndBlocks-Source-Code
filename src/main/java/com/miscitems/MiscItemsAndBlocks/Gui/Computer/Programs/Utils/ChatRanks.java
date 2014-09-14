package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import java.awt.*;

public enum ChatRanks {

    User("User", null, 0),
    Moderator("Moderator", new Color(0, 183, 6), 1),
    Admin("Admin", new Color(209,0,12), 2),
    Owner("Owner", new Color(255, 245,0), 3);

    public String Name;
    public Color color;
    public int Value;


     ChatRanks(String Name, Color color, int Value){

         this.Name = Name;
         this.color = color;
         this.Value = Value;

     }
}
