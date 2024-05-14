package org.example.powwww.Sim;


import org.example.powwww.MapGridTaslak.GridFrame;
import org.example.powwww.grid.City;
import org.example.powwww.med.Pill;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Simulation extends SimMethods implements Runnable{

    public static int tick;
    public static ArrayList<Pill> pills = Pill.getPillObjects();
    public static City city = createCity();

    public static void main(String[] args) {
        playSimulation();
    }

    public static void playSimulation() {

        // Initialize the city with desired parameters
        Pill.fillPills();
        Pill a = new Pill(0);
        System.out.println();

        JFrame grid = new GridFrame(city);
        grid.setTitle("MAP");
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setVisible(true);

        buildBilkent(city);


        boolean running = true;
        tick = 480; // Track the current tick
        int day = 0;

        // Duration of a tick in minutes
        final int TICK_DURATION_MINUTES = 5;
        final int REFRESH_CONSTANT = 3; //kaç iteration'da bir komut çalışsın

        // Start time for the simulation
        final LocalTime START_TIME = LocalTime.of(0, 0);

        ArrayList f = new ArrayList();
        Pill p = new Pill(0);

        // TODO: Put clock on right hand side top corner

        // Every tick is 1.5 seconds, every day is 240 ticks, a whole day is 6 minutes real time
        // In the simulation every tick is 6 minutes
        while (running) {
            long start = System.nanoTime();
            city.stimulateOrders();
            if(tick >= (TICKPERDAY - 1)){
                tick = 1;
                day += 1;
            }

            // çalışan metodlar olmuş oluyor. mesela orderları 2 tickte bir güncellerken başka bir şeyi 10 tickte 1 yapabiliyorsun
            if (tick % (TICK_DURATION_MINUTES * REFRESH_CONSTANT / TICK_DURATION_MINUTES) == 0) {   //
                //System.out.println("mert");
            }

            // makes people take their medicine
            if (tick % (TICKPERDAY / 4) == 0) {
                simulateSicknessProgression(city, ((tick / (TICKPERDAY / 4)) - 1));
                System.out.println(city.viewMap(true));
                if(TICKPERDAY!=0){
                    city.changeTraffic();
                    System.out.println(city.viewMap(true));
                }
            }

            // moves all nurses
            stimulateNurses(city);

            ((GridFrame)grid).showTime(tick);
            ((GridFrame)grid).getPanel().repaint();

            // Advance the time by one tick
            tick++;

            long nanoSecTaken = System.nanoTime() - start;
            // Pause execution to simulate the duration of a tick
            try {
                Thread.sleep(100
                //        -(int)(nanoSecTaken / 1000000)
                ); // constant saniye boyunca uyuyor. real time simüle ediliyor.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        playSimulation();
    }
}