package baitaplab4;

import baitaplab4.view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.selectDisplayMenuFunction(scanner);
    }
}
