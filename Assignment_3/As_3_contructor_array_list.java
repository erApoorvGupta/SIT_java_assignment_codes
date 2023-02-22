// Name: Apoorv Gupta
// PRN: 21070126018
// Batch: AIML - A1

// Problem: Create a Student class describing attributes of a student like prn, name, DoB, marks etc. Create an array of objects of Student class and perform operations like: Add students, Display, Search (by prn, by name, by position), Update/Edit and Delete.

// Solution: Using private variables in a student class and using a student_functions class to perform operations on the student class such as add, display, search, update and delete. 2 classes are used to implement the solution.

import java.util.*;

public class As_3_contructor_array_list {
    public static void main(String[] args) 
    {
        student_functions student_functions_object = new student_functions();

        // menu for add, display, search, update, delete
        while(true){
            System.out.println("Select the operation to modify database: ");
            System.out.println("0. Exit");
            System.out.println("1. Add student details");
            System.out.println("2. Display all");
            System.out.println("3. Search student");
            System.out.println("4. Update Details");
            System.out.println("5. Delete record");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch(choice){
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    student_functions_object.add_student();
                    break;
                case 2:
                    student_functions_object.display();
                    break;
                case 3:
                    student_functions_object.search();
                    break;
                case 4:
                    student_functions_object.update();
                    break;
                case 5:
                    student_functions_object.delete();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (choice == 0){
                break;
            }
        }
    }
}

class student {
    private int prn;
    private String name;
    private String dob;
    private int marks;

    public student(int prn, String name, String dob, int marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class student_functions {
    ArrayList<student> student_list = new ArrayList<student>();


    public void print_student(int i)
    {
        System.out.print("Name: " + student_list.get(i).getName()+" | ");
        System.out.print("PRN: " + student_list.get(i).getPrn()+" | ");
        System.out.print("DOB: "+ student_list.get(i).getDob()+" | ");
        System.out.print("Marks: " +student_list.get(i).getMarks()+"  | \n\n");
    }

    public void add_student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students to be added: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of the student in the following format: PRN, Name, Date of Birth (dd/mm/yyyy), Marks");
            String details = sc.next();

            String[] details_array = details.split(",");
            int prn = Integer.parseInt(details_array[0]);

            String name = details_array[1];

            String dob_string = details_array[2];

            int marks = Integer.parseInt(details_array[3]);

            student new_student = new student(prn, name, dob_string, marks);
            student_list.add(new_student);
        }
    }

    public void display() {
        for (int i = 0; i < student_list.size(); i++) {
            print_student(i);
        }
    }

    public void search(){

        System.out.println("Select the search criteria: ");
        System.out.println("1. PRN");
        System.out.println("2. Name");
        System.out.println("3. Position");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                //Using contains method
                // System.out.println("Enter the PRN to be searched: ");
                // int temp_prn = sc.nextInt();
                // if(student_list.contains(temp_prn)){
                // int found = student_list.getPrn().indexOf(temp_prn);
                // print_student(found);
                // }
                // else{
                //     System.out.println("PRN not found");
                // }

                //OR 

                System.out.println("Enter the PRN to be searched: ");
                int prn = sc.nextInt();
                for (int i = 0; i < student_list.size(); i++) {
                    if (student_list.get(i).getPrn() == prn) {
                        print_student(i);
                    }
                }

                break;
            case 2:
                System.out.println("Enter the Name to be searched: ");
                String name = sc.next();
                for (int i = 0; i < student_list.size(); i++) {
                    if (student_list.get(i).getName() == name) {
                        print_student(i);
                    }
                }
                break;
            case 3: //position
                System.out.println("Enter the Position to be searched: ");
                int position = sc.nextInt();
                for (int i = 0; i < student_list.size(); i++) {
                    if (i == position) {
                        print_student(i);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    public void update(){
        System.out.println("Enter the PRN of the student to be updated: ");
        Scanner sc = new Scanner(System.in);
        int prn = sc.nextInt();

        for (int i = 0; i < student_list.size(); i++) {
            if (student_list.get(i).getPrn() == prn) {
                System.out.println("Enter the details of the student in the following format: PRN, Name, Date of Birth (dd/mm/yyyy), Marks");
                String details = sc.next();

                String[] details_array = details.split(",");
                int prn_new = Integer.parseInt(details_array[0]);

                String name_new = details_array[1];

                String dob_string_new = details_array[2];

                int marks_new = Integer.parseInt(details_array[3]);

                student new_student = new student(prn_new, name_new, dob_string_new, marks_new);
                student_list.set(i, new_student);
                print_student(i);
            }
        }
    }

    public void delete(){
        System.out.println("Enter the PRN of the student to be deleted: ");
        Scanner sc = new Scanner(System.in);
        int prn = sc.nextInt();

        for (int i = 0; i < student_list.size(); i++) {
            if (student_list.get(i).getPrn() == prn) {
                System.out.println("Student named:"+ student_list.get(i).getName() + " deleted successfully");
                student_list.remove(i);
            }
        }
    }

}
