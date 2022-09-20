package jdbc;

public class Airline {

    private String airlineName;
    private Country country;
    private int airlineId;

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
