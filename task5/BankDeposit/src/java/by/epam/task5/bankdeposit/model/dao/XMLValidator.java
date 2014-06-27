/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.model.dao;

import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * 
 * @author Администратор
 */
public class XMLValidator {

    public void validateXML(String xmlFilePath, String xsdFilePath) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream(xsdFilePath)));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(getClass().getResourceAsStream(xmlFilePath)));
    }

}
