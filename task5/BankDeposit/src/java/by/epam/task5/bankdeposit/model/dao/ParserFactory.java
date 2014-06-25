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
public class ParserFactory {
    private static ParserFactory instance = null;
    private static SAXParser saxParser = null;
    
    public static synchronized ParserFactory getInstance() {
        if (instance == null) {
            instance = new ParserFactory();
        }
        return instance;
    }
    
    public SAXParser getSAXParser() {
        if(saxParser == null) {
            saxParser = new SAXParser();
        }
        return saxParser;
    }
}
