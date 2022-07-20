package models;

import org.sql2o.Connection;

import java.util.List;

public class Ranger {
        private String name;

        private String username;

        private int id;

    public Ranger(String name,String username){
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object otherRanger){
        if(!(otherRanger instanceof Ranger)){
            return false;
        }else{
            Ranger newRanger = (Ranger) otherRanger;
            return this.getName().equals(newRanger.getName()) &&
                    this.getUsername().equals(newRanger.getUsername());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO ranger (name, username) VALUES (:name, :username)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("username", this.username)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Ranger> all() {
        String sql = "SELECT * FROM ranger";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Ranger.class);
        }
    }

    public static Ranger find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM ranger where id=:id";
            Ranger person = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranger.class);
            return person;
        }
    }

    public List<Animal> getAnimals() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where rangerId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Animal.class);
        }
    }

    public int getId() {
        return id;
    }
}
