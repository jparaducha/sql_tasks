DROP DATABASE IF EXISTS `sql_task`;
CREATE DATABASE `sql_task`;
USE sql_task;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS airports;
CREATE TABLE airports(
`airport_id` INT auto_increment PRIMARY KEY NOT NULL,
`airport_name` VARCHAR(80) NOT NULL UNIQUE,
`IATA_code` VARCHAR(3) UNIQUE
,cityId INT NOT NULL,
FOREIGN KEY (cityId) REFERENCES cities(city_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS cities;
CREATE TABLE cities(
city_id INT NOT NULL auto_increment PRIMARY KEY,
city_name VARCHAR(30) UNIQUE,
countryId INT NOT NULL,
FOREIGN KEY (countryId) REFERENCES countries(country_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS countries;
CREATE TABLE countries(
country_id INT NOT NULL auto_increment PRIMARY KEY,
country_name VARCHAR(30) UNIQUE
);

DROP TABLE IF EXISTS airlines;
CREATE TABLE airlines(
airline_id INT NOT NULL auto_increment PRIMARY KEY,
airline_name VARCHAR(35) NOT NULL,
countryId INT NOT NULL,
FOREIGN KEY (countryId) REFERENCES countries(country_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS flights;
CREATE TABLE flights(
`flight_id` INT auto_increment PRIMARY KEY NOT NULL,
`flight_duration` TIME,
`price` DOUBLE,
departure_time datetime NOT NULL,
arrival_time DATETIME NOT NULL,
#departure_airport INT NOT NULL,
#arrival_airport INT NOT NULL,
airlineId INT NOT NULL,
pilotId INT,
planeId INT,
#passengerId INT,
#FOREIGN KEY (departure_airport) REFERENCES departure_airports(departure_id) ON UPDATE CASCADE ON DELETE NO ACTION,
#FOREIGN KEY (arrival_airport) REFERENCES arrival_airports(arrival_id) ON UPDATE CASCADE ON DELETE NO ACTION,
FOREIGN KEY (airlineId) REFERENCES airline(airline_id) ON UPDATE CASCADE ON DELETE NO ACTION,
FOREIGN KEY (pilotId) REFERENCES pilots(id_pilot) ON UPDATE CASCADE ON DELETE NO ACTION,
FOREIGN KEY (planeId) REFERENCES planes(plane_id) ON UPDATE CASCADE ON DELETE NO ACTION
#FOREIGN KEY (passengerId) REFERENCES passengers(passenger_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS airport_flights;
CREATE TABLE airport_flights(
`airport_flight_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`flightId` INT NOT NULL,
`departure_airportId` INT NOT NULL,
`arrival_airportId` INT NOT NULL,
 #CONSTRAINT `departure_id` PRIMARY KEY (`flightId`, `airportId`),
 FOREIGN KEY (flightId) REFERENCES flights(flight_id) ON UPDATE CASCADE ON DELETE NO ACTION,
 FOREIGN KEY (departure_airportId) REFERENCES airports(airport_id) ON UPDATE CASCADE ON DELETE NO ACTION,
 FOREIGN KEY (arrival_airportId) REFERENCES airports(airport_id) ON UPDATE CASCADE ON DELETE NO ACTION
);


DROP TABLE IF EXISTS plane_manufacturers;
CREATE TABLE plane_manufacturers(
manufacturer_id INT auto_increment NOT NULL PRIMARY KEY,
manufacturer_name VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS plane_models;
CREATE TABLE plane_models(
model_id INT NOT NULL auto_increment PRIMARY KEY UNIQUE,
model_name VARCHAR(30) NOT NULL,
manufacturer INT NOT NULL,
FOREIGN KEY (manufacturer) REFERENCES plane_manufacturers(manufacturer_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS planes;
CREATE TABLE planes(
plane_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`year` INT NOT NULL,
modelId INT,
FOREIGN KEY (modelId) REFERENCES plane_models(model_id) ON UPDATE CASCADE ON DELETE NO ACTION
);
DROP TABLE IF EXISTS pilot_licenses;
CREATE TABLE pilot_licenses(
license_id INT NOT NULL auto_increment PRIMARY KEY,
issued_on DATE,
expires DATE,
pilotId INT,
FOREIGN KEY (pilotId) REFERENCES pilots(id_pilot) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS pilots;
CREATE TABLE pilots(
id_pilot INT NOT NULL auto_increment PRIMARY KEY,
pilot_name VARCHAR(30),
pilot_age INT,
licenseId INT,
FOREIGN KEY (licenseId) REFERENCES pilot_licenses(license_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets(
ticket_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
passengerId INT NOT NULL,
flightId INT NOT NULL,
FOREIGN KEY(passengerId) REFERENCES passengers(passenger_id) ON UPDATE CASCADE ON DELETE NO ACTION,
FOREIGN KEY(flightId) REFERENCES flights(flight_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS passengers;
CREATE TABLE passengers(
passenger_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
passenger_name VARCHAR(55) NOT NULL
);


