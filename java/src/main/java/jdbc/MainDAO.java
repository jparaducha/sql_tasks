package jdbc;

import jdbc.DAO.mysql.AirportDAO;
import jdbc.DAO.mysql.CountryDAO;
import jdbc.DAO.mysql.FlightDAO;
import jdbc.DAO.mysql.PlaneDAO;
import jdbc.model.Airport;
import jdbc.model.Country;
import jdbc.model.Flight;
import jdbc.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainDAO {
    private static final Logger LOGGER = LogManager.getLogger(MainDAO.class);

    public static void main(String[] args) throws SQLException {

        PlaneDAO pld = new PlaneDAO();
        CountryDAO countryDAO = new CountryDAO();

        Plane plane2 = pld.getById(2);

        System.out.println(plane2);

        System.out.println("-------------------------------------------------");
        System.out.println("----------------ALL PLANES-----------------------");
        System.out.println("-------------------------------------------------");
        ArrayList<Plane> planes = pld.getAll();

        for (int i = 0; i < planes.size(); i++) {
            System.out.println(planes.get(i));
        }

        Plane planeToInsert = new Plane();

        planeToInsert.setYear(3333);
        planeToInsert.setModelId(2);

        pld.insertRow(planeToInsert);

        ArrayList<Plane> planeInserted = pld.getAll();

        int idToDelete = 0;
        System.out.println("-------------------------------------------------");
        System.out.println("----------------AFTER INSERTION------------------");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < planeInserted.size(); i++) {
            System.out.println(planeInserted.get(i));

            if (planeInserted.get(i).getYear() == 3333) {
                idToDelete = planeInserted.get(i).getPlaneId();
            }
        }

        pld.deleteById(idToDelete);

        Country Argentina = countryDAO.getById(1);

        System.out.println(Argentina);

        ArrayList<Country> countries;

        countries = countryDAO.getAll();

        System.out.println("-------------------------------------------------");
        System.out.println("----------------ALL COUNTRIES--------------------");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        FlightDAO fDAO = new FlightDAO();

        Flight flight4 = fDAO.getById(4);

        LOGGER.info(flight4);
        Plane plane5 = new PlaneDAO().getById(5);

        LOGGER.info(plane5);

        ArrayList<Flight> flights = fDAO.getAll();

        System.out.println("-------------------------------------------------");
        System.out.println("----------------ALL FLIGHTS----------------------");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < flights.size(); i++) {
            LOGGER.info("----------------------------------------------------------------------------------");
            LOGGER.info(flights.get(i));
        }

        System.out.println("-------------------------------------------------");
        System.out.println("----------------ALL AIRPORTS---------------------");
        System.out.println("-------------------------------------------------");
        ArrayList<Airport> airports = new AirportDAO().getAll();
        for (int i = 0; i < airports.size(); i++) {
            System.out.println(airports.get(i));
        }
    }
}
