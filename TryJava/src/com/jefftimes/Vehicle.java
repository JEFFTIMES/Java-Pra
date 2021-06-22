package com.jefftimes;

// this is a class to try abstract class
public abstract class Vehicle {
    private String color;
    protected String brand = "Ford";        // Vehicle attribute
    public void honk() {                    // Vehicle method
        System.out.println("Tuut, tuut!");
    }
}

// this is a try for inheritance
class Car extends Vehicle {
    private String modelName = "Mustang";    // Car attribute
    private int modelYear;
    static int numberOfModels = 4;

    public Car() {};

    public Car(String modelName){
        this.modelName = modelName;
    }

    public Car(String modelName, int modelYear){
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    
}
