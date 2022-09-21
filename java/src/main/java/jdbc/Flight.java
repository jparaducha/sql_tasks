package jdbc;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@JsonRootName("flight")
@XmlRootElement(name = "flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    @XmlElement(name = "flightId")
    private int flightId;
    @XmlElement(name = "flightDuration")
    private String flightDuration;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "departureTime")
    private String departureTime;
    @XmlElement(name = "arrivalTime")
    private String arrivalTime;
    @XmlElement(name = "arrivalAirport")
    private Airport arrivalAirport;
    @XmlElement(name = "departureAirport")
    private Airport departureAirport;
    @XmlElement(name = "pilot")
    private Pilot pilot;
    @XmlElement(name = "plane")
    private Plane plane;
    @XmlElement(name = "airline")
    private Airline airline;
    @XmlElementWrapper(name = "passengers")
    @XmlElement(name = "passenger")
    private ArrayList<Passenger> passengers = new ArrayList<>();

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

    @JsonGetter("departureTime")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonSetter("departureTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonGetter("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }

    @JsonSetter("arrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonGetter("pilot")
    public Pilot getPilot() {
        return pilot;
    }

    @JsonSetter("pilot")
    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @JsonGetter("plane")
    public Plane getPlane() {
        return plane;
    }

    @JsonSetter("plane")
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @JsonGetter("airline")
    public Airline getAirline() {
        return airline;
    }

    @JsonSetter("airline")
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @JsonGetter("flightId")
    public int getFlightId() {
        return flightId;
    }

    @JsonSetter("flightId")
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @JsonGetter("flightDuration")
    public String getFlightDuration() {
        return flightDuration;
    }

    @JsonSetter("flightDuration")
    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public String toString() {
        return "Flight{" + ", flight_id=" + flightId + ", flight_duration='" + flightDuration + '\'' + ", price=" + price + ", departure_time='" + departureTime + '\'' + ", arrival_time='" + arrivalTime + '\'' + ", arrival_airport=" + arrivalAirport + ", departure_airport=" + departureAirport + ", pilot=" + pilot + ", plane=" + plane + ", airline=" + airline + "passengers=" + passengers + '}';
    }

    @JsonGetter("price")
    public double getPrice() {
        return price;
    }

    @JsonSetter("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonGetter("arrivalAirport")
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    @JsonSetter("arrivalAirport")
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @JsonGetter("departureAirport")
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    @JsonSetter("departureAirport")
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    @JsonGetter("passengers")
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    @JsonSetter("passengers")
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
