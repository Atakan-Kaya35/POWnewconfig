package org.example.powwww.grid;
import java.util.*;

import org.example.powwww.entity.mobile.physcian.Nurses;
import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Pill;
import org.example.powwww.med.Serum;

public class Order {
    
    int[] startingCord;
    int[] finishingCord;
    boolean assigned = false;
    boolean completed = false;
    ArrayList<Road> path;
    int progressIndex;
    Medicine carriedMedicine;
    ArrayList<Serum> carriedSerums = new ArrayList();
    ArrayList<Pill> carriedPills = new ArrayList();
    public static ArrayList<Order> assignedOrders = new ArrayList<Order>();
    public static ArrayList<Order> completedOrders = new ArrayList<Order>();
    Patients orderPatient;

    //atakan biz burda pathi array arraylisti yaptık da, biz citydeki 
    //find pathde road array listi olarak kullandık sıkıntı çıkarmaz mı bu????

    public void orderFiller(ArrayList<int[]> path){
        this.assigned = true;
        this.path = new ArrayList<Road>();
    }

    // constructors
/*    public Order(Patients patient, Serum carriedPill){
        patient.setCurrentOrder(this);

        this.startingCord = patient.getCity().findMobile(patient.getCoordinates());
        path = patient.getCity().findPath(patient.getCity().getRoad(startingCord[0],startingCord[1]).getContained(), patient);
        this.finishingCord = patient.getCoordinates();
        this.carriedMedicine = new Serum();
        orderPatient = patient;
    }*/

    public Order(Patients patient, Medicine carriedPill){
        orderPatient = patient;
        this.finishingCord = patient.getCoordinates();
        this.carriedMedicine = carriedPill;
        int[] initialGuy = orderPatient.getCity().findMobile(orderPatient.getCoordinates());
        if (initialGuy != null)
            ((Nurses)(orderPatient.getCity().getRoad(initialGuy[0], initialGuy[1]).getContained())).receiveOrder(this);
    }

    public Order(Patients patient, ArrayList<Medicine> medList){
        orderPatient = patient;
        this.finishingCord = patient.getCoordinates();
        for (Medicine med : medList) {
            if (med instanceof Serum){
                carriedSerums.add(new Serum());
            } else {
                carriedPills.add(new Pill(((Pill)med).getPillID()));
            }
        }
        int[] initialGuy = orderPatient.getCity().findMobile(orderPatient.getCoordinates());
        if (initialGuy != null)
            ((Nurses)(orderPatient.getCity().getRoad(initialGuy[0], initialGuy[1]).getContained())).receiveOrder(this);
    }

    public void manifestOrder(){
        orderPatient.setCurrentOrder(this);
        this.startingCord = orderPatient.getCity().findMobile(orderPatient.getCoordinates());
        path = orderPatient.getCity().findPath(orderPatient.getCity().getRoad(startingCord[0],startingCord[1]).getContained(), orderPatient);
    }

    // manifest order path dolacak??
    
    //getter methods
    public int[] getStartingCord() {
        return this.startingCord;
    }

    public int[] getFinishingCord() {
        return this.finishingCord;
    }

    public boolean isAssigned() {
        return this.assigned;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public ArrayList<Road> getPath() {
        return this.path;
    }

    public ArrayList<Serum> getCarriedSerums(){
        return carriedSerums;
    }

    public ArrayList<Pill> getCarriedPills(){
        return carriedPills;
    }

    public int getProgressIndex(){
        return progressIndex;
    }

    public void setProgressIndex(int processIndex){
        this.progressIndex = processIndex;
    }


/*     public Medicine getCarriedMedication() {
        return this.getCarriedMedication;
    }
 */
    //setter methods
    public void setAssignedOrder(boolean assigned){
        this.assigned = assigned;
        assignedOrders.add(this);
    }

    public void setCompletedOrder(boolean completed){
        this.completed = completed;
        completedOrders.add(this);
    }

    public Patients getPatient() {
        return this.orderPatient;
    }


}
