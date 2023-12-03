package com.jpademo.JpaDemo.Controller;

import com.jpademo.JpaDemo.DAO.BookDAO;
import com.jpademo.JpaDemo.DAO.BookDAOImple;
import com.jpademo.JpaDemo.Entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
    @RequestMapping("/book/v1")
public class BookController {

    private BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO thebookDAO) {
        bookDAO=thebookDAO;
    }

    @GetMapping("/savedata")
    public String getDailyWorkout(){
        System.out.println("Creating the Book");
        //create student
        Books tempBook =new Books(2,"Tenth of December","George Saunders",2800.00);

        System.out.println("Saving the book");
        bookDAO.save(tempBook);
        return "success";
    }
     @PostMapping("/savedata")
    public String getDailyWorkout(@RequestBody Books book){
         if(book!=null)
           bookDAO.save(book);
        return "success";
    }

}
