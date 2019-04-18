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
public class UnparkThread extends Thread{
    public int num;
    public UnparkThread(String name, int number)
    {
        super(name);
        num = number;
    }
    public void run()
    {
        synchronized(ParkPackage.Funcs.cars)
        {
        for(int iter = 0; iter < ParkPackage.Funcs.cars.size(); iter++)
        {
            if(ParkPackage.Funcs.cars.get(iter).ticket == num)
            {
                ParkPackage.Funcs.freePlaces++;
                ParkPackage.Funcs.cars.remove(iter);
                break;
            }
            else if(iter == ParkPackage.Funcs.cars.size() - 1)
            {System.out.println("Incorrect ticket number");}
        }
        }
    }
}
