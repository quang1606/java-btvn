package btvn_b7.service;

import btvn_b7.entities.BizStudent;

import java.util.Scanner;

public class BizStudentService {
    public BizStudent[] inputBitStudent(Scanner scanner, int size){
        BizStudent[] bizStudents = new BizStudent[size];
        for(int i = 0; i < size; i++){
            double marketing, sales;
            do {
                System.out.println("Sinh vien thu "+(i+1)+":");
                System.out.println("Nhập tên: ");
                String name = scanner.nextLine();
                System.out.println("Nhập chuyên ngành: ");
                String major = scanner.nextLine();
                System.out.println("Nhập điểm marketing: ");
                marketing = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập điểm sales: ");
                sales = Double.parseDouble(scanner.nextLine());
                if (marketing>0 && sales>0) {
                    bizStudents[i] = new BizStudent(name, major, marketing, sales);
                }else {
                    System.out.println("Moi ban nhap so diem lon hon 0!");
                }
            }while (marketing<0 || sales<0);

        }
        return bizStudents;
    }

    public void outputBitStudent(BizStudent[] bizStudents){
        for (BizStudent bizStudent : bizStudents){
            System.out.println(bizStudent);
        }
    }
}