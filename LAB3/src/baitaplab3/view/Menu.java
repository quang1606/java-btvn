package baitaplab3.view;

import baitaplab3.entities.Worker;
import baitaplab3.service.WorkerService;

import java.util.Scanner;

public class Menu {
    WorkerService workerService = new WorkerService();
    public void displayMenu(Scanner scanner){
        System.out.println("""
                1 - Them cong nhan
                2 - Tang luong
                3 - Giam luong
                4 - display information
                5 - Thoat chuong trinh""");
        System.out.println("Mời b lựa chọn:");
    }
    public void selectMenu(Scanner scanner){
        do {
            displayMenu(scanner);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Worker worker = workerService.worker(scanner);
                    selectMenu1(scanner,worker);
                    break;
                default:
                    System.out.println("Ban can them cong nhan de thuc hien chuc nang");

            }
        }while (true);

    }
    public void selectMenu1(Scanner scanner, Worker worker){
        do {
            displayMenu(scanner);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){

                case 1:
                    workerService.worker(scanner);

                    break;
                case 2:
                    workerService.StatusUp(scanner);
                    break;
                case 3:
                    workerService.StatusDown(scanner);
                    break;
                case 4:
                    workerService.outPutword();
                    break;
                case 5:
                    System.exit(0);

            }
        }while (true);

    }
}
