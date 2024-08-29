package quanlytranxephang.service;

import quanlytranxephang.entities.Figure;
import quanlytranxephang.entities.Name;
import quanlytranxephang.entities.SommonRift;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SommomRiftService {
   FigureService figureService = new FigureService();
   NameService nameService = new NameService();
   public SommonRift songService (Scanner scanner){

       System.out.println(" Thoi gian tran dau: ");
       String time =scanner.nextLine();


       List<Figure>figures =new ArrayList<>();
       List<Name>names=new ArrayList<>();

       for (int dem1 = 1; dem1 <= 2; dem1++) {
           System.out.println("Nhập thông tin đội thứ " + dem1 + ": ");
           Name name = nameService.name(scanner);
           names.add(name);

           for (int dem2 = 1; dem2 <= 4; dem2++) {
               System.out.println("Nhập thông tin tướng thứ " + dem2 + ": ");
               Figure figure = figureService.figure(scanner);
               figures.add(figure);
           }
       }

      return new SommonRift(figures,time,names);
   }


}
