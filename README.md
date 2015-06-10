# TP4 CAR - JAVA EE

## Structure :
 - build :  all built files (jar and war)
 - dist : all files to distribute (ear, war and jar) and corresponding Javadoc (to deliver to a client for example)
 - TP4_CAR-war : module directory for the web application
 - TP4_CAR-ejb : module directory for all EJB and entities
 - README.txt
 - nbproject, src & build.xml : to manage all the project (clean, build, etc)

In each module, the src directory is for all sources files. In the web application (TP4_CAR-war), the web directory contains all pages.

## How to :
 1/ Import TP4_CAR.zip into Netbeans (TODO : export the project before !!!!)
 2/ Go into service and connect to the sample JDBC
 3/ execute the 2 creations of table (see the SQL Code section)

## Tests :
 - It's difficult to make usefull tests. We have tested only the entity Books.

## Compilation :
 - The compilation pass without warnings and no @suppressWarning present

## Documentation :
 - see into the directory dist/war/ and dist/ejb/

## UML :
 - It is a classic project and there is nothing in particular

## SQL Code :
# Creation of the Books table

CREATE TABLE books (
  b_title varchar(255) NOT NULL PRIMARY KEY,
  b_author varchar(50) NOT NULL,
  b_year int NOT NULL
)

# Creation of the Orders table

CREATE table APP.ORDERS (
    NUMBER INT NOT NULL 
    PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
    (START WITH 1, INCREMENT BY 1),
    BOOKS BLOB NOT NULL
)