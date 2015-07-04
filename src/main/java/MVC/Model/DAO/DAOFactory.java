/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Model.DAO;

import MVC.Model.DAO.ConnectionPool.ConnectionPool;

import java.sql.SQLException;

public class DAOFactory {
    public static UserDAO getUserDAO() {
        try {
            return new UserDAO(ConnectionPool.getConnection());
        } catch (SQLException e) {
            return null;
        }
    }

    public static FlightDAO getFlightDAO() {
        try {
            return new FlightDAO(ConnectionPool.getConnection());
        } catch (SQLException e) {
            return null;
        }
    }

    public static ReservationDAO getReservationDAO() {
        try {
            return new ReservationDAO(ConnectionPool.getConnection());
        } catch (SQLException e) {
            return null;
        }
    }

    public static AirportDAO getAirportDAO() {
        try {
            return new AirportDAO(ConnectionPool.getConnection());
        } catch (SQLException e) {
            return null;
        }
    }

    public static AddressDAO getAddressDAO() {
        try {
            return new AddressDAO(ConnectionPool.getConnection());
        } catch (SQLException e) {
            return null;
        }
    }
}

