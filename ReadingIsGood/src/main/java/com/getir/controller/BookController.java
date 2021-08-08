package com.getir.controller;


import com.getir.domain.Book;
import com.getir.domain.UpdateBookStock;
import com.getir.repository.BookRepository;
import com.getir.service.BookService;
import com.getir.service.impl.BookServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookServiceImp bookService;
    public BookController(BookServiceImp service){
        this.bookService = service;
    }
    @PostMapping(value = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ApiOperation(value = "", notes = "save campaign")
    public Book save(@RequestBody Book request) {
            var book = request;
            return bookService.save(request);
    }

    @PutMapping(value="/updateBookStock", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStock(@RequestBody UpdateBookStock request) throws Exception {
        try {
            return ResponseEntity.ok(bookService.updateBookStock(request).toString());
        }
        catch (Exception e){
            return ResponseEntity.ok("{\"error\" : "+e.getMessage());
        }
    }

}
