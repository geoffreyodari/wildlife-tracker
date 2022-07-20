package models;

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

    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animal)){
            return false;
        }else{
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName())&&this.getRangerId().equals(newAnimal.getRangerId());
        }
    }
}
