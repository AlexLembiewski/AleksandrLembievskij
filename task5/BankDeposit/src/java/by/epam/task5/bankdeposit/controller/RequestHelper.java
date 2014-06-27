/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.controller;

import by.epam.task5.bankdeposit.model.command.ICommand;
import by.epam.task5.bankdeposit.model.command.NotFoundCommand;
import by.epam.task5.bankdeposit.model.command.ReadXMLUsingDOM;
import by.epam.task5.bankdeposit.model.command.ReadXMLUsingSAX;
import by.epam.task5.bankdeposit.model.command.ReadXMLUsingStAX;
import by.epam.task5.bankdeposit.model.command.appvalue.ParserType;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class RequestHelper {

    private static RequestHelper instance = new RequestHelper();
    HashMap<ParserType, ICommand> commands = new HashMap<>();

    private RequestHelper() {
        commands.put(ParserType.SAX, new ReadXMLUsingSAX());
        commands.put(ParserType.DOM, new ReadXMLUsingDOM());
        commands.put(ParserType.STAX, new ReadXMLUsingStAX());

    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        ICommand command = commands.get(ParserType.valueOf(action.toUpperCase()));
        if (command == null) {
            command = (ICommand) new NotFoundCommand();
        }
        return command;
    }

    public static RequestHelper getInstance() {
        return instance;
    }
}
