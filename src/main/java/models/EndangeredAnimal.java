package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal implements DatabaseManagement {
    private final String HEALTH;
    private final String AGE;

    public static final String DATABASE_TYPE = "Endangered";
    public EndangeredAnimal(String name,String rangerName,String health,String age){
        super(name,rangerName);
        this.HEALTH =health;
        this.AGE = age;
        type = DATABASE_TYPE;
    }

    public String getAge() {
        return AGE;
    }

    public String getHealth() {
        return HEALTH;
    }



    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, rangerName,health,age, type) VALUES (:name, :rangerName, :health,:age,:type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("health", this.HEALTH)
                    .addParameter("age", this.AGE)
                    .addParameter("type", this.type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals where type='Endangered'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
}
