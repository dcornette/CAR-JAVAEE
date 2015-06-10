/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BooksTest {
    
    private Books book;
    
    public BooksTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        book = new Books("test", "author", 2015);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBTitle method, of class Books.
     */
    @Test
    public void testGetBTitle() {
        System.out.println("getBTitle");
        assertEquals("test", book.getBTitle());
    }

    /**
     * Test of setBTitle method, of class Books.
     */
    @Test
    public void testSetBTitle() {
        System.out.println("setBTitle");
        book.setBTitle("toto");
        assertEquals("toto", book.getBTitle());
    }

    /**
     * Test of getBAuthor method, of class Books.
     */
    @Test
    public void testGetBAuthor() {
        System.out.println("getBAuthor");
        assertEquals("author", book.getBAuthor());
    }

    /**
     * Test of setBAuthor method, of class Books.
     */
    @Test
    public void testSetBAuthor() {
        System.out.println("setBAuthor");
        book.setBAuthor("bibi");
        assertEquals("bibi", book.getBAuthor());
    }

    /**
     * Test of getBYear method, of class Books.
     */
    @Test
    public void testGetBYear() {
        System.out.println("getBYear");
        assertEquals(2015, book.getBYear());
    }

    /**
     * Test of setBYear method, of class Books.
     */
    @Test
    public void testSetBYear() {
        System.out.println("setBYear");
        book.setBYear(1);
        assertEquals(1, book.getBYear());
    }    
}
