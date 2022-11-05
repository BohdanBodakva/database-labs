# lab6

Based on the previous work (back-end with Spring Boot), a number of software structures (triggers, procedures, functions, cursors) should be written for the existing database. For stored procedures, ensure that they are called using backend controllers.

1) Add an arbitrary table to DB 1 and connect it to another existing table with a 1:M relationship. However, to ensure value integrity, use triggers instead of a physical foreign key.

2) Stored procedures:
   1. Provide parameterized insertion of new values into an arbitrary table.
   2. To ensure the implementation of M:M connection between 2 tables, i.e. to insert into the connecting table the corresponding tape according to the real-existing values ​​(eg surname, name) in these main tables.
   3. Create a package that inserts 10 tapes into an arbitrary DB table in the format <Noname+No>, for example: Noname5, Noname6, Noname7, etc.
   4. Write a custom function that will search for Max, Min, Sum or Avg for a column of an arbitrary table in the database. Write a procedure that will call this function in SELECT.
   5. Write 1 procedure with a cursor to perform one of the following tasks:
      1. Using a cursor, ensure the dynamic creation of 2 tables with names containing a time stamp, the structure of the tables is identical to any structure of a DB table. Then randomly copy tapes from the parent table to one or the other additional table. Re-starting the procedure again creates new similar tables, in which the data from the parent table will be randomly spread again.
      2. Using a cursor, ensure dynamic creation of tables with names+timestamp taken from a column from an arbitrary DB table, with a random number of columns (from 1 to 9). Column names and type are arbitrary.
      3. Using a cursor, ensure dynamic creation of databases with names taken from a column from an arbitrary table of the current database, with a random number of tables for each database (from 1 to 9). The structure of the tables is arbitrary. The names of the tables correspond to the name of the database with a serial number from 1 to 9.

3) Write 3 arbitrary triggers for the tables of the current database, as an example you can take the following:
   1. The value of a certain column cannot end with two zeros
   2. Prohibit any modification of the data in the table
   3. Prohibit removal of tapes from the table
   4. Ensure a minimum cardinality of 6 tapes for a certain database table
   5. Ensure the cardinality (min=2, max=6) of tapes for a certain database table
   6. Create a log table in which to keep logs with a time stamp when data is deleted for a certain table
   7. Create a log table in which to keep logs with a time stamp when data is modified for the table
   8. For a specific column, provide the input format: 2 arbitrary letters, except M and R + '-' + 3 numbers + '-' + 2 numbers
   9. For a specific column, provide the input format: 1 letter: A, M or Z + 5 numbers + 2 random letters
   10. Only the following names are allowed for a given column: 'Svitlana', 'Petro', 'Olha', 'Taras'.
   11. For a specific column, provide the input format: the first letter in the value must match the first letter of the value of the adjacent field in the string