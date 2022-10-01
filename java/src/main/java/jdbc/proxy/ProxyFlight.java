package jdbc.proxy;

import jdbc.DAO.mysql.FlightDAO;
import jdbc.model.Flight;

import java.sql.SQLException;
import java.text.ParseException;

public class ProxyFlight {

    private String flightDuration;
    private double price;
    private String departureTime;
    private String arrivalTime;
    private String arrivalAirport;
    private String departureAirport;

    @Override
    public String toString() {
        return "ProxyFlight{" + "\nflightDuration=" + flightDuration + ",\n price=" + price + ",\n departureTime=" + departureTime + ",\n arrivalTime=" + arrivalTime + ",\n arrivalAirport='" + arrivalAirport + '\'' + ",\n departureAirport='" + departureAirport + '\'' + "\n}";
    }

    public ProxyFlight() {
    }

    public ProxyFlight(int id) throws SQLException, ParseException {
        this.getProxyFlight(id);
    }

    public void getProxyFlight(int id) throws SQLException, ParseException {
        Flight flight = new FlightDAO().getById(id);

        this.flightDuration = flight.getFlightDuration();
        this.price = flight.getPrice();
        this.departureTime = flight.getDepartureTime();
        this.arrivalTime = flight.getArrivalTime();
        this.arrivalAirport = flight.getArrivalAirport().getAirportName();
        this.departureAirport = flight.getDepartureAirport().getAirportName();
    }
}
