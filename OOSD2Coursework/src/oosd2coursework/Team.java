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
public class Team {

    private String teamName;
    private List<Player> playerList = new ArrayList<Player>();
    private int matchesPlayed;
    private int matchesWon;
    private int setsWon;
    private int points;

    public Team(String teamName) {
        this.matchesPlayed = 0;
        this.matchesWon = 0;
        this.setsWon = 0;
        this.points = 0;
        this.setName(teamName);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getName() {
        return this.teamName;
    }

    public void setName(String name) {
        this.teamName = name;
    }

    public void addPlayer(String playerName) {
        Player tempPlayer = new Player(playerName);
        this.playerList.add(tempPlayer);
        System.out.println(this.playerList);
    }

    public List<Player> getPlayers() {
        return this.playerList;
    }

    public int getWinCount() {
        return this.matchesWon;
    }

    public void increaseWinCount() {
        this.matchesWon++;
    }

    public int getWonSets() {
        return this.setsWon;
    }

    public void wonSet() {
        this.setsWon++;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int point) {
        this.points = point;
    }

    public void increaseMatchesPlayed() {
        this.matchesPlayed++;
    }

    public int getMatchesPlayed() {
        return this.matchesPlayed;
    }

    public void increaseMatchesWon() {
        this.matchesWon++;
    }

    public int getMatchesWon() {
        return this.matchesWon;
    }

    public void resetSetsWon() {
        System.out.println("scores reset");
        this.setsWon = 0;
    }
}
