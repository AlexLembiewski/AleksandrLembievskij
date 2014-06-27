
package by.epam.task5.bankdeposit.model.command;

import by.epam.task5.bankdeposit.controller.PageName;
import by.epam.task5.bankdeposit.model.command.appvalue.DataPath;
import by.epam.task5.bankdeposit.model.command.appvalue.ParserType;
import by.epam.task5.bankdeposit.model.dao.ReaderFactory;
import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderDOMException;
import by.epam.task5.bankdeposit.model.entity.BankDeposit;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Администратор
 */
public class ReadXMLUsingDOM implements ICommand {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReadXMLUsingDOM.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BankDeposit> deposits = ReaderFactory.getInstance().getDOMReader()
                    .readXML(DataPath.XML_FILE);
            request.setAttribute("deposits", deposits);
            request.setAttribute("type", ParserType.DOM);
            return PageName.DEPOSITS_PAGE;
        } catch (XMLReaderDOMException ex) {
            log.error(ex.getHiddenException());
        }
        return PageName.ERROR_PAGE;
    }

}
