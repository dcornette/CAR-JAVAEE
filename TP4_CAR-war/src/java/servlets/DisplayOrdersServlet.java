/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.OrdersEJB;
import entity.Orders;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Display all orders
 */
@WebServlet(name = "DisplayOrdersServlet", urlPatterns = {"/displayOrders"})
public class DisplayOrdersServlet extends HttpServlet {

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
        List<Orders> orders = ordersEJBImpl.findAll();
        request.setAttribute("orders", orders);
        this.getServletContext().getRequestDispatcher("/orders.jsp").forward( request, response );
    }

}
