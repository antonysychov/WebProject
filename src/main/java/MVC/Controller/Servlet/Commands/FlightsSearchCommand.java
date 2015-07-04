
package MVC.Controller.Servlet.Commands;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FlightsSearchCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher rd = request.getRequestDispatcher("/JSPs/flights.jsp");
        rd.forward(request, response);
    }

}
