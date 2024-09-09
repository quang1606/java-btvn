package baitaplab4.service;

import baitaplab4.entities.AdministrativeStaff;

import java.util.Scanner;

public class AdministrativeStaffService {
    public AdministrativeStaff addAdministrativeStaff(Scanner scanner) {
        System.out.println("Nhap vao ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap vao luong: ");
        double salary = Double.parseDouble(scanner.nextLine());
        double income = totalIncome(salary);
        if (salary < 11000000) {
            int incomeTex = 0;
            return new AdministrativeStaff(name, salary, income, incomeTex);
        }
          double  incomeTex =totalIncomeTex(salary);
            return new AdministrativeStaff(name, salary, income,incomeTex);
    }
    public double totalIncome(double administrativeStaff){
        return administrativeStaff ;
    }
    public double totalIncomeTex(double administrativeStaff){
        return administrativeStaff*0.11;
    }
}
