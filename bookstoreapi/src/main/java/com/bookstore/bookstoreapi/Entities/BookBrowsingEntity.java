package com.bookstore.bookstoreapi.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookBrowsingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String genre;

    @Column
    private Integer copies;

    public BookBrowsingEntity() {}

    public BookBrowsingEntity(Integer id, String name, String genre, Integer copies) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.copies = copies;
    }

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
