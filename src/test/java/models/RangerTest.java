package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DatabaseRule.class)
public class RangerTest {

    @Test
    public void ranger_Instantiates_correctly(){
        Ranger newRanger = new Ranger("James","james2022");
        assertTrue(newRanger instanceof Ranger);
    }

    @Test
    public void ranger_Instantiates_withName_geoffrey(){
        String testName = "Geoffrey";
        Ranger testRanger = new Ranger("Geoffrey","geoffrey222");
        assertEquals(testName,testRanger.getName());
    }

    @Test
    public void ranger_instantiates_with_username(){
        String testUsername = "geoffrey222";
        Ranger testRanger = new Ranger("Geoffrey","geoffrey222");
        assertEquals(testUsername,testRanger.getUsername());
    }

    @Test
    public void equals_returnsTrueIf_NameAndUsernameEqual_true(){
        Ranger firstRanger = new Ranger("Geoffrey","geoffrey222");
        Ranger secondRanger = new Ranger("Geoffrey","geoffrey222");
        assertTrue(firstRanger.equals(secondRanger));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Ranger() {
        Ranger testRanger = new Ranger("Geoffrey","geoffrey222");
        testRanger.save();
        assertTrue(Ranger.all().get(0).equals(testRanger));
    }

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger firstRanger = new Ranger("Mathew", "mathew123");
        firstRanger.save();
        Ranger secondRanger = new Ranger("Mark", "mark123");
        secondRanger.save();
        assertEquals(true, Ranger.all().get(0).equals(firstRanger));
        assertEquals(true, Ranger.all().get(1).equals(secondRanger));
    }





}
