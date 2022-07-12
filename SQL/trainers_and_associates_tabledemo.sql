-- this is a comment

-- DDL: Data Definition Language
-- Commands: Create, Alter, Drop

-- this creates a table with no columns
CREATE TABLE trainers();

-- How to change a table after it has been created
ALTER TABLE trainers ADD COLUMN trainer_name varchar(100);

 DROP TABLE trainers;
--Be careful when you drop tables - the data cannot be retreived

--Constraints: 
-- Used for setting guidelines inw hat data belongs to a column
-- Types of constraints: Data type, not null, Unique (values in column cannot be the same), check 
-- (used to put limits on values), 
-- primary key (unique and not null value in table, used as the unique identifier to a record)
-- foreign key (reference to a primary key in another table)

-- Datatypes: 
--Numeric types
	-- smallint - 2 bytes, small range integer
	--int (integer) - 4 bytes
	--bigint - 8 bytes, long range integer
	--decimal - variable storage type (there is a limit)

--Character types
	-- char(n) : character string; if don't specify the length, the length is 1; trailing spaces not counted
	-- varchar(n) : character string; recommended by documentation due to char being the slowest and 
		-- least efficient when it comes to storage costs
	-- text : equivalent of a string in sql; unlimited length

--Boolean (bool)
	--acceptable values: can hold: (true, false, null)
		--true, false
		--'t', 'f'
		-- 'y', 'n'
		-- 'yes', 'no'
		-- '1', '0'
-- Many other datatypes in Postgres: Range, Array, Date, Geometric types, JSON...

CREATE TABLE trainers (
	id SERIAL PRIMARY KEY, -- NOT NULL UNIQUE BY default
	-- id does not need to be the primary key, but it is commonly used as such
	-- SERIAL is a pseudo type: it is an autoincrementing integer
	trainer_name VARCHAR(100) NOT NULL,
	campus VARCHAR(10) NOT NULL,
	likes_coffee BOOL NOT NULL,
	caffine_lvl INT NOT NULL
);

-- DML - Data Manipulation Language
--All operations are done on individual rows: 
--Commands: Insert, Update, Delete

--DQL: Data Query Language
-- Commands: Select

INSERT INTO trainers (trainer_name, campus, likes_coffee, caffine_lvl) VALUES
('Christina', 'Texas', FALSE, 50), -- DO NOT use double quotes FOR CHARACTER TYPES
-- double quotes are for referring to column names
('Jackie', 'Tampa', TRUE, 45),
('Patrick', 'Reston', TRUE, 100),
('Brian', 'Texas', FALSE, 80); 

SELECT * FROM trainers;
-- the * (askerisk) is a wildcard that simply means "all"
-- (*.txt --> reminder from when we used this when working in the shell) 

ALTER TABLE trainers ADD COLUMN test_column TEXT;
--test_column is the name of the column I want to add, and TEXT is the data type for the values in this COLUMN 

ALTER TABLE trainers DROP COLUMN test_column;
-- if I want to drop a column

-- Altering the datatype constraint for a column

INSERT INTO trainers (trainer_name, campus, likes_coffee, caffine_lvl) VALUES
('Harvey', 'khkkfkfnwkehfo', 't', 90)

ALTER TABLE trainers ALTER COLUMN "campus" TYPE VARCHAR(15);

UPDATE trainers SET campus = 'Orlando' WHERE trainer_name = 'Jackie';
-- the where clause is one way to specify the record that I am referring to
UPDATE trainers SET caffine_lvl = 100;

UPDATE trainers SET caffine_lvl = 150 WHERE campus = 'Texas' RETURNING *;
-- The where clause is used to set the condition, and RETURNING returns the records that are changed

DELETE FROM trainers WHERE id = 3 RETURNING trainer_name;

SELECT id, trainer_name, likes_coffee FROM trainers;
SELECT campus, id FROM trainers;

 -- using where to set condition for the query
SELECT * FROM trainers WHERE caffine_lvl = 100; -- need TO specify the column


CREATE TABLE associates (
	id SERIAL PRIMARY KEY,
	associate_name TEXT NOT NULL,
	associate_locale VARCHAR(10) NOT NULL, 
	associate_hobby TEXT,
	trainer_id INT REFERENCES trainers(id) NOT NULL -- FOREIGN KEY, it IS REFERENCING the PRIMARY KEY
	--of another table
);

DROP TABLE associates;
-- because associates has a column that is dependent on the trainers table (foreign key)
-- if we ever want to drop the trainers table we can't do so without first dropping the associates table

INSERT INTO associates (associate_name, associate_locale, associate_hobby, trainer_id) VALUES 
('Myesha', 'Virginia', 'swimming', 1),
('Stephanie', 'Colorado', 'hiking', 4),
('Jonathan', 'California', NULL, 2),
('Muhammad', 'Florida', 'Kayaking', 6)

-- use ALTER to change columns after they have been made
ALTER TABLE associates ALTER COLUMN associate_locale TYPE TEXT;

SELECT * FROM associates;

INSERT INTO associates (associate_name, associate_locale, trainer_id) VALUES 
('Tommy', 'North Carolina', 1)


-- Multiplicity 
-- This is referring to a set of data in relation to another set of data
-- There are 3 categories of multiplicity: 
	-- 1-1 One to one: 2 sets of data are unique to each other
	-- 1-m One to many: one set of data can have many instances of the other data set
		-- we see this in the associates table with the foreign key
		-- each trainer can have more than one associate
	-- m-m Many to many: both data sets can have many instances of each other
		-- for example in our cohort there are "many" trainers to many associates

CREATE TABLE batches (
	trainer_id INT REFERENCES trainers(id),
	associate_id INT REFERENCES associates(id)
);

INSERT INTO batches (trainer_id, associate_id) VALUES 
	(1, 1),
	(1, 2),
	(4, 3)
	
SELECT * FROM batches;
 -- one to many: the same trainer can have multiple associates

SELECT * FROM trainers, batches;
-- you can display more than one table at a time

UPDATE trainers SET likes_coffee = TRUE WHERE id = 4;

SELECT * FROM trainers WHERE caffine_lvl > 100 AND likes_coffee = FALSE;

-- in SQL we can also have something called subqueries
-- basically a query within a query

SELECT avg (caffine_lvl) FROM trainers;
-- avg: average - basically calculating the average caffine_lvl in the trainers table

SELECT * FROM trainers WHERE caffine_lvl > (SELECT avg (caffine_lvl) FROM trainers);
-- this query is selecting all of the trainers that have a caffine level that is greater than the average
-- the query finds out what is the average caffine level, then finds the trainers that have a higher than 
-- avg lvl

