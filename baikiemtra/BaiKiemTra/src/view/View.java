package view;

import entities.LogGin;
import entities.Register;
import service.LogGinService;
import service.RegisterService;

import java.util.List;
import java.util.Scanner;

public class View {
    private LogGin currentLogGin;
    RegisterService registerService = new RegisterService();
    LogGinService logGinService = new LogGinService();
    public void displayMenu(){
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký ");
    }
    public void displayMenuLogGin(){
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");
    }
    public void displayMenuLogInSuccessfully(){
        System.out.println("1 - Thay đổi usename");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("0 - Thoát chương trình");
    }
    private LogGin handleLogin(Scanner scanner, List<Register> registers) {
        LogGin logGin = logGinService.logGin(scanner);
        if (registerService.useNameExists(logGin.getUseName(),registers)) {
            if (logGinService.checkPassword(registers, logGin)) {
                return logGin;
            } else {
                System.out.println("Sai mật khẩu!");
                selectDisplayMenuLogGin(scanner, registers, logGin);
            }
        } else {
            System.out.println("Kiểm tra lại username");
        }
        return null;
    }


    public void selectMenu(Scanner scanner, List<Register> registers) {
        do {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    currentLogGin = handleLogin(scanner, registers);
                    if (currentLogGin != null) {
                        System.out.println("Chào mừng bạn " + currentLogGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                        selectDisplayMenuLogInSuccessfully(scanner,registers);
                    }
                    break;
                case 2:
                    Register register = registerService.register(scanner, registers);
                    registers.add(register);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (true);
    }

    public void selectDisplayMenuLogGin(Scanner scanner, List<Register> registers, LogGin logGin) {
        displayMenuLogGin();
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                    currentLogGin = handleLogin(scanner, registers);
                if (currentLogGin != null) {
                    System.out.println("Chào mừng bạn " + currentLogGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                    selectDisplayMenuLogInSuccessfully(scanner,registers);
                }
                break;
            case 2:

                if(logGinService.forgetPassword(scanner, logGin, registers)) {
                    System.out.println("Moi ban chon!");
                } else {
                    System.out.println("Chưa tồn tại tài khoản !");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }


    public void selectDisplayMenuLogInSuccessfully(Scanner scanner, List<Register>registers){
        do {
            displayMenuLogInSuccessfully();
            int choice=Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    if (logGinService.useNameNew(scanner,currentLogGin,registers)){
                        System.out.println("Đổi  useName thành công!");

                    }
                    break;
                case 2:
                    if (logGinService.emailNew(scanner,currentLogGin,registers)){
                        System.out.println("Đổi email thành công!");
                    }
                    break;
                case 3:
                    if (logGinService.passWordNew(scanner,currentLogGin,registers)){
                        System.out.println("Đổi  password thành công");
                    }
                    break;
                case 4:
                    currentLogGin = null;
                    System.out.println("Bạn đã đăng xuất thành công.");
                    selectMenu(scanner,registers);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }while (true);
    }




}
