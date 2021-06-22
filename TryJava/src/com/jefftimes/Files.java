package com.jefftimes;

import java.io.File;
import java.io.IOException;

// this is a class to try the java.io.File class and the java.io.IOException class
class CreateFile {
    public static void createFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
