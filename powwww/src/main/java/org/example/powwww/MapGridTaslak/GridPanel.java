
package org.example.powwww.MapGridTaslak;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.grid.City;

public class GridPanel extends JComponent
{
    public final static int calibrationX = 53;
    public final static int calibrationY = 50;
    private GridFrame gridFrame;
    private ArrayList<Home> homes;
    private ArrayList<Obstacle> obstacles;
    private Van van;
    private City city;
    Timer t;
    ActionListener listener;

    public GridPanel(GridFrame ref)
    {
        gridFrame = ref;
        homes = createHomes();
        obstacles = createObstacles();
        van = new Van(0,0);

        //listener = new sucu();
        t = new Timer(400, listener);
        t.start(); 
        
    }

    public void setCity(City city) {
        this.city = city;
    }

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




    public ArrayList<Obstacle> createObstacles()
    {
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        Obstacle obs1 = new Obstacle(100, 100, 240, 140); //Obstacle coordinates will be taken from A* code.
        obstacles.add(obs1);
        return obstacles;
    }


// class sucu implements ActionListener
//    {
//        public void actionPerformed(ActionEvent event)
//        {
//            if(van.getCurrentRoad() <= van.getTotalWayLength()) //This will be determined by A* algorithm.(not hardcode)
//            {
//                moveVan();
//                repaint();
//                if(van.getCurrentRoad() == van.getTotalWayLength()-1)
//                {
//                    System.out.println("VAN REACHED TO TARGET!");
//                    repaint();
//                    t.stop();
//                }
//            }
//
//        }
//    }


//    public void moveVan()
//    {
//        van.setCurrentRoad();
//        int nextX = van.getC()[van.getCurrentRoad()][0];
//        int nextY = van.getRoad()[van.getCurrentRoad()][1];
//        van.setXCoor(nextX);
//        van.setYCoor(nextY);
//    }

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

        for(int i = 0; i< city.getVanList().size(); i++){
            if(city.getVanList().get(i).getCurrentOrder()!=null) { //null degilse
                city.getVanList().get(i).draw(g);
            }
        }
        for(int i = 0; i< city.getScooterList().size(); i++){
            if(city.getScooterList().get(i).getCurrentOrder()!=null) { //null degilse
                city.getScooterList().get(i).draw(g);
            }
        }
    }
}
