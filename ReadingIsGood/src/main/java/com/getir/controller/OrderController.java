package com.getir.controller;

import com.getir.domain.Customer;
import com.getir.domain.ListBetweenDatesRequest;
import com.getir.domain.Order;
import com.getir.service.impl.CustomerServiceImpl;
import com.getir.service.impl.OrderServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl service){
        this.orderService = service;
    }
    @PostMapping(value = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order save(@RequestBody Order request) throws Exception {

        return orderService.save(request);
    }



    @GetMapping(value = "/getOrderBetweenDates")
    public List<Order> getOrders(@RequestParam String date1,@RequestParam String date2) throws Exception {

        return orderService.listOrdersBetweenDates(ZonedDateTime.parse(date1),ZonedDateTime.parse(date2));
    }


    @GetMapping(value = "/getOrderByCustomer" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrdersByCustomer(@RequestParam String id) throws Exception {

        return orderService.listOrdersByCustomer(id);
    }



}
