package com.example.sporuygulamasi.models.football;

import com.example.sporuygulamasi.models.football.Enum.Position;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Feature implements Serializable {
    private int value;
    private List<Position> positions;

    public Feature(List<Position> positions) {
        this.positions = positions;
    }

    public void calculateValue(boolean isHomeGame) {
        int low = isHomeGame ? 60 : 10;

        int high = isHomeGame ? 100 : 50;

        Random rnd = new Random();
        this.value = rnd.nextInt(high - low) + low;

    }

    public void calculateValue(Position playerPosition) {
        int low = 10;
        int high = 100;
        if (this.positions != null) {
            boolean contains = this.positions.contains(playerPosition);
            low = contains ? 60 : 10;
            high = contains ? 100 : 50;
        }
        Random rnd = new Random();
        this.value = rnd.nextInt(high - low) + low;

    }

    public int getValue() {
        return value;
    }

}
