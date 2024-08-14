import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("so hang mang 1: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("so co mang 1: ");
        int column = Integer.parseInt(scanner.nextLine());
        int arr[][] = new int[row][column];
        System.out.println("so hang mang 2: ");
        int row2 = Integer.parseInt(scanner.nextLine());
        System.out.println("so co mang 2: ");
        int column2 = Integer.parseInt(scanner.nextLine());
        int arr2[][] = new int[row2][column2];

        if (row == row2 && column == column2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print("arr[" + i + "][" + j + "] = ");
                    arr[i][j] = Integer.parseInt(scanner.nextLine());
                }
            }
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < column2; j++) {
                    System.out.print("arr2[" + i + "][" + j + "] = ");
                    arr2[i][j] = Integer.parseInt(scanner.nextLine());
                }
            }
            int sum[][]= new int[row][column];
            for(int i=0; i<row; i++){
                for(int j=0; j<column; j++){
                    sum[i][j]=arr[i][j]+arr2[i][j];
                    System.out.print(sum[i][j]+"\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("Khong the thuc hien!");
        }
    }
}