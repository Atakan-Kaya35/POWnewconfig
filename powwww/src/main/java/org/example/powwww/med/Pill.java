package org.example.powwww.med;
import java.io.*;
import java.util.*;
import java.io.File;

public class Pill extends Medicine {

    public static ArrayList<String[]> AllPills;
    public static ArrayList OTCpills;
    public static ArrayList prescribedPills;
    public int pillID;

    public Pill(int IDnumber) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
        this.cyclesLeft = 5;
    }

    public Pill(int IDnumber, int cyclesOfTaking, boolean[] takeingFrequency) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
        super.setCyclesOfTaking(cyclesOfTaking);
        super.setConsumeFreq(takeingFrequency);
    }

    public static void fillPills(){
        //AllPills = new ArrayList<>();

        // Get the file path relative to the current package
        String filename = "meds.txt";

        // Use ClassLoader to load the file
        try (Scanner scanner = new Scanner(new File(filename))) {

            while (scanner.hasNextLine()){
                String[] command = scanner.nextLine().split(",");
                AllPills.add(command);
            }
            /*// Check if the file was found
            if (inputStream != null) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Split the line into fields
                    String[] fields = line.split(",");
                    // adds the pill into the big pile
                    AllPills.add(fields);
                }
            } else {
                // File not found
                System.err.println("File not found: " + csvFile);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
        csvFile = "prescribed_meds.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(csvSplitBy);

                // adds the pill into the big pile
                AllPills.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    public int getPillID() {
        return pillID;
    }

    public void setPillID(int pillID) {
        this.pillID = pillID;
    }
}

