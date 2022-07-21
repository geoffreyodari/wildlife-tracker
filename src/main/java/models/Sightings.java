package models;

import org.sql2o.Connection;

import java.sql.Date;
import java.sql.Timestamp;

public class Sightings {
     private Integer animalId;
     private Integer rangerId;
     private String location;

     private Timestamp timespotted;

     private int id;

    public Sightings(int animalId,int rangerId,String location){
        this.animalId = animalId;
        this.rangerId = rangerId;
        this.location = location;
    }

    public Integer getRangerId() {
        return rangerId;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;

    }

    public Timestamp getTimeSpotted() {
        return timespotted;
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings  where animalId=:animalId";
            Sightings sighting = con.createQuery(sql)
                    .addParameter("animalId", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sightings.class);
            return sighting;
        }
    }


    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings  (animalId, rangerId, location, timespotted) VALUES (:animalId, :rangerId,:location ,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("rangerId", this.rangerId)
                    .addParameter("location", this.location)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }


}
