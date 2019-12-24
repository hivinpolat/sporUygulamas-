package com.example.sporuygulamasi.models.basketball;

import com.example.sporuygulamasi.models.basketball.Enum.Positions;

public abstract class BRootFeature {
    protected abstract void generate(Positions playerPosition);

    protected abstract double getAvgPower();
}
