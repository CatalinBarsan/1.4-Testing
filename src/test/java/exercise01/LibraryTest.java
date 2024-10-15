package exercise01;

import org.example.exercise01.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    private void addBooks(String... titles) {
        for (String title : titles) {
            library.addBook(title);
        }
    }

    private void assertBooksContain(String[] expectedBooks) {
        List<String> books = library.getBooks();
        assertEquals(expectedBooks.length, books.size(), "The size of the list should match expected books count");

        for (String expectedBook : expectedBooks) {
            assertTrue(books.contains(expectedBook), "The list should contain '" + expectedBook + "'");
        }
    }

    @Test
    void testCreateLibrary() {
        assertNotNull(library.getBooks(), "The list of books should not be null");
    }

    @Test
    void testAddBooks() {
        addBooks("Book A", "Book B", "Book C");
        assertBooksContain(new String[]{"Book A", "Book B", "Book C"});
    }

    @Test
    void testGetBookByPosition() {
        addBooks("Book A", "Book B");
        String book = library.getBookByPosition(1);
        assertEquals("Book B", book, "The book at position 1 should be 'Book B'");
    }

    @Test
    void testAddBookAtPosition() {
        addBooks("Book A", "Book C");
        library.addBookAtPosition("Book B", 1);
        List<String> books = library.getBooks();
        assertEquals("Book B", books.get(1), "The book at position 1 should be 'Book B'");
    }

    @Test
    void testRemoveBookByTitle() {
        addBooks("Book A", "Book B");
        library.removeBookByTitle("Book A");
        assertFalse(library.getBooks().contains("Book A"), "The list should not contain 'Book A'");
    }

    @Test
    void testNoDuplicatesWhenAdding() {
        library.addBook("Book A");
        library.addBook("Book A"); // Try to add duplicate
        assertEquals(1, library.getBooks().size(), "The list should contain only one book 'Book A'");
    }

    @Test
    void testAlphabeticalOrder() {
        addBooks("Book C", "Book A", "Book B");
        List<String> books = library.getBooks();
        assertEquals("Book A", books.get(0), "The first book should be 'Book A'");
        assertEquals("Book B", books.get(1), "The second book should be 'Book B'");
        assertEquals("Book C", books.get(2), "The third book should be 'Book C'");
    }

    @Test
    void testRemoveDecreasesSize() {
        addBooks("Book A", "Book B");
        int sizeBefore = library.getBooks().size();
        library.removeBookByTitle("Book A");
        int sizeAfter = library.getBooks().size();
        assertEquals(sizeBefore - 1, sizeAfter, "The size should decrease by 1 when a book is removed");
    }
}


