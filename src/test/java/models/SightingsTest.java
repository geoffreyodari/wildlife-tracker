package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class SightingsTest {
    @Test
    public void sightings_instantiates_Correctly(){
        Sightings newSighting = new Sightings(1,1,"Third quadrant");
        assertTrue(newSighting instanceof Sightings);
    }

    @Test
    public void instanceOfSightingGetsAnimalId(){
        Sightings newSighting = new Sightings(1,1,"Third quadrant");
        assertEquals(1,newSighting.getAnimalId());
    }

    @Test
    public void instanceOfSightingGetsRangerId(){
        Sightings newSighting = new Sightings(1,2,"Third quadrant");
        assertEquals(2,newSighting.getRangerId());
    }

    @Test
    public void instanceOfSightingGetsLocation(){
        Sightings newSighting = new Sightings(1,2,"Third quadrant");
        assertEquals("Third quadrant",newSighting.getLocation());
    }



}
