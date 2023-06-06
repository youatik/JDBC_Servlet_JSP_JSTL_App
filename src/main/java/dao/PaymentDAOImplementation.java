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
import models.Payment;

public class PaymentDAOImplementation implements PaymentDAOInterface {
    private Connection connection;

    public PaymentDAOImplementation() {
        this.connection = MyConnection.getInstance();
    }

    @Override
    public void addPayment(Payment payment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Test_Projet.payment (clientId, cardNumber, expiration) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, payment.getClientId());
            preparedStatement.setString(2, payment.getCardNumber());
            preparedStatement.setDate(3, payment.getExpiration());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Test_Projet.payment SET cardNumber = ?, expiration = ? WHERE paymentId = ?");
            preparedStatement.setString(1, payment.getCardNumber());
            preparedStatement.setDate(2, payment.getExpiration());
            preparedStatement.setInt(3, payment.getPaymentId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int paymentId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Test_Projet.payment WHERE paymentId = ?");
            preparedStatement.setInt(1, paymentId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.payment WHERE paymentId = ?");
            preparedStatement.setInt(1, paymentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createPaymentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Test_Projet.payment");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Payment payment = createPaymentFromResultSet(resultSet);
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;
    }

    private Payment createPaymentFromResultSet(ResultSet resultSet) throws SQLException {
        int paymentId = resultSet.getInt("paymentId");
        int clientId = resultSet.getInt("clientId");
        String cardNumber = resultSet.getString("cardNumber");
        java.sql.Date expiration = resultSet.getDate("expiration");

        return new Payment(paymentId, clientId, cardNumber, expiration);
    }
}
