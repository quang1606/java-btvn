package baitaplab3.service;

import baitaplab3.data.Database;
import baitaplab3.entities.Status;
import baitaplab3.entities.Worker;

import java.time.LocalDate;
import java.util.Scanner;

public class WorkerService {
    public Worker worker(Scanner scanner) {
        System.out.println("Nhap vao ten: ");
        String name = scanner.nextLine();
        int age;
        double salary;
        do {
            System.out.println("Nhap vao tuoi: ");
            age = Integer.parseInt(scanner.nextLine());
            if (age < 0) {
                System.out.println("Tuoi khong hop le!");
            }

        } while (age < 0);
        do {
            System.out.println("Nhap vao luong: ");
            salary = Double.parseDouble(scanner.nextLine());
            if (salary < 0) {
                System.out.println("Tien luong khong hop le!");
            }
        } while (salary < 0);
        System.out.println("Nhap vao noi lam viec: ");
        String workPlace = scanner.nextLine();
        Worker worker = new Worker(name, age, salary, workPlace);
        Database.workers.add(worker);
        return worker;
    }

    private Worker searchID(int id) {
        for (Worker worker : Database.workers) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    public void StatusUp(Scanner scanner) {
        System.out.println("Nhap code cong nhan: ");
        int id = Integer.parseInt(scanner.nextLine());
        Worker worker = searchID(id);
        if (worker != null) {
            System.out.println("Nhap so tien muon tang");
            double salaryUp = Double.parseDouble(scanner.nextLine());
            worker.setSalary(worker.getSalary()+salaryUp);
            Worker workerUp = new Worker(worker.getId(),worker.getName(), worker.getAge(), Status.UP, LocalDate.now(), salaryUp);
            Database.workerList.add(workerUp);
        }else {
            System.out.println("Khong tim thay con nhan!");
        }
    }

    public void StatusDown(Scanner scanner) {
        System.out.println("Nhap code cong nhan: ");
        int id = Integer.parseInt(scanner.nextLine());
        Worker worker = searchID(id);
        if (worker != null) {
            double salaryDown;
            do {
                System.out.println("Nhap so tien muon giam: ");
                salaryDown = Double.parseDouble(scanner.nextLine());
                if (salaryDown > worker.getSalary()) {
                    System.out.println("So tien khong hop le!");
                    continue;
                } else {
                    Worker workerDown = new Worker(worker.getId(), worker.getName(), worker.getAge(), Status.DOWN, LocalDate.now(), salaryDown);
                    Database.workerList.add(workerDown);
                }
            }while (salaryDown > worker.getSalary()) ;
        }
    }

    public void outPutword() {
        for (Worker worker : Database.workerList) {
            System.out.println(worker);
        }
    }
}
