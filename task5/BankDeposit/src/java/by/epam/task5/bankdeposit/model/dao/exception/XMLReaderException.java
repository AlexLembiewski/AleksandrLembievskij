/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.model.dao.exception;

/**
 *
 * @author Администратор
 */
public class XMLReaderException extends Exception {

    private Exception hiddenException;

    public XMLReaderException() {
    }

    public XMLReaderException(Exception e) {
        super(e);
        hiddenException = e;
    }

    public Exception getHiddenException() {
        return hiddenException;
    }
    
    

}
