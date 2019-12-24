package com.example.sporuygulamasi.models.football;

import android.icu.text.Transliterator;

import com.example.sporuygulamasi.models.football.Enum.Position;

import java.io.Serializable;

public abstract class RootFeature implements Serializable {
    protected abstract void generate(Position playerPosition);

    protected abstract double getAvgPower();

    protected abstract void generate(Transliterator.Position playerPosition);
}