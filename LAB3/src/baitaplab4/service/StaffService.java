package baitaplab4.service;

import baitaplab4.data.Database;

import baitaplab4.entities.Position;
import baitaplab4.entities.Staff;
import baitaplab4.view.Menu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffService {
    AdministrativeStaffService administrativeStaffService = new AdministrativeStaffService();
    MarketingStaffService marketingStaffService = new MarketingStaffService();
    HeadOfDepartmentService headOfDepartmentService = new HeadOfDepartmentService();
    public void addStaff(Scanner scanner){
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        Position administration= Position.ADMINISTRATION;
                        Staff staff = new Staff(administrativeStaffService.addAdministrativeStaff(scanner),null,null, administration);
                        Database.staff.add(staff);
                        break;

                    case 2:
                        Position sales= Position.HEADOFDEPARTMENT;
                        Staff staff1 = new Staff(headOfDepartmentService.addHeadOfDepartment(scanner),null,null, sales);
                        Database.staff.add(staff1);
                        break;
                    case 3:
                        Position marketingStaff = Position.SALES;
                        Staff staff2 = new Staff(marketingStaffService.addMarketingStaff(scanner),null,null, marketingStaff);
                        Database.staff.add(staff2);
                        break;
                }
    }
    public void outPutStaff(){
        for (Staff staff : Database.staff){
            System.out.println(staff);
        }
    }
    public void deleteStaff(Scanner scanner){
        Staff staff = findStaff(scanner);
        if(staff!=null){
            Database.staff.remove(staff);
        }else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }
    public void updateStaff(Scanner scanner){
        Staff staff = findStaff(scanner);
        if(staff!=null){
            System.out.println("""
                -- Mời b lựa chọn chuc vu---
                1 -  nhan vien hanh chinh
                2 -  truong phong
                3 -  nhan vien sale
                """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    staff.setPosition(Position.ADMINISTRATION);
                    staff.setAdministrativeStaff(administrativeStaffService.addAdministrativeStaff(scanner));
                case 2:
                    staff.setPosition(Position.HEADOFDEPARTMENT);
                    staff.setHeadOfDepartment(headOfDepartmentService.addHeadOfDepartment(scanner));
                case 3:
                    staff.setPosition(Position.SALES);
                    staff.setMarketingStaff(marketingStaffService.addMarketingStaff(scanner));
            }
        }else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }

      private Staff findStaff(Scanner scanner) {
        System.out.println("Mời b nhập id nhan vien muốn tim:");
        int id = Integer.parseInt(scanner.nextLine());
          for (Staff staff : Database.staff) {
            if (staff.getAdministrativeStaff().getId()==id){
                return staff;
            }
        }
          return null;
    }
    public void searchSalary(Scanner scanner) {
        System.out.println("Nhập vào mức lương bạn muốn tìm: ");
        double targetSalary = Double.parseDouble(scanner.nextLine());
        boolean found = false;

        for (Staff staff : Database.staff) {
            if (matchesSalary(staff, targetSalary)) {
                System.out.println(staff);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nhân viên nào với mức lương này.");
        }
    }

    private boolean matchesSalary(Staff staff, double targetSalary) {
        switch (staff.getPosition()) {
            case ADMINISTRATION:
                if(staff.getAdministrativeStaff() != null && staff.getAdministrativeStaff().getSalary() == targetSalary) {
                return true;
            }else {
                    return false;
                }
            case HEADOFDEPARTMENT:
                if(staff.getHeadOfDepartment() != null && staff.getHeadOfDepartment().getSalary() == targetSalary){
                return true;
            }else {
                    return false;
                }
            case SALES:
                if (staff.getMarketingStaff() != null && staff.getMarketingStaff().getSalary() == targetSalary){
                return true;
            }else {
                    return false;
                }
            default:
                return false;
        }
    }



}


