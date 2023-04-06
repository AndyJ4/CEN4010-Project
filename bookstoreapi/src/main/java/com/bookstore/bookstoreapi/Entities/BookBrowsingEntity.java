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
    @Column
    private Double rating;
    @Column
    private String publisher;
    @Column
    private Double price;

    public BookBrowsingEntity() {}

    public BookBrowsingEntity(Integer id, String name, String genre, Integer copies, Double rating, String publisher, Double price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.copies = copies;
        this.rating = rating;
        this.publisher = publisher;
        this.price = price;
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

    public Double getRating() {return rating;}

    public void setRating(Double rating) {this.rating = rating;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

}
