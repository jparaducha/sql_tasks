package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@JsonRootName("country")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    @XmlTransient
    private ArrayList<Airline> airlines = new ArrayList<Airline>();
    @XmlTransient
    private ArrayList<City> cities = new ArrayList<>();
    @XmlElement(name = "countryName")
    private String countryName;
    @XmlElement(name = "countryId")
    private int countryId;

    public Country() {
    }

    public Country(String name, int countryId) {
        this.countryName = name;
        this.countryId = countryId;
    }

    public Country(String name, ArrayList<City> cities) {
        this.countryName = name;
        this.cities = cities;
    }

    @JsonGetter("countryId")
    public int getCountryId() {
        return countryId;
    }

    @JsonSetter("countryId")
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        String citiesString = "";
        for (int i = 0; i < cities.size(); i++) {
            citiesString += cities.get(i).getCityName() + (cities.size() == i + 1 ? "" : ", ");
        }

        String airlinesString = "";

        for (int i = 0; i < airlines.size(); i++) {
            airlinesString += airlines.get(i).getAirlineName() + (airlines.size() == i + 1 ? "" : ", ");
        }
        return "Country{" + (airlines.size() > 0 ? "airlines=" + airlinesString + ", " : "") + (cities.size() > 0 ? "cities=[" + citiesString + "], " : "") + "country_name='" + countryName + '\'' + '}';
    }

    @JsonGetter("cities")
    public ArrayList<City> getCities() {
        return cities;
    }

    @JsonSetter("cities")
    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @JsonGetter("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonSetter("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonGetter("airlines")
    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    @JsonSetter("airlines")
    public void setAirlines(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }

    public void setAirline(Airline airline) {
        this.airlines.add(airline);
    }
}
