package btvn_b7.service;

import btvn_b7.entities.ItStudent;

import java.util.Scanner;

public class ItStudentService {
    public ItStudent[] inputItStudents(Scanner scanner, int sizeIt){
        ItStudent[] itStudents = new  ItStudent[sizeIt];
        for(int i=0; i<sizeIt; i++){
            double java, html, css;
            do {
                System.out.println("Sinh vien thu "+(i+1)+":");
                System.out.println("Nhập tên: ");
                String name = scanner.nextLine();
                System.out.println("Nhập chuyên ngành: ");
                String major = scanner.nextLine();
                System.out.println("Nhập điểm java: ");
                 java = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập điểm html: ");
                html = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập điểm css: ");
                 css = Double.parseDouble(scanner.nextLine());
                 if (java >0 && html>0&&css>0) {
                     itStudents[i] = new ItStudent(name, major, java, html, css);
                 }else {
                     System.out.println("Moi ban nhap so diem lon 0!");
                 }
            }while (java<0 || html<0 ||css<0);

        }
        return itStudents;

    }

    public void outputItStudent(ItStudent[] itStudents){
      for (ItStudent itStudent: itStudents){
          System.out.println(itStudent);
      }
    }
}
