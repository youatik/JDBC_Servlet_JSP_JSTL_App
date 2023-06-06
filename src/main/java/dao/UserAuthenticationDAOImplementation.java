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
import models.UserAuthentication;

public class UserAuthenticationDAOImplementation implements UserAuthenticationDAOInterface {
    private Connection connection;

    public UserAuthenticationDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addUserAuthentication(UserAuthentication userAuthentication) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.userAuthentication (clientId, username, password) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, userAuthentication.getClientId());
            preparedStatement.setString(2, userAuthentication.getUsername());
            preparedStatement.setString(3, userAuthentication.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserAuthentication(UserAuthentication userAuthentication) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.userAuthentication SET username = ?, password = ? WHERE clientId = ?");
            preparedStatement.setString(1, userAuthentication.getUsername());
            preparedStatement.setString(2, userAuthentication.getPassword());
            preparedStatement.setInt(3, userAuthentication.getClientId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserAuthentication(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.userAuthentication WHERE clientId = ?");
            preparedStatement.setInt(1, clientId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserAuthentication getUserAuthenticationById(int clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.userAuthentication WHERE clientId = ?");
            preparedStatement.setInt(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createUserAuthenticationFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<UserAuthentication> getAllUserAuthentications() {
        List<UserAuthentication> userAuthentications = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.userAuthentication");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserAuthentication userAuthentication = createUserAuthenticationFromResultSet(resultSet);
                userAuthentications.add(userAuthentication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userAuthentications;
    }

    private UserAuthentication createUserAuthenticationFromResultSet(ResultSet resultSet) throws SQLException {
        int clientId = resultSet.getInt("clientId");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        return new UserAuthentication(clientId, username, password);
    }
}
