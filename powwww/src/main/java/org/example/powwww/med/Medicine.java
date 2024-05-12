package org.example.powwww.med;

import org.example.powwww.entity.*;
/**
 * medicine
 */
public abstract class Medicine {
    protected static int ID = 0;
    protected double price;
    protected String name;
    protected String description;
    protected boolean[] consumeFreq = new boolean[3];
    protected int cyclesLeft = -1;

    Medicine(String name, String desciption){
        this.name = name;
        this.description = desciption;
    }
    Medicine(){

    }

    /**
     * Action when a pill is taken
     * @return a boolean that states if the medicine is done being used
     */
    public boolean takePill(int timeOfDay){

        if(consumeFreq[timeOfDay])
        {
            this.cyclesLeft--;
            if(this.cyclesLeft < 1){
                return true;
            }
            else{
                return false;
            }
        }
        // the medicin need not be taken at this
        return false;
    }

    public boolean[] getConsumeFreq() {
        return consumeFreq;
    }

    public void setConsumeFreq(boolean[] consumeFreq) {
        this.consumeFreq = consumeFreq;
    }

    public int getCyclesLeft() {
        return cyclesLeft;
    }

    public void setCyclesOfTaking(int cyclesOfTaking) {
        this.cyclesLeft = cyclesOfTaking;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    /**
     * Assign a price to each medicine. (in order to calculate totol price that cart has)
     * @param price medicine price
     */
    public void setPrice(double price){
        this.price = price;
    }
    public static int getID() {
        return ID;
    }
}