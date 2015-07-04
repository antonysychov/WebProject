
package MVC.Controller.Servlet.Commands;


import MVC.Model.DAO.DAOFactory;
import MVC.Model.DAO.ReservationDAO;
import MVC.Model.JavaBeans.Flight;
import MVC.Model.JavaBeans.Reservation;
import MVC.Model.JavaBeans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class BookFlightCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String flightId = request.getParameter("flightId");
        String luggage = request.getParameter("luggage");
        HttpSession session = request.getSession(false);

        if (session == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/JSPs/login_required.jsp");
            rd.forward(request, response);
        } else {
            if (session.getAttribute("userId") == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/JSPs/login_required.jsp");
                rd.forward(request, response);
            }
            User user = new User();
            user.setId((Integer)session.getAttribute("userId"));
            Flight flight = new Flight();
            flight.setId(Integer.parseInt(flightId));
            ReservationDAO reservationDAO = DAOFactory.getReservationDAO();
            Reservation reservation = new Reservation();
            reservation.setUser(user);
            reservation.setFlight(flight);
            reservation.setLuggageInclude(Boolean.getBoolean(luggage));
            reservationDAO.addReservation(reservation);
            RequestDispatcher rd = request.getRequestDispatcher("/JSPs/flights.jsp");
            rd.forward(request, response);
        }
    }
}
