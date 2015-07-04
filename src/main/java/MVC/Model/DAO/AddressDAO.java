package MVC.Model.DAO;

import MVC.Model.JavaBeans.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO {
    private final static String getAddressById = "SELECT * FROM addresses WHERE id = ?";
    private Connection conn;

    public AddressDAO(Connection connection) {
        this.conn = connection;
    }

    public Address getById(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(getAddressById);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            Address address = new Address();
            address.setId(rs.getInt("id"));
            address.setCountry(rs.getString("country"));
            address.setCity(rs.getString("city"));
            address.setStreet(rs.getString("street"));
            address.setPostalCode(rs.getString("postalCode"));
            address.setBuilding(rs.getString("building"));
            return address;
        } else {
            return null;
        }
    }
}
