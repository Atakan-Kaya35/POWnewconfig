package org.example.powwww.med;

import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.Order;

public class PeriodicSickness extends Sickness{



    public PeriodicSickness(int cycleFreq, Patients patient, Medicine ... neededMeds){
        super(cycleFreq, patient, neededMeds);
    }

    @Override
    public boolean fullCycle(int timeOfDay) {
        if (!neededMeds.isEmpty()) {
            for (int i = 0; i < neededMeds.size(); i++) {
                if (neededMeds.get(i).takePill(timeOfDay)) {
                    Order comingOrder = new Order(this.patient, (Pill)neededMeds.get(i));
                    neededMeds.remove(i);
                    neededMeds.add(comingOrder.getCarriedPills().get(0));
                }
            }
        }

        // TODO: make the reminding system into the cycle

        return false;
    }

    /*
    public boolean fullCycle() {
        for (int i = 0; i < neededMeds.size(); i++) {
            if( neededMeds.get(i).takePill()){
                neededMeds.remove(i);
                new Order(this.patient, (Pill)neededMeds.get(i));
            }
        }

        return false;
    }
    */
/*


    public boolean fullCycle() {
        if (!neededMeds.isEmpty()) {
            Medicine medicine = neededMeds.get(0);
            new Order(this.patient, (Pill)medicine);
            if (medicine.takePill()) {
                neededMeds.remove(0);
            }
        }
        return neededMeds.isEmpty();
    }
*/


}
