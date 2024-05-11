package org.example.powwww.Database;

public class SQLExampleCreator {
    public static void main(String[] args){
        SQLTest.addUser("kaya", "35gevrek", 18,
                "Atakan Kaya", 85, 187, 20,10);

        SQLTest.addUser("tuncturk", "vanli65", 19,
                "Burkay Tuncturk", 72, 187, 20,16);

        SQLTest.addUser("sesen", "eceninpartievi", 19,
                "Ece Sesen", 65, 178, 16,18);

        SQLTest.addUser("suci", "25dadas25", 19,
                "Mest Suci", 82, 184, 5,5);
    }
}