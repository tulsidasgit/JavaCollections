package Set.LinkedHashSet;

import java.util.*;

public class LinkedHashSetDemo
{
    public static void main(String[] args) {
        Set<Integer> hashSet = new LinkedHashSet<>();

        List<Integer> tempList = new LinkedList<>();
        tempList.add(31);
        tempList.add(32);
        tempList.add(33);
        Integer [] temparr = {12,23,34,45};

        int choice =0;
        int data;
        do {
            System.out.println("\t Enter 1: Add element");
            System.out.println("\t Enter 2: Display element");
            System.out.println("\t Enter 3: Remove element");
            System.out.println("\t Enter 4: Check size");
            System.out.println("\t Enter 5: Search element in the linkedHashSet");
            System.out.println("\t Enter 6: Add null values");
            System.out.println("\t Enter 7: Add elements from other list");
            System.out.println("\t Enter 8: Retain common elements in two lists");
            System.out.println("\t Enter 11: Convert linkedHashSet to array");
            System.out.println("\t Enter 12: Convert array to linkedHashSet");
            System.out.println("\t Enter 13: Print elements in sorted order");
            System.out.println("\t Enter 99:    EXIT");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter element to add: ");
                    data = scanner.nextInt();
                    hashSet.add(data);
                    break;
                case 2:
                    System.out.println("Elements in HashSet are: "+hashSet);
                    break;
                case 3:
                    System.out.println("Enter element to remove: ");
                    data = scanner.nextInt();
                    hashSet.remove(Integer.valueOf(data));
                    break;
                case 4:
                    System.out.println("Size of linkedHashSet is: "+hashSet.size());
                    break;
                case 5:
                    System.out.println("Enter element to search in list: ");
                    data = scanner.nextInt();
                    if(hashSet.contains(data))
                        System.out.println("Element is present in set: ");
                    else
                        System.out.println("Element is not present in set");
                    break;
                case 6:
                    hashSet.add(null);
                    break;
                case 7:
                    hashSet.addAll(tempList);
                    break;
                case 8:
                    hashSet.retainAll(tempList);
                    break;

                case 11:
                    Integer[] arr =hashSet.toArray(new Integer[0]);
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
                    hashSet = new HashSet<>(Arrays.asList(temparr));
                    break;
                case 13:
                    tempList = new ArrayList<>(hashSet);
                    Collections.sort(tempList);
                    System.out.println(tempList);
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

