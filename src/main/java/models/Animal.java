package models;

import org.sql2o.Connection;

import java.util.List;

public abstract class Animal {
    public Integer id;
    public String name;
    public Integer  rangerId;

    public String type;
    public Animal(String name,int rangerId){
        this.name = name;
        this.rangerId =rangerId;
    }

    public String getName() {
        return name;
    }

    public Integer getRangerId() {
        return rangerId;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        }else{
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName())&&this.getRangerId().equals(newAnimal.getRangerId());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, rangerId, type) VALUES (:name, :rangerId, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerId", this.rangerId)
                    .addParameter("type", this.type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }




    public Integer getId() {
        return id;
    }


}
