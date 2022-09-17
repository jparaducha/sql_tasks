package jdbc;

public class Airport {

    private int airport_id;
    private String airport_name;
    private String IATA_code;
    private City city;

    public Airport(int id, String name, String IATA, City city) {
        this.airport_id = id;
        this.airport_name = name;
        this.IATA_code = IATA;
        this.city = city;
    }

    public Airport() {
    }

    @Override
    public String toString() {
        return "Airport{" + "airport_id=" + airport_id + ", airport_name='" + airport_name + '\'' + ", IATA_code='" + IATA_code + '\'' + ", city=" + city + '}';
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getIATA_code() {
        return IATA_code;
    }

    public void setIATA_code(String IATA_code) {
        this.IATA_code = IATA_code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
