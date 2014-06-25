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
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if(thisElement.equals("name")) {
                    
                    
                    }
                }
                
                
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    thisElement = ""; 
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("Stop parse XML..."); 
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
