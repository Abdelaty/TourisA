package com.tourisa.models;

import java.io.Serializable;
import java.util.List;

public class Assesstant extends User implements Serializable {
    private float rate;
    private List<Review> reviewList;

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
