
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // TODO 1: Parse each line to extract details
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int publicationYear = Integer.parseInt(parts[2].trim());

                    // TODO 2: Create a Book object
                    Book book = new Book(title, author, publicationYear);

                    // TODO 3: Add the Book object to the books list
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO 9: Ensure case-insensitivity
        keyword = keyword.toLowerCase();

        // TODO 10: Iterate over the books list
        for (Book book : books) {
            // TODO 11: Check conditions
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword) ||
                Integer.toString(book.getPublicationYear()).equals(keyword)) {
                return book; // Return the first matching book
            }
        }
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
