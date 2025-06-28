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
    
    // --- BOOK OPERATIONS ---
    public String addBook(String bookName, String authorName) {
        try {

            Book bookToAdd = new Book(bookName, authorName); // New book instance
            this.bookMap.computeIfAbsent(bookName, k -> new ArrayList<Book>()).add(bookToAdd); // If the key doesn't already exist, make a new entry, otherwise append to list
            return "Successfully added " + bookName + "!";

        } catch (Exception e) {
            return "An error has occurred adding book: " + bookName +  ": " + e;
        }
        
    }

    // --- USER OPERATIONS ---
    public String addUser(String userName) {

        try {
            // TO DO: add check for userName already in userMap (w/ helper function)

            User userToAdd = new User(userName); // New user instance
            this.userMap.put(userToAdd, new ArrayList<Book>()); // New Users start with 0 books so no need to check for existence
            return "Successfully added user: " + userName + "!";

        } catch (Exception e) {
            return "An error has occurred adding user: " + userName + ": " + e;
        }
    }

    // --- HELPER FUNCTIONS ---
}
    
