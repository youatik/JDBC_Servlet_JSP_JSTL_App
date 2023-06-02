/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Produit;

/**
 *
 * @author youatik
 */
public interface ProduitDAOInterface {
     
    Produit getProduitById(Long id);

    List<Produit> findByName(String name);
    
    List<Produit> findByAuthor(String name);

    List<Produit> findByDescription(String name);

    List<Produit> findAll();
    
}
