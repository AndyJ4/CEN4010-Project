package com.example.shoppingcart.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    private String userid;
    private String list;
    private Long ISBN;
    private double subtotal;

    public ShoppingCart(){
    }
    public ShoppingCart(String userid, String list, Long ISBN, double subtotal){
        this.userid = userid;
        this.list = list;
        this.ISBN = ISBN;
        this.subtotal = subtotal;
    }

    public String getUserid(){

        return userid;
    }

    public void setUserid(String userid){

        this.userid = userid;
    }

    public String getList(){

        return list;
    }

    public void setList(String list){

        this.list = list;
    }

    public Long getISBN(){

        return ISBN;
    }

    public void setISBN(Long ISBN){

        this.ISBN = ISBN;
    }

    public double getSubtotal(){

        return subtotal;
    }

    public void setSubtotal(double subtotal){

        this.subtotal = subtotal;
    }

}


