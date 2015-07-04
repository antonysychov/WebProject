
package MVC.Controller.Servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> commands = new HashMap<String, Command>() {{
        put("sign in", new AuthCommand());
        put("register", new RegistrationCommand());
        put("searchFlights", new FlightsSearchCommand());
        put("bookFlight", new BookFlightCommand());
        put("languageSelect", new LanguageSelect());
    }};


    public static Command getCommand(HttpServletRequest request) {
        String value = request.getParameter("send");
        return commands.get(value);
    }
}
