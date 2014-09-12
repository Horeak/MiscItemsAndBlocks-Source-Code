package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import java.awt.*;

public enum ChatRanks {

    User("User", null),
    Moderator("Moderator", new Color(0, 183, 6)),
    Admin("Admin", new Color(209,0,12)),
    Owner("Owner", new Color(255, 245,0));

    public String Name;
    public Color color;

     ChatRanks(String Name, Color color){

         this.Name = Name;
         this.color = color;
     }
}
