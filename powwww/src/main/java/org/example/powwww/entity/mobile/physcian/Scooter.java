package org.example.powwww.entity.mobile.physcian;

import org.example.powwww.grid.Road;
import org.example.powwww.med.Pill;

import java.awt.*;

public class Scooter extends Nurses {

    private static Road cotainedIn;
    final protected int speed = 5;

    private int RADIUS = 5;

    public Scooter(Road cotainedIn){
        super(cotainedIn);
    }

    /*//@Override
    public void receiveOrder(org.example.powwww.grid.Order order){
        this.pillBaggage = order.getCarriedPills();
        this.currentOrder = order;
    }*/

    /**
     * Give all medicines stored in baggage
     * @return baggage
     */
    /*public ArrayList<Pill> getBaggage() {
        return pillBaggage;
    }*/

    /**
     * Nurse added new medine to baggage
     * @param x added medicine
     */
    /*public void addToBaggage(ArrayList<Pill> x) {
        this.pillBaggage = x;
    }*/
    /**
     * When nurse deliver medicine to patient baggage update its current medicines
     * @param x given medicine 
     */
    public void giveMedicine(Pill x){
        this.pillBaggage.remove(x);
    }

    /**
     * Prints all medicines located in the baggage 
     */
    public String toString() {
        String result = "";
        for (Pill x : pillBaggage){
            result += x;
        }
        return result;
    }

    /**
     * Draw van as a red point
     * @param g graphics object
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, RADIUS * 4, RADIUS * 4);
    }
    
}