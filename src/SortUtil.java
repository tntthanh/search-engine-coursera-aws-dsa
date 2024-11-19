
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        // TODO 5: Calculate the size of the list
        int size = books.size();

        // TODO 6: Implement nested loops for the sorting
        for (int i = 0; i < size - 1; i++) { // Outer loop for passes
            for (int j = 0; j < size - i - 1; j++) { // Inner loop for comparisons
                // TODO 7: Compare and swap adjacent elements
                if (comparator.compare(books.get(j), books.get(j + 1)) > 0) {
                    Collections.swap(books, j, j + 1); // Swap if the current book should come after the next
                }
            }
        }
    }

    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }

    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
