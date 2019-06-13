package session2;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        double money=1.0;
        int month=1;
        double interset_rate = 1.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền vay");
        money = sc.nextDouble();
        System.out.println("Nhập số tháng vay");
        month = sc.nextInt();
        System.out.println("Nhập lãi suất tiền vay");
        interset_rate = sc.nextDouble();
        for(int i=0;i<month;i++){
            interset_rate = money * (interset_rate/100)/12 * 3;
        }
        System.out.println("Tiền lãi là : " + interset_rate);
    }
}
