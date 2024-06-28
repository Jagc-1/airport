-- SQLBook: Code
DROP DATABASE IF EXISTS airport;
CREATE DATABASE airport;
USE airport;



DROP TABLE IF EXISTS `airlines`;
CREATE TABLE `airlines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `countries`
DROP TABLE IF EXISTS `countries`;
CREATE TABLE `countries` (
  `id` int NOT NULL ,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `flightfares`
DROP TABLE IF EXISTS `flightfares`;
CREATE TABLE `flightfares` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `details` text,
  `value` double(7,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `trips`

DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_date` date DEFAULT NULL,
  `price_tripe` double DEFAULT NULL,
  `departure_airport` VARCHAR(255) NOT NULL,
  `arrival_airport` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `tripulationroles`
DROP TABLE IF EXISTS `tripulationroles`;
CREATE TABLE `tripulationroles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `statuses`
DROP TABLE IF EXISTS `statuses`;
CREATE TABLE `statuses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `documenttypes`
DROP TABLE IF EXISTS `documenttypes`;
CREATE TABLE `documenttypes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `manufacturers`
DROP TABLE IF EXISTS `manufacturers`;
CREATE TABLE `manufacturers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `cities`
DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `id` int NOT NULL ,
  `name` varchar(255) DEFAULT NULL,
  `idcountry` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_city` (`idcountry`),
  CONSTRAINT `Fk_city` FOREIGN KEY (`idcountry`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `airports`
DROP TABLE IF EXISTS `airports`;
CREATE TABLE `airports` (
  `id` int NOT NULL ,
  `name` varchar(255)  DEFAULT NULL,
  `idcity` int DEFAULT NULL,  
  PRIMARY KEY (`id`),
  KEY `fk_id_city_airport` (`idcity`),
  CONSTRAINT `fk_id_city_airport` FOREIGN KEY (`idcity`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `customers`

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL UNIQUE,
  `password` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `id_document` varchar(255) DEFAULT NULL UNIQUE,
  `id_document_type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_customers` (`id_document_type`),
  CONSTRAINT `Fk_customers` FOREIGN KEY (`id_document_type`) REFERENCES `documenttypes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;









-- Table structure for table `employees`

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  `ingressdate` date DEFAULT NULL,
  `idairline` int DEFAULT NULL,
  `idairport` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_airline_employee` FOREIGN KEY (`idairline`) REFERENCES `airlines` (`id`),
  CONSTRAINT `fk_airport_employee` FOREIGN KEY (`idairport`) REFERENCES `airports` (`id`),
  CONSTRAINT `fk_rol_employee` FOREIGN KEY (`idrol`) REFERENCES `tripulationroles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `models`
DROP TABLE IF EXISTS `models`;
CREATE TABLE `models` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `manufacturerid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_manufacturerid` (`manufacturerid`),
  CONSTRAINT `Fk_manufacturerid` FOREIGN KEY (`manufacturerid`) REFERENCES `manufacturers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `planes`

DROP TABLE IF EXISTS `planes`;
CREATE TABLE `planes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plateNumber` varchar(255) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `fabrication_date` date DEFAULT NULL,
  `id_status` int DEFAULT NULL,
  `id_model` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `plateNumber` (`plateNumber`),
  KEY `fk_id_status_plane` (`id_status`),
  KEY `fk_id_model_plane` (`id_model`),
  CONSTRAINT `fk_id_model_plane` FOREIGN KEY (`id_model`) REFERENCES `models` (`id`),
  CONSTRAINT `fk_id_status_plane` FOREIGN KEY (`id_status`) REFERENCES `statuses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `flight_connections`

DROP TABLE IF EXISTS `flight_connections`;
CREATE TABLE `flight_connections` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `connection_number` VARCHAR(255) DEFAULT NULL,
  `id_trip` INT DEFAULT NULL,
  `id_plane` INT DEFAULT NULL,
  `type_fright` VARCHAR(255) DEFAULT NULL,
  `last_scale` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trip_connection` (`id_trip`),
  KEY `fk_plane_connection` (`id_plane`),
  CONSTRAINT `fk_plane_connection` FOREIGN KEY (`id_plane`) REFERENCES `planes` (`id`),
  CONSTRAINT `fk_trip_connection` FOREIGN KEY (`id_trip`) REFERENCES `trips` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `gates`
DROP TABLE IF EXISTS `gates`;
CREATE TABLE `gates` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gatenumber` varchar(255) DEFAULT NULL,
  `idairport` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_airport_gate` (`idairport`),
  CONSTRAINT `fk_airport_gate` FOREIGN KEY (`idairport`) REFERENCES `airports` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `revisions`
DROP TABLE IF EXISTS `revisions`;
CREATE TABLE `revisions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `revision_date` date DEFAULT NULL,
  `id_plane` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_plane_revision` (`id_plane`),
  CONSTRAINT `fk_id_plane_revision` FOREIGN KEY (`id_plane`) REFERENCES `planes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





-- Table structure for table `revemployee`
DROP TABLE IF EXISTS `revemployee`;
CREATE TABLE `revemployee` (
  `idemployee` int NOT NULL,
  `idrevision` int NOT NULL,
  PRIMARY KEY (`idemployee`,`idrevision`),
  KEY `fk_id_revision_revemployee` (`idrevision`),
  CONSTRAINT `fk_id_employee_revemployee` FOREIGN KEY (`idemployee`) REFERENCES `employees` (`id`),
  CONSTRAINT `fk_id_revision_revemployee` FOREIGN KEY (`idrevision`) REFERENCES `revisions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;







-- Table structure for table `revision_details`
DROP TABLE IF EXISTS `revision_details`;
CREATE TABLE `revision_details` (
  `id` int NOT NULL ,
  `description` text,
  `id_employee` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_revision_detail` (`id_employee`),
  CONSTRAINT `fk_employee_revision_detail` FOREIGN KEY (`id_employee`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `tripbooking`
DROP TABLE IF EXISTS `tripbooking`;
CREATE TABLE `tripbooking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `idtrips` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trips` (`idtrips`),
  CONSTRAINT `fk_trips` FOREIGN KEY (`idtrips`) REFERENCES `trips` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;







-- Table structure for table `tripbookingdetails`
DROP TABLE IF EXISTS `tripbookingdetails`;
CREATE TABLE `tripbookingdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idtripbooking` int DEFAULT NULL,
  `idcustomers` int DEFAULT NULL,
  `idfares` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tripbooking` (`idtripbooking`),
  KEY `fk_conection_trip_booking_details` (`idcustomers`),
  KEY `fk_flightfares_trip_booking_details` (`idfares`),
  CONSTRAINT `fk_conection_trip_booking_details` FOREIGN KEY (`idcustomers`) REFERENCES `customers` (`id`),
  CONSTRAINT `fk_flightfares_trip_booking_details` FOREIGN KEY (`idfares`) REFERENCES `flightfares` (`id`),
  CONSTRAINT `fk_tripbooking` FOREIGN KEY (`idtripbooking`) REFERENCES `tripbooking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- Table structure for table `tripcrews`
DROP TABLE IF EXISTS `tripcrews`;
CREATE TABLE `tripcrews` (
  `idemployees` int NOT NULL,
  `idconection` int NOT NULL,
  PRIMARY KEY (`idconection`,`idemployees`),
  KEY `fk_employees` (`idemployees`),
  CONSTRAINT `fk_conection` FOREIGN KEY (`idconection`) REFERENCES `flight_connections` (`id`),
  CONSTRAINT `fk_employees` FOREIGN KEY (`idemployees`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




INSERT INTO airlines (id, name) VALUES 
(1,'Airline A'), (2,'Airline B'), (3,'Airline C'), (4,'Airline D'), (5,'Airline E');

INSERT INTO countries (id, name) VALUES 
(1, 'Country A'), (2, 'Country B'), (3, 'Country C'), (4, 'Country D'), (5, 'Country E');

INSERT INTO cities (id, name, idcountry) VALUES 
(1, 'City A', 1), (2, 'City B', 2), (3, 'City C', 3), (4, 'City D', 4), (5, 'City E', 5);

INSERT INTO airports (id, name, idcity) VALUES 
(1, 'Airport A', 1), (2, 'Airport B', 2), (3, 'Airport C', 3), (4, 'Airport D', 4), (5, 'Airport E', 5);

INSERT INTO tripulationroles (name) VALUES 
('administrador'), ('tecnico'), ('ventas'), ('Pilot'), ('Co-Pilot'), ('Flight Attendant'), ('Ground Staff');

INSERT INTO documenttypes (name) VALUES 
('Passport'), ('ID Card'), ('Driver License'), ('Visa'), ('Work Permit');

INSERT INTO statuses (name) VALUES 
('Active'), ('Inactive'), ('Under Maintenance'), ('Retired'), ('Scheduled for Maintenance');

INSERT INTO manufacturers (name) VALUES 
('Manufacturer A'), ('Manufacturer B'), ('Manufacturer C'), ('Manufacturer D'), ('Manufacturer E');

INSERT INTO manufacturers (name) VALUES 
('Manufacturer A'), ('Manufacturer B'), ('Manufacturer C'), ('Manufacturer D'), ('Manufacturer E');



INSERT INTO customers (id, name, email, password, age, id_document, id_document_type) VALUES 
(1, 'cliente', 'cliente', 'cliente', 30,"123456", 1), 
(2, 'Customer B', 'customerB@example.com', 'passwordB', 25,"123", 2), 
(3, 'Customer C', 'customerC@example.com', 'passwordC', 35, "321", 3), 
(4, 'Customer D', 'customerD@example.com', 'passwordD', 40, "323", 4), 
(5, 'Customer E', 'customerE@example.com', 'passwordE', 45,"113",  5);

INSERT INTO employees (id, name, email, password, idrol, ingressdate, idairline, idairport) VALUES 
(1, 'admin', 'admin', 'admin', 1, '2015-06-01', 1, 1), 
(2, 'tecnico', 'tecnico', 'tecnico', 2, '2016-07-01', 2, 2), 
(3, 'ventas', 'ventas', 'ventas', 3, '2017-08-01', 3, 3), 
(4, 'Employee D', 'employeeD@example.com', 'passwordD', 4, '2018-09-01', 4, 4), 
(5, 'Employee E', 'employeeE@example.com', 'passwordE', 5, '2019-10-01', 5, 5);

INSERT INTO trips (trip_date, price_tripe, departure_airport, arrival_airport) VALUES 
('2024-07-01', 500.00, 'Airport A', 'Airport B'), 
('2024-08-01', 600.00, 'Airport B', 'Airport C'), 
('2024-09-01', 700.00, 'Airport C', 'Airport D'), 
('2024-10-01', 800.00, 'Airport D', 'Airport E'), 
('2024-11-01', 900.00, 'Airport E', 'Airport A');

INSERT INTO flightfares (description, details, value) VALUES 
('Economy', 'Basic economy fare', 100.000), 
('Business', 'Business class fare', 200.000), 
('First', 'First class fare', 300.000), 
('Premium Economy', 'Premium economy fare', 150.000), 
('Discount', 'Discounted fare', 50.000);



INSERT INTO gates (gatenumber, idairport) VALUES 
('Gate 1', 1), 
('Gate 2', 2), 
('Gate 3', 3), 
('Gate 4', 4), 
('Gate 5', 5);





INSERT INTO revision_details (id, description, id_employee) VALUES 
(1, 'Routine check-up', 1), 
(2, 'Engine maintenance', 2), 
(3, 'Landing gear inspection', 3), 
(4, 'Electrical system check', 4), 
(5, 'Interior cleaning', 5);

INSERT INTO tripbooking (date, idtrips) VALUES 
('2024-06-01', 1), 
('2024-07-01', 2), 
('2024-08-01', 3), 
('2024-09-01', 4), 
('2024-10-01', 5);

INSERT INTO tripbookingdetails (idtripbooking, idcustomers, idfares) VALUES 
(1, 1, 1), 
(2, 2, 2), 
(3, 3, 3), 
(4, 4, 4), 
(5, 5, 5);

INSERT INTO airport.models
(id, name, manufacturerid)
VALUES(1, ' boeing 747', 1);


INSERT INTO planes (plateNumber, capacity, fabrication_date, id_status, id_model) VALUES 
('ABC123', 150, '2020-01-01', 1, 1), 
('DEF456', 180, '2019-02-01', 2, 1), 
('GHI789', 200, '2018-03-01', 3, 1), 
('JKL012', 220, '2021-04-01', 4, 1), 
('MNO345', 250, '2022-05-01', 5, 1);

INSERT INTO flight_connections (connection_number, id_trip, id_plane, type_fright, Last_Scale) VALUES 
('FC123', 1, 1, 'Domestic', 'City A'), 
('FC456', 2, 2, 'International', 'City B'), 
('FC789', 3, 3, 'Domestic', 'City C'), 
('FC012', 4, 4, 'International', 'City D'), 
('FC345', 5, 5, 'Domestic', 'City E');

INSERT INTO tripcrews (idemployees, idconection) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5);

INSERT INTO revisions (revision_date, id_plane) VALUES 
('2024-01-01', 1), 
('2024-02-01', 2), 
('2024-03-01', 3), 
('2024-04-01', 4), 
('2024-05-01', 5);

INSERT INTO revemployee (idemployee, idrevision) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5);


