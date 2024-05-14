package org.example.powwww.entity.mobile.physcian;
    
import org.example.powwww.grid.*;

import java.awt.*;
import java.util.*;
import org.example.powwww.entity.mobile.*;

import org.example.powwww.entity.mobile.physcian.*;
import org.example.powwww.med.Serum;

public class Van extends Nurses {
    public Van(){}
    final protected int speed = 3;

    protected ArrayList<Serum> serumBaggage = new ArrayList<>();

    private int RADIUS = 15;
    private int currentRoad;

    public Van(Road containedIn)
    {
        super(containedIn);
        currentRoad = 0;
        this.x = containedIn.getCoords()[0] * 36;
        this.y = containedIn.getCoords()[1] * 36;
        //road = createRoad();
    }

    /**
     * Draw van as a red point
     * @param g graphics object
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(36+ x-RADIUS/2, 36+y-RADIUS/2, RADIUS, RADIUS);
        Graphics2D a = (Graphics2D)g;
        g.setColor(Color.blue);
        a.drawString("" + this.ID,36+ x-RADIUS/2, 36+y-RADIUS/2 + RADIUS);
    }

    public void drawIdle(Graphics g)
    {
        g.setColor(Color.lightGray);
        g.fillOval(36+ x-RADIUS/2, 36+y-RADIUS/2, RADIUS, RADIUS);
        Graphics2D a = (Graphics2D)g;
        g.setColor(Color.blue);
        a.drawString("" + this.ID,36+ x-RADIUS/2, 36+y-RADIUS/2 + RADIUS);
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
