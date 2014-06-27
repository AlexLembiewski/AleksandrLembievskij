/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.model.command;

import by.epam.task5.bankdeposit.controller.PageName;
import by.epam.task5.bankdeposit.model.command.appvalue.DataPath;
import by.epam.task5.bankdeposit.model.command.appvalue.ParserType;
import by.epam.task5.bankdeposit.model.dao.ReaderFactory;
import by.epam.task5.bankdeposit.model.dao.exception.XMLReaderStAXException;
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
public class ReadXMLUsingStAX implements ICommand {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ReadXMLUsingDOM.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BankDeposit> deposits = ReaderFactory.getInstance().getStAXReader()
                    .readXML(DataPath.XML_FILE);

            request.setAttribute("type", ParserType.STAX);
            request.setAttribute("deposits", deposits);

            return PageName.DEPOSITS_PAGE;

        } catch (XMLReaderStAXException ex) {
            log.error(ex);
        }
        return PageName.ERROR_PAGE;
    }

}
