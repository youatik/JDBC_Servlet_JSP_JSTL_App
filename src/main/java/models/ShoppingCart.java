/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author youatik
 */
public class ShoppingCart {
    private int id;
    private int clientId;
    private long eanIsbn13;
    private int quantity;

    public ShoppingCart() {
        // Default constructor
    }

    public ShoppingCart(int id, int clientId, long eanIsbn13, int quantity) {
        this.id = id;
        this.clientId = clientId;
        this.eanIsbn13 = eanIsbn13;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
}
