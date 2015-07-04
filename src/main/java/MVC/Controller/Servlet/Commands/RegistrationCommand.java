/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controller.Servlet.Commands;

import MVC.Model.DAO.DAOFactory;
import MVC.Model.DAO.UserDAO;
import MVC.Model.JavaBeans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);

        UserDAO userDAO = DAOFactory.getUserDAO();

        if (userDAO.insertUser(user)) {
            RequestDispatcher rd = request.getRequestDispatcher("/JSPs/register_success.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/JSPs/register_false.jsp");
            rd.forward(request, response);            
        }
    }
}