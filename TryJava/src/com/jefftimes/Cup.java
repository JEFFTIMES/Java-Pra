package com.jefftimes;

public class Cup {



    private int weight;
    private String clolor;
    private String material;
    private int screenSizeY;

    public Cup(){
        this.clolor = "white";
        this.material = "glass";
        this.weight = 200;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }


}
