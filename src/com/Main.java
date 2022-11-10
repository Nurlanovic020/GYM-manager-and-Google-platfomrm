package com;

import com.company.GymManager;
import com.company.model.Athlete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GymManager gymManager = new GymManager();

        gymManager.addAthlete("Nodir",75);
        gymManager.addAthlete("Davron",75);
        gymManager.addAthlete("Xayrullo",65);
        gymManager.addAthlete("Dastan",70);

        System.out.println("**************** Get athlete List *************");
        System.out.println(gymManager.getAthleteList());

        System.out.println("***************Get athlete *****************");
        System.out.println(gymManager.getAthlete("Nodir"));
        System.out.println(gymManager.getAthlete("Bobur_aka"));

        gymManager.addExercise("Turnik",100);
        gymManager.addExercise("Tas koteru",200);
        gymManager.addExercise("Brusya",100);
        gymManager.addExercise("Nafas chiqarish",2100);

        System.out.println("************* Get exercise list**************");
        System.out.println(gymManager.getExerciseList());

        System.out.println("*************** Get exercise list **************");
        System.out.println(gymManager.getExercise("Turnik"));
        System.out.println(gymManager.getExercise("Ardjimaniya"));


        System.out.println("****************** add exercise to programm***************");
        gymManager.addExerciseToProgramm("Nodir","Turnik",2,15,3);
        gymManager.addExerciseToProgramm("Ali","Brus",3,10,3);
        gymManager.addExerciseToProgramm("Davron","Tas koteru",2,15,10);
        gymManager.addExerciseToProgramm("Dastan","Press",2,15,3);


        for (Athlete oneAthletelist : gymManager.getAthleteList()) {
            System.out.println(oneAthletelist);
        }


    }


}
