package session2;

import java.util.Scanner;
public class ListStudentPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hiển thị giá trị nhỏ nhất trong mảng");
        int[] array;
        int size;

        do{
            System.out.println("số sinh viên cần nhập điểm là  : ");
            size = scanner.nextInt();
            if(size > 30) {
                System.out.println("Kích thước số nhập vào phải nhỏ hơn 30");
            }
        }while(size > 30);

        int i = 0;
        array =  new int[size];
        while(i < array.length){
            System.out.println("nhập điểm cho  sinh viên thứ  " + (i+1) +" là: ");
            array[i] = scanner.nextInt();
            i++;
        }

        int count = 0;
        System.out.print("Danh sách điểm: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n số sinh viên vượt qua kỳ thi là " + count);
    }
}

