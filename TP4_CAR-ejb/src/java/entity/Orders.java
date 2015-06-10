/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The entity which represent the order
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByNumber", query = "SELECT o FROM Orders o WHERE o.number = :number")})
public class Orders implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private Integer number;
    
    @Lob
    @Column(name = "BOOKS")
    @OneToMany
    private List<Books> books;

    /**
     * default constructor
     */
    public Orders() {
    }

    /**
     * Create an order with an id
     * @param number : id
     */
    public Orders(Integer number) {
        this.number = number;
    }

    /**
     * get the ID of the order
     * @return id
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Set the id of an order
     * @param number : id
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * Get the list of boos of the order
     * @return all books
     */
    public List<Books> getBooks() {
        return books;
    }

    /**
     * Set the list of boos of the order
     * @param books 
     */
    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ number=" + number + " ]";
    }
    
}
