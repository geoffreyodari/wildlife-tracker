package models;

import org.sql2o.Connection;

import java.util.List;

public class AbundantAnimal extends Animal implements DatabaseManagement{
    private static final String DATABASE_TYPE = "Abundant";

    public AbundantAnimal(String name,int rangerId){
        super(name,rangerId);
        type = DATABASE_TYPE;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        }else{
            AbundantAnimal newAnimal = (AbundantAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName())&&this.getRangerId().equals(newAnimal.getRangerId());
        }
    }



    @Override
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

    public static List<AbundantAnimal> all() {
        String sql = "SELECT * FROM animals Where type='Abundant'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(AbundantAnimal.class);
        }
    }

    public static AbundantAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            AbundantAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(AbundantAnimal.class);
            return animal;
        }
    }
}
