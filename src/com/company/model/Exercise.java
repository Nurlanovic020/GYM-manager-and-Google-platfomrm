package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String exerCiseOfName;
    private Double coeffitcient;

    List<Athlete> exercisesList = new ArrayList<>();

    public Exercise() {}

    public Exercise(String exerCiseOfName, Double coeffitcient) {
        this.exerCiseOfName = exerCiseOfName;
        this.coeffitcient = coeffitcient;
    }

    public String getExerCiseOfName() {
        return exerCiseOfName;
    }

    public void setExerCiseOfName(String exerCiseOfName) {
        this.exerCiseOfName = exerCiseOfName;
    }

    public Double getCoeffitcient() {
        return coeffitcient;
    }

    public void setCoeffitcient(Double coeffitcient) {
        this.coeffitcient = coeffitcient;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerCiseOfName='" + exerCiseOfName + '\'' +
                ", coeffitcient=" + coeffitcient +
                '}';
    }
}
