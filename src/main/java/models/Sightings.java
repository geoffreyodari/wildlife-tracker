package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;


public class Sightings{
     private Integer animalid;
     private String rangername;
     private String location;
     private Timestamp timespotted;

     private String name;

     private String health;

     private String type;

     private String age;

     private int id;

    public Sightings(int animalid,String rangername,String location){
        this.animalid = animalid;
        this.rangername = rangername;
        this.location = location;
    }

    public String getRangername() {
        return rangername;
    }


    public Integer getAnimalid() {
        return animalid;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getLocation() {
        return location;

    }

    public Timestamp getTimespotted() {
        return timespotted;
    }

    public Timestamp getTimeSpotted() {
        return timespotted;
    }

    public static List<Sightings> find(int id) {
        String sql = "SELECT * FROM sightings JOIN animals ON(sightings.animalId=animals.id) WHERE sightings.animalId=:animalId";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("animalId",id)
                    .executeAndFetch(Sightings.class);
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings JOIN animals ON(sightings.animalId=animals.id)";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);
        }
    }


    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings  (animalId, rangername, location, timespotted) VALUES (:animalId, :rangername,:location ,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalid)
                    .addParameter("rangername", this.rangername)
                    .addParameter("location", this.location)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }


}
