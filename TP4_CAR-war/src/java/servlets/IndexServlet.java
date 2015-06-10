/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.BooksEJB;
import entity.Books;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Enable to forward on the index of the project
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {
    
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
        request.getSession().setAttribute("jsp", "/index.jsp");
        List<Books> books = booksEJBImpl.findAll();
        request.setAttribute("books", books);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward( request, response );
    }
}
