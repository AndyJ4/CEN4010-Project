package com.example.demo;

import jakarta.persistence.*;

//model
@Entity
@Table(name = "books")
public class BookEntity {
    private Integer id;
    private String name;
    private String genre;
    private Integer copies;

    public BookEntity() {}

    public BookEntity(Integer id, String name, String genre, Integer copies) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.copies = copies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCopies() {return copies;}

    public void setCopies(Integer copies) {this.copies = copies;}

}
