package models;

public class Sightings {
     private Integer animalId;
     private Integer rangerId;
     private String location;

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
}
