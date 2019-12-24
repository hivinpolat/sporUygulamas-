package com.example.sporuygulamasi.models.basketball;

import java.util.Random;

public class BMatch {
    private BTeams homeTeam;
    private BTeams awayTeam;
    private int goalHome;
    private int goalAway;
    private boolean isOver;

    public BMatch(BTeams homeTeam, BTeams awayTeam) {
        super();

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void ready() {
        homeTeam.readyGame(true);
        awayTeam.readyGame(false);
    }
    public void playMatch() {
        isOver = true;
        System.out.println(homeTeam.getAvgPower() + " " + homeTeam.getName() + " vs " + awayTeam.getName() + " "
                + awayTeam.getAvgPower());// isim ort vs isim ort
        double thisMatchTotalPowerHome = random() * homeTeam.getAvgPower();// (0-64)arasından rastgele bir sayi
        double thisMatchTotalPowerAway = random() * awayTeam.getAvgPower();
        System.out.println("buMaclikToplamGucHome " + thisMatchTotalPowerHome + " vs buMaclikToplamGucAway "
                + thisMatchTotalPowerAway);
        // /////

        double atkHome = thisMatchTotalPowerHome * homeTeam.getAvgForward() / 100;
        atkHome = random() * atkHome;
        System.out.println("atkHome: " + atkHome);// ev sahibi hucum gucu(50) rakip savunma gucu (40) 20 uzerınden
        // hesaplarsak %50
        // den 10 basarılı attack olma ihtimali

        double defHome = thisMatchTotalPowerHome * homeTeam.getAvgGuard() / 100;
        defHome = random() * defHome;
        System.out.println("defHome: " + defHome);

        // ///
        double atkAway = thisMatchTotalPowerAway * awayTeam.getAvgForward() / 100;
        atkAway = random() * atkAway;
        System.out.println("atkAway: " + atkAway);

        double defAway = thisMatchTotalPowerAway * awayTeam.getAvgGuard() / 100;
        defAway = random() * defAway;
        System.out.println("defAway: " + defAway);

        // ///
        atkHome = atkHome * (100 - defAway) / 100;// sayi1-sayi2
        System.out.println("atkHome: " + atkHome);

        // ///

        atkAway = atkAway * (100 - defHome) / 100;
        System.out.println("atkAway: " + atkAway);

        // ///
        double goalHome = random() * atkHome;// gol ihtimalleri
        goalHome = goalHome * (100 - defAway) / 100;

        goalHome = random() * goalHome;
        System.out.println("goalHome: " + goalHome);

        double goalAway = random() * atkAway;
        goalAway = goalAway * (100 - defHome)/ 100 ;

        goalAway = random() * goalAway;
        System.out.println("goalAway: " + goalAway);
        // gol ihtimallerini yazdırma

        this.goalHome = (int) Math.round(goalHome);
        this.goalAway = (int) Math.round(goalAway);
        homeTeam.matchEnded(this.goalHome, this.goalAway);
        awayTeam.matchEnded(this.goalAway, this.goalHome);

    }

    public void print() {
        if (isOver) {
            System.out.println(
                    homeTeam.getName() + "  " + this.goalHome + " vs " + this.goalAway + "  " + awayTeam.getName());
        } else {
            System.out.println(homeTeam.getName() + " vs " + awayTeam.getName());
        }
    }

    private double random() {
        return new Random().nextDouble();
    }

    public BTeams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(BTeams homeTeam) {
        this.homeTeam = homeTeam;
    }

    public BTeams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(BTeams awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getGoalHome() {
        return goalHome;
    }

    public void setGoalHome(int goalHome) {
        this.goalHome = goalHome;
    }

    public int getGoalAway() {
        return goalAway;
    }

    public void setGoalAway(int goalAway) {
        this.goalAway = goalAway;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

    @Override
    public String toString() {

        if (isOver) {
            return
                    homeTeam.getName() + " " + this.goalHome + " vs " + this.goalAway + " " + awayTeam.getName();
        } else {
            return  homeTeam.getName() + " vs " + awayTeam.getName();
        }

    }
}
