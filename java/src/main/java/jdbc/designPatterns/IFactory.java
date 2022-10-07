package jdbc.designPatterns;

import jdbc.model.City;
import jdbc.model.Country;
import jdbc.model.Passenger;
import jdbc.model.Plane;

import java.sql.SQLException;

public interface IFactory {

    City getCity();

    Plane getPlane();

    Passenger getPassenger();

    Object getInstance(String modelToGet);

    Country getCountry(int id) throws SQLException;
}
