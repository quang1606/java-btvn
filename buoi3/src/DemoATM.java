import java.time.LocalDateTime;
import java.util.Scanner;

public class DemoATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "techmaster";
        String password = "hoclacoviec";
        int balance = 10000000;
        System.out.print("Nhap username: ");
        String usename1 = scanner.nextLine();
        System.out.print("Nhap vao password: ");
        String password1= scanner.nextLine();
        String answer;
        if(usename1.equals(username)&&password1.equals(password)){
            do {

                System.out.println("Moi ban chon chuc nang!");
                System.out.println("Chuc nang 1: xem thong tin TK ");
                System.out.println("Chuc nang 2: Rut tien ");
                int luachon= Integer.parseInt(scanner.nextLine());

                switch (luachon){
                    case 1:
                        System.out.println("usename: "+usename1+" password: "+password1+"balance: "+balance);
                        break;
                    case 2:
                        System.out.print("Nhap vao so tien muon rut: ");
                        int money = Integer.parseInt(scanner.nextLine());
                        if(money<=balance) {
                            System.out.println("Ban da rut tien vao luc: " + LocalDateTime.now());
                            balance=balance-money;
                        }else {
                            System.out.println("So tien trong TK khong du!");
                        }
                        break;
                    default:
                        System.out.println("Khong co luc chon nay, moi ban nhap lai");
                }


                    System.out.println("Ban co muon tiep tuc ?");
                    answer = scanner.nextLine();

            }while(answer.equals("Y"));
        }else {
            System.out.println("Tai khoan khong ton tai");
        }


    }
}
