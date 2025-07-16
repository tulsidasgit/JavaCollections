package List.Arraylist;

import java.util.ArrayList;
import java.util.Scanner;

class CustomGenericArraylist<T>
{
    public Object[] elements = new Object[0];
    private int size = 0;

    public int getSize()
    {
        return size;
    }
    public void add(T data)
    {
        if(size == elements.length)
            elements = resize(elements);
        elements[size] = data;
        size++;
    }
    public void add(int index, T data)
    {
        if(index < 0 || index>size)
            throw new ArrayIndexOutOfBoundsException("Kindly Enter the Correct size");

        if(size == elements.length)
            elements = resize(elements);

        for(int i=size;i>index;i--)
        {
            elements[i] = elements[i-1];
        }
        elements[index] = data;
        size++;
    }

    public void set(int index, T data)
    {
        if(index < 0 || index>size)
            throw new ArrayIndexOutOfBoundsException("Kindly Enter the Correct size");
        else
            elements[index] = data;
    }

    public T remove(int index)
    {
        T val= (T) elements[index];
        if(index < 0 || index>size)
            throw new ArrayIndexOutOfBoundsException("Kindly Enter the Correct size");
        else {
            for(int i=index;i<size-1;i++)
            {
                elements[i] = elements[i+1];
            }
            size--;
        }
        return val;
    }

    public boolean remove(Object obj)
    {
        T data ;
        int index=0;
        int dataNum;
        String dataName;
        if(obj instanceof Integer)
        {
            dataNum = ((Integer) obj).intValue();
            while(index<size)
            {
                if((Integer) elements[index]== dataNum)
                {
                    for(int i=index;i<size-1;i++)
                    {
                        elements[i] = elements[i+1];
                    }
                    size--;
                    return true;
                }
                index++;
            }
        }
        if(obj instanceof String)
        {
            dataName = (String) obj;
            while(index<size)
            {
                if(elements[index].equals(dataName))
                {
                    for(int i=index;i<size-1;i++)
                    {
                        elements[i] = elements[i+1];
                    }
                    size--;
                    return true;
                }
                index++;
            }
        }

        return false;
    }

    private Object[] resize(Object[] elements)
    {
        Object[] tempArray = new Object[0];
        if(elements.length ==0)
        {
            tempArray = new Object[1];
        }
        else
        {
            tempArray = new Object[elements.length *2];
            copyArray(tempArray, elements);
        }
        return tempArray;       // return base address of array
    }

    private void copyArray(Object[] tempArray, Object[] numbers)
    {
        for(int i=0;i< numbers.length;i++)
        {
            tempArray[i] = numbers[i];
        }
    }

}


public class MyGenericArrayListMain
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> originalArraylistNumbers = new ArrayList<>();
        ArrayList<String> originalArraylistNames = new ArrayList<>();
        CustomGenericArraylist<Integer> customArraylistNumbers = new CustomGenericArraylist<>();
        CustomGenericArraylist<String> customArraylistNames = new CustomGenericArraylist<>();
        int choice;
        int dataNum, index;
        String dataName;
        do {
            System.out.println("\n Menu for Custom Arraylist");
            System.out.println("\t Enter 1: Insert element");
            System.out.println("\t Enter 11: Insert element at a given index");
            System.out.println("\t Enter 2: Display all elements in arraylist");
            System.out.println("\t Enter 3: Get size of arraylist");
            System.out.println("\t Enter 4: Update element in arraylist by index");
            System.out.println("\t Enter 5: Remove element by index");
            System.out.println("\t Enter 55: Remove element by data");
            System.out.println("\t Enter 99: Insert element");
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter a number");
                    dataNum = scanner.nextInt();
                    originalArraylistNumbers.add(dataNum);
                    customArraylistNumbers.add(dataNum);
                    System.out.println("Enter a Name");
                    dataName = scanner.next();
                    originalArraylistNames.add(dataName);
                    customArraylistNames.add(dataName);
                    break;
                case 11:
                    System.out.println("Enter the index");
                    index = scanner.nextInt();
                    System.out.println("Enter a number");
                    dataNum = scanner.nextInt();
                    originalArraylistNumbers.add(index,dataNum);
                    customArraylistNumbers.add(index,dataNum);
                    System.out.println("Enter a Name");
                    dataName = scanner.next();
                    originalArraylistNames.add(index,dataName);
                    customArraylistNames.add(index,dataName);
                    break;
                case 2:
                    displayArraylist(originalArraylistNumbers, customArraylistNumbers,originalArraylistNames, customArraylistNames);
                    System.out.println("      ------------           ");

                    break;
                case 3:
                    System.out.println("Size of Original arraylist of numbers is: "+originalArraylistNumbers.size());
                    System.out.println("Size of Custom arraylist of numbers is  : "+ customArraylistNumbers.getSize());
                    System.out.println("Size of Original arraylist of Names is  : "+originalArraylistNames.size());
                    System.out.println("Size of Custom arraylist of Names is    : "+ customArraylistNames.getSize());
                    break;
                case 4:
                    System.out.println("Enter the index");
                    index = scanner.nextInt();
                    System.out.println("Enter the updated value for given index in Integer Arraylist");
                    dataNum = scanner.nextInt();
                    System.out.println("Enter the updated value for given index in String Arraylist");
                    dataName = scanner.next();
                    originalArraylistNames.set(index,dataName);
                    customArraylistNames.set(index,dataName);
                    break;
                case 5:
                    System.out.println("Enter the index to remove element");
                    index = scanner.nextInt();
                    System.out.println("Value of deleted Element at given index is in original Arraylist of Integers: "+originalArraylistNumbers.remove(index));
                    System.out.println("Value of deleted Element at given index is in custom   Arraylist of Integers: "+ customArraylistNumbers.remove(index));
                    System.out.println("Value of deleted Element at given index is in original Arraylist of String  : "+originalArraylistNames.remove(index));
                    System.out.println("Value of deleted Element at given index is in custom   Arraylist of String  : "+ customArraylistNames.remove(index));
                    break;
                case 55:
                    System.out.println("Enter a number to remove from arraylist");
                    dataNum = scanner.nextInt();
                    System.out.println("Enter a name to remove from arraylist");
                    dataName = scanner.next();
                    System.out.println("Value of deleted Element at given index is in original Arraylist of Integers: "+originalArraylistNumbers.remove(Integer.valueOf(dataNum)));
                    System.out.println("Value of deleted Element at given index is in custom   Arraylist of Integers: "+ customArraylistNumbers.remove(Integer.valueOf(dataNum)));
                    System.out.println("Value of deleted Element at given index is in original Arraylist of String  : "+originalArraylistNames.remove(dataName));
                    System.out.println("Value of deleted Element at given index is in custom   Arraylist of String  : "+ customArraylistNames.remove(dataName));
                    break;
                case 99:
                    System.out.println("Thanks");
                    break;

            }

        }while(choice !=99);
    }
    public static void displayArraylist(ArrayList<Integer> originalArraylistNumbers, CustomGenericArraylist<Integer> customArraylistNumbers,ArrayList<String> originalArraylistNames, CustomGenericArraylist<String> customArraylistNames)
    {
        System.out.print("Numbers in Original arraylist is: ");
        for(int i=0;i<originalArraylistNumbers.size();i++)
            System.out.print("   "+originalArraylistNumbers.get(i));
        System.out.println("\n-----------------------------");
        System.out.print("Numbers in Custom arraylist is: ");
        for(int i = 0; i< customArraylistNumbers.getSize(); i++)
            System.out.print("   "+ customArraylistNumbers.elements[i]);
        System.out.println("\n----------==================-------------------");
        System.out.print("Names in Original arraylist is: ");
        for(int i=0;i<originalArraylistNumbers.size();i++)
            System.out.print("   "+originalArraylistNames.get(i));
        System.out.println("\n-----------------------------");
        System.out.print("Names in Custom arraylist is: ");
        for(int i = 0; i< customArraylistNames.getSize(); i++)
            System.out.print("   "+ customArraylistNames.elements[i]);
    }
}

