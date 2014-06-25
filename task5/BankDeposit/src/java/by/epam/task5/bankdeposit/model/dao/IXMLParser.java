
package by.epam.task5.bankdeposit.model.dao;

import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import java.util.List;

/**
 *
 * @author Администратор
 */
public interface IXMLParser {
        
    public List<BankDeposit> parse(String path);
}
