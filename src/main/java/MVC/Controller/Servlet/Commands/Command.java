/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controller.Servlet.Commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author margarita
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
}
