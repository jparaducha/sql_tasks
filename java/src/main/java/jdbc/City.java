package jdbc;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("city")
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlElement(name = "countryId")
    private int countryId;
    @XmlElement(name = "cityId")
    private int cityId;
    @XmlElement(name = "cityName")
    private String cityName;
    @XmlElement(name = "country")
    private Country country;

    public City() {

    }

    public City(int id, String name) {
        this.cityId = id;
        this.cityName = name;
    }

    public City(int id, String name, Country countryId) {
        this.cityId = id;
        this.cityName = name;
        this.country = countryId;
    }

    public City(String name) {
        this.cityName = name;
    }

    public City(int cityId, String cityName, int country_id) {

        this.cityId = cityId;
        this.cityName = cityName;
        this.countryId = country_id;
    }

    @JsonGetter("cityId")
    public int getCityId() {
        return cityId;
    }

    @JsonSetter("cityId")
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "City{" + "city_id=" + cityId + ", city_name='" + cityName + '\'' + ", country=" + country + '}';
    }

    @JsonGetter("cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonSetter("cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonGetter("country")
    public Country getCountry() {
        return country;
    }

    @JsonSetter("country")
    public void setCountry(Country countryId) {
        this.country = countryId;
    }
}
