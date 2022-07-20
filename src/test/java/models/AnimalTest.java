package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class AnimalTest {
    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal testAnimal = new Animal("lion",1);
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void animal_instantiatesWithName_String() {
        Animal testAnimal = new Animal("lion", 1);
        assertEquals("lion", testAnimal.getName());
    }

    @Test
    public void animal_instantiatesWithRangerId_int() {
        Animal testAnimal = new Animal("lion", 1);
        assertEquals(1, testAnimal.getRangerId());
    }

    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        Animal testAnimal = new Animal("lion", 1);
        Animal anotherAnimal = new Animal("lion", 1);
        assertTrue(testAnimal.equals(anotherAnimal));
    }
}
