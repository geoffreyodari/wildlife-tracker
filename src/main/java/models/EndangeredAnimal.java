package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal {
    private final String HEALTH;
    private final String AGE;

    public static final String DATABASE_TYPE = "Endangered";
    public EndangeredAnimal(String name,int rangerId,String health,String age){
        super(name,rangerId);
        this.HEALTH =health;
        this.AGE = age;
        String type = DATABASE_TYPE;
    }

    public String getAge() {
        return AGE;
    }

    public String getHealth() {
        return HEALTH;
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
