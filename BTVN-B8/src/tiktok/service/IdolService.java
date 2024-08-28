package tiktok.service;

import tiktok.entities.Follower;
import tiktok.entities.Idol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IdolService {
    FollowerService followerService = new FollowerService();

    public Idol idol(Scanner scanner) {
        List<Follower> followers = new ArrayList<>();
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap email: ");
        String email = scanner.nextLine();
        System.out.println("Nhap ten group: ");
        String group = scanner.nextLine();
        while (true) {
            System.out.println("Nhap thong tin follower: ");
            Follower follower = followerService.follower(scanner);
            followers.add(follower);
            System.out.println("Ban co muon tiep tuc nhap thong tin follower? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
        return new Idol(id,name,email,followers,group);
    }
}
