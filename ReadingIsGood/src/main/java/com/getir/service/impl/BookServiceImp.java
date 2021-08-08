package com.getir.service.impl;

import com.getir.domain.Book;
import com.getir.domain.UpdateBookStock;
import com.getir.repository.BookRepository;
import com.getir.service.BookService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImp implements BookService {
    private BookRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public BookServiceImp(BookRepository repo,MongoTemplate template){
        this.mongoTemplate = template;
        this.repository=repo;
    }
    @Override
    public  Book save(Book book) {
        return repository.save(book);
    }

    public Book updateBookStock(UpdateBookStock bookStock) throws Exception {
        if(bookStock.getStock()<0){
            throw new Exception("book stock should be greater than zero");
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is((bookStock.getId())));
        Update update = new Update();
        update.set("stock", bookStock.getStock());
        Book book = (mongoTemplate.findAndModify(query, update,
                FindAndModifyOptions.options().returnNew(true), Book.class));
        if(book == null){
            throw new Exception("No Book defined with such id");
        }

        return book;
    }
}
