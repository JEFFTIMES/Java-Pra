package com.jefftimes;

import java.util.Arrays;

class Ftest {

    enum Weather{
        SUNNY,
        CLOUDY,
        RAINING,
        WINDY
    }
    public int checkWeather(Weather weatherCondition) {
        if (weatherCondition == Weather.SUNNY || weatherCondition == Weather.CLOUDY){
            return 1;
        }else{
            return 0;
        }

    }

}

class Iter2DArray{

    private final String[][] carMakers = {
            {"Honda", "Toyota", "Mazda", "Mitsubishi", "Suzuki"},
            {"Tesla", "Audi", "NIO", "Xpeng", "Hyundai", "Kia"}
    };

    public void TheArray(){

        for(int i = 0; i < carMakers.length; i++){
            for(int j = 0; j < carMakers[i].length; j++){
                System.out.println("At index " + i + j + carMakers[i][j]);
            }
        }

    }

}

class Coffee {

    protected String size;
    protected int cream;
    protected int milk;
    protected int sugar;
    protected double price;

    Coffee(){
        size = "small";
        cream = 0;
        milk = 0;
        sugar = 0;
        price = 1.00;
    }

    Coffee(String size, int cream, int milk, int sugar, double price){

        this.size = size;
        this.cream = cream;
        this.milk = milk;
        this.sugar = sugar;
        this.price = price;

    }

    public void printOrder(){

        System.out.println("Your Coffee Order is here..." );
        System.out.println("size : " + this.size);
        System.out.println("cream : " + this.cream);
        System.out.println("milk : " + this.milk);
        System.out.println("sugar : " + this.sugar);
        System.out.println("price : " + this.price);

    }

}


class BasicMath {
    int x,y;
    double p,q;

    //addition int method
    public int addition(int x, int y)
    {
        return x + y;
    }

    // create an overloaded method for double addition
    public double addition(double p, double q){

        return p + q;


    }


}


class AdvanceMath extends BasicMath{

    int x, y, z;
    float p,q,r;

    //override int method

    public int addition(int x, int y, int z)
    {
        return x + y + z;
    }

    //override the double method having a parameters of three values
    public double addition(double p, double q, double r){
        return p + q + r;
    }

}

class BankAccount {
    private String fName;
    private String lName;
    private int customerID;

    public BankAccount(String fName, String lName, int customerID)
    {
        this.fName = fName;
        this.lName = lName;
        this.customerID = customerID;
    }

    // getter method for first name
    public String getFirstName()
    {
        return this.fName;
    }

    // setter method for last name
    public void setFirstName(String newFirstName)
    {
        this.fName = newFirstName;
    }

    // getter method for the IName
    public String getLastName()
    {
        return this.lName;
    }


    // setter method for the lastName
    public void setLastName(String newLastName)
    {
        this.fName = newLastName;
    }

    // getter method for the customerID
    public int getCustomerID()
    {
        return this.customerID;
    }

    // setter method for the customerID
    public void setCustomerID(int id)
    {
        this.customerID = id;
    }
}

