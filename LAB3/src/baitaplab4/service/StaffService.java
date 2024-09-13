package baitaplab4.service;

import baitaplab4.data.Database;
import baitaplab4.entities.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StaffService {
    AdministrativeStaffService administrativeStaffService = new AdministrativeStaffService();
    MarketingStaffService marketingStaffService = new MarketingStaffService();
    HeadOfDepartmentService headOfDepartmentService = new HeadOfDepartmentService();

    public void addStaff(Scanner scanner) {
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                Position administration = Position.ADMINISTRATION;
                Staff staff = new Staff(administrativeStaffService.addAdministrativeStaff(scanner), null, null, administration);
                Database.staff.add(staff);
                break;

            case 2:
                Position sales = Position.HEADOFDEPARTMENT;
                Staff staff1 = new Staff(headOfDepartmentService.addHeadOfDepartment(scanner), null, null, sales);
                Database.staff.add(staff1);
                break;
            case 3:
                Position marketingStaff = Position.SALES;
                Staff staff2 = new Staff(marketingStaffService.addMarketingStaff(scanner), null, null, marketingStaff);
                Database.staff.add(staff2);
                break;
        }
    }
    public void outPutStaff() {
        for (Staff staff : Database.staff) {
            System.out.println(staff);
        }
    }

    public void deleteStaff(Scanner scanner) {
        Staff staff = findStaff(scanner);
        if (staff != null) {
            Database.staff.remove(staff);
        } else {
            System.out.println("Khong tim thay nhan vien!");
        }
    }

    private Staff findStaff(Scanner scanner) {
        System.out.println("Mời b nhập id nhan vien muốn tim:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Staff staff : Database.staff) {
            if (staff.getId() == id) {
                return staff;
            }
        }
        return null;
    }
    public void updateStaff(Scanner scanner) {
        Staff staff = findStaff(scanner);
        if (staff != null) {
            System.out.println("""  
            -- Mời b lựa chọn chức vụ ---  
            1 - Nhân viên hành chính  
            2 - Trưởng phòng  
            3 - Nhân viên sale  
            """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    staff.setPosition(Position.ADMINISTRATION);
                    staff.setAdministrativeStaff(administrativeStaffService.addAdministrativeStaff(scanner));
                    staff.setMarketingStaff(null);
                    staff.setHeadOfDepartment(null);
                    break;
                case 2:
                    staff.setPosition(Position.HEADOFDEPARTMENT);
                    staff.setHeadOfDepartment(headOfDepartmentService.addHeadOfDepartment(scanner));
                    staff.setAdministrativeStaff(null);
                    staff.setMarketingStaff(null);
                    break;
                case 3:
                    staff.setPosition(Position.SALES);
                    staff.setMarketingStaff(marketingStaffService.addMarketingStaff(scanner));
                    staff.setAdministrativeStaff(null);
                    staff.setHeadOfDepartment(null);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } else {
            System.out.println("Không tìm thấy nhân viên!");
        }
    }

    public void searchSalary(Scanner scanner) {
        System.out.println("Nhập vào mức lương bạn muốn tìm: ");
        double targetSalary = Double.parseDouble(scanner.nextLine());
        boolean found = false;

        for (int i=0; i<Database.staff.size(); i++) {
            if (getSalary(Database.staff.get(i))==targetSalary) {
                System.out.println(Database.staff.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nhân viên nào với mức lương này.");
        }
    }


    // Phương thức trả về lương của từng nhân viên dựa trên chức vụ của họ
    public void saveSortedStaffToAnotherArray() {
        if (Database.staff == null || Database.staff.size() == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        // Sắp xếp danh sách theo lương giảm dần
       Collections.sort(Database.staff, new Comparator<Staff>() {
            @Override
            public int compare(Staff s1, Staff s2) {
                // So sánh lương của hai nhân viên theo thứ tự giảm dần
                return Double.compare(getSalary(s2), getSalary(s1));
            }
        });


        System.out.println("Top 5 nhan vien luong cao nhat!");
        int limit = Math.min(5, Database.staff.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(Database.staff.get(i));
        }
    }


    private double getSalary(Staff staff) {
        if (staff == null) {
            return 0.0; // Trả về 0 nếu nhân viên không tồn tại
        }

        if (staff.getAdministrativeStaff() != null) {
            return staff.getAdministrativeStaff().getSalary();
        } else if (staff.getHeadOfDepartment() != null) {
            return staff.getHeadOfDepartment().getSalary();
        } else if (staff.getMarketingStaff() != null) {
            return staff.getMarketingStaff().getSalary();
        }

        return 0.0; // Trả về 0 nếu không có thông tin lương
    }


    private String getFullName(Staff staff) {
        if (staff == null) {
            return null;
        }
        if (staff.getAdministrativeStaff() != null) {
            return staff.getAdministrativeStaff().getFullName();
        } else if (staff.getHeadOfDepartment() != null) {
            return staff.getHeadOfDepartment().getFullName();
        } else if (staff.getMarketingStaff() != null) {
            return staff.getMarketingStaff().getFullName();
        }

        return null;
    }
    private double getIncome(Staff staff){
        if (staff == null) {
            return 0; // Trả về 0 nếu nhân viên không tồn tại
        }
        if (staff.getAdministrativeStaff() != null) {
            return staff.getAdministrativeStaff().getIncome();
        } else if (staff.getHeadOfDepartment() != null) {
            return staff.getHeadOfDepartment().getIncome();
        } else if (staff.getMarketingStaff() != null) {
            return staff.getMarketingStaff().getIncome();
        }
        return 0;
    }
    public void saveSortedStaffToAnotherArray1() {
        if (Database.staff == null || Database.staff.size() == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        // Sắp xếp danh sách theo họ tên và thu nhập
        Collections.sort(Database.staff, new Comparator<Staff>() {
            @Override
            public int compare(Staff s1, Staff s2) {
                // So sánh theo họ tên trước
                int nameComparison = getFullName(s1).compareToIgnoreCase(getFullName(s2));

                // Nếu họ tên giống nhau thì so sánh theo thu nhập
                if (nameComparison == 0) {
                    return Double.compare(getIncome(s2), getIncome(s1)); // Sắp xếp thu nhập giảm dần
                }
                return nameComparison; // Sắp xếp họ tên tăng dần
            }
        });

        // Duyệt qua từng nhân viên và in ra thông tin chi tiết sau khi sắp xếp
        for (int i = 0; i < Database.staff.size(); i++) {
            Staff staff = Database.staff.get(i);
            System.out.println("Nhân viên thứ " + (i + 1) + ": " + staff);


        }
    }



}
