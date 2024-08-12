import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class B7sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen : ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.println("tong trong cac truong hop la: " + n);
        } else {
            int sum = 1;
            for (int i = 2; i <= n; i++) {
                sum += i;


            }
            int sum2 = 1;
            int j = 2;
            System.out.println("Tong khi su dung vong lap for :" + sum);
            while (j <= n) {

                sum2 += j;
                j++;
            }
            System.out.println("Tong khi su dung vong lap while: " + sum2);

            int sum3 = 1;
            do {
                sum3 += n;
                n--;
            } while (n > 1);
            System.out.println("Tong khi su dung vong lap do-while: " + sum3);
        }

    }
}