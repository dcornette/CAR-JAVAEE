/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.BooksEJB;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service to get all authors
 */
@WebServlet(name = "Authors", urlPatterns = {"/authors"})
public class GetAuthorsServlet extends HttpServlet {
    
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
        List authors = booksEJBImpl.getAuthors();
        request.setAttribute("authors", authors);
        this.getServletContext().getRequestDispatcher("/authors.jsp").forward( request, response );
    }
}
