package ParkPackage;

import java.util.Scanner;
import java.util.ArrayList;

public class Funcs {
    public static ArrayList<Car> cars = new ArrayList<Car>();
    public static int totalPlaces;
    public static int freePlaces;
    public static int ticketCounter = 1;
    public static String FixPlacesNum(String input)
    {
        int plNum;
        try{
        plNum = Integer.parseInt(input);
        totalPlaces = plNum;
        if(plNum < 0)
        {
            throw new Exception("Number of places cannot be negative");
        }
        
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Information about the number of parking places"
                    + " is incorrect");
            return "Incorrect input";
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return "Incorrect input";
        }
        freePlaces = totalPlaces;
        return "Correct input";
    }
    public static int parkingTime;
    public static String FixParkingTime(String input)
    {
        try{
        parkingTime = Integer.parseInt(input);
        if(parkingTime < 0 || parkingTime > 5)
        {
            throw new Exception("Unexpected parking time");
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return "Incorrect input";
        }
        return "Correct input";
    }
    
    
}

