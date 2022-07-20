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
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        assertTrue(newAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void endangeredAnimal_gets_name(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        assertEquals("rhino" ,newAnimal.getName());
    }

    @Test
    public void endangeredAnimal_gets_health(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        assertEquals("healthy" ,newAnimal.getHealth());
    }

    @Test
    public void endangeredAnimal_gets_age(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        assertEquals(2 ,newAnimal.getAge());
    }

    @Test
    public void equals_returnsTrueIfNameAndRangerIdAreSame_True(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        EndangeredAnimal otherAnimal = new EndangeredAnimal("rhino",1,"healthy",2);
        assertTrue(newAnimal.equals(otherAnimal));
    }






}
