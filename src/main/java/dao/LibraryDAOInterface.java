/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import models.Library;
/**
 *
 * @author youatik
 */
import java.util.List;

public interface LibraryDAOInterface {
    void addLibrary(Library library);
    
    void updateLibrary(Library library);
    
    void deleteLibrary(long eanIsbn13);
    
    Library getLibraryById(long eanIsbn13);
    
    List<Library> findByTitle(String word);

    List<Library> findByCreators(String word);

    List<Library> findByDescription(String word);
    
    List<Library> getAllLibraries();
}
