# Wildlife Tracker

An application to help rangers track wildlife sightings.

### Author
Geoffrey Odari

### Installation

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
  ![image](https://drive.google.com/uc?export=view&id=1euAl99FEDHVamFNLjXKX06Yo6w-yZbnl)
* Adding an animal
  ![image](https://drive.google.com/uc?export=view&id=1uKZ1UJPxDgS3Uh458EJJOdgb4ezzhNji)
* Recording sightings
  ![image](https://drive.google.com/uc?export=view&id=17u79--uQLaX5CpnCurOCcz1NgpFpWAjM)
* View all sightings
  ![image](https://drive.google.com/uc?export=view&id=19fVIpQjDDaQMwPEWVbdhBpWpCSUvXXCH)