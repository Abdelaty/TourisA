package com.tourisa.models;

import java.io.Serializable;

public class Review implements Serializable {
    private String description;
    private float rate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
