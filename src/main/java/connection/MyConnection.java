/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author youatik
 */
/**
 * Cette classe représente une connexion unique à une base de données.
 * Elle utilise la méthode statique getInstance() pour obtenir l'instance de connexion.
 * Le modèle singleton est utilisé pour garantir qu'une seule instance de connexion est créée.
 */
public class MyConnection {

    private String url = "jdbc:mysql://localhost:3306/Test_Projet";
    private String username = "root";
    private String password = "";

    private static Connection connection;

    /**
     * Constructeur privé pour empêcher l'instanciation directe de la classe.
     * Utilisez getInstance() pour obtenir l'instance de connexion.
     */
    private MyConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère l'instance unique de connexion à la base de données.
     *
     * @return L'instance de connexion à la base de données.
     */
    public static Connection getInstance() {
        if (connection == null) {
            new MyConnection();
        }
        return connection;
    }
}

