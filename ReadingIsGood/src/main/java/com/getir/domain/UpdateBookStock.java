package com.getir.domain;

import org.bson.types.ObjectId;

public class UpdateBookStock {

    private int stock;
    private String id;

    public UpdateBookStock(int stock, String id) {
        this.stock = stock;
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
