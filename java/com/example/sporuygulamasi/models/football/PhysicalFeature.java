package com.example.sporuygulamasi.models.football;

import android.icu.text.Transliterator;

import com.example.sporuygulamasi.models.football.Enum.Position;

public class PhysicalFeature extends RootFeature {
    private Feature acceleration;
    private Feature agility;
    private Feature balance;
    private Feature jumpingReach;
    private Feature naturalFitness;
    private Feature pace;
    private Feature stamia;
    private Feature strength;

    public PhysicalFeature() {
        super();
    }

    @Override
    protected double getAvgPower() {
        return (acceleration.getValue() + agility.getValue() + balance.getValue() + jumpingReach.getValue()
                + naturalFitness.getValue() + pace.getValue() + stamia.getValue() + strength.getValue()) / 8;
    }

    @Override
    protected void generate(Transliterator.Position playerPosition) {
        
    }

    @Override
    protected void generate(Position playerPosition) {
        this.acceleration = new Feature(null);
        this.acceleration.calculateValue(playerPosition);

        this.agility = new Feature(null);
        this.agility.calculateValue(playerPosition);

        this.balance = new Feature(null);
        this.balance.calculateValue(playerPosition);

        this.jumpingReach = new Feature(null);
        this.jumpingReach.calculateValue(playerPosition);

        this.naturalFitness = new Feature(null);
        this.naturalFitness.calculateValue(playerPosition);

        this.pace = new Feature(null);
        this.pace.calculateValue(playerPosition);

        this.stamia = new Feature(null);
        this.stamia.calculateValue(playerPosition);

        this.strength = new Feature(null);
        this.strength.calculateValue(playerPosition);
    }

    public Feature getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Feature acceleration) {
        this.acceleration = acceleration;
    }

    public Feature getAgility() {
        return agility;
    }

    public void setAgility(Feature agility) {
        this.agility = agility;
    }

    public Feature getBalance() {
        return balance;
    }

    public void setBalance(Feature balance) {
        this.balance = balance;
    }

    public Feature getJumpingReach() {
        return jumpingReach;
    }

    public void setJumpingReach(Feature jumpingReach) {
        this.jumpingReach = jumpingReach;
    }

    public Feature getNaturalFitness() {
        return naturalFitness;
    }

    public void setNaturalFitness(Feature naturalFitness) {
        this.naturalFitness = naturalFitness;
    }

    public Feature getPace() {
        return pace;
    }

    public void setPace(Feature pace) {
        this.pace = pace;
    }

    public Feature getStamia() {
        return stamia;
    }

    public void setStamia(Feature stamia) {
        this.stamia = stamia;
    }

    public Feature getStrength() {
        return strength;
    }

    public void setStrength(Feature strength) {
        this.strength = strength;
    }
}