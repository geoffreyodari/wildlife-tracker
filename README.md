# wildlife-tracker

* Database Setup
IN PSQL:
````
CREATE DATABASE wildlife_tracker;
CREATE TABLE ranger (id serial PRIMARY KEY, name varchar, username varchar);
CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, rangerId int, location varchar);
````
