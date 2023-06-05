/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author youatik
 */
import java.math.BigDecimal;

public class OrderItem {
    private int id;
    private int orderId;
    private long eanIsbn13;
    private int quantity;
    private BigDecimal price;
    private int clientId;

    public OrderItem() {
        // Default constructor
    }

    public OrderItem(int id, int orderId, long eanIsbn13, int quantity, BigDecimal price, int clientId) {
        this.id = id;
        this.orderId = orderId;
        this.eanIsbn13 = eanIsbn13;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public long getEanIsbn13() {
        return eanIsbn13;
    }

    public void setEanIsbn13(long eanIsbn13) {
        this.eanIsbn13 = eanIsbn13;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}

