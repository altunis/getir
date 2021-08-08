package com.getir.domain;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document
public class Order {

    @Id
    @Hidden
    private String id;
    private String customerId;
    private String bookId;
    private ZonedDateTime orderedDate;

    public Order(String customerId, String bookId, ZonedDateTime orderedDate) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.orderedDate = orderedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public ZonedDateTime getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(ZonedDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }

}
