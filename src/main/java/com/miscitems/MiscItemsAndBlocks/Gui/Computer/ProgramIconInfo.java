package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import net.minecraft.util.*;

public class ProgramIconInfo {

    //Receive the information about the icon
    public ProgramIconInfo(ResourceLocation texture, int x, int y, int SizeX, int SizeY){

        this.rs = texture;
        this.X = x;
        this.Y = y;
        this.sizeX = SizeX;
        this.sizeY = SizeY;
    }

    //The x and y coordinates of the texture in the texture file
    private int X, Y;

    //The x and y size of the texture
    private int sizeX, sizeY;

    //The location fo the texture file
    private ResourceLocation rs;


    //Returns the x cord for the icon
    public int GetX(){
        return X;
    }

    //Returns the y cord for the icon
    public int GetY(){
        return Y;
    }

    //Returns the x size of the icon
    public int GetXSize(){
        return sizeX;
    }

    //Returns the y size of the icon
    public int GetYSize(){
        return sizeY;
    }

    //Returns the ResourceLocation instance used for the icon
    public ResourceLocation GetTexture(){
        return rs;
    }
}
