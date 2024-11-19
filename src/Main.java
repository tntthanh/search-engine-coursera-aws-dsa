
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();

        // TODO 23: Load the library or fallback to books.txt
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully from src/resources/data/library.ser");
        } else {
            System.out.println("Loading data from books.txt...");
            library.loadBooks("src/resources/data/books.txt");
        }

        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();

        // Save the library on exit
        serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
        System.out.println("Library saved successfully to src/resources/data/library.ser");
    }
}
