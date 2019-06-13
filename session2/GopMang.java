package session2;

import java.util.Scanner;
public class GopMang {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 ;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập giá trị của mảng 1");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Nhập giá trị của mảng 2");
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = sc.nextInt();
        }
//        size mảng 3 bằng size mảng 1 + size mảng 2
        int size = arr1.length + arr2.length;
        arr3 = new int[size];
//        gộp mảng 1 vào mảng 3
        for(int i = 0; i < arr1.length; i++){
            arr3[i]=arr1[i];
        }
//        gộp mảng 2 vào mảng 3
        for(int i = arr1.length; i < size; i++){
            arr3[i]=arr2[i-arr1.length];
        }
//        in mảng 3 ra
        for(int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i]+"\t");
        }
    }
}
