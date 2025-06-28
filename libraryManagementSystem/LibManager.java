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
    
    // --- BOOK CURD OPERATIONS ---
    public void addBook(String bookName, String authorName) {
        if (bookName == null || bookName.isBlank()) {
            throw new IllegalArgumentException("Book name cannot be empty!");
        }

        Book bookToAdd = new Book(bookName, authorName); // New book instance
        this.bookMap.computeIfAbsent(bookName, k -> new ArrayList<Book>()).add(bookToAdd); // If the key doesn't already exist, make a new entry, otherwise append to list
    }

    public ArrayList<Book> getBooksByName(String bookName) {
        if (!this.isInBookMap(bookName)) {
            throw new IllegalArgumentException("Book: '" + bookName + "' not found!");
        }
        return new ArrayList<>(this.bookMap.getOrDefault(bookName, new ArrayList<>()));
    }

    public boolean bookIsAvailable(String bookName) {
        try {
            int bookCount = this.amountBooksByName(bookName);
            if (bookCount > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public int amountBooksByName(String bookName) {
        if (!this.isInBookMap(bookName)) {
            throw new IllegalArgumentException("Book: '" + bookName + "' not found!");
        }
        ArrayList<Book> bookList = this.bookMap.get(bookName);
        return bookList.size();
    }

    public void barrowBook(String bookName, String userName) {
        if (this.isInBookMap(bookName) && this.userInMapByName(userName) && this.bookIsAvailable(bookName)) {
            ArrayList<Book> bookList = this.bookMap.get(bookName);
            Book bookObj = bookList.remove(bookList.size() - 1);

            User userObj = this.getUserByName(userName);
            userMap.get(userObj).add(bookObj);
        }
    }

    // --- USER CURD OPERATIONS ---
    public void addUser(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty!");
        }

        User userToAdd = new User(userName); // New user instance

        if (this.isInUserMap(userToAdd)) { // checks if the userName already exists in userMap
            throw new IllegalArgumentException("User: " + userName + " is already registered!");
        }

        this.userMap.put(userToAdd, new ArrayList<Book>()); // New Users start with 0 books so no need to check for existence
    }

    // --- HELPER METHODS ---
    //      --- USERS ---
    private boolean isInUserMap(User userObj) { // checks if userObj.name is in userMap due to @Overrides in User Class
        return this.userMap.containsKey(userObj);
    }

    private User getUserByName(String name) {
        for (User key : this.userMap.keySet()) {
            if (key.getUserName().equals(name)){
                return key;
            } 
        }
        return null;
    }

    private boolean userInMapByName(String name) {
        for (User key : this.userMap.keySet()) {
            if (key.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //     --- BOOKS ---
    private boolean isInBookMap(String bookName) {
        return this.bookMap.containsKey(bookName);
    }

}
    
