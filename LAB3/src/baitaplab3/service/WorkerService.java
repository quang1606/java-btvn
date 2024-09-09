package baitaplab3.service;

import baitaplab3.data.Database;
import baitaplab3.entities.Worker;

import java.util.Scanner;

public class WorkerService {
    public Worker worker (Scanner scanner){
        System.out.println("Nhap vao ten: ");
        String name = scanner.nextLine();
        int age;
        double salary;
        do {
            System.out.println("Nhap vao tuoi: ");
            age =Integer.parseInt(scanner.nextLine());
            if (age < 0) {
                System.out.println("Tuoi khong hop le!");
            }

        }while (age<0);
       do {
               System.out.println("Nhap vao luong: ");
               salary = Double.parseDouble(scanner.nextLine());
               if (salary<0){
                   System.out.println("Tien luong khong hop le!");
               }
       }while (salary<0);
        System.out.println("Nhap vao noi lam viec: ");
        String workPlace = scanner.nextLine();
        Worker worker =new Worker(name,age,salary,workPlace);
        Database.workers.add(worker);
        return worker;
    }
    private boolean searchID (int id){
        for (Worker worker : Database.workers ){
            if(worker.getId()==id){
                return true;
            }
        }
        return false;
    }
    public void salaryIncrease(Scanner scanner , Worker worker){
        System.out.println("Nhap code cong nhan: ");
        int id = Integer.parseInt(scanner.nextLine());
        if(searchID(id)){
            System.out.println("Nhap so tien muon tang");
            double salaryUp = Double.parseDouble(scanner.nextLine());
            worker.setSalary(salaryUp+worker.getSalary());
        }else {
            System.out.println("Khong ton tai cong nhan !");
        }

    }
    public void salaryReduction(Scanner scanner , Worker worker) {
        System.out.println("Nhap code cong nhan: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap so tien muon giam");
        double salaryDown = Double.parseDouble(scanner.nextLine());
        if (searchID(id) && salaryDown <= worker.getSalary()) {
            worker.setSalary(worker.getSalary() - salaryDown);
        } else {
            System.out.println("Cong nhan khong ton tai or So tien khong hop le");
        }
    }
public void outPutword(){
        for (Worker worker : Database.workers){
            System.out.println(worker);
        }
}

}
