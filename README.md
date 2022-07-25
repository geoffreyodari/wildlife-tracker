# wildlife-tracker

An application to help rangers track wildlife sightings.

## Installation

* System Requirements
Openjdk 18.0.1 
OpenJDK Runtime Environment 
Postgres SQL

```
Run $ gradle build
Run $ gradle run
```

* Database Setup
IN PSQL:
```
postgres=#DROP DATABASE wildlife_tracker;
postgres=#CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
wildlife_tracker=#CREATE TABLE ranger (id serial PRIMARY KEY, name varchar, username varchar);
wildlife_tracker=#CREATE TABLE animals (id serial PRIMARY KEY, name varchar,rangername varchar, health varchar, age varchar,type varchar);
wildlife_tracker=#CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, rangername varchar, location varchar,timespotted timestamp);
wildlife_tracker=#DROP DATABASE wildlife_tracker_test;
wildlife_tracker=#CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
```
* To access the application 
Open your Browser and enter the link http://localhost:4567

* Adding an animal 
* Recording sightings
* View all sightings
