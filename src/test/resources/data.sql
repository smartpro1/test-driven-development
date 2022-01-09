DROP TABLE IF EXISTS CARS;

CREATE TABLE CARS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  type VARCHAR(250) NOT NULL
);

INSERT INTO CARS (name, type) VALUES ('duster','hybrid');
INSERT INTO CARS (name, type) VALUES ('micra','hatchback');
INSERT INTO CARS (name, type) VALUES ('lodgy','suv');
INSERT INTO CARS (name, type) VALUES ('suv','jeep');
