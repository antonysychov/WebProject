package MVC.Model.DAO;

import MVC.Model.JavaBeans.Address;
import MVC.Model.JavaBeans.Airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportDAO {
    private final static String getAirportById = "SELECT * FROM airports WHERE id = ?";
    private Connection conn;
    private static AddressDAO addressDAO = DAOFactory.getAddressDAO();

    public AirportDAO(Connection conn) {
        this.conn = conn;
    }

    public Airport getById(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(getAirportById);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            Airport airport = new Airport();
            airport.setName(rs.getString("name"));

            Address address = addressDAO.getById(rs.getInt("addressID"));
            airport.setAddress(address);

            return airport;
        } else {
            return null;
        }

    }
}
