package com.getir.service.impl;

import com.getir.domain.Customer;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public CustomerServiceImpl(CustomerRepository repo,MongoTemplate template){
        this.mongoTemplate = template;
        this.repository=repo;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }


}
