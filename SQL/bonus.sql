/* 
 * Outside OF your basic CRUD (Create, Read, Update, Delete),
 * you can do a lot more with SQL. That said, we'll take a look
 * at some of the "bonus" things you can do with SQL.
 */

-- FOR INSTANCE, you can can ORDER your records BY a column's DATA:
SELECT * FROM associates ORDER BY "associate_locale";

SELECT * FROM batches;

-- Recall that an aggregate function returns a single value.

-- You could write a query like this to identify how many
-- associates a trainer has, BUT you would have to write this
-- every single trainer.
SELECT count(associate_id) FROM batches WHERE trainer_id = 1;

-- You can instead use GROUP BY in order to view the information
-- about how many associates each trainer has, and this only
-- requires that a single query. Note that GROUP BY is used
-- in conjunction with aggregate functions. You can also use the "HAVING" keyword
-- to further filter out your aggregated records. Note that HAVING is WHERE but for
-- GROUP BY.

/*
 * Remember:
 * 1) You do NOT use GROUP BY unless you are using an aggregate function.
 * 2) You cannot GROUP BY the column you're aggregating.
 */

SELECT "trainer_id", count(associate_id) FROM batches GROUP BY trainer_id 
HAVING trainer_id > 1;

-- Another practical example: Determining the states where most associates live.
SELECT "associate_locale", count(id) FROM associates GROUP BY "associate_locale" 
ORDER BY count desc;

/*
 * How can I get around needlessly retyping queries that I think are "too long"
 * or complex? In SQL, we can define what we call "views". Views are actually
 * virtual tables (creating a view does NOT create a new table). In any case,
 * a view can encompass a query and make it easier for you to execute that query.
 * 
 * Note the below syntax for creating a view:
 */

CREATE VIEW associate_location as
SELECT "associate_locale", count(id) FROM associates GROUP BY "associate_locale"
ORDER BY count DESC;

-- This is how you reference a view. Note that updating a view WILL affect the records
-- on the underlying table.
SELECT * FROM associate_location;

-- When you're tired of a view, use your typical DDL to drop it.
DROP VIEW associate_location;

-- I am altering the associates table for the sake of practicality
--for this demo. This requires that I use some DDL (the alter keyword).

ALTER TABLE associates ALTER COLUMN trainer_id DROP NOT NULL;

-- Inserting dummy data for the demo's sake
INSERT INTO associates values(DEFAULT, 'John', 'Georgia', 'playing LoZ', null),
(DEFAULT, 'Jerry', 'New York', 'playing basketball', null),
(DEFAULT, 'Jordan', 'Oregon', 'painting', null);

SELECT * FROM associates;
SELECT * FROM trainers;

/*
 * Our associates table has a foreign key that references the
 * trainers table. In order to figure out the trainer's details
 * for an associate, we are currently querying the trainer's
 * table using the "trainer_id" we find on the associates table.
 * 
 * This is really annoying and inconvenient. Fortunately, we
 * don't have to do this because we can use what we call "joins"
 * in SQL. Joins allow us to combine the data from multiple tables
 * so that we can see a more "complete" view of the data.
 * 
 * There are multiple types of joins. Today we will discuss these
 * joins:
 * 
 * outer joins
 * inner joins
 * left joins
 * right joins
 */

-- Outer join: You can perform an outer join using either 
-- "full outer join" or "full join". An outer join promises you
-- all records from both tables, even if there is nothing to
-- match on in the "on" clause. If there is no match, "NULL"
-- will be substituted where data doesn't exist.

SELECT * FROM associates 
FULL OUTER JOIN trainers 
ON associates.trainer_id = trainers.id;

-- Inner join: Join two tables but exclude any records that
-- cannot be matched between the 2 tables. It will NOT substitute
-- NULLs if a trainer can't be matched with an associate or vice
-- versa.

SELECT * FROM associates
INNER JOIN trainers 
ON associates.trainer_id = trainers.id;

-- Left join: Guarantees at a bare minimum all of the records
-- from the left table. Even if an associate does not have a
-- trainer, they will show up in the result set. However, any
-- trainers who don't have associates won't show up here!
SELECT * FROM associates LEFT JOIN trainers 
ON associates.trainer_id = trainers.id;

-- Right join: Guarantees at a minimum all records from the right
-- table.
SELECT * FROM associates RIGHT JOIN trainers 
ON associates.trainer_id = trainers.id;

-- Cross join for people who are interested; you do not have to
-- know this.
SELECT * FROM associates CROSS JOIN trainers;

-- This is called a "natural join" because you don't use the
-- join keyword to join the tables. You don't have to know this.
SELECT associates.associate_name, associates.associate_locale,
trainers.trainer_name, trainers.campus FROM associates, trainers
WHERE associates.trainer_id = trainers.id;

-- END JOINS

-- START SET OPERATIONS

/*
 * 
 * We also have access to various set operations in SQL. Set
 * operations allow us to easily combine and compare data.
 * Set operations take the results of two separate queries and
 * combine those results or filter out some of the results.
 * 
 * Types of set operations:
 * - union
 * - union all
 * - intersect
 * - except
 * 
 * When using a set operator:
 * 1) The number of columns in the result set must match up.
 * 2) Like data types must be stacked on top of each other.
 */

-- UNION: Combines the results of 2 queries, but it omits
-- duplicates.
SELECT "trainer_name" , "campus" FROM trainers
UNION
SELECT "associate_name", "associate_locale" FROM associates;

-- UNION: Combines the results of 2 queries, but it supports
-- duplicates.

SELECT "trainer_name", "campus" FROM trainers 
UNION ALL
SELECT "associate_name", "associate_locale" FROM associates;

-- Intersect: Any record that is in the first result set AND
-- in the second result set is included in the intersection.

SELECT "trainer_name", "campus" FROM trainers
INTERSECT
SELECT "associate_name", "associate_locale" FROM associates;

-- Except: Returns any records that are unique to the first
-- result set, meaning that they do NOT appear in the second
-- result set.
SELECT "trainer_name", "campus" FROM trainers
EXCEPT
SELECT "associate_name", "associate_locale" FROM associates;

