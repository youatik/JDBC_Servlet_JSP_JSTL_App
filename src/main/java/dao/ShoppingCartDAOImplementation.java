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
import models.ShoppingCart;

public class ShoppingCartDAOImplementation implements ShoppingCartDAOInterface {
    private Connection connection;

    public ShoppingCartDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addToCart(ShoppingCart cartItem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.shoppingCart (clientId, ean_isbn13, quantity) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, cartItem.getClientId());
            preparedStatement.setLong(2, cartItem.getEanIsbn13());
            preparedStatement.setInt(3, cartItem.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCartItem(ShoppingCart cartItem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.shoppingCart SET quantity = ? WHERE id = ?");
            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setInt(2, cartItem.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCartItem(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.shoppingCart WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ShoppingCart getCartItemById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.shoppingCart WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createCartItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ShoppingCart> getAllCartItems() {
        List<ShoppingCart> cartItems = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.shoppingCart");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ShoppingCart cartItem = createCartItemFromResultSet(resultSet);
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartItems;
    }

    private ShoppingCart createCartItemFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int clientId = resultSet.getInt("clientId");
        long eanIsbn13 = resultSet.getLong("ean_isbn13");
        int quantity = resultSet.getInt("quantity");

        return new ShoppingCart(id, clientId, eanIsbn13, quantity);
    }
}

