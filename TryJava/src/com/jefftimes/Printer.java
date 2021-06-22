package com.jefftimes;

import java.util.Date;

public class Printer {

    private final String maker;
    private final String model;
    private final String serialNumber;

    public String name;
    public String wifiAPName;
    public Date yearOfDeployed;
    public int inkCartridges;
    public int paperTray;
    enum FUNCTION {
        WB_PRINT,
        CL_PRINT,
        WB_COPY,
        CL_COPY,
        FAX
    }

    Printer(String maker, String model,
            String serialNumber, String name,
            String wifiAPName, Date yearOfDeployed,
            int inkCartridges, int paperTray){

        this.maker = maker;
        this.model = model;
        this.serialNumber = serialNumber;
        this.name = name;
        this.wifiAPName =  wifiAPName;
        this.yearOfDeployed = yearOfDeployed;
        this.inkCartridges = inkCartridges;
        this.paperTray = paperTray;
    }

    public void printTestPage(){
        System.out.println("Hello World.");
    }

    public void copy(){
        System.out.println("please put the paper up side down on the scanner.");
    }

    public void fax(){
        
    }
}
