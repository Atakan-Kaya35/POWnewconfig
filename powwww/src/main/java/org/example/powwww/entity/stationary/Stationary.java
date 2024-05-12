package org.example.powwww.entity.stationary;

import org.example.powwww.entity.*;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Road;

import java.awt.*;


public abstract class Stationary extends User{
    
    int[] coordinates;
    Road[] surroundingRoads;
    Stationary contained;
    String inital;
    protected City insideOf;
    int startX;
    int startY;
    int endX;
    int endY;
    boolean meaningful;
/*     public Building(int[] coords, Stationary contained){
        this.coordinates = coords;
        this.contained = contained;
    }

    public Building(int x, int y, Stationary contained){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.contained = contained;
    } */
    public Stationary(){
        meaningful = false;
    }
    public Stationary(int x, int y, City insideOf){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        this.insideOf = insideOf;
        meaningful = true;
        this.contained = null;
    }

    public void setRoads(Road[] roads){
        this.surroundingRoads = roads;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        //g.fillRect(36+ startX, 36+startY, 36+surroundingRoads[4].getCoords()[0], 36+surroundingRoads[4].getCoords()[1]);
    }

    public Road getEntrence(){
        return surroundingRoads[0];
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setInitial(String initial){
        this.inital = initial;
    }

    public String initialString(){
        return this.inital;
    }

    public String getName(){
        return "";
    }

    public boolean getIsMeaningful() {
        return meaningful;
    }
}