package org.example.powwww.entity.mobile;

import org.example.powwww.grid.*;
import org.example.powwww.entity.User;

public abstract class Mobile extends User {

    // maybe ArrayList for more complicated city arrangements in the future
    // though that would require a rework of a* which is not easy
    //Building[] surroundingBuildings;

    // Burkay affet
    Road containedIn = null;

    public Mobile (Road containedIn){
        setContainedIn(containedIn);
    }

    /**
     * Put mobile to the given road
     * @param containedIn road
     */
    public void setContainedIn(Road containedIn) {
        this.containedIn = containedIn;
        containedIn.setContined(this);
    }

    public void moveForth(Road containedIn) {
        this.containedIn.setContined(null);
        this.containedIn = containedIn;
        containedIn.setContined(this);
    }

    public Road getContainedIn() {
        return this.containedIn;
    }

    public void receiveOrder(Order order){
    }

/* 

    public void Road(int[] coords, Nurses contained){
        this.coordinates = coords;
        this.containedIn = contained;
    }

    public void Road(int x, int y, Nurses contained){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.containedIn = contained;
    }
 
     public void Road(int x, int y){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.containedIn = null;
    }

    public void setSurroundings(Building[] buildings){
        this.surroundingBuildings = buildings;
    }

    public void setSurroundings(Building building1, Building building2, Building building3, Building building4){
        this.surroundingBuildings = new Building[4];

        this.surroundingBuildings[0] = building1;
        this.surroundingBuildings[1] = building2;
        this.surroundingBuildings[2] = building3;
        this.surroundingBuildings[3] = building4;
    }
 */
}
