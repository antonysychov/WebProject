
package MVC.Controller.Servlet.Commands;


import MVC.Model.DAO.DAOFactory;
import MVC.Model.DAO.UserDAO;
import MVC.Model.JavaBeans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        UserDAO userDAO = DAOFactory.getUserDAO();

        try {
            if (userDAO.findUser(user)) {
                User user1 = userDAO.getUser(login, password);
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("userId", user1.getId());
                RequestDispatcher rd = request.getRequestDispatcher("/JSPs/login_success.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/JSPs/login_incorrect.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
