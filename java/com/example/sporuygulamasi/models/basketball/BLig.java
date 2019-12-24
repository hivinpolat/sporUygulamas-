package com.example.sporuygulamasi.models.basketball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.BMatch;

public class BLig {
    //private List<Teams> takimlar = new ArrayList<Teams>();
    private HashMap<Integer, List<BMatch>> fixture = new HashMap<Integer, List<BMatch>>();

    public void createFixture() {

        String[] names=	UtilMethods.name();


        List<BTeams> temp = new ArrayList<BTeams>();
        for (int i=0;i<names.length;i++){
           temp.add(new BTeams(names[i]));
        }
        UtilMethods.teams.addAll(temp);

        List<BTeams> firstWeek = new ArrayList<BTeams>();

        for (int i = 0; i < UtilMethods.teams.size(); i++) {
            int index = new Random().nextInt(temp.size());
            firstWeek.add(temp.get(index));
            temp.remove(index);
        }

        createWeek(1, firstWeek);
        for (int i = 0; i <17; i++) {// 16 kayd�rma var
            BTeams lastTeam = firstWeek.get(UtilMethods.teams.size() - 1);
            firstWeek.remove(UtilMethods.teams.size() - 1);
            firstWeek.add(1, lastTeam);
            createWeek(i + 2, firstWeek);

        }
    }

    private void createWeek(int week, List<BTeams> takimlar) {
        List<BMatch> matchesOftheWeek = new ArrayList<BMatch>();
        List<BMatch> rematchMatches = new ArrayList<BMatch>();
        for (int i = 0; i < 9; i++) {// bir haftada 9 ma� olur
            matchesOftheWeek.add(new BMatch(takimlar.get(i), takimlar.get(17 - i)));
            rematchMatches.add(new BMatch(takimlar.get(17 - i), takimlar.get(i)));

        }
        fixture.put(week, matchesOftheWeek);
        fixture.put(week + 17, rematchMatches);

        UtilMethods.fixture.put(week,matchesOftheWeek);
        UtilMethods.fixture.put(week+17,rematchMatches);

    }




	/*public List<Teams> getTakimlar() {
		return takimlar;
	}

	public void setTakimlar(List<Teams> takimlar) {
		this.takimlar = takimlar;
	}*/

    public HashMap<Integer, List<BMatch>> getFixture() {
        return fixture;
    }

    public void setFixture(HashMap<Integer, List<BMatch>> fixture) {
        this.fixture = fixture;
    }

}

