package models;

import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private Integer id;
    private String name;
    private Integer  rangerId;
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
            String sql = "INSERT INTO animals (name, rangerId) VALUES (:name, :rangerId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerId", this.rangerId)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    public Integer getId() {
        return id;
    }


}
