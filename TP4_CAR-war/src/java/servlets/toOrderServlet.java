/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.OrdersEJB;
import entity.Books;
import entity.Orders;
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
 * Confirm the cart and add it into the order table
 */
@WebServlet(name = "toOrderServlet", urlPatterns = {"/toOrder"})
public class toOrderServlet extends HttpServlet {
    
    @EJB
    private OrdersEJB ordersEJBImpl;

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
        List<Books> cart;  
        Object cartSession = request.getSession().getAttribute("cart");  
        if(cartSession != null) {
            cart = (List<Books>) cartSession;
        } else {
            cart = new ArrayList<>();
        }
        
        if(cart.isEmpty()) {
            request.setAttribute("orderStatus", "empty");
            this.getServletContext().getRequestDispatcher("/cart.jsp").forward( request, response );
        } else {
            Orders order = new Orders();
            order.setBooks(cart);
            this.ordersEJBImpl.create(order);
        }
        request.setAttribute("orderStatus", "created");
        request.getSession().setAttribute("cart", null);
        this.getServletContext().getRequestDispatcher("/cart.jsp").forward( request, response );
    }
}
