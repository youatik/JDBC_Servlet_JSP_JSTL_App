/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.Payment;
/**
 *
 * @author youatik
 */
import java.util.List;

public interface PaymentDAOInterface {
    void addPayment(Payment payment);
    
    void updatePayment(Payment payment);
    
    void deletePayment(int paymentId);
    
    Payment getPaymentById(int paymentId);
    
    List<Payment> getAllPayments();
}
