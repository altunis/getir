package com.getir.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document
public class ListBetweenDatesRequest {
    private ZonedDateTime date1;
    private ZonedDateTime date2;

    public ListBetweenDatesRequest(ZonedDateTime date1, ZonedDateTime date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public ZonedDateTime getDate1() {
        return date1;
    }

    public void setDate1(ZonedDateTime date1) {
        this.date1 = date1;
    }

    public ZonedDateTime getDate2() {
        return date2;
    }

    public void setDate2(ZonedDateTime date2) {
        this.date2 = date2;
    }
}
