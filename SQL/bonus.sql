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

