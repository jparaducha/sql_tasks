package jdbc;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.*;

@JsonRootName("airport")
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

    @JsonGetter("airportId")
    public int getAirportId() {
        return airportId;
    }

    @JsonSetter("airportId")
    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    @JsonGetter("airportName")
    public String getAirportName() {
        return airportName;
    }

    @JsonSetter("airportName")
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @JsonGetter("iataCode")
    public String getIataCode() {
        return iataCode;
    }

    @JsonSetter("iataCode")
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @JsonGetter("city")
    public City getCity() {
        return city;
    }

    @JsonSetter("city")
    public void setCity(City city) {
        this.city = city;
    }
}
