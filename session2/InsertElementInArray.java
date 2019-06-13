package session2;

import java.util.Scanner;
public class InsertElementInArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chèn một phần tử vào mảng.");

        int k = 0;
        while(k < 10){
            System.out.println("nhập phần tử " + (k+1) +" của mảng là: ");
            array[k] = scanner.nextInt();
            k++;
        }

        System.out.println("nhập phần tử để chèn vào mảng : ");
        int x = scanner.nextInt();

        System.out.println("nhập vị trí cần chèn: ");
        int index = scanner.nextInt();
        if(index <= 1 || index >= 10){
            System.out.println("vị trí này không có trong mảng nên không thể chèn !");
            System.exit(0);
        }
        for( int i = 0; i < array.length; i++){
            if(i == index){
                array[i] = array[x];
                i++;
            }
        }
        for(int j = 0 ; j < array.length;j++)
            System.out.println(array[j]);
    }
}

