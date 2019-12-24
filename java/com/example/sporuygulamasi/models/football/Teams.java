package com.example.sporuygulamasi.models.football;

import com.example.sporuygulamasi.models.football.Enum.Position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams implements Serializable {// tak�m�n de�i�kenleri tan�mland�.

    private List<Players> playerss = new ArrayList<Players>();
    private List<Players> firstEleven = new ArrayList<Players>();
    private String name;
    private Feature viewerPower;// seyirci gucu
    private double avgDefense;// ort savunma gucu
    private double avgAttack;// ort hucum gucu
    private double avgPower;// ort guc //4 nun ortalamas�
    private int matchPlayed;// oynanan mac say�s�
    private int goalScored;// at�lan gol says�
    private int goalLost;// yenilen gol say�s�
    private int point;// puan
    private int victory;// galibiyet
    private int defeat;// yenilgi
    private int equal;// beraberlik

    public Teams(String isim) {

        this.name =isim;
        createPlayers();
    }

    @Override
    public String toString() {
        return ((int) avgPower) + " " + name + "oynan mac: " + matchPlayed + " " + " galibiyet: " + victory + " "
                + " beraberlik: " + equal + " " + "maglubiyet:  " + defeat + " " + " attigi gol: " + goalScored + " "
                + "yenen gol: " + goalLost + " " + "averaj:" + (goalScored - goalLost) + " " + "puan: " + point;

    }

    public void createPlayers() {// 25 futbolcu oldugu icin futbolcular olusturuluyor
        for (int i = 0; i < 25; i++) {
            if (i < 3) {
                playerss.add(new Players(Position.CASTLE));
            }
            if (i >= 3 && i < 11) {
                playerss.add(new Players(Position.DEFENSE));
            }
            if (i >= 11 && i < 19) {
                playerss.add(new Players(Position.MİDFIELD));
            }
            if (i >= 19) {
                playerss.add(new Players(Position.ATTACK));
            }

        }
    }

    public void readyGame(boolean isHomeGame) {
        firstEleven = createfirstEleven();// 11 kisilik futbol tak�m� olusturuluyor
        viewerPower = new Feature(null);
        viewerPower.calculateValue(isHomeGame);// seyici gucunu hesaplamak icin feature da hesaplama yap�l�yor
        avgDefense = calculateAvgDefense();
        avgAttack = calculateAvgAttack();
        avgPower = (viewerPower.getValue() + avgDefense + avgAttack) / 3;

    }

    public void matchEnded(int goalScored, int goalLost) {// mac sonucland� metodu
        this.matchPlayed += 1;
        this.goalScored += goalScored;
        this.goalLost += goalLost;
        if (goalScored > goalLost) {
            this.point += 3;// gol att�ysa 3 puan
            this.victory += 1;// galibiyet bir art�r�l�yor

        } else if (goalScored == goalLost) {// beraberlik durumu
            this.point += 1;
            this.equal += 1;

        } else {// yenilgi durumu
            this.defeat += 1;
        }
    }

    private double calculateAvgAttack() {// ortalam hucum gucu hesaplaniyor
        double total = 0;
        for (int i = 5; i < 11; i++) {// kale al�nm�yor
            Players temp = firstEleven.get(i);// 11 ki�ilik tak�m oyncular� al�n�yor ve gecici bir de�i�kene atan�yor
            double power = temp.getAvgGuc();
            total += power;

        }
        return total / 6;
    }

    private double calculateAvgDefense() {
        double total = 0;
        for (int i = 0; i < 9; i++) {// kale al�n�yor
            Players temp = firstEleven.get(i);
            double power = temp.getAvgGuc();
            total += power;
        }
        return total / 9;
    }

    private List<Players> createfirstEleven() {

        List<Players> goalkeepers = new ArrayList<Players>(playerss.subList(0, 3));
        List<Players> defenders = new ArrayList<Players>(playerss.subList(3, 11));
        List<Players> midfieldPlayers = new ArrayList<Players>(playerss.subList(11, 19));
        List<Players> attackers = new ArrayList<Players>(playerss.subList(19, 25));

        List<Players> firstEleven = new ArrayList<Players>();
        for (int i = 0; i < 11; i++) {
            if (i < 1) {
                int index = new Random().nextInt(goalkeepers.size());
                Players p = goalkeepers.get(index);
                firstEleven.add(p);
            }
            if (i >= 1 && i < 5) {
                int index = new Random().nextInt(defenders.size());
                Players p = defenders.get(index);
                firstEleven.add(p);
                defenders.remove(p);// aynu oyuncular gelmesin diye listeden c�kar�yoruz
            }
            if (i >= 5 && i < 9) {
                int index = new Random().nextInt(midfieldPlayers.size());
                Players p = midfieldPlayers.get(index);
                firstEleven.add(p);
                midfieldPlayers.remove(p);
            }
            if (i >= 9 && i < 11) {
                int index = new Random().nextInt(attackers.size());
                Players p = attackers.get(index);
                firstEleven.add(p);
                attackers.remove(p);
            }
        }
        return firstEleven;
    }


    public List<Players> getPlayerss() {
        return playerss;
    }

    public void setPlayerss(List<Players> playerss) {
        this.playerss = playerss;
    }

    public List<Players> getFirstEleven() {
        return firstEleven;
    }

    public void setFirstEleven(List<Players> firstEleven) {
        this.firstEleven = firstEleven;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Feature getViewerPower() {
        return viewerPower;
    }

    public void setViewerPower(Feature viewerPower) {
        this.viewerPower = viewerPower;
    }

    public double getAvgDefense() {
        return avgDefense;
    }

    public void setAvgDefense(double avgDefense) {
        this.avgDefense = avgDefense;
    }

    public double getAvgAttack() {
        return avgAttack;
    }

    public void setAvgAttack(double avgAttack) {
        this.avgAttack = avgAttack;
    }

    public double getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(double avgPower) {
        this.avgPower = avgPower;
    }

    public int getAVG() {

        return goalScored - goalLost;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public int getGoalLost() {
        return goalLost;
    }

    public void setGoalLost(int goalLost) {
        this.goalLost = goalLost;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public int getEqual() {
        return equal;
    }

    public void setEqual(int equal) {
        this.equal = equal;
    }

}
