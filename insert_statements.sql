USE sql_task;
SET SQL_SAFE_UPDATES= 0;

INSERT INTO countries(country_name)
VALUES("Argentina"), ("United Kingdom"), ("Saudi Arabia"),
("Egypt"), ("China"), ("Netherlands"), 
("France"), ("Russia"), ("South Africa"),
("Mexico"), ("United States"), ("Belarus"),
("Spain"), ("Canada"), ("Brazil"),
("Qatar"), ("Turkey"), ("Portugal");

INSERT INTO cities(city_name, countryId)
VALUES("Ezeiza", 1), ("London", 2), ("Rotterdam", 6),
("Dammam", 3), ("Cairo", 4), ("Beijing", 5),
("Amsterdam", 6), ("Paris", 7), ("Moscow", 8),
("Cape Town", 9), ("Johannesburg", 9), ("Mexico City",10),
("Cancun",10), ("Atlanta",11), ("New York City",11),
("Los Ángeles",11), ("San Francisco",11), ("Buenos Aires",1),
("Minsk",12), ("Hrodna",12), ("Guangzhou",5),
("Nice", 7), ("Madrid",13), ("Barcelona",13),
("Toronto",14), ("Vancouver",14), ("Sao Paulo",15),
("Rio de Janeiro",15), ("Brasilia",15);

INSERT INTO airports(airport_name, IATA_code, cityId) 
VALUES("Ministro Pistarini International", "EZE", 1), ("Heathrow Airport", "LHR", 2), ("Rotterdam The Hague", "RTM", 3),
 ("King Fahd International", "DMM", 4), ("Beijing Daxing International", "PKX", 6), ("Cairo International", "CAI", 5),
 ("Amsterdam Airport Schiphol", "AMS", 7), ("Paris Charles de Gaulle", "CDG", 8), ("Sheremetyevo International", "SVO", 9),
 ("Gatwick" , "LGW", 2), ("Luton", "LTN", 2), ("Cape Town International", "CPT", 10),
 ("O. R. Tambo International", "JNB", 11), ("Mexico City International", "MEX", 12), ("Cancún International", "CUN", 13),
 ("Hartsfield–Jackson Atlanta International", "ATL", 14), ("John F. Kennedy International", "JFK", 15), ("Los Angeles International", "LAX", 16),
 ("San Francisco International" , "SFO", 17), ("Domodedovo International", "DME", 9), ("Aeroparque Jorge Newbery", "AEP", 18),
 ("Minsk International", "MSQ", 19), ("Hrodna", "GNA", 20), ("Guangzhou Baiyun International", "CAN", 21),
 ("Orly", "ORY", 8), ("Nice Côte d'Azur", "NCE",22), ("Madrid-Barajas", "MAD", 23),
 ("Josep Tarradellas Barcelona–El Prat", "BCN", 24), ("Toronto Pearson International", "YYZ", 25), ("Vancouver International", "YVR", 26),
 ("São Paulo/Guarulhos International", "GRU", 27), ("São Paulo–Congonhas", "CGH",27), ("Rio de Janeiro/Galeão International", "GIG", 28),
 ("Brasília International", "BSB",29)
 ;
 
 INSERT INTO airlines(airline_name, countryId)
 VALUES("Qatar Airways",16),
 ("Air France",7),
 ("Virgin Atlantic Airways",2),
 ("Aerolíneas Argentinas",1),
 ("American Airlines",11),
 ("Delta Air Lines",11),
 ("China Southern Airlines",5),
 ("British Airways", 2),
 ("Turkish Airlines", 17),
 ("Tap Air Portugal", 18);
 
 INSERT INTO plane_manufacturers(manufacturer_name)
 VALUES("Boeing"),
 ("Airbus"),
 ("Comac");
 
 INSERT INTO plane_models(model_name, manufacturer)
 VALUES("737",1),
 ("747",1),
 ("767",1),
 ("A320",2),
 ("A330",2),
 ("C919",3);
 
 INSERT INTO planes(year, modelId)
 VALUES(1967, 1),
 (1969, 1),
 (1969, 1),
 (1970, 1),
 (1969, 2),
 (1972, 2),
 (1972, 2),
 (1981, 3),
 (1982, 3),
 (1982, 3),
 (1987, 4),
 (1989, 4),
 (1989, 4),
 (1993, 4),
 (1994, 5),
 (1995, 5),
 (1999, 5),
 (2001, 5);
 
 
 INSERT INTO pilot_licenses(issued_on, expires, pilotId)
 VALUES("2018-2-04","2023-2-04",1), ("2019-8-14","2024-8-14",2), ("2019-4-12","2026-4-12",3),
 ("2019-2-05","2026-2-05",4), ("2020-6-07","2027-6-07",5), ("2021-7-09","2028-7-09",6),
 ("2021-7-09","2028-7-09",7), ("2021-1-17","2027-1-17",8), ("2021-9-11","2028-9-11",9),
 ("2021-10-10","2028-10-10",10), ("2021-10-30","2028-10-30",11), ("2021-12-12","2027-12-12",12),
 ("2021-6-24","2028-6-24",13), ("2021-4-05","2028-4-05",14);
 
INSERT INTO pilots(pilot_name, pilot_age, licenseId)
VALUES("Howard Hughes",43 ,1), ("Eugène Roland Garros",32 ,2), ("Orville Wright", 26,3),
 ("Jules Verne", 29,4), ("George Louis Borges", 27,5), ("Leonardo DiCaprio", 24,6),
 ("John Watson", 28,7), ("Louis Armstrong",31,8), ("Rod Laver",30,9),
 ("Roger Federer",20,10), ("Billie Jean King",27,11), ("Margaret Court",29,12),
 ("Simonne Mathieu",27,13), ("Suzanne Lenglen",25,14);
 INSERT INTO pilots(pilot_name, pilot_age)
 VALUES ("Osama Bin Laden", 35);
 
 INSERT INTO passengers(passenger_name)
 VALUES("James Moriarty"), ("Jefferson Hope"), ("Enoch Drebber"),
 ("Joseph Stagerson"), ("Jonathan Small"), ("Jack McMurdo"),
 ("Cecil Baker"), ("Henry Baskerville"), ("Jack Stapleton"),
 ("Philip Pirrip"), ("Joe Gargery"), ("Abel Magwitch"),
 ("Estella Magwitch"), ("Herbert Pocket"), ("Dolge Orlick"),
 ("Bentley Drummle"), ("Phileas Fogg"), ("Jean Passepartout"),
 ("Emiliano Martínez"), ("Lisandro Martínez"), ("Rodrigo De Paul"),
 ("Nahuel Molina"), ("Marcos Acuña"),
 ("Nicolas Tagliafico"), ("Leandro Paredes"), ("Alejandro Gómez"),
 ("Gonzalo Montiel"), ("Lautaro Martínez"), ("Alejandro Sabella"),
 ("Jannik Sinner"), ("Carlos Alcaraz"), ("Andrey Rublev"),
 ("Stefanos Tsitsipas"), ("Sebastian Baez"), ("Francisco Cerúndolo"),
 ("Daniil Medvedev"), ("Holger Rune"), ("Casper Ruud"),
 ("Hubert Hurkacz"), ("Félix Auger-Aliassime"), ("Nick Kyrgios");

 INSERT INTO flights(airlineId,pilotId,planeId,price, departure_time, arrival_time, flight_duration)
 VALUES(4, 5, 1, 1700, "2022-11-03 23:55:00", "2022-11-04 16:10:00", "12:15:00"),
 (10, 1, 2, 260, "2022-11-03 13:40:00", "2022-11-03 15:00:00", "01:20:00"),
 (2, 2, 3, 286, "2022-11-04 08:30:00", "2022-11-04 11:50:00", "08:20:00"),
 (5, 4,18, 314, "2022-11-05 17:00:00", "2022-11-04 22:25:00", "06:25:00"),
 (5, 5, 6, 480, "2022-11-04 11:15:00", "2022-11-04 14:35:00", "04:20:00"),
 (4, 6, 9, 480, "2022-11-04 02:00:00", "2022-11-04 04:45:00", "02:45:00"),
 (1, 8, 11, 3692, "2022-11-04 15:15:00", "2022-11-05 08:15:00", "15:00:00"),
 (7, 10, 12, 864, "2022-11-04 08:00:00", "2022-11-04 11:05:00", "03:05:00");
 
 INSERT INTO airport_flights(flightId, departure_airportId, arrival_airportId)
 VALUES(1,1,27),
 (2,27,2),
 (3,1,27),
 (4,17,18),
 (5,17,15),
 (6,21,31),
 (7,7,9),
 (8,24,5);
 
 
 INSERT INTO tickets(passengerId, flightId)
 VALUES(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),
 (9,2),(10,2),(11,2),(12,2),(13,3),(14,3),(15,3),(16,3),
 (17,4),(18,4),(19,4),(20,4),(21,5),(22,5),(23,5),(24,5),
 (25,6),(26,6),(27,7),(28,7),(29,8),(30,8),(31,8),(32,8);
 # , `2022-11-04 16:10:00`,  `12:15:00`
 
 ALTER TABLE passengers
 ADD passenger_contact_number VARCHAR(22);
 
 ALTER TABLE pilots
 ADD countryId INT;
 
 ALTER TABLE pilots
 ADD CONSTRAINT FOREIGN KEY(countryId) REFERENCES countries(country_id) ON UPDATE CASCADE ON DELETE NO ACTION;
 
 UPDATE pilots
 SET countryId = 1
 WHERE pilot_name LIKE "%Borges";
 
 UPDATE pilots
 SET countryId = 7
 WHERE pilot_name LIKE "%Garros" OR pilot_name LIKE "%Lenglen"
 OR pilot_name LIKE "%Mathieu" OR pilot_name LIKE "%Verne";
 
 UPDATE pilots
 SET countryId = 11
 WHERE pilot_name LIKE "Howard%" OR pilot_name LIKE "Louis%"
 OR pilot_name LIKE "%Wright" OR pilot_name LIKE "%Jean%" OR pilot_name LIKE "%DiCaprio";
 
 UPDATE passengers 
 SET passenger_contact_number= "+05-9432-4523"
 WHERE passenger_name = "Jannik Sinner";
 
 UPDATE pilots
 SET pilot_name = "Jorge Luis Borges"
 WHERE id_pilot = 5;
 
 DELETE FROM passengers
 WHERE passenger_name LIKE "%Kyrgios";
 
 DELETE FROM pilots
 WHERE pilot_name LIKE "Osama%";
 