/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd2coursework;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nik_3
 */
public class Fixtures {

    protected Team homeTeam;
    protected Team awayTeam;
    private int homeSets; //add score to this
    private int awaySets; //score
    protected int homeTeamScore;
    protected int awayTeamScore;
    //check if played

    Fixtures(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        //while ((this.homeTeam == null || (this.awayTeam == null))) {
        // for (Team newteam : OOSD2Coursework.teamList) {
        //     if (homeTeam == null) {
        //         homeTeam = newteam;
        //     } else if (newteam.getName() != homeTeam.getName()) {
        //          awayTeam = newteam;
        //     }
        //for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
        // for (int z = 0; z < OOSD2Coursework.teamList.size(); z++) {
        //if i == z do nothing

        //}
    }

    @Override
    public String toString() {
        String s = "Fixture: " + this.homeTeam + " vs. " + this.awayTeam;
        return s;
    }

    public String getName() {
        String s = this.homeTeam + " vs. " + this.awayTeam;
        return s;
    }

    public void increaseScore(String team) {
        if (team == "home") {
            this.homeTeamScore++;
        }
        if (team == "away") {
            this.awayTeamScore++;
        }
    }

    public String calculateWinner() {
        if (this.getHomeScore() > this.getAwayScore()) {
            return this.getHomeTeam().toString();
        }
        else if (this.getHomeScore() == 0 && this.getAwayScore() == 0){
            return "This match has not been played.";
        }        
        else {
            return this.getAwayTeam().toString();
        }
    }
    
    public String getAwayTeam(){return this.awayTeam.toString();}
    
    public String getHomeTeam(){return this.homeTeam.toString();}

    public int getHomeScore() {
        return this.homeTeamScore;
    }

    public int getAwayScore() {
        return this.awayTeamScore;
    }

    public void viewFixture() {
        System.out.println("hometeam: " + this.homeTeam.toString() + " awayteam: " + this.awayTeam.toString() + "   homesets: " + this.homeSets + " " + "Awaysets:" + this.awaySets);
    }
    
    public void resetScore() {
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }
}
