package group.learn.graphql.data;

import java.util.Arrays;
import java.util.List;

public record Book (String id, String name, int pageCount, String authorId){
    public static final List<Book> BOOKS = Arrays.asList(
            new Book("book-1", "Effective Java", 415, "author-1"),
            new Book("book-2", "The Pragmatic Programmer", 415, "author-2"),
            new Book("book-3", "The Clean Coder", 415, "author-3")
    );

    public static Book getById(String id){
        return BOOKS.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
