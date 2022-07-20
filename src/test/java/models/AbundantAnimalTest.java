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

        @Test
        public void save_assignsIdAnimal() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion", 1);
            testAnimal.save();
            AbundantAnimal savedAnimal = (AbundantAnimal) AbundantAnimal.all().get(0);
            assertEquals(savedAnimal.getId(), testAnimal.getId());
        }

        @Test
        public void all_returnsAllInstancesOfAnimal_true() {
            AbundantAnimal firstAnimal= new AbundantAnimal("lion", 1);
            firstAnimal.save();
            AbundantAnimal secondAnimal= new AbundantAnimal("lion", 1);
            secondAnimal.save();
            assertEquals(true, AbundantAnimal.all().get(0).equals(firstAnimal));
            assertEquals(true, AbundantAnimal.all().get(1).equals(secondAnimal));
        }

        @Test
        public void find_returnsAnimalWithSameId_secondAnimal() {
            AbundantAnimal firstAnimal= new AbundantAnimal("lion", 1);
            firstAnimal.save();
            AbundantAnimal secondAnimal = new AbundantAnimal("Elephant", 3);
            secondAnimal.save();
            assertEquals(AbundantAnimal.find(secondAnimal.getId()), secondAnimal);
        }

        @Test
        public void save_savesAnimalIdIntoDB_true() {
            Ranger testRanger = new Ranger("Geoffrey", "geoffrey123");
            testRanger.save();
            AbundantAnimal testAnimal = new AbundantAnimal("Elephant", testRanger.getId());
            testAnimal.save();
            AbundantAnimal savedAnimal =  AbundantAnimal.find(testAnimal.getId());
            assertEquals(savedAnimal.getRangerId(), testRanger.getId());
        }



}
