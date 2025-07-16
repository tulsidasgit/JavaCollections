package List.Linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

import java.util.*;

public class LinkedListDemo
{
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
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
            System.out.println("\t Enter 5: Search element in the list");
            System.out.println("\t Enter 6: Add null values");
            System.out.println("\t Enter 7: Add elements from one list to another list");
            System.out.println("\t Enter 8: Keep Only common elements in two lists");
            System.out.println("\t Enter 9: sublist");
            System.out.println("\t Enter 10: Remove duplicate elements");
            System.out.println("\t Enter 11: Convert list to array");
            System.out.println("\t Enter 12: Convert Array to list");
            System.out.println("\t Enter 13: Sort the List");
            System.out.println("\t Enter 14: Sort with Comparator");
            System.out.println("\t Enter 99:    EXIT");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter element to add: ");
                    data = scanner.nextInt();
                    linkedList.add(data);
                    break;
                case 2:
                    System.out.println("Elements in linkedList are: "+linkedList);
                    break;
                case 3:
                    System.out.println("Enter element to remove: ");
                    data = scanner.nextInt();
                    linkedList.remove(Integer.valueOf(data));
                    break;
                case 4:
                    System.out.println("Size of linkedList is: "+linkedList.size());
                    break;
                case 5:
                    System.out.println("Enter element to search in list: ");
                    data = scanner.nextInt();
                    if(linkedList.contains(data))
                        System.out.println("Element is present at index: "+linkedList.indexOf(data));
                    else
                        System.out.println("Element is not present in list");
                    break;
                case 6:
                    linkedList.add(null);
                    break;
                case 7:
                    linkedList.addAll(tempList);
                    break;
                case 8:
                    linkedList.retainAll(tempList);
                    break;
                case 9:
                    System.out.println("Enter start index for sublist: ");
                    int start = scanner.nextInt();
                    System.out.println("Enter last index for sublist: ");
                    int last = scanner.nextInt();
                    try {
                        System.out.println(linkedList.subList(start, last));
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Range is not valid tray again");
                    }
                    break;
                case 10:
                    Set<Integer> tempSet = new HashSet<>();
                    tempSet.addAll(linkedList);
                    linkedList.clear();
                    linkedList.addAll(tempSet);
                    break;
                case 11:
                    Integer[] arr =linkedList.toArray(new Integer[0]);
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
                    linkedList = Arrays.asList(temparr);
                    break;
                case 13:
                    Collections.sort(linkedList);
                    break;
                case 14:
                    //arrayList.sort(Comparator.comparingInt(Integer::intValue));
                    Comparator<Integer> comparator= new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    };
                    linkedList.sort(comparator);
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

