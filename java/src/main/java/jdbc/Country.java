package jdbc;

import java.util.ArrayList;

public class Country {

    private ArrayList<Airline> airlines = new ArrayList<Airline>();
    private ArrayList<City> cities = new ArrayList<>();
    private String countryName;
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

    public int getCountryId() {
        return countryId;
    }

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

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }

    public void setAirline(Airline airline) {
        this.airlines.add(airline);
    }
}
