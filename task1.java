package ElevateLabs;

import java.util.Scanner;

public class task1 {

     public static double Addition (double a,double b) {
        return a+b;
    }

     public static double multiplication (double a,double b) {
        return a*b;
    }

     public static double division (double a,double b) {
        return a/b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        while (true) {
            System.out.println("Enter '1' if you want to do addition");
            System.out.println("Enter '2' if you want to do Multiplication");
            System.out.println("Enter '3' if you want to do Division");
            System.out.println("Enter '4' to exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter two numbers to add:");
                    double a1 = sc.nextDouble();
                    double b1 = sc.nextDouble();
                    System.out.println("Result: " + Addition(a1, b1));
                    break;
                case 2:
                    System.out.println("Enter two numbers to multiply:");
                    double a2 = sc.nextDouble();
                    double b2 = sc.nextDouble();
                    System.out.println("Result: " + multiplication(a2, b2));
                    break;
                case 3:
                    System.out.println("Enter two numbers to divide:");
                    double a3 = sc.nextDouble();
                    double b3 = sc.nextDouble();
                    if (b3 != 0) {
                        System.out.println("Result: " + division(a3, b3));
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                    break;
                case 4:
                    System.out.println("Calculations completed!! Exiting the Calculator");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}