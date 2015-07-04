package MVC.Model.DAO;

import MVC.Model.JavaBeans.Airport;
import MVC.Model.JavaBeans.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FlightDAO {
    private final static String getFlightById = "SELECT * FROM flights WHERE id = ?";
    private final static String getFlightsByPoints = "SELECT flights.id, flights.from, flights.to, flights.arrival, flights.departure\n" +
            "FROM flights, airports ai1, airports ai2, addresses a1, addresses a2\n" +
            "WHERE ((flights.from = ai1.id AND ai1.addressID = a1.id AND a1.city = ?)\n" +
            "and (flights.to = ai2.id AND ai2.addressID = a2.id AND a2.city = ?))";
    private Connection conn;
    private static AirportDAO airportDAO = DAOFactory.getAirportDAO();

    public FlightDAO(Connection conn) {
        this.conn = conn;
    }

    public Flight getFlight(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(getFlightById);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            Flight flight = new Flight();
            flight.setId(rs.getInt("id"));
            Airport from = airportDAO.getById(rs.getInt("from"));
            Airport to = airportDAO.getById(rs.getInt("to"));
            flight.setFrom(from);
            flight.setTo(to);
            flight.setArrival(rs.getDate("arrival"));
            flight.setDeparture(rs.getDate("departure"));
            return flight;
        } else {
            return null;
        }
    }

    public List<Flight> flightByPoints(String from, String to) throws SQLException {
        List<Flight> flights = new LinkedList<>();

        PreparedStatement ps = conn.prepareStatement(getFlightsByPoints);
        ps.setString(1, from);
        ps.setString(2, to);

        ResultSet rs = ps.executeQuery();
        FlightDAO flightDAO = DAOFactory.getFlightDAO();

        while (rs.next()) {
            Flight flight = new Flight();
            flight.setId(rs.getInt("id"));
            Airport fromAirport = airportDAO.getById(rs.getInt("from"));
            Airport toAirport = airportDAO.getById(rs.getInt("to"));
            flight.setFrom(fromAirport);
            flight.setTo(toAirport);
            flight.setArrival(rs.getDate("arrival"));
            flight.setDeparture(rs.getDate("departure"));
            flights.add(flight);
        }
        return flights;
    }
}
