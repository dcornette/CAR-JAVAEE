/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Books;
import exceptions.BooksEJBException;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface of the EBJ Book
 */
@Local
public interface BooksEJB {

    /**
     * Function used to initiate book DB
     */
    public void initBookDB() throws BooksEJBException;

    /**
     * Find a book with the name
     * @param title
     * @return All book with this title
     */
    public List<Books> getBookFromTitle(String title);

    /**
     * Find a book with the name
     * @param author
     * @return All book with this author
     */
    public List<Books> getBookFromAuthor(String author);

    /**
     * Get all authors
     * @return all authors
     */
    public List getAuthors();  
    
    
    /* Need to add theses methods for servlets */
    void create(Books books);

    void edit(Books books);

    void remove(Books books);

    Books find(Object id);

    List<Books> findAll();

    List<Books> findRange(int[] range);

    int count();
}
