/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Books;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;

public class BooksEJBImplTest {

    /**
     * Test of create method, of class BooksEJBImpl.
     */
    @Test
    public void testCreate() throws Exception {
        Books b = new Books("test", "author", 2015);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB instance = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        instance.create(b);
        assertEquals(b, instance.getBookFromTitle("test"));
        container.close();
    }

    /**
     * Test of findAll method, of class BooksEJBImpl.
     */
    @Test
    public void testFindAll() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB instance = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        
        List<Books> expResult = new ArrayList<>();
        Books book = new Books("TCP/IP Illustrated", "W. Stevens", 1994);
        instance.create(book);
        expResult.add(book);
        book = new Books("Advanced Programming in the Unix environment", "W. Stevens", 1992);
        instance.create(book);
        expResult.add(book);

        assertEquals(expResult, instance.findAll());
        container.close();
    }

    /**
     * Test of count method, of class BooksEJBImpl.
     */
    @Test
    public void testCount() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB instance = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        instance.initBookDB();
        assertEquals(4, instance.count());
        container.close();
    }

    /**
     * Test of initBookDB method, of class BooksEJBImpl.
     */
    @Test
    public void testInitBookDB() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB booksEJBImpl = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        booksEJBImpl.initBookDB();
        assertEquals("TCP/IP Illustrated", booksEJBImpl.getBookFromTitle("TCP/IP Illustrated").get(0).getBTitle());
        assertEquals("Advanced Programming in the Unix environment", booksEJBImpl.getBookFromTitle("Advanced Programming in the Unix environment").get(0).getBTitle());
        assertEquals("Data on the Web", booksEJBImpl.getBookFromTitle("Data on the Web").get(0).getBTitle());
        assertEquals("The Economics of Technology and Content for Digital TV", booksEJBImpl.getBookFromTitle("The Economics of Technology and Content for Digital TV").get(0).getBTitle());
    }

    /**
     * Test of getBookFromTitle method, of class BooksEJBImpl.
     */
    @Test
    public void testGetBookFromTitle() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB instance = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        assertEquals("TCP/IP Illustrated", instance.getBookFromTitle("TCP/IP Illustrated").get(0));
        container.close();
    }

    /**
     * Test of getAuthors method, of class BooksEJBImpl.
     */
    @Test
    public void testGetAuthors() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BooksEJB instance = (BooksEJB)container.getContext().lookup("java:global/classes/BooksEJBImpl");
        instance.initBookDB();
        assertEquals("W. Stevens", instance.getAuthors().get(0));
        assertEquals("Serge Abiteboul", instance.getAuthors().get(1));
        assertEquals("Darcy Gerbarg", instance.getAuthors().get(2));
        container.close();
    }
}
