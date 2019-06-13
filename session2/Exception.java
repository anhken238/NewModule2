package session2;

import java.util.Scanner;
public class Exception {
    public static double Triangle(double side1, double side2, double side3) {

        if (side1 <= 0 || (side1 + side2) < side3 || (side1 + side3) < side2) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else if (side2 <= 0 || (side2 + side3) < side1) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else if (side3 <= 0) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else {
            throw new IllegalArgumentException("Valid Triangle Side Numbers");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Three Double Side: ");

        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        try {
            double result = Triangle(side1, side2, side3);
            System.out.println("Valid triangle sides");
        } catch (java.lang.Exception e) {
            System.out.println("Exception: Invalid Triangle Side Numbers");
        }
    }
}
