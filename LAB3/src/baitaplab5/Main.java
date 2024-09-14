package baitaplab5;

import baitaplab5.entities.Pet;
import baitaplab5.entities.Sex;
import baitaplab5.entities.Type;
import baitaplab5.service.PetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetService petService =new PetService();
        List<Pet> pets = new ArrayList<>();

        pets.add(new Pet("Khong co", Type.CAT, "xinh xan", Sex.FEMALE, 3, "meo anh", "loki"));
        pets.add(new Pet("Khong co", Type.DOG, "thong minh", Sex.MALE, 2, "cho shiba", "shiro"));
        pets.add(new Pet("Khong co", Type.CAT, "de thuong", Sex.FEMALE, 1, "meo ba tu", "mimi"));
        pets.add(new Pet("Khong co", Type.CAT, "sac so", Sex.MALE, 4, "vet nuoc", "parrot"));
        pets.add(new Pet("Khong co", Type.CAT, "meo hoang", Sex.FEMALE, 2, "meo rung", "wildy"));
        pets.add(new Pet("Khong co", Type.DOG, "trung thanh", Sex.MALE, 5, "cho labrador", "buddy"));
        pets.add(new Pet("Khong co", Type.DOG, "hat hay", Sex.FEMALE, 3, "vet con", "tweetie"));
        pets.add(new Pet("Khong co", Type.CAT, "an nhieu", Sex.FEMALE, 6, "meo mun", "pinky"));
        pets.add(new Pet("Khong co", Type.DOG, "cao lon", Sex.MALE, 7, "cho becgie", "rex"));
        pets.add(new Pet("Khong co", Type.DOG, "nho nhan", Sex.FEMALE, 2, "chim hoang", "chirpy"));
        pets.add(new Pet("Khong co", Type.CAT, "lanh loi", Sex.FEMALE, 4, "meo vien", "tiger"));


        petService.pet(scanner,pets);

    }


}
