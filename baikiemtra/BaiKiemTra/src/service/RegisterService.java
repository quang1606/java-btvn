package service;
import entities.Register;
import utils.Constant;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService {
    public Register register(Scanner scanner, List<Register> registers) {
        String useName;
        do {
            System.out.println("Nhập usename: ");
            useName = scanner.nextLine();
            if(useNameExists(useName,registers)){
                System.out.println("UseName đã tồn tại!");
            }else {
                break;
            }

        }while (true);

        String email;
        do {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Email không hợp lệ!");
            } else if (emailExists(email, registers)) {
                System.out.println("Email đã tồn tại!");
            } else {
                break;
            }
        } while (true);
        String passWord;
        do {
            System.out.println("Nhập password: ");
            passWord = scanner.nextLine();
            if (!containsUppercaseOrSpecialChar(passWord)) {
                System.out.println("Password không hợp lệ!");
            } else {
                break;
            }
        } while (true);
        return new  Register(useName, passWord, email);
    }

    public static boolean isValidEmail (String email){
        Pattern pattern =Pattern.compile(Constant.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean useNameExists(String useName, List<Register>registers){
        for (Register register : registers){
            if(register.getUseName().equals(useName)){
                return true;
            }
        }
        return false;
    }
    public boolean emailExists (String email, List<Register> registers){
        for(Register register : registers){
            if(register.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean isSpecialCharacter(char ch) {
        return !Character.isLetterOrDigit(ch);
    }

    public boolean containsUppercaseOrSpecialChar(String password) {
        int capitalLetters = 0;
        int specialCharacters = 0;
        if (password.length() >= 7 && password.length() <= 15) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    capitalLetters++;
                } else if (isSpecialCharacter(ch)) {
                    specialCharacters++;
                }
            }
            if (capitalLetters >= 1 && specialCharacters >= 1) {
                return true;
            }
        }

        return false;
    }

}
