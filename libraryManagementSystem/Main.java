package libraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        LibManager manager = new LibManager();
        manager.addBook("Test", "Book");

        try {
            manager.addUser("Rashid Al-Marri");
            System.out.println("User Added");

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());

        } catch (Exception e2) {
            System.out.println("Unexpected Error: " + e2.getMessage());
        }

        try {
            manager.addUser("Rashid Al-Marri");
            System.out.print("User Added");

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());

        } catch (Exception e2) {
            System.out.println("Unexpected Error: " + e2.getMessage());
        }

        try {
            manager.addUser("");
            System.out.print("User Added");

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());

        } catch (Exception e2) {
            System.out.println("Unexpected Error: " + e2.getMessage());
        }
    }
}