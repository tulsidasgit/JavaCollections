package Set.Treeset;

import java.util.*;

public class TreeSetDemo
{
   public static void main(String[] args) {
       Set<Integer> treeSet = new TreeSet<>();

       List<Integer> tempList = new LinkedList<>();
       tempList.add(31);
       tempList.add(38);
       tempList.add(35);
       Integer [] temparr = {12,23,34,45};

       int choice =0;

       int data;
       do {
           System.out.println("\t Enter 1: Add element");
           System.out.println("\t Enter 2: Display element");
           System.out.println("\t Enter 3: Remove element");
           System.out.println("\t Enter 4: Check size");
           System.out.println("\t Enter 5: Search element in the treeSet");
           System.out.println("\t Enter 6: Add null values");
           System.out.println("\t Enter 7: Add elements from other list");
           System.out.println("\t Enter 8: Retain common elements from list and treeSet");
           System.out.println("\t Enter 11: Convert treeSet to array");
           System.out.println("\t Enter 12: Convert Array to treeSet");
           System.out.println("\t Enter 99:    EXIT");
           Scanner scanner = new Scanner(System.in);
           choice = scanner.nextInt();
           switch(choice)
           {
               case 1:
                   System.out.println("Enter element to add: ");
                   data = scanner.nextInt();
                   treeSet.add(data);
                   break;
               case 2:
                   System.out.println("Elements in treeSet are: "+treeSet);
                   break;
               case 3:
                   System.out.println("Enter element to remove: ");
                   data = scanner.nextInt();
                   treeSet.remove(Integer.valueOf(data));
                   break;
               case 4:
                   System.out.println("Size of treeSet is: "+treeSet.size());
                   break;
               case 5:
                   System.out.println("Enter element to search in treeSet: ");
                   data = scanner.nextInt();
                   if(treeSet.contains(data))
                       System.out.println("Element is present in set: ");
                   else
                       System.out.println("Element is not present in set");
                   break;
               case 6:
                   treeSet.add(null);
                   break;
               case 7:
                   treeSet.addAll(tempList);
                   break;
               case 8:
                   treeSet.retainAll(tempList);
                   break;

               case 11:
                   Integer[] arr =treeSet.toArray(new Integer[0]);
                   try {
                       for (int i : arr) {
                           System.out.println("  " + i);
                       }
                   }
                   catch (NullPointerException e)
                   {
                       System.out.println("There are null values in array");
                   }
                   break;
               case 12:
                   treeSet = new TreeSet<>(Arrays.asList(temparr));
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
