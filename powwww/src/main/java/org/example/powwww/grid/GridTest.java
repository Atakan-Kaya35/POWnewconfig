package org.example.powwww.grid;

import java.util.List;

import org.example.powwww.entity.mobile.Mobile;
import org.example.powwww.entity.mobile.physcian.*;
import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.stationary.Patients;

public class GridTest {
    public static void main(String[] args) {
        
        City city = new City(12, 12);
        Mobile a = new Van(city.getRoad(0,0));
        city.setRoad(a, 0,0);
        city.setRoad(a, 0,0);
        Patients b = new Patients(9,9, city);
        city.buildCustomeStationary(9,9, 1,1);     //We already passed the coordinates of stationary by using "b". Not need!!!!!!!!!!?

        city.buildCustomeStationary(0,1, 9,6);

        int[] newTraffic = {10,14};
        city.getRoad(10, 5).setTraffic(newTraffic);


        List<Road> d = city.findPath((Nurses)a, b);
        System.out.println(city.viewMap(false));
        System.out.println("a");
        for (int i = 0; i< city.wholeWay.size(); i++) {
            
                System.out.println(city.wholeWay.get(i).get(0)+ " " + city.wholeWay.get(i).get(1));
                        
        }  // bu a neden acaba...gercek bir gizem -> map printinin gerçekten bittiğini anlamak için bence :)

        //Mutlulukkk a* a kurban olim
    }
}
