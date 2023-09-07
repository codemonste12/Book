package com.example.demo.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BoDbRepo;
//import com.example.demo.Repository.BookRepo;
import com.example.demo.entity.Book;
import com.example.demo.exception.BoException;

@Service
public class BookService {
          @Autowired
         BoDbRepo boRepo;
          
          public List<Book> findAll(Pageable pa){
        	  return boRepo.findAll(pa).toList();
          }
          
          public Book findByID(long id)
          {
        	  Optional<Book> b = boRepo.findById(id);
                  return b.orElseThrow( ()-> new BoException("Book Not Found") );
        	}
          
          public Book updateBook(long id,Book bo) {
        	  Book book1=findByID(id);
          	book1.setAuthor(bo.getAuthor());
          	book1.setTitle(bo.getTitle());
          	book1.setPublished(bo.isPublished());
          	boRepo.save(book1);
          	return book1;
          }
          
          public Book addBook(Book b) {
          	return boRepo.save(b);
          }
          
          public void deleteBook(long id) {
        	  
        	  Book b = findByID(id);
        	  boRepo.delete(b);
          }
}
