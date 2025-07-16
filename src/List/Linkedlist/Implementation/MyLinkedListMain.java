package List.Linkedlist.Implementation;

import java.util.LinkedList;
import java.util.Scanner;

class Node
{
    public int data;
    public Node next;
    public Node prev;
}
class CustomLinkedlist
{
    public Node head = null,temp,p,q;
    //private int size=0;

    public void add(int data)
    {
        if(head == null)
        {
            head = new Node();
            head.data = data;
            head.prev = null;
            head.next = null;
        }
        else
        {
            temp = new Node();
            temp.data = data;
            temp.next = null;
            temp.prev = null;
            p = head;
            while(p.next !=null)
            {
                p=p.next;
            }
            p.next = temp;
            temp.prev = p;
        }
    }
    public void addFirst(int data)
    {
        temp = new Node();
        temp.data = data;
        temp.next = null;
        temp.prev = null;

        temp.next = head;
        head = temp;
    }

    public void addLast(int data)
    {
        temp = new Node();
        temp.data = data;
        temp.next = null;
        temp.prev = null;

        p = head;
        while(p.next !=null)
        {
            p=p.next;
        }
        p.next = temp;
        temp.prev = p;
    }
    public void add(int index, int data)
    {
        if(index <0 || index >size())
        {
            System.out.println("You have entered wrong index");
        }
        else if(index==0)
        {
            addFirst(data);
        }
        else if(index == size())
        {
            addLast(data);
        }
        else
        {
            temp = new Node();
            temp.data = data;
            temp.next = null;
            temp.prev = null;

            p = head;
            for(int i=0;i<index-1;i++)
            {
                p = p.next;
            }
            q = p.next;

            p.next = temp;
            temp.next = q;
            q.prev = temp;
            temp.prev = p;
        }
    }
    public int size()
    {
        int i=0;
        p=head;
        while(p!=null)
        {
            p = p.next;
            i++;
        }
        return i;
    }
    public void set(int index, int data)
    {
        if(index <0 || index >size())
        {
            System.out.println("You have entered wrong index");
        }
        else if(index==0)
        {
            head.data = data;
        }
        else if(index == size())
        {
            p = head;
            while(p.next !=null)
            {
                p=p.next;
            }
            p.data = data;
        }
        else
        {
            p = head;
            for(int i=0;i<index;i++)
            {
                p = p.next;
            }
            p.data = data;
        }
    }

    public int remove(int index)
    {
        int data=0;
        if(index <0 || index >size())
        {
            System.out.println("You have entered wrong index");
        }
        else if(index==0)
        {
            data = removeFirst();
        }
        else if(index == size())
        {
            data = removeLast();
        }
        else
        {
            p = head;
            for(int i=0;i<index-1;i++)
            {
                temp = p;
                p = p.next;
            }
            q = p.next;

            temp.next = q;
            q.prev = temp;

             data = p.data;
            p = null;

        }
        return data;
    }
    public int removeFirst()
    {
        p = head;
        head = head.next;
        int data = p.data;
        p = null;
        return data;
    }
    public int removeLast()
    {
        p = head;
        while(p.next !=null)
        {
            q = p;
            p = p.next;
        }
        q.next = null;
        int data = p.data;
        p = null;
        return data;
    }

}


public class MyLinkedListMain
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> originalLinkedListlist = new LinkedList<>();
        CustomLinkedlist customLinkedlist = new CustomLinkedlist();

        int choice;
        int data, index;
        do {
            System.out.println("\n Menu for Custom Linked List");
            System.out.println("\t Enter 1: Insert element");
            System.out.println("\t Enter 11: Insert element at first position");
            System.out.println("\t Enter 12: Insert element at last position");
            System.out.println("\t Enter 13: Insert element at a given position");
            System.out.println("\t Enter 2: Display all elements in arraylist");
            System.out.println("\t Enter 3: Get size of Linkedlist");
            System.out.println("\t Enter 4: Update element in arraylist by index");
            System.out.println("\t Enter 5: Remove element by index");
            System.out.println("\t Enter 51: Remove element by value");
            System.out.println("\t Enter 52: Remove element at fist position");
            System.out.println("\t Enter 53: Remove element at last position");
            System.out.println("\t Enter 54: Remove first occurrence of element by vale");
            System.out.println("\t Enter 55: Remove last occurrence of element by vale");

            System.out.println("\t Enter 99: Insert element");
            choice = scanner.nextInt();


            switch(choice)
            {
                case 1:
                    System.out.println("Enter the element");
                    data = scanner.nextInt();
                    originalLinkedListlist.add(data);
                    customLinkedlist.add(data);
                    break;
                case 11:
                    System.out.println("Enter the element to insert at first position of linked list");
                    data = scanner.nextInt();
                    originalLinkedListlist.addFirst(data);
                    customLinkedlist.addFirst(data);
                    break;
                case 12:
                    System.out.println("Enter the element to insert at last position of linked list");
                    data = scanner.nextInt();
                    originalLinkedListlist.addLast(data);
                    customLinkedlist.addLast(data);
                    break;
                case 13:
                    System.out.println("Enter the element to insert at given position of linked list");
                    data = scanner.nextInt();
                    System.out.println("Enter the position");
                    index = scanner.nextInt();
                    originalLinkedListlist.add(index,data);
                    customLinkedlist.add(index,data);
                    break;
                case 2:
                    displayArraylist(originalLinkedListlist, customLinkedlist);
                    break;
                case 3:
                    System.out.println("Size of Original arraylist is: "+originalLinkedListlist.size());
                    System.out.println("Size of Custom arraylist is: "+ customLinkedlist.size());
                    break;
                case 4:
                    System.out.println("Enter the index");
                    index = scanner.nextInt();
                    System.out.println("Enter the updated value for given index");
                    data = scanner.nextInt();
                    originalLinkedListlist.set(index,data);
                    customLinkedlist.set(index,data);
                    break;
                case 5:
                    System.out.println("Enter the index to remove element");
                    index = scanner.nextInt();
                    System.out.println("Value of deleted Element at given index is: "+originalLinkedListlist.remove(index));
                   // System.out.println("Value of deleted Element at given index is: "+ customLinkedlist.remove(index));
                    break;
                case 51:
                    System.out.println("Enter the data to remove from arraylist");
                    data = scanner.nextInt();
                    System.out.println("Value of deleted Element  is: "+originalLinkedListlist.remove(Integer.valueOf(data)));
                 //   System.out.println("Value of deleted Element  is: "+ customLinkedlist.remove(Integer.valueOf(data)));
                    break;
                case 52:

                    System.out.println("Value of deleted Element  is: "+originalLinkedListlist.removeFirst());
                    System.out.println("Value of deleted Element  is: "+ customLinkedlist.removeFirst());
                    break;
                case 53:

                    System.out.println("Value of deleted Element  is: "+originalLinkedListlist.removeLast());
                    System.out.println("Value of deleted Element  is: "+ customLinkedlist.removeLast());
                    break;
                case 54:
                    System.out.println("Enter the data to remove its first occurrence in linkedlist");
                    data = scanner.nextInt();
                    System.out.println("Value of deleted Element  is: "+originalLinkedListlist.removeFirstOccurrence(data));
                  //  System.out.println("Value of deleted Element  is: "+ customLinkedlist.removeFirstOccurrence(data));
                    break;
                case 55:
                    System.out.println("Enter the data to remove its first occurrence in linkedlist");
                    data = scanner.nextInt();
                    System.out.println("Value of deleted Element  is: "+originalLinkedListlist.removeLastOccurrence(data));
                  //  System.out.println("Value of deleted Element  is: "+ customLinkedlist.removeLastOccurrence(data));
                    break;
                case 99:
                    System.out.println("Thanks");
                    break;

            }

        }while(choice !=99);
    }
    public static void displayArraylist(LinkedList<Integer> numbers, CustomLinkedlist customLinkedlist)
    {
        System.out.print("Elements in Original LinkedList is: ");
        for(int i=0;i<numbers.size();i++)
            System.out.print("   "+numbers.get(i));
        System.out.println("\n-----------------------------");
        System.out.print("Elements in Custom LinkedList is: ");
        for(Node p = customLinkedlist.head; p!=null; p=p.next)
            System.out.print("   "+ p.data);
        System.out.println("\n-----------------------------");
    }
}