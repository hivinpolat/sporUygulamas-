package com.example.sporuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sporuygulamasi.BasketballUtilMethods.UtilMethods;
import com.example.sporuygulamasi.models.basketball.BLig;
import com.example.sporuygulamasi.models.basketball.BMatch;
import com.example.sporuygulamasi.models.basketball.BTeams;
import com.example.sporuygulamasi.models.football.Lig;
import com.example.sporuygulamasi.models.football.Match;
import com.example.sporuygulamasi.models.football.Teams;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.view.View;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;

    private BLig lig;
    private Lig lig2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res=getResources();
        final BLig lig = new BLig();
        final Lig lig2 = new Lig();

        button = (Button) findViewById(R.id.basketbol);
        Drawable d = this.getResources().getDrawable(R.drawable.indirccrop);
        button.setBackgroundDrawable(d);

        button2=(Button)findViewById(R.id.futbol);
        Drawable as = this.getResources().getDrawable(R.drawable.futboltopu);
        button2.setBackgroundDrawable(as);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
@Override
            public void onClick(View view) {
                openActivity();
            }

        });
        lig.createFixture();
        lig2.createFixture();

        for (int i = 1; i <= 34; i++) {
            List<BMatch> matchs = lig.getFixture().get(i);

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta maclari");
           for (BMatch match : matchs) {
               match.print();
          }

            for (BMatch match : matchs) {
                match.ready();
                match.playMatch();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta mac sonuclari");
            for (BMatch match : matchs) {
                match.print();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta  puan siralamasi");
            List<BTeams> temp = new ArrayList<BTeams>(UtilMethods.teams);
            for (int a = 0; a < temp.size() - 1; a++) {
                BTeams takimlar = temp.get(a);
                int index = a;
                for (int b = a + 1; b < temp.size(); b++) {
                    if (isSmall(temp.get(b), takimlar)) {
                        takimlar = temp.get(b);
                        index = b;
                    }

                }

                if (index != a) {
                    temp.remove(index);
                    temp.add(index, temp.get(a));
                    temp.remove(a);
                    temp.add(a, takimlar);
                }
            }

            for (BTeams teams : temp) {
                System.out.println(teams);
            }

        }



        for (int i = 1; i <= 34; i++) {
            List<Match> matchs = lig2.getFixture().get(i);

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta maclari");
            for (Match match : matchs) {
                match.print();
            }

            for (Match match : matchs) {
                match.ready();
                match.playMatch();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta mac sonuclari");
            for (Match match : matchs) {
                match.print();
            }

            System.out.println("  ");
            System.out.println("  ");
            System.out.println(i + ". hafta  puan siralamasi");
            List<Teams> temp = new ArrayList<Teams>(com.example.sporuygulamasi.UtilMethods.UtilMethods.teams);
            for (int a = 0; a < temp.size() - 1; a++) {
                Teams takimlar = temp.get(a);
                int index = a;
                for (int b = a + 1; b < temp.size(); b++) {
                    if (isSmall2(temp.get(b), takimlar)) {
                        takimlar = temp.get(b);
                        index = b;
                    }

                }

                if (index != a) {
                    temp.remove(index);
                    temp.add(index, temp.get(a));
                    temp.remove(a);
                    temp.add(a, takimlar);
                }
            }

            for (Teams teams : temp) {
                System.out.println(teams);
            }

        }


    }

    private void openActivity2() {
        Intent intent=new Intent(MainActivity.this, FutbolTakimActivity.class);
        startActivity(intent);
    }

    private void openActivity() {
        Intent intent=new Intent(MainActivity.this, BasketbolTakimActivity.class);
        startActivity(intent);
    }
    private static boolean isSmall(BTeams teams, BTeams teams2) {

        if (teams.getPoint() != teams2.getPoint())
            return teams.getPoint() > teams2.getPoint();

        if (teams.getAVG() != teams2.getAVG())
            return teams.getAVG() > teams2.getAVG();
        if (teams.getGoalScored() != teams2.getGoalScored())
            return teams.getGoalScored() > teams2.getGoalScored();

        return teams.getVictory() > teams2.getVictory();

    }
    private static boolean isSmall2(Teams teams, Teams teams2) {

        if (teams.getPoint() != teams2.getPoint())
            return teams.getPoint() > teams2.getPoint();

        if (teams.getAVG() != teams2.getAVG())
            return teams.getAVG() > teams2.getAVG();
        if (teams.getGoalScored() != teams2.getGoalScored())
            return teams.getGoalScored() > teams2.getGoalScored();

        return teams.getVictory() > teams2.getVictory();

    }
}