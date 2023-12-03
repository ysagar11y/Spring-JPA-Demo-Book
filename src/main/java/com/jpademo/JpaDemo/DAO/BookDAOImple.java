package com.jpademo.JpaDemo.DAO;

import com.jpademo.JpaDemo.Entity.Books;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;

@Repository
public class BookDAOImple implements BookDAO{

    private EntityManager entityManager;

    @Autowired
    public BookDAOImple(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    @Transactional
    @PostMapping("myapp/save")
    public void save(Books theBook) {
        entityManager.persist(theBook);
    }
}
