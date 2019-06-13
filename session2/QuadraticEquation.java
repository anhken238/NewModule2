package session2;

import java.util.Scanner;

public class QuadraticEquation {
    private double a,b,c,delta;
    public QuadraticEquation(){}
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double  getDiscriminant(){
        return delta = b*b - 4*a*c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a : ");
        double a = scanner.nextDouble();
        System.out.println("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhập c: ");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant() > 0){
            System.out.println("Phương trình có 2 nghiệm");
        }
        else if(quadraticEquation.getDiscriminant() == 0){
            System.out.println("Phương trình có 1 nghiệm");
        }
        else System.out.println("phương trình vô nghiệm");
    }
}
