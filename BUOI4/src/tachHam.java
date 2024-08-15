 import java.util.Scanner;

public class tachHam {


    private int[][] NhapMang(int row, int column) {
        int[][] arr = new int[row][column];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        return arr;
    }


    private int[][] TinhTong(int[][][] arr, int row, int column) {
        int[][] sum = new int[row][column];

        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    sum[i][j] += arr[k][i][j];
                }
            }
        }
        return sum;
    }


    private void InMang(int[][] arr, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        tachHam tachham = new tachHam();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhap so mang: ");
        int soMang = Integer.parseInt(scanner.nextLine());

        int[][][] tongMang = new int[soMang][][];
        int[] rows = new int[soMang];
        int[] columns = new int[soMang];


        for (int i = 0; i < soMang; i++) {
            System.out.println("Nhap vao kich thuoc mang thu " + (i + 1) + ":");
            System.out.print("So hang: ");
            rows[i] = Integer.parseInt(scanner.nextLine());
            System.out.print("So cot: ");
            columns[i] = Integer.parseInt(scanner.nextLine());
            if (rows[i] < 1 || columns[i] < 1) {
                System.out.println("Ban da nhap sai ");
            } else {


                tongMang[i] = tachham.NhapMang(rows[i], columns[i]);
            }
        }



        boolean sameSize = true;
        for (int i = 1; i < soMang; i++) {
            if (rows[i] != rows[0] || columns[i] != columns[0]) {
                sameSize = false;
                break;
            }
        }

        if (sameSize) {
            int[][] sumMang = tachham.TinhTong(tongMang, rows[0], columns[0]);


            for (int i = 0; i < soMang; i++) {
                System.out.println("Mang thu " + (i + 1) + ":");
                tachham.InMang(tongMang[i], rows[i], columns[i]);
            }


            System.out.println("Mang tong la:");
            tachham.InMang(sumMang, rows[0], columns[0]);
        } else {
            System.out.println("Khong the tinh tong vi cac mang co kich thuoc khac nhau.");
        }
    }
}

