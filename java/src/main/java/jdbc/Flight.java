package jdbc;

import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int flightId;
    private String flightDuration;
    private double price;
    private String departureTime;
    private String arrivalTime;
    private Airport arrivalAirport;
    private Airport departureAirport;
    private Pilot pilot;
    private Plane plane;
    private Airline airline;

    public Flight() {
    }

    public Flight(int flightId, String flightDuration, double price, String departureTime, String arrivalTime, Airport arrivalAirport, Airport departureAirport, Pilot pilot, Plane plane, Airline airline, ArrayList<Passenger> passengers) {
        this.flightId = flightId;
        this.flightDuration = flightDuration;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.pilot = pilot;
        this.plane = plane;
        this.airline = airline;
        this.passengers = passengers;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public String toString() {
        return "Flight{" + ", flight_id=" + flightId + ", flight_duration='" + flightDuration + '\'' + ", price=" + price + ", departure_time='" + departureTime + '\'' + ", arrival_time='" + arrivalTime + '\'' + ", arrival_airport=" + arrivalAirport + ", departure_airport=" + departureAirport + ", pilot=" + pilot + ", plane=" + plane + ", airline=" + airline + "passengers=" + passengers + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
