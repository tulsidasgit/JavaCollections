package List.Arraylist.resizableArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] demoArray = new int[0];
            int choice =0;
            int data;
            do {
                System.out.println("\t Enter 1: Add element");
                System.out.println("\t Enter 2: Display element");
                System.out.println("\t Enter 3: Check size");
                System.out.println("\t Enter 99:    EXIT");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter element to add: ");
                        data = scanner.nextInt();
                        demoArray = Arrays.copyOf(demoArray, demoArray.length+1);
                        demoArray[demoArray.length-1] = data;
                        break;
                    case 2:
                        System.out.println("Elements in arraylist are:  ");
                        for (int i : demoArray)
                        {
                            System.out.print( " "+i);
                        }
                        System.out.println("\n-------------");
                        break;
                    case 3:
                        System.out.println("Size of arraylist is: "+demoArray.length);
                        break;
                    case 99:
                        System.out.println("Thanks for your time ");
                        break;
                    default:
                        System.out.println("Wrong choice");
                        break;
                }
            }while(choice !=99);
    }
}