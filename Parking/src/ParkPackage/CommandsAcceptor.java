
package ParkPackage;

import java.util.Scanner;


public class CommandsAcceptor {
    public void CommandOperator(Scanner in){
     String input = in.next();
    while(!"e".equals(input))
    {
        switch(input)
        {
            case "l":
                for(Car elem: ParkPackage.Funcs.cars)
                    if(elem != null)
                    System.out.println("\nTicket number: " + elem.ticket +
                             "\nOrder:" + elem.number);
            break;
            case "c":
                System.out.println(ParkPackage.Funcs.freePlaces);
            break;
            default:
                if(input.indexOf(':') == -1)
                    System.out.println("Incorrect command");
                else
                {
                    String[] arr = input.split(":");
                    if(arr.length != 2)
                        System.out.println("Incorrect command");
                    else
                        {
                            switch(arr[0])
                            {
                                case "p":
                                {
                                    int carAmount = Integer.parseInt(arr[1]);
                                    for(int iter = 0; iter < carAmount; iter++)
                                    {
                                        new ParkThread("ParkThread " + iter).start();
                                    }
                                }
                                    break;
                                case "u":
                                {
                                    try{
                                    int parkNum = Integer.parseInt(arr[1]);
                                    new UnparkThread("UnparkThread ", parkNum).start();
                                    }
                                    catch(NumberFormatException ex)
                                    {
                                        try
                                        {if(arr[1].indexOf('[')==0 && arr[1].indexOf(']') == arr[1].length()-1)
                                        {
                                        arr[1] = arr[1].substring(1, arr[1].length()-1);
                                        String[] symbols = arr[1].split(",");
                                        int[] numbers = new int[symbols.length];
                                        
                                            for(int iter = 0; iter < numbers.length; iter++)
                                            {
                                                try{
                                                numbers[iter] = Integer.parseInt(symbols[iter]);
                                                new UnparkThread("Unpark" + iter, numbers[iter]).start();
                                                }
                                                catch(NumberFormatException e)
                                                {
                                                    System.out.println("Incorrect ticket information");
                                                }
                                            }
                                        
                                        
                                        }
                                        else
                                            System.out.println("Incorrect ticket information");
                                        }
                                        catch(OutOfMemoryError | Exception e)
                                        {
                                            System.out.println("Incorrect information");
                                        }
                                    }
                                }
                                    break;
                                    }
                                    
                            }
                        }
                }
     input = in.next();   }
           
    }
}

