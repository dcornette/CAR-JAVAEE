/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.BooksEJB;
import entity.Books;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create a new book
 */
@WebServlet(name = "NewBookServlet", urlPatterns = {"/newBook"})
public class NewBookServlet extends HttpServlet {
    
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
        this.getServletContext().getRequestDispatcher("/newBook.jsp").forward( request, response );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int year = Integer.valueOf(request.getParameter("year"));
        
        Books book = new Books(title, author, year);
        
        booksEJBImpl.create(book);
        
        request.setAttribute("status", "ok");
        
        this.getServletContext().getRequestDispatcher("/newBook.jsp").forward( request, response );
    }
}
