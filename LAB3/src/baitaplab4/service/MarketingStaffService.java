package baitaplab4.service;

import baitaplab4.entities.HeadOfDepartment;
import baitaplab4.entities.MarketingStaff;

import java.util.Scanner;

public class MarketingStaffService {
    public MarketingStaff addMarketingStaff(Scanner scanner){
        System.out.println("Nhap vao ten: ");
        String name= scanner.nextLine();
        System.out.println("Nhap vao luong: ");
        double salary =Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap vao doanh so ban hang: ");
        double sales = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap % vao hoa hong: ");
        double commissionRate = Double.parseDouble(scanner.nextLine());
        double income = totalIncome(salary,sales,commissionRate);
        if(income<11000000) {
            int incomeTex = 0;
            return new MarketingStaff(name, salary, income, incomeTex,commissionRate,sales);
        }
        double incomeTex = totalIncomeTex(salary,sales,commissionRate);

        return new MarketingStaff(name, salary, income, incomeTex,commissionRate,sales);

    }

    public double totalIncome(double salary,double sales,double commissionRate){
        return (salary+sales*(1+commissionRate)) ;
    }
    public double totalIncomeTex(double salary,double sales,double commissionRate){
        return(salary+sales*(1+commissionRate))*0.11;
    }
}
