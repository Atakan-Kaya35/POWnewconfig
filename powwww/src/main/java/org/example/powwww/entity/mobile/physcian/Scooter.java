package org.example.powwww.entity.mobile.physcian;

import org.example.powwww.grid.Road;
import org.example.powwww.med.Pill;

import java.awt.*;

public class Scooter extends Nurses {
    public Scooter(){}
    private static Road cotainedIn;
    final protected int speed = 5;

    private int RADIUS = 15;

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
        g.fillOval(36+x-RADIUS/2, 36 + y-RADIUS/2, RADIUS, RADIUS);
        Graphics2D a = (Graphics2D)g;
        g.setColor(Color.black);
        a.setFont(new Font("Arial", Font.BOLD, 12));
        a.drawString("" + this.ID,36+ x-RADIUS/2, 36+y-RADIUS/2 + RADIUS);
    }

    public void drawIdle(Graphics g)
    {
        g.setColor(Color.lightGray);
        g.fillOval(36+x-RADIUS/2, 36 + y-RADIUS/2, RADIUS, RADIUS);
        Graphics2D a = (Graphics2D)g;
        g.setColor(Color.blue);
        a.drawString("" + this.ID,36+ x-RADIUS/2, 36+y-RADIUS/2 + RADIUS);
    }
    
}