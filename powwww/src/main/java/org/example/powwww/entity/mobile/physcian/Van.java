package org.example.powwww.entity.mobile.physcian;
    
import org.example.powwww.grid.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import org.example.powwww.entity.mobile.*;

import org.example.powwww.entity.mobile.physcian.*;
import org.example.powwww.med.Serum;

public class Van extends Nurses {
    
    final protected int speed = 3;

    protected ArrayList<Serum> serumBaggage = new ArrayList<>();

    private int RADIUS = 5;
    private int currentRoad;

    public Van(){
        super();
    }

    public Van(int x, int y)
    {
        currentRoad = 0;
        this. x = x;
        this.y = y;
        //road = createRoad();
    }

    public Van(String name) {
    }

    /*
    public int [][] createRoad()
    {
        int[][] road = new int[12][2]; ////This will be determined by A* algorithm.(not hardcode)
        

        City city = new City(12, 12);
        
        city.setRoad((Mobile)this, x,y);
        Stationary ob1 = new Stationary(12,12);
        city.buildCustomeStationary(1,5, 6,4, ob1);     //We already passed the coordinates of stationary by using "b". Not need!!!!!!!!!!?
        //Stationary ob2 = new Stationary(10,10);
        //city.buildCustomeStationary(0,1, 9,6, ob2);

        int[] newTraffic = {10,14};
        city.getRoad(10, 5).setTraffic(newTraffic);


        List<Road> d = city.findPath(this, ob1);
        //List<Road> e = city.findPath((Van)this, ob2);
        //System.out.println(city.viewMap(false));


        
        int base = 50;
        for(int i = 0; i<12; i++){
                road[i][0] = base*(city.wholeWay.get(i).get(0));
                road[i][1] = base*(city.wholeWay.get(i).get(1));
        } 

        return road;
    }
    */

    /**
     * Draw van as a red point
     * @param g graphics object
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillOval(x, y, RADIUS * 4, RADIUS * 4);
    }

    //Setter methods
    public void setXCoor(int n)
    {
        this.x = n;
    }
    public void setYCoor(int n)
    {
        this.y = n;
    }
    public void setCurrentRoad()
    {
        currentRoad++;
    }

    //Getter methods
    public int getXCoor()
    {
        return x;
    }
    public int getYCoor()
    {
        return y;
    }
    public int getRadius()
    {
        return RADIUS;
    }
    public int getCurrentRoad()
    {
        return currentRoad;
    }
}
