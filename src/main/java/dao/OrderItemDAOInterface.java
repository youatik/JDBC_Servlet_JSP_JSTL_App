/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.OrderItem;
/**
 *
 * @author youatik
 */
import java.util.List;

public interface OrderItemDAOInterface {
    void addOrderItem(OrderItem orderItem);
    
    void updateOrderItem(OrderItem orderItem);
    
    void deleteOrderItem(int id);
    
    OrderItem getOrderItemById(int id);
    
    List<OrderItem> getAllOrderItems();
}

