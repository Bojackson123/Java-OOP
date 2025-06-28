package libraryManagementSystem;

public class Book {
    private static int nextId = 1;
    private int id;
    private String name;
    private String author;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "Book ID: " + this.id + ", Name: " + this.name + ", Author: " + this.author;  
    }

    public int getBookId() {
        return this.id;
    }

    public String getBookName() {
        return this.name;
    }

    public String getBookAuthor() {
        return this.author;
    }

}