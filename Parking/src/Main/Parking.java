/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static ParkPackage.Funcs.FixPlacesNum;
import static ParkPackage.Funcs.FixParkingTime;
import java.util.Scanner;

/**
 *
 * @author askoz
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        do
         {
         System.out.println("Enter the number of places on a parking site");
         input = in.next();
         }while("Incorrect input".equals(FixPlacesNum(input)));
         do
         {
         System.out.println("Enter the time which is necessary for parking");
         input = in.next();
         }while("Incorrect input".equals(FixParkingTime(input)));
         ParkPackage.CommandsAcceptor acceptor = new ParkPackage.CommandsAcceptor();
         acceptor.CommandOperator(in);
         System.out.println("finish");
         in.close();
    }
    
}
