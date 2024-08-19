import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static final Account account = new Account("techmaster", "hoclacoviec", 10000000);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (authenticateUser(scanner)) {
            String answer;
            do {
                showMenu();
                int choice = getValidChoice(scanner);
                handleUserChoice(scanner, choice);

                answer = getYesNoInput(scanner, "Ban co muon tiep tuc? (Y/N): ");
            } while (answer.equalsIgnoreCase("Y"));
        } else {
            System.out.println("Tai khoan khong ton tai");
        }
    }

    private static boolean authenticateUser(Scanner scanner) {
        System.out.print("Nhap username: ");
        String inputUsername = scanner.nextLine().trim();
        System.out.print("Nhap vao password: ");
        String inputPassword = scanner.nextLine().trim();


        return inputUsername.equals(account.getUsename()) && inputPassword.equals(account.getPassword());
    }

    private static void showMenu() {
        System.out.println("Moi ban chon chuc nang!");
        System.out.println("1: Xem thong tin TK");
        System.out.println("2: Rut tien");
    }

    private static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                System.out.print("Lua chon cua ban: ");
                choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Lua chon khong hop le, vui long chon 1 hoac 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap so hop le!");
            }
        }
        return choice;
    }

    private static void handleUserChoice(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                showAccountInfo();
                break;
            case 2:
                withdrawMoney(scanner);
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private static void showAccountInfo() {

        System.out.println("Username: " + account.getUsename() +"Pasword: "+account.getPassword()+ ", Balance: " + account.getBalance() + " VND");
    }

    private static void withdrawMoney(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhap vao so tien muon rut: ");
                int money = Integer.parseInt(scanner.nextLine().trim());
                // Kiểm tra số dư tài khoản
                if (money <= account.getBalance() && money > 0) {
                    System.out.println("Ban da rut " + money + " VND vao luc: " + LocalDateTime.now());
                    // Sử dụng setter để cập nhật giá trị
                    account.setBalance(account.getBalance() - money);
                    break;
                } else {
                    System.out.println("So tien trong TK khong du!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap so tien hop le!");
            }
        }
    }

    private static String getYesNoInput(Scanner scanner, String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Vui long nhap Y hoac N.");
            }
        }
        return input;
    }
}
