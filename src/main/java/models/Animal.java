package models;

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

    public Integer getId() {
        return id;
    }


}
