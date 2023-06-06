/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import models.Client;

/**
 *
 * @author youatik
 */
public interface ClientDAOInterface {
    


    void addClient(Client client);
    
    void updateClient(Client client);
    
    void deleteClient(int clientId);
    
    Client getClientById(int clientId);
    
    
    List<Client> getAllClients();
}

  
    
}
