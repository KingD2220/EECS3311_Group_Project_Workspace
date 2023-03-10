

CREATE TABLE ACCOUNT 
	(userName 			VARCHAR(30) 	NOT NULL, 
     hashPassWord		VARCHAR(30)	NOT NULL,
     PRIMARY KEY (userName));

CREATE TABLE EMPLOYEE
	(last_name 			VARCHAR(30) 	NOT NULL, 
     first_name 		VARCHAR(30)		NOT NULL, 
     address 			VARCHAR(30) 	NOT NULL, 
     phone_num 			VARCHAR(30)		NOT NULL,
     PRIMARY KEY(phone_num));
     
     CREATE TABLE RESERVATION
	(arrival_date		VARCHAR(30)		NOT NULL,
     departure_date     VARCHAR(30)     NOT NULL,
     resNum 			INT(30)		    NOT NULL AUTO_INCREMENT,
     last_name 			VARCHAR(30) 	NOT NULL, 
     first_name 		VARCHAR(30)		NOT NULL, 
     address 			VARCHAR(30) 	NOT NULL, 
     phone_num 			VARCHAR(30)		NOT NULL,
     credit_card		VARCHAR(30)     NOT NULL,
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
	 bedType 			VARCHAR(30)	    NOT NULL, 
     numberOfBeds       INT				NOT NULL, 
     occupancy			INT 			NOT NULL, 
     roomSize			INT 			NOT NULL, 
     fixedRatePerNight  DOUBLE 			NOT NULL);    
     
     