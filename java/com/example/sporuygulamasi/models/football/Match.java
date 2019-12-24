package com.example.sporuygulamasi.models.football;

import java.io.Serializable;
import java.util.Random;

public class Match implements Serializable {
    private Teams homeTeam;
    private Teams awayTeam;
    private int goalHome;
    private int goalAway;
    private boolean isOver;

    public Match(Teams homeTeam, Teams awayTeam) {
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
        double thisMatchTotalPowerHome = random() * homeTeam.getAvgPower();// (0-64)aras�ndan rastgele bir sayi
        double thisMatchTotalPowerAway = random() * awayTeam.getAvgPower();
        System.out.println("buMaclikToplamGucHome " + thisMatchTotalPowerHome + " vs buMaclikToplamGucAway "
                + thisMatchTotalPowerAway);
        // /////

        double atkHome = thisMatchTotalPowerHome * homeTeam.getAvgAttack() / 100;
        atkHome = random() * atkHome;
        System.out.println("atkHome: " + atkHome);// ev sahibi hucum gucu(50) rakip savunma gucu (40) 20 uzer�nden
        // hesaplarsak %50
        // den 10 basar�l� attack olma ihtimali

        double defHome = thisMatchTotalPowerHome * homeTeam.getAvgDefense() / 100;
        defHome = random() * defHome;
        System.out.println("defHome: " + defHome);

        // ///
        double atkAway = thisMatchTotalPowerAway * awayTeam.getAvgAttack() / 100;
        atkAway = random() * atkAway;
        System.out.println("atkAway: " + atkAway);

        double defAway = thisMatchTotalPowerAway * awayTeam.getAvgDefense() / 100;
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
        goalAway = goalAway * (100 - defHome) / 100;

        goalAway = random() * goalAway;
        System.out.println("goalAway: " + goalAway);
        // gol ihtimallerini yazd�rma

        this.goalHome = (int) Math.round(goalHome);
        this.goalAway = (int) Math.round(goalAway);
        homeTeam.matchEnded(this.goalHome, this.goalAway);
        awayTeam.matchEnded(this.goalAway, this.goalHome);

    }

    public void print() {
        if (isOver) {
            System.out.println(
                    homeTeam.getName() + " " + this.goalHome + " vs " + this.goalAway + " " + awayTeam.getName());
        } else {
            System.out.println(homeTeam.getName() + " vs " + awayTeam.getName());
        }
    }

    private double random() {
        return new Random().nextDouble();
    }

    public Teams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Teams homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Teams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Teams awayTeam) {
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
        return getHomeTeam().getName()+" ->"+getGoalHome()+"  "+ "vs"+"  " +getGoalAway()+"->"+getAwayTeam().getName();
    }
}