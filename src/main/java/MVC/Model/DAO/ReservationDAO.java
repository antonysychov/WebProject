package MVC.Model.DAO;

import MVC.Model.JavaBeans.Flight;
import MVC.Model.JavaBeans.Reservation;
import MVC.Model.JavaBeans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReservationDAO {
    private Connection conn;
    private final static String findForUser = "SELECT * FROM reservations WHERE userID = ?";
    private final static String add = "Insert into reservations (userId, flightId, luggage) values (?, ?, ?)";
    private static FlightDAO flightDAO = DAOFactory.getFlightDAO();
    private static UserDAO userDAO = DAOFactory.getUserDAO();

    public ReservationDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Reservation> getReservationsByUserID(int userId) throws SQLException {
        List<Reservation> reservations = new LinkedList<>();

        PreparedStatement ps = conn.prepareStatement(findForUser);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Reservation r = new Reservation();
            r.setLuggageInclude(rs.getBoolean("luggage"));
            r.setId(rs.getInt("id"));

            Flight flight = flightDAO.getFlight(rs.getInt("flightID"));
            User user = userDAO.getUser(rs.getInt("userID"));
            r.setUser(user);
            r.setFlight(flight);
            reservations.add(r);
        }
        return reservations;
    }

    public void addReservation(Reservation reservation) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(add);
        ps.setInt(1, reservation.getUser().getId());
        ps.setInt(2, reservation.getFlight().getId());
        ps.setInt(3, reservation.isLuggageInclude() == true ? 'y' : 'n');

        ps.execute();
    }
}
