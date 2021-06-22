package com.jefftimes;

import java.util.Comparator;

interface IntSequence {

    // declare some variables:
    // int START = 0;
    // int STEP = 1;

    // To declare an interface, you provide the method headers:
    int next();

    //You need not implement these methods, buy you could provide default implementations like this.
    default boolean hasNext() { return true; }

    //Declare a static method
    public static double average(IntSequence seq, int n){
        int count=0;
        double sum =0;
        while(seq.hasNext() && count<n){
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;

    }

}

class SquareSequence implements IntSequence {

    private int i;

    public boolean hasNext() {return true;}

    public int next() {
        i++;
        return i * i;
    }
}

// implement the Comparable interface
// the Comparable interface is used to allow the class which implementing it have the compareTo() service.

class Employee implements Comparable <Employee>  {

    // lastID is a variable which has only one instance belong to the class, shared by all the instance objects.
    public static int lastID;
    private int employeeID;
    public String name;

    public Employee(String name){
        int currentID = Employee.lastID;
        Employee.lastID = currentID + 1;
        this.employeeID = Employee.lastID;
        this.name = name;
    }

    public int getEmployeeID(){
        return this.employeeID;
    };


    public int getLastID(){
        return Employee.lastID;
    }
    //implement the compareTo method of the Interface Comparable.
    public int compareTo(Employee other){
        //return this.getEmployeeID() - other.getEmployeeID();
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, other.name);

    }
    //implement the compare method of the Interface Comparator.

}
//implementing the Comparator interface
class employeeComparator implements Comparator<Employee> {

    public int compare(Employee first, Employee second){
        return first.getEmployeeID() - second.getEmployeeID();
        //String.CASE_INSENSITIVE_ORDER.compare(first.name, second.name);

    }
}

//implementing the Runnable interface.
class tryRunnable implements Runnable {

    // implementing the only method -- run().
    public void run(){
        for(int i=1; i<=1000; i++){
            System.out.println(i);
        }
    }

}
