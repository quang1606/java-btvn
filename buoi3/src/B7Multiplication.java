import java.util.Scanner;

public class B7Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen : ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.println("tich trong cac truong hop la: " + n);
        } else {
            int mul = 1;
            for (int i = 2; i <= n; i++) {
                mul *= i;


            }
            System.out.println("Tich khi su dung vong lap for :" + mul);
            int mul2 = 1;
            int j = 2;

            while (j <= n) {

                mul2 *= j;
                j++;
            }
            System.out.println("Tich khi su dung vong lap while: " + mul2);

            int sum3 = 1;
            int m = 1;
            do {
                sum3 *= m;
                m++;
            } while (m <= n);
            System.out.println("Tich khi su dung vong lap do-while: " + sum3);
        }
    }
}

