package jdbc;

public class Airline {

    private String airline_name;
    private Country country;
    private int airline_id;

    public Airline(Country country) {
        this.country = country;
    }

    public Airline(int id, String airline_name, Country country) {
        this.airline_name = airline_name;
        this.airline_id = id;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airline{" + airline_name + '\'' + '}';
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }
}
