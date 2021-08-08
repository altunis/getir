package com.getir.service.impl;

import com.getir.domain.Book;
import com.getir.domain.Order;
import com.getir.repository.BookRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int getTotalAmountOrder() {
        System.out.println("zsdas");
        return mongoTemplate.findAll(Order.class).size();
    }

    @Override
    public int getTotalAmountOfBooks() {

        return mongoTemplate.findAll(Book.class).size();
    }
}
