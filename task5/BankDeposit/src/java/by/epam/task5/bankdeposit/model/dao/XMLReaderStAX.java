package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.command.appvalue.DataPath;
import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderStAXException;
import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import by.epam.task5.bankdeposit.model.entity.DepositType;
import by.epam.task5.bankdeposit.model.command.appvalue.XMLTag;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.xml.sax.SAXException;

/**
 * Read XML file with StAX parser
 * @author Администратор
 */
public class XMLReaderStAX implements XMLReader {

    @Override
    public List<BankDeposit> readXML(String xmlFilePath) throws XMLReaderStAXException {
        List<BankDeposit> deposits = new ArrayList<>();
        BankDeposit deposit = null;
        String tagContent = null;
        try {
            XMLValidator validator = new XMLValidator();
            validator.validateXML(xmlFilePath, DataPath.XSD_FILE);

            XMLInputFactory factory = XMLInputFactory.newInstance();
            InputStream in = getClass().getResourceAsStream(xmlFilePath);
            XMLStreamReader reader = factory.createXMLStreamReader(in);
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (XMLTag.BANK.equals(reader.getLocalName())) {
                            deposit = new BankDeposit();
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case XMLTag.BANK:
                                deposits.add(deposit);
                                break;
                            case XMLTag.NAME:
                                deposit.setName(tagContent);
                                break;
                            case XMLTag.COUNTRY:
                                deposit.setCountry(tagContent);
                                break;
                            case XMLTag.TYPE:
                                deposit.setType(DepositType.valueOf(tagContent.toUpperCase()));
                                break;
                            case XMLTag.DEPOSITOR:
                                deposit.setDepositor(tagContent);
                                break;
                            case XMLTag.ACCOUNT_ID:
                                deposit.setAccountId(tagContent);
                                break;
                            case XMLTag.AMOUNT:
                                deposit.setAmount(Integer.parseInt(tagContent));
                                break;
                            case XMLTag.PROFITABILITY:
                                deposit.setProfitability(Integer.parseInt(tagContent));
                                break;
                            case XMLTag.TIME_CONSTRAINTS:
                                deposit.setTimeConstraints(Integer.parseInt(tagContent));
                                break;
                        }
                        break;

                }

            }
        } catch (XMLStreamException ex) {
            throw new XMLReaderStAXException(ex);
        } catch (SAXException | IOException ex) {
            throw new XMLReaderStAXException(ex);
        }
        return deposits;
    }

}
