package service;

import entities.LogGin;
import entities.Register;

import java.util.List;
import java.util.Scanner;

public class LogGinService {
RegisterService registerService =new RegisterService();
       public LogGin logGin(Scanner scanner){
           System.out.println("Nhập usename:");
           String useName = scanner.nextLine();
           System.out.println("Nhập password: ");
           String passWord = scanner.nextLine();
           return new LogGin(useName,passWord);
       }

    public boolean checkPassword(List<Register> registers, LogGin logGin) {
        for (Register register : registers) {
            if (register.getUseName().equals(logGin.getUseName()) && register.getPassWord().equals(logGin.getPassWord())) {
                return true;
            }
        }
        return false;
    }
    private Register findRegisterByUsername(List<Register> registers, LogGin logGin) {
        for (Register register : registers) {
            if (register.getUseName().equals(logGin.getUseName())) {
                return register;
            }
        }
        return null;
    }
    public boolean forgetPassword(Scanner scanner, LogGin logGin, List<Register> registers) {
        Register register = findRegisterByUsername(registers, logGin);
        System.out.println("Nhập email để xác nhận tài khoản: ");
        String email = scanner.nextLine();
        if (!register.getEmail().equals(email)) {
            return false;
        }
        String newPassword;
        boolean validPassword;
        do {
            System.out.println(" Nhập mật khẩu mới: ");
            newPassword = scanner.nextLine();
            validPassword = registerService.containsUppercaseOrSpecialChar(newPassword);
            if (!validPassword) {
                System.out.println("Password không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validPassword);

        register.setPassWord(newPassword);
        System.out.println("Đổi mật khẩu thành công. Đăng nhập lại.");
        return true;
    }
    public boolean useNameNew(Scanner scanner, LogGin logGin, List<Register> registers){
        Register register = findRegisterByUsername(registers, logGin);
        String useName;
       do {
           System.out.println("Nhập vào usename: ");
           useName = scanner.nextLine();
           if(registerService.useNameExists(useName,registers)){
               System.out.println("usename đã tồn tại");
           }else {
               register.setUseName(useName);
               logGin.setUseName(useName);
               break;
           }

       }while (true);
       return true;
    }

    public boolean emailNew(Scanner scanner, LogGin logGin, List<Register> registers){
        Register register = findRegisterByUsername(registers, logGin);
        String email;
        do {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (!registerService.isValidEmail(email)) {
                System.out.println("Email không hợp lệ!");
            } else if (registerService.emailExists(email, registers)) {
                System.out.println("Email đã tồn tại!");
            }else {
                register.setEmail(email);
                break;
            }
    }while (true);
        return true;

}
    public boolean passWordNew(Scanner scanner, LogGin logGin, List<Register> registers){
        Register register = findRegisterByUsername(registers, logGin);
        String passWord;
        do {
            System.out.println("Nhập vào password: ");
            passWord = scanner.nextLine();

                if (!registerService.containsUppercaseOrSpecialChar(passWord)) {
                    System.out.println("Password không hợp lệ!");
                } else {
                     register.setPassWord(passWord);
                    break;
                }

        }while (true);
        return true;
    }
    }




