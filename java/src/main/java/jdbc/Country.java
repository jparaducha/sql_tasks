package jdbc;

import java.util.ArrayList;

public class Country {

    private ArrayList<Airline> airlines = new ArrayList<Airline>();
    private ArrayList<City> cities = new ArrayList<>();
    private String country_name;
    private int country_id;

    public Country() {
    }

    public Country(String name, int country_id) {
        this.country_name = name;
        this.country_id = country_id;
    }

    public Country(String name, ArrayList<City> cities) {
        this.country_name = name;
        this.cities = cities;
    }

    public int getCountryId() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        String citiesString = "";
        for (int i = 0; i < cities.size(); i++) {
            citiesString += cities.get(i).getCity_name() + (cities.size() == i + 1 ? "" : ", ");
        }

        String airlinesString = "";

        for (int i = 0; i < airlines.size(); i++) {
            airlinesString += airlines.get(i).getAirline_name() + (airlines.size() == i + 1 ? "" : ", ");
        }
        return "Country{" + (airlines.size() > 0 ? "airlines=" + airlinesString + ", " : "") + (cities.size() > 0 ? "cities=[" + citiesString + "], " : "") + "country_name='" + country_name + '\'' + '}';
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
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
