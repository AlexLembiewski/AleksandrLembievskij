/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task5.bankdeposit.controller;

import by.epam.task5.bankdeposit.model.command.ICommand;
import by.epam.task5.bankdeposit.model.command.NotFoundCommand;
import by.epam.task5.bankdeposit.model.command.PrintHelloCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class RequestHelper {

    private static RequestHelper instance = new RequestHelper();
    HashMap<String, ICommand> commands = new HashMap<>();

    private RequestHelper() {
        commands.put("say", new PrintHelloCommand());
        
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        ICommand command = commands.get(action);
        if (command == null) {
            command = (ICommand) new NotFoundCommand();  
        }
        return command;
    }

    public static RequestHelper getInstance() {
        return instance;
    }
}
