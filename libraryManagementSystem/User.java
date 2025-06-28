package libraryManagementSystem;

import java.util.Objects;

public class User {
    private static int nextId = 1; // Class variable that keeps track of user id
    private final int id;
    private final String name;
    
    public User(String name) {
        this.name = name;
        this.id = nextId++; // assigns current nextId then increments by 1
    }

    // --- ACCESSORS ---

    public int getUserId(){
        return this.id;
    }

    public String getUserName() {
        return this.name;
    }

    // --- HELPER FUNCTIONS ---

    /**
     * Returns a formatted string representation of the User.
     * Useful for logging or printing user details.
     */
    @Override
    public String toString(){
        return "User ID: " + this.id +  ", User Name: " + this.name; 
    }

    /**
     * Compares this user to another object for equality.
     * Two users are considered equal if they have the same name.
     * This overrides the default Object.equals() to support logical equality based on name.
     */
    @Override
    public boolean equals(Object obj) {                                // maintains all the functionality of .equals but also allows for User.name comparisons 
        if (this == obj) {return true;}                                // normal equals functionality for comparing two object
        if (obj == null || getClass() != obj.getClass()) return false; // does a check to make sure the two objects are of the same class and obj is not null
        User user = (User) obj;                                        // casts the obj to class User since we confirmed it in the line above

        return name.equals(user.name);                                 // boolean return comparing the .name String of each object
    }

    /**
     * Returns the hash code for this user based on the name.
     * This must be consistent with the equals() method to allow usage
     * in hash-based collections such as HashMap or HashSet.
     */
    @Override
    public int hashCode() {         // This tells the hashCode to use name when hashing objects in this class.
        return Objects.hash(name);  // This allows us in combination with the equals Override to do O(1) look ups 
    }                               // within the userMap(User: ArrayList<Book>) in LibManager class using .containsKey() method.
                                    // Instead of using the address in memory to check if they are equal it will not use User.name.
}
