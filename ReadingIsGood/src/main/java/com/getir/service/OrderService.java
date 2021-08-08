package com.getir.service;

import com.getir.domain.Order;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> listOrdersBetweenDates(ZonedDateTime date1, ZonedDateTime date2);
    public Optional<Order> findById(String id);
    public Order save(Order order) throws Exception;
    public List<Order> listOrdersByCustomer(String customerId) throws Exception;
    public List <Order> findAllOrders();
}
