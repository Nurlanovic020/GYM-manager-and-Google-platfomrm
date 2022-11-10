package com.company.model;

public class Athlete {
    private String name;
    private Double weigth;

    public Athlete(String name, Double weigth) {
        this.name = name;
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
