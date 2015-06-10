/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Orders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of the EJB Order
 */
@Stateless
public class OrdersEJBImpl extends AbstractFacade<Orders> implements OrdersEJB {
    @PersistenceContext(unitName = "TP4_CAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersEJBImpl() {
        super(Orders.class);
    }  
}
