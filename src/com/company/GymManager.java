package com.company;

import com.company.model.Athlete;
import com.company.model.Exercise;
import com.company.model.OneAthletelist;

import java.util.ArrayList;
import java.util.List;

public class GymManager {
    private boolean turnOnOrTurnOff = false;
    private boolean done = false;

    List<Exercise> exerciseList = new ArrayList<>();
    List<Athlete> athleteList = new ArrayList<>();
    List<OneAthletelist> oneAlthletelists = new ArrayList<>();

    private OneAthletelist oneAthletelist = new OneAthletelist();

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    public List<OneAthletelist> getOneAlthletelists() {
        return oneAlthletelists;
    }

    public void addAthlete(String name,double weight){
        if(weight <= 0)     return;
        Athlete athlete = getAthleteByName(name);
        if(athlete != null) return;

        athleteList.add(new Athlete(name,weight));
    }
    public Athlete getAthleteByName(String name) {
        if (name == null || name.isBlank()) return null;
        for (Athlete athlete : athleteList) {
            if (athlete.getName().equalsIgnoreCase(name)) {
                return athlete;
            }
        }
        return null;
    }

   public String getAthlete(String name){
        Athlete athlete = getAthleteByName(name);
        if(athlete != null) return athlete.getName() + " " + athlete.getWeigth();

        return "Sportsmen qani ? ";
   }

   public void addExercise(String name,double coefficient){
        if(coefficient <= 0) return;

        Exercise exercise = getExerciseByname(name);
        if(exercise != null) return;

        exerciseList.add(new Exercise(name,coefficient));
   }

    private Exercise getExerciseByname(String name) {
        if(name == null || name.isBlank()) return null;
        for (Exercise exercise : exerciseList) {
            if(exercise.getExerCiseOfName().equalsIgnoreCase(name)){
                return exercise;
            }
        }
        return null;
     }


     public String getExercise(String name){
        Exercise exercise = getExerciseByname(name);
        if(exercise != null ) return exercise.getExerCiseOfName() + "  " + exercise.getCoeffitcient();
        return "Mash qani ?";
    }

     public void addExerciseToProgramm(String nameAthlete,String nameExercise,
                                       int series,int repetitions, double weigth){


        Athlete athlete = getAthleteByName(nameAthlete);
        if(athlete == null){
            System.out.println("Sportsmen qani ? ");
        }
        if(series <= 0){
            System.out.println("Kamida 1 marta "+ nameExercise + " mashqni bajarish kerak");
            return;
        }

        if(repetitions <= 0){
            System.out.println("Kamida 1 marta "+ nameExercise + " mashqni takrorlash kerak");
            return;
        }

        if (weigth <= 0){
            System.out.println("Og'irlik kamida 1kg bo'lishi kerak. ");
            return;
        }


        OneAthletelist oneAthletelistObject = new OneAthletelist(nameAthlete,nameExercise,series,repetitions,weigth);
        oneAlthletelists.add(oneAthletelistObject);
         System.out.println("Added yangi ism ");

//        oneAthletelistObject.setAthleteName(nameAthlete);
//        oneAthletelistObject.setExerciseName(nameExercise);
//        oneAthletelistObject.setRepetitions(repetitions);
//        oneAthletelistObject.setSeries(series);
//        oneAthletelistObject.setWeight(weight);
         System.out.println(nameAthlete + ", "+ nameExercise + ", "+ series + ". " + repetitions + ", " + weigth);


     }



     public void trainingStart(String nameAthlete, String nameExercise){
        Athlete athlete = getAthleteByName(nameAthlete);
        if(athlete == null){
            System.out.println("Sportsmen qani?");
            return;
        }

        Exercise exercise = getExerciseByname(nameExercise);
        if(exercise == null){
            System.out.println("Mashq qani ?");
            return;
        }

         for (OneAthletelist athletelist : oneAlthletelists) {
             if (athletelist.getAthleteName().equalsIgnoreCase(nameAthlete) &&
                     athletelist.getExerciseName().equalsIgnoreCase(nameExercise)) {
                 athletelist.setStatus("process");
             }
         }
         System.out.println("Mashqlarni bajarish boshlandi!!!");
         turnOnOrTurnOff = true;


     }

     public void trainingEnd(String nameAthlete, String nameExercise){
        Athlete athlete = getAthleteByName(nameAthlete);
        if(athlete == null){
            System.out.println("Sportsmen qani?");
            return;
        }

        Exercise exercise = getExerciseByname(nameExercise);
        if(exercise == null){
            System.out.println("Mashq qani?");
            return;
        }

         for (OneAthletelist athletelist : oneAlthletelists) {
             if (athletelist.getAthleteName().equalsIgnoreCase(nameAthlete) &&
                     athletelist.getExerciseName().equalsIgnoreCase(nameExercise)
                     && athletelist.getExerciseName().equalsIgnoreCase(nameExercise)) {
                 athletelist.setStatus("process");
             }
         }
         System.out.println("Mashqlar tugatildi!!!");
         return;

     }

     public double caloriesBrunt(String nameAthlete){
        double sum = 0;
        double weigthOfAthlete = 0;

        Exercise exercise = new Exercise();

        Athlete athlete = getAthleteByName(nameAthlete);
        if(athlete == null) return -1;

         for (OneAthletelist athletelist1 : oneAlthletelists) {
             if (athletelist1.getStatus().equalsIgnoreCase("end")
                     && athletelist1.getAthleteName().equalsIgnoreCase(nameAthlete)) {
                 sum += athletelist1.getCoffitsient() * athletelist1.getSeries()
                         * athletelist1.getRepetitions() * (athlete.getWeigth() + athletelist1.getWeight());
             }
         }

         return sum;


     }

     public double caloriesTarget(String nameAhlete){
        int sum = 0;
        Athlete athlete = getAthleteByName(nameAhlete);
        if(athlete == null) return -1;

         for (OneAthletelist athletelist1 : oneAlthletelists) {
             if (athletelist1.getAthleteName().equalsIgnoreCase(nameAhlete)) {
                 sum += athletelist1.getCoffitsient() * athletelist1.getSeries()
                         * athletelist1.getRepetitions() * (athlete.getWeigth() + athletelist1.getWeight());
             }
         }
         return 0;
     }

     public String score(String nameAthlete){
        double caloriesBrunt = caloriesBrunt(nameAthlete);
        double caloriesTarget = caloriesTarget(nameAthlete);

        if(caloriesBrunt == -1 || caloriesTarget == -1){
            return "Error";

        }

        double result = caloriesBrunt / caloriesTarget;

        if(result >= 1 ){
            return "Good";
        } else if (result < 1 && result > 0.8) {
            return "Average";

        }
        return "Bad";
     }

    public String worstExercise(String nameAthlete) {
        Athlete athlete = getAthleteByName(nameAthlete);
        if (athlete != null) return "Not found name";

        double caloriya = 0;

        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getAthleteName().equalsIgnoreCase(nameAthlete)) {
                caloriya = oneAlthletelists.get(i).getCoffitsient();
                break;
            }
        }

        double minimum = caloriya;
        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getAthleteName().equalsIgnoreCase(nameAthlete)) {
                caloriya = Math.min(oneAlthletelists.get(i).getCoffitsient(), caloriya);
            }
        }

        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getCoffitsient() == caloriya) {
                return oneAlthletelists.get(i).getExerciseName();
            }
        }

        return null;
    }

    public String bestExercise(String nameAthlete) {
        Athlete athlete = getAthleteByName(nameAthlete);
        if (athlete != null) return "Not found name";

        double caloriya = 0;

        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getAthleteName().equalsIgnoreCase(nameAthlete)) {
                caloriya = oneAlthletelists.get(i).getCoffitsient();
                break;
            }
        }

        double minimum = caloriya;
        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getAthleteName().equalsIgnoreCase(nameAthlete)) {
                caloriya = Math.max(oneAlthletelists.get(i).getCoffitsient(), caloriya);
            }
        }

        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getCoffitsient() == caloriya) {
                return oneAlthletelists.get(i).getExerciseName();
            }
        }

        return null;
    }

    public String exercisesByPerformance(String nameAthlete) {
        String result = "";
        Athlete athlete = getAthleteByName(nameAthlete);
        if (athlete ==null)return result;

        for (int i = 0; i < oneAlthletelists.size(); i++) {
            if (oneAlthletelists.get(i).getAthleteName().equalsIgnoreCase(nameAthlete)) {
                if (oneAlthletelists.get(i).getStatus().equalsIgnoreCase("end")) {
                    result += oneAlthletelists.get(i).getExerciseName() + "   " +
                            +(oneAthletelist.getCoffitsient() * oneAthletelist.getSeries()
                                    * oneAthletelist.getRepetitions() * (athlete.getWeigth() + oneAthletelist.getWeight()));
                }
            }
        }

        return result;
    }


    public String exercisesByExecutionOrder(String nameAthlete) {
        return null;
    }



}
