/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author youatik
 */
import java.sql.Date;

public class Payment {
    private int paymentId;
    private int clientId;
    private String cardNumber;
    private Date expiration;

    public Payment() {
        // Default constructor
    }

    public Payment(int paymentId, int clientId, String cardNumber, Date expiration) {
        this.paymentId = paymentId;
        this.clientId = clientId;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}

