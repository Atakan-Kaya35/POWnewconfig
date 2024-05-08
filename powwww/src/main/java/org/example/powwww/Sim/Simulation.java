package org.example.powwww.Sim;


import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.MapGridTaslak.GridFrame;
import org.example.powwww.grid.City;
import org.example.powwww.med.AcutSickness;
import org.example.powwww.med.Pill;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Simulation extends SimMethods {

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

        Patients p1 = new Patients("p1", 0,0,city);
        city.addStationary(p1);
        Patients p2 = new Patients("p2", 28,18,city);
        city.addStationary(p2);


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

        buildCity(city);


        boolean running = true;
        int tick = 1; // Track the current tick
        int day = 0;

        // Duration of a tick in minutes
        final int TICK_DURATION_MINUTES = 5;
        final int REFRESH_CONSTANT = 3; //kaç iteration'da bir komut çalışsın

        // Start time for the simulation
        final LocalTime START_TIME = LocalTime.of(0, 0);


        // TODO: Put clock on right hand side top corner

        // Every tick is 1.5 seconds, every day is 240 ticks, a whole day is 6 minutes real time
        // In the simulation every tick is 6 minutes
        while (running) {

            if(tick >= (TICKPERDAY - 1)){
                tick = 1;
                day += 1;
            }

            // bu if bloklarının sayısını artırıp refresh constantı her birinde değiştirince birbirinden farklı aralıklarda bir
            // çalışan metodlar olmuş oluyor. mesela orderları 2 tickte bir güncellerken başka bir şeyi 10 tickte 1 yapabiliyorsun
            if (tick % (TICK_DURATION_MINUTES * REFRESH_CONSTANT / TICK_DURATION_MINUTES) == 0) {   //
                System.out.println("mert");
            }

            // makes people take their medicine
            if (tick % (TICKPERDAY / 4) == 0) {
                simulateSicknessProgression(city, ((tick / (TICKPERDAY / 4)) - 1));
            }

            System.out.println(tick);

            if(Math.random() < h){
                ArrayList f = new ArrayList();
                Pill p = new Pill(0);
                p1.addSickness(new AcutSickness(5,5, p1,p));
/*                f.add(Pill.AllPills.get(0));
                createOrdersForPatients(p1, city, f);*/
                h = 0;
            }

            // moves all nurses
            stimulateNurses(city, (GridFrame) grid);

            System.out.println(city.viewMap(false));

            // Advance the time by one tick
            tick++;

            // Pause execution to simulate the duration of a tick
            try {
                Thread.sleep(TICK_DURATION_MINUTES * 300); // constant saniye boyunca uyuyor. real time simüle ediliyor.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check the progress of activities
            //checkActivityProgress();
        }
    }
}