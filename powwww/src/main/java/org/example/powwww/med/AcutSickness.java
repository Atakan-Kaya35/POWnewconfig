package org.example.powwww.med;


import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.Order;

public class AcutSickness extends Sickness{

    protected int cyclesLeft;
    private boolean done = false;

    public AcutSickness(int cycles, int cycleFrequency, Patients patient, Medicine ... neededMeds) {
        super(cycleFrequency, patient, neededMeds);
        this.cyclesLeft = cycles;

        for (Medicine medicine : neededMeds) {
            new Order(patient, medicine);
        }
    }

    /**
     * @return a boolean stating whether the treatment for the sickness has been concluded
     */
    public boolean fullCycle(int timeOfDay) {
        if (!neededMeds.isEmpty()) {
            for (int i = 0; i < neededMeds.size(); i++) {
                if (neededMeds.get(i).takePill(timeOfDay)) {
                    neededMeds.remove(i);
                }
            }
        }

        // TODO: make the reminding system into the cycle

        done = neededMeds.isEmpty();
        return done;
    }



    /*     bence bu metod işe yaramaz.
    public boolean fullCycle(){
        for (int i = 0; i < neededMeds.size(); i++) {
            if( neededMeds.get(i).takePill()){
                neededMeds.remove(i);
            }
        }

        // TODO: make the reminding system into the cycle

        if( neededMeds.size() == 0){
            done = true;
            return true;
        }
        else return false;
    }
    */

    public boolean getIfDone(){
        return done;
    }

}
