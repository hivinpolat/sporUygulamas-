package com.example.sporuygulamasi.models.basketball;

import java.io.Serializable;
import java.util.Arrays;

import com.example.sporuygulamasi.models.basketball.Enum.Positions;

public class BPhysicalFeature implements Serializable {
    private BFeature gripStrength;
    private BFeature flexibility;
    private BFeature aerobicPower;
    private BFeature anaerobicPower;

    protected double getAvgPower() {

        return (gripStrength.getValue() + flexibility.getValue() + aerobicPower.getValue() + anaerobicPower.getValue())
                / 4;
    }

    protected double getAvgPenalty() {
        return (gripStrength.getPenal() + flexibility.getPenal() + aerobicPower.getPenal() + anaerobicPower.getPenal())
                / 4;
    }

    protected void generate(Positions playerPosition) {
        this.gripStrength = new BFeature(Arrays.asList(Positions.FORWARD, Positions.GUARD, Positions.POST));
        this.gripStrength.calculateValue(playerPosition);

        this.flexibility = new BFeature(Arrays.asList(Positions.FORWARD, Positions.GUARD, Positions.POST));
        this.flexibility.calculateValue(playerPosition);

        this.aerobicPower = new BFeature(Arrays.asList(Positions.FORWARD, Positions.GUARD, Positions.POST));
        this.aerobicPower.calculateValue(playerPosition);

        this.anaerobicPower = new BFeature(Arrays.asList(Positions.FORWARD, Positions.GUARD, Positions.POST));
        this.anaerobicPower.calculateValue(playerPosition);

    }

    public BFeature getGripStrength() {
        return gripStrength;
    }

    public void setGripStrength(BFeature gripStrength) {
        this.gripStrength = gripStrength;
    }

    public BFeature getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(BFeature flexibility) {
        this.flexibility = flexibility;
    }

    public BFeature getAerobicPower() {
        return aerobicPower;
    }

    public void setAerobicPower(BFeature aerobicPower) {
        this.aerobicPower = aerobicPower;
    }

    public BFeature getAnaerobicPower() {
        return anaerobicPower;
    }

    public void setAnaerobicPower(BFeature anaerobicPower) {
        this.anaerobicPower = anaerobicPower;
    }

}
