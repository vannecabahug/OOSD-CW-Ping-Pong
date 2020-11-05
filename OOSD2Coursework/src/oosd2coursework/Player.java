/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd2coursework;

/**
 *
 * @author nik_3
 */
public class Player {
    private String playerName;
    
    public Player(String name){
        this.playerName = name;
}

    @Override
    public String toString() {
        return this.getName();
    }
    
    public String getName(){
        return this.playerName;
    }
  
    public void setName(String name){
        this.playerName = name;
    }
}
