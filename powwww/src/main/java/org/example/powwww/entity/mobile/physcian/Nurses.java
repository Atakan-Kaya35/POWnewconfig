package org.example.powwww.entity.mobile.physcian;
import java.util.ArrayList;

import org.example.powwww.MapGridTaslak.GridFrame;
import org.example.powwww.Sim.SimMethods;
import org.example.powwww.entity.mobile.Mobile;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Order;
import org.example.powwww.grid.Road;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Pill;

public class Nurses extends Mobile {
    
    protected ArrayList<Pill> pillBaggage = new ArrayList<>();
    protected ArrayList<Medicine> baggage = new ArrayList<Medicine>();
    protected String name;
    protected Order currentOrder;
    protected City city;
    protected int x;
    protected int y;
    protected int currentTrafic;

    public enum ArrowKey {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        STAY
    }

    ArrowKey direction;

    public Nurses(){
        super();
    }
    public Nurses(Road cotainedIn){
        super(cotainedIn);
        this.city = cotainedIn.getCity();
        city.addNurse(this);
        this.x = cotainedIn.getCoords()[0] * GridFrame.EACH_SQUARE;
        this.y = cotainedIn.getCoords()[1] * GridFrame.EACH_SQUARE;
    }

    public boolean move(){
        if(currentOrder != null){
            setDirectionOfTravel();
            if (direction == ArrowKey.UP) {
                y -= (36 / currentTrafic);
            } else if (direction == ArrowKey.DOWN) {
                y += (36 / currentTrafic);
            } else if (direction == ArrowKey.LEFT) {
                x -= (36 / currentTrafic);
            } else if(direction == ArrowKey.RIGHT){
                x += (36 / currentTrafic);
            }
            return roadUpdateNecessaryCheck();
        }
        else{
            x = this.getContainedIn().getCoords()[0]*36;
            y = this.getContainedIn().getCoords()[1]*36;
            direction = ArrowKey.STAY;
        }
        return false;
    }

    private boolean roadUpdateNecessaryCheck(){
        if((x % 36) < 6 && (y % 36) < 6) {
            this.moveForth(currentOrder.getPath().get(currentOrder.getProgressIndex() + 1));

            x = this.getContainedIn().getCoords()[0]*36;
            y = this.getContainedIn().getCoords()[1]*36;

            currentOrder.setProgressIndex(currentOrder.getProgressIndex() + 1);
            setDirectionOfTravel();
            return true;
        }
        return false;
    }

    private void setDirectionOfTravel(){
        try{
            currentTrafic = city.getTrafficBetweenRoads(currentOrder.getPath().get(currentOrder.getProgressIndex()), currentOrder.getPath().get(currentOrder.getProgressIndex() + 1));

            try {
                if ((currentOrder.getPath().get(currentOrder.getProgressIndex()).getCoords()[0] - currentOrder.getPath().get(currentOrder.getProgressIndex() + 1).getCoords()[0]) > 0) {
                    direction = ArrowKey.LEFT;
                } else if ((currentOrder.getPath().get(currentOrder.getProgressIndex()).getCoords()[1] - currentOrder.getPath().get(currentOrder.getProgressIndex() + 1).getCoords()[1]) > 0) {
                    direction = ArrowKey.UP;
                } else if ((currentOrder.getPath().get(currentOrder.getProgressIndex()).getCoords()[0] - currentOrder.getPath().get(currentOrder.getProgressIndex() + 1).getCoords()[0]) < 0) {
                    direction = ArrowKey.RIGHT;
                } else if ((currentOrder.getPath().get(currentOrder.getProgressIndex()).getCoords()[1] - currentOrder.getPath().get(currentOrder.getProgressIndex() + 1).getCoords()[1]) < 0) {
                    direction = ArrowKey.DOWN;
                }
            } catch (Exception e) {
                System.out.println("Check your indexes in Move!");
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("end of road");
            direction = ArrowKey.STAY;
            //currentOrder.getPatient().setCurrentOrder(null);
            currentOrder = null;
        }
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

    public void receiveOrder(org.example.powwww.grid.Order order){
        if(currentOrder == null) {
            this.pillBaggage = order.getCarriedPills();
            this.currentOrder = order;
        }
    }
}
