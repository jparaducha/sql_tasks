USE sql_task;

SELECT airports.airport_id ,airports.airport_name, airports.IATA_code, cities.city_name, countries.country_name
 FROM airports
 JOIN cities ON cities.city_id = airports.cityId
 INNER JOIN countries ON cities.countryId = countries.country_id;
 
SELECT planes.year,planes.plane_id, plane_models.model_name, plane_manufacturers.manufacturer_name
 FROM planes
 INNER JOIN plane_models ON planes.modelId = plane_models.model_id
 INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id;
 
SELECT pilots.pilot_name AS `Name`, pilots.pilot_age AS Age, pilot_licenses.issued_on AS `License issued date`, pilot_licenses.expires AS `License expiration date`
 FROM pilots
 INNER JOIN pilot_licenses ON pilot_licenses.license_id = pilots.licenseId;
 

SELECT passengers.passenger_name AS `Passenger`, a1.airport_name AS `From`,c1.city_name AS `Departure city`,  con1.country_name AS `Departure country`,
flights.departure_time AS `Departure time and date`,
 a2.airport_name AS `To`, c2.city_name AS `Destination city`, con2.country_name AS `Destination country`,
 flights.arrival_time AS `Arrival time and date`,
 flights.flight_duration AS `Duration`,
planes.year AS `Plane year`, plane_models.model_name AS `Plane model`, plane_manufacturers.manufacturer_name AS `Manufacturer`,
pilots.pilot_name AS `Pilot`, pilot_licenses.expires AS `Pilot licensed until`,
airlines.airline_name AS `Airline`
FROM planes
INNER JOIN plane_models ON planes.modelId = plane_models.model_id
INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id
INNER JOIN flights ON flights.planeId = planes.plane_id
INNER JOIN departure_airports ON departure_airports.flightId = flights.flight_id
INNER JOIN airports a1 ON a1.airport_id = departure_airports.airportId
INNER JOIN arrival_airports ON arrival_airports.flightId = flights.flight_id
INNER JOIN airports a2 ON a2.airport_id = arrival_airports.airportId
INNER JOIN pilots ON flights.pilotId = pilots.id_pilot
INNER JOIN pilot_licenses ON pilots.id_pilot = pilot_licenses.pilotId
INNER JOIN cities c1 ON c1.city_id = a1.cityId
INNER JOIN cities c2 ON c2.city_id = a2.cityId
INNER JOIN countries con1 ON con1.country_id = c1.countryId
INNER JOIN countries con2 ON con2.country_id = c2.countryId
INNER JOIN airlines ON airlines.airline_id = flights.airlineId
INNER JOIN tickets ON flights.flight_id = tickets.flightId
INNER JOIN passengers ON tickets.passengerId = passengers.passenger_id;

SELECT flights.flight_duration, a1.airport_name AS `Departure airport`, a2.airport_name AS `Arrival airport`
 FROM flights
 INNER JOIN departure_airports ON departure_airports.flightId = flights.flight_id 
 INNER JOIN airports a1 ON departure_airports.airportId = a1.airport_id
 INNER JOIN arrival_airports ON arrival_airports.flightId = flights.flight_id 
 INNER JOIN airports a2 ON arrival_airports.airportId = a2.airport_id;

SELECT AVG(pilot_age) `Average pilots age`
 FROM pilots;
 
SELECT SUM(price) `Collection from flight 1`
 FROM tickets
 INNER JOIN flights ON flights.flight_id = tickets.flightId
 WHERE flight_id=1;

SELECT COUNT(*)
 FROM passengers;

SELECT pilot_name AS `Pilot`, pilot_age AS `Age`
 FROM pilots
 HAVING pilot_age = (SELECT MIN(pilot_age) FROM pilots);
 
SELECT pilot_name, country_name
 FROM pilots
 LEFT JOIN countries ON pilots.countryId = countries.country_id;
 
SELECT pilot_name, issued_on
 FROM pilots
 RIGHT JOIN pilot_licenses ON pilots.licenseId = pilot_licenses.license_id;

SELECT *
 FROM pilots
 HAVING pilot_age > (SELECT AVG(pilot_age) FROM pilots);