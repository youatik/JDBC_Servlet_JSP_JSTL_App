/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Produit;

import connection.MyConnection; // need to add and edit myconnection
import java.math.BigDecimal;
import models.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author youatik
 */
public class ProduitDAOImplementation implements ProduitDAOInterface {
        private Connection connection;

         public ProduitDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }
        
@Override
public Produit getProduitById(Long id) {
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Test_Projet.library WHERE ean_isbn13 = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return createProduitFromResultSet(resultSet);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

@Override
public List<Produit> findByName(String name) {
    List<Produit> produits = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produit WHERE title = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            produits.add(createProduitFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produits;
}

@Override
public List<Produit> findByAuthor(String name) {
    List<Produit> produits = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produit WHERE creators = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            produits.add(createProduitFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produits;
}

@Override
public List<Produit> findByDescription(String name) {
    List<Produit> produits = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produit WHERE description = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            produits.add(createProduitFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produits;
}



@Override
public List<Produit> findAll() {
    List<Produit> produits = new ArrayList<>();
    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM produit");

        while (resultSet.next()) {
            Produit produit = createProduitFromResultSet(resultSet);
            produits.add(produit);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return produits;
}

//does this respect the way in which exceptions are thrown by Tomcat?
private Produit createProduitFromResultSet(ResultSet resultSet) throws SQLException {
    long eanIsbn13 = resultSet.getLong("ean_isbn_13");
    String title = resultSet.getString("title");
    String creators = resultSet.getString("creators");
    String firstName = resultSet.getString("first_name");
    String lastName = resultSet.getString("last_name");
    String description = resultSet.getString("description");
    String publisher = resultSet.getString("publisher");
    Date publishDate = resultSet.getDate("publish_date");
    BigDecimal price = resultSet.getBigDecimal("price");
    int length = resultSet.getInt("length");

    return new Produit(eanIsbn13, title, creators, firstName, lastName, description, publisher, publishDate, price, length);
}

    
}
