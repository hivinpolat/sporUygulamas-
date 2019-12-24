package com.example.sporuygulamasi.models.football;

import com.example.sporuygulamasi.UtilMethods.UtilMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Lig {
        //private List<Teams> takimlar = new ArrayList<Teams>();
        private HashMap<Integer, List<Match>> fixture = new HashMap<Integer, List<Match>>();

        public void createFixture() {

            String[] names=	UtilMethods.name();


            List<Teams> temp = new ArrayList<Teams>();
            for (int i=0;i<names.length;i++){
                temp.add(new Teams(names[i]));
            }
            UtilMethods.teams.addAll(temp);

            List<Teams> firstWeek = new ArrayList<Teams>();

            for (int i = 0; i < UtilMethods.teams.size(); i++) {
                int index = new Random().nextInt(temp.size());
                firstWeek.add(temp.get(index));
                temp.remove(index);
            }

            createWeek(1, firstWeek);
            for (int i = 0; i < 16; i++) {// 16 kayd�rma var
                Teams lastTeam = firstWeek.get(UtilMethods.teams.size() - 1);
                firstWeek.remove(UtilMethods.teams.size() - 1);
                firstWeek.add(1, lastTeam);
                createWeek(i + 2, firstWeek);

            }
        }

        private void createWeek(int week, List<Teams> takimlar) {
            List<Match> matchesOftheWeek = new ArrayList<Match>();
            List<Match> rematchMatches = new ArrayList<Match>();
            for (int i = 0; i < 9; i++) {// bir haftada 9 ma� olur
                matchesOftheWeek.add(new Match(takimlar.get(i), takimlar.get(17 - i)));
                rematchMatches.add(new Match(takimlar.get(17 - i), takimlar.get(i)));

            }
            fixture.put(week, matchesOftheWeek);
            fixture.put(week + 17, rematchMatches);

            UtilMethods.fixture.put(week,matchesOftheWeek);
            UtilMethods.fixture.put(week+17,rematchMatches);

        }

        public HashMap<Integer, List<Match>> getFixture() {
            return fixture;
        }

        public void setFixture(HashMap<Integer, List<Match>> fixture) {
            this.fixture = fixture;
        }

    }

