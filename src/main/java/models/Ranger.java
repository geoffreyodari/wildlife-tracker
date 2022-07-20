package models;

public class Ranger {
        private String name;

        private String username;

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
}
