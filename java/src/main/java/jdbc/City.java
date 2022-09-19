package jdbc;

public class City {

    private int countryId;
    private int cityId;
    private String cityName;
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "City{" + "city_id=" + cityId + ", city_name='" + cityName + '\'' + ", country=" + country + '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country countryId) {
        this.country = countryId;
    }
}
