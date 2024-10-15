package org.example.exercise01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title) {
        if (!books.contains(title)) {
            books.add(title);
            Collections.sort(books);
        }
    }

    public List<String> getBooks() {
        return new ArrayList<>(books);
    }

    public String getBookByPosition(int position) {
        if (position < 0 || position >= books.size()) {
            throw new IndexOutOfBoundsException("Position out of range");
        }
        return books.get(position);
    }

    public void addBookAtPosition(String title, int position) {
        if (!books.contains(title) && position >= 0 && position <= books.size()) {
            books.add(position, title);
            Collections.sort(books);
        }
    }

    public void removeBookByTitle(String title) {
        books.remove(title);
    }
}
