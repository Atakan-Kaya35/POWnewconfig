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


    public static void runThisShit() {

        // Initialize the city with desired parameters
        Pill.fillPills();
        Pill a = new Pill(0);
        System.out.println();



        JFrame grid = new GridFrame(city);
        grid.setTitle("MAP");
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setVisible(true);

        int h = 1;


        /*sign upa tıklanırsa
        boolean signedUp = false;
        while (!signedup) {
            signedUp = signUp(name, x, y, ankara, username, password);
                //kordinatları önce default bir şey yapıp sonra kendimiz atarız. kullanıcı sign upta kordinat veremez çünkü.
                //diğer bilgiler sign up ekranından çekilecek.patient classını editleyip age, height vb constructora eklicem.
            if (!signedUp) {
                System.out.println("Sign up unsuccessful. Try again.")
                // boş sign up ekranı yüklenmeli burada tekrar.
            } else {
                System.out.println("Welcome to Pills on Wheels!")
                // bu yazı da UI işi
            }
        }
        logine tıklanırsa:
        boolean login = false;
        while (!login)
            login(username, password);
            if (!login) {
                System.out.println("Login unsuccessful. Try again.")
                // boş login ekranı yüklenmeli
            } else {
                System.out.println("Login successfull!")
                // UI
            }
         */

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

            // bu if bloklarının sayısını artırıp refresh constantı her birinde değiştirince birbirinden farklı aralıklarda bir
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

            //System.out.println(city.viewMap(false));

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

            // Check the progress of activities
            //checkActivityProgress();
        }
    }

    @Override
    public void run() {
        runThisShit();
    }
}