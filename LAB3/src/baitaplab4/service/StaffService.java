package baitaplab4.service;

import baitaplab4.data.Database;

import baitaplab4.entities.Position;
import baitaplab4.entities.Staff;


import java.sql.SQLOutput;
import java.util.*;

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
                    break;
                case 2:
                    staff.setPosition(Position.HEADOFDEPARTMENT);
                    staff.setHeadOfDepartment(headOfDepartmentService.addHeadOfDepartment(scanner));
                    break;
                case 3:
                    staff.setPosition(Position.SALES);
                    staff.setMarketingStaff(marketingStaffService.addMarketingStaff(scanner));
                    break;
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
                if (staff.getAdministrativeStaff() != null && staff.getAdministrativeStaff().getSalary() == targetSalary) {
                    return true;
                } else {
                    return false;
                }
            case HEADOFDEPARTMENT:
                if (staff.getHeadOfDepartment() != null && staff.getHeadOfDepartment().getSalary() == targetSalary) {
                    return true;
                } else {
                    return false;
                }
            case SALES:
                if (staff.getMarketingStaff() != null && staff.getMarketingStaff().getSalary() == targetSalary) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static void swap(int i, int j) {
        Staff temp = Database.staff.get(i);
        Database.staff.set(i, Database.staff.get(j));
        Database.staff.set(j, temp);
    }

    // Phương thức sắp xếp nhân viên theo lương giảm dần và in ra kết quả
    public void saveSortedStaffToAnotherArray() {
        for (int i = 0; i < Database.staff.size() - 1; i++) {
            for (int j = 0; j < Database.staff.size()-i-1; j++) {
                if (getSalary(Database.staff.get(j)) < getSalary(Database.staff.get(j+1))) {
                    swap( j,j+1);

                }
            }
        }

        // In ra mảng đã sắp xếp
        System.out.println("Top 5 nhan vien luong cao nhat!");
        int limit = Math.min(5, Database.staff.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(Database.staff.get(i));
        }
    }

    // Phương thức trả về lương của từng nhân viên dựa trên chức vụ của họ
    private double getSalary(Staff staff) {
        switch (staff.getPosition()) {
            case ADMINISTRATION:
                if (staff.getAdministrativeStaff() != null) {
                    return staff.getAdministrativeStaff().getSalary();
                }
                break;
            case HEADOFDEPARTMENT:
                if (staff.getHeadOfDepartment() != null) {
                    return staff.getHeadOfDepartment().getSalary();
                }
                break;
            case SALES:
                if (staff.getMarketingStaff() != null) {
                    return staff.getMarketingStaff().getSalary();
                }
                break;
            default:
                return 0.0;
        }
        return 0.0;
    }

}


