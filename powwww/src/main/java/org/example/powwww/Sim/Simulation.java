package org.example.powwww.Sim;


import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.MapGridTaslak.GridFrame;
import org.example.powwww.grid.City;
import org.example.powwww.med.AcutSickness;
import org.example.powwww.med.Pill;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Simulation extends SimMethods {

    public static int tick;

    public static void main(String[] args) {

        // Initialize the city with desired parameters
        City city = createCity();
        Pill.fillPills();
        Pill a = new Pill(0);
        System.out.println();

        JFrame grid = new GridFrame(city);
        grid.setTitle("MAP");
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setVisible(true);
//
//        Patients p1 = new Patients("p1", 0,0,city);
//        city.addStationary(p1);
//        Patients p2 = new Patients("p1", 28,0,city);
//        city.addStationary(p1);
//        Patients p3 = new Patients("p1", 28,18,city);
//        city.addStationary(p1);
//        Patients p4 = new Patients("p1", 0,18,city);
//        city.addStationary(p1);
//        Patients p5 = new Patients("p1", 0,5,city);
//        city.addStationary(p1);
//        Patients p6 = new Patients("p1", 5,5,city);
//        city.addStationary(p1);
//        Patients p7 = new Patients("p1", 10,10,city);
//        city.addStationary(p1);
//        Patients p8 = new Patients("p1", 15,10,city);
//        city.addStationary(p1);
//        Patients p9 = new Patients("p1", 0,18,city);
//        city.addStationary(p1);
//        Patients p10 = new Patients("p1", 3,15,city);
//        city.addStationary(p1);
//        Patients p11 = new Patients("p1", 25,8,city);
//        city.addStationary(p1);
//        Patients p12 = new Patients("p1", 28,11,city);
//        city.addStationary(p1);
//        Patients p13 = new Patients("p1", 27,6,city);
//        city.addStationary(p1);

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
            city.killPatients();
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

//            // For p1
//            if (Math.random() < 0.1) {
//                System.out.println("p1");
//                p1.addSickness(new AcutSickness(5, 5, p1, p));
//            }
//
//// For p2
//            if (Math.random() < 0.1) {
//                System.out.println("p2");
//                p2.addSickness(new AcutSickness(5, 5, p2, p));
//            }
//
//// For p3
//            if (Math.random() < 0.1) {
//                System.out.println("p3");
//                p3.addSickness(new AcutSickness(5, 5, p3, p));
//            }
//
//// For p4
//            if (Math.random() < 0.1) {
//                System.out.println("p4");
//                p4.addSickness(new AcutSickness(5, 5, p4, p));
//            }
//
//
//// For p5
//            if (Math.random() < 0.1) {
//                System.out.println("p5");
//                p5.addSickness(new AcutSickness(5, 5, p5, p));
//            }
//
//// For p6
//            if (Math.random() < 0.1) {
//                System.out.println("p6");
//                p6.addSickness(new AcutSickness(5, 5, p6, p));
//            }
//
//// For p7
//            if (Math.random() < 0.1) {
//                System.out.println("p7");
//                p7.addSickness(new AcutSickness(5, 5, p7, p));
//            }
//
//// For p8
//            if (Math.random() < 0.1) {
//                System.out.println("p8");
//                p8.addSickness(new AcutSickness(5, 5, p8, p));
//            }
//
//// For p9
//            if (Math.random() < 0.1) {
//                System.out.println("p9");
//                p9.addSickness(new AcutSickness(5, 5, p9, p));
//            }
//
//// For p10
//            if (Math.random() < 0.1) {
//                System.out.println("p10");
//                p10.addSickness(new AcutSickness(5, 5, p10, p));
//            }
//
//// For p11
//            if (Math.random() < 0.1) {
//                System.out.println("p11");
//                p11.addSickness(new AcutSickness(5, 5, p11, p));
//            }
//
//// For p12
//            if (Math.random() < 0.1) {
//                System.out.println("p12");
//                p12.addSickness(new AcutSickness(5, 5, p12, p));
//            }
//
//// For p13
//            if (Math.random() < 0.1) {
//                System.out.println("p13");
//                p13.addSickness(new AcutSickness(5, 5, p13, p));
//            }


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
}