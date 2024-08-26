package btvn_b7;

import btvn_b7.entities.BizStudent;
import btvn_b7.entities.ItStudent;
import btvn_b7.service.BizStudentService;
import btvn_b7.service.ItStudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeBiz;
        do {
            System.out.println("Nhap so sinh vien BizStudent: ");
            sizeBiz = Integer.parseInt(scanner.nextLine());
            if(sizeBiz>0){
                BizStudentService bizStudentService = new BizStudentService();
                BizStudent[] bizStudents = bizStudentService.inputBitStudent(scanner, sizeBiz);
                bizStudentService.outputBitStudent(bizStudents);
            }else {
                System.out.println("Ban can nhap so luong sinh vien lon hon 0");
            }
        }while (sizeBiz<0);

        int sizeIt;
        do {
            System.out.println("Nhap so sinh vien ItStudent: ");
             sizeIt = Integer.parseInt(scanner.nextLine());
             if(sizeIt>0){
                 ItStudentService itStudentService = new ItStudentService();
                 ItStudent[] itStudents = itStudentService.inputItStudents(scanner,sizeIt);
                 itStudentService.outputItStudent(itStudents);
             }else {
                 System.out.println("Ban can nhap so luong sinh vien lon hon 0");
             }
        }while (sizeIt<0);


    }
}