package com.example.sporuygulamasi.models.basketball;

import com.example.sporuygulamasi.models.basketball.BPlayers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.Enum.Positions;

public class BTeams implements Serializable {
    private List<BPlayers> basketbolcular = new ArrayList<BPlayers>();// 10 kişi
    private List<BPlayers> firstFive = new ArrayList<BPlayers>();// her takım 5 kişi
    private String name;
    private double avgForward;
    private double avgGuard;
    private double avgPost;
    private double avgPower;// ort guc //4 nun ortalaması
    private int matchPlayed;// oynanan mac sayısı
    private int goalScored;// atılan basket saysı
    private int goalLost;// yenilen basket sayısı//karşi tarıfın yaptıgı sayi
    private int point;// puan
    private int victory;// galibiyet
    private int defeat;// yenilgi
    private int equal;// beraberlik

    public BTeams(String isim) {

        this.name =isim;
        createPlayers();
    }

    private void createPlayers() {
        for (int i = 0; i < 12; i++) {
            if (i < 5) {
                basketbolcular.add(new BPlayers(Positions.FORWARD));
            }
            if (i >= 5 && i < 10) {
                basketbolcular.add(new BPlayers(Positions.GUARD));
            }
            if (i >= 10 && i < 12) {
                basketbolcular.add(new BPlayers(Positions.POST));
            }

        }
    }

    public void readyGame(boolean isHomeGame) {
        firstFive = CreatefirstFive();// 5 kisilik basketbol takımı olusturuluyor
        avgForward = calculateAvgForward();
        avgGuard = calculateAvgGuard();

        avgPower = ( avgGuard + avgForward) / 2;

    }

    public void matchEnded(int goalScored, int goalLost) {// mac sonuclandı metodu
        this.matchPlayed += 1;
        this.goalScored += goalScored;
        this.goalLost += goalLost;
        if (goalScored > goalLost) {
            this.point += 3;// gol attıysa 3 puan
            this.victory += 1;// galibiyet bir artırılıyor

        } else if (goalScored == goalLost) {// beraberlik durumu
            this.point += 1;
            this.equal += 1;

        } else {// yenilgi durumu
            this.defeat += 1;
        }
    }

    private List<BPlayers> CreatefirstFive() {
        List<BPlayers> forwarders = new ArrayList<BPlayers>(basketbolcular.subList(0, 5));
        List<BPlayers> guards = new ArrayList<BPlayers>(basketbolcular.subList(5, 10));
        List<BPlayers> posts = new ArrayList<BPlayers>(basketbolcular.subList(10, 12));

        List<BPlayers> firstFive = new ArrayList<BPlayers>();
        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                int index = new Random().nextInt(forwarders.size());
                BPlayers p = forwarders.get(index);
                firstFive.add(p);
            }
            if (i >= 2 && i < 4) {
                int index = new Random().nextInt(guards.size());
                BPlayers p = guards.get(index);
                firstFive.add(p);
                guards.remove(p);// aynu oyuncular gelmesin diye listeden cıkarıyoruz
            }
            if (i >= 4 && i < 5) {
                int index = new Random().nextInt(posts.size());
                BPlayers p = posts.get(index);
                firstFive.add(p);
                posts.remove(p);
            }
        }
        return firstFive;
    }



    private double calculateAvgGuard() {
        double total = 0;
        for (int i = 0; i < 3; i++) {
            BPlayers temp = firstFive.get(i);
            double power = temp.getAvgGuc();
            total += power;

        }
        return total / 3;
    }

    private double calculateAvgForward() {
        double total = 0;
        for (int i = 3; i < 5; i++) {
            BPlayers temp = firstFive.get(i);
            double power = temp.getAvgGuc();
            total += power;

        }
        return total / 2;
    }


    public List<BPlayers> getBasketbolcular() {
        return basketbolcular;
    }

    public void setBasketbolcular(List<BPlayers> basketbolcular) {
        this.basketbolcular = basketbolcular;
    }

    public List<BPlayers> getFirstFive() {
        return firstFive;
    }

    public void setFirstFive(List<BPlayers> firstFive) {
        this.firstFive = firstFive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgForward() {
        return avgForward;
    }

    public void setAvgForward(double avgForward) {
        this.avgForward = avgForward;
    }

    public double getAvgGuard() {
        return avgGuard;
    }

    public void setAvgGuard(double avgGuard) {
        this.avgGuard = avgGuard;
    }

    public double getAvgPost() {
        return avgPost;
    }

    public void setAvgPost(double avgPost) {
        this.avgPost = avgPost;
    }

    public double getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(double avgPower) {
        this.avgPower = avgPower;
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
    public int getAVG() {

        return goalScored - goalLost;
    }


}
