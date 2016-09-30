/*
    Lab 6 Problem 4 - Updated Lake Laps Program
    Jeremy Wolfe 09/29/2016

    Copied from Lab 4 Problem 4.

    Update program to use an Arraylist to hold lake information object defined in
    another Java class file.

*/
package com.wolfe;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    static HashMap<String, LakeLaps> lakesMap = new HashMap<String, LakeLaps>();

    public static void main(String[] args) {

        // get user input and add the data to the class object and HashMap
        buildHashMap();

        // display the minimum/best lap time for each lake (along with all lap times)
        displayHashMap();

        stringScanner.close();
        numberScanner.close();

    } // end main method

    // call class object to display information it contains
    private static void displayHashMap() {

        for (HashMap.Entry<String, LakeLaps> entry : lakesMap.entrySet()) {
            String key = entry.getKey();
            LakeLaps obj = entry.getValue();

            obj.displayLapTimes(key);
        }
    }

    // get lake name and lap times from user, add the data to LakeLaps object
    private static void buildHashMap() {

        String moreEntries = "n";

        do {    // loop through user Lake/Lap input data

            System.out.println("Please enter the name of the Lake: ");
            String lakeName = stringScanner.nextLine();

            LakeLaps obj = new LakeLaps(lakeName);

            while (true) {   // allow user to enter multiple times for a given lake
                System.out.println(" lap time in decimal minutes (zero to exit): ");
                Double inTime = numberScanner.nextDouble();
                if (inTime == 0) {
                    break;
                } else {
                    obj.setLapTimes(inTime);    // add entry to Arraylist in object of LakeLaps
                }
            } // end inner while

            lakesMap.put(lakeName, obj);        // add object to HashMap

            System.out.println("Do you have more entries? (y or n)");
            moreEntries = stringScanner.nextLine();

        } while (moreEntries.equalsIgnoreCase("y"));
    }
} // end class Main
