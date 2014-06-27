
package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderException;
import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import java.util.List;

/**
 *
 * @author Администратор
 */
public interface XMLReader {
        
    public List<BankDeposit> readXML(String xmlFilePath) throws XMLReaderException;
}
