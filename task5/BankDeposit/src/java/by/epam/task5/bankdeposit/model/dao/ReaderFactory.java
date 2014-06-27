/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.model.dao;

/**
 *
 * @author Администратор
 */
public class ReaderFactory {

    private static ReaderFactory instance = null;
    private static XMLReaderSAX saxReader = null;
    private static XMLReaderDOM domReader = null;
    private static XMLReaderStAX staxReader = null;

    public static synchronized ReaderFactory getInstance() {
        if (instance == null) {
            instance = new ReaderFactory();
        }
        return instance;
    }

    public XMLReaderSAX getSAXReader() {
        if (saxReader == null) {
            saxReader = new XMLReaderSAX();
        }
        return saxReader;
    }

    public XMLReaderDOM getDOMReader() {
        if (domReader == null) {
            domReader = new XMLReaderDOM();
        }
        return domReader;
    }
    
    public XMLReaderStAX getStAXReader() {
        if (staxReader == null) {
            staxReader = new XMLReaderStAX();
        }
        return staxReader;
    }
}
