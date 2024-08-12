import java.util.Scanner;

public class B7evensum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen duong : ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n > 0) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }

            }
            System.out.println("Tong so nguyen duong dung vong lap for: " + sum);
            int sum2=0;
            int j=1;
           while (j<=n ){
               if(j%2==0) {
                   sum2 += j;
               }
               j++;
           }
            System.out.println("Tong khi su dung vong lap while: "+sum2);
           int sum3 =0;
            int m=0;
           do{
               if(m%2==0) {
                   sum3 += m;
               }
               m++;
           }while ( m<=n);
            System.out.println("Tong khi su dung vong lap do-while: "+sum3);
        } else {
            System.out.println("Ban da nhap sai. Vui long nhap lai so nguyen duong!");
        }



    }
}
