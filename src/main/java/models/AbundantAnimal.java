package models;

import org.sql2o.Connection;

import java.util.List;

public class AbundantAnimal extends Animal{
    private static final String DATABASE_TYPE = "Abundant";

    public AbundantAnimal(String name,int rangerId){
        super(name,rangerId);
        String type = DATABASE_TYPE;
    }

    public static List<AbundantAnimal> all() {
        String sql = "SELECT * FROM animals";
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
