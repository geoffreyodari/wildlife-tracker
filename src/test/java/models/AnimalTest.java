package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

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
    public void equals_returnsTrueIfNameAndRangerIdAreSame_true() {
        Animal testAnimal = new Animal("lion", 1);
        Animal anotherAnimal = new Animal("lion", 1);
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        Animal testAnimal= new Animal("lion", 1);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void save_assignsIdAnimal() {
        Animal testAnimal = new Animal("lion", 1);
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal= new Animal("lion", 1);
        firstAnimal.save();
        Animal secondAnimal= new Animal("lion", 1);
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal= new Animal("lion", 1);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Elephant", 3);
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void save_savesAnimalIdIntoDB_true() {
        Ranger testRanger = new Ranger("Geoffrey", "geoffrey123");
        testRanger.save();
        Animal testAnimal = new Animal("Elephant", testRanger.getId());
        testAnimal.save();
        Animal savedAnimal = Animal.find(testAnimal.getId());
        assertEquals(savedAnimal.getRangerId(), testRanger.getId());
    }

    @Test
    public void getAnimals_retrievesAllAnimalsFromDB_animalsList() {
        Ranger testRanger = new Ranger("Geoffrey", "geoffrey123");
        testRanger.save();
        Animal firstAnimal = new Animal("lion", testRanger.getId());
        firstAnimal.save();
        Animal secondAnimal = new Animal("Elephant", testRanger.getId());
        secondAnimal.save();
        Animal[] animals = new Animal[] { firstAnimal, secondAnimal };
        assertTrue(testRanger.getAnimals().containsAll(Arrays.asList(animals)));
    }


}
