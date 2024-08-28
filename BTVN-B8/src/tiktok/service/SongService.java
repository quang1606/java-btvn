package tiktok.service;

import tiktok.entities.Song;

import java.util.Scanner;

public class SongService {
    public Song song(Scanner scanner){
        System.out.println("Nhap ID:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap ca si: ");
        String singer = scanner.nextLine();
        return new Song(id, name, singer);
    }

}
