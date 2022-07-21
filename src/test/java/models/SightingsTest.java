package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Date;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class SightingsTest {
    @Test
    public void sightings_instantiates_Correctly(){
        Sightings newSighting = new Sightings(1,"Geoffrey","Third quadrant");
        assertTrue(newSighting instanceof Sightings);
    }

    @Test
    public void instanceOfSightingGetsAnimalId(){
        Sightings newSighting = new Sightings(1,"Geoffrey","Third quadrant");
        assertEquals(1,newSighting.getAnimalId());
    }

    @Test
    public void instanceOfSightingGetsRangerId(){
        Sightings newSighting = new Sightings(1,"Geoffrey","Third quadrant");
        assertEquals("Geoffrey",newSighting.getRangerName());
    }

    @Test
    public void instanceOfSightingGetsLocation(){
        Sightings newSighting = new Sightings(1,"geoffrey","Third quadrant");
        assertEquals("Third quadrant",newSighting.getLocation());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Sightings firstSighting = new Sightings(1,"Geoffrey","Third quadrant");
        firstSighting.save();
        Timestamp rightNow = new Timestamp(new Date(System.currentTimeMillis()).getTime());
        Sightings secondSighting = new Sightings(1,"Geoffrey","Third quadrant");
        assertEquals(Sightings.find(secondSighting.getAnimalId()).getTimeSpotted().getDate(), rightNow.getDate());
    }





}
