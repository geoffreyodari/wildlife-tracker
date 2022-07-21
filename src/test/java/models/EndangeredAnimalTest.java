package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class EndangeredAnimalTest {

    @Test
    public void endangeredAnimal_Instantiates_Correctly(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        assertTrue(newAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void endangeredAnimal_gets_name(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        assertEquals("rhino" ,newAnimal.getName());
    }

    @Test
    public void endangeredAnimal_gets_health(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        assertEquals("healthy" ,newAnimal.getHealth());
    }

    @Test
    public void endangeredAnimal_gets_age(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        assertEquals("young" ,newAnimal.getAge());
    }

    @Test
    public void equals_returnsTrueIfNameAndRangerIdAreSame_True(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        EndangeredAnimal otherAnimal = new EndangeredAnimal("rhino","Geoffrey","healthy","young");
        assertTrue(newAnimal.equals(otherAnimal));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        EndangeredAnimal testAnimal= new EndangeredAnimal("lion", "Geoffrey","healthy","young");
        testAnimal.save();
        System.out.println(EndangeredAnimal.all().get(0).name);
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimal));
    }

    @Test
    public void save_assignsIdAnimal() {
        EndangeredAnimal testAnimal= new EndangeredAnimal("lion", "Geoffrey","healthy","young");
        testAnimal.save();
        EndangeredAnimal  savedAnimal = (EndangeredAnimal) EndangeredAnimal.all().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        EndangeredAnimal firstAnimal= new EndangeredAnimal("lion1", "Geoffrey","healthy","young");
        firstAnimal.save();
        EndangeredAnimal secondAnimal= new EndangeredAnimal("lion", "Geoffrey","healthy","young");
        secondAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimal firstAnimal= new EndangeredAnimal("lion", "Geoffrey","healthy","young");
        firstAnimal.save();
        EndangeredAnimal secondAnimal= new EndangeredAnimal("lion", "Geoffrey","healthy","young");
        secondAnimal.save();
        assertEquals(EndangeredAnimal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void save_savesAnimalIdIntoDB_true() {
        Ranger testRanger = new Ranger("Geoffrey", "geoffrey123");
        testRanger.save();
        EndangeredAnimal testAnimal = new EndangeredAnimal("Elephant", testRanger.getName(),"healthy","young");
        testAnimal.save();
        EndangeredAnimal savedAnimal =  EndangeredAnimal.find(testAnimal.getId());
        assertEquals(savedAnimal.getRangerName(), testRanger.getName());
    }








}
