package com.wolfe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jeremy on 9/30/2016.
 * Class LakeLaps
 * Holds Lake name and an arraylist of runner lap times
 */
public class LakeLaps {

    private String name;                // lake name
    private ArrayList<Double> lapTimes; // lap time around lake

    LakeLaps(String lakeName) {
        name = lakeName;
        lapTimes = new ArrayList<Double>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    // add lap time entry to arraylist
    public void setLapTimes(Double lapTime) {
       lapTimes.add(lapTime);
    }

    // find the minimum/lowest lap time in the arraylist
    public Double getMinTime() {
        if (lapTimes.size() > 0) {
            return Collections.min(lapTimes);
        } else {
            return null;
        }
    }


    // display the data in the object arraylist
    public void displayLapTimes(String key) {

        System.out.print("Lake " + key + " Best time: " + getMinTime());
        System.out.print("   All times: ");
        for (int j = 0;  j < lapTimes.size(); j++) {
            System.out.print(lapTimes.get(j) + " ");
        }
        System.out.println();
    }

} // end LakeLaps Class
