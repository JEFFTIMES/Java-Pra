package com.jefftimes;


public class Main {

    public static void reportPerson(Person person){
        String statement;
        if(person instanceof Son){
            statement = "a son";
            ((Son)person).setIncome(100);
            ((Son)person).saySomething(statement,"haha.");

        }else if(person instanceof Father){
            statement = "a father";
            ((Father)person).setIncome(1000);
            ((Father) person).saySomething(statement);
        }

        System.out.println(person.firstName + " is a " + person.getGender());
        person.saySomething();

    }


    public static void main(String[] args) throws Exception {

        String [] lan =  {"Chinese","English"};
        //Person person = new Person("Who","are","02/02/2000");
        Person jeff = new Father("Jeff","Throne","04/05/1976","male");
        Person vic = new Son("Victor","Throne","06/06/2015","male","Semi");


        reportPerson(jeff);
        reportPerson(vic);

        String [] argss = {"t","y"};

        Invoice.main();

        Invoice invo = new Invoice();

        invo.addItem("plate",1,4.3);
        invo.printInvoiceItems();
    }



}
