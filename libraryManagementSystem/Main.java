package libraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        LibManager manager = new LibManager();
        manager.addBook("Test", "Book");
        String res1 = manager.addUser("Rashid Al-Marri");
        System.out.println(res1);
        String res2 = manager.addUser("Rashid Al-Marri");
        System.out.println(res2);
        
    }
}