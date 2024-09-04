import entities.Register;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Register> registers = new ArrayList<>();
        View view =new View();
        view.selectMenu(scanner,registers);
    }
}
