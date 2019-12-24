package com.example.sporuygulamasi.models.basketball;

import com.example.sporuygulamasi.models.basketball.BFeature;

import java.io.Serializable;
import java.util.Arrays;
import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.Enum.Positions;


public class BMentalFeature implements Serializable {
    private BFeature aggression;// saldırganlık
    private BFeature anticipation;// tahmin etme
    private BFeature bravery;// cesaret
    private BFeature composure;// sakinlik
    private BFeature concentration;// konsatrasyon
    private BFeature decisions;// hulum verme
    private BFeature determination;// karalilik
    private BFeature flair;// yetenek
    private BFeature leadership;// liderlik
    private BFeature positioning;// konumlandirma
    private BFeature teamwork;// takim çalıismasi
    private BFeature vision;// vizyon
    private BFeature workRate;// çalışma oranı

    public BMentalFeature() {
        super();
    }

    protected double getAvgPenalty() {

        return (aggression.getPenal() + anticipation.getPenal() + bravery.getPenal() + composure.getPenal()
                + concentration.getPenal() + decisions.getPenal() + determination.getPenal() + flair.getPenal()
                + leadership.getValue() + positioning.getValue() + teamwork.getValue() + vision.getPenal()
                + workRate.getPenal()) / 13;
    }

    protected double getAvgPower() {

        return (aggression.getValue() + anticipation.getValue() + bravery.getValue() + composure.getValue()
                + concentration.getValue() + decisions.getValue() + determination.getValue() + flair.getValue()
                + leadership.getValue() + positioning.getValue() + teamwork.getValue() + vision.getValue()
                + workRate.getValue()) / 13;
    }

    protected void generate(Positions playerPosition) {
        this.aggression = new BFeature(null);
        this.aggression.calculateValue(playerPosition);

        this.anticipation = new BFeature(null);
        this.anticipation.calculateValue(playerPosition);

        this.bravery = new BFeature(Arrays.asList(Positions.GUARD));
        this.bravery.calculateValue(playerPosition);

        this.composure = new BFeature(null);
        this.composure.calculateValue(playerPosition);

        this.concentration = new BFeature(null);
        this.concentration.calculateValue(playerPosition);

        this.decisions = new BFeature(null);
        this.decisions.calculateValue(playerPosition);

        this.determination = new BFeature(null);
        this.determination.calculateValue(playerPosition);

        this.flair = new BFeature(null);
        this.flair.calculateValue(playerPosition);

        this.leadership = new BFeature(null);
        this.leadership.calculateValue(playerPosition);

        this.positioning = new BFeature(Arrays.asList(Positions.GUARD));
        this.positioning.calculateValue(playerPosition);

        this.teamwork = new BFeature(null);
        this.teamwork.calculateValue(playerPosition);

        this.vision = new BFeature(null);
        this.vision.calculateValue(playerPosition);

        this.workRate = new BFeature(null);
        this.workRate.calculateValue(playerPosition);
    }

    public BFeature getAggression() {
        return aggression;
    }

    public void setAggression(BFeature aggression) {
        this.aggression = aggression;
    }

    public BFeature getAnticipation() {
        return anticipation;
    }

    public void setAnticipation(BFeature anticipation) {
        this.anticipation = anticipation;
    }

    public BFeature getBravery() {
        return bravery;
    }

    public void setBravery(BFeature bravery) {
        this.bravery = bravery;
    }

    public BFeature getComposure() {
        return composure;
    }

    public void setComposure(BFeature composure) {
        this.composure = composure;
    }

    public BFeature getConcentration() {
        return concentration;
    }

    public void setConcentration(BFeature concentration) {
        this.concentration = concentration;
    }

    public BFeature getDecisions() {
        return decisions;
    }

    public void setDecisions(BFeature decisions) {
        this.decisions = decisions;
    }

    public BFeature getDetermination() {
        return determination;
    }

    public void setDetermination(BFeature determination) {
        this.determination = determination;
    }

    public BFeature getFlair() {
        return flair;
    }

    public void setFlair(BFeature flair) {
        this.flair = flair;
    }

    public BFeature getLeadership() {
        return leadership;
    }

    public void setLeadership(BFeature leadership) {
        this.leadership = leadership;
    }

    public BFeature getPositioning() {
        return positioning;
    }

    public void setPositioning(BFeature positioning) {
        this.positioning = positioning;
    }

    public BFeature getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(BFeature teamwork) {
        this.teamwork = teamwork;
    }

    public BFeature getVision() {
        return vision;
    }

    public void setVision(BFeature vision) {
        this.vision = vision;
    }

    public BFeature getWorkRate() {
        return workRate;
    }

    public void setWorkRate(BFeature workRate) {
        this.workRate = workRate;
    }

}

