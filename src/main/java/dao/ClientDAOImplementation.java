/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.MyConnection;
import models.Client;

public class ClientDAOImplementation implements ClientDAOInterface {
    private Connection connection;

    public ClientDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.client (firstName, lastName, email, address) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.client SET firstName = ?, lastName = ?, email = ?, address = ? WHERE clientId = ?");
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.setInt(5, client.getClientId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.client WHERE clientId = ?");
            preparedStatement.setInt(1, clientId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getClientById(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.client WHERE clientId = ?");
            preparedStatement.setInt(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createClientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.client");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Client client = createClientFromResultSet(resultSet);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    private Client createClientFromResultSet(ResultSet resultSet) throws SQLException {
        int clientId = resultSet.getInt("clientId");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String email = resultSet.getString("email");
        String address = resultSet.getString("address");

        return new Client(clientId, firstName, lastName, email, address);
    }
}
