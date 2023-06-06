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
import models.Library;

public class LibraryDAOImplementation implements LibraryDAOInterface {
    private Connection connection;

    public LibraryDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addLibrary(Library library) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.library (ean_isbn13, title, creators, firstName, lastName, description, publisher, publishDate, price, length) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, library.getEanIsbn13());
            preparedStatement.setString(2, library.getTitle());
            preparedStatement.setString(3, library.getCreators());
            preparedStatement.setString(4, library.getFirstName());
            preparedStatement.setString(5, library.getLastName());
            preparedStatement.setString(6, library.getDescription());
            preparedStatement.setString(7, library.getPublisher());
            preparedStatement.setDate(8, library.getPublishDate());
            preparedStatement.setBigDecimal(9, library.getPrice());
            preparedStatement.setInt(10, library.getLength());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLibrary(Library library) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.library SET title = ?, creators = ?, firstName = ?, lastName = ?, description = ?, publisher = ?, publishDate = ?, price = ?, length = ? WHERE ean_isbn13 = ?");
            preparedStatement.setString(1, library.getTitle());
            preparedStatement.setString(2, library.getCreators());
            preparedStatement.setString(3, library.getFirstName());
            preparedStatement.setString(4, library.getLastName());
            preparedStatement.setString(5, library.getDescription());
            preparedStatement.setString(6, library.getPublisher());
            preparedStatement.setDate(7, library.getPublishDate());
            preparedStatement.setBigDecimal(8, library.getPrice());
            preparedStatement.setInt(9, library.getLength());
            preparedStatement.setLong(10, library.getEanIsbn13());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLibrary(long eanIsbn13) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.library WHERE ean_isbn13 = ?");
            preparedStatement.setLong(1, eanIsbn13);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Library getLibraryById(long eanIsbn13) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.library WHERE ean_isbn13 = ?");
            preparedStatement.setLong(1, eanIsbn13);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createLibraryFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.library");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                libraries.add(createLibraryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libraries;
    }
    
    @Override
public List<Library> findByTitle(String word) {
    List<Library> libraries = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Test_Projet.library WHERE title LIKE ?");
        preparedStatement.setString(1, "%" + word + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            libraries.add(createLibraryFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return libraries;
}

@Override
public List<Library> findByCreators(String word) {
    List<Library> libraries = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Test_Projet.library WHERE creators LIKE ?");
        preparedStatement.setString(1, "%" + word + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            libraries.add(createLibraryFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return libraries;
}

@Override
public List<Library> findByDescription(String word) {
    List<Library> libraries = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Test_Projet.library WHERE description LIKE ?");
        preparedStatement.setString(1, "%" + word + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            libraries.add(createLibraryFromResultSet(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return libraries;
}

    
    
    private Library createLibraryFromResultSet(ResultSet resultSet) throws SQLException {
        long eanIsbn13 = resultSet.getLong("ean_isbn13");
        String title = resultSet.getString("title");
        String creators = resultSet.getString("creators");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String description = resultSet.getString("description");
        String publisher = resultSet.getString("publisher");
        java.sql.Date publishDate = resultSet.getDate("publishDate");
        java.math.BigDecimal price = resultSet.getBigDecimal("price");
        int length = resultSet.getInt("length");

        return new Library(eanIsbn13, title, creators, firstName, lastName, description, publisher, publishDate, price,
                length);
    }
}

