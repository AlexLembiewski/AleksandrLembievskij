
package by.epam.task5.bankdeposit.model.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Администратор
 */
public interface ICommand {
      public String execute(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;
}

