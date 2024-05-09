package org.example.powwww.grid;

import org.example.powwww.entity.*;

import java.awt.*;


public class Stationary extends User{
    
    int[] coordinates;
    Road[] surroundingRoads;
    Stationary contained;
    String inital;
    City insideOf;
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
        insideOf.addStationary(this);
        meaningful = true;
        this.contained = null;
    }

    public void setRoads(Road[] roads){
        this.surroundingRoads = roads;
    }

    public void setRoads(Road road1, Road road2, Road road3, Road road4){
        this.surroundingRoads = new Road[4];

        this.surroundingRoads[0] = road1;
        this.surroundingRoads[1] = road2;
        this.surroundingRoads[2] = road3;
        this.surroundingRoads[3] = road4;
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