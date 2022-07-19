package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AnimalTest {
    @Test
    public void test_AnimalInstantiatesCorrectly(){
        EndangeredAnimal newAnimal = new EndangeredAnimal("lion","healthy","young");
        assertTrue(newAnimal instanceof EndangeredAnimal);
    }
}
