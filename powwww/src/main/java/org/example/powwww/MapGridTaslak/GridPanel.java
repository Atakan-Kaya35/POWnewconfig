
package org.example.powwww.MapGridTaslak;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.City;

public class GridPanel extends JComponent
{

    private GridFrame gridFrame;
    private ArrayList<Home> homes;
    private ArrayList<Obstacle> obstacles;
    //private Van van;
    private City city;
    //Timer t;
    ActionListener listener;

    public GridPanel(GridFrame ref, City c)
    {
        this.setCity(c);
        gridFrame = ref;
        homes = createHomes();
        //obstacles = createObstacles();
        //van = new Van(city);

        //listener = new sucu();
        //t = new Timer(400, listener);
        //t.start();
        
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<Home> createHomes()
    {
        
        ArrayList<Home> homes = new ArrayList<Home>();

        for(int i = gridFrame.getStartW(); i < gridFrame.getWidth()-50; i += gridFrame.getEachSquare())
        {
            for(int j = gridFrame.getStartH(); j < gridFrame.getHeight()-100; j += gridFrame.getEachSquare())
            {
                Home h = new Home(i+ gridFrame.getEachSquare()/2, j+ gridFrame.getEachSquare()/2);
                homes.add(h);
            }
        }
        return homes;
    }

//    public ArrayList<Obstacle> createObstacles()
//    {
//        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
//        Obstacle obs1 = new Obstacle(100, 100, 240, 140); //Obstacle coordinates will be taken from A* code.
//        obstacles.add(obs1);
//        return obstacles;
//    }

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
            g.setColor(Color.WHITE);
            g.drawLine(homes.get(j).getXCoor()- gridFrame.getEachSquare()/2, homes.get(j).getYCoor()- gridFrame.getEachSquare()/2,
                    homes.get(j).getXCoor()+ gridFrame.getEachSquare()/2 , homes.get(j).getYCoor()- gridFrame.getEachSquare()/2);
            g.drawLine(homes.get(j).getXCoor()- gridFrame.getEachSquare()/2, homes.get(j).getYCoor()- gridFrame.getEachSquare()/2,
                    homes.get(j).getXCoor()- gridFrame.getEachSquare()/2 , homes.get(j).getYCoor()+ gridFrame.getEachSquare()/2);

        }

        g.drawLine(gridFrame.getEachSquare(), homes.get(homes.size() - 1).getYCoor() + gridFrame.getEachSquare() / 2,
                homes.get(homes.size() - 1).getXCoor() + gridFrame.getEachSquare() / 2, homes.get(homes.size() - 1).getYCoor() + gridFrame.getEachSquare() / 2);
        g.drawLine(homes.get(homes.size() - 1).getXCoor() + gridFrame.getEachSquare() / 2, gridFrame.getEachSquare(),
                homes.get(homes.size() - 1).getXCoor() + gridFrame.getEachSquare() / 2 , homes.get(homes.size() - 1).getYCoor() + gridFrame.getEachSquare()/2);

        g.setColor(Color.blue);

        for(Patients p : city.getPatientList())
        {
            if(p.getCurrentOrder()!=null){
                System.out.println("BBBBBBBBBBBBBBBBBBBBBB");
                p.draw(g);
            }
        }

        for(Van v : city.getVanList()){
            if(v.getCurrentOrder()!=null) { //null degilse
                v.draw(g);
            }
            else{
                v.drawIdle(g);
            }
        }
        for(int i = 0; i< city.getScooterList().size(); i++) {
            if (city.getScooterList().get(i).getCurrentOrder() != null) { //null degilse
                city.getScooterList().get(i).draw(g);
            }
            else{
                city.getScooterList().get(i).drawIdle(g);
            }
        }
    }
}
