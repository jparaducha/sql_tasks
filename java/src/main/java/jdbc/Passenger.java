package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {

    @XmlElement(name = "passengerId")
    private int passengerId;
    @XmlElement(name = "passengerName")
    private String passengerName;
    @XmlElement(name = "passengerContactNumber")
    private int passengerContactNumber;

    public Passenger(int passengerId, String passengerName, int passengerContactNumber) {
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

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}
