package libraryManagementSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibManager {
    private Map<String, ArrayList<Book>> bookMap; // Mapping that stores bookName as Key, Instances of Book Object(s) in a list as the value. 
    private Map<User, ArrayList<Book>> userMap; // Mapping that stores instance of User object as Key, Instances of Book Object(s) in a list as the value.

    // Initializing Mappings
    public LibManager() {
        this.bookMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }
    
    // --- BOOK CRUD OPERATIONS ---
    public String addBook(String bookName, String authorName) {
        try {

            Book bookToAdd = new Book(bookName, authorName); // New book instance
            this.bookMap.computeIfAbsent(bookName, k -> new ArrayList<Book>()).add(bookToAdd); // If the key doesn't already exist, make a new entry, otherwise append to list
            return "Successfully added " + bookName + "!";

        } catch (Exception e) {
            return "An error has occurred adding book: " + bookName +  ": " + e;
        }
        
    }

    // --- USER CRUD OPERATIONS ---
    public String addUser(String userName) {

        try {
            User userToAdd = new User(userName); // New user instance
            if (!this.isInUserMap(userToAdd)) { // checks if the userName already exists in userMap

                this.userMap.put(userToAdd, new ArrayList<Book>()); // New Users start with 0 books so no need to check for existence
                return "Successfully added user: " + userName + "!";

            } else {
                return "Error! User: " + userName + " already exists!";
            }

        } catch (Exception e) {
            return "An error has occurred adding user: " + userName + ": " + e;
        }
    }

    // --- HELPER METHODS ---
    //      --- USERS ---
    private boolean isInUserMap(User userObj) { // checks if userObj.name is in userMap due to @Overrides in User Class
        return userMap.containsKey(userObj);
    }

    //     --- BOOKS ---
    private boolean isInBookMap(String bookName) {
        return bookMap.containsKey(bookName);
    }
}
    
