package jdbc.factory;

import jdbc.model.City;
import jdbc.model.Passenger;
import jdbc.model.Plane;

public class SchemaFactory implements IFactory {

    public City getCity() {
        return new City("Random city name from factory");
    }

    public Plane getPlane() {
        return new Plane(999, 999, "Random plane from factory", null);
    }

    public Passenger getPassenger() {
        return new Passenger(999, "Random passenger from factory", "999999");
    }
}
