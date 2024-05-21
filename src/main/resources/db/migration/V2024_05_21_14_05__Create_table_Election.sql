--<table name>:				Election
--<description>:			Used to store the list of all election of the system

CREATE TABLE Election
(
	id				    SERIAL NOT NULL,
	name		        VARCHAR(255) NOT NULL,
	person			    VARCHAR(100) NOT NULL,
	CONSTRAINT		    PK_Election PRIMARY KEY
	(
		id
	)
);