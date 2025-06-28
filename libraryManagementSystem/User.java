package libraryManagementSystem;

public class User {
    private static int nextId = 1;
    private int id;
    private String name;
    
    public User(String name) {
        this.name = name;
        this.id = nextId++;
    }
    @Override
    public String toString(){
        return "User ID: " + this.id +  ", User Name: " + this.name; 
    }

    public int getUserId(){
        return this.id;
    }

    public String getUserName() {
        return this.name;
    }
}
