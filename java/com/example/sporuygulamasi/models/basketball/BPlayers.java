package com.example.sporuygulamasi.models.basketball;

import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.Enum.Positions;

import java.io.Serializable;

public class BPlayers implements Serializable {

    private String name;
    private int year;
    private int weight;
    private int boy;
    private Positions position;

    private BPhysicalFeature pBFeature;
    private BMentalFeature mBFeature;
    // private BTechnicalFeature tBFeature;

    BPlayers(Positions position) {
        year = 18 + (int) Math.random() * 17;
        weight = 80 + (int) Math.random() * 95;
        boy = 180 + (int) Math.random() * 230;
        name = UtilMethods.nameCreation();
        this.position = position;
        pBFeature = generatePBfeature();
        mBFeature = generateMBfeature();
        // tBFeature = generateTBfeature();
    }

///

    private BMentalFeature generateMBfeature() {
        BMentalFeature mBFeature = new BMentalFeature();
        mBFeature.generate(this.position);
        return mBFeature;
    }

    private BPhysicalFeature generatePBfeature() {
        BPhysicalFeature pBFeature = new BPhysicalFeature();
        pBFeature.generate(this.position);
        return pBFeature;
    }

    //////
    public double getAvgGuc() {
        return (pBFeature.getAvgPower() + mBFeature.getAvgPower()) / 2;
    }

    public double getAvgFaul() {
        return (pBFeature.getAvgPenalty() + mBFeature.getAvgPenalty()) / 2;
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

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public BPhysicalFeature getpBFeature() {
        return pBFeature;
    }

    public void setpBFeature(BPhysicalFeature pBFeature) {
        this.pBFeature = pBFeature;
    }

    public BMentalFeature getmBFeature() {
        return mBFeature;
    }

    public void setmBFeature(BMentalFeature mBFeature) {
        this.mBFeature = mBFeature;
    }

}
