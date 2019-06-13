package session2;

import java.util.Scanner;

public class DeleteElements {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chèn một phần tử vào mảng.");

        int k = 0;
        while (k < 10) {
            System.out.println("nhập phần tử " + (k + 1) + " của mảng là: ");
            array[k] = scanner.nextInt();
            k++;
        }

        System.out.println("nhập vị trí cần xóa: ");
        int x =  scanner.nextInt();
        int index=0;
        for (int i=0; i<array.length; i++){
            if(array[i]== array[x]){
                index = i;
            }
        }

        for (int i = index; i < array.length -1; i++){
            array[i] = array[i+1];
        }

        for(int j = 0 ; j < array.length;j++)
            System.out.println(array[j]);
    }
}
