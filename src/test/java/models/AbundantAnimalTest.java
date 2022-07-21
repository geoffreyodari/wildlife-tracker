package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class AbundantAnimalTest {
        @Test
        public void animal_instantiatesCorrectly_true(){
            AbundantAnimal testAnimal = new AbundantAnimal("lion","Geoffrey");
            assertEquals(true, testAnimal instanceof Animal);
        }

        @Test
        public void animal_instantiatesWithName_String() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion","Geoffrey");
            assertEquals("lion", testAnimal.getName());
        }

        @Test
        public void animal_instantiatesWithRangerId_int() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion","Geoffrey");
            assertEquals("Geoffrey", testAnimal.getRangerName());
        }

        @Test
        public void equals_returnsTrueIfNameAndRangerIdAreSame_true() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion","Geoffrey");
            AbundantAnimal anotherAnimal = new AbundantAnimal("lion","Geoffrey");
            assertTrue(testAnimal.equals(anotherAnimal));
        }

        @Test
        public void save_assignsIdAnimal() {
            AbundantAnimal testAnimal = new AbundantAnimal("lion", "Geoffrey");
            testAnimal.save();
            AbundantAnimal savedAnimal = (AbundantAnimal) AbundantAnimal.all().get(0);
            assertEquals(savedAnimal.getId(), testAnimal.getId());
        }

        @Test
        public void all_returnsAllInstancesOfAnimal_true() {
            AbundantAnimal firstAnimal= new AbundantAnimal("lion", "Geoffrey");
            firstAnimal.save();
            AbundantAnimal secondAnimal= new AbundantAnimal("lion", "Geoffrey");
            secondAnimal.save();
            assertEquals(true, AbundantAnimal.all().get(0).equals(firstAnimal));
            assertEquals(true, AbundantAnimal.all().get(1).equals(secondAnimal));
        }

        @Test
        public void find_returnsAnimalWithSameId_secondAnimal() {
            AbundantAnimal firstAnimal= new AbundantAnimal("lion", "Geoffrey");
            firstAnimal.save();
            AbundantAnimal secondAnimal = new AbundantAnimal("Elephant", "George");
            secondAnimal.save();
            assertEquals(AbundantAnimal.find(secondAnimal.getId()), secondAnimal);
        }

        @Test
        public void save_savesAnimalIdIntoDB_true() {
            Ranger testRanger = new Ranger("Geoffrey", "geoffrey123");
            testRanger.save();
            AbundantAnimal testAnimal = new AbundantAnimal("Elephant", testRanger.getName());
            testAnimal.save();
            AbundantAnimal savedAnimal =  AbundantAnimal.find(testAnimal.getId());
            assertEquals(savedAnimal.getRangerName(), testRanger.getName());
        }





}
