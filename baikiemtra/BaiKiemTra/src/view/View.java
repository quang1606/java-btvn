package view;

import entities.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private User currentLogGin;

    UserService userService = new UserService();
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
    private User handleLogin(Scanner scanner,  List<User> users) {
        User logGin = userService.logGin(scanner);
        if (userService.useNameExists(logGin.getUseName(),users)) {
            if (userService.checkPassword(users, logGin)) {
                return logGin;
            } else {
                System.out.println("Sai mật khẩu!");
                selectDisplayMenuLogGin(scanner, users, logGin);
            }
        } else {
            System.out.println("Kiểm tra lại username");
        }
        return null;
    }

    public void selectMenu(Scanner scanner, List<User> users) {
        do {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    currentLogGin = handleLogin(scanner, users);
                    if (currentLogGin != null) {
                        System.out.println("Chào mừng bạn " + currentLogGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                        selectDisplayMenuLogInSuccessfully(scanner,users);
                    }
                    break;
                case 2:
                    User user = userService.register(scanner,users);
                    users.add(user);

                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (true);
    }

    public void selectDisplayMenuLogGin(Scanner scanner, List<User> users, User logGin) {
        displayMenuLogGin();
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                    currentLogGin = handleLogin(scanner, users);
                if (currentLogGin != null) {
                    System.out.println("Chào mừng bạn " + currentLogGin.getUseName() + ", bạn có thể thực hiện công việc sau:");
                    selectDisplayMenuLogInSuccessfully(scanner,users);
                }
                break;
            case 2:

                if(userService.forgetPassword(scanner, logGin, users)) {
                    System.out.println("Moi ban chon!");
                } else {
                    System.out.println("Chưa tồn tại tài khoản !");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }


    public void selectDisplayMenuLogInSuccessfully(Scanner scanner,  List<User> users){
        do {
            displayMenuLogInSuccessfully();
            int choice=Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    if (userService.useNameNew(scanner,currentLogGin,users)){
                        System.out.println("Đổi  useName thành công!");

                    }
                    break;
                case 2:
                    if (userService.emailNew(scanner,currentLogGin,users)){
                        System.out.println("Đổi email thành công!");
                    }
                    break;
                case 3:
                    if (userService.passWordNew(scanner,currentLogGin,users)){
                        System.out.println("Đổi  password thành công");
                    }
                    break;
                case 4:
                    currentLogGin = null;
                    System.out.println("Bạn đã đăng xuất thành công.");
                    selectMenu(scanner,users);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }while (true);
    }




}
