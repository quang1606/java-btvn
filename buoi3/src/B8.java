import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String answer;

        do {
            System.out.println("Moi ban nhap vao mot so nguyen: ");
            int n = Integer.parseInt(scanner.nextLine());
            sum += n;

            System.out.println("Ban co muon nhap tiep mot so khac? (Y de tiep tuc, bat ky phim nao de dung): ");
            answer = scanner.nextLine();
        } while (answer.equals("Y"));

        System.out.println("Tong cac so vua nhap la: " + sum);
    }
}

