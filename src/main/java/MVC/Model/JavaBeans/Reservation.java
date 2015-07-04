package MVC.Model.JavaBeans;

public class Reservation  {
    private int id;
    private User user;
    private Flight flight;
    boolean luggageInclude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isLuggageInclude() {
        return luggageInclude;
    }

    public void setLuggageInclude(boolean luggageInclude) {
        this.luggageInclude = luggageInclude;
    }
}
