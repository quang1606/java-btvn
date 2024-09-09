package baitaplab4.service;

import baitaplab4.entities.AdministrativeStaff;
import baitaplab4.entities.HeadOfDepartment;

import java.util.Scanner;

public class HeadOfDepartmentService {

    public HeadOfDepartment addHeadOfDepartment(Scanner scanner){
        System.out.println("Nhap vao ten: ");
        String name= scanner.nextLine();
        System.out.println("Nhap vao luong: ");
        double salary =Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap vao luon trach nhiem: ");
        double responsibilitySalary = Double.parseDouble(scanner.nextLine());
        double income = totalIncome(salary,responsibilitySalary);
        if(income<11000000) {
            int incomeTex = 0;
            return new HeadOfDepartment(name, salary, income, incomeTex,responsibilitySalary);
        }
        double incomeTex = totalIncomeTex(salary,responsibilitySalary);

        return new HeadOfDepartment(name, salary, income, incomeTex,responsibilitySalary);

    }
    public double totalIncome(double salary,double responsibilitySalary){
        return (salary+responsibilitySalary) ;
    }
    public double totalIncomeTex(double salary,double responsibilitySalary){
        return(salary+responsibilitySalary)*0.11;
    }
}
