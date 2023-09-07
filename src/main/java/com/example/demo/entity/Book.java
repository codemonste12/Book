package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Book_details") //name of table which will be created in database by orm
public class Book {
	
	@Id   //primary key of table
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //will auto_increment this value
      long id;
	  @Column(nullable=false,unique=true) //title will not be null and unique
	  @NotEmpty(message ="Title cannot be emtpy")
	  @Size(min =3,message = "Title should be minimum of three letter")
      String title;
      String author;
      @Column(name="Publish")
      boolean published;
	public Book(long id, String title, String author, boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.published = published;
		
		
		
		
		
	}
      
      
      
}
