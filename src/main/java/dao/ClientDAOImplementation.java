/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import models.Client;
import models.Produit;

/**
 *
 * @author youatik
 */
public class ClientDAOImplementation implements ClientDAOInterface {
    private Connection connection;
    //You have to get client by username for login, by id for account info, 
    
    /* Premiere implementation, mise-de-côté
    @Override
    public Client getClientById(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produit WHERE client_id = ?");
            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Client((int) resultSet.getLong("id"), resultSet.getString("nom"), null, null, null, null);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    */
    
    @Override
    public Client getClientById(int clientId) {
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client WHERE client_id = ?");
        preparedStatement.setInt(1, clientId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("client_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");

            return new Client(id, firstName, lastName, email, null, address);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
    
    
    
}
