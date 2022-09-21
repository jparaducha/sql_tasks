package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airline {

    @XmlElement(name = "airlineName")
    private String airlineName;
    @XmlElement(name = "country")
    private Country country;
    @XmlElement(name = "airlineId")
    private int airlineId;

    public Airline() {
    }

    public Airline(Country country) {
        this.country = country;
    }

    public Airline(int id, String airlineName, Country country) {
        this.airlineName = airlineName;
        this.airlineId = id;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airline{" + airlineName + '\'' + country.toString() + " airlineId " + airlineId + '}';
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }
}
