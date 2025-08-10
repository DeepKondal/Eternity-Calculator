package org.example;

import java.util.Scanner;

public class Main {
    public static double sinh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / 2.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("===== Eternity Calculator - sinh(x) =====");

        do {
            try {
                System.out.print("Enter a real number x: ");
                double x = scanner.nextDouble();

                if (x < -100 || x > 100) {
                    System.out.println("Input out of range [-100, 100]. Try again.");
                } else {
                    double result = sinh(x);
                    System.out.printf("sinh(%.6f) = %.6f\n", x, result);
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a real number.");
                scanner.next(); // clear the buffer
            }

            System.out.print("Do you want to compute another value? (yes/no): ");
            choice = scanner.next().toLowerCase();
        } while (choice.equals("yes") || choice.equals("y"));

        System.out.println("Goodbye!");
        scanner.close();
    }
}
