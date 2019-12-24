package com.example.sporuygulamasi.BasketballUtilMethods;
import com.example.sporuygulamasi.models.basketball.BMatch;
import com.example.sporuygulamasi.models.basketball.BTeams;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UtilMethods {
    public  static HashMap<Integer,List<BMatch>> fixture=new HashMap<>();
    public static List<BTeams> teams=new ArrayList<>();//takim listesini bircok yerde kullanıyoruz ama direkt adapter a gonderilemedi

    public static   String[] name(){
        String []names={"Los Angeles Lakers","Golden State Warriors","Houston Rockets","Toronto Raptors","Boston Celtics","Dallas Mavericks",
                "Los Angeles Clippers","Miami Heat","Milwaukee Bucks","San Antonio Spurs","Philadelphia 76ers","New York Knicks","Chicago Bulls",
                "Portland Trail Blazers","New Orleans Pelicans","Utah Jazz","Denver Nuggets","Brooklyn Nets"};

        return names;
    }

    public static String nameCreation() {
        Random rnd = new Random();
        int rnd1 = rnd.nextInt(25) + 65;
        String name = new Character((char) rnd1).toString();
        for (int i = 1; i < 10; i++) {
            rnd1 = rnd.nextInt(26) + 96;
            if (rnd1 == 96)
                rnd1 += 3;
            name += new Character((char) rnd1).toString();
        }
        return name;
    }

}
