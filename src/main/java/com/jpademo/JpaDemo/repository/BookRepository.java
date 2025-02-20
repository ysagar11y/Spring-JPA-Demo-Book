package com.jpademo.JpaDemo.repository;

import com.jpademo.JpaDemo.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    public Books findByAuthor(String author);
}
