package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("airline")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "airline")
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
        String result = country != null ? "Airline{" + airlineName + '\'' + country.toString() + " airlineId " + airlineId + '}' : "Airline{" + airlineName + " airlineId " + airlineId + '}';
        return result;
    }

    @JsonGetter("airlineName")
    public String getAirlineName() {
        return airlineName;
    }

    @JsonSetter("airlineName")
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @JsonGetter("country")
    public Country getCountry() {
        return country;
    }

    @JsonSetter("country")
    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonGetter("airlineId")
    public int getAirlineId() {
        return airlineId;
    }

    @JsonSetter("airlineId")
    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }
}
