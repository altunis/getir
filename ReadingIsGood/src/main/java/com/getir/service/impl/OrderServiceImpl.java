package com.getir.service.impl;

import com.getir.domain.Book;
import com.getir.domain.Order;
import com.getir.repository.OrderRepository;
import com.getir.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public OrderServiceImpl(OrderRepository repo,MongoTemplate template){
        this.mongoTemplate = template;
        this.repository=repo;
    }
    @Override
    public List<Order> listOrdersBetweenDates(ZonedDateTime date1, ZonedDateTime date2) {

        Query query = new Query();
        query.addCriteria(Criteria.where("orderedDate").gte(date1).lt(date2));
        List<Order> orders = mongoTemplate.find(query,Order.class);
        return orders;

    }

    @Override
    public Optional<Order> findById(String id) {
        return repository.findById(id);
    }


    @Override
    public Order save(Order order) throws Exception {
        Book book = mongoTemplate.findById(order.getBookId(), Book.class);
        if(book == null){
            throw new Exception("No book with such a id");

        }if(book.getStock()<=0){
            throw new Exception("No stock for book");
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(book.getId()));
        Update update = new Update();
        update.set("stock", book.getStock()-1);
         mongoTemplate.findAndModify(query, update,
                FindAndModifyOptions.options().returnNew(true), Book.class);
        return repository.save(order);
    }

    @Override
    public List<Order> listOrdersByCustomer(String customerId) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerId").is(customerId));
        List<Order> orders = (mongoTemplate.find(query, Order.class));
        if(orders == null || orders.size()==0){
            throw new Exception("No order found");
        }

        return orders;
    }

    @Override
    public List<Order> findAllOrders() {
        return repository.findAll();
    }
}
