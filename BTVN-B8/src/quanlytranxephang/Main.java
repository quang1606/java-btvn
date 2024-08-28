package quanlytranxephang;

import quanlytranxephang.entities.SommonRift;
import quanlytranxephang.service.SommomRiftService;
import tiktok.service.SongService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SommomRiftService sommomRiftService = new SommomRiftService();
        SommonRift sommonRift = sommomRiftService.songService(scanner);
        System.out.println(sommonRift);
    }
}
