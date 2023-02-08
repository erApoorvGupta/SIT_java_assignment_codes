// Name: Apoorv Gupta
// PRN: 21070126018
// Batch: AIML-A1

// Write a program to take input from command line arguments, scanner object, BufferedReader object, DataInputStream object, console object and perform the following operations:
// Calculator: Addition, Subtraction, Multiplication, Division, Square Root, Power, Mean, Variance using basic math based functions.


import java.util.Scanner;
import java.io.*;

public class As1_input_calculator {
    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException{
        {//commandline arguments
        // System.out.println("Input taken trough commandline arguments: ");
        // System.out.print("Enter a number: ");
        // int num1 = Integer.parseInt(args[0]);
        // System.out.println("Number entered (commandline): " + num1);

        //input option
        input_options.input();

        //calculator
        calculator.calculation();}

    }
}

class input_options {
    static void input() throws IOException{
        
        // scanner object
        Scanner sc = new Scanner(System.in);
        System.out.println("Input taken trough scanner object: ");
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Number entered (scanner): " + num);

        //BufferedReader object
        InputStreamReader r= new InputStreamReader(System.in);    
        BufferedReader br = new BufferedReader(r);
        System.out.println("Input taken trough BufferedReader object: ");
        System.out.print("Enter a number: ");
        String n = br.readLine();
        int num2 = Integer.parseInt(n);
        System.out.println("Number entered (BufferedReader): " + num2);
        
        //DataInputStream object
        DataInputStream data = new DataInputStream(System.in);
        System.out.println("Input taken trough DataInputStream object: ");
        System.out.print("Enter a number: ");
        int num3 = Integer.parseInt(data.readLine());
        System.out.println("Number entered (DataInputStream): " + num3);

        //console object
        Console c = System.console();
        System.out.println("Input taken trough console object: ");
        System.out.print("Enter a number: ");
        int num4 = Integer.parseInt(c.readLine());
        System.out.println("Number entered (console): " + num4);
    }
}


class calculator {
    static void calculation() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Mean");
            System.out.println("8. Variance");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 / num2));
                    break;
                case 5:
                    System.out.print("Enter number: ");
                    num1 = sc.nextDouble();
                    System.out.println("Result: " + Math.sqrt(num1));
                    break;
                case 6:
                    System.out.print("Enter base: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    int exponent = sc.nextInt();
                    System.out.println("Result: " + Math.pow(num1, exponent));
                    break;
                case 7:
                    double sum = 0;
                    int count = 0;
                    String input;
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        sum += Double.parseDouble(input);
                        count++;
                    }
                    System.out.println("Mean: " + (sum / count));
                    break;
                case 8:
                    sum = 0;
                    count = 0;
                    double mean = 0;
                    double variance = 0;
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        double num = Double.parseDouble(input);
                        sum += num;
                        count++;
                    }
                    mean = sum / count;
                    sc = new Scanner(System.in);
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        double num = Double.parseDouble(input);
                        variance += Math.pow((num - mean), 2);
                    }
                    variance = variance / count;
                    System.out.println("Variance: " + variance);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}