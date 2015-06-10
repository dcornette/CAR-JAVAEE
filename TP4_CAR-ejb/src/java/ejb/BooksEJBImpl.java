/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Books;
import exceptions.BooksEJBException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of the EJB Book
 */
@Stateless
public class BooksEJBImpl extends AbstractFacade<Books> implements BooksEJB {

    @PersistenceContext(unitName = "TP4_CAR-ejbPU")
    private EntityManager em;

    public BooksEJBImpl() {
        super(Books.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void initBookDB() throws BooksEJBException {
        try {
            Books book = new Books("TCP/IP Illustrated", "W. Stevens", 1994);
            this.create(book);
            book = new Books("Advanced Programming in the Unix environment", "W. Stevens", 1992);
            this.create(book);
            book = new Books("Data on the Web", "Serge Abiteboul", 2000);
            this.create(book);
            book = new Books("The Economics of Technology and Content for Digital TV", "Darcy Gerbarg", 1999);
            this.create(book);
        } catch(EntityExistsException e) {
            throw new BooksEJBException("Book already exists", e);
        }
    }

    @Override
    public List<Books> getBookFromTitle(String title) {
        return (List<Books>) em.createNamedQuery("Books.findByBTitle").setParameter("bTitle", title).getResultList();
    }

    @Override
    public List<Books> getBookFromAuthor(String author) {
        return (List<Books>) em.createNamedQuery("Books.findByBAuthor").setParameter("bAuthor", author).getResultList();
    }

    @Override
    public List getAuthors() {
        return em.createNamedQuery("Books.findAllAuthors").getResultList();
    }
}
