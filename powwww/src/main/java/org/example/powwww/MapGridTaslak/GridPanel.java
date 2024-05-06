package org.example.powwww.MapGridTaslak;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

import org.example.powwww.entity.mobile.physcian.Van;

public class GridPanel extends JComponent
{
    public final static int calibrationX = 53;
    public final static int calibrationY = 50;
    private GridFrame gridFrame;
    private ArrayList<Home> homes;
    private ArrayList<Obstacle> obstacles;
    private Van van;
    Timer t;
    ActionListener listener;

    public GridPanel(GridFrame ref)
    {
        gridFrame = ref;
        homes = createHomes();
        obstacles = createObstacles();
        van = new Van("atakan", 0,0);

        listener = new sucu();
        t = new Timer(400, listener);
        t.start(); 
        
    }

    /**
     * Create all homes according to gird. Center of all squares there is a home.
     * @return all home objects in the ArrayList
     */
    public ArrayList<Home> createHomes()
    {
        
        ArrayList<Home> homes = new ArrayList<Home>();

        for(int i = gridFrame.getStartW() + (gridFrame.getEachSquare()/ 2); i < gridFrame.getWidth(); i += gridFrame.getEachSquare())
        {
            for(int j = gridFrame.getStartH() + (gridFrame.getEachSquare()/ 2); j < gridFrame.getHeight(); j += gridFrame.getEachSquare())
            {
                
                Home h = new Home(i, j);
                homes.add(h);
            }
        }
        return homes;
    }

    /**
     * Create all obstacles according to coordinates.
     * @return all obstacle objects in the ArrayList
     */
    public ArrayList<Obstacle> createObstacles()
    {
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        Obstacle obs1 = new Obstacle(100, 100, 240, 140); //Obstacle coordinates will be taken from A* code.
        obstacles.add(obs1);
        return obstacles;
    }

    class sucu implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(van.getCurrentRoad() <= van.getTotalWayLength()) //This will be determined by A* algorithm.(not hardcode)
            {
                moveVan();
                repaint();
                if(van.getCurrentRoad() == van.getTotalWayLength()-1)
                {
                    System.out.println("VAN REACHED TO TARGET!");
                    repaint();
                    t.stop();
                }
            }
            
        }
    }

    /**
     * make van follow its path
     */
    public void moveVan()
    {
        van.setCurrentRoad();
        int nextX = van.getRoad()[van.getCurrentRoad()][0];
        int nextY = van.getRoad()[van.getCurrentRoad()][1];
        van.setXCoor(nextX);
        van.setYCoor(nextY);
    }

    public void paintComponent(Graphics g)
    {
        //ImageIcon imageIcon = new ImageIcon("C:\\Users\\burka\\Desktop\\20240412_173426.jpg");
        //Image image = imageIcon.getImage();
        //g.drawImage(image, -16, -12, 650, 650, this);
        setBackground(Color.BLACK);
        
        for(int j = 0; j < homes.size(); j++)
        {
            homes.get(j).draw(g);
            g.setColor(Color.BLACK);
            g.drawLine(homes.get(j).getXCoor()-25, homes.get(j).getYCoor()-20, homes.get(j).getXCoor()+35, homes.get(j).getYCoor()-20);
            g.drawLine(homes.get(j).getXCoor()-20, homes.get(j).getYCoor()-20, homes.get(j).getXCoor()-20, homes.get(j).getYCoor()+35);
            g.setColor(Color.blue);
        }

        for(int i = 0; i < obstacles.size(); i++)
        {
            obstacles.get(i).draw(g);
        }

        van.draw(g);
    }
}
