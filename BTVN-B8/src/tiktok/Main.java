package tiktok;

import tiktok.entities.TikTok;
import tiktok.service.TikTokService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TikTokService tikTokService = new TikTokService();
        TikTok tikTok = tikTokService.tikTok(scanner);
        System.out.println(tikTok);
    }
}