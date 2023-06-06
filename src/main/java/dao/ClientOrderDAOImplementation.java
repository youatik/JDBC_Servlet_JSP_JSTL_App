/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author youatik
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.MyConnection;
import models.ClientOrder;

public class ClientOrderDAOImplementation implements ClientOrderDAOInterface {
    private Connection connection;

    public ClientOrderDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addClientOrder(ClientOrder clientOrder) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.clientOrder (clientId, orderDate, totalAmount) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, clientOrder.getClientId());
            preparedStatement.setDate(2, clientOrder.getOrderDate());
            preparedStatement.setBigDecimal(3, clientOrder.getTotalAmount());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClientOrder(ClientOrder clientOrder) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.clientOrder SET clientId = ?, orderDate = ?, totalAmount = ? WHERE orderId = ?");
            preparedStatement.setInt(1, clientOrder.getClientId());
            preparedStatement.setDate(2, clientOrder.getOrderDate());
            preparedStatement.setBigDecimal(3, clientOrder.getTotalAmount());
            preparedStatement.setInt(4, clientOrder.getOrderId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClientOrder(int orderId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.clientOrder WHERE orderId = ?");
            preparedStatement.setInt(1, orderId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClientOrder getClientOrderById(int orderId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.clientOrder WHERE orderId = ?");
            preparedStatement.setInt(1, orderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createClientOrderFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ClientOrder> getAllClientOrders() {
        List<ClientOrder> clientOrders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.clientOrder");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ClientOrder clientOrder = createClientOrderFromResultSet(resultSet);
                clientOrders.add(clientOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientOrders;
    }

    private ClientOrder createClientOrderFromResultSet(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("orderId");
        int clientId = resultSet.getInt("clientId");
        java.sql.Date orderDate = resultSet.getDate("orderDate");
        java.math.BigDecimal totalAmount = resultSet.getBigDecimal("totalAmount");

        return new ClientOrder(orderId, clientId, orderDate, totalAmount);
    }
}
