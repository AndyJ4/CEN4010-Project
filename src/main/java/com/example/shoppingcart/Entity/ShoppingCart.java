package com.example.shoppingcart.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "userid")
    private String userid;
    @Column(name = "bookid")
    private Long bookid;

    public ShoppingCart(){
    }
    public ShoppingCart(String userid, Long bookid){
        this.userid = userid;
        this.bookid = bookid;
    }

    public String getUserid(){
        return userid;
    }

    public void setUserid(String userid){
        this.userid = userid;
    }

    public Long getBookid(){
        return bookid;
    }

    public void setBookid(Long bookid){
        this.bookid = bookid;
    }
}


