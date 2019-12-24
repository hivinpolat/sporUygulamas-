package com.example.sporuygulamasi.models.football;

import android.icu.text.Transliterator;

import com.example.sporuygulamasi.models.football.Enum.Position;

import java.util.Arrays;

public class TechnicalFeature extends RootFeature {
    private Feature corners;// ortasaha
    private Feature crossing;// ortasaha
    private Feature dribbling;// ortasaha
    private Feature finishing; // hucum
    private Feature firstTouch;// hucum,savunma
    private Feature freeKickTaking;
    private Feature heading; // hucum,savunma
    private Feature longShots;// hucum,ortasaha
    private Feature longThrows;// savunma
    private Feature marking; // savunma
    private Feature passing;// hucum,ortasaha
    private Feature penalty;
    private Feature taking;
    private Feature tackling;// savunma
    private Feature technique;// hucum,ortasaha

    public TechnicalFeature() {
        super();
    }

    @Override
    protected double getAvgPower() {
        return (corners.getValue() + crossing.getValue() + dribbling.getValue() + finishing.getValue()
                + firstTouch.getValue() + freeKickTaking.getValue() + heading.getValue() + longShots.getValue()
                + longThrows.getValue() + marking.getValue() + passing.getValue() + penalty.getValue()
                + tackling.getValue() + technique.getValue()) / 15;
    }

    @Override
    protected void generate(Transliterator.Position playerPosition) {

    }

    @Override

    protected void generate(Position playerPosition) {
        this.corners = new Feature(Arrays.asList(Position.MİDFIELD));
        this.corners.calculateValue(playerPosition);

        this.crossing = new Feature(Arrays.asList(Position.MİDFIELD));
        this.crossing.calculateValue(playerPosition);

        this.dribbling = new Feature(Arrays.asList(Position.MİDFIELD));
        this.dribbling.calculateValue(playerPosition);

        this.finishing = new Feature(Arrays.asList(Position.ATTACK));
        this.finishing.calculateValue(playerPosition);

        this.firstTouch = new Feature(Arrays.asList(Position.ATTACK, Position.DEFENSE));
        this.firstTouch.calculateValue(playerPosition);

        this.heading = new Feature(Arrays.asList(Position.ATTACK, Position.DEFENSE));
        this.heading.calculateValue(playerPosition);

        this.freeKickTaking = new Feature(null);
        this.freeKickTaking.calculateValue(playerPosition);

        this.longShots = new Feature(Arrays.asList(Position.ATTACK, Position.MİDFIELD));
        this.longShots.calculateValue(playerPosition);

        this.longThrows = new Feature(Arrays.asList(Position.DEFENSE));
        this.longThrows.calculateValue(playerPosition);

        this.marking = new Feature(Arrays.asList(Position.DEFENSE));
        this.marking.calculateValue(playerPosition);

        this.passing = new Feature(Arrays.asList(Position.ATTACK, Position.MİDFIELD));
        this.passing.calculateValue(playerPosition);

        this.penalty = new Feature(null);
        this.penalty.calculateValue(playerPosition);

        this.taking = new Feature(null);
        this.taking.calculateValue(playerPosition);

        this.tackling = new Feature(Arrays.asList(Position.DEFENSE));
        this.tackling.calculateValue(playerPosition);

        this.technique = new Feature(Arrays.asList(Position.ATTACK, Position.MİDFIELD));
        this.technique.calculateValue(playerPosition);

    }

    public Feature getCorners() {
        return corners;
    }

    public void setCorners(Feature corners) {
        this.corners = corners;
    }

    public Feature getCrossing() {
        return crossing;
    }

    public void setCrossing(Feature crossing) {
        this.crossing = crossing;
    }

    public Feature getDribbling() {
        return dribbling;
    }

    public void setDribbling(Feature dribbling) {
        this.dribbling = dribbling;
    }

    public Feature getFinishing() {
        return finishing;
    }

    public void setFinishing(Feature finishing) {
        this.finishing = finishing;
    }

    public Feature getFirstTouch() {
        return firstTouch;
    }

    public void setFirstTouch(Feature firstTouch) {
        this.firstTouch = firstTouch;
    }

    public Feature getFreeKickTaking() {
        return freeKickTaking;
    }

    public void setFreeKickTaking(Feature freeKickTaking) {
        this.freeKickTaking = freeKickTaking;
    }

    public Feature getHeading() {
        return heading;
    }

    public void setHeading(Feature heading) {
        this.heading = heading;
    }

    public Feature getLongShots() {
        return longShots;
    }

    public void setLongShots(Feature longShots) {
        this.longShots = longShots;
    }

    public Feature getLongThrows() {
        return longThrows;
    }

    public void setLongThrows(Feature longThrows) {
        this.longThrows = longThrows;
    }

    public Feature getMarking() {
        return marking;
    }

    public void setMarking(Feature marking) {
        this.marking = marking;
    }

    public Feature getPassing() {
        return passing;
    }

    public void setPassing(Feature passing) {
        this.passing = passing;
    }

    public Feature getPenalty() {
        return penalty;
    }

    public void setPenalty(Feature penalty) {
        this.penalty = penalty;
    }

    public Feature getTaking() {
        return taking;
    }

    public void setTaking(Feature taking) {
        this.taking = taking;
    }

    public Feature getTackling() {
        return tackling;
    }

    public void setTackling(Feature tackling) {
        this.tackling = tackling;
    }

    public Feature getTechnique() {
        return technique;
    }

    public void setTechnique(Feature technique) {
        this.technique = technique;
    }

}
