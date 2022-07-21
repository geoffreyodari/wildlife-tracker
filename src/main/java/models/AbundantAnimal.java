package models;

import org.sql2o.Connection;

import java.util.List;

public class AbundantAnimal extends Animal implements DatabaseManagement{
    private static final String DATABASE_TYPE = "Abundant";

    public AbundantAnimal(String name,String rangerName){
        super(name,rangerName);
        type = DATABASE_TYPE;
    }





    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, rangerName, type) VALUES (:name, :rangerName, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerName", this.rangerName)
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
