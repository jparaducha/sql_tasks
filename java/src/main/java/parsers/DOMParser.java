package parsers;

import jdbc.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DOMParser {
    private static final Logger LOGGER = LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) {

        File xmlFile = new File("java\\src\\main\\resources\\xml\\airports.xml");
        ArrayList<Flight> flights = flightParser("java\\src\\main\\resources\\xml\\flight.xml");

        for (Flight flight : flights) {
            LOGGER.info(flight);
        }

        Element parsedFile = parseElement(xmlFile);

        NodeList childNodes = parsedFile.getChildNodes();
        ArrayList<Airport> airports = new ArrayList<>();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Airport airport = new Airport();
            Node airportNode = childNodes.item(i);

            if (airportNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            NodeList airportElementsList = airportNode.getChildNodes();

            for (int j = 0; j < airportElementsList.getLength(); j++) {
                Node airportElementNode = airportElementsList.item(j);

                if (airportElementNode.getNodeType() == Node.ELEMENT_NODE) {

                    switch (airportElementNode.getNodeName()) {
                        case "airportId":
                            airport.setAirportId(Integer.parseInt(airportElementNode.getTextContent()));
                            break;
                        case "airportName":
                            airport.setAirportName(airportElementNode.getTextContent());
                            break;
                        case "iataCode":
                            airport.setIataCode(airportElementNode.getTextContent());
                        default:
                            break;
                    }
                }
            }
            airports.add(airport);
        }

        for (Airport airport : airports) {
            LOGGER.info(airport);
        }
    }

    public static Element parseElement(File xml) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xml);
            return doc.getDocumentElement();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Flight> flightParser(String xmlPath) {
        ArrayList<Flight> flights = new ArrayList<>();
        try {

            File flightXml = new File(xmlPath);
            Element flightElement = parseElement(flightXml);

            NodeList flightNodes = flightElement.getChildNodes();

            for (int i = 0; i < flightNodes.getLength(); i++) {

                Flight flight = new Flight();
                Node flightNode = flightNodes.item(i);
                if (flightNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                NodeList flightElementList = flightNode.getChildNodes();

                for (int j = 0; j < flightElementList.getLength(); j++) {
                    Node flightElementNode = flightElementList.item(j);

                    if (flightElementNode.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList newNodeList = flightElementNode.getChildNodes();

                        switch (flightElementNode.getNodeName()) {
                            case "flight_id":
                                flight.setFlightId(Integer.parseInt(flightElementNode.getTextContent()));
                                break;

                            case "price":
                                flight.setPrice(Double.parseDouble(flightElementNode.getTextContent()));
                                break;
                            case "flight_duration":
                                flight.setFlightDuration(flightElementNode.getTextContent());
                                break;

                            case "departure_time":
                                flight.setDepartureTime(flightElementNode.getTextContent());
                                break;

                            case "arrival_time":
                                flight.setArrivalTime(flightElementNode.getTextContent());
                                break;

                            case "pilot":
                                Pilot pilot = new Pilot();
                                for (int p = 0; p < newNodeList.getLength(); p++) {
                                    Node pilotNode = newNodeList.item(p);

                                    if (pilotNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }
                                    switch (pilotNode.getNodeName()) {
                                        case "pilotId":
                                            pilot.setPilotId(Integer.parseInt(pilotNode.getTextContent()));
                                            break;
                                        case "pilotName":
                                            pilot.setPilotName(pilotNode.getTextContent());
                                            break;
                                        case "pilotAge":
                                            pilot.setPilotAge(Integer.parseInt(pilotNode.getTextContent()));
                                            break;
                                    }
                                }
                                flight.setPilot(pilot);
                                break;

                            case "plane":
                                Plane plane = new Plane();

                                for (int p = 0; p < newNodeList.getLength(); p++) {
                                    Node planeNode = newNodeList.item(p);

                                    if (planeNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }
                                    switch (planeNode.getNodeName()) {
                                        case "plane_id":
                                            plane.setPlaneId(Integer.parseInt(planeNode.getTextContent()));
                                            break;
                                        case "model":
                                            plane.setModelId(planeNode.getTextContent());
                                            break;
                                        case "year":
                                            plane.setYear(Integer.parseInt(planeNode.getTextContent()));
                                            break;
                                    }
                                }
                                flight.setPlane(plane);
                                break;
                            case "departure_airport":
                                Airport departureAirport = new Airport();

                                for (int p = 0; p < newNodeList.getLength(); p++) {
                                    Node departureNode = newNodeList.item(p);

                                    if (departureNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }
                                    switch (departureNode.getNodeName()) {
                                        case "airport_id":
                                            departureAirport.setAirportId(Integer.parseInt(departureNode.getTextContent()));
                                            break;
                                        case "airport_name":
                                            departureAirport.setAirportName(departureNode.getTextContent());
                                            break;
                                        case "IATA_code":
                                            departureAirport.setIataCode(departureNode.getTextContent());
                                            break;
                                        case "cityId":
                                            City city = new City(Integer.parseInt(departureNode.getTextContent()), "");
                                            departureAirport.setCity(city);
                                            break;
                                    }
                                }
                                flight.setDepartureAirport(departureAirport);

                                break;
                            case "arrival_airport":
                                Airport arrivalAirport = new Airport();

                                for (int p = 0; p < newNodeList.getLength(); p++) {
                                    Node arrivalNode = newNodeList.item(p);

                                    if (arrivalNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }
                                    switch (arrivalNode.getNodeName()) {
                                        case "airport_id":
                                            arrivalAirport.setAirportId(Integer.parseInt(arrivalNode.getTextContent()));
                                            break;
                                        case "airport_name":
                                            arrivalAirport.setAirportName(arrivalNode.getTextContent());
                                            break;
                                        case "IATA_code":
                                            arrivalAirport.setIataCode(arrivalNode.getTextContent());
                                            break;
                                        case "cityId":
                                            City city = new City(Integer.parseInt(arrivalNode.getTextContent()), "");
                                            arrivalAirport.setCity(city);
                                            break;
                                    }
                                }
                                flight.setArrivalAirport(arrivalAirport);

                                break;
                            case "passengers":
                                ArrayList<Passenger> passengers = new ArrayList<>();
                                for (int p = 0; p < newNodeList.getLength(); p++) {
                                    Passenger passenger = new Passenger();

                                    Node passengerNode = newNodeList.item(p);

                                    if (passengerNode.getNodeType() != Node.ELEMENT_NODE) {
                                        continue;
                                    }

                                    NodeList passengerNodeChildNodes = passengerNode.getChildNodes();

                                    for (int q = 0; q < passengerNodeChildNodes.getLength(); q++) {

                                        Node passengerField = passengerNodeChildNodes.item(q);

                                        if (passengerField.getNodeType() != Node.ELEMENT_NODE) {
                                            continue;
                                        }

                                        switch (passengerField.getNodeName()) {
                                            case "passenger_id":
                                                passenger.setPassengerId(Integer.parseInt(passengerField.getTextContent()));
                                                break;
                                            case "passenger_name":
                                                passenger.setPassengerName(passengerField.getTextContent());
                                                break;
                                        }
                                    }
                                    passengers.add(passenger);
                                }
                                flight.setPassengers(passengers);
                                break;
                        }
                    }
                }
                flights.add(flight);
            }

            return flights;
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
            return null;
        }
    }
}
