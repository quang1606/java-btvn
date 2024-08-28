package tiktok.service;

import tiktok.entities.Idol;
import tiktok.entities.Song;
import tiktok.entities.TikTok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TikTokService {
    SongService songService  =new SongService();
    IdolService idolService = new IdolService();
    public TikTok tikTok (Scanner scanner) {
        List<Idol> idols = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        while (true) {
            System.out.println("Nhap ten idol: ");
            Idol idol = idolService.idol(scanner);
            idols.add(idol);
            System.out.println("Ban co muon tiep tuc nhap ten idol? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap ten song: ");
            Song song = songService.song(scanner);
            songs.add(song);
            System.out.println("Ban co muon tiep tuc nhap ten bai hat? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
        return new TikTok(idols,songs);
    }
}
