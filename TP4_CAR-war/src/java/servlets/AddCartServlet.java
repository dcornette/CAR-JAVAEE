/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.BooksEJB;
import entity.Books;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add a book into the cart
 */
@WebServlet(name = "AddCartServlet", urlPatterns = {"/addToCart"})
public class AddCartServlet extends HttpServlet {

    @EJB
    private BooksEJB booksEJBImpl;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
        // Set all books 
        List<Books> books = booksEJBImpl.findAll();
        request.setAttribute("books", books);
        
        // Add book to Cart
        List<Books> cart;  
        Object cartSession = request.getSession().getAttribute("cart");  
        if(cartSession != null) {
            cart = (List<Books>) cartSession;
        } else {
            cart = new ArrayList<>();
        }       
        String titleBook = request.getParameter("title");
        List<Books> booksFromTitle = booksEJBImpl.getBookFromTitle(titleBook);
        for(Books b : booksFromTitle) {
            if(!cart.contains(b)) {
                cart.add(b);
            }
        } 
        request.getSession().setAttribute("cart", cart);
        
        // Call JSP page
        this.getServletContext().getRequestDispatcher("/index.jsp").forward( request, response );
    }
}
