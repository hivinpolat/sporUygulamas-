package com.example.sporuygulamasi.models.football;
import android.icu.text.Transliterator;

import com.example.sporuygulamasi.models.football.Enum.Position;

import static java.util.Arrays.asList;

public class MentalFeature extends RootFeature {
    private Feature aggression;// savunma
    private Feature anticipation;
    private Feature bravery;// savunma
    private Feature composure;
    private Feature concentration;
    private Feature decisions;
    private Feature determination;
    private Feature flair;
    private Feature leadership;
    private Feature offTheBall;
    private Feature positioning;// savunma
    private Feature teamwork;
    private Feature vision;
    private Feature workRate;

    public MentalFeature() {
        super();
    }



    @Override
    protected double getAvgPower() {
        return (aggression.getValue() + anticipation.getValue() + bravery.getValue() + composure.getValue()
                + concentration.getValue() + decisions.getValue() + determination.getValue() + flair.getValue()
                + leadership.getValue() + offTheBall.getValue() + positioning.getValue() + teamwork.getValue()
                + vision.getValue() + workRate.getValue()) / 14;
    }

    @Override
    protected void generate(Transliterator.Position playerPosition) {

    }

    @Override
    protected void generate(Position playerPosition) {
        this.aggression = new Feature(asList(Position.DEFENSE));
        this.aggression.calculateValue(playerPosition);

        this.anticipation = new Feature(null);
        this.anticipation.calculateValue(playerPosition);

        this.bravery = new Feature(asList(Position.DEFENSE));
        this.bravery.calculateValue(playerPosition);

        this.composure = new Feature(null);
        this.composure.calculateValue(playerPosition);

        this.concentration = new Feature(null);
        this.concentration.calculateValue(playerPosition);

        this.decisions = new Feature(null);
        this.decisions.calculateValue(playerPosition);

        this.determination = new Feature(null);
        this.determination.calculateValue(playerPosition);

        this.flair = new Feature(null);
        this.flair.calculateValue(playerPosition);

        this.leadership = new Feature(null);
        this.leadership.calculateValue(playerPosition);

        this.offTheBall = new Feature(null);
        this.offTheBall.calculateValue(playerPosition);

        this.positioning = new Feature(asList(Position.DEFENSE));
        this.positioning.calculateValue(playerPosition);

        this.teamwork = new Feature(null);
        this.teamwork.calculateValue(playerPosition);

        this.vision = new Feature(null);
        this.vision.calculateValue(playerPosition);

        this.workRate = new Feature(null);
        this.workRate.calculateValue(playerPosition);
    }

    public Feature getAggression() {
        return aggression;
    }

    public void setAggression(Feature aggression) {
        this.aggression = aggression;
    }

    public Feature getAnticipation() {
        return anticipation;
    }

    public void setAnticipation(Feature anticipation) {
        this.anticipation = anticipation;
    }

    public Feature getBravery() {
        return bravery;
    }

    public void setBravery(Feature bravery) {
        this.bravery = bravery;
    }

    public Feature getComposure() {
        return composure;
    }

    public void setComposure(Feature composure) {
        this.composure = composure;
    }

    public Feature getConcentration() {
        return concentration;
    }

    public void setConcentration(Feature concentration) {
        this.concentration = concentration;
    }

    public Feature getDecisions() {
        return decisions;
    }

    public void setDecisions(Feature decisions) {
        this.decisions = decisions;
    }

    public Feature getDetermination() {
        return determination;
    }

    public void setDetermination(Feature determination) {
        this.determination = determination;
    }

    public Feature getFlair() {
        return flair;
    }

    public void setFlair(Feature flair) {
        this.flair = flair;
    }

    public Feature getLeadership() {
        return leadership;
    }

    public void setLeadership(Feature leadership) {
        this.leadership = leadership;
    }

    public Feature getOffTheBall() {
        return offTheBall;
    }

    public void setOffTheBall(Feature offTheBall) {
        this.offTheBall = offTheBall;
    }

    public Feature getPositioning() {
        return positioning;
    }

    public void setPositioning(Feature positioning) {
        this.positioning = positioning;
    }

    public Feature getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(Feature teamwork) {
        this.teamwork = teamwork;
    }

    public Feature getVision() {
        return vision;
    }

    public void setVision(Feature vision) {
        this.vision = vision;
    }

    public Feature getWorkRate() {
        return workRate;
    }

    public void setWorkRate(Feature workRate) {
        this.workRate = workRate;
    }

}