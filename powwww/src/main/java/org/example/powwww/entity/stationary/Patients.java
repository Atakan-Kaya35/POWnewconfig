package org.example.powwww.entity.stationary;
import java.awt.*;
import java.util.ArrayList;

import org.example.powwww.grid.City;
import org.example.powwww.grid.Order;
import org.example.powwww.med.Medicine;
import org.example.powwww.med.Sickness;

public class Patients extends org.example.powwww.grid.Stationary {
    public Patients(){}
    protected ArrayList<Medicine> cart = new ArrayList<Medicine>();
    protected ArrayList<Sickness> sicknesses = new ArrayList<Sickness>();
    protected ArrayList<Order> orderList = new ArrayList<Order>();
    private Order currentOrder;
    ArrayList<Order> prevOrders;
    private final int RADIUS = 5;


    protected City city;

    /*public Patients(){
        super(0, 0);
    }*/

    public Patients(String name, int x, int y, City city){
        super(x, y,city);
        this.name = name;
        this.city = city;
    }
    public void draw(Graphics g, Color color){
        g.setColor(color);
        g.fillOval(getCoordinates()[0]*36+54, getCoordinates()[1]*36+54, RADIUS * 2, RADIUS * 2);
    }
    public String getPatientsName(){
        return this.name;
    }
    public void addMedicine(Medicine x){
        cart.add(x);
    }
    public ArrayList<Medicine> getCart(){
        return cart;
    }
    public int getCartSize(){
        return cart.size();
    }
    
    /**
     * Make cart empty when patients purchase all their medicines
     */
    public void setCartNull(){
        this.cart = new ArrayList<Medicine>();
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<Sickness> getSicknesses() {
        return sicknesses;
    }
    public void addSickness(Sickness sickness) {
        this.sicknesses.add(sickness);
    }
    public void removeSickness(Sickness sickness) {
        this.sicknesses.remove(sickness);
    }

    public void patientCycle(int timeOfDay){
        for (int i = 0; i < sicknesses.size(); i++){

            // TODO: Creater an order automatically if the patient has run out of medicine

            Sickness sick = sicknesses.get(i);
            if(sick.fullCycle(timeOfDay)){
                sicknesses.remove(i);
                i --;
            }
        }
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order newOrder){
        if (this.prevOrders == null) {
            this.prevOrders = new ArrayList<>();
        }
        this.prevOrders.add(newOrder);
        this.currentOrder = newOrder;
    }

}
