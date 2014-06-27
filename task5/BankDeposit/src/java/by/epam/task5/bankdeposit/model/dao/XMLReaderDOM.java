package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.command.appvalue.DataPath;
import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderDOMException;
import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import by.epam.task5.bankdeposit.model.entity.DepositType;
import by.epam.task5.bankdeposit.model.command.appvalue.XMLTag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Read XML file with DOM parser
 * @author Администратор
 */
public class XMLReaderDOM implements XMLReader {

    private List<BankDeposit> deposits;

    @Override
    public List<BankDeposit> readXML(String xmlFilePath) throws XMLReaderDOMException {
        try {
            XMLValidator validator = new XMLValidator();
            validator.validateXML(xmlFilePath, DataPath.XSD_FILE);

            deposits = new ArrayList<>();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(getClass().getResourceAsStream(xmlFilePath));
            NodeList nList = doc.getElementsByTagName(XMLTag.BANK);
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                BankDeposit deposit = new BankDeposit();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    deposit.setName(eElement.getElementsByTagName(XMLTag.NAME).item(0).getTextContent());
                    deposit.setCountry(eElement.getElementsByTagName(XMLTag.COUNTRY).item(0).getTextContent());
                    deposit.setType(DepositType.valueOf(eElement.getElementsByTagName(XMLTag.TYPE)
                            .item(0).getTextContent().toUpperCase()));
                    deposit.setDepositor(eElement.getElementsByTagName(XMLTag.DEPOSITOR).item(0).getTextContent());
                    deposit.setAccountId(eElement.getElementsByTagName(XMLTag.ACCOUNT_ID).item(0).getTextContent());
                    deposit.setAmount(Integer.parseInt(eElement.getElementsByTagName(XMLTag.AMOUNT).item(0).getTextContent()));
                    deposit.setProfitability(Integer.parseInt(eElement.getElementsByTagName(XMLTag.PROFITABILITY)
                            .item(0).getTextContent()));
                    deposit.setTimeConstraints(Integer.parseInt(eElement.getElementsByTagName(XMLTag.TIME_CONSTRAINTS)
                            .item(0).getTextContent()));
                }
                deposits.add(deposit);
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new XMLReaderDOMException(ex);
        }

        return deposits;
    }

}
