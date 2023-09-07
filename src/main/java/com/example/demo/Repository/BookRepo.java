package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.exception.BoException;

@Repository
public class BookRepo {
        List<Book> books = new ArrayList<>();
        
        public BookRepo()
        {
        	books.add( new Book( 1l , "C++" , "YOU" , false ) );
        	
        	books.add( new Book( 2l , "C++" , "YOU" , false ) );
        }
         
        public List<Book> findAll(){
        	return books;
        }
        
        public Book findByID(long id) {
        	Optional<Book> b = books.
		                           stream().
	                                   filter( (bo) -> bo.getId()==id).
	                                      findAny();
            return b.orElseThrow( ()-> new BoException("Book Not Found") );
        }
        
        public Book save(Book book) {
        	books.add(book);
        	return book;
        }
        
        public Book update(long id,Book bo) {
        	Book book1=findByID(id);
        	book1.setAuthor(bo.getAuthor());
        	book1.setTitle(bo.getTitle());
        	book1.setPublished(bo.isPublished());
        	return book1;
        }
        
        public void delete(long id) {
        	Book book1 =findByID(id);
        	books.remove(book1);
        }
        
}
