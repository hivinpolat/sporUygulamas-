package com.example.sporuygulamasi.UtilMethods;

import com.example.sporuygulamasi.models.football.Match;
import com.example.sporuygulamasi.models.football.Teams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UtilMethods {
    public  static HashMap<Integer,List<Match>> fixture=new HashMap<>();
    public static List<Teams> teams=new ArrayList<>();//takim listesini bircok yerde kullanıyoruz ama direkt adapter a gonderilemedi

    public static   String[] name(){
        String []names={"ALANYASPOR","ANTALYASPOR","ISTANBUL BASAKSEHIR","BESIKTAS","CAYKUR RIZESPOR","DENIZLISPOR",
                "FENERBAHCE","GALATASARAY","GAZISEHIR GAZIANTEP","GENCLERBIRLIGI","GOZTEPE","KASIMPASA","KAYSERISPOR",
                "KONYASPOR","MKE ANKARAGUCU","SIVASSPOR","TRABZONSPOR","YENI MALATYASPOR"};

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

