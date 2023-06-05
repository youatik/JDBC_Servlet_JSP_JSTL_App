/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.ShoppingCart;
/**
 *
 * @author youatik
 */
import java.util.List;

public interface ShoppingCartDAOInterface {
    void addToCart(ShoppingCart cartItem);
    
    void updateCartItem(ShoppingCart cartItem);
    
    void removeCartItem(int id);
    
    ShoppingCart getCartItemById(int id);
    
    List<ShoppingCart> getAllCartItems();
}
