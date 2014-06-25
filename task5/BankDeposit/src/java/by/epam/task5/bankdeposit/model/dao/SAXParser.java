package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Администратор
 */
public class SAXParser implements IXMLParser{

    
    
    
    
    
    @Override
    public List<BankDeposit> parse(String path) {
        try {
            String thisElement = ""; 
            
            
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start parse XML..."); 
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    thisElement = qName;  
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void endDocument() throws SAXException {
                    super.endDocument(); //To change body of generated methods, choose Tools | Templates.
                }
                
                
            
            
            }
           
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
