package quanlytranxephang.service;

import quanlytranxephang.entities.Name;

import java.util.Scanner;

public class NameService {
    public Name name(Scanner scanner){
        System.out.println("Nhap vao ten doi: ");
        String name =scanner.nextLine();
        return new Name(name);
    }
}
