package models;

public class EndangeredAnimal extends Animal {
    private final String HEALTH;
    private final int AGE;

    public static final String DATABASE_TYPE = "Endangered";
    public EndangeredAnimal(String name,int rangerId,String health,int age){
        super(name,rangerId);
        this.HEALTH =health;
        this.AGE = age;
    }

    public Integer getAge() {
        return AGE;
    }

    public String getHealth() {
        return HEALTH;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof EndangeredAnimal)){
            return false;
        }else{
            EndangeredAnimal newAnimal =(EndangeredAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName())
                    && this.getRangerId().equals(newAnimal.getRangerId())
                    && this.getHealth().equals(newAnimal.getHealth())
                    && this.getAge().equals(newAnimal.getAge());
        }
    }
}
