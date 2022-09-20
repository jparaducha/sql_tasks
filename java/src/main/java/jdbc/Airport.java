package jdbc;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "airport")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport {

    @XmlElement(name = "airportId")
    private int airportId;
    @XmlElement(name = "airportName")
    private String airportName;
    @XmlElement(name = "iataCode")
    private String iataCode;
    @XmlTransient
    private City city;

    public Airport(int id, String name, String IATA, City city) {
        this.airportId = id;
        this.airportName = name;
        this.iataCode = IATA;
        this.city = city;
    }

    public Airport() {
    }

    @Override
    public String toString() {
        return "Airport{" + "airportId=" + airportId + ", airportName='" + airportName + '\'' + ", iataCode='" + iataCode + '\'' + ", city=" + city + '}';
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
