package com.smtrsolutions.test.services.callbacks;

/**
 * Created by edwinalvarado on 2/12/19.
 * Copyright © 2017 edwinalvarado. All rights reserved.
 */

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseProducts {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("baskets")
    @Expose
    private List<Integer> baskets = null;
    @SerializedName("unit_cost")
    @Expose
    private Double unitCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Integer> baskets) {
        this.baskets = baskets;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getBasketSum(){

        //int sum = IntStream.of(this.baskets).sum(); // for array but we got a list so

        int sum = 0;

        for(int i = 0; i < this.baskets.size(); i++)
            sum += this.baskets.get(i);

        return String.valueOf(sum);

    }

    public Integer getBasketCount(){
        return this.baskets.size();
    }

    public String getBasketStringCount(){
        return String.valueOf(this.baskets.size());
    }

}