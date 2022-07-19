package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AnimalTest {
    @Test
    public void test_AnimalInstantiatesCorrectly(){
        Animal newAnimal = new Animal();
        assertTrue(newAnimal instanceof Animal);
    }
}
