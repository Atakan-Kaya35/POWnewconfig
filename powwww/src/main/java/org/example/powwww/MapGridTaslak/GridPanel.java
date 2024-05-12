
package org.example.powwww.MapGridTaslak;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

import org.example.powwww.Sim.Simulation;
import org.example.powwww.entity.mobile.Animations;
import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Stationary;

public class GridPanel extends JComponent
{

    private GridFrame gridFrame;
    private ArrayList<Home> homes;
    private ArrayList<Obstacle> obstacles;
    //private Van van;
    private City city;
    //Timer t;
    ActionListener listener;
    public static ArrayList<int[]> obstanceList = new ArrayList<>();
    Animations animations;

    public GridPanel(GridFrame ref, City c)
    {
        this.setCity(c);
        gridFrame = ref;
        homes = createHomes();
         animations = new Animations();
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

        g.setColor(Color.WHITE);
        for(int j = 1; j <= 20; j++)
        {
            g.drawLine(GridFrame.EACH_SQUARE, j * GridFrame.EACH_SQUARE, GridFrame.EACH_SQUARE * 30, j * GridFrame.EACH_SQUARE);
        }

        for (int i = 1; i <= 30; i++) {
            g.drawLine(i * GridFrame.EACH_SQUARE, GridFrame.EACH_SQUARE , i * GridFrame.EACH_SQUARE, GridFrame.EACH_SQUARE * 20);
        }

        g.setColor(Color.blue);

//        for(Stationary[] stationary2d: city.getStationaries())
//        {
//            for(Stationary stat : stationary2d){
//                if(stat != null){
//                    stat.draw(g);
//                }
//            }
//        }


/*        for(int i = 0; i< city.getVanList().size(); i++) {
            city.getVanList().get(i).draw(g);
        }*/

        for(Patients p : city.getPatientList())
        {
            if(p.getCurrentOrder()==null){ // bunun not equal to olmasi lazim
                p.draw(g,Color.ORANGE);
            }
            else{
                p.draw(g,Color.BLUE);
            }
        }

        g.setColor(Color.black);
        for(int[] obstacle : obstanceList){
            if(obstacle[3] > 1 && obstacle[2] > 1) {
                g.drawRect(obstacle[0] * GridFrame.EACH_SQUARE + GridFrame.EACH_SQUARE + 1, obstacle[1] * GridFrame.EACH_SQUARE + GridFrame.EACH_SQUARE + 1,
                        obstacle[2] * GridFrame.EACH_SQUARE - 2, obstacle[3] * GridFrame.EACH_SQUARE - 2);
                g.fillRect(obstacle[0] * GridFrame.EACH_SQUARE + GridFrame.EACH_SQUARE + 1, obstacle[1] * GridFrame.EACH_SQUARE + GridFrame.EACH_SQUARE + 1,
                        obstacle[2] * GridFrame.EACH_SQUARE - 2, obstacle[3] * GridFrame.EACH_SQUARE - 2);
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

        g.setColor(Color.ORANGE);
        g.drawRect((int)(27.5 * GridFrame.EACH_SQUARE), (int)(20.5 * GridFrame.EACH_SQUARE), 2 * GridFrame.EACH_SQUARE, GridFrame.EACH_SQUARE);
        g.fillRect((int)(27.5 * GridFrame.EACH_SQUARE), (int)(20.5 * GridFrame.EACH_SQUARE), 2 * GridFrame.EACH_SQUARE, GridFrame.EACH_SQUARE);

        g.setColor(Color.black);
        Graphics2D a = (Graphics2D)g;
        a.setFont(new Font("Arial", Font.BOLD, 20));
        a.drawString(String.format("%02d:%02d", Simulation.tick / 60, Simulation.tick % 60), (int)(27.8 * GridFrame.EACH_SQUARE), (int)(21.2 * GridFrame.EACH_SQUARE));

        animations.movePlanes();
        animations.draw(g, this);
    }
    public static void addObstacle(int[] newObstacle){
        obstanceList.add(newObstacle);
    }
}
