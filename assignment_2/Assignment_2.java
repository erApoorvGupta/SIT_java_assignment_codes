// Name: Apoorv Gupta
// PRN: 21070126018
// Batch: AIML-A1

//Created 3 classes for each part:
// 1) Takes 10 numbers as input and gives sorted arrays as outputs.
// 2) Takes 10 numbers as inputs and finds smallest distance, returns the numbers and index of the first number.
// 3) Converts array into aaraylist and vice versa.



import java.util.Scanner;
import java.util.ArrayList;

public class As_2_array {
    public static void main(String arg[])
    {
        even_odd obj1 = new even_odd(); 
        obj1.accept();
        obj1.display();
        distance obj2 = new distance();
        obj2.smallest_distance();
        convert obj3 = new convert();
        obj3.array_list();
        obj3.array_list_2();
    }
}

class even_odd
{
    int even[] = new int[10];
    int odd[] = new int[10];
    int i, j, k;
    void accept()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        for(i = 0; i < 10; i++)
        {
            System.out.print("Enter a number: ");
            int a = obj.nextInt();
            if(a % 2 == 0)
            {
                even[j] = a;
                j++;
            }
            else
            {
                odd[k] = a;
                k++;
            }
        }
        System.out.println("\n");
    }
    void display()
    {
        System.out.println("Even numbers: ");
        for(i = 0; i < j; i++)
        {
            System.out.println(even[i]);
        }
        System.out.println("Odd numbers: ");
        for(i = 0; i < k; i++)
        {
            System.out.println(odd[i]);
        }
        System.out.println("\n");
    }
}


class distance 
{

    void smallest_distance() {
        Scanner obj = new Scanner(System.in);
        int a[] = new int[10];
        System.out.println("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a number: ");
            a[i] = obj.nextInt();
        }
        int i, j, min = 1000, index1 = 0, index2 = 0;
        for (i = 0; i < 10; i++) {
            for (j = i + 1; j < 10; j++) {
                if (Math.abs(a[i] - a[j]) < min) {
                    min = Math.abs(a[i] - a[j]);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("The 2 numbers with the smallest distance are: " + a[index1] + " and " + a[index2]);
        System.out.println("The index of the first number is: " + index1);

        System.out.println("\n");
    }
}


class convert
{
    void array_list()
    {
        System.out.println("Converting array to array list");
        int a[] = {1, 2, 3, 4, 5};
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++)
        {
            ar.add(a[i]);
        }
        System.out.println("Array list: "+ ar);
        System.out.println("\n");
    }

    void array_list_2()
    {
        //array list into array
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i= 0 ; i < 5; i++)
        {
            ar.add(i);
        }
        int a[] = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++)
        {
            a[i] = ar.get(i);
        }
        System.out.println("Converting array list to array");
        System.out.println("Array: " );
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
