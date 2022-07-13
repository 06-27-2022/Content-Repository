-- this is a comment

-- DDL: Data Definition Language
-- Commands: Create, Alter, Drop

-- this creates a table with no columns
CREATE TABLE trainers();

-- How to change a table after it has been created
ALTER TABLE trainers ADD COLUMN trainer_name varchar(100);

DROP TABLE trainers;
DROP TABLE associates; 
DROP TABLE batches; 
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
('Muhammad', 'Florida', 'Kayaking', 2)


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
	(1, 5),
	(1, 6),
	(4, 7)
	
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


-- Aggregate functions
-- these are functions that perform a calulation ona  set of rows and they return a single ROW
-- Some aggregate functions: 
	-- avg() - get the average
	-- count() - counting the total; for ex, how many trainers are in my trainer table
	-- max() - the maximum value
	-- min() - the minimum value
	-- sum() - adding up the total

-- COUNT function
SELECT COUNT(DISTINCT(associate_name)) FROM associates;
-- distinct keyword looks for unique records, does not count duplicates

-- SUM function
SELECT sum(caffine_lvl) FROM trainers;
-- simple addition

-- MIN funciton
SELECT min(caffine_lvl) FROM trainers;


-- Subqueries
-- A subquery is a query within a query - subqueries are also know as inner queries 
-- the "outer" query would also be known as the main query
-- Subqueries are always enclosed within ()
-- You can combine subqueries within select, insert, update, and delete commands, as well as
-- WITH different operators (<, > =, <=, ...), as well as with aggregate functions as above

SELECT * FROM trainers; 
SELECT * FROM associates; 
SELECT * FROM batches; 

INSERT INTO trainers (trainer_name, campus, likes_coffee, caffine_lvl) VALUES 
('Charles', 'Virginia', 't', 55),
('Stephen', 'Virginia', 'f', 200)

SELECT trainer_name, campus FROM trainers WHERE caffine_lvl = (SELECT min(caffine_lvl) FROM trainers);
-- The below syntax is not allowed in Postgres; aggregate functions are not allowed in the WHERE position
-- SELECT trainer_name FROM trainers WHERE caffine_lvl = (min(caffine_lvl));

-- you can have subqueries that return more than one row only if they are used with multiple value operators
-- multiple value operators include: IN, EXISTS, NOT IN, ANY/SOME, ALL 

UPDATE trainers SET caffine_lvl = caffine_lvl + 10 WHERE caffine_lvl IN (SELECT caffine_lvl FROM trainers 
WHERE caffine_lvl < 150);

DELETE FROM trainers WHERE caffine_lvl IN (SELECT caffine_lvl FROM trainers WHERE caffine_lvl < 100) RETURNING trainer_name;


-- Referential integrity
-- Just to revisit this one more time: referential integrity refers to the relationships between tables;
-- specifically the accuracy and consistency of data within that relationship
-- This is referring to the use of foreign keys - the connection (relationship) between DATA
-- in other tables; whenever a foreign key value is used, it must reference a valid existing primary key
-- in the parent table


-- TCL: Transaction Control Language
-- THis sublanguage is concerned with groups sql commands and executing them as a batch
-- Commands: Commit, Savepoint, Rollback, Transact
-- For today we will only be focusing on COMMIT 

-- Commit is used to save changes to your tables and reflect those changes in the database; the commit command
-- is very essential in SQL, and is typically used after DML commands (or transactions - transactions 
-- as simply a set of sql statements). When you execute a DML command without a commit statement, 
-- the changes to the tables are only visible to you - they haven't actually been committed to the database itself
-- Once you commit the changes, those changes become visible on the database itself

-- if I want to commit my changes to the database, I must surround those statements with a begin block 
BEGIN TRANSACTION; 
INSERT INTO batches (trainer_id, associate_id) VALUES
(1, 8)
COMMIT; 

-- one thing to keep in mind with these transactions - if one of my statements retuls in an error 
-- while i am inside of the begin block, the subsequent commands after the error occured won't execute
-- until the transaction is closed

BEGIN TRANSACTION; 

INSERT INTO associates (associate_name, associate_locale, associate_hobby, trainer_id) VALUES 
('Ben', 'Florida', 'reading', 1)
INSERT INTO batches (trainer_id, associate_id) VALUES
(1, 9)
ROLLBACK; -- you can ROLLBACK IF an error occurs inside OF the TRANSACTION block
-- note that you cannot continue executing commands if there is a failure inside the block

COMMIT; 
-- if you commit your changes, they are guaranteed to be there 
-- this is important in case there is a failure of some kind; without committing, your data is not
-- guaranteed to still be there once the database is back up and running
-- Some vendors autocommit to the database for you so you don't need to call the commit command
-- but you can turn this autocommit on and off






