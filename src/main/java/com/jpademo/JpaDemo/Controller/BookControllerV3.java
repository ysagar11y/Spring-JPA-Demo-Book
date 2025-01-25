package com.jpademo.JpaDemo.Controller;

import com.jpademo.JpaDemo.Entity.Books;
import com.jpademo.JpaDemo.Entity.User;
import com.jpademo.JpaDemo.repository.BookRepository;
import com.jpademo.JpaDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/book/")
public class BookControllerV3 {
    @Autowired
    private BookRepository bookRepository;
    @Autowired UserRepository userRepository;
 //localhost:8080/api/v3/book/all
    @GetMapping("all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity getAllBooks(){
        List<Books> book = bookRepository.findAll();
        return ResponseEntity.ok(book);
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getUserBooks(){
        List<Books> book = bookRepository.findAll();
        return ResponseEntity.ok(book);
    }
    @GetMapping("get-user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getUser(){
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }
}
