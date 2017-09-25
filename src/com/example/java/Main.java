package com.example.java;


import  java.time.*;
import  java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        int firstDay = 12;
        int firstMonth = 1;
        int firstYear = 2017;
        double accurateCycle = 29.5;
        int moonCycle = 29;
        int numCycles = 0;
        int totalDays;

        LocalDate today = LocalDate.now();  //get todays date
        LocalDate FirstFullMoon = LocalDate.of(firstYear,firstMonth,firstDay); //set first full moon of the year
            //set next & recent full moon
        LocalDate nextFullMoon;
        LocalDate recentFullMoon;

            //format the date to month/day/year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");

            //set next full moon from first full moon to add day cycles in do-while loop
        nextFullMoon = FirstFullMoon;

        do {        //add 29 day cycles until day is after current date for a rough number in cycles

            nextFullMoon = nextFullMoon.plusDays(moonCycle);
            numCycles++;

        } while (nextFullMoon.isBefore(today));

            //the number of cycles will then be multiplied by the accurate days in a cycle
        totalDays = Math.toIntExact(Math.round(accurateCycle * numCycles));


            //format the date to display
        String todayText = today.format(formatter);
        System.out.println("Today's Date: " + todayText);

        //the accurate number of days will be added to the last full moon
        nextFullMoon = FirstFullMoon.plusDays(totalDays);
        String nextFullMoonText = nextFullMoon.format(formatter);   //format and display the next full moon
        System.out.println("\nThe next full moon will be: " + nextFullMoonText);

        //next full moon will subract 1 cycle to determine the most recent cycle
        recentFullMoon = nextFullMoon.minusDays(moonCycle);
        String recentFullMoonText = recentFullMoon.format(formatter);   //format and display the recent full moon
        System.out.println("\nMost recent full moon was: " + recentFullMoonText);
    }
}
