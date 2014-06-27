package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.command.appvalue.DataPath;
import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderSAXException;
import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import by.epam.task5.bankdeposit.model.entity.DepositType;
import by.epam.task5.bankdeposit.model.command.appvalue.XMLTag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Read XML file with SAX parser
 * @author Администратор
 */
public class XMLReaderSAX extends DefaultHandler implements XMLReader {

    private List<BankDeposit> tempList;
    private String temp;
    private BankDeposit deposit;

    @Override
    public void startDocument() throws SAXException {
        tempList = new ArrayList<>();
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        temp = new String(buffer, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        temp = "";
        if (qName.equalsIgnoreCase(XMLTag.BANK)) {
            deposit = new BankDeposit();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(XMLTag.BANK)) {
            tempList.add(deposit);
        } else if (qName.equalsIgnoreCase(XMLTag.NAME)) {
            deposit.setName(temp);
        } else if (qName.equalsIgnoreCase(XMLTag.COUNTRY)) {
            deposit.setCountry(temp);
        } else if (qName.equalsIgnoreCase(XMLTag.TYPE)) {
            DepositType valueOf = DepositType.valueOf(temp.toUpperCase());
            deposit.setType(valueOf);
        } else if (qName.equalsIgnoreCase(XMLTag.DEPOSITOR)) {
            deposit.setDepositor(temp);
        } else if (qName.equalsIgnoreCase(XMLTag.ACCOUNT_ID)) {
            deposit.setAccountId(temp);
        } else if (qName.equalsIgnoreCase(XMLTag.AMOUNT)) {
            deposit.setAmount(Integer.parseInt(temp));
        } else if (qName.equalsIgnoreCase(XMLTag.PROFITABILITY)) {
            deposit.setProfitability(Integer.parseInt(temp));
        } else if (qName.equalsIgnoreCase(XMLTag.TIME_CONSTRAINTS)) {
            deposit.setTimeConstraints(Integer.parseInt(temp));
        }

    }

    private List<BankDeposit> getDeposits() {
        return tempList;
    }

    @Override
    public List<BankDeposit> readXML(String xmlFilePath) throws XMLReaderSAXException {
        List<BankDeposit> deposits = Collections.emptyList();
        try {
            XMLValidator validator = new XMLValidator();
            validator.validateXML(xmlFilePath, DataPath.XSD_FILE);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReaderSAX myParser = new XMLReaderSAX();
            parser.parse(getClass().getResourceAsStream(xmlFilePath), myParser);
            deposits = myParser.getDeposits();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new XMLReaderSAXException(ex);
        }

        return deposits;

    }

}
