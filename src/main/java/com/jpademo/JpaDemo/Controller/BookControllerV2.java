package com.jpademo.JpaDemo.Controller;

import com.jpademo.JpaDemo.Entity.Books;
import com.jpademo.JpaDemo.exception.NoBookFoundException;
import com.jpademo.JpaDemo.exception.WrongDataException;
import com.jpademo.JpaDemo.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book/v2")
@Transactional
public class BookControllerV2 {

    private Logger log = LoggerFactory.getLogger(BookControllerV2.class);
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book/{id}")
    public ResponseEntity getSpecificUser(@PathVariable Integer id) throws NoBookFoundException {
        Books book = bookRepository.findById(id)
                .orElseThrow(() -> new NoBookFoundException("No book found with the id " + id));
        log.info("Book found for required Id");
        System.out.println("this is the book id ");
        return ResponseEntity.ok(book);

    }

    @GetMapping("/book/{author}")
    public ResponseEntity getSpecificUserByName(@PathVariable String author) throws NoBookFoundException {
        Books book = bookRepository.findByAuthor(author);
        log.info("Book found for required Id");
        return new ResponseEntity(book,HttpStatusCode.valueOf(200));

    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody Books book) throws WrongDataException {
        bookRepository.save(book);
        log.info("New book added successfully");
        return new ResponseEntity(book, HttpStatusCode.valueOf(201));
    }

    /*
     * Handled exception with manual try catch
     * */
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody Books book) {
        if (book != null) {
            Books existedBook = bookRepository.getById(book.getId());
            if (existedBook != null) {
                existedBook.setPrice(book.getPrice());
                existedBook.setAuthor(book.getAuthor());
                existedBook.setTitle(book.getTitle());
                log.info("Book updated successfully.");
                bookRepository.save(existedBook);
            } else {
                log.info("No book exists with provided details");
                return new ResponseEntity<>("No book exists", HttpStatusCode.valueOf(200));
            }
        } else {
            log.info("Wrong argument to update book");
            return new ResponseEntity<>("Wrong argument", HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity(book, HttpStatusCode.valueOf(200));
    }
}
