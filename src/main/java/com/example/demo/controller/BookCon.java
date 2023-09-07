package com.example.demo.controller;


import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;

@RestController
@RequestMapping("/api/v1/books") //common uri for all requests

public class BookCon {
        
	@Autowired
	BookService service;
	
	
	//http://localhost:1010/api/v1/books
	@GetMapping
	public ResponseEntity< List< Book >> getAllBooks(Pageable pa){
		return new ResponseEntity<List<Book>> (service.findAll(pa),HttpStatus.OK);
	}
	
	//http://localhost:1010/api/v1/books/id
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable long id) {
		return new ResponseEntity<Book> (service.findByID(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> addBooks(@RequestBody Book bo){
		return new ResponseEntity<Book>(service.addBook(bo),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")	 
    public ResponseEntity<Book> updateBooks(@RequestBody Book bo, @PathVariable("id") Long boId)
    {
        return new ResponseEntity<Book>(service.updateBook(boId, bo),HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/delete/{id}")	 
    public String delById(@PathVariable("id")
                                       Long Id)
    {
        service.deleteBook(Id);
        return "Deleted Successfully";
    }
	
	
}
