/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Model.DAO;

import MVC.Model.JavaBeans.Reservation;
import MVC.Model.JavaBeans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection conn;
    private final static String getUser = "SELECT * FROM users WHERE id = ?";
    private final static String find = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?";
    private final static String all = "SELECT * FROM users";
    private final static String insert = "INSERT INTO users(login, password, name, surname, email) VALUES(?, ?, ?, ?, ?)";
    private final static String getByLoginPassword = "SELECT * FROM users WHERE login = ? and password = ?";

    private static ReservationDAO reservationDAO = DAOFactory.getReservationDAO();

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean findUser(User u) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(find);
        statement.setString(1, u.getLogin());
        statement.setString(2, u.getPassword());

        ResultSet rs = statement.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> getAll() throws SQLException {

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(all);

        List<User> users = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));

            List<Reservation> reservations = reservationDAO.getReservationsByUserID(user.getId());
            user.setReservations(reservations);
            users.add(user);
        }

        return users;
    }

    public boolean insertUser(User u) throws SQLException {

        if (!findUser(u)) {
            PreparedStatement statement = conn.prepareStatement(insert);

            statement.setString(1, u.getLogin());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getName());
            statement.setString(4, u.getSurname());
            statement.setString(5, u.getEmail());
            statement.execute();
            return true;
        }

        return false;

    }

    public User getUser(int id) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(getUser);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));

            //List<Reservation> reservations = reservationDAO.getReservationsByUserID(user.getId());
            //user.setReservations(reservations);
            return user;
        } else {
            return null;
        }
    }

    public User getUser(String login, String password) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(getByLoginPassword);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet rs = statement.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));

            List<Reservation> reservations = reservationDAO.getReservationsByUserID(user.getId());
            user.setReservations(reservations);
            return user;
        } else {
            return null;
        }
    }

}
