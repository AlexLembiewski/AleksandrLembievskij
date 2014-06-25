/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task5.bankdeposit.model.command;

import by.epam.task5.bankdeposit.model.dao.ParserFactory;
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
public class DoSAXCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BankDeposit> deposits = ParserFactory.getInstance().getSAXParser().parse("path");
        request.setAttribute("deposits", deposits);
        return "/deposits.jsp";
    
    }
    
}
