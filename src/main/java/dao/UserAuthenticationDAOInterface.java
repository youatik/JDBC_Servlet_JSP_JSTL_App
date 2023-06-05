/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.UserAuthentication;

/**
 *
 * @author youatik
 */
import java.util.List;

public interface UserAuthenticationDAOInterface {
    void addUserAuthentication(UserAuthentication userAuthentication);
    
    void updateUserAuthentication(UserAuthentication userAuthentication);
    
    void deleteUserAuthentication(int clientId);
    
    UserAuthentication getUserAuthenticationById(int clientId);
    
    List<UserAuthentication> getAllUserAuthentications();
}

