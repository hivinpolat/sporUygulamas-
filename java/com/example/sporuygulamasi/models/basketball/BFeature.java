package com.example.sporuygulamasi.models.basketball;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import com.example.sporuygulamasi.models.basketball.Enum.Positions;

public class BFeature implements Serializable {
    private int value;
    private int penal;// ceza puanını hesaplama
    private List<Positions> positions;

    public BFeature(List<Positions> positions) {
        this.positions = positions;
    }

    public void calculateValue(Positions playerPosition) {
        int low = 150;
        int high = 500;
        if (this.positions != null) {
            boolean contains = this.positions.contains(playerPosition);
            low = contains ? 300 : 150;
            high = contains ? 500 : 400;
        }
        Random rnd = new Random();
        this.value = rnd.nextInt(high - low) + low;

    }

    public void calculatePenalty(Positions playerPosition) {
        int low = -54;
        int high = -10;
        if (this.positions != null) {
            boolean contains = this.positions.contains(playerPosition);
            low = contains ? -30 : -54;
            high = contains ? -10 : -20;
        }
        Random rnd = new Random();
        this.penal = rnd.nextInt(high - low) + low;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPenal() {
        return penal;
    }

    public void setPenal(int penal) {
        this.penal = penal;
    }

    public List<Positions> getPositions() {
        return positions;
    }

    public void setPositions(List<Positions> positions) {
        this.positions = positions;
    }

}