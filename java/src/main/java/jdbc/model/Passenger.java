package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("passenger")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {

    @XmlElement(name = "passengerId")
    private int passengerId;
    @XmlElement(name = "passengerName")
    private String passengerName;

    @XmlElement(name = "passengerContactNumber")
    private String passengerContactNumber;

    public Passenger(int passengerId, String passengerName, String passengerContactNumber) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerContactNumber = passengerContactNumber;
    }

    public Passenger() {

    }

    public Passenger(int passengerId, String passengerName) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
    }

    @Override
    public String toString() {
        return "Passenger{" + "passenger_id=" + passengerId + ", passenger_name='" + passengerName + '\'' + ", passenger_contact_number=" + passengerContactNumber + '}';
    }

    @JsonGetter("passengerId")
    public int getPassengerId() {
        return passengerId;
    }

    @JsonSetter("passengerId")
    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @JsonGetter("passengerName")
    public String getPassengerName() {
        return passengerName;
    }

    @JsonSetter("passengerName")
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @JsonGetter("passengerContactNumber")
    public String getPassengerContactNumber() {
        return passengerContactNumber;
    }

    @JsonSetter("passengerContactNumber")
    public void setPassengerContactNumber(String passengerContactNumber) {
        this.passengerContactNumber = passengerContactNumber;
    }
}
