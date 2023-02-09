import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title, author;
    private int publicationYear;
    private double price;

    public Book(String title, String author, int publicationYear, double price) {
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        this.publicationYear = publicationYear;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + " " + author + " " + publicationYear + " " + price;
    }

    @Override
    public int compareTo(Book other) {
        if (this.publicationYear != other.publicationYear) {
            return Integer.compare(this.publicationYear, other.publicationYear);
        } else if (this.price != other.price) {
            return Double.compare(this.price, other.price);
        } else if (!this.author.equals(other.author)) {
            return this.author.compareTo(other.author);
        } else
            return this.title.compareTo(other.title);
    }
}


