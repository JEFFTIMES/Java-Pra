package com.jefftimes;


import javafx.scene.control.cell.TextFieldListCell;

import java.util.Date;
import java.text.SimpleDateFormat;

class Person {

    public String firstName, lastName;
    protected final Date birthOfDate;
    private String gender = "unknown";

    public Person(String firstName, String lastName, String strBirthOFDate) throws Exception {
        this.firstName = firstName;
        this.lastName  = lastName;
        birthOfDate = new SimpleDateFormat("dd/MM/yyyy").parse(strBirthOFDate);
    }

    public String getBirthOfDate(){
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return ft.format(birthOfDate);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return this.gender;
    }

    public void saySomething() {
        String words = "";
        if(this.gender.equals("male")){
            words = "Man";
        }else if(this.gender.equals("female")){
            words = "Woman";
        }else{
            words = "Secret";
        }
        System.out.println("I am a " + words);
    }
}

interface MonthlyIncome{
    public void setIncome(float income);
    public float getIncome();
}


class Father extends Person implements MonthlyIncome {

    private float income = 0;

    public Father(String firstName, String lastName, String strBirthOfDate,String gender) throws Exception {
        super(firstName, lastName, strBirthOfDate);
        this.setGender(gender);
    }

    @Override
    public String getGender() {
        return super.getGender() + " (superMethod called)";
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return this.income;
    }

    @Override
    public void saySomething(){
        System.out.println("I am definitely a Man.");
    }
    //Overload
    public void saySomething(String otherWords){
        System.out.println("I am a " + this.getGender() + " and " + otherWords);
    }
}


class Son extends Father {

    private String school;

    public Son(String firstName, String lastName, String strBirthOfDate, String gender, String school) throws Exception {
        super(firstName, lastName, strBirthOfDate, gender);
        this.school = school;
    }

    @Override
    public void saySomething(){
        System.out.println("I am still a boy.");
    }

    //Overload
    public void saySomething(String otherWords, String moreWords){
        System.out.println("I am a " + this.getGender() + " and " + otherWords + ", " + moreWords);
    }

    @Override
    public void setIncome(float income) {
        super.setIncome(income*2);
    }
}

