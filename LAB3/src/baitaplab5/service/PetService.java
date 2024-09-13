package baitaplab5.service;

import baitaplab5.entities.Pet;
import baitaplab5.entities.Sex;
import baitaplab5.entities.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PetService {
    public void pet(Scanner scanner, List<Pet> pets){
        System.out.println("Nhap ten: ");
        String name= scanner.nextLine();
        System.out.println("Nhpa giong loai: ");
        String species = scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("""
                -- Mời b lựa chọn gioi tinhs---
                1 -  giong cai
                2 -  giong duc
                """);
        int choice = Integer.parseInt(scanner.nextLine());
        Sex sex = null;
        switch (choice) {
            case 1:
                sex = Sex.FEMALE;
                break;
            case 2:
                sex = Sex.MALE;
                break;
        }
        System.out.println("Gioi thieu: ");
        String description = scanner.nextLine();
        System.out.println("""
                -- Mời b lựa chọn loai---
                1 -  loai cho
                2 -  loai meo
                """);
        int choice1 = Integer.parseInt(scanner.nextLine());
        Type type = null;
        switch (choice1) {
            case 1:
                type = Type.DOG;
                break;
            case 2:
                type  = Type.CAT;
                break;
        }
        System.out.println("Anh: ");
        String images = scanner.nextLine();
        String choice3;
        do {
            search(type,sex,pets);
            System.out.println("Bạn có muốn tìm chú pet khác k?(Y/N)");
            choice3 =scanner.nextLine();
        }while (choice3.equalsIgnoreCase("y"));
    }
    public void outptu(List<Pet>pets){
        for (Pet pet: pets){
            System.out.println(pet);
        }
    }
    private void search (Type type, Sex sex, List<Pet> pets){
        List<Pet>petList = new ArrayList<>();
        for (Pet pet : pets){
            if(!pet.getSex().equals(sex)&& pet.getType().equals(type)){
               petList.add(pet);
            }
        }
        if(!petList.isEmpty()){
            Random random = new Random();
            int randomIndex= random.nextInt(petList.size());
            System.out.println(petList.get(randomIndex));
        }else {
            System.out.println("Khong con  loai phu hop!");
        }
    }
}
