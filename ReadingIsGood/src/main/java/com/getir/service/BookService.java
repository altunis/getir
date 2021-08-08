package com.getir.service;

import com.getir.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

public interface BookService {
    public Book save(Book book);
}
