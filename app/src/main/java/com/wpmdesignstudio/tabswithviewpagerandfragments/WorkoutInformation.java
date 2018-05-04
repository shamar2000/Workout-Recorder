package com.wpmdesignstudio.tabswithviewpagerandfragments;


import java.io.Serializable;

public class WorkoutInformation implements Serializable {

    private int setNumber;
    private int repNumber;
    private int weightNumber;

    public WorkoutInformation(int setNumber, int weightNumber, int repNumber) {
        this.setNumber = setNumber;
        this.repNumber = repNumber;
        this.weightNumber = weightNumber;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(int repNumber) {
        this.repNumber = repNumber;
    }

    public int getWeightNumber() {
        return weightNumber;
    }

    public void setWeightNumber(int weightNumber) {
        this.weightNumber = weightNumber;
    }
}
