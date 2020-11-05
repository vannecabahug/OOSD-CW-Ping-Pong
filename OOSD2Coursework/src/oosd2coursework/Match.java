/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd2coursework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import javafx.scene.control.TextField;

/**
 *
 * @author n2-purohit
 */
public class Match {
    //---------------------------Home player 1 vs AWAY player 1 and player 2----------------------------//
    private int a11set1Home;
    private int a11set1Away;

    private int a11set2Home;
    private int a11set2Away;

    private int a11set3Home;
    private int a11set3Away;

    private int a12set1Home;
    private int a12set1Away;

    private int a12set2Home;
    private int a12set2Away;

    private int a12set3Home;
    private int a12set3Away;
    
    //----------------------------Home player 2 vs AWAY player 1 and player 2---------------------------------//
    private int a21set1Home;
    private int a21set1Away;

    private int a21set2Home;
    private int a21set2Away;

    private int a21set3Home;
    private int a21set3Away;

    private int a22set1Home;
    private int a22set1Away;

    private int a22set2Home;
    private int a22set2Away;

    private int a22set3Home;
    private int a22set3Away;
    
    //-------------------------Double set-----------------------------------//
    private int Dset1Home;
    private int Dset1Away;

    private int Dset2Home;
    private int Dset2Away;

    private int Dset3Home;
    private int Dset3Away;

    private Team homeTeam;
    private Team awayTeam;
    protected Player homePlayer1;
    protected Player homePlayer2;
    protected Player awayPlayer1;
    protected Player awayPlayer2;

    private String name;
    private Fixtures fixture;
    
    private int set1;
    private int set2;
    private int set3;
    private int set4;
    private int set5;
    
    @Override
    public String toString() {
        this.name = this.getHomeTeam() + " vs. " + this.getAwayTeam();
        return this.name;
    }
    
    public void linkFixture(){
        this.toString();
        for (int i = 0; i < OOSD2Coursework.fixtureList.size(); i++) {
            System.out.println(this.name);
            System.out.println(OOSD2Coursework.fixtureList.get(i).toString());
            if (this.name.equals(OOSD2Coursework.fixtureList.get(i).getName())) {
                this.fixture = OOSD2Coursework.fixtureList.get(i);
                System.out.println("fixture linked to match");
            }
            else {System.out.println("cannot find matching fixture.");}
        }
    }

    public void setScore(List<String> scoreValues) {
        for (int i = 0; i < scoreValues.size(); i++) {
            String temp = scoreValues.get(i);
            String splitTemp[] = temp.split(":");
            int homeScore = Integer.parseInt(splitTemp[0]);
            int awayScore = Integer.parseInt(splitTemp[1]);
            if (i == 0) {
                this.a11set1Home = homeScore;
                this.a11set1Away = awayScore;
            }
            if (i == 1) {
                this.a11set2Home = homeScore;
                this.a11set2Away = awayScore;
            }
            if (i == 2) {
                this.a11set3Home = homeScore;
                this.a11set3Away = awayScore;
            }
            if (i == 3) {
                this.a12set1Home = homeScore;
                this.a12set1Away = awayScore;
            }
            if (i == 4) {
                this.a12set2Home = homeScore;
                this.a12set2Away = awayScore;
            }
            if (i == 5) {
                this.a12set3Home = homeScore;
                this.a12set3Away = awayScore;
            }
            if (i == 6) {
                this.a21set1Home = homeScore;
                this.a21set1Away = awayScore;
            }
            if (i == 7) {
                this.a21set2Home = homeScore;
                this.a21set2Away = awayScore;
            }
            if (i == 8) {
                this.a21set3Home = homeScore;
                this.a21set3Away = awayScore;
            }
            if (i == 9) {
                this.a22set1Home = homeScore;
                this.a22set1Away = awayScore;
            }
            if (i == 10) {
                this.a22set2Home = homeScore;
                this.a22set2Away = awayScore;
            }
            if (i == 11) {
                this.a22set3Home = homeScore;
                this.a22set3Away = awayScore;
            }
            if (i == 12) {
                this.Dset1Home = homeScore;
                this.Dset1Away = awayScore;
            }
            if (i == 13) {
                this.Dset2Home = homeScore;
                this.Dset2Away = awayScore;
            }
            if (i == 14) {
                this.Dset3Home = homeScore;
                this.Dset3Away = awayScore;
            }

        }
    }
    
    public List<String> getSet(int setNo){
        String concat;
        List<String> sets = new ArrayList<String>();
        if (setNo == 1){
            concat = Integer.toString(this.a11set1Home) + ":" + Integer.toString(this.a11set1Away);
            sets.add(concat);
            concat = Integer.toString(this.a11set2Home) + ":" + Integer.toString(this.a11set2Away);
            sets.add(concat);
            concat = Integer.toString(this.a11set3Home) + ":" + Integer.toString(this.a11set3Away);
            sets.add(concat);
        }
        if (setNo == 2){
            concat = Integer.toString(this.a12set1Home) + ":" + Integer.toString(this.a12set1Away);
            sets.add(concat);
            concat = Integer.toString(this.a12set2Home) + ":" + Integer.toString(this.a12set2Away);
            sets.add(concat);
            concat = Integer.toString(this.a12set3Home) + ":" + Integer.toString(this.a12set3Away);
            sets.add(concat);
        }
        if (setNo == 3){
            concat = Integer.toString(this.a21set1Home) + ":" + Integer.toString(this.a21set1Away);
            sets.add(concat);
            concat = Integer.toString(this.a21set2Home) + ":" + Integer.toString(this.a21set2Away);
            sets.add(concat);
            concat = Integer.toString(this.a21set3Home) + ":" + Integer.toString(this.a21set3Away);
            sets.add(concat);
        }
        if (setNo == 4){
            concat = Integer.toString(this.a22set1Home) + ":" + Integer.toString(this.a22set1Away);
            sets.add(concat);
            concat = Integer.toString(this.a22set2Home) + ":" + Integer.toString(this.a22set2Away);
            sets.add(concat);
            concat = Integer.toString(this.a22set3Home) + ":" + Integer.toString(this.a22set3Away);
            sets.add(concat);
        }
        if (setNo == 5){
            concat = Integer.toString(this.Dset1Home) + ":" + Integer.toString(this.Dset1Away);
            sets.add(concat);
            concat = Integer.toString(this.Dset2Home) + ":" + Integer.toString(this.Dset2Away);
            sets.add(concat);
            concat = Integer.toString(this.Dset3Home) + ":" + Integer.toString(this.Dset3Away);
            sets.add(concat);
        }
        return sets;
    }

    public void setPlayers(String team, int playerNo, Player player) {
        if (team == "home" && playerNo == 1) {
            this.homePlayer1 = player;
            System.out.println("home 1 saved");
        }
        if (team == "home" && playerNo == 2) {
            this.homePlayer2 = player;
            System.out.println("home 2 saved");
        }
        if (team == "away" && playerNo == 1) {
            this.awayPlayer1 = player;
            System.out.println("away 1 saved");
        }
        if (team == "away" && playerNo == 2) {
            this.awayPlayer2 = player;
            System.out.println("away 2 saved");
        }
    }

    public List<String> getScores() {
        List<String> scoreValues = new ArrayList<String>();
        StringJoiner joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a11set1Home)).add(String.valueOf(this.a11set1Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a11set2Home)).add(String.valueOf(this.a11set2Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a11set3Home)).add(String.valueOf(this.a11set3Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a12set1Home)).add(String.valueOf(this.a12set1Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a12set2Home)).add(String.valueOf(this.a12set2Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a12set3Home)).add(String.valueOf(this.a12set3Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a21set1Home)).add(String.valueOf(this.a21set1Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a21set2Home)).add(String.valueOf(this.a21set2Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a21set3Home)).add(String.valueOf(this.a21set3Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a22set1Home)).add(String.valueOf(this.a22set1Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a22set2Home)).add(String.valueOf(this.a22set2Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.a22set3Home)).add(String.valueOf(this.a22set3Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.Dset1Home)).add(String.valueOf(this.Dset1Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.Dset2Home)).add(String.valueOf(this.Dset2Away)).toString());
        joiner = new StringJoiner(":");
        scoreValues.add(joiner.add(String.valueOf(this.Dset3Home)).add(String.valueOf(this.Dset3Away)).toString());

        return scoreValues;

    }

    public void calculateScores() {
        //this.fixture.resetScore();
        int homeScore = 0, awayScore = 0;
        if (a11set1Home > a11set1Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a11set2Home > a11set2Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a11set3Home > a11set3Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (homeScore > awayScore) {
            fixture.increaseScore("home");
            this.homeTeam.wonSet();
        } else {
            fixture.increaseScore("away");
            this.awayTeam.wonSet();
        }

        homeScore = 0;
        awayScore = 0;
        if (a12set1Home > a12set1Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a12set2Home > a12set2Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a12set3Home > a12set3Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (homeScore > awayScore) {
            fixture.increaseScore("home");
            this.homeTeam.wonSet();
        } else {
            fixture.increaseScore("away");
            this.awayTeam.wonSet();
        }

        homeScore = 0;
        awayScore = 0;
        if (a21set1Home > a21set1Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a21set2Home > a21set2Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a21set3Home > a21set3Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (homeScore > awayScore) {
            fixture.increaseScore("home");
            this.homeTeam.wonSet();
        } else {
            fixture.increaseScore("away");
            this.awayTeam.wonSet();
            
        }

        homeScore = 0;
        awayScore = 0;
        if (a22set1Home > a22set1Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a22set2Home > a22set2Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (a22set3Home > a22set3Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (homeScore > awayScore) {
            fixture.increaseScore("home");
            this.homeTeam.wonSet();
        } else {
            fixture.increaseScore("away");
            this.awayTeam.wonSet();
        }

        homeScore = 0;
        awayScore = 0;
        if (Dset1Home > Dset1Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (Dset2Home > Dset2Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (Dset3Home > Dset3Away) {
            homeScore++;
        } else {
            awayScore++;
        }
        if (homeScore > awayScore) {
            fixture.increaseScore("home");
            this.homeTeam.wonSet();
        } else {
            fixture.increaseScore("away");
            this.awayTeam.wonSet();
        }
    }
    

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setHomeTeam(Team name) {
        this.homeTeam = name;
    }

    public void setAwayTeam(Team name) {
        this.awayTeam = name;
    }

    public Player getHomePlayer1() {
        return this.homePlayer1;
    }

    public Player getHomePlayer2() {
        return this.homePlayer2;
    }

    public Player getAwayPlayer1() {
        return this.awayPlayer1;
    }

    public Player getAwayPlayer2() {
        return this.awayPlayer2;
    }    
   
    public Fixtures getFixture() {return this.fixture;}
    
}
