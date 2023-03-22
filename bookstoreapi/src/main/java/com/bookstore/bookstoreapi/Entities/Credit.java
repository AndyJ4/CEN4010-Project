package com.bookstore.bookstoreapi.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "creditcards")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private Long cardNumber;

    @Column
    private String expirationDate;

    @Column
    private Long securityCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Long securityCode) {
        this.securityCode = securityCode;
    }
}
