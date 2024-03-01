package com.example.Book_Management;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1)

    private Integer id;
    private String name;
    private String review;
    //private String auther;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Book(Integer id, String name, String review) {
        this.id = id;
        this.name = name;
        this.review = review;
    }

    public Book() {

    }
}
