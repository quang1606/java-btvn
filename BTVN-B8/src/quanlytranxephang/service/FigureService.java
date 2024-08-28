package quanlytranxephang.service;

import quanlytranxephang.entities.Figure;

import java.util.Scanner;

public class FigureService {
    public Figure figure(Scanner scanner){
        System.out.println("Nhap ten tuong: ");
        String name = scanner.nextLine();
        System.out.println("Nhap chuc vu: ");
        String position =scanner.nextLine();
        return new Figure(name,position);
    }
}
