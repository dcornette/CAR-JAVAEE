/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Custom exception for a book
 */
public class BooksEJBException extends RuntimeException {

    /**
     * Constructor
     */
    public BooksEJBException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message Message of exception
     */
    public BooksEJBException(final String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param t Throwable exception
     */
    public BooksEJBException(final Throwable t) {
        super(t);
    }

    /**
     * Constructor
     *
     * @param message Message of exception
     * @param t Throwable exception
     */
    public BooksEJBException(final String message, final Throwable t) {
        super(message, t);
    }
}
