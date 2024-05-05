package org.example.powwww.entity.mobile.physcian;
import java.util.ArrayList;

import org.example.powwww.entity.mobile.Mobile;
import org.example.powwww.grid.Order;
import org.example.powwww.grid.Road;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Pill;
import org.example.powwww.med.Serum;

public class Nurses extends Mobile {
    
    protected ArrayList<Serum> serumBaggage = new ArrayList<>();
    protected ArrayList<Pill> pillBaggage = new ArrayList<>();
    protected ArrayList<Medicine> baggage = new ArrayList<Medicine>();
    protected String name;
    protected Order currentOrder;

    public Nurses(){
        
    }

    Nurses(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    
    /**
     * Give all medicines stored in baggage
     * @return baggage
     */
    public ArrayList<Medicine> getBaggage() {
        return baggage;
    }

    /**
     * Nurse added new medine to baggage
     * @param x added medicine
     */
    public void addToBaggage(ArrayList<Medicine> x) {
        this.baggage = x;
    }
    /**
     * When nurse deliver medicine to patient baggage update its current medicines
     * @param x given medicine 
     */
    public void giveMedicine(Medicine x){
        this.baggage.remove(x);
    }

    /**
     * Prints all medicines located in the baggage 
     */
    public String toString() {
        String result = "";
        for (Medicine x : baggage){
            result += x;
        }
        return result;
    }
    
    public Order getCurrentOrder(){
        return currentOrder;
    }

    public void setCurrentOrder(Order newOrder){
        this.currentOrder = newOrder;
    }
    
}
