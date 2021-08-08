package com.getir.controller;

import com.getir.domain.Customer;
import com.getir.service.impl.StatisticsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsServiceImpl statisticsService;
    @GetMapping(value = "/getTotalAmountOfOrder")
    public int getTotalAmountOfOrder() {
        return statisticsService.getTotalAmountOrder();
    }

    @GetMapping(value = "/getTotalAmountOfBooks")
    public int getTotalAmountOfBook() {
        return statisticsService.getTotalAmountOfBooks();
    }
}
