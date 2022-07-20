package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class AbundantAnimalTest {
        @Test
        public void animal_instantiatesCorrectly_true(){
            AbundantAnimal testAnimal = new AbundantAnimal("lion",1);
            assertEquals(true, testAnimal instanceof Animal);
        }

        @Test
        public void animal_instantiatesWithName_String() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion",1);
            assertEquals("lion", testAnimal.getName());
        }

        @Test
        public void animal_instantiatesWithRangerId_int() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion",1);
            assertEquals(1, testAnimal.getRangerId());
        }

        @Test
        public void equals_returnsTrueIfNameAndRangerIdAreSame_true() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion",1);
            AbundantAnimal anotherAnimal = new AbundantAnimal("lion",1);
            assertTrue(testAnimal.equals(anotherAnimal));
        }

}
