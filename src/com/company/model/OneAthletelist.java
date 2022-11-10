package com.company.model;

public class OneAthletelist {
    protected String athleteName;
    protected String exerciseName;
    protected int series;
    protected int repetitions;
    protected double weight;
    protected double coffitsient;
    protected String status = "new";

    public OneAthletelist() {}

    public OneAthletelist(String athleteName, String exerciseName,
              int series, int repetitions, double weight) {
        this.athleteName = athleteName;
        this.exerciseName = exerciseName;
        this.series = series;
        this.repetitions = repetitions;
        this.weight = weight;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCoffitsient() {
        return coffitsient;
    }

    public void setCoffitsient(double coffitsient) {
        this.coffitsient = coffitsient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OneAthletelist{" +
                "athleteName='" + athleteName + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", series=" + series +
                ", repetitions=" + repetitions +
                ", weight=" + weight +
                ", coffitsient=" + coffitsient +
                ", status='" + status + '\'' +
                '}';
    }
}
