//Name : Apoorv Gupta
//PRN: 21070126018

import java.util.*;
import java.math.*;

// Problem statement:

public class As_5_abstract_implements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle: ");
        double radius = sc.nextDouble();
        System.out.println("Enter the length and breadth of rectangle: ");
        double length = sc.nextDouble();
        double breadth = sc.nextDouble();
        System.out.println("Enter the sides of triangle: ");
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        circle c = new circle(radius);
        rectangle r = new rectangle(length, breadth);
        triangle t = new triangle(side1, side2, side3);
        System.out.println(c);
        System.out.println(r);
        System.out.println(t);
    }
}

interface Shape{
    void calculateArea();
    void calculatePerimeter();
}

class circle implements Shape{
    double radius;
    double circleArea, circlePerimeter;
    circle(double radius){
        this.radius = radius;
    }
    public void calculateArea(){
        circleArea = Math.PI*radius*radius;
        System.out.println("Area of circle is: "+(circleArea));
    }
    public void calculatePerimeter(){
        System.out.println("Perimeter of circle is: "+(2*Math.PI*radius));
    }

    // toString() method
    public String toString(){
        return "Circle with radius: "+ radius +" and area: "+circleArea;
    }
}

class rectangle implements Shape{
    double length;
    double breadth;
    double rectangleArea, rectanglePerimeter;
    rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public void calculateArea(){
        rectangleArea = length*breadth;
        System.out.println("Area of rectangle is: "+(length*breadth));
    }
    public void calculatePerimeter(){
        rectangleArea = 2*(length+breadth);
        System.out.println("Perimeter of rectangle is: "+(2*(length+breadth)));
    }
    // to string
    public String toString(){
        return "Rectangle with length: "+length+" breadth: "+breadth+" and area: "+rectangleArea;
    }

}

class triangle implements Shape{
    double side1;
    double side2;
    double side3;
    double triangleArea, trianglePerimeter;
    triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public void calculateArea(){
        double s = (side1+side2+side3)/2;
        System.out.println("Area of triangle is: "+(Math.sqrt(s*(s-side1)*(s-side2)*(s-side3))));
        triangleArea = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
    public void calculatePerimeter(){
        System.out.println("Perimeter of triangle is: "+(side1+side2+side3));
        trianglePerimeter = side1+side2+side3;
    }
    // to string
    public String toString(){
        return "Triangle with sides: "+side1+" "+side2+" "+side3+" and area: "+triangleArea;
    }
}