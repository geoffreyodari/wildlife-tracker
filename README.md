# wildlife-tracker

* Database Setup
IN PSQL:
````
DROP DATABASE wildlife_tracker;
CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE ranger (id serial PRIMARY KEY, name varchar, username varchar);
CREATE TABLE animals (id serial PRIMARY KEY, name varchar,rangername varchar, health varchar, age varchar,type varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, rangername varchar, location varchar,timespotted timestamp);
DROP DATABASE wildlife_tracker_test;
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
````
