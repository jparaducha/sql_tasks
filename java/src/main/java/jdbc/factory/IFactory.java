package jdbc.factory;

import jdbc.model.City;
import jdbc.model.Passenger;
import jdbc.model.Plane;

public interface IFactory {

    City getCity();

    Plane getPlane();

    Passenger getPassenger();

    Object getInstance(String modelToGet);
}
