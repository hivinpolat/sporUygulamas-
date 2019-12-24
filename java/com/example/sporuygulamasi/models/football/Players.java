package com.example.sporuygulamasi.models.football;


import com.example.sporuygulamasi.UtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.football.Enum.Position;

import java.io.Serializable;

public class Players implements Serializable {// futbolcunun de�i�kenleri tan�mland�.
    private String name;// random(buyuk harfla baslayacak.10 karakterli olacak.util metod icinde yapild�
    // .bircok yerde kullan�ld�g� icin
    private int year;// random(18-25)
    private Position position;
    private PhysicalFeature pFeature;
    private MentalFeature mFeature;
    private TechnicalFeature tFeature;
    private GoalKeepingFeature gFeature;

    Players(Position position) {// constructor

        year = 18 + (int) Math.random() * 17;
        name = UtilMethods.nameCreation();
        this.position = position;

        pFeature = generatePfeature();
        mFeature = generateMfeature();
        tFeature = generateTfeature();
        gFeature = generateGfeature();
    }

    public double getAvgGuc() {
        return (mFeature.getAvgPower() + pFeature.getAvgPower() + mFeature.getAvgPower() + gFeature.getAvgPower()) / 4;
    }

    ////////////////////////
    private TechnicalFeature generateTfeature() {
        TechnicalFeature tFeature = new TechnicalFeature();
        tFeature.generate(this.position);
        return tFeature;
    }

    private MentalFeature generateMfeature() {
        MentalFeature mFeature = new MentalFeature();
        mFeature.generate(this.position);
        return mFeature;
    }

    private PhysicalFeature generatePfeature() {
        PhysicalFeature pFeature = new PhysicalFeature();
        pFeature.generate(this.position);
        return pFeature;
    }

    private GoalKeepingFeature generateGfeature() {
        GoalKeepingFeature gFeature = new GoalKeepingFeature();
        gFeature.generate(this.position);

        return gFeature;
    }

    // sets,gets
    public PhysicalFeature getpFeature() {
        return pFeature;
    }

    public void setpFeature(PhysicalFeature pFeature) {
        this.pFeature = pFeature;
    }

    public MentalFeature getmFeature() {
        return mFeature;
    }

    public void setmFeature(MentalFeature mFeature) {
        this.mFeature = mFeature;
    }

    public TechnicalFeature gettFeature() {
        return tFeature;
    }

    public void settFeature(TechnicalFeature tFeature) {
        this.tFeature = tFeature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public GoalKeepingFeature getgFeature() {
        return gFeature;
    }

    public void setgFeature(GoalKeepingFeature gFeature) {
        this.gFeature = gFeature;
    }

}