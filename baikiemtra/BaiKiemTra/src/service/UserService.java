package service;

import entities.User;
import utils.Constant;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    public User register(Scanner scanner, List<User> users) {
        String useName;
        do {
            System.out.println("Nhập usename: ");
            useName = scanner.nextLine();
            if (useNameExists(useName, users)) {
                System.out.println("UseName đã tồn tại!");
            } else {
                break;
            }
        } while (true);
        String email;
        do {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Email không hợp lệ!");
            } else if (emailExists(email, users)) {
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
        return new User(useName, passWord, email);
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(Constant.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean useNameExists(String useName, List<User> users) {
        for (User user : users) {
            if (user.getUseName().equals(useName)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailExists(String email, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
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

    public User logGin(Scanner scanner) {
        System.out.println("Nhập usename:");
        String useName = scanner.nextLine();
        System.out.println("Nhập password: ");

        String passWord = scanner.nextLine();
        return new User(useName, passWord, null);
    }

    public boolean checkPassword(List<User> users, User logGin) {
        for (User user : users) {
            if (user.getUseName().equals(logGin.getUseName()) && user.getPassWord().equals(logGin.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    private User findRegisterByUsername(List<User> users, User logGin) {
        for (User user : users) {
            if (user.getUseName().equals(logGin.getUseName())) {
                return user;
            }
        }
        return null;
    }

    public boolean forgetPassword(Scanner scanner, User logGin, List<User> users) {
        User user = findRegisterByUsername(users, logGin);
        System.out.println("Nhập email để xác nhận tài khoản: ");
        String email = scanner.nextLine();
        if (!user.getEmail().equals(email)) {
            return false;
        }
        String newPassword;
        boolean validPassword;
        do {
            System.out.println(" Nhập mật khẩu mới: ");
            newPassword = scanner.nextLine();
            validPassword = containsUppercaseOrSpecialChar(newPassword);
            if (!validPassword) {
                System.out.println("Password không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validPassword);
        user.setPassWord(newPassword);
        System.out.println("Đổi mật khẩu thành công. Đăng nhập lại.");
        return true;
    }

    public boolean useNameNew(Scanner scanner, User logGin, List<User> users) {
        User user = findRegisterByUsername(users, logGin);
        String useName;
        do {
            System.out.println("Nhập vào usename: ");
            useName = scanner.nextLine();
            if (useNameExists(useName, users)) {
                System.out.println("usename đã tồn tại");
            } else {
                user.setUseName(useName);
                logGin.setUseName(useName);
                break;
            }
        } while (true);
        return true;
    }

    public boolean emailNew(Scanner scanner, User logGin, List<User> users) {
        User user = findRegisterByUsername(users, logGin);
        String email;
        do {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Email không hợp lệ!");
            } else if (emailExists(email, users)) {
                System.out.println("Email đã tồn tại!");
            } else {
                user.setEmail(email);
                break;
            }
        } while (true);
        return true;
    }

    public boolean passWordNew(Scanner scanner, User logGin, List<User> users) {
        User user = findRegisterByUsername(users, logGin);
        String passWord;
        do {
            System.out.println("Nhập vào password: ");
            passWord = scanner.nextLine();

            if (!containsUppercaseOrSpecialChar(passWord)) {
                System.out.println("Password không hợp lệ!");
            } else {
                user.setPassWord(passWord);
                break;
            }

        } while (true);
        return true;
    }
}




