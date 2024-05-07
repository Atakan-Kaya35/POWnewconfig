package org.example.powwww.entity.stationary;

import java.util.ArrayList;

import org.example.powwww.grid.City;
import org.example.powwww.grid.Stationary;
import org.example.powwww.med.Pill;

public class Pharmacy extends Stationary {
    
    protected String name;
    protected int range;
    protected ArrayList arsenal;

    public Pharmacy(int x, int y, int range, String name, City city){
        
        super(x, y, city);
        this.range = range;
        this.name = name; 
        arsenal = new ArrayList<>();
        arsenal.add(Pill.OTCpills.subList(1,5));
        arsenal.add(Pill.prescribedPills.subList(1,20));

    }
}
