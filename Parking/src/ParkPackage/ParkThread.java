/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParkPackage;

/**
 *
 * @author askoz
 */
public class ParkThread extends Thread {
    public ParkThread(String name)
    {
        super(name);
    }
    
    public void run()
    {
        synchronized(ParkPackage.Funcs.cars)
        {
        if(ParkPackage.Funcs.freePlaces == 0)
            System.out.println("There are no empty places");
        else{
        Car parkingCar = new Car(ParkPackage.Funcs.totalPlaces - 
                ParkPackage.Funcs.freePlaces + 1,
                ParkPackage.Funcs.ticketCounter);
        ParkPackage.Funcs.freePlaces--;
        ParkPackage.Funcs.ticketCounter++;
        ParkPackage.Funcs.cars.add(parkingCar);
        try{
            Thread.sleep(ParkPackage.Funcs.parkingTime*100);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        }
        
    }
    }
}
