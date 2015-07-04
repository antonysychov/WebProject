package MVC.Controller.Servlet;

import MVC.Controller.Servlet.Commands.Command;
import MVC.Controller.Servlet.Commands.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "controller", urlPatterns = {"/JSPs/controller"})
public class ControllerServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Command c = CommandFactory.getCommand(request);
        try {
            c.execute(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
