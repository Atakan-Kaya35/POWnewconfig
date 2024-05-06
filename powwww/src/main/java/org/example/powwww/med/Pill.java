package org.example.powwww.med;
import java.io.*;
import java.util.*;
import java.io.File;

public class Pill extends Medicine {

    public static ArrayList<String[]> AllPills = new ArrayList();
    public static ArrayList<String[]> OTCpills = new ArrayList();
    public static ArrayList<String[]> prescribedPills = new ArrayList();
    public int pillID;

    public Pill(int IDnumber) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[3]);
        this.pillID = IDnumber;
        this.cyclesLeft = 5;
    }

    public Pill(int IDnumber, int cyclesOfTaking, boolean[] takeingFrequency) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
        super.setCyclesOfTaking(cyclesOfTaking);
        super.setConsumeFreq(takeingFrequency);
    }

    public static void fillPills() {
        // Get the file path relative to the current package
        String counterMeds = "C:\\Users\\ataka\\Desktop\\POWnewconfig\\powwww\\src\\main\\java\\org\\example\\powwww\\med\\over_the_counter_meds.txt";
        String prescribedMeds = "C:\\Users\\ataka\\Desktop\\POWnewconfig\\powwww\\src\\main\\java\\org\\example\\powwww\\med\\prescribed_meds.csv";

        // Use ClassLoader to load the file
        try (Scanner scanner = new Scanner(new File(counterMeds))) {

            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(",");
                AllPills.add(command);
                OTCpills.add(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File(prescribedMeds))) {

            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(",");
                AllPills.add(command);
                prescribedPills.add(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public int getPillID() {
        return pillID;
    }

    public void setPillID(int pillID) {
        this.pillID = pillID;
    }
}

