/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.ClientOrder;
/**
 *
 * @author youatik
 */
import java.util.List;

public interface ClientOrderDAOInterface {
    void addClientOrder(ClientOrder clientOrder);
    
    void updateClientOrder(ClientOrder clientOrder);
    
    void deleteClientOrder(int orderId);
    
    ClientOrder getClientOrderById(int orderId);
    
    List<ClientOrder> getAllClientOrders();
}
