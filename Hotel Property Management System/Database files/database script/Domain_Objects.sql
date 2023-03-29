

CREATE TABLE ACCOUNT 
	(userName 			VARCHAR(30) 	NOT NULL, 
     hashPassWord		VARCHAR(30) 	NOT NULL,
     jobType			VARCHAR(15), 
     PRIMARY KEY (userName));

CREATE TABLE EMPLOYEE
	(last_name 			VARCHAR(30) 	NOT NULL, 
     first_name 		VARCHAR(30)		NOT NULL, 
     address 			VARCHAR(30) 	NOT NULL, 
     phone_num 			VARCHAR(30)		NOT NULL,
     hourlyPay          VARCHAR(70)		NOT NULL,
     weeklyWage         VARCHAR(10),
     employeeNum        int             NOT NULL AUTO_INCREMENT,
     emplRole           VARCHAR(15)     NOT NULL,
     email              VARCHAR(50)     NOT NULL,
     hoursWorked        VARCHAR(10),
     PRIMARY KEY(employeeNum));
     
     CREATE TABLE RESERVATION
	(arrival_date		VARCHAR(30)		NOT NULL,
     departure_date     VARCHAR(30)     NOT NULL,
     resNum 			INT(30)		    NOT NULL AUTO_INCREMENT,
     last_name 			VARCHAR(30) 	NOT NULL, 
     first_name 		VARCHAR(30)		NOT NULL, 
     address 			VARCHAR(30) 	NOT NULL, 
     phone_num 			VARCHAR(30)		NOT NULL,
     credit_card		VARCHAR(30)     NOT NULL,
     roomType           VARCHAR(30),
     roomNumber         VARCHAR(5),
     checkedIn          VARCHAR(5)      DEFAULT'NO',
     checkedOut         VARCHAR(5)      DEFAULT'NO',
     addOnns            Varchar(30),
     PRIMARY KEY(resNum),
     UNIQUE(phone_num));

CREATE TABLE CUSTOMER
	(last_name 			VARCHAR(30) 	NOT NULL, 
     first_name 		VARCHAR(30)		NOT NULL, 
     address 			VARCHAR(30) 	NOT NULL, 
     phone_num 			VARCHAR(30)		NOT NULL,
     credit_card		VARCHAR(30)     NOT NULL,
     ID   				INT 		    NOT NULL AUTO_INCREMENT,
     FOREIGN KEY(phone_num) REFERENCES RESERVATION(phone_num) ON DELETE CASCADE ON UPDATE CASCADE,
     PRIMARY KEY(ID));
     
     
CREATE TABLE ROOM
	(roomType			VARCHAR(30) 	NOT NULL, 
     reservationStatus  VARCHAR(20)     DEFAULT'AVAILABLE',
	 roomSatus          VARCHAR (8)     DEFAULT 'CLEAN',
     roomNumber         VARCHAR(5),
     start_date		    VARCHAR(30),
     end_date           VARCHAR(30),
     fixedRate          DOUBLE 			NOT NULL,
     PRIMARY KEY(roomNumber));
     
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('100', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('101', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('102', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('103', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('104', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('105', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('106', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('107', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('108', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('109', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('200', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('201', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('202', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('203', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('204', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('205', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('206', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('207', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('208', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('209', 'Presidential', 1000.00);
	 INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('300', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('301', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('302', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('303', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('304', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('305', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('306', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('307', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('308', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('309', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('400', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('401', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('402', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('403', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('404', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('405', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('406', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('407', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('408', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('409', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('500', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('501', 'Standard', 100.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('502', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('503', 'Deluxe', 200.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('504', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('505', 'Suite', 300.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('506', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('507', 'Executive', 500.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('508', 'Presidential', 1000.00);
     INSERT INTO ROOM(roomNumber, roomType, fixedRate) VALUES('509', 'Presidential', 1000.00);
     