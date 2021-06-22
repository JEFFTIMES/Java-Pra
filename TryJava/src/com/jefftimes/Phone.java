package com.jefftimes;

public class Phone {

    private int screenSizeX;
    private int screenSizeY;

     public Phone(){
        screenSizeX = 300;
        screenSizeY = 800;
    }

    public int[] getScreenSize(){
        return new int[]{screenSizeX, screenSizeY};
    }

    public void setScreenSize(int x, int y){

        screenSizeX = x;
        screenSizeY = y;
    }

}
