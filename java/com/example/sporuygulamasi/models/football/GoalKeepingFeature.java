package com.example.sporuygulamasi.models.football;

import android.icu.text.Transliterator;

import com.example.sporuygulamasi.models.football.Enum.Position;

import java.util.Arrays;

public  class GoalKeepingFeature extends RootFeature {

    private Feature aerialAbility;
    private Feature commandOfArea;
    private Feature eccentricity;
    private Feature handling;
    private Feature kicking;
    private Feature reflexes;
    private Feature rushingOut;
    private Feature tendencyToPunch;
    private Feature throwing;

    public GoalKeepingFeature() {// constructor
        super();
    }

    @Override
    protected double getAvgPower() {
        return (aerialAbility.getValue() + commandOfArea.getValue() + eccentricity.getValue() + handling.getValue()
                + kicking.getValue() + reflexes.getValue() + rushingOut.getValue() + tendencyToPunch.getValue()
                + throwing.getValue()) / 9;
    }

    @Override
    protected void generate(Transliterator.Position playerPosition) {

    }

    @Override
    protected void generate(Position playerPosition) {
        this.aerialAbility = new Feature(Arrays.asList(Position.CASTLE));
        this.aerialAbility.calculateValue(playerPosition);

        this.commandOfArea = new Feature(Arrays.asList(Position.CASTLE));
        this.commandOfArea.calculateValue(playerPosition);

        this.eccentricity = new Feature(Arrays.asList(Position.CASTLE));
        this.eccentricity.calculateValue(playerPosition);

        this.handling = new Feature(Arrays.asList(Position.CASTLE));
        this.handling.calculateValue(playerPosition);

        this.kicking = new Feature(Arrays.asList(Position.CASTLE));
        this.kicking.calculateValue(playerPosition);

        this.reflexes = new Feature(Arrays.asList(Position.CASTLE));
        this.reflexes.calculateValue(playerPosition);

        this.rushingOut = new Feature(Arrays.asList(Position.CASTLE));
        this.rushingOut.calculateValue(playerPosition);

        this.tendencyToPunch = new Feature(Arrays.asList(Position.CASTLE));
        this.tendencyToPunch.calculateValue(playerPosition);

        this.throwing = new Feature(Arrays.asList(Position.CASTLE));
        this.throwing.calculateValue(playerPosition);
    }

    public Feature getAerialAbility() {
        return aerialAbility;
    }

    public void setAerialAbility(Feature aerialAbility) {
        this.aerialAbility = aerialAbility;
    }

    public Feature getCommandOfArea() {
        return commandOfArea;
    }

    public void setCommandOfArea(Feature commandOfArea) {
        this.commandOfArea = commandOfArea;
    }

    public Feature getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Feature eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Feature getHandling() {
        return handling;
    }

    public void setHandling(Feature handling) {
        this.handling = handling;
    }

    public Feature getKicking() {
        return kicking;
    }

    public void setKicking(Feature kicking) {
        this.kicking = kicking;
    }

    public Feature getReflexes() {
        return reflexes;
    }

    public void setReflexes(Feature reflexes) {
        this.reflexes = reflexes;
    }

    public Feature getRushingOut() {
        return rushingOut;
    }

    public void setRushingOut(Feature rushingOut) {
        this.rushingOut = rushingOut;
    }

    public Feature getTendencyToPunch() {
        return tendencyToPunch;
    }

    public void setTendencyToPunch(Feature tendencyToPunch) {
        this.tendencyToPunch = tendencyToPunch;
    }

    public Feature getThrowing() {
        return throwing;
    }

    public void setThrowing(Feature throwing) {
        this.throwing = throwing;
    }

}
