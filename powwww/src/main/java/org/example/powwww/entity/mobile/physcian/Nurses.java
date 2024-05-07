package org.example.powwww.entity.mobile.physcian;
import java.util.ArrayList;

import org.example.powwww.Sim.SimMethods;
import org.example.powwww.entity.mobile.Mobile;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Order;
import org.example.powwww.grid.Road;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Pill;
import org.example.powwww.med.Serum;
import org.example.powwww.Sim.SimMethods;

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
        RIGHT
    }

    ArrowKey direction;


    public Nurses(Road cotainedIn){
        setContainedIn(cotainedIn);
        this.x = cotainedIn.getCoords()[0] * SimMethods.TICKPERDAY;
        this.y = cotainedIn.getCoords()[1] * SimMethods.TICKPERDAY;
    }

    public Nurses(){}

    public boolean move(){
        setDirectionOfTravel();
        if(direction == ArrowKey.UP){
            y -= (36 / currentTrafic);
        } else if(direction == ArrowKey.DOWN){
            y += (36 / currentTrafic);
        } else if(direction == ArrowKey.LEFT){
            x -= (36 / currentTrafic);
        } else {
            x += (36 / currentTrafic);
        }
        return roadUpdateNecessaryCheck();
    }

    private boolean roadUpdateNecessaryCheck(){
        if((x+1) % 36 < 2 && (y+1) % 36 < 2) {
            this.setContainedIn(currentOrder.getPath().get(currentOrder.getProgressIndex() + 1));
            if(x % 5 == 0 && x != 0){
                x ++;
            }
            if(y % 5 == 0 && y != 0){
                y ++;
            }
            currentOrder.setProgressIndex(currentOrder.getProgressIndex() + 1);
            setDirectionOfTravel();
            return true;
        }
        return false;

        /*if((x+1) % 36 < 2 && (y+1) % 36 < 2) {
            if(x % 5 == 0 && x != 0){
                x ++;
            }
            if(y % 5 == 0 && y != 0){
                y ++;
            }
            this.setContainedIn(city.getRoad((x / 36), (y / 36)));
            return true;
        }
        return false;
        */
    }

    private void setDirectionOfTravel(){
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
        }catch (Exception e){
            System.out.println("Check your indexes in Move!");
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
}
