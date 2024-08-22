package tinhdientichchuvi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HinhChuNhat hinhChuNhat = new HinhChuNhat();
        double length, width ;

        do {
            do {
                System.out.println("Nhap vao chieu dai: ");
                length = Double.parseDouble(scanner.nextLine());
                if (length <= 0) {
                    System.out.println("Chieu dai phai lon hon 0. Moi ban nhap lai.");

                }
            } while (length <= 0);
            do {
                System.out.println("Nhap vao chieu rong: ");
                width = Double.parseDouble(scanner.nextLine());
                if (width <=0) {
                    System.out.println("Chieu rong phai lon hon 0. Moi ban nhap lai.");
                }
            } while (width <= 0);
            if(length<=width){
                System.out.println("Nhap chieu dai phai lon hon chieu rong!");
            }
        }while (length<=width);




        System.out.println("Dien tich hinh chu nhat la: " + hinhChuNhat.dienTich(width, length));
        System.out.println("Chu vi hinh chu nhat la: " + hinhChuNhat.chuVi(width, length));

        HinhVuong hinhVuong = new HinhVuong();
        double side;
        do {
            System.out.println("Nhap vao canh hinh vuong: ");
            side = Double.parseDouble(scanner.nextLine());
            if (side <= 0) {
                System.out.println("Canh hinh vuong phai lon hon 0. Moi ban nhap lai.");
            }
        } while (side <=0);

        System.out.println("Dien tich hinh vuong la: " + hinhVuong.dienTich(side, side));
        System.out.println("Chu vi hinh vuong la: " + hinhVuong.chuVi(side, side));
    }
}
