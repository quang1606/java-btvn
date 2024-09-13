package baitaplab4.view;

import baitaplab4.entities.Position;
import baitaplab4.entities.Staff;
import baitaplab4.service.StaffService;

import java.util.Scanner;

public class Menu {
    StaffService staffService = new StaffService();
 public void DisplayMenu(Scanner scanner){
     System.out.println("""
                -- Mời b lựa chọn chuc vu---
                1 -  nhan vien hanh chinh
                2 -  truong phong
                3 -  nhan vien sale
                """);


 }
    public void DisplayMenuFunction(Scanner scanner){
        System.out.println("""
                1 - Them nhan vien 
                2 - Xuat danh sach nhan vien
                3 - Xoa nhan vien
                4 - Cap nhat thong tin nhan vien
                5 - Tim nhan vien theo luong
                6 - Top 5 luong cao nhat
                7 - Xap xep nhan vien theo ten va thu nhap
                8 - Thoat khoi chuong trinh
                """);
        System.out.println("Mời b lựa chọn:");

    }
    public void selectDisplayMenuFunction(Scanner scanner){
     do {
         DisplayMenuFunction(scanner);
         int choice = Integer.parseInt(scanner.nextLine());
         switch (choice){
             case 1:
                 DisplayMenu(scanner);
                staffService.addStaff(scanner);
             break;
             case 2:
                staffService.outPutStaff();
                break;
             case 3:
                 staffService.deleteStaff(scanner);
                 break;
             case 4:
                 staffService.updateStaff(scanner);
                 break;
             case 5:
                 staffService.searchSalary(scanner);
                 break;
             case 6:
                 staffService.saveSortedStaffToAnotherArray();
                 break;
             case 7:
                 staffService.saveSortedStaffToAnotherArray1();
             case 8:
                 System.exit(0);
             default:
                 System.out.println("Chuc nang khong hop le!");
         }

     }while (true);
    }
}
