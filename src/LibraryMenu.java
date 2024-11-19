
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        logger.log("Program started and menu displayed.");
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books by Title");
            System.out.println("3. Sort Books by Author");
            System.out.println("4. Sort Books by Publication Year");
            System.out.println("5. Search for a Book by Keyword");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logger.log("User selected to view all books.");
                    System.out.println("\nAll Books:");
                    library.viewAllBooks();
                    break;

                case 2:
                    logger.log("User selected to sort books by title.");
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("\nBooks sorted by Title:");
                    library.viewAllBooks();
                    break;

                case 3:
                    logger.log("User selected to sort books by author.");
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("\nBooks sorted by Author:");
                    library.viewAllBooks();
                    break;

                case 4:
                    logger.log("User selected to sort books by publication year.");
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparingInt(Book::getPublicationYear));
                    System.out.println("\nBooks sorted by Publication Year:");
                    library.viewAllBooks();
                    break;

                case 5:
                    System.out.print("\nEnter a keyword to search (title, author, or year): ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        logger.log("User searched for a book. Found: " + foundBook);
                        System.out.println("\nBook found: " + foundBook);
                    } else {
                        logger.log("User searched for a book. No matches found for keyword: " + keyword);
                        System.out.println("\nBook not found.");
                    }
                    break;

                case 6:
                    logger.log("User exited the program.");
                    System.out.println("\nExiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    logger.log("User entered an invalid menu choice: " + choice);
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

}
