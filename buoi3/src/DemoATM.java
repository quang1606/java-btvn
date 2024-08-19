import java.time.LocalDateTime;
import java.util.Scanner;

public class DemoATM {

    private static final String USERNAME = "techmaster";
    private static final String PASSWORD = "hoclacoviec";
    private static int balance = 10000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (authenticateUser(scanner)) {
            String answer;
            do {
                showMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                handleUserChoice(scanner, choice);

                System.out.println("Ban co muon tiep tuc ? (Y/N)");
                answer = scanner.nextLine();
            } while (answer.equalsIgnoreCase("Y"));
        } else {
            System.out.println("Tai khoan khong ton tai");
        }
    }

    private static boolean authenticateUser(Scanner scanner) {
        System.out.print("Nhap username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Nhap vao password: ");
        String inputPassword = scanner.nextLine();

        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }

    private static void showMenu() {
        System.out.println("Moi ban chon chuc nang!");
        System.out.println("1: Xem thong tin TK");
        System.out.println("2: Rut tien");
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
                System.out.println("Khong co luc chon nay, moi ban nhap lai");
        }
    }

    private static void showAccountInfo() {
        System.out.println("Username: " + USERNAME + ", Balance: " + balance + " VND");
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Nhap vao so tien muon rut: ");
        int money = Integer.parseInt(scanner.nextLine());
        if (money <= balance && money>0) {
            System.out.println("Ban da rut " + money + " VND vao luc: " + LocalDateTime.now());
            balance -= money;
        } else {
            System.out.println("So tien rut khong hop le!");
        }
    }
}


