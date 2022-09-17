package jdbc;

public class City {

    private int countryId;
    private int city_id;
    private String city_name;
    private Country country;

    public City() {

    }

    public City(int id, String name) {
        this.city_id = id;
        this.city_name = name;
    }

    public City(int id, String name, Country countryId) {
        this.city_id = id;
        this.city_name = name;
        this.country = countryId;
    }

    public City(String name) {
        this.city_name = name;
    }

    public City(int city_id, String city_name, int country_id) {

        this.city_id = city_id;
        this.city_name = city_name;
        this.countryId = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "City{" + "city_id=" + city_id + ", city_name='" + city_name + '\'' + ", country=" + country + '}';
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country countryId) {
        this.country = countryId;
    }
}
