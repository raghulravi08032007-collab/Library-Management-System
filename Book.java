public class Book {
    int id;
    String title;
    String author;
    String status;

    public Book(int id, String title, String author, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public String toString() {
        return id + " | " + title + " | " + author + " | " + status;
    }
}
