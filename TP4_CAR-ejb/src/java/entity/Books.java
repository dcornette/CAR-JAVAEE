/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The entity which represent the book
 */
@Entity
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByBTitle", query = "SELECT b FROM Books b WHERE b.bTitle = :bTitle"),
    @NamedQuery(name = "Books.findByBAuthor", query = "SELECT b FROM Books b WHERE b.bAuthor = :bAuthor"),
    @NamedQuery(name = "Books.findByBYear", query = "SELECT b FROM Books b WHERE b.bYear = :bYear"),
    @NamedQuery(name = "Books.findAllAuthors", query = "SELECT DISTINCT b.bAuthor FROM Books b")})
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "B_TITLE")
    private String bTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "B_AUTHOR")
    private String bAuthor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_YEAR")
    private int bYear;
    
    /**
     * Default constructor
     */
    public Books() {
    }

    /**
     * Construct a book just with the title
     * @param bTitle 
     */
    public Books(String bTitle) {
        this.bTitle = bTitle;
    }

    /**
     * Construct a book with all parameters
     * @param bTitle
     * @param bAuthor
     * @param bYear 
     */
    public Books(String bTitle, String bAuthor, int bYear) {
        this.bTitle = bTitle;
        this.bAuthor = bAuthor;
        this.bYear = bYear;
    }

    /**
     * Get the title of the book
     * @return the title
     */
    public String getBTitle() {
        return bTitle;
    }

    /**
     * Set the title to a book
     * @param bTitle 
     */
    public void setBTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    /**
     * Get the author of the book
     * @return the author
     */
    public String getBAuthor() {
        return bAuthor;
    }

    /**
     * Set the author to a book
     * @param bAuthor 
     */
    public void setBAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    /**
     * Get the date of the publication of the book
     * @return 
     */
    public int getBYear() {
        return bYear;
    }

    /**
     * Set the date of publication to a book
     * @param bYear 
     */
    public void setBYear(int bYear) {
        this.bYear = bYear;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bTitle != null ? bTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bTitle == null && other.bTitle != null) || (this.bTitle != null && !this.bTitle.equals(other.bTitle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Books[ bTitle=" + bTitle + " ]";
    }
    
}
