--<table name>:				election_vote
--<description>:			Used to store the saved responses for election

CREATE TABLE election_vote
(
    id				    SERIAL NOT NULL,
    idnp		        VARCHAR(13) NOT NULL,
    election_id			INT NOT NULL,
    CONSTRAINT		    PK_ElectionVote PRIMARY KEY
    (
         id
    ),
    CONSTRAINT		    FK_ElectionVote_Election FOREIGN KEY (election_id)
    REFERENCES		    election (id)
    ON DELETE		    NO ACTION
    ON UPDATE		    NO ACTION
);