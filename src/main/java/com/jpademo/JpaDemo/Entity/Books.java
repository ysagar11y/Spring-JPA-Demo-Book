package com.jpademo.JpaDemo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "books")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Books {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "author name cannot be empty or null")
    @Column(name = "author")
    private String author;
    @NotNull(message = "book title cannot be empty or null")
    @Column(name = "title")
    private String title;
    @NotNull(message = "book price cannot be empty or null")
    @Column(name = "price")
    private double price;

}
