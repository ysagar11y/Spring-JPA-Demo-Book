package com.jpademo.JpaDemo.Controller;

import com.jpademo.JpaDemo.DAO.BookDAO;
import com.jpademo.JpaDemo.DAO.BookDAOImple;
import com.jpademo.JpaDemo.Entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book/v1")
public class BookController {

    private BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO thebookDAO) {
        bookDAO = thebookDAO;
    }

    @GetMapping("/savedata")
    public String getDailyWorkout() {
        System.out.println("Creating the Book");
        //create student
        Books tempBook = new Books(2, "Tenth of December", "George Saunders", 2800.00);

        System.out.println("Saving the book");
        bookDAO.save(tempBook);
        return "success";
    }

    @PostMapping("/savedata")
    public ResponseEntity getDailyWorkout(@RequestBody Books book) {
        if (book != null)
            bookDAO.save(book);
        return new ResponseEntity(book, HttpStatusCode.valueOf(201));
    }

}
