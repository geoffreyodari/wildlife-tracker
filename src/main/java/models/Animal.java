package models;

import org.sql2o.Connection;

import java.util.List;

public abstract class Animal {
    public Integer id;
    public String name;
    public String  rangerName;

    public String type;
    public Animal(String name,String rangerName){
        this.name = name;
        this.rangerName =rangerName;
    }

    public String getName() {
        return name;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Integer getId() {
        return id;
    }

    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        }else{
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName())&&this.getRangerName().equals(newAnimal.getRangerName());
        }
    }


}
