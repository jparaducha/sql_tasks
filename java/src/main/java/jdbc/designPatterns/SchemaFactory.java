package jdbc.designPatterns;

import jdbc.DAO.ICountryDAO;
import jdbc.DAO.IPlaneDAO;
import jdbc.DAO.mySQLservice.CountryService;
import jdbc.DAO.mySQLservice.IBaseService;
import jdbc.DAO.mySQLservice.PlaneService;
import jdbc.model.City;
import jdbc.model.Country;
import jdbc.model.Passenger;
import jdbc.model.Plane;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class SchemaFactory implements IFactory {

    String type;

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();

    public SchemaFactory(String type) throws IOException {
        this.type = type;
    }

    public static IBaseService create(String serviceClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class.forName(serviceClass).getDeclaredConstructor();

        Object o = Class.forName(serviceClass).getDeclaredConstructor().newInstance();
        return (IBaseService) o;
    }

    public static Object createObject(String serviceClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class.forName(serviceClass).getDeclaredConstructor();

        Object o = Class.forName(serviceClass).getDeclaredConstructor().newInstance();
        return o;
    }

    public City getCity() {
        return new City("Random city name from factory");
    }

    public Plane getPlane() throws SQLException {
        Plane plane;
        if (type == "dao") {
            plane = new PlaneService().getById(1);
        } else {

            IPlaneDAO planeMapper = session.getMapper(IPlaneDAO.class);
            plane = planeMapper.getPlaneById(1);
        }
        return plane;
    }

    public Passenger getPassenger() {
        return new Passenger(999, "Random passenger from factory", "999999");
    }

    public Object getInstance(String modelToGet) {
        switch (modelToGet) {
            case "CITY":
                return new City("Random city name from factory");
            case "PLANE":
                return new Plane(999, 999, "Random plane from factory", null);
            case "PASSENGER":
                return new Passenger(999, "Random passenger from factory", "999999");
            default:
                return null;
        }
    }

    @Override
    public Country getCountry(int id) throws SQLException {
        Country country;
        if (type == "dao") {
            country = new CountryService().getById(id);
        } else {

            ICountryDAO countryMapper = session.getMapper(ICountryDAO.class);
            country = countryMapper.getCountryById(id);
        }

        return country;
    }
}
