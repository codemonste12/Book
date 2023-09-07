package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BoDbRepo extends JpaRepository<Book, Long>{
            
}
