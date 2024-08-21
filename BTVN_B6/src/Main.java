import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhap vao so luong: ");
             size= Integer.parseInt(scanner.nextLine());
            if (size > 0) {
                Employee [] employees = new  Employee[size];
                intputEmplyee(scanner,size,employees);
                outputEmplyee(employees,size);

            }else {
                System.out.println("Ban can nhap so nguoi hop le!");
            }
        }while (size<0);



    }
    private static void intputEmplyee(Scanner scanner, int size, Employee[] employees){
            for(int i=0; i<size; i++){
                System.out.println("Nguoi lao dong thu "+(i+1));
                System.out.println("Nhap vao tuoi: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap vao ID: ");
                int id= Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap vao ten: ");
                String name= scanner.nextLine();
                System.out.println("nhap vao Experience: ");
                double experience = Double.parseDouble(scanner.nextLine());
                employees[i]= new Employee(age, id, name,experience);
            }
    }
    private static void outputEmplyee(Employee[] employees, int size){
        for(int i=0; i<size; i++){
            System.out.println("Nguoi lao dong thu "+(i+1)+" "+employees[i]);
        }
    }

}