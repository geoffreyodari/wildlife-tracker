# wildlife-tracker

* Database Setup
IN PSQL:
````
CREATE DATABASE wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name varchar, rangerID int);
CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, rangerId int, location varchar);
````
