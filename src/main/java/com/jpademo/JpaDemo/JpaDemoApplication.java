package com.jpademo.JpaDemo;

import com.jpademo.JpaDemo.DAO.BookDAO;
import com.jpademo.JpaDemo.Entity.Books;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);

	}

//	@Bean
//	public CommandLineRunner commandLineRunner(BookDAO bookDAO){
//		return runner->{
//			createBook(bookDAO);
//		};
//	}
//
//	private void createBook(BookDAO bookDAO) {
//
//		System.out.println("Creating the Book");
//		//create student
//		Books tempBook =new Books(1,"Kafka on the shore","Haruki Murakami",3200.00);
//
//		System.out.println("Saving the book");
//		bookDAO.save(tempBook);
//
//	}

}
