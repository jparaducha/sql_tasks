package jdbc;

public class Airport {

    private int airportId;
    private String airportName;
    private String iataCode;
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
        return "Airport{" + "airport_id=" + airportId + ", airport_name='" + airportName + '\'' + ", IATA_code='" + iataCode + '\'' + ", city=" + city + '}';
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
