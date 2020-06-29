CREATE TABLE TEAM(
	id int NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	squad_type VARCHAR(100) NOT NULL,
	tag VARCHAR(100) NOT NULL
);
INSERT INTO TEAM (id, name, squad_type, tag) values ('1', 'TIGERS','PLANKTON', 'TP1');
--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------
CREATE TABLE EMPLOYEE(
	id int NOT NULL PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	given_name VARCHAR(100) NOT NULL,
	position VARCHAR(100) NOT NULL,
	age int NOT NULL,
	team_id int REFERENCES TEAM (id)
);
INSERT INTO EMPLOYEE (id, first_name, last_name, given_name, position, age, team_id)
values ('1', 'Stepan','Papazian', 'M', 'Junior Java', '28', '1');
