package MVC.View.CustomTags;

import MVC.Model.DAO.DAOFactory;
import MVC.Model.DAO.FlightDAO;
import MVC.Model.JavaBeans.Flight;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TableTagHandler extends SimpleTagSupport  {
    private String cityFrom;
    private String cityTo;

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public void doTag() throws JspException, IOException {
        FlightDAO flightDAO = DAOFactory.getFlightDAO();
        List<Flight> flights = null;
        try {
            flights = flightDAO.flightByPoints(cityFrom, cityTo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JspWriter out = getJspContext().getOut();
        out.println("<table border=\"1\">" +
                "   <caption>Schedules of flights</caption>\n" +
                "   <tr>\n" +
                "    <th>id</th>\n" +
                "    <th>Departure country</th>\n" +
                "    <th>Departure city</th>\n" +
                "    <th>Arrival country</th>\n" +
                "    <th>Arrival city</th>\n" +
                "    <th>Departure date</th>\n" +
                "    <th>Arrival date</th>\n" +
                "   </tr>");
        for (Flight flight : flights) {
            out.println("<tr>"
                    + "<td>" + flight.getId() + "</td>"
                    + "<td>" + flight.getFrom().getAddress().getCountry() + "</td>"
                    + "<td>" + flight.getFrom().getAddress().getCity() + "</td>"
                    + "<td>" + flight.getTo().getAddress().getCountry() + "</td>"
                    + "<td>" + flight.getTo().getAddress().getCity() + "</td>"
                    + "<td>" + flight.getDeparture() + "</td>"
                    + "<td>" + flight.getArrival() + "</td>"
                    + "</tr>");
        }
        out.println("</table>");
    }
}
