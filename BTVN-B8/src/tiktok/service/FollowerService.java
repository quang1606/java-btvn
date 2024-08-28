package tiktok.service;

import tiktok.entities.Follower;

import java.util.Scanner;

public class FollowerService {
    public Follower follower(Scanner scanner){
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap ID: ");
        int id =Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Nhap so luot thich: ");
        int numberOfLike = Integer.parseInt(scanner.nextLine());
        return new Follower(id, name,numberOfLike,email);
    }
}
